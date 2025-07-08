package bookPack;

public class PaperBook extends Book {
    private int bookStock ;

    public PaperBook(int bookStock) {
        this.bookStock = bookStock;
    }

    public PaperBook(String ISBN, String title, String year, double price, int bookStock) {
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
