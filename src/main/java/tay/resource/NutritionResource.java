package tay.resource;

import io.dropwizard.hibernate.UnitOfWork;
import tay.api.Nutrition;
import tay.db.NutritionDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;
/**
 * Created by yoseph on 4/22/17.
 */

@Path("nutrition")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NutritionResource {

    private NutritionDAO nutritionDAO;

    public NutritionResource(NutritionDAO nutritionDAO) {
        this.nutritionDAO = nutritionDAO;
    }

    @GET
    @UnitOfWork
    public List<Nutrition> getAll(@QueryParam("type") Optional<String> type) throws IOException {
        if (type.isPresent()) {
            return nutritionDAO.findByType(type.get());
        } else {
            return nutritionDAO.findAll();
        }
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public Nutrition getById(@PathParam("id") Integer id) {
        return nutritionDAO.findById(id);
    }

    @POST
    @UnitOfWork
    public Nutrition add(@Valid Nutrition nutrition){
        Nutrition nutrition1 = nutritionDAO.insert(nutrition);
        return nutrition1;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") Integer id){
        nutritionDAO.delete(nutritionDAO.findById(id));
    }

}
