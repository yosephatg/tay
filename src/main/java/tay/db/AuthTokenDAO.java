package tay.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import tay.api.AuthToken;
import tay.api.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by yoseph on 4/25/17.
 */
public class AuthTokenDAO extends AbstractDAO<AuthToken>{

    private final SessionFactory sessionFactory;

    public AuthTokenDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public AuthToken add(User user) {
        AuthToken authToken = new AuthToken();
        authToken.setUser(user);
        authToken.setToken(newToken());
        return persist(authToken);
    }

    public Optional<AuthToken> find(String token) {
        //look for token, return it
    }

    public List<AuthToken> findByUser(User user) {
        Criteria criteria = currentSession().createCriteria(AuthToken.class);
        criteria.add(Restrictions.eq("user", user));
        return list(criteria);
    }

    // make sure we search for this correctly
    public List<AuthToken> FindByCellNumber(String cell) {
        Criteria criteria = currentSession().createCriteria(AuthToken.class);
        criteria.add(Restrictions.eq("cellNumber", cell));
        return list(criteria);
    }

    private String newToken(){
        return UUID.randomUUID().toString();
    }
}
