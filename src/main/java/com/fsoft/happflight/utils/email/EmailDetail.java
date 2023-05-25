package com.fsoft.happflight.utils.email;

public class EmailDetail {
    private String recipent;
    private String messageBody;
    private String subject;

    public EmailDetail() {}

    public EmailDetail(String recipent, String messageBody, String subject) {
        this.recipent = recipent;
        this.messageBody = messageBody;
        this.subject = subject;
    }

    public String getRecipent() {
        return recipent;
    }

    public void setRecipent(String recipent) {
        this.recipent = recipent;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
