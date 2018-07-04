package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import utils.LoggerDecorator;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    /**
     * Config classes
     * @return              Class[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses(){
        LoggerDecorator.logger.info("Initializing root config");
        return new Class[]{SecurityConfig.class, PersistenceConfig.class};
    }

    /**
     * Servlet config classes
     * @return              Class[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        LoggerDecorator.logger.info("Initializing servlet config");
        return new Class[]{WebAppConfig.class};
    }

    /**
     * Mapping config
     * @return              String[]
     */
    @Override
    protected String[] getServletMappings() {
        LoggerDecorator.logger.info("Initializing servlet mappings");
        return new String[]{"/"};
    }
}
