package com.services.cxf.rest;

import com.services.cxf.rest.model.TeacherUtil;
import com.services.cxf.rest.providers.TeacherNotFoundExceptionHandler;
import com.services.cxf.rest.services.TeachersServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
public class RestApplication {

    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.<Object>asList(teachersService()));
        endpoint.setAddress("/");
        endpoint.setProvider(jacksonJsonProvider());
        endpoint.setProvider(teacherNotFoundExceptionHandler());
        return endpoint.create();
    }

    @Bean
    public TeacherNotFoundExceptionHandler teacherNotFoundExceptionHandler(){
        return new TeacherNotFoundExceptionHandler();
    }

    @Bean
    public TeachersServiceImpl teachersService(){
        return new TeachersServiceImpl();
    }

    @Bean
    public TeacherUtil teacherUtil(){
        return new TeacherUtil();
    }

    @Bean
    public JacksonJsonProvider jacksonJsonProvider(){
        return new JacksonJsonProvider();
    }
}