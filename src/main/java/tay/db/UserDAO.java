package tay.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import tay.api.User;

import javax.ws.rs.NotFoundException;
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
        if (user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    public User add(???){
        // from parameter, extract username and password and persist
    }

    public void update(User user) {
        persist(user);
    }

    public Optional<User>findByUsername(String username) {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username).ignoreCase());
        List<User> users = list(criteria);
        if (users.size() == 1) {
            return Optional.of(users.get(0));
        } else {
            return Optional.empty();
        }
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
