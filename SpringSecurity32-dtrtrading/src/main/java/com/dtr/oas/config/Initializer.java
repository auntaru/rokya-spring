/*
 * http://dtr-trading.blogspot.ro/search/label/Security
 * http://dtr-trading.blogspot.ro/2014/02/spring-mvc-4-security-part-1.html
 * 
 */

package com.dtr.oas.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dtr.oas.config.RootConfig;
import com.dtr.oas.config.ThymeleafConfig;
import com.dtr.oas.config.WebAppConfig;

public class Initializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class, SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ThymeleafConfig.class, WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}