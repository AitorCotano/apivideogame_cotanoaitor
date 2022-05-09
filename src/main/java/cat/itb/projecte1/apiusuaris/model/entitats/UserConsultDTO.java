package cat.itb.projecte1.apiusuaris.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserConsultDTO {
    private String username;
    private String avatar;
    private String rol;
}
