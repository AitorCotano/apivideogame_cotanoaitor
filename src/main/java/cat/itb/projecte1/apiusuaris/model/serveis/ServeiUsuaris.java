package cat.itb.projecte1.apiusuaris.model.serveis;

import cat.itb.projecte1.apiusuaris.model.entitats.Usuari;
import cat.itb.projecte1.apiusuaris.model.repositoris.RepositoriUsuaris;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ServeiUsuaris {
    private final RepositoriUsuaris repoUsuaris;

    //llistar tots els ítems
    public List<Usuari> llistarUsuaris(){

        return repoUsuaris.findAll();
    }


    public List<Usuari> llistarUsuarisPerRol(String rol){
        return repoUsuaris.findByRol(rol);
    }

    public long comptarPerRol(String rol){
        return repoUsuaris.countByRol(rol);
    }

    public List<Usuari> llistatPerSouMenorA(double sou){
        return repoUsuaris.findBySouLessThan(sou);
    }

    //consultar ítem per id
    public Usuari consultarUsuari(String id){
        return repoUsuaris.findById(id).orElse(null);
    }

    //afegir ítem
    public Usuari afegirUsuari(Usuari it){
       return repoUsuaris.save(it);
    }

    //modificar sencer, si existeix el canvia, sino retorna null
    public Usuari modificarUsuari(Usuari usu){
        Usuari aux=null;
        if(repoUsuaris.existsById(usu.getIdUsuari())) aux=repoUsuaris.save(usu);
        return aux;
    }

    //eliminar ítem per id
    //si no existeix id retorna null
    public Usuari eliminarUsuari(String id){
        Usuari res=repoUsuaris.findById(id).orElse(null);
        if(res!=null) repoUsuaris.deleteById(id);
        return res;
    }

}
