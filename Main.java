
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<VehicleData> vehicleList = new LinkedList<>();

        while (true) {
            System.out.print("Vehicle Brand (or 'exit' to finish): ");
            String make = scanner.nextLine();
            if (make.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter vehicle model: ");
            String model = scanner.nextLine();

            double mpg;
            while (true) {
                System.out.print("Enter miles per gallon (MPG): ");
                try {
                    mpg = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("enter a number");
                }
            }

            vehicleList.add(new VehicleData(make, model, mpg));
        }

        vehicleList.sort(Comparator.comparingDouble(VehicleData::getMilesPerGallon));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt"))) {
            for (VehicleData vehicle : vehicleList) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            System.out.println("Vehicle data saved to 'vehicles.txt'");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
