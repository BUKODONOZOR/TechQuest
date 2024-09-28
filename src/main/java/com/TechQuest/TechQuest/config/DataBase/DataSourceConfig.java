package com.TechQuest.TechQuest.config.DataBase;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("mysqlProperties")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSourceProperties getMySqlProperties() {
        return new DataSourceProperties();
    }

    @Bean("mysqlDatasource")
    public DataSource getMysqlDatasource() {
        return getMySqlProperties().initializeDataSourceBuilder().build();
    }
}
