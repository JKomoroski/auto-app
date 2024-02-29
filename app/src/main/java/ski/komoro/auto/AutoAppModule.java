package ski.komoro.auto;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Clock;
import jakarta.inject.Singleton;
import com.google.inject.Provides;
import org.jdbi.v3.core.Jdbi;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import ski.komoro.auto.player.PlayerDao;
import ski.komoro.auto.round.RoundDao;

public class AutoAppModule extends DropwizardAwareModule<AutoAppConfig> {

    @Override
    public void configure() {
        bind(ObjectMapper.class).toInstance(bootstrap().getObjectMapper());
        bind(MetricRegistry.class).toInstance(bootstrap().getMetricRegistry());
    }

    @Provides
    @Singleton
    RoundDao provideRoundDao(Jdbi jdbi) {
        return jdbi.onDemand(RoundDao.class);
    }

    @Provides
    @Singleton
    PlayerDao providePlayerDao(Jdbi jdbi) {
        return jdbi.onDemand(PlayerDao.class);
    }

    @Provides
    @Singleton
    public Clock provideSystemClock() {
        return Clock.systemUTC();
    }

}
