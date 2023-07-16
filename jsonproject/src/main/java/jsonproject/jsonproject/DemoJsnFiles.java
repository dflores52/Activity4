package jsonproject.jsonproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class demonstrates the usage of JSON files in Java.
 */
public class DemoJsnFiles {

    /**
     * The main entry point of the program.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car(2018, "Ford", "Mustang", 0, 1.5d);
        cars[1] = new Car(2018, "Chevy", "Blazer", 1000, 1.5d);
        cars[2] = new Car(2019, "Toyota", "Camry", 2000, 1.5d);
        cars[3] = new Car(2018, "Toyota", "Avalon", 9000, 1.5d);
        cars[4] = new Car(2010, "GMC", "Silverado", 10000, 1.5d);

        for (int i = 0; i < 4; ++i) {
            saveToFile("out.json", cars[i], true);
        }

        ArrayList<Car> carsList = readFromFile("out.json");
        for (Car car : carsList) {
            String text = Integer.toString(car.getYear()) + ", " + car.getMake() + ", " + car.getModel() + ", " +
                    Integer.toString(car.getOdometer()) + ", " + Double.toString(car.getEngineLiters());
            System.out.println(text);
        }
    }

    /**
     * Saves a Car object to a JSON file.
     *
     * @param filename The name of the JSON file.
     * @param car      The Car object to be saved.
     * @param append   Whether to append to an existing file or create a new file.
     */
    public static void saveToFile(String filename, Car car, boolean append) {
        PrintWriter pw;
        try {
            File file = new File(filename);
            FileWriter fw = new FileWriter(file, append);
            pw = new PrintWriter(fw);

            ObjectMapper objMap = new ObjectMapper();
            String json = objMap.writeValueAsString(car);
            pw.println(json);

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads Car objects from a JSON file and returns them as an ArrayList.
     *
     * @param filename The name of the JSON file.
     * @return An ArrayList of Car objects read from the file.
     */
    public static ArrayList<Car> readFromFile(String filename) {
        ArrayList<Car> cars = new ArrayList<Car>();
        try {
            File file = new File(filename);
            Scanner scnr = new Scanner(file);

            while (scnr.hasNext()) {
                String json = scnr.nextLine();
                ObjectMapper objMap = new ObjectMapper();
                Car car = objMap.readValue(json, Car.class);
                cars.add(car);
            }
            scnr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cars;
    }
}
