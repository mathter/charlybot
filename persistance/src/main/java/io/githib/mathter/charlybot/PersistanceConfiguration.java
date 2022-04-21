package io.githib.mathter.charlybot;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("io.githib.mathter.charlybot.persistance")
public class PersistanceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public HikariDataSource mainDataSource() {
        return mainDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties("spring.jpa.properties")
    public Properties hibernateJpaProperties() {
        return new Properties();
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory() {
        final LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setDataSource(mainDataSource());
        sessionFactoryBean.setHibernateProperties(hibernateJpaProperties());
        sessionFactoryBean.setPackagesToScan("io.githib.mathter.charlybot.persistance");

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setDataSource(mainDataSource());
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
