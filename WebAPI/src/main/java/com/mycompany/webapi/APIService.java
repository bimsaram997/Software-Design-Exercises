/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webapi;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;




/**
 *
 * @author bimsa
 */
public class APIService {
  
  public DataHolder getDataFromApi() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = client.execute(request)) {
                return new Gson().fromJson(new InputStreamReader(response.getEntity().getContent()), DataHolder.class);
            }
        } catch (Exception e) {
            return null;
        }
    }

}
