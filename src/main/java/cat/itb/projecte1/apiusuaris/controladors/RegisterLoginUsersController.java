package cat.itb.projecte1.apiusuaris.controladors;

import cat.itb.projecte1.apiusuaris.model.entitats.User;
import cat.itb.projecte1.apiusuaris.model.entitats.UserConsultDTO;
import cat.itb.projecte1.apiusuaris.model.serveis.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegisterLoginUsersController {
    private final UserService userService;

    @GetMapping("/me")
    public UserConsultDTO consultaQuiEts(@AuthenticationPrincipal User usu) { return new UserConsultDTO(usu.getUsername(), usu.getAvatar(), usu.getRol()); }

    /*
    {
    "username":"Aitor",
    "password":"1234",
    "avatar":"http://imatge.com"
    }
    */

    @PostMapping("/usuaris")
    public ResponseEntity<?> newUser(@RequestBody User newUsu) {
        try {
            User res = userService.createNewUser(newUsu);
            UserConsultDTO usu = new UserConsultDTO(res.getUsername(), res.getAvatar(), res.getRol());
            return new ResponseEntity<UserConsultDTO>(usu, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage()); }
    }

    @GetMapping("/usuaris")
    public ResponseEntity<?> listUsersDTO() {
        List<User> res = userService.listUsers();
        List<UserConsultDTO> aux = new ArrayList();
        for (User usu : res) { aux.add(new UserConsultDTO(usu.getUsername(), usu.getAvatar(), usu.getRol())); }
        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(aux);
    }
}
