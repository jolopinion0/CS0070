import java.util.Scanner;

public class MP2P8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products to add: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();

        String[] prodCodes = new String[numProducts];
        String[] prodNames = new String[numProducts];
        double[] prodPrices = new double[numProducts];
        int[] prodStocks = new int[numProducts];

        for (int i = 0; i < numProducts; i++) {
            System.out.println("\nDetails for Product " + (i + 1));
            System.out.print("Product Code: ");
            prodCodes[i] = scanner.next();

            System.out.print("Product Name: ");
            prodNames[i] = scanner.next();

            System.out.print("Price: ");
            prodPrices[i] = scanner.nextDouble();

            System.out.print("Stock Quantity: ");
            prodStocks[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println();
        System.out.print("Enter number of add-to-cart actions: ");
        int numActions = scanner.nextInt();
        scanner.nextLine();

        String[] cartCodes = new String[numActions];
        String[] cartNames = new String[numActions];
        double[] cartPrices = new double[numActions];
        int[] cartQuantities = new int[numActions];

        int itemCount = 0;

        for (int i = 0; i < numActions; i++) {
            System.out.println("\nProcessing Add to Cart Action " + (i + 1));

            System.out.print("Product Code: ");
            String reqCode = scanner.next();

            System.out.print("Quantity to Add: ");
            int reqQty = scanner.nextInt();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            int prodIndex = -1;
            for (int p = 0; p < numProducts; p++) {
                if (prodCodes[p].equalsIgnoreCase(reqCode)) {
                    prodIndex = p;
                    break;
                }
            }

            if (prodIndex == -1) {
                System.out.println("Unknown Product Code (" + reqCode + ").");
            } else if (reqQty <= 0) {
                System.out.println("Quantity must be greater than 0.");
            } else if (prodStocks[prodIndex] < reqQty) {
                System.out.println("Insufficient stock available.");
            } else {
                prodStocks[prodIndex] -= reqQty;

                int existingCartIndex = -1;
                for (int c = 0; c < itemCount; c++) {
                    if (cartCodes[c].equalsIgnoreCase(reqCode)) {
                        existingCartIndex = c;
                        break;
                    }
                }

                if (existingCartIndex != -1) {
                    cartQuantities[existingCartIndex] += reqQty;
                    System.out.println("Updated " + prodNames[prodIndex] + " quantity in cart.");
                } else {
                    cartCodes[itemCount] = prodCodes[prodIndex];
                    cartNames[itemCount] = prodNames[prodIndex];
                    cartPrices[itemCount] = prodPrices[prodIndex];
                    cartQuantities[itemCount] = reqQty;
                    itemCount++;
                    System.out.println("Added " + prodNames[prodIndex] + " to cart.");
                }
            }
        }

        System.out.println("\nCART RECEIPT");
        double subtotal = 0;

        if (itemCount == 0) {
            System.out.println("Cart is empty.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                double lineTotal = cartPrices[i] * cartQuantities[i];
                subtotal += lineTotal;
                System.out.printf("Code: %s | Item: %s | Qty: %d | Unit Price: $%.2f | Line Total: $%.2f%n",
                        cartCodes[i], cartNames[i], cartQuantities[i], cartPrices[i], lineTotal);
            }
        }

        double discount = 0;
        if (subtotal >= 5000) {
            discount = subtotal * 0.10;
        } else if (subtotal >= 2000) {
            discount = subtotal * 0.05;
        }

        double discountedAmount = subtotal - discount;
        double vat = discountedAmount * 0.12;
        double finalTotal = discountedAmount + vat;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Discount: $%.2f%n", discount);
        System.out.printf("VAT (12%%): $%.2f%n", vat);
        System.out.printf("Final Total: $%.2f%n", finalTotal);

        System.out.println("\nREMAINING STOCK");
        for (int i = 0; i < numProducts; i++) {
            System.out.printf("Product: %s (%s) | Remaining Stock: %d%n", prodCodes[i], prodNames[i], prodStocks[i]);
        }

        scanner.close();
    }
}