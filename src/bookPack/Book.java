package bookPack;

import java.time.Year;

public abstract class Book {
    private String ISBN;
    private String title;
    private int year;
    private double price;

    public Book() {}

    public Book(String ISBN, String title, int year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOutdated(int specificNumOfYears){
        int year = Year.now().getValue();
        return ((year - this.year) >= specificNumOfYears ) ;
    }

}
