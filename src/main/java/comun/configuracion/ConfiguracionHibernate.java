package comun.configuracion;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("comun.usuario.*")})
public class ConfiguracionHibernate {
	
   @Bean
   public DataSource fuenteDatos(){
      DriverManagerDataSource fuenteDatos = new DriverManagerDataSource();
      fuenteDatos.setDriverClassName("org.hsqldb.jdbcDriver");
      fuenteDatos.setUrl("jdbc:hsqldb:file:C:\\hsqldb\\");
      fuenteDatos.setUsername( "SA" );
      fuenteDatos.setPassword( "" );
      return fuenteDatos;
   }
	
	@Bean
	public LocalContainerEntityManagerFactoryBean dameAdministradorEntidadesLocal() {
		LocalContainerEntityManagerFactoryBean  adminEntLocal = new LocalContainerEntityManagerFactoryBean();
		adminEntLocal.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
		adminEntLocal.setDataSource(fuenteDatos());
		adminEntLocal.setPackagesToScan("comun.usuario.*");
		adminEntLocal.setPersistenceUnitName("PERSISTENCIA_LOCAL");
		adminEntLocal.setJpaProperties(getHibernateProperties());
		return adminEntLocal;
	}

	@Bean
	public JpaTransactionManager dameAdministradorTransaccionesJPA() {
		JpaTransactionManager administradorTransacciones = new JpaTransactionManager();
		administradorTransacciones.setEntityManagerFactory(dameAdministradorEntidadesLocal().getObject());
		return administradorTransacciones;
	}
	
	@Bean
    public Properties getHibernateProperties()
    {
		Properties propiedadesPersistence = new Properties();		
		propiedadesPersistence.put("hibernate.dialect","org.hibernate.dialect.HSQLDialect");
		propiedadesPersistence.put("hibernate.show_sql","true");
		propiedadesPersistence.put("hibernate.hbm2ddl.auto","update");
		return propiedadesPersistence;
    }
}
