package org.mind.training.data.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"org.mind.training.data.entity"}
)
public class MySQLConfiguration {
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setPackagesToScan("org.mind.training.data.entity");
//
//        JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(vendor);
//
//        Properties properties = new Properties();
//        properties.setProperty("javax.persistence.schema-generation.database.action", "none");
//        bean.setJpaProperties(properties);
//
//        return bean;
//    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
