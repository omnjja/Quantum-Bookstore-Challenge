package bookPack;

import interfaces.StockableBooks;

public class PaperBook extends Book implements StockableBooks {
    private int bookStock ;

    public PaperBook(int bookStock) {
        this.bookStock = bookStock;
    }

    public PaperBook(String ISBN, String title, int year, double price, int bookStock) {
        super(ISBN, title, year, price);
        this.bookStock = bookStock;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }
}
