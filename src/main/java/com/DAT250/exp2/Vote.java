package com.DAT250.exp2;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;

    public Instant getPublishedAt () {
        return publishedAt;
    }

    public void setPublishedAt (Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
