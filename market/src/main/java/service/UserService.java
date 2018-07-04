package service;

import dao.user.UserRepository;
import dto.UserDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
@ComponentScan("dao")
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public UserDto getUserById(long id) {
        return toDto(userRepository.getUserById(id));
    }


    public void create(UserDto user) {
        userRepository.createUser(toModel(user));
    }

    private User toModel(UserDto user) {
        return new User(user.getUsername());
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }
}
