package ski.komoro.auto.views;

import io.dropwizard.views.common.View;
import jakarta.inject.Inject;
import lombok.Getter;

@Getter
public class RoundView extends View {

    private final Round round;

    @Inject
    public RoundView(Round round) {
        super("round.ftl");
        this.round = round;
    }


    public record Round(
            int number,
            String groups
    ) {
    }

}
