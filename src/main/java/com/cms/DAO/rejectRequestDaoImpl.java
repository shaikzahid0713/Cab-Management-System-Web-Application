package com.cms.DAO;

import com.cms.Database.HibernateCon;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class rejectRequestDaoImpl implements rejectRequestDao {
    @Override
    public boolean reject (Integer id) {
        Session session = HibernateCon.getSession().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Request r = session.get(Request.class, id);
            BookingStatus cs = new BookingStatus(3, "Rejected");
            r.setbId(cs);
            session.update(r);
            session.flush();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
