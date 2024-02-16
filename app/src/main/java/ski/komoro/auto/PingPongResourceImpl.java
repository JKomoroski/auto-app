package ski.komoro.auto;

import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingPongResourceImpl implements PingPongApi {

    private static final Logger log = LoggerFactory.getLogger(PingPongResourceImpl.class);

    @Inject
    private Jdbi jdbi;

    @Override
    public String ping() {
        log.info("received ping, relying pong");
        jdbi.withHandle(h -> {
            final var execute = h.execute("select 1");
            log.info("db query response code {}", execute);
            return execute;
        });
        return "pong";
    }
}
