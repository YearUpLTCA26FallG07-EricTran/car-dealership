
package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Search vehicles by price
    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0 &&
                    vehicle.getPrice().compareTo(max) <= 0) {

                results.add(vehicle);
            }
        }

        return results;
    }

    // Search vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)) {

                results.add(vehicle);
            }
        }

        return results;
    }

    // Search vehicles by year
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min &&
                    vehicle.getYear() <= max) {

                results.add(vehicle);
            }
        }

        return results;
    }

    // Search vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Search vehicles by mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min &&
                    vehicle.getOdometer() <= max) {

                results.add(vehicle);
            }
        }

        return results;
    }

    // Search vehicles by type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Add vehicle
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Remove vehicle
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
