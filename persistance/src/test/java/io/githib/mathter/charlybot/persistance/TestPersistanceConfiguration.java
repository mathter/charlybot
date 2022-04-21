package io.githib.mathter.charlybot.persistance;

import io.githib.mathter.charlybot.PersistanceConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import({PersistanceConfiguration.class, LiquibaseAutoConfiguration.class})
public class TestPersistanceConfiguration {
}
