package com.martinsaman.facemaskdetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FaceMaskDetectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceMaskDetectionApplication.class, args);
    }

}
