package com.foodrelief.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodrelief.bean.Donation;
import com.foodrelief.util.HibernateUtil;

public class DonationDAO {

    public Donation findDonation(String donationID) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Donation.class, donationID);
        }
    }

    public List<Donation> viewDonationsByStatusAndArea(String status, String cityArea) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "FROM Donation d WHERE "
                    + "(:status IS NULL OR d.donationStatus = :status) "
                    + "AND (:cityArea IS NULL OR d.cityArea = :cityArea)";

            return session.createQuery(hql, Donation.class)
                    .setParameter("status", status)
                    .setParameter("cityArea", cityArea)
                    .getResultList();
        }
    }

    public boolean insertDonation(Donation d) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.persist(d);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDonationStatus(String donationID, String newStatus) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Donation d = session.get(Donation.class, donationID);
            if (d != null) {
                d.setDonationStatus(newStatus);
                session.merge(d);
                tx.commit();
                return true;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }

        return false;
    }

    public boolean updateDonationStatusAndRemarks(String donationID, String newStatus, String remarks) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Donation d = session.get(Donation.class, donationID);
            if (d != null) {
                d.setDonationStatus(newStatus);
                d.setRemarks(remarks);
                session.merge(d);
                tx.commit();
                return true;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }

        return false;
    }
}