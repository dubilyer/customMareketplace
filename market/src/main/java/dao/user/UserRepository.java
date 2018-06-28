package dao.user;

import model.User;

public interface UserRepository {
    User getUserById(long id);
    void createUser(User user);
}
