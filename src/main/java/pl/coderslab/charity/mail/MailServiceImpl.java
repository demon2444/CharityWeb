package pl.coderslab.charity.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;




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


    public void reciveSimpleMessage(String title, String text, String reply) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("charity.donation12@gmail.com");
        message.setSubject(title);
        message.setText(text);
        message.setReplyTo(reply);
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
