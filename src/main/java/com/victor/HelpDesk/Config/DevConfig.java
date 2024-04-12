package com.victor.HelpDesk.Config;

import com.victor.HelpDesk.Service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Dev")
public class DevConfig {

    @Autowired
    private DBService service;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public boolean instanciaDB(){

        if(value.equals("create")){
            this.service.instanciaDB();
        }
        return false;
    }
}
