package bookPack;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Book> books;

    public Inventory() {}

    public Inventory(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addNewBook(Book book) {
        books.add(book);
    }
    public void removeBooks() {
        books.removeIf(Book::isOutdated);
    }

    public List<Book> returnOutdated() {
        List<Book> outdatedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isOutdated()) {
                outdatedBooks.add(book);
            }
        }
        return outdatedBooks;
    }


    public void buyBook(String ISBN, int quantity, String email) {
        // check if book is available
        // check if the amount is available
        // reduce the book amount
        // return paid amount
        // send to email service or to shipping service
//        for (Book book : books) {
//            if(book.getSpecieficBook(ISBN) != null) {
//                return (book.getPrice() * quantity);
//            }
//        }
    }
}
