package com.foodrelief.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodrelief.bean.Trip;
import com.foodrelief.util.HibernateUtil;

public class TripDAO {

    public int generateTripID() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            id = ((Number) session
                    .createNativeQuery("SELECT trip_seq1.NEXTVAL FROM dual")
                    .getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return id;
    }

    public boolean insertTrip(Trip t) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public Trip findTrip(int tripID) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Trip trip = null;

        try {
            trip = session.get(Trip.class, tripID);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return trip;
    }

    public List<Trip> findTripsByVolunteerAndDate(String volunteerID, Date date) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Trip> list = null;

        try {
            String hql = "FROM Trip t WHERE t.volunteerID = :vid "
                    + "AND (FUNCTION('TRUNC', t.assignedTime) = :dt "
                    + "OR FUNCTION('TRUNC', t.pickupTime) = :dt)";

            list = session.createQuery(hql, Trip.class)
                    .setParameter("vid", volunteerID)
                    .setParameter("dt", date)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    public List<Trip> findTripsByDate(Date date) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Trip> list = null;

        try {
            String hql = "FROM Trip t WHERE FUNCTION('TRUNC', t.assignedTime) = :dt "
                    + "OR FUNCTION('TRUNC', t.pickupTime) = :dt";

            list = session.createQuery(hql, Trip.class)
                    .setParameter("dt", date)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

    public boolean updateTripStatusAndOutcome(int tripID, String newStatus,
            double deliveredQty, String notes) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            String hql = "UPDATE Trip t SET t.tripStatus = :status, "
                    + "t.deliveredQuantityKg = :qty, "
                    + "t.notes = :notes "
                    + "WHERE t.tripID = :id";

            int rows = session.createQuery(hql)
                    .setParameter("status", newStatus)
                    .setParameter("qty", deliveredQty)
                    .setParameter("notes", notes)
                    .setParameter("id", tripID)
                    .executeUpdate();

            tx.commit();
            return rows > 0;

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}