import java.time.Year;

public class Main {
    public static void main(String[] args) {

        int year = Year.now().getValue();
        System.out.println(year);
    }
}