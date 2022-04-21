package io.githib.mathter.charlybot;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("local-dev")
public class LocalDevConfiguration {
    @Autowired
    private DataSource dataSource;

    @Value("${spring.liquibase.change-log}")
    private String defaultLiquibaseChangelog;

    @Bean
    public SpringLiquibase liquibase() {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(defaultLiquibaseChangelog);

        return liquibase;
    }
}
