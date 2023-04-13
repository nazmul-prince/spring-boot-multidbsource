package com.db.multiplesources.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.db.multiplesources.db2source.repositories", 
		entityManagerFactoryRef = "db2EntityManagerFactory", 
		transactionManagerRef = "db2TransactionManager")
public class Db2SourceConfiguration {
	
	@Autowired
	private DataSource dataSource;

    @Bean
//    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties db2DataSourceProperties() {
        return new DataSourceProperties();
    }
    
//    @Bean
//    @Primary
//    @ConfigurationProperties("spring.datasource.configuration")
//    public DataSource db2DataSource() {
//        return db2DataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
    
//    @Primary
    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource).packages("com.db.multiplesources.db2source.entity").build();
    }
    
//    @Primary
    @Bean
    public PlatformTransactionManager db2TransactionManager(
            final @Qualifier("db2EntityManagerFactory") LocalContainerEntityManagerFactoryBean db2EntityManagerFactory) {
        return new JpaTransactionManager(db2EntityManagerFactory.getObject());
    }
    
}