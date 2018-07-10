package db;

import models.Golfer;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGolfer {

    private static Session session;
    private static Transaction transaction;

    public static void save(Golfer golfer) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(golfer);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Golfer> getAll(){

        List<Golfer> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Golfer.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Golfer find(int id){

        Golfer result = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Golfer.class);
            cr.add(Restrictions.eq("id", id));
            result = (Golfer)cr.uniqueResult();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }
}
