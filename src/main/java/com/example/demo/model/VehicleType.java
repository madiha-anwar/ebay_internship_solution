package com.example.demo.model;

public enum VehicleType {
    BICYCLE ("bicycle", 10),
    MOTORBIKE ("motorbike", 15),
    PARCELCAR ("parcel_car", 20),
    SMALLVAN ("small_van", 30),
    LARGEVAN ("large_van", 40);

    private final String name;
    private final Integer markup;

    private VehicleType(String name, Integer markup) {
        this.name = name;
        this.markup = markup;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public Integer getMarkup() { return this.markup; }
    public String getName() { return this.name; }

    public String toString() {
        return this.name;
    }
}