package dao.user;

import model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    User getUserById(long id);
    void createUser(User user);
    UserDetails getUserByUsername(String username);
}
