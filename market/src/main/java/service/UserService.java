package service;

import dao.user.UserRepository;
import dto.UserDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
@ComponentScan("dao")
public class UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UserDto getUserById(long id) {
        return toDto(userRepository.getUserById(id));
    }


    public void create(UserDto user) {
        userRepository.createUser(toModel(user));
    }

    private User toModel(UserDto user) {
        return User
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .build();
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getPassword());
    }

    public void addRole(long id, String role) {
        userRepository.addRole(id, role);
    }
}
