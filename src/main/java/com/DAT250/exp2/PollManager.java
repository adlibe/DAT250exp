package com.DAT250.exp2;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();

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

    public void addPoll(Poll poll) {
        polls.put(poll.getQuestion(), poll);
    }
}
