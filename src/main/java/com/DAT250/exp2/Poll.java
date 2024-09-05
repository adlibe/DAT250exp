package com.DAT250.exp2;

public class Poll {
    private String question;
    private Instant publishedAt;
    private Instant validUntil;

    public String getQuestion () {
        return question;
    }

    public void setQuestion (String question) {
        this.question = question;
    }

    public Instant setPublishedAt () {
        return publishedAt;
    }

    public void getPublishedAt (Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant setValidUntil () {
        return validUntil;
    }

    public void getValidUntil (Instant validUntil) {
        this.validUntil = validUntil;
    }
}


