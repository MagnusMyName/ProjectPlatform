/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Helper.PasienHelper;
import Pojos.Pasien;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author basisa11
 */
public class testPasien {
     public static void main(String[] args) {
        PasienHelper test = new PasienHelper();
        List<Pasien> list = test.getAllPasien();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
