package tay.core;

import org.hibernate.SessionFactory;
import tay.api.AuthToken;
import tay.api.Nutrition;
import tay.api.User;
import tay.db.AuthTokenDAO;
import tay.db.NutritionDAO;
import tay.db.UserDAO;

import java.util.List;
import java.util.Optional;

/**
 * Created by yoseph on 4/25/17.
 */
public class TayCore {

    private final SessionFactory sessionFactory;
    private final UserDAO userDAO;
    private final NutritionDAO nutritionDAO;
    private final AuthTokenDAO authTokenDAO;

    public TayCore(SessionFactory sessionFactory, UserDAO userDAO, NutritionDAO nutritionDAO, AuthTokenDAO authTokenDAO) {
        this.sessionFactory = sessionFactory;
        this.userDAO = userDAO;
        this.nutritionDAO = nutritionDAO;
        this.authTokenDAO = authTokenDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // USER

    public User addUser(User user) {
        // get info from passed parameter
        // call userDao.add
        //Optional<User> optional = userDAO.findByUsername(user.getUsername());
        //if exists, throw exception
        User user1 = userDAO.add(user);
        return user1;
    }

    //public User update(???) {
        // get info from passed parameter
        // call userDao.update
    //}

    //public void changePassword(???) {
        // get info from passed parameter
        // call userDao.update
    //}

    //public Optional<User> findUserByToken(String token) {
        // use token parameter, call authTokenDao.find, return user
    //}

    public Optional<User> login(User user) {
//         passed in parameter should have username, password, token
//         confirm they're accurate and return user
        Optional<User> optUser = userDAO.findByUsername(user.getUsername());
        if(optUser.isPresent()) {
            User user1 = optUser.get();
            if (user.getPassword().matches(user1.getPassword())) {
                List<AuthToken> tokens = authTokenDAO.findByUser(user1);
                if (tokens.isEmpty()) {
                    AuthToken token = authTokenDAO.add(optUser.get());
                    optUser.get().setToken(token.getToken());
                    return optUser;
                } else {
                    optUser.get().setToken(tokens.get(0).getToken());
                    return optUser;
                }
            }
        }
        return Optional.empty();
    }


    // Nutrition

    //public List<Nutrition> findByUser(User user){
        // call the nutritiondao.find
    //}
}
