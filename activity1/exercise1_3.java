import java.util.Scanner;

public class VehicleInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String brand = sc.nextLine();
        String model = sc.nextLine();
        String plateNumber = sc.next();
        int year = sc.nextInt();
        double engineDisplacement = sc.nextDouble();

        System.out.println("Brand: " + brand + "\n Model: " + model
                + "\n Plate: " + plateNumber + "\n Year: " + year
                + "\n Engine: " + engineDisplacement + "L");

        sc.close();
    }
}