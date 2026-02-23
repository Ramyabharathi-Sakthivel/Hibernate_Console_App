package com.foodrelief.bean;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trip_table1")
public class Trip {

    @Id
    @Column(name = "trip_id")
    private int tripID;

    @Column(name = "donation_id")
    private String donationID;

    @Column(name = "volunteer_id")
    private String volunteerID;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "vehicle_capacity")
    private double vehicleCapacityKg;

    @Column(name = "assigned_time")
    private Timestamp assignedTime;

    @Column(name = "pickup_time")
    private Timestamp pickupTime;

    @Column(name = "delivery_location")
    private String deliveryLocation;

    @Column(name = "delivery_ngo_shelter_name")
    private String deliveryNgoOrShelterName;

    @Column(name = "delivery_quantity")
    private double deliveredQuantityKg;

    @Column(name = "trip_status")
    private String tripStatus;

    @Column(name = "notes")
    private String notes;

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public String getDonationID() {
        return donationID;
    }

    public void setDonationID(String donationID) {
        this.donationID = donationID;
    }

    public String getVolunteerID() {
        return volunteerID;
    }

    public void setVolunteerID(String volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getVehicleCapacityKg() {
        return vehicleCapacityKg;
    }

    public void setVehicleCapacityKg(double vehicleCapacityKg) {
        this.vehicleCapacityKg = vehicleCapacityKg;
    }

    public Timestamp getAssignedTime() {
        return assignedTime;
    }

    public void setAssignedTime(Timestamp assignedTime) {
        this.assignedTime = assignedTime;
    }

    public Timestamp getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Timestamp pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getDeliveryNgoOrShelterName() {
        return deliveryNgoOrShelterName;
    }

    public void setDeliveryNgoOrShelterName(String deliveryNgoOrShelterName) {
        this.deliveryNgoOrShelterName = deliveryNgoOrShelterName;
    }

    public double getDeliveredQuantityKg() {
        return deliveredQuantityKg;
    }

    public void setDeliveredQuantityKg(double deliveredQuantityKg) {
        this.deliveredQuantityKg = deliveredQuantityKg;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}