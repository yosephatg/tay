package tay;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class tayApplication extends Application<tayConfiguration> {

    public static void main(final String[] args) throws Exception {
        new tayApplication().run(args);
    }

    @Override
    public String getName() {
        return "tay";
    }

    @Override
    public void initialize(final Bootstrap<tayConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final tayConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
