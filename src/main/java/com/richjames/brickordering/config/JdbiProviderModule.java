package com.richjames.brickordering.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.richjames.brickordering.dao.OrderHeaderDao;
import com.richjames.brickordering.dao.OrderLineDao;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class JdbiProviderModule extends AbstractModule {

    private Jdbi jdbi;

    @Provides
    public Jdbi prepareJdbi(Environment environment, ApplicationConfiguration configuration) {
        if (jdbi == null) {
            final JdbiFactory factory = new JdbiFactory();
            jdbi = factory.build(environment, configuration.getDatabase(), "postgresql");
        }
        return jdbi;
    }

    @Override
    protected void configure() {
    }

    @Provides
    public OrderHeaderDao orderHeaderDao(Jdbi dbi) {
        return jdbi.onDemand(OrderHeaderDao.class);
    }


    @Provides
    public OrderLineDao orderLineDao(Jdbi dbi) {
        return jdbi.onDemand(OrderLineDao.class);
    }
}
