package com.cms.DAO;

import com.cms.Database.HibernateCon;
import com.cms.Model.BookingStatus;
import com.cms.Model.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class acceptRequestDaoImpl implements acceptRequestDao {

    private static final Logger logger = Logger.getLogger("acceptRequestDaoImpl.class");

    @Override
    public boolean accept (Integer id) {
        Session session = HibernateCon.getSession().openSession();
        Transaction tx = null;

        logger.info("Within AcceptRequestDao");
        try {
            tx = session.beginTransaction();
            Request r = session.get(Request.class, id);
            BookingStatus cs = new BookingStatus(2, "Accepted");
            r.setbId(cs);
            session.update(r);
            session.flush();
            tx.commit();
            logger.info("Success in updating Booking Status to Accepted");
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            logger.info("Couldn't update booking status");
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
