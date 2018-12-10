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
import pojos.Location;
import Util.NewHibernateUtil;
/**
 *
 * @author Imi
 */
public class LocationHelper {
    public LocationHelper() {
    }
    
    public List<Location> getAll(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "From Location";
        Query q = session.createQuery(query);
        List<Location> list = q.list();
        session.close();
        return list;
    }
    
//    public Location cariLokasi(String nama) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        String query = "from Location l where l.name=:name";
//        Query q = session.createQuery(query);
//        q.setParameter("nama", nama);
//        List<Location> list = q.list();
//        t.commit();
//        session.close();
//        
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
    
    public void addNewLocation(Double lat, Double lng, String name){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Location local = new Location(lat, lng, name);
        session.saveOrUpdate(local);
        transaction.commit();
        session.close();
    }

}
