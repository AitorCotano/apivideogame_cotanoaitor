package cat.itb.projecte1.apiusuaris.controladors;

import cat.itb.projecte1.apiusuaris.model.entitats.Usuari;
import cat.itb.projecte1.apiusuaris.model.serveis.ServeiUsuaris;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExempleControladorResponseEntity {

private final ServeiUsuaris serveiUsuaris;

    //proves amb un altre endpoint per consultar usuari
    //si l'id d'usuari no existeix es retorna 404 Not Found
    @GetMapping("/user/{id}")
    public ResponseEntity<?> consultarUsuari(@PathVariable String id) {
        Usuari res = serveiUsuaris.consultarUsuari(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //proves amb un altre endpoint per crear un usuari
    //si es pot crear es retorna CREATED
    @PostMapping("/user")
    public ResponseEntity<?> crearTodoItem(@RequestBody Usuari nou){
        Usuari res=serveiUsuaris.afegirUsuari(nou);
        return new ResponseEntity<Usuari>(res, HttpStatus.CREATED);
    }

    //TODO

}
