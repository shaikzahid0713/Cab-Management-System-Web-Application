package com.cms.DAO;

import com.cms.Database.HibernateCon;
import com.cms.Model.BookingStatus;
import com.cms.Model.Employee;
import com.cms.Model.Request;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class bookingDaoImpl implements bookingDao {
    @Override
    public boolean requestCab () {

        Session session = HibernateCon.getSession().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            BookingStatus b = new BookingStatus(1, "Requested");
            for (Employee e : ValidateUser.elist) {
                Request rq = new Request(e, b);
                session.save(rq);
            }

            tx.commit();

            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
