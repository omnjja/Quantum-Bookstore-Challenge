package purchase;

import bookPack.Book;
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
    public double buyBook(String ISBN, int quantity, String email, String address) {
        Book book = inventory.getSpecieficBook(ISBN);
        if (book == null) {
            throw new UnsupportedOperationException("Book is not available");
        } else {
            switch (book) {
                case NotForSale notForSale -> throw new UnsupportedOperationException("This type of book is not for sale");
                case StockableBooks stockableBook -> {
                    if (stockableBook.getBookStock() < quantity) {
                        throw new UnsupportedOperationException("Not enough books in the stock.");
                    } else {
                        if (address == null) {
                            throw new IllegalArgumentException("Shipping address must be provided for PaperBooks.");
                        }
                        inventory.reduceBookAmount(stockableBook, quantity);
                        ShippingService shippingService = new ShippingService();
                        shippingService.shipBook(stockableBook , address);
                        return returnPaidAmount(book, quantity);
                    }
                }
                case Ebooks ebook -> {
                    if (quantity > 1) {
                        throw new UnsupportedOperationException("Can't buy multiple copies of an EBook");
                    }
                    if (email == null) {
                        throw new IllegalArgumentException("Email must be provided for E-books.");
                    }
                    EmailService emailService = new EmailService();
                    emailService.sendEmail(ebook, email);
                    return returnPaidAmount(book, 1);
                }
                default -> {
                    throw new IllegalStateException("Not valid book.");
                }
            }
        }
    }
}

