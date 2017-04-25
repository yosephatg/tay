package tay.auth;

import io.dropwizard.auth.Authorizer;
import tay.api.User;

/**
 * Created by yoseph on 4/25/17.
 */
public class DefaultAuth implements Authorizer<User> {

    @Override
    public boolean authorize(User user, String s) {
        return true;
    }
}
