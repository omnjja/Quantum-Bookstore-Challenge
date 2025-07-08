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

    public void addNewBook(String ISBN, String title, int year, double price, Object extra) {
        String bookType ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the book type: ");
        System.out.println("1. Paper book");
        System.out.println("2. E-book");
        System.out.println("3. Demo book(not for sale)");
        bookType = scanner.nextLine();
        switch (bookType){
            case "1":
                System.out.println("Please enter the book stock: ");
                int bookStock = scanner.nextInt();
                Book paperBook = factory.createBook(bookType, ISBN, title, year, price, bookStock);
                books.put(ISBN, paperBook);
                break;
            case "2":
                System.out.println("Please enter file type of the book: ");
                String fileType = scanner.nextLine();
                Book eBook = factory.createBook(bookType, ISBN, title, year, price, fileType);
                books.put(ISBN, eBook);
                break;
            case "3":
                Book demo = factory.createBook(bookType, ISBN, title, year, price, null);
                books.put(ISBN, demo);
        }
    }

    public void removeBooks(int numOfYears) {
        for (Book book : books.values()) {
            if (book.isOutdated(numOfYears)){
                books.remove(book.getISBN());
            }
        }
    }

    public List<Book> returnOutdated(int numOfYears) {
        List<Book> outdatedBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isOutdated(numOfYears)){
                outdatedBooks.add(book);
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
        stockableBook.setBookStock(stockableBook.getBookStock() - amount);
    }
}
