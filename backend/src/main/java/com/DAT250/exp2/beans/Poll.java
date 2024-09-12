package com.DAT250.exp2.beans;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Poll {
    private Instant publishedAt;
    private Instant validUntil;
    private String pollId;
    private String question;
    private List<VoteOption> voteOptions = new ArrayList<>();

    public Poll() {
        this.pollId = UUID.randomUUID().toString();
        this.publishedAt = Instant.now();
    }

    public String getQuestion () {
        return question;
    }

    public void setQuestion (String question) {
        this.question = question;
    }

    public Instant getPublishedAt () {
        return publishedAt;
    }

    public void setPublishedAt (Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil () {
        return validUntil;
    }

    public void setValidUntil (Instant validUntil) {
        this.validUntil = validUntil;
    }

    public String getPollId() {
        return pollId;
    }

    public List<VoteOption> getVoteOptions() {
        return voteOptions;
    }

    public void setVoteOptions(List<VoteOption> voteOptions) {
        this.voteOptions = voteOptions;
    }

}


