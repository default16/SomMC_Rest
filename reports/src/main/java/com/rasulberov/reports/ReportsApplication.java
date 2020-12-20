package com.rasulberov.reports;

import com.rasulberov.reports.restclient.services.ApiService;
import com.rasulberov.reports.restclient.services.ApiServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ReportsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ReportsApplication.class, args);

        ApiService service = context.getBean(ApiServiceImpl.class);

        System.out.println(service.getData());
    }

}
