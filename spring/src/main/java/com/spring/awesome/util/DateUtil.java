package com.spring.awesome.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

/**
 * DateUtil
 */
// Pode ser usada na injção de depências
@Component // Ele marca classe como uma classe que vai ser escaneada pelo ComponentScan
// @Repository // Especialização de quando você estiver trabalhando com DAO
// @Service // Especialização do Component mas não tem nada diferente, só
// especifica mesmo
public class DateUtil {

  public String formatLocalDateTimeToDataBaseStyle(LocalDateTime localDateTime) {

    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
  }
}