package cat.itb.projecte1.apiusuaris.model.serveis;

import cat.itb.projecte1.apiusuaris.model.entitats.VideoGame;
import cat.itb.projecte1.apiusuaris.model.repositoris.VideogameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VideogamesService {
    private final VideogameRepo repo;

    public List<VideoGame> listVG() { return repo.findAll(); }

    public List<VideoGame> listVGByGenere(String genere) { return repo.findByGenere(genere); }

    public long countByGenere(String genere) { return repo.countByGenere(genere); }

    public List<VideoGame> findByMultiplayer(boolean mp) { return repo.findByMultiplayer(mp);}

    public VideoGame cVideogame(String id) { return repo.findById(id).orElse(null); }

    public VideoGame addVideogame(VideoGame it) { return repo.save(it); }

    public VideoGame modifyVideogame(VideoGame videogame) {
        VideoGame aux = null;
        if(repo.existsById(videogame.getIdVG())) aux = repo.save(videogame);
        return aux;
    }

    public VideoGame deleteVideogame(String id) {
        VideoGame res = repo.findById(id).orElse(null);
        if(res!=null) repo.deleteById(id);
        return res;
    }
}
