package com.cms.DAO;


import com.cms.Database.HibernateCon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ValidateUser {
    public static List<Employee> elist = null;

    public static boolean check (String email, String pass) {
        boolean st = false;
        Transaction tx = null;
        try {
            Session session = HibernateCon.getSession().openSession();
            tx = session.beginTransaction();

            Query q = session.createQuery("from Employee e where e.email= :email and e.password= :pass and e.manager=0")
                    .setParameter("email", email)
                    .setParameter("pass", pass); //HQL
            elist = q.list();

            if (elist.size() == 1)
                st = true;

            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }


        return st;
    }

    public static boolean checkMan (String email, String pass) {
        boolean st = false;
        Transaction tx = null;
        try {
            Session session = HibernateCon.getSession().openSession();
            tx = session.beginTransaction();

            Query q = session.createQuery("from Employee e where e.email= :email and e.password= :pass and e.manager=1")
                    .setParameter("email", email)
                    .setParameter("pass", pass); //HQL
            elist = q.list();

            if (elist.size() == 1)
                st = true;

            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }


        return st;
    }
}
