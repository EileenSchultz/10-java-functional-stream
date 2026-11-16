package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<>() {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    @Override
    public void accept(Message<T> message) {
        mailBox.computeIfAbsent(message.getTo(), k -> new ArrayList<>())
                .add(message.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}