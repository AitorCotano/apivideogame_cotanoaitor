package cat.itb.projecte1.apiusuaris.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class VideoGame {
    @Id
    private String idVG;
    private String title;
    private String genere;
    private double multiplayer;
}




