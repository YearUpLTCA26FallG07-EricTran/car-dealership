package com.pluralsight;

import java.util.List;

public class UserInterface {

        private Dealership dealership;

        public UserInterface() {
    }

    private void innit() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = DealershipFileManager.getDealership();
    }


    public static void display() {
        int choice;



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

    public static void processGetbyPriceRequest() {

    }

    public static void processGetByMakeModelRequest() {

    }

    public static void processGetByYearRequest() {

    }
    public static void processGetByColorRequest() {

    }
    public static void processGetByMileageRequest() {

    }
    public static void processGetByVehicleTypeRequest() {

    }
    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    public static void processAddVehicleRequest() {

    }
    public static void processRemoveVehicleRequest() {

    }


}
