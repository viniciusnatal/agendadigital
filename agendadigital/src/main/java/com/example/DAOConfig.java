package com.example;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DAOConfig {
	// Manter o contato com o hibernate e disparar a conexao com BD
// Scan na pasta com o setPackage
	// HibernateProperties -> configuração para passar para o Hibernate
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.example");
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

// Chamada DataSource / Comunicacao com o banco de dados
	// nome/url/username/senha do BD
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/xe");
		dataSource.setUsername("system");
		dataSource.setPassword("IFTM1234#");

		return dataSource;
	}

//Gerenciador de transacao da plataforma ~~> Implementa Commit, transaction 
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	// Propriedades do Hibernate - Dialeto que ira utilizar
//Quando subir a aplicacao, o hibernate vai subir automaticamente os dados no DB [<hbm2ddl.auto", "update">]
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		return hibernateProperties;
	}
}
