package com.richjames.brickordering;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.richjames.brickordering.config.ApplicationConfiguration;
import com.richjames.brickordering.config.JdbiProviderModule;
import com.richjames.brickordering.exception.ApplicationExceptionMapper;
import com.richjames.brickordering.resources.CustomerResource;
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller;

@Slf4j
public class Application extends io.dropwizard.Application<ApplicationConfiguration> {

    @Getter
    private static Environment applicationEnvironment;
    @Getter
    private static ApplicationConfiguration configuration;

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
                .modules(new JdbiProviderModule())
                .extensions(CustomerResource.class)
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new TemplateConfigBundle());

    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) {
        applicationEnvironment = environment;
        configuration = applicationConfiguration;
        environment.jersey().register(CustomerResource.class);
        environment.jersey().register(new ApplicationExceptionMapper());

        environment.getObjectMapper().registerModule(new JavaTimeModule());
        environment.getObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        environment.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
