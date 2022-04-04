package cat.itb.projecte1.apiusuaris.controladors;

import cat.itb.projecte1.apiusuaris.model.entitats.VideoGame;
import cat.itb.projecte1.apiusuaris.model.serveis.VideogamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VGController {
    private final VideogamesService serveiVideojocs;

    @GetMapping("/videogames")
    public ResponseEntity<?> listVideogames(@RequestParam (value="genere", required=false) String genere) {
        List<VideoGame> videogames;

        if (genere == null) { videogames = serveiVideojocs.listVG(); }
        else { videogames = serveiVideojocs.listVGByGenere(genere); }
        if (videogames == null) { return ResponseEntity.notFound().build(); }
        else { return ResponseEntity.ok(videogames); }
    }

    @GetMapping("/videogames/{id}")
    public ResponseEntity<?> cVideogame(@PathVariable String id)
    {
        VideoGame videogame = serveiVideojocs.cVideogame(id);
        if(videogame == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videogame);
    }

    @GetMapping("/videogames/count/{genere}")
    public ResponseEntity<?> countByGenere(@PathVariable String genere){
        long count = serveiVideojocs.countByGenere(genere);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/videogames")
    public ResponseEntity<?> addVideogame(@RequestBody VideoGame newVG){
        VideoGame videogame = serveiVideojocs.addVideogame(newVG);
        return new ResponseEntity<VideoGame>(videogame, HttpStatus.CREATED);
    }

    @DeleteMapping("/videogames/{id}")
    public ResponseEntity<?> deleteVideogame(@PathVariable String id){
        VideoGame videogame = serveiVideojocs.deleteVideogame(id);
        if(videogame == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videogame);
    }

    @PutMapping("/videogames")
    public ResponseEntity<?> modifyVideogame(@RequestBody VideoGame nou){
        VideoGame videogame = serveiVideojocs.modifyVideogame(nou);
        if(videogame == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videogame);
    }


}
