package pl.coderslab.charity.model;

public class Email {


    private String to;
    private String title;
    private String text;
    private String reply;

    public Email() {
    }

    public Email(String to, String title, String text, String reply) {
        this.to = to;
        this.title = title;
        this.text = text;
        this.reply = reply;
    }


    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
