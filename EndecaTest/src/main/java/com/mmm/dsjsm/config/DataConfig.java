package com.mmm.dsjsm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.mmm.dsjsm.entity.Group;
import com.mmm.dsjsm.entity.Student;
import com.mmm.dsjsm.entity.Subject;
import com.mmm.dsjsm.entity.Teacher;

@Configuration
@ComponentScan(basePackages = "com.mmm.dsjsm", includeFilters = { @Filter(Configuration.class) })
public class DataConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/endeca_db");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() throws Exception {
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(buildHibernateProperties());
		sessionFactoryBean.setAnnotatedClasses(new Class[] { Student.class,
				Subject.class, Teacher.class, Group.class });
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
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.connection.charSet", "UTF-8");
		props.put("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");
		return props;
	}
}
