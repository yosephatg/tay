package tay.resource;

import com.sun.org.apache.regexp.internal.RE;
import io.dropwizard.hibernate.UnitOfWork;
import tay.api.User;
import tay.core.TayCore;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Optional;

import static javax.ws.rs.core.Response.created;

/**
 * Created by yoseph on 4/25/17.
 */

@Path(ResourceURL.USER)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource extends AbstractResource{

    private final TayCore tayCore;

    public UserResource(TayCore tayCore) {
        this.tayCore = tayCore;
    }

    @Override
    public String getPath() {
        return ResourceURL.USER;
    }

    //    Still need to implement the following:
//    add, update, changePassword, findAccountByCellNum, auth and ping
    @POST
    @UnitOfWork
    public Response add(@Valid User user) {
        User user1 = tayCore.addUser(user);
        return created(user1, user1.getId());
    }

    @POST
    @UnitOfWork
    @Path("/login")
    public Response login(@Valid User user) {
        Optional<User> user1 = tayCore.login(user);
        if (user1.isPresent()) {
            return ok(user1.get());
        } else {
            return unauthorized();
        }
    }
}
