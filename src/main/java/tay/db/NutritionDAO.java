package tay.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tay.api.Nutrition;

import javax.ws.rs.NotFoundException;
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
//        return (List<Nutrition>) currentSession().createQuery("From Nutrition");
        Query query = currentSession().createQuery("From Nutrition");
        List<Nutrition> results = query.list();
        return results;
    }

    public Nutrition findById(int id) {
        Nutrition nut = get(id);
        if (nut == null) {
            throw new NotFoundException();
        } else {
            return nut;
        }
        //return (Nutrition) currentSession().get(Nutrition.class, id);
    }

    public List<Nutrition> findByType(String type){
//        StringBuilder builder = new StringBuilder("%");
//        builder.append(type).append("%");
//        return list(
//                namedQuery("tay.core.Nutrition.findByType")
//                        .setParameter("type", builder.toString()));
        Query query = currentSession().createQuery("From Nutrition n where n.type like :n_type");
        query.setParameter("n_type", type);
        return query.list();
    }

    public Nutrition insert(Nutrition nutrition) {
        return persist(nutrition);
    }

    public void delete(Nutrition nutrition){
        currentSession().delete(nutrition);
    }
}
