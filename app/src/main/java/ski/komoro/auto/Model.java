package ski.komoro.auto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Model {

    public record Player(
            UUID id,
            String playerName,
            boolean active
    ) {}

    public record Group(
            UUID id,
            String name,
            List<Player> players,
            List<Match> matches
    ) {}

    public record Match(
            UUID id,
            Player winningPlayer,
            Player losingPlayer,
            List<Game> games
    ) {}

    public record Game(
            UUID id,
            Player winner,
            Player loser,
            Optional<Score> score
    ) {}

    public record Score(
            int winnerScore,
            int loserScore
    ) {}
}
