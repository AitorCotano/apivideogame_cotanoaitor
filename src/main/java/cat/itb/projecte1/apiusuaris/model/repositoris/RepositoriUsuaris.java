package cat.itb.projecte1.apiusuaris.model.repositoris;

import cat.itb.projecte1.apiusuaris.model.entitats.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriUsuaris extends JpaRepository<Usuari,String> {
}
