/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Pasien;
import Util.NewHibernateUtil;

/**
 *
 * @author Imi
 */
public class PasienHelper {

    public PasienHelper() {
    }

    public List<Pasien> getAllPasien() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Pasien p";
        Query q = session.createQuery(query);
        List<Pasien> list = q.list();
        session.close();
        return list;
    }

    public static String toJson() {
        PasienHelper helper = new PasienHelper();
        List<Pasien> list = helper.getAllPasien();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                result = result + list.get(i).toJson() + ",\n";
            } else {
                result = result + list.get(i).toJson() + "\n";
            }
        }
        result = result + "]";
        return result;
    }

    public void addNewPasien(String noRm, String nama, String alamat,
            String nik, Date tanggalLahir, String kelamin) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pasien pasien = new Pasien(noRm, nama, alamat, nik, tanggalLahir, kelamin);
        session.saveOrUpdate(pasien);
        transaction.commit();
        session.close();
    }

}
