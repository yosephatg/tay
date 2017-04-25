package tay;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import tay.api.Nutrition;
import tay.api.User;
import tay.auth.DefaultAuth;
import tay.auth.TokenAuth;
import tay.core.TayCore;
import tay.db.NutritionDAO;
import tay.db.UserDAO;
import tay.resource.EventResource;
import tay.resource.NutritionResource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tayApplication extends Application<tayConfiguration> {

    private final HibernateBundle<tayConfiguration> hibernateBundle = new HibernateBundle<tayConfiguration>(Nutrition.class){
        @Override
        public DataSourceFactory getDataSourceFactory(tayConfiguration tayConfiguration) {
            return tayConfiguration.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {
        new tayApplication().run(args);
    }

    @Override
    public String getName() {
        return "tay";
    }

    @Override
    public void initialize(final Bootstrap<tayConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final tayConfiguration configuration,
                    final Environment environment) {

        // DAO
        final NutritionDAO nutritionDAO = new NutritionDAO(hibernateBundle.getSessionFactory());
        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());

        // Core
        final TayCore tayCore = new TayCore(hibernateBundle.getSessionFactory(), userDAO, nutritionDAO);

        // Resource
        NutritionResource nutritionResource = new NutritionResource(nutritionDAO);
        environment.jersey().register(nutritionResource);
        EventResource eventResource = new EventResource();
        environment.jersey().register(eventResource);

        // Auth. Gotta make sure i'm using the 2nd call correctly
        final OAuthCredentialAuthFilter<User> authFilter = new
                OAuthCredentialAuthFilter.Builder<User>()
                    .setAuthenticator(new TokenAuth(tayCore))
                    .setPrefix("Bearer")
                    .setAuthorizer(new DefaultAuth())
                    . buildAuthFilter();
        environment.jersey().register(new AuthDynamicFeature(authFilter));
        environment.jersey().register(new AuthValueFactoryProvider.Binder(User.class));

        // Misc, figure out where these go!
        DateFormat testDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(testDateFormat);


    }

}
