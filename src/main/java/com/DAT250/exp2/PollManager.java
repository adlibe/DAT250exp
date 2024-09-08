package com.DAT250.exp2;

import com.DAT250.exp2.beans.Poll;
import com.DAT250.exp2.beans.User;
import com.DAT250.exp2.beans.Vote;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();
    private final Map<String, Map<String, Vote>> votes = new HashMap<>();

    //Users
    public Map<String, User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public boolean deleteUser(String username) {
        return this.users.remove(username) != null;
    }

    //Polls
    public Map<String, Poll> getPolls() {
        return polls;
    }

    public Poll getPoll(String pollId) {
        return polls.get(pollId);
    }

    public void updatePoll(String pollId, Poll updatedPoll) {
        polls.put(pollId, updatedPoll);
    }

    public void addPoll(Poll poll) {
        polls.put(poll.getPollId(), poll);
    }

    public boolean deletePoll(String pollId) {
        return polls.remove(pollId) != null;
    }

    // Votes
    public Map<String, Vote> getVotesForPoll(String pollId) {
        Map<String, Vote> pollVotes = votes.get(pollId);
        return pollVotes;
    }


    public void addVote(String pollId, Vote vote) {
        Map<String, Vote> pollVotes = votes.get(pollId);
        pollVotes.put(vote.getUser().getUsername(), vote);
    }

}
