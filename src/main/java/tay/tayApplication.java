package tay;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import tay.resource.EventResource;
import tay.resource.MessageReceiveResource;
import tay.resource.MessageSendResource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        DateFormat testDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(testDateFormat);


        EventResource eventResource = new EventResource();
        environment.jersey().register(eventResource);
        
        MessageSendResource messagesend = new MessageSendResource();
        environment.jersey().register(messagesend);
        
        MessageReceiveResource messageReceive = new MessageReceiveResource();
        environment.jersey().register(messageReceive);
    }

}
