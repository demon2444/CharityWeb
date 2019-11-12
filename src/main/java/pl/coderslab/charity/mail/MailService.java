package pl.coderslab.charity.mail;



public interface MailService  {

    public void sendSimpleMessage(String to, String title, String text);
    public void reciveSimpleMessage(String title, String text);

}
