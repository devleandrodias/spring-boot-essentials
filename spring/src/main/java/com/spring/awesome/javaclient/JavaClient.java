package com.spring.awesome.javaclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * JavaClient
 */
public class JavaClient {

  public static void main(String[] args) {
    HttpURLConnection connection = null;

    BufferedReader reader = null;

    String user = "devleandrodias";
    String password = "devleandro";

    try {
      URL url = new URL("http://localhost:8080/v1/protected/students");
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.addRequestProperty("Authorization", "Basic " + encodeUsernamePassword(user, password));

      System.out.println(encodeUsernamePassword(user, password));

      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder jsonSB = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        jsonSB.append(line);
      }

      System.out.println(jsonSB.toString());

    } catch (Exception e) {
      e.printStackTrace();
    }

    finally {
      // Fecha o conexão
      IOUtils.closeQuietly(reader);
      if (connection != null)
        connection.disconnect();
    }
  }

  private static String encodeUsernamePassword(String username, String password) {
    String userPassword = username + ":" + password;

    return new String(Base64.encodeBase64(userPassword.getBytes()));
  }
}