package cat.itb.projecte1.apiusuaris.model.serveis;

import cat.itb.projecte1.apiusuaris.model.entitats.User;
import cat.itb.projecte1.apiusuaris.model.repositoris.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo repoUser;

    private final PasswordEncoder xifrat;

    public User consultByUsername(String username) {
        return repoUser.findByUsername(username).orElse(null);
    }

    public User createNewUser(User newUser) {
        newUser.setPassword(xifrat.encode(newUser.getPassword()));
        repoUser.save(newUser);
        return newUser;
    }

    public List<User> listUsers(){
        return repoUser.findAll();
    }
}
