package bookPack;

public class Book {
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

    public boolean isOutdated(){
        return (year < 2000) ;
    }

    public Book getSpecieficBook(String ISBN){
        if(this.ISBN.equals(ISBN)){
            return this;
        }
        return null;
    }
}
