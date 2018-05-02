package com.richjames.brickordering.config;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationConfiguration extends Configuration {

    private DataSourceFactory database = new DataSourceFactory();

}
