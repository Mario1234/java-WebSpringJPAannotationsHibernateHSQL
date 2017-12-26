package comun.configuracion;
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
		adminEntLocal.setPersistenceUnitName("PERSISTENCIA_LOCAL");
		return adminEntLocal;
	}

	@Bean
	public JpaTransactionManager dameAdministradorTransaccionesJPA() {
		JpaTransactionManager administradorTransacciones = new JpaTransactionManager();
		administradorTransacciones.setEntityManagerFactory(dameAdministradorEntidadesLocal().getObject());
		return administradorTransacciones;
	}
}
