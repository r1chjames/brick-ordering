package com.richjames.brickordering;

import com.richjames.brickordering.config.ApplicationConfiguration;
import com.richjames.brickordering.resources.CustomerResource;
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller;

@Slf4j
public class Application extends io.dropwizard.Application<ApplicationConfiguration> {

    private static Environment applicationEnvironment;

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.run(args);
    }

    public static void stop() throws Exception {
        applicationEnvironment.getApplicationContext().getServer().stop();
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {

        GuiceBundle<ApplicationConfiguration> guiceBundle = GuiceBundle.<ApplicationConfiguration>builder()
                .installers(ResourceInstaller.class)
                .extensions(CustomerResource.class)
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new TemplateConfigBundle());

    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) {
        applicationEnvironment = environment;
        environment.jersey().register(CustomerResource.class);
    }
}
