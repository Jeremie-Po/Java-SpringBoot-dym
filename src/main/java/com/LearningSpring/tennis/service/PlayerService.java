package com.LearningSpring.tennis.service;

import com.LearningSpring.tennis.Player;
import com.LearningSpring.tennis.PlayerList;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    public List<Player> getAllPlayers() {

        return PlayerList.ALL;
    }

    public List<Player> getSortedPlayers() {

        return getAllPlayers().stream()
                .sorted(Comparator.comparing(player -> player.rank().position()))
                .collect(Collectors.toList());
    }

    public Player getByLastName(String lastName) {
        return getAllPlayers().stream()
                .filter(player -> player.lastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(lastName));
    }
}
