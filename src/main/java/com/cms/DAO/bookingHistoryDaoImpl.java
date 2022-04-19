package com.cms.DAO;

import com.cms.Database.HibernateCon;
import org.hibernate.Session;

import java.util.List;

public class bookingHistoryDaoImpl implements bookingHistoryDao {
    @Override
    public List bookingHistory (String email, String password) {
        Session session = HibernateCon.getSession().openSession();
        List alist = null;
        try {
            String sql = "Select b.bookingId,b.cabNo,e.id from bdetails as b, employee as e where e.email= :email and b.id=e.id";
            SQLQuery q = session.createSQLQuery(sql);
            q.setParameter("email", email);
            q.addEntity(BookingDetails.class);
            alist = q.list();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }

        return alist;
    }
}
