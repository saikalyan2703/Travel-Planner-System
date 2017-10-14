package com.spring;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class JpaConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean createEmf() {
		
		//SImilar to Emf in persisentce api
		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		System.out.println("akjscn");
		emf.setPackagesToScan("com.spring.RestApiEntity");
		emf.setDataSource(getDatasource());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.user", "root"));
		ds.setPassword(env.getProperty("db.password", ""));
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txMng(EntityManagerFactory emf) {
		JpaTransactionManager txMng= new JpaTransactionManager(emf);
			return txMng;
	}
	//JPA properities Eclipse link 
	private Properties jpaProperties() {
		
		Properties props= new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show.sql"));
		props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format.sql"));
		return props;
			}
}
