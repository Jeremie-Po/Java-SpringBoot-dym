package com.LearningSpring.tennis.web;

import com.LearningSpring.tennis.Player;
import com.LearningSpring.tennis.PlayerToSave;
import com.LearningSpring.tennis.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tennis Players API")
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Operation(summary = "finds players", description = "find players")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "players list",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Player.class)))
                    })
    })

    @GetMapping
    public List<Player> list() {

        return playerService.getSortedPlayers();
    }

    @Operation(summary = "find a player", description = "find a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "player",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Player.class))
                    }),
            @ApiResponse(responseCode = "404", description = "player with specified last name was not found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))
                    })
    })
    @GetMapping("{lastName}")
    public Player getByLastName(@PathVariable("lastName") String lastName) {
        return playerService.getByLastName(lastName);
    }

    @Operation(summary = "Create a player", description = "Create a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created player",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerToSave.class))
                    })
    })
    @PostMapping
    public Player createPlayer(@Valid @RequestBody PlayerToSave playerToSave) {
        return playerService.create(playerToSave);
    }

    @Operation(summary = "Update a player", description = "Update a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updated player",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Player.class))
                    }),
            @ApiResponse(responseCode = "404", description = "player with specified last name was not found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))
                    })
    })
    @PutMapping
    public Player updatePlayer(@Valid @RequestBody PlayerToSave playerToSave) {
        return playerService.update(playerToSave);
    }

    @Operation(summary = "Delete a player", description = "Delete a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player has been deleted player"),
            @ApiResponse(responseCode = "404", description = "player with specified last name was not found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Error.class))
                    })
    })
    @DeleteMapping("{lastName}")
    public void playerDelete(@PathVariable("lastName") String lastName) {
        playerService.delete(lastName);
    }
}
