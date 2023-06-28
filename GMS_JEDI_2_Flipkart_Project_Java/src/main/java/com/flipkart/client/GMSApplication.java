package com.flipkart.client;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.flipkart.service.*;

public class GMSApplication extends Application<GMSConfiguration> {
    public static void main(final String[] args) throws Exception{
        new GMSApplication().run(args);
    }


    @Override
    public void run(GMSConfiguration gmsconfiguration, Environment environment) throws Exception {
        environment.jersey().register(BookingSlotService.class);
        environment.jersey().register(AdminGMSService.class);
        environment.jersey().register(CustomerService.class);
        environment.jersey().register(GymOwnerService.class);
        environment.jersey().register(UserService.class);




    }
}
