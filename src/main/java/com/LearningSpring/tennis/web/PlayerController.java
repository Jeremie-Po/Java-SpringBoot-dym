package com.LearningSpring.tennis.web;

import com.LearningSpring.tennis.Player;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Tag(name = "Tennis Players API")
@RestController
@RequestMapping("/players")
public class PlayerController {

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
        return Collections.emptyList();
    }

    @Operation(summary = "find a player", description = "find a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "player",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Player.class))
                    })
    })
    @GetMapping("{lastName}")
    public Player getByLastName(@PathVariable("lastName") String lastName) {
        return null;
    }

    @Operation(summary = "Add a player", description = "add a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "created player",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Player.class))
                    })
    })
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return player;
    }
}
