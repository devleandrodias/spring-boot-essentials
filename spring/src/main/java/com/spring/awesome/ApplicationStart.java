package com.spring.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aqui você estarta o spring boot, e ele start o servert content pra você Ex.
 * Tom Cat.
 */

// Faz tudo o que as três annotation faz abaixo
@SpringBootApplication // Diz pro Spring configurar projeto através das dependencias

// @EnableAutoConfiguration // Auto configura o SpringBoot
// @ComponentScan // Pacote onde está nosso endpoint
// @Configuration // Ela faz a configuração de acordo com as classes que você
// definir como config.
public class ApplicationStart {
  public static void main(String[] args) {

    SpringApplication.run(ApplicationStart.class, args);
  }
}