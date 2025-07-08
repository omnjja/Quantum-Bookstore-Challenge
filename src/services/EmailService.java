package services;

import interfaces.Ebooks;

public class EmailService {
    public void sendEmail(Ebooks ebook , String email) {
        System.out.println("The book sent to the email address " + email);
    }
}
