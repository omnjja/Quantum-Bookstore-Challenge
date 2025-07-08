package bookPack;

import interfaces.NotForSale;

public class DemoBook extends Book implements NotForSale {

    public DemoBook(String ISBN, String title, int year, double price) {
        super(ISBN, title, year, price);
    }

}
