package inventory;

import bookPack.*;
import interfaces.StockableBooks;

import java.util.*;

public class Inventory {
    private HashMap<String, Book> books;
    private FactoryBook factory;

    public Inventory() {
        this.books = new HashMap<>();
        this.factory = new FactoryBook();
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, Book> books) {
        this.books = books;
    }

    public void addBook(String bookType, String ISBN, String title, int year, double price, Object extra) {
        Book book = factory.createBook(bookType, ISBN, title, year, price, extra);
        books.put(ISBN, book);
    }

    public void removeOutdatedBooks(int numOfYears) {
        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (book.isOutdated(numOfYears)) {
                iterator.remove();
            }
        }
    }

    public HashMap<String, Book> returnOutdated(int numOfYears) {
        HashMap<String, Book>  outdatedBooks = new HashMap<>();
        for (Book book : books.values()) {
            if (book.isOutdated(numOfYears)){
                outdatedBooks.put(book.getISBN(), book);
            }
        }
        return outdatedBooks;
    }
    public Book getSpecieficBook(String ISBN){
        for (Book book : books.values()) {
            if (book.getISBN().equals(ISBN)){
                return book;
            }
        }
        return null;
    }

    public void reduceBookAmount(StockableBooks stockableBook, int amount){
        int newStock = stockableBook.getBookStock() - amount;
        stockableBook.setBookStock(newStock);
    }

    public void printInventory(HashMap<String, Book> books) {
        System.out.println("######### Inventory #########");

        if (getBooks().isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        // Print header
        System.out.printf("%-6s | %-25s | %-6s | %-8s | %-10s | %-15s%n",
                "ISBN", "Title", "Year", "Price", "Type", "Extra Info");

        System.out.println("------------------------------------------------------------------------");

        for (Book book : books.values()) {
            String type;
            String extraInfo = "";

            if (book instanceof StockableBooks) {
                type = "PaperBook";
                extraInfo = "Stock: " + ((StockableBooks) book).getBookStock();
            } else if (book instanceof Ebook) {
                type = "EBook";
                extraInfo = "File: " + ((Ebook) book).getFileType();
            } else if (book instanceof DemoBook) {
                type = "DemoBook";
                extraInfo = "Not for sale";
            } else {
                type = "Unknown";
            }
            System.out.printf("%-6s | %-25s | %-6d | %-8.2f | %-10s | %-15s%n",
                    book.getISBN(), book.getTitle(), book.getYear(), book.getPrice(), type, extraInfo);
        }
    }

}
