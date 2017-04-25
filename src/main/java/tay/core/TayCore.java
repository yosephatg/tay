package tay.core;

import org.hibernate.SessionFactory;
import tay.api.Nutrition;
import tay.api.User;
import tay.db.NutritionDAO;
import tay.db.UserDAO;

import java.util.Optional;

/**
 * Created by yoseph on 4/25/17.
 */
public class TayCore {

    private final SessionFactory sessionFactory;
    private final UserDAO userDAO;
    private final NutritionDAO nutritionDAO;

    public TayCore(SessionFactory sessionFactory, UserDAO userDAO, NutritionDAO nutritionDAO) {
        this.sessionFactory = sessionFactory;
        this.userDAO = userDAO;
        this.nutritionDAO = nutritionDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // USER

    public User addUser(???) {
        // get info from passed parameter
        // call userDao.add
    }

    public User update(???) {
        // get info from passed parameter
        // call userDao.update
    }

    public void changePassword(???) {
        // get info from passed parameter
        // call userDao.update
    }

    public Optional<User> findUserByToken(String token) {
        // use token parameter, call authTokenDao.find, return user
    }

    public Optional<User> login(???) {
        // passed in parameter should have username, password, token
        // confirm they're accurate and return user
    }

}
