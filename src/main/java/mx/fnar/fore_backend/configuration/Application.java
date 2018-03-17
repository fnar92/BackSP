/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fnar.fore_backend.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author francisco.acevedo
 */
@SpringBootApplication
@ComponentScan(basePackages = {
    "mx.fnar.fore_backend.rest",
    "mx.fnar.fore_backend.service",
    "mx.fnar.fore_backend.configuration"
})
@MapperScan("mx.fnar.fore_backend.mapper")
public class Application {

    public static void main(String... args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

}
