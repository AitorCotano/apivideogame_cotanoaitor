package cat.itb.projecte1.apiusuaris.model.repositoris;

import cat.itb.projecte1.apiusuaris.model.entitats.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideogameRepo extends JpaRepository<VideoGame,String> {
    List<VideoGame> findByGenere(String g);
    long countByGenere(String g);
    List<VideoGame> findByMultiplayer(boolean mp);
}
