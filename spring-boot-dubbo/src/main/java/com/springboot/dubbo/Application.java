package com.springboot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;
@ComponentScan("com.springboot.dubbo.http")
@ImportResource("classpath:config/appcontext-*.xml")
@SpringBootApplication  
@EnableAspectJAutoProxy
@RestController  
public class Application {  
      
    public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }  
      
}