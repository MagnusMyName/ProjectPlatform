/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Helper.PasienHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author basisa11
 */
public class testAddPasien {

    public static void main(String[] args) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String tglLahir = "19741231";
            Date date = format.parse(tglLahir);
            String noRm = "654321";
            String nama = "Adi";

            PasienHelper helper = new PasienHelper();
            String alamat = "paingan";
            String kelamin = "lelaki";
            helper.addNewPasien(noRm, nama, alamat, noRm, date, kelamin);
        } catch (ParseException ex) {
            Logger.getLogger(testAddPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}