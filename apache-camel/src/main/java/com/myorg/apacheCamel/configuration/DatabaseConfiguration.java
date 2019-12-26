package com.myorg.apacheCamel.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
// @ComponentScan({ "com.myorg.apacheCamel" })
// @EnableJpaRepositories(basePackages = "com.myorg.apacheCamel.repository")
public class DatabaseConfiguration {

	public DatabaseConfiguration() {
		super();
	}

	@Autowired
	private Environment env;

	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(new String[] { "net.javaguides.springmvc.entity" });

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(additionalProperties());

		return entityManagerFactoryBean;
	}*/

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/apache_camel_db");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres@11");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	// Setting up the additional properties
	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("spring.jpa.properties.hibernate.default_schema",
				env.getProperty("spring.jpa.properties.hibernate.default_schema"));
		hibernateProperties.setProperty("spring.datasource.dbcp2.test-while-idle",
				env.getProperty("spring.datasource.dbcp2.test-while-idle"));
		hibernateProperties.setProperty("spring.datasource.dbcp2.validation-query",
				env.getProperty("spring.datasource.dbcp2.validation-query"));
		hibernateProperties.setProperty("spring.jpa.show-sql", env.getProperty("spring.jpa.show-sql"));
		hibernateProperties.setProperty("spring.jpa.hibernate.ddl-auto",
				env.getProperty("spring.jpa.hibernate.ddl-auto"));
		hibernateProperties.setProperty("spring.jpa.hibernate.naming.implicit-strategy",
				env.getProperty("spring.jpa.hibernate.naming.implicit-strategy"));
		hibernateProperties.setProperty("spring.jpa.hibernate.naming.physical-strategy",
				env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
		hibernateProperties.setProperty("spring.jpa.properties.hibernate.dialect",
				env.getProperty("spring.jpa.properties.hibernate.dialect"));
		hibernateProperties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation",
				env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
		return hibernateProperties;
	}
}
