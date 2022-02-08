package com.kuehne_nagel.contact_list.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomServletInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        sc.setInitParameter("primefaces.THEME", "bootstrap");
    }

}