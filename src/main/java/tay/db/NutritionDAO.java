package tay.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import tay.api.Nutrition;

import java.util.List;

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
}
