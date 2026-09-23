import java.util.Scanner;

public class MP2P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rooms to add: ");
        int numRooms = scanner.nextInt();
        scanner.nextLine();

        int[] roomNumbers = new int[numRooms];
        String[] roomTypes = new String[numRooms];
        double[] nightlyRates = new double[numRooms];
        boolean[] isAvailable = new boolean[numRooms];

        for (int i = 0; i < numRooms; i++) {
            System.out.println("\nDetails for Room " + (i + 1));
            System.out.print("Room Number: ");
            roomNumbers[i] = scanner.nextInt();

            System.out.print("Room Type: ");
            roomTypes[i] = scanner.next();

            System.out.print("Nightly Rate: ");
            nightlyRates[i] = scanner.nextDouble();
            scanner.nextLine();

            isAvailable[i] = true;
        }

        System.out.println();
        System.out.print("Enter number of guests: ");
        int numGuests = scanner.nextInt();
        scanner.nextLine();

        String[] guestIds = new String[numGuests];
        String[] guestNames = new String[numGuests];

        for (int i = 0; i < numGuests; i++) {
            System.out.println("\nDetails for Guest " + (i + 1));
            System.out.print("Guest ID: ");
            guestIds[i] = scanner.next();

            System.out.print("Full Name: ");
            guestNames[i] = scanner.next();
        }

        System.out.println();
        System.out.print("Enter number of reservation requests: ");
        int numRequests = scanner.nextInt();
        scanner.nextLine();

        String[] resIds = new String[numRequests];
        String[] resGuestNames = new String[numRequests];
        int[] resRoomNumbers = new int[numRequests];
        int[] resNights = new int[numRequests];
        double[] resTotalCosts = new double[numRequests];

        int successfulCount = 0;

        for (int i = 0; i < numRequests; i++) {
            System.out.println("\nProcessing Reservation Request " + (i + 1));

            System.out.print("Reservation ID: ");
            String requestResId = scanner.next();

            System.out.print("Guest ID: ");
            String reqGuestId = scanner.next();

            System.out.print("Room Number: ");
            int reqRoomNum = scanner.nextInt();

            System.out.print("Number of Nights: ");
            int reqNights = scanner.nextInt();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            int guestIndex = -1;
            for (int g = 0; g < numGuests; g++) {
                if (guestIds[g].equalsIgnoreCase(reqGuestId)) {
                    guestIndex = g;
                    break;
                }
            }

            int roomIndex = -1;
            for (int r = 0; r < numRooms; r++) {
                if (roomNumbers[r] == reqRoomNum) {
                    roomIndex = r;
                    break;
                }
            }

            if (guestIndex == -1) {
                System.out.println("Unknown Guest ID (" + reqGuestId + ").");
            } else if (roomIndex == -1) {
                System.out.println("Unknown Room Number (" + reqRoomNum + ").");
            } else if (reqNights < 1) {
                System.out.println("Nights must be at least 1.");
            } else if (!isAvailable[roomIndex]) {
                System.out.println("Room " + reqRoomNum + " is already unavailable/booked.");
            } else {
                isAvailable[roomIndex] = false;

                resIds[successfulCount] = requestResId;
                resGuestNames[successfulCount] = guestNames[guestIndex];
                resRoomNumbers[successfulCount] = roomNumbers[roomIndex];
                resNights[successfulCount] = reqNights;
                resTotalCosts[successfulCount] = nightlyRates[roomIndex] * reqNights;

                successfulCount++;
                System.out.println("Reservation " + requestResId + " created for " + guestNames[guestIndex]);
            }
        }

        System.out.println("\nSUCCESSFUL RESERVATIONS");
        double totalRevenue = 0;

        if (successfulCount == 0) {
            System.out.println("No successful reservations were made.");
        } else {
            for (int i = 0; i < successfulCount; i++) {
                System.out.printf("Reservation ID: %s | Guest: %s | Room: %d | Nights: %d | Total Cost: $%.2f%n",
                        resIds[i], resGuestNames[i], resRoomNumbers[i], resNights[i], resTotalCosts[i]);
                totalRevenue += resTotalCosts[i];
            }
        }

        System.out.printf("Total Expected Revenue: $%.2f%n", totalRevenue);

        System.out.println("\nAVAILABLE ROOMS");
        boolean anyAvailable = false;
        for (int i = 0; i < numRooms; i++) {
            if (isAvailable[i]) {
                System.out.printf("Room %d (%s) - $%.2f/night%n", roomNumbers[i], roomTypes[i], nightlyRates[i]);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No rooms are currently available.");
        }

        scanner.close();
    }
}