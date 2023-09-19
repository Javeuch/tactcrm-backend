package com.wetic.tactcrm.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.concurrent.Executor;


public class LiquibaseConfiguration {


    private final Environment env;
    private final YAMLConfig yamlConfig;
    public LiquibaseConfiguration(Environment env, YAMLConfig yamlConfig) {
        this.env = env;
        this.yamlConfig = yamlConfig;
    }

    @Bean
    public SpringLiquibase liquibase(@Qualifier("taskExecutor") Executor executor,
                                     DataSource dataSource, LiquibaseProperties liquibaseProperties) {

        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        liquibase.setChangeLogParameters(liquibaseProperties.getParameters());

        if(yamlConfig.getName() == "dev"){

            liquibase.setShouldRun(false);
        }else{
            liquibase.setShouldRun(liquibaseProperties.isEnabled());
        }
        return liquibase;
    }
}
