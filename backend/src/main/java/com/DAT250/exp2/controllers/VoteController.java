package com.DAT250.exp2.controllers;

import com.DAT250.exp2.PollManager;
import com.DAT250.exp2.beans.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final PollManager pollManager;

    public VoteController(@Autowired PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping("/{pollId}")
    public void addVote(@PathVariable String pollId, @RequestBody Vote vote) {
        pollManager.addVote(pollId, vote);
    }

    @GetMapping("/{pollId}")
    public Collection<Vote> getVotes(@PathVariable String pollId) {
        return pollManager.getVotesForPoll(pollId).values();
    }
}
