/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dokter;
import Util.NewHibernateUtil;

/**
 *
 * @author Imi
 */
public class DokterHelper {
    
    public DokterHelper() {
    }

//    public Dokter cariDokter(String id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        String query = "from Dokter d where d.id=:id";
//        Query q = session.createQuery(query);
//        q.setParameter("id", id);
//        List<Dokter> list = q.list();
//        transaction.commit();
//        session.close();
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
    
    public List<Dokter> getAll() {
         Session session = NewHibernateUtil.getSessionFactory().openSession();
         String query = "from Dokter";
         Query q = session.createQuery(query);
         List<Dokter> list = q.list();
         session.close();
        return list;  
    }
    
    public void addNewDoctor(String nama, String spesialis){
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Dokter dokter = new Dokter(nama, spesialis);
        session.saveOrUpdate(dokter);
        transaction.commit();
        session.close();
    }
}
