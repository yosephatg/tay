package tay.resource;

import tay.api.Event;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by yoseph on 4/22/17.
 */

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    @GET
    public List<Event> allEvents() {
        Event e = new Event();
        e.setDate(new Date());
        e.setName("Bday");
        e.setId(1L);
        e.setDescription("Please be on time");
        e.setLocation("40 north 4th street");

        return Collections.singletonList(e);
    }
}
