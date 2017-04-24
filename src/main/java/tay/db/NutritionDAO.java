package tay.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import tay.api.Nutrition;

import java.util.List;
import java.util.Optional;

/**
 * Created by yoseph on 4/24/17.
 */
public class NutritionDAO extends AbstractDAO<Nutrition> {

    public NutritionDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Nutrition> findAll(){
        return list(namedQuery("tay.core.Nutrition.findAll"));
    }

    public List<Nutrition> findByType(String type){
        StringBuilder builder = new StringBuilder("%");
        builder.append(type).append("%");
        return list(
                namedQuery("tay.core.Nutrition.findByType")
                        .setParameter("type", builder.toString()));
    }
}
