package com.spring.awesome.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Aqui você estarta o spring boot, e ele start o servert content pra você Ex.
 * Tom Cat.
 */
@SpringBootApplication // Diz pro Spring configurar projeto através das dependencias
@ComponentScan(basePackages = "com.spring.awesome.endpoint") // Pacote onde está nosso endpoint
public class ApplicationStart {
  public static void main(String[] args) {

    SpringApplication.run(ApplicationStart.class, args);
  }
}