package com.LearningSpring.tennis.service;

import com.LearningSpring.tennis.Player;
import com.LearningSpring.tennis.PlayerList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> getAllPlayers() {
        return PlayerList.ALL;
    }
}
