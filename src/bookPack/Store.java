package bookPack;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private Inventory inventory;

    public Store() {
        inventory = new Inventory();
    }

    public void addBook(Book book) {
        inventory.addNewBook(book);
    }
    public void removeOutdatedBooks() {
        inventory.removeBooks();
    }

    public List<Book> returnOutdatedBooks() {
        return inventory.returnOutdated();
    }


    public void buyBook(String ISBN, int quantity, String email) {
        // check if book is available
        // check if the amount is available
        // reduce the book amount
        // return paid amount
        // send to email service or to shipping service

    }
}
