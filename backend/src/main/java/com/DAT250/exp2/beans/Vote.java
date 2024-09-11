package com.DAT250.exp2.beans;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;
    private User user;
    private VoteOption voteOption;

    public Instant getPublishedAt () {
        return publishedAt;
    }

    public void setPublishedAt (Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }

}
