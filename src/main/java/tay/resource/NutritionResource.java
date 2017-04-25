package tay.resource;

import tay.api.Nutrition;
import tay.core.NutritionRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;
/**
 * Created by yoseph on 4/22/17.
 */

@Path("nutrition")
@Produces(MediaType.APPLICATION_JSON)
public class NutritionResource {

    private NutritionRepository repo;
    public NutritionResource(NutritionRepository repo) {
        this.repo = repo;
    }

    @GET
    public List<Nutrition> allNutrition() throws IOException {
        return repo.findAll();
    }
}
