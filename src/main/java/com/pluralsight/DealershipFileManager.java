package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {

    public static Dealership getDealership() {


        Dealership dealership = null;

        try(BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {


            String line = reader.readLine();
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];
                dealership = new Dealership(name, address, phone);

                line = reader.readLine();
            while (line != null) {
                String[] vehicleInformation = line.split("\\|");
                int vin = Integer.parseInt(vehicleInformation[0]);
                int year = Integer.parseInt(vehicleInformation[1]);
                String make = vehicleInformation[2];
                String model = vehicleInformation[3];
                String vehicleType = vehicleInformation[4];
                String color = vehicleInformation[5];
                int odometer = Integer.parseInt(vehicleInformation[6]);
                BigDecimal price = new BigDecimal(vehicleInformation[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model,
                        vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
                line = reader.readLine();


            }
            return dealership;

        }
        catch (FileNotFoundException e) {
            System.out.println("Could not locate file");
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }

        return null;
    }




    public static void saveDealership(Dealership dealership) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"))) {


            writer.write(dealership.getName() + "|"
                    + dealership.getAddress() + "|"
                    + dealership.getPhone());

            writer.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice()
                );

                writer.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }


    }
}
