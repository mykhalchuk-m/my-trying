package com.mmm.spring.socsec.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.mmm.spring.socsec.entity.User;

@Configuration
@ComponentScan(basePackages = "com.mmm.spring.socsec", includeFilters = { @Filter(Configuration.class) })
public class MainConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://mysql-socsec.jelastic.dogado.eu/spring_soc_sec");
		dataSource.setUsername("root");
		dataSource.setPassword("YbkDvcCjeV");
		return dataSource;
	}
	
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() throws Exception {
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(buildHibernateProperties());
		sessionFactoryBean.setAnnotatedClasses(new Class[] { User.class });
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean.getObject();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() throws Exception {
		return new HibernateTransactionManager(sessionFactory());
	}

	/**
	 * Build a {@linkplain Properties} object to represent the Hibernate
	 * configuration.
	 * 
	 * @return the properties used to configure the Hibernate session factory
	 */
	private Properties buildHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.connection.charSet", "UTF-8");
		return props;
	}
}
