import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String model;
    private double price;
    private boolean available;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
        this.available = true;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class RentalSystem {
    private List<Car> cars;
    private int rentalId;

    public RentalSystem() {
        this.cars = new ArrayList<>();
        this.rentalId = 1000; // starting rental ID
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void rentCar(int index, int duration, String customerInfo) {
        Car selectedCar = cars.get(index);
        if (selectedCar.isAvailable()) {
            selectedCar.setAvailable(false);
            rentalId++;
            System.out.println("Rental ID: " + rentalId);
            System.out.println("Car Model: " + selectedCar.getModel());
            System.out.println("Rental Duration: " + duration + " days");
            System.out.println("Customer Information: " + customerInfo);
            System.out.println("Total Price: $" + (selectedCar.getPrice() * duration));
        } else {
            System.out.println("Selected car is not available.");
        }
    }

    public void returnCar(int rentalId) {
        // Logic to update car availability and generate invoice
    }

    public void inquireAboutCar(String model, double maxPrice) {
        // Logic to display available cars matching criteria
    }
}

public class rent_car {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        rentalSystem.addCar(new Car("Toyota Camry", 50.0));
        rentalSystem.addCar(new Car("Honda Civic", 40.0));
        rentalSystem.addCar(new Car("Ford Mustang", 100.0));

        Scanner scanner = new Scanner(System.in);

        // Example usage
        System.out.println("Welcome to Rent-a-Car System");
        System.out.println("1. Rent a Car");
        System.out.println("2. Return a Car");
        System.out.println("3. Enquire about Car");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Available Cars:");
                List<Car> availableCars = rentalSystem.getCars();
                for (int i = 0; i < availableCars.size(); i++) {
                    Car car = availableCars.get(i);
                    System.out.println(i + ". " + car.getModel() + " - $" + car.getPrice() + " per day");
                }
                System.out.print("Select a car to rent (enter index): ");
                int carIndex = scanner.nextInt();
                System.out.print("Enter rental duration (in days): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter your information: ");
                String customerInfo = scanner.nextLine();
                rentalSystem.rentCar(carIndex, duration, customerInfo);
                break;
            case 2:
                System.out.print("Enter rental ID to return the car: ");
                int rentalId = scanner.nextInt();
                rentalSystem.returnCar(rentalId);
                break;
            case 3:
                System.out.print("Enter car model: ");
                String model = scanner.next();
                System.out.print("Enter maximum price: ");
                double maxPrice = scanner.nextDouble();
                rentalSystem.inquireAboutCar(model, maxPrice);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}
