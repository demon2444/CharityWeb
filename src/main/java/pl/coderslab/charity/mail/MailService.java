package pl.coderslab.charity.mail;


import pl.coderslab.charity.model.Email;

public interface MailService  {

    public void sendSimpleMessage(String to, String title, String text);
    public void reciveSimpleMessage(String title, String text, String reply);
    public void sendActivationLink(String to, Long id, String token);
    public void recoverPassword(String to, Long id, String token);
    public void emailContact(Email email);

}
