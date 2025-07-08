package purchase;

import bookPack.Book;
import bookPack.Ebook;
import interfaces.Ebooks;
import interfaces.NotForSale;
import interfaces.StockableBooks;
import inventory.Inventory;
import services.EmailService;
import services.ShippingService;


public class StoreService {
    private Inventory inventory;

    public StoreService(Inventory inventory) {
        this.inventory = inventory;
    }

    public double returnPaidAmount(Book book , int quantity){
        return (book.getPrice() * quantity);
    }
    public void buyBook(String ISBN, int quantity, String email, String address) {
        Book book = inventory.getSpecieficBook(ISBN);
        if (book == null) {
            System.out.println("Book is not available");
            return;
        } else {
            switch (book) {
                case NotForSale notForSale -> throw new UnsupportedOperationException("This type of book is not for sale");
                case StockableBooks stockableBook -> {
                    if (stockableBook.getBookStock() < quantity) {
                        throw new UnsupportedOperationException("Not enough books in the stock");
                    } else {
                        inventory.reduceBookAmount(stockableBook, quantity);
                        ShippingService shippingService = new ShippingService();
                        shippingService.shipBook(stockableBook , address);
                        System.out.println(returnPaidAmount(book, quantity));
                    }
                }
                case Ebooks ebook -> {
                    EmailService emailService = new EmailService();
                    emailService.sendEmail(ebook, email);
                    System.out.println(returnPaidAmount(book, 1));
                }
                default -> {
                    throw new IllegalStateException("Not valid book");
                }
            }
        }
    }
}

