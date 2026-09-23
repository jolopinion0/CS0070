import java.util.Scanner;

public class MP2P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        while (count < 1 || count > 10) {
            System.out.print("Enter number of employees(1-10): ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count < 1 || count > 10) {
                    System.out.println("Please pick a number between 1 and 10");
                }
            } else {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        scanner.nextLine();

        String[] id = new String[count]; // Changed from int[] to String[]
        String[] name = new String[count];
        double[] hours = new double[count];
        double[] rates = new double[count];
        double[] gross = new double[count];
        double[] taxes = new double[count];
        double[] net = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\n Employee " + (i + 1));

            System.out.print("ID: ");
            id[i] = scanner.nextLine(); // Now reads full String input for ID

            System.out.print("Name: ");
            name[i] = scanner.nextLine();

            double hoursholder = -1;
            while (hoursholder < 0) {
                System.out.print("Hours Worked: ");
                if (scanner.hasNextDouble()) {
                    hoursholder = scanner.nextDouble();
                    if (hoursholder < 0) System.out.println("Hours cannot be negative");
                } else {
                    System.out.println("Invalid input");
                    scanner.next();
                }
            }
            hours[i] = hoursholder;

            double rateholder = -1;
            while (rateholder < 0) {
                System.out.print("Hourly Rate: ");
                if (scanner.hasNextDouble()) {
                    rateholder = scanner.nextDouble();
                    if (rateholder < 0) System.out.println("Hourly rate cannot be negative.");
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }
            rates[i] = rateholder;

            // Gross Pay
            if (hours[i] <= 40) {
                gross[i] = hours[i] * rates[i];
            } else {
                double regular = 40 * rates[i];
                double overtime = (hours[i] - 40) * (rates[i] * 1.5);
                gross[i] = regular + overtime;
            }

            // Taxes
            if (gross[i] <= 10000) {
                taxes[i] = gross[i] * 0.05;
            } else if (gross[i] <= 20000) {
                taxes[i] = gross[i] * 0.10;
            } else {
                taxes[i] = gross[i] * 0.15;
            }

            // Net Pay
            net[i] = gross[i] - taxes[i];
            scanner.nextLine(); // Consume newline after numeric inputs before next loop iteration
        }

        System.out.println("\nPAYROLL SUMMARY");
        double totalNetPay = 0;
        int highestNetIndex = 0;

        for (int i = 0; i < count; i++) {
            // Changed %d to %s in print format string for String ID output
            System.out.printf("ID: %s | Name: %s | Gross: $%.2f | Tax: $%.2f | Net: $%.2f%n",
                    id[i], name[i], gross[i], taxes[i], net[i]);

            totalNetPay += net[i];

            if (net[i] > net[highestNetIndex]) {
                highestNetIndex = i;
            }
        }

        double averageNetPay = totalNetPay / count;

        System.out.println("");
        System.out.printf("Highest Net Pay: %s ($%.2f)%n", name[highestNetIndex], net[highestNetIndex]);
        System.out.printf("Average Net Pay: $%.2f%n", averageNetPay);
        System.out.println("Total Employees Processed: " + count);

        scanner.close();
    }
}