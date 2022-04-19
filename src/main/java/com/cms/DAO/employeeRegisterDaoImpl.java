package com.cms.DAO;

import com.cms.Database.HibernateCon;
import com.cms.Model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class employeeRegisterDaoImpl implements employeeRegisterDao {
    @Override
    public boolean registerEmployee (Employee employee) {
        Session session = HibernateCon.getSession().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (employee != null)
                session.save(employee);
            else
                throw new Exception();
            tx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            //e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
