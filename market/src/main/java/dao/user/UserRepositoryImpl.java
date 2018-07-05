package dao.user;

import model.Authority;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository("userRepository")
@Transactional
@ComponentScan("model")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User getUserById(long id) {
        return getSession().get(User.class, id);
    }

    @Override
    public void createUser(User user) {
        Set<Authority> authorities = new HashSet<>();
        user.getAuthorities()
                .forEach(authority -> authorities.add(getAuthorityByName(authority.getRole())));
        user.setAuthorities(authorities);
        getSession().save(user);
    }

    @Override
    public UserDetails getUserByUsername(String username) {
        return (UserDetails) getSession()
                .getNamedQuery("GET_USER_BY_USERNAME")
                .setParameter("username", username)
                .setMaxResults(1)
                .list()
                .get(0);
    }

    @Override
    public void addRole(long id, String role) {
        User user = getUserById(id);
        Authority authority = getAuthorityByName(role);
        getSession().saveOrUpdate(authority);
        user.getAuthorities().add(authority);
        getSession().saveOrUpdate(user);
    }

    private Authority getAuthorityByName(String role) {
        try{
            return Optional.ofNullable((Authority) getSession()
                    .createNamedQuery("GET_AUTHORITY_BY_NAME")
                    .setParameter("role", role)
                    .list()
                    .get(0)).orElse(Authority.builder().role(role).build());
        } catch (IndexOutOfBoundsException e){
            return Authority.builder().role(role).build();
        }
    }
}
