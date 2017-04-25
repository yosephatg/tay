package tay.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tay.api.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by yoseph on 4/24/17.
 */
public class UserDAO extends AbstractDAO<User>{

    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User findById(Long userId) {
        User user = get(userId);
    }
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return (Optional<User>) currentSession()
                .createQuery("select u from User u where u.username = :username and u.password = :password")
                .setParameter("u.username", username)
                .setParameter("u.password", password)
                .uniqueResult();
    }
//    public com.google.common.base.Optional<User> findByUsernameAndPassword(String username, String password) {
//        Query query = currentSession().createQuery("select u from User u where u.username = :username and u.password = :password");
//        query.setParameter("u.username", username);
//        query.setParameter("u.password", password);
//        return Optional
//        return com.google.common.base.Optional.fromNullable(uniqueResult(query));
//    }
}
