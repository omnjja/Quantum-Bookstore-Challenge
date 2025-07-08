package services;

import interfaces.StockableBooks;

public class ShippingService {
    public void shipBook(StockableBooks shippedBook , String address){
        System.out.println("Book is shipped successfully to the address: " + address);
    }
}
