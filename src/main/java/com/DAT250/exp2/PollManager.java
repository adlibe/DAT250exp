package com.DAT250.exp2;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Poll> polls = new HashMap<>();
}
