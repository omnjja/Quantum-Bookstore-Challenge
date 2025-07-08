package bookPack;

public class Ebook extends Book {
    private String fileType ;

    public Ebook(String ISBN, String title, String year, double price, String fileType) {
        super(ISBN, title, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
