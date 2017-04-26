package tay.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import tay.api.User;
import tay.core.TayCore;

import java.util.Optional;

/**
 * Created by yoseph on 4/25/17.
 */
public class TokenAuth implements Authenticator<String, User> {
    private final TayCore tayCore;

    public TokenAuth(TayCore tayCore) {
        this.tayCore = tayCore;
    }


    @Override
    public Optional<User> authenticate(String token) throws AuthenticationException {
//        java.util.Optional<User> possibleUser = tayCore.findUserByToken(token);
//        if (possibleUser.isPresent()) {
//            return Optional.of(possibleUser.get());
//        } else {
//            return Optional.empty();
//        }


        //delete this, using it to compile
        return Optional.empty();
    }
}
