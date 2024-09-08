package com.DAT250.exp2.controllers;

import com.DAT250.exp2.beans.Poll;
import com.DAT250.exp2.PollManager;
import com.DAT250.exp2.beans.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/voteoptions")
public class VoteOptionController {
    private final PollManager pollManager;

    public VoteOptionController(@Autowired PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public void addVoteOption(@PathVariable String pollId, @RequestBody VoteOption voteOption) {
        Poll poll = pollManager.getPoll(pollId);
        poll.getVoteOptions().add(voteOption);
        pollManager.updatePoll(pollId, poll);
    }

    @GetMapping
    public Collection<VoteOption> getVoteOptions(@PathVariable String pollId) {
        Poll poll = pollManager.getPoll(pollId);
        return poll.getVoteOptions();
    }

}
