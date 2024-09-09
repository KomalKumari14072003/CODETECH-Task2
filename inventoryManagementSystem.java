package codeTech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class inventoryManagementSystem {
	 private static ArrayList<Product> products = new ArrayList<>();
	 private static HashMap<String, String> users = new HashMap<>();
	 private static Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) {
		// Initialize users
        users.put("komal", "modi");

        // Login
        System.out.print("Enter u  sername: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            // Login successful, show main menu
            showMenu();
        } else {
            // Login failed, show error message
            System.out.println("Invalid username or password");
        }
    }
	private static void showMenu() {
        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Products");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                editProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                viewProducts();
                break;
            case 5:
                generateReport();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

	private static void addProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.next();
        System.out.print("Enter product quantity: ");
        int productQuantity = scanner.nextInt();

        Product product = new Product(productName, productQuantity);
        products.add(product);
    }

    private static void editProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.next();
        System.out.print("Enter new quantity: ");
        int productQuantity = scanner.nextInt();

        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setQuantity(productQuantity);
                break;
            }
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.next();

        for (Product product : products) {
            if (product.getName().equals(productName)) {
                products.remove(product);
                break;
            }
        }
    }

    private static void viewProducts() {
        for (Product product : products) {
            System.out.println("Product Name: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }
    private static void generateReport() {
        // Generate report logic here
        System.out.println("Report generated");
    }

    private static class Product {
        private String name;
        private int quantity;

        public Product(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
		

	}

}








//The 'main' method initializes the users and prompts the user to login.
// The 'showMenu' methods displays the main menu and handles user input.
//the 'addProduct','editProduct','deleteProduct','viewProduct',and 'generateReport' methods performs the corresponding actions.
//the 'Product' class represents  a product with a name and quantity.