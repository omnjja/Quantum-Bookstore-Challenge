package bookPack;

public class FactoryBook {

    public Book createBook(String bookType, String ISBN, String title, int year, double price, Object extra) {

        return switch (bookType) {
            case "1" -> new PaperBook(ISBN, title, year, price, (Integer) extra);
            case "2" -> new Ebook(ISBN, title, year, price, (String) extra);
            case "3"  -> new DemoBook(ISBN, title, year, price);
            default -> throw new IllegalStateException("Unexpected book type : " + bookType);
        };
    }
}
