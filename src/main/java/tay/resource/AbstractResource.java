package tay.resource;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by yoseph on 4/25/17.
 */
abstract class AbstractResource {

    public abstract String getPath();

    public Response ok(Object object) {
        return Response.ok(object).build();
    }

    public Response created(Object object, Object id) {
        try {
            return Response.created(new URI(getPath() + "/" + String.valueOf(id))).entity(object).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
