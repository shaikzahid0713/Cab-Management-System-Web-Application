package com.cms.DAO;

import com.cms.Database.HibernateCon;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class assignCabDaoImpl implements assignCabDao {

    private static final Logger logger = Logger.getLogger("assignCabDaoImpl.class");

    @Override
    public boolean assign (Integer id) {
        Session session = HibernateCon.getSession().openSession();
        List clist = null;
        List rlist = null;
        Transaction tx = null;

        logger.info("With in Assign Cab Dao Implementation");

        try {
            tx = session.getTransaction();
            tx.begin();
            SQLQuery c = session.createSQLQuery("select * from cab as c where c.status= 1"); //HQL
            c.addEntity(Cab.class);
            clist = c.list();

            logger.info("Cab got selected");

            SQLQuery r = session.createSQLQuery("select * from request as r where r.requestId= :rqst"); //HQL
            r.addEntity(Request.class);
            r.setParameter("rqst", id);
            rlist = r.list();

            logger.info("Particular Request got selected");

            Iterator it = clist.iterator();
            Iterator ite = rlist.iterator();
            if (it.hasNext() && ite.hasNext()) {

                Cab c1 = (Cab) it.next();
                Request r1 = (Request) ite.next();

                BookingDetails bd = new BookingDetails(c1, r1.getEmp());
                BookingStatus bs = new BookingStatus(4, "Booked");
                logger.info("Objects got created");
                session.save(bd);
                logger.info("Saved into booking details ");
                c1.setStatus(0);
                r1.setBookingId(bd);
                r1.setbId(bs);
                session.update(c1);
                logger.info("updated cab's booking status");
                session.update(r1);
                logger.info("updated request table with booking id");
                session.flush();
            }
            else {
                return false;
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
