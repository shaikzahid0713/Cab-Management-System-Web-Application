package com.cms.DAO;

import com.cms.Database.HibernateCon;
import com.cms.Model.Cab;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class cabRegisterDaoImpl implements cabRegisterDao {

    private static final Logger logger = Logger.getLogger("CabRegistrationImpl.class");

    @Override
    public boolean register (Cab c) {
        Transaction tx = null;
        Session session = HibernateCon.getSession().openSession();
        logger.info("Transaction started");
        try {
            tx = session.beginTransaction();
            if (c != null) {
                session.save(c);
                tx.commit();
                logger.info("Transaction committed");
            }
            else {
                logger.info("Cab object is null! Exception Thrown");
                throw new Exception();
            }

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            logger.info("Transaction Rollback");
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
