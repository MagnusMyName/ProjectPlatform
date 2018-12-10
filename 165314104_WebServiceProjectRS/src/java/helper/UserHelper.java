/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.User;

/**
 *
 * @author Imi
 */
public class UserHelper {

    public UserHelper() {
    }

//    public User cariUser(String email) {
//        //create session
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
////        //crate transaction
//        Transaction transaction = session.beginTransaction();
//
////        User user = null;
//        //create string query
//        String query = "from User u where u.email=:email";
//        Query q = session.createQuery(query);
//        q.setParameter("email", email);
//
//        //create list hasil pencarian dan panggil pencarian
//        List<User> list = q.list();
//        transaction.commit();
//
//        //tutup session
//        session.close();
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
//    
//    public User Login(String email, String password) {
//        User user = this.cariUser(email);
//
//        if (user != null) {//user ada
//            if (user.getPassword().equals(password)) {//passwd sama
//                return user;
//            } else {//passwd beda
//                return null;
//            }
//        } else {
//            return null;
//        }
//
//    }
    public List<User> getAllUser() {
        //create session
        Session session = NewHibernateUtil.getSessionFactory().openSession();

//        //crate transaction
//        Transaction transaction = session.beginTransaction();
//        User user = null;
        //create string query
//        String query = "from User u where u.email=:email";
        String query = "from User";
        Query q = session.createQuery(query);
//        q.setParameter("email", email);
//
        //create list hasil pencarian dan panggil pencarian
        List<User> list = q.list();
//        transaction.commit();

        //tutup session
        session.close();
        return list;
    }

    public User login(String email, String password) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "From User a where a.email=:email AND a.password=:password";

        Query q = session.createQuery(query);
        q.setParameter("email", email);
        q.setParameter("password", password);

        return (User) q.uniqueResult();
    }
}
