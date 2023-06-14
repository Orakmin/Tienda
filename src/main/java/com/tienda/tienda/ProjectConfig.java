
package com.tienda.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ProjectConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
      var slr= new SessionLocaleResolver();
          slr.setDefaultLocale(Locale.getDefault());
          slr.setTimeZoneAttributeName("sesion.current.locale");
          slr.setTimeZoneAttributeName("session.current.timezone");
      
      
      return slr;
      
    }
    
    
    
}
