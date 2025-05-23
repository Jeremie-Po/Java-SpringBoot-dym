package com.LearningSpring.tennis.service;

import com.LearningSpring.tennis.Player;
import com.LearningSpring.tennis.PlayerList;
import com.LearningSpring.tennis.PlayerToSave;
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

    public Player create(PlayerToSave playerToSave) {

        return getPlayerNewRanking(PlayerList.ALL, playerToSave);
    }

    public Player update(PlayerToSave playerToSave) {
        getByLastName(playerToSave.lastName());

        List<Player> playerWithoutPlayerToUpdate = PlayerList.ALL.stream()
                .filter(player -> !player.lastName().equals(playerToSave.lastName()))
                .collect(Collectors.toList());

        RankingCalculator rankingCalculator = new RankingCalculator(playerWithoutPlayerToUpdate, playerToSave);
        List<Player> players = rankingCalculator.getNewPlayersRanking();

        return players.stream()
                .filter(player -> player.lastName().equals(playerToSave.lastName()))
                .findFirst().get();

    }

    public void delete(String lastName) {
        Player playerToDelete = getByLastName(lastName);

        PlayerList.ALL = PlayerList.ALL.stream()
                .filter(player -> !player.lastName().equals(lastName))
                .toList();

        RankingCalculator rankingCalculator = new RankingCalculator(PlayerList.ALL);
        rankingCalculator.getNewPlayersRanking();
    }

    private Player getPlayerNewRanking(List<Player> existingPlayers, PlayerToSave playerToSave) {
        RankingCalculator rankingCalculator = new RankingCalculator(existingPlayers, playerToSave);
        List<Player> players = rankingCalculator.getNewPlayersRanking();

        return players.stream()
                .filter(player -> player.lastName().equals(playerToSave.lastName()))
                .findFirst().get();
    }
}
