/**
 * 
 */
package gestionPortatilesWeb.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import gestionPortatilesWeb.aplicacion.dal.Alumno;

/**
 * @author Pablo: Configuración del contexto de nuestra aplicación (No XML)
 *
 */
@Configuration
@ComponentScan
@PropertySource("classpath:web.properties")
@EnableJpaRepositories("gestionPortatilesWeb.aplicacion.dal")
public class AplicacionConfiguracionContexto {

	@Autowired
	private Environment enviroment;

	
	/**
	 * Acceso a las propiedades de spring que están alojadas en el archivo
	 * properties en nuestro apartado de recursos (web.properties) (Driver, Base de
	 * Datos, Usuario, Contraseña)
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("spring.dataSource.url"));
		dataSource.setUrl(enviroment.getProperty("spring.dataSource.database"));
		dataSource.setUsername(enviroment.getProperty("spring.dataSource.username"));
		dataSource.setPassword(enviroment.getProperty("spring.dataSource.password"));
		return dataSource;
	}

	/**
	 * Declaración y configuración de nuestro Entity Manager Factory Propiedades
	 * alojadas en nuestro archivo properties (web.properties)
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(Alumno.class.getPackage().getName());

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		jpaVendorAdapter.setDatabasePlatform(enviroment.getProperty("hibernate.dialect"));
		jpaVendorAdapter.setGenerateDdl(enviroment.getProperty("hibernate.generateDdl", Boolean.class));
		jpaVendorAdapter.setShowSql(enviroment.getProperty("hibernate.show_sql", Boolean.class));
		emf.setJpaVendorAdapter(jpaVendorAdapter);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", enviroment.getProperty("hibernate.format_sql"));
		emf.setJpaProperties(jpaProperties);

		return emf;
	}

	/**
	 * Declaración y configuración del Transaction Manager Propiedades alojadas en
	 * nuestro archivo properties (web.properties)
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager JpaTransactionManager = new JpaTransactionManager();
		JpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return JpaTransactionManager;
	}

}
