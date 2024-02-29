package ski.komoro.auto.round;

import io.dropwizard.views.common.View;
import java.util.List;
import lombok.Getter;

@Getter
class RoundView extends View {

    private final List<Round> rounds;

    public RoundView(List<Round> rounds) {
        super("round.ftl");
        this.rounds = rounds;
    }


}
