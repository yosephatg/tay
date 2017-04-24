package tay.resource;

import io.dropwizard.hibernate.UnitOfWork;
import tay.api.Nutrition;
import tay.core.NutritionRepository;
import tay.db.NutritionDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;
/**
 * Created by yoseph on 4/22/17.
 */

@Path("nutrition")
@Produces(MediaType.APPLICATION_JSON)
public class NutritionResource {

//    private NutritionRepository repo;
//    public NutritionResource(NutritionRepository repo) {
//        this.repo = repo;
//    }

    private NutritionDAO nutritionDAO;

    public NutritionResource(NutritionDAO nutritionDAO) {
        this.nutritionDAO = nutritionDAO;
    }

    @GET
    @UnitOfWork
    public List<Nutrition> allNutrition() throws IOException {
        return nutritionDAO.findAll();
    }

    @GET
    @UnitOfWork
    public List<Nutrition> findByType(@QueryParam("type") Optional<String> type){
        return nutritionDAO.findByType(type.get());
    }
}
