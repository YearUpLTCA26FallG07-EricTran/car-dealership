package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;

public class UserInterface {

        private Dealership dealership;

        public UserInterface() {
    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }


    public void display() {
        int choice;
        init();


        do {
            String userDisplayScreen = """
                    
                    Car Dealership
                    [1] - Find vehicles within a price
                    [2] - Find vehicles by make/model
                    [3] - Find vehicles by year range
                    [4] - Find vehicles by color
                    [5] - Find vehicles by mileage range
                    [6] - Find vehicels by type(car, truck, SUV, van)
                    [7] - List ALL vehicles
                    [8] - Add a vehicle
                    [9] - Remove a vehicle
                    [99] - Quit
                    
                    Select an option: """;
            choice = Console.promptForInt(userDisplayScreen);

            switch(choice) {
                case 1 -> processGetbyPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> {}

                default -> System.out.println("Invalid Input, Try again.");

            }
        } while (choice != 99);

    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(
                    vehicle.getVin() + " | " +
                            vehicle.getYear() + " | " +
                            vehicle.getMake() + " | " +
                            vehicle.getModel() + " | " +
                            vehicle.getVehicleType() + " | " +
                            vehicle.getColor() + " | " +
                            vehicle.getOdometer() + " | " +
                            vehicle.getPrice()
            );
        }
    }

    public  void processGetbyPriceRequest() {
        BigDecimal min = Console.promptForBigDecimal(
                "Enter minimum price: ");

        BigDecimal max = Console.promptForBigDecimal(
                "Enter maximum price: ");

        List<Vehicle> vehicles =
                dealership.getVehiclesByPrice(min, max);

        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        String make = Console.promptForString(
                "Enter vehicle make: ");

        String model = Console.promptForString(
                "Enter vehicle model: ");

        List<Vehicle> vehicles =
                dealership.getVehiclesByMakeModel(make, model);

        displayVehicles(vehicles);

    }

    public void processGetByYearRequest() {
        int min = Console.promptForInt(
                "Enter minimum year: ");

        int max = Console.promptForInt(
                "Enter maximum year: ");

        List<Vehicle> vehicles =
                dealership.getVehiclesByYear(min, max);

        displayVehicles(vehicles);

    }
    public void processGetByColorRequest() {
        String color = Console.promptForString(
                "Enter vehicle color: ");

        List<Vehicle> vehicles =
                dealership.getVehiclesByColor(color);

        displayVehicles(vehicles);

    }
    public void processGetByMileageRequest() {
        int min = Console.promptForInt(
                "Enter minimum mileage: ");

        int max = Console.promptForInt(
                "Enter maximum mileage: ");

        List<Vehicle> vehicles =
                dealership.getVehiclesByMileage(min, max);

        displayVehicles(vehicles);

    }
    public void processGetByVehicleTypeRequest() {
        String vehicleType = Console.promptForString(
                "Enter vehicle type (car, truck, SUV, van): ");

        List<Vehicle> vehicles =
                dealership.getVehiclesByType(vehicleType);

        displayVehicles(vehicles);


    }
    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.println("Enter vehicle information:");

        int vin = Console.promptForInt("VIN: ");

        int year = Console.promptForInt("Year: ");

        String make = Console.promptForString("Make: ");

        String model = Console.promptForString("Model: ");

        String vehicleType = Console.promptForString(
                "Vehicle type: ");

        String color = Console.promptForString("Color: ");

        int odometer = Console.promptForInt("Odometer: ");

        BigDecimal price = Console.promptForBigDecimal(
                "Price: ");

        Vehicle vehicle = new Vehicle(
                vin,
                year,
                make,
                model,
                vehicleType,
                color,
                odometer,
                price
        );

        dealership.addVehicle(vehicle);

        DealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle successfully added!");
    }


    public void processRemoveVehicleRequest() {
        int vin = Console.promptForInt(
                "Enter VIN of vehicle to remove: ");

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {

            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager.saveDealership(dealership);

            System.out.println("Vehicle successfully removed!");

        } else {

            System.out.println("Vehicle not found.");

        }

    }
}
