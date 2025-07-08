import inventory.Inventory;
import purchase.StoreService;

public class BookStoreTest {
    public static void main(String[] args) {

        System.out.println("Test started\n");
        Inventory inventory = new Inventory();

        // Print before test
        inventory.printInventory(inventory.getBooks());

        // Add books
        inventory.addBook("1", "001", "Java Essentials", 2016, 150.0, 10); // PaperBook
        inventory.addBook("1", "011", "Solid", 2024, 200.0, 15); // PaperBook
        inventory.addBook("2", "002", "Learn Spring Boot", 2020, 100.0, "pdf"); // EBook
        inventory.addBook("2", "022", "Python", 2020, 100.0, "docx"); // EBook
        inventory.addBook("3", "003", "Free Preview Book", 2012, 0.0, null); // DemoBook

        System.out.println("All books added successfully.");
        System.out.println("Total books in inventory: " + inventory.getBooks().size());
        inventory.printInventory(inventory.getBooks());

        // print outdated books
        System.out.println("\nHere is the outdated books");
        inventory.printInventory(inventory.returnOutdated(10));
        // Remove outdated books
        inventory.removeOutdatedBooks(10);
        System.out.println("\nThe inventory after outdated books removed.");
        inventory.printInventory(inventory.getBooks());

        StoreService storeService = new StoreService(inventory);


        System.out.println("\nTest #1 : Valid PaperBook purchase");
        try {
            double amountPaid = storeService.buyBook("001", 2, "user@example.com", "Cairo, Egypt");
            System.out.println("PaperBook purchase successful. Amount paid: " + amountPaid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nTest #2 : Valid Ebook purchase");
        try {
            double amountPaid = storeService.buyBook("002", 1, "ebook@example.com", "Cairo");
            System.out.println("EBook purchase successful. Amount paid: " + amountPaid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTest #3 : Buying a DemoBook");
        try {
            storeService.buyBook("003", 1, "demo@example.com", "Anywhere");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTest #4 : Buying a non-existent book");
        try {
            storeService.buyBook("999", 1, "fake@example.com", "Nowhere");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nTest #5 : Buying more PaperBooks than available");
        try {
            storeService.buyBook("001", 20, "tooMuch@example.com", "Giza");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nTest #6 : Buying EBook with quantity > 1");
        try {
            storeService.buyBook("002", 5, "ebook@example.com", "Alex");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nTest #7 : Buying EBook without email");
        try {
            storeService.buyBook("002", 1, null, "Alex");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nTest #8 : Buying PaperBook with null address");
        try {
            storeService.buyBook("001", 1, "user@example.com", null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final Inventory:");
        inventory.printInventory(inventory.getBooks());
        System.out.println("Test completed :)");
    }
}
