package com.nitish;

/**
 * Created by nitishkandula on 23/01/17.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
//@EnableAutoConfiguration
//public class UserApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(UserApplication.class, args);
//    }
//
//}
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class UserApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String propertyFilePath = "./config/application.properties";
        if(System.getenv("API_ENV").equalsIgnoreCase("production")){
            propertyFilePath = "/opt/config/applicaton.properties";
        }
        InputStream input = new FileInputStream(propertyFilePath);
        Properties properties = new Properties();
        properties.load(input);
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<UserApplication> applicationClass = UserApplication.class;
}
