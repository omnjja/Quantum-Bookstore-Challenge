package bookPack;

public class DemoBook extends Book {

    private boolean isForSale ;

    public DemoBook() {
        this.isForSale = false;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }
}
