package ski.komoro.auto;

import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractAutoAppConfig extends Configuration {

    @Valid
    @NotNull
    private final FlywayFactory flyway = new FlywayFactory();

    @Valid
    @NotNull
    @Value.Parameter
    public abstract DataSourceFactory getDatabase();

    public FlywayFactory getFlyway() {
        return flyway;
    }

}
