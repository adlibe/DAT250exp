package com.DAT250.exp2.controllers;

import com.DAT250.exp2.beans.Poll;
import com.DAT250.exp2.PollManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/polls")
public class PollController {
    private final PollManager pollManager;

    public PollController(@Autowired PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public void addPoll(@RequestBody Poll poll) {
        pollManager.addPoll(poll);
    }

    @GetMapping("/{pollId}")
    public Poll getPolls(@PathVariable String pollId) {
        return pollManager.getPoll(pollId);
    }

    @GetMapping
    public Collection<Poll> getPolls() {
        return pollManager.getPolls().values();
    }

    @PutMapping("/{pollId}")
    public Poll updatePoll(@PathVariable String pollId, @RequestBody Poll updatedPoll) {
        pollManager.updatePoll(pollId, updatedPoll);
        return updatedPoll;
    }

    @DeleteMapping("/{pollId}")
    public void deletePoll(@PathVariable String pollId) {
        pollManager.deletePoll(pollId);
    }
}
