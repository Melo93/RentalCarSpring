package com.si2001.rentalcarspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;


@Configuration
@EnableTransactionManagement
@ComponentScan({"com.si2001.rentalcarspring.config"})
@PropertySource("classpath:application.properties")
@EnableJpaRepositories({"com.si2001.rentalcarspring.dao"})
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(this.jpaVendorAdapter());
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.si2001.rentalcarspring.entities");
        factory.setJpaProperties(this.hibernateProperties());
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);

        return factory;

    }

    @Bean
    public Properties hibernateProperties() {
        Properties jpaProperties = new Properties();

        jpaProperties.put("javax.persitence.schema-generation.database.action", "none");
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

        jpaProperties.put(C3P0_MIN_SIZE, env.getRequiredProperty("hibernate.c3p0.min_size"));
        jpaProperties.put(C3P0_MAX_SIZE, env.getRequiredProperty("hibernate.c3p0.max_size"));
        jpaProperties.put(C3P0_ACQUIRE_INCREMENT, env.getRequiredProperty("hibernate.c3p0.acquire_increment"));
        jpaProperties.put(C3P0_TIMEOUT, env.getRequiredProperty("hibernate.c3p0.timeout"));
        jpaProperties.put(C3P0_MAX_STATEMENTS, env.getRequiredProperty("hibernate.c3p0.max_statements"));

        return jpaProperties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));

        return hibernateJpaVendorAdapter;

    }

    @Bean
    public JpaTransactionManager transactionManager(){

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
