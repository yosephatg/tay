package tay.resource;

import io.dropwizard.hibernate.UnitOfWork;
import tay.core.TayCore;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by yoseph on 4/25/17.
 */

@Path(ResourceURL.USER)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final TayCore tayCore;

    public UserResource(TayCore tayCore) {
        this.tayCore = tayCore;
    }

//    Still need to implement the following:
//    add, update, changePassword, findAccountByCellNum, auth and ping

}
