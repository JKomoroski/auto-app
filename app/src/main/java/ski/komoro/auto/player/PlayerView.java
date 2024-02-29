package ski.komoro.auto.player;

import io.dropwizard.views.common.View;
import java.util.List;
import lombok.Getter;
import ski.komoro.auto.Model.Player;

@Getter
public class PlayerView extends View {

    private final List<Player> players;

    protected PlayerView(List<Player> players) {
        super("player.ftl");
        this.players = players;
    }
}
