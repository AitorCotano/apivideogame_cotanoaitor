package cat.itb.projecte1.apiusuaris.controladors;

import cat.itb.projecte1.apiusuaris.model.entitats.Usuari;
import cat.itb.projecte1.apiusuaris.model.serveis.ServeiUsuaris;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorUsuaris {
    private final ServeiUsuaris serveiUsuaris;

    //TODO
    //Amb l'exemple de l'altre controlador cal canviar el retorn d'aquests endpoints
    //pel seu corresponent retornant un ResponseEntity


    @GetMapping("/usuaris")
    public List<Usuari> llistarUsuaris(){
        return serveiUsuaris.llistarUsuaris();
    }

    @GetMapping("/usuaris/{id}")
    public Usuari consultarUsuari(@PathVariable String id)
    {
        return serveiUsuaris.consultarUsuari(id);
    }

    @PostMapping("/usuaris")
    public Usuari crearUsuari(@RequestBody Usuari nou){
        return serveiUsuaris.afegirUsuari(nou);
    }

    @DeleteMapping("/usuaris/{id}")
    public Usuari eliminarUsuari(@PathVariable String id){
        return serveiUsuaris.eliminarUsuari(id);
    }

    //per modificar un usuari existent
    @PutMapping("/usuaris")
    public Usuari modificarUsuari(@RequestBody Usuari mod){
       return serveiUsuaris.modificarUsuari(mod);
    }

}
