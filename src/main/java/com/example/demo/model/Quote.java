package com.example.demo.model;

public class Quote {
    String pickupPostcode;
    String deliveryPostcode;
    Long price;
    String vehicle;

    public Quote() {}

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
        this.vehicle = vehicle;
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickup_postcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDelivery_postcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getVehicle() { return vehicle; }
    public void setVehicle(String travel_vehicle) { this.vehicle = travel_vehicle; }
}
