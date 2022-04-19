package com.cms.DAO;

import com.cms.Database.HibernateCon;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class requestPendingDaoImpl implements requestPendingDao {
    @Override
    public List cabRequest () {
        Session session = HibernateCon.getSession().openSession();
        List alist = null;
        try {
            SQLQuery q = session.createSQLQuery("select * from request as r where r.bid= 1"); //HQL
            q.addEntity(Request.class);
            alist = q.list();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }
        return alist;
    }

    @Override
    public List pendingRequest () {
        Session session = HibernateCon.getSession().openSession();
        List alist = null;
        try {
            sqlquery q = session.createsqlquery("select * from request as r where r.bid= 2"); //hql
            q.addentity(request.class);
            alist = q.list();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }
        return alist;
    }
}
