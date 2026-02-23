package com.foodrelief.app;

import java.sql.Timestamp;

import com.foodrelief.bean.Donation;
import com.foodrelief.bean.Trip;
import com.foodrelief.dao.DonationDAO;
import com.foodrelief.dao.TripDAO;
import com.foodrelief.util.HibernateUtil;

public class FoodReliefMain {

    public static void main(String[] args) {

        System.out.println("--- Local Food Donation Coordination Console (Hibernate Direct DAO) ---");

        DonationDAO donationDAO = new DonationDAO();
        TripDAO tripDAO = new TripDAO();

        try {

            Donation d = new Donation();

            d.setDonationID("DN7000");
            d.setDonorName("Mathavi");
            d.setDonorPhone("9998887784");
            d.setDonorAddress("Flat No 234, Anna nagar");
            d.setCityArea("Anna nagar");
            d.setFoodType("GROCERY");
            d.setApproxQuantityKg(25.0);

            Timestamp now = new Timestamp(System.currentTimeMillis());
            Timestamp cutoff = new Timestamp(System.currentTimeMillis() + 3L * 60 * 60 * 1000);

            d.setPreparedTime(now);
            d.setExpiryCutoffTime(cutoff);
            d.setPreferredPickupSlot("Within next 2 hours");
            d.setDonationStatus("OPEN");
            d.setRemarks("10 Boxes of groceries");

            boolean donationSaved = donationDAO.insertDonation(d);

            System.out.println(donationSaved ? "DONATION REGISTERED" : "DONATION FAILED");

        } catch (Exception e) {
            System.out.println("Donation Error: " + e.getMessage());
        }

        try {

            int tripID = tripDAO.generateTripID();

            Timestamp assignedTime = new Timestamp(System.currentTimeMillis());

            com.foodrelief.bean.Trip trip = new com.foodrelief.bean.Trip();

            trip.setTripID(tripID);
            trip.setDonationID("DN7000");
            trip.setVolunteerID("VL210");
            trip.setVehicleType("TRUCK");
            trip.setVehicleCapacityKg(50.0);
            trip.setAssignedTime(assignedTime);
            trip.setDeliveryLocation("Shelter Home A, Main Road");
            trip.setDeliveryNgoOrShelterName("Shelter Home A");
            trip.setDeliveredQuantityKg(0.0);
            trip.setTripStatus("ASSIGNED");
            trip.setNotes("Handle carefully");

            boolean tripSaved = tripDAO.insertTrip(trip);

            System.out.println(tripSaved ? "TRIP CREATED" : "TRIP FAILED");

        } catch (Exception e) {
            System.out.println("Trip Error: " + e.getMessage());
        }

        HibernateUtil.getSessionFactory().close();
    }
}