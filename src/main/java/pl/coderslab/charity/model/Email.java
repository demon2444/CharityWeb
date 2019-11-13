package pl.coderslab.charity.model;

public class Email {


    private String to;
    private String title;
    private String text;

    public Email() {
    }

    public Email(String to, String title, String text) {
        this.to = to;
        this.title = title;
        this.text = text;
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
