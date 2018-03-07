package com.example.auth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.auth.NotFoundException;
import com.example.auth.model.User;

public class InMemoryUserService implements UserService {

    private static final AtomicLong ID = new AtomicLong(1000);

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User getUser(long id) throws NotFoundException {
        User user = users.get(id);
        return copy(Optional.ofNullable(user).orElseThrow(() -> new NotFoundException(String.format("User %d not found", id))));
    }

    @Override
    public List<User> findUsers(String filter) {
        return users.values().stream().filter(user ->
            Stream.of(user.getName(), user.getEmail(), user.getPhone())
                    .filter(Objects::nonNull)
                    .anyMatch(s -> s.contains(filter))
        ).collect(Collectors.toList());
    }

    @Override
    public User addUser(User newUser) {
        User userToAdd = copy(newUser);
        userToAdd.setId(ID.incrementAndGet());
        users.put(userToAdd.getId(), userToAdd);
        return copy(userToAdd);
    }

    @Override
    public User updateUser(User user) throws NotFoundException {
        User storedUser = users.get(user.getId());
        if (storedUser == null) {
            throw new NotFoundException(String.format("User %d not found", user.getId()));
        }
        storedUser.setName(user.getName());
        storedUser.setPhone(user.getPhone());
        storedUser.setEmail(user.getEmail());
        return copy(storedUser);
    }

    @Override
    public void deleteUser(long id) throws NotFoundException {
        if (users.remove(id) == null) {
            throw new NotFoundException(String.format("User %d not found", id));
        }
    }

    private User copy(User source) {
        User clone = new User();
        clone.setId(source.getId());
        clone.setName(source.getName());
        clone.setEmail(source.getEmail());
        clone.setPhone(source.getPhone());
        return clone;
    }
}
