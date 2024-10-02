/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.webapi;

import java.io.IOException;








/**
 *
 * @author bimsa
 */
public class WebAPI {

    public static void main(String[] args)  {
         APIService apiService = new APIService();
        DataHolder data = apiService.getDataFromApi();
        System.out.println("hi" + data.toString());

       
      
    }
}
