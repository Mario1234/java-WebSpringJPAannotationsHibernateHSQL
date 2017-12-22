package comun.configuracion;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ConfiguracionAplicacion extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { ConfiguracionHibernate.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { ConfiguracionWeb.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}
