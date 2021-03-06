package dao.user;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        getSession().persist(user);
    }
}
