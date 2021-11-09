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


    /*  exemple de control cors a nivell de mètode  */
    @CrossOrigin(origins="http://localhost:9001")
    @GetMapping("/usuaris")
    public List<Usuari> llistarUsuaris(@RequestParam (value="sou", required=false) String sou){
        if(sou==null){
            return serveiUsuaris.llistarUsuaris();
        }
        else return serveiUsuaris.llistatPerSouMenorA(Double.parseDouble(sou));
    }


    //requestparam are required by default
    //l'endpoint és únic, crea ambigüitat
//    @GetMapping("/usuaris")
//    public List<Usuari> llistarMenorsAUnSou(@RequestParam (value="sou") double sou){
//        return serveiUsuaris.llistatPerSouMenorA(sou);
//    }



    @GetMapping("/usuaris/{id}")
    public Usuari consultarUsuari(@PathVariable String id)
    {
        return serveiUsuaris.consultarUsuari(id);
    }

    @GetMapping("/usuaris/rol/{rol}")
    public List<Usuari> llistarUsuarisPerRol(@PathVariable String rol){
        return serveiUsuaris.llistarUsuarisPerRol(rol);
    }

    @GetMapping("/usuaris/comptar/{rol}")
    public long comptarPerRol(@PathVariable String rol){
        return serveiUsuaris.comptarPerRol(rol);
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
