package comun.configuracion;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("comun")})
public class ConfiguracionHibernate {
	@Bean
	public LocalEntityManagerFactoryBean dameAdministradorEntidadesLocal() {
		LocalEntityManagerFactoryBean adminEntLocal = new LocalEntityManagerFactoryBean();
		adminEntLocal.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
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
		propiedadesPersistence.put("javax.persistence.jdbc.url","jdbc:hsqldb:file:C:\\hsqldb\\");
		propiedadesPersistence.put("javax.persistence.jdbc.user","SA");
		propiedadesPersistence.put("javax.persistence.jdbc.password","");
		propiedadesPersistence.put("javax.persistence.jdbc.driver","org.hsqldb.jdbcDriver");
		propiedadesPersistence.put("hibernate.dialect","org.hibernate.dialect.HSQLDialect");
		propiedadesPersistence.put("hibernate.show_sql","true");
		propiedadesPersistence.put("hibernate.hbm2ddl.auto","update");
		return propiedadesPersistence;
    }
}
