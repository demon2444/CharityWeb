package pl.coderslab.charity.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.model.Email;

import java.util.Properties;
import java.util.UUID;


@Component
public class MailServiceImpl implements MailService{

    @Autowired
    public JavaMailSender mailSender;


    public void sendSimpleMessage(String to, String title, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(title);
        message.setText(text);
        mailSender.send(message);
    }

    @Override
    public void emailContact(Email email) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email.getTo());
    message.setSubject(email.getTitle());
    message.setText(email.getText());
    message.setFrom(email.getReply());
    mailSender.send(message);
    }

    public void reciveSimpleMessage(String title, String text, String reply) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("charity.donation12@gmail.com");
        message.setSubject(title);
        message.setText(text);
        message.setReplyTo(reply);
        mailSender.send(message);
    }

    @Override
    public void sendActivationLink(String to, Long id, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Link aktywacyjny");
        message.setText("http://localhost:8080/user/activate/" + id + "/" + token);
        mailSender.send(message);
    }

    @Override
    public void recoverPassword(String to, Long id, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setReplyTo("charity.donation12@gmail.com");
        message.setSubject("Link resetujący hasło");
        message.setText("Poniżej przesyłamy link resetujacy hasło: \n \n http://localhost:8080/user/reset/" + id + "/" + token +
        "\n \n Jeśli nie ty wygenerowałeś to żądanie kliknij odpowiedz i powiadom o tym incydencie administratora");
        mailSender.send(message);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("charity.donation12@gmail.com");
        mailSender.setPassword("fwczhSNWA55eDSG");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }


}
