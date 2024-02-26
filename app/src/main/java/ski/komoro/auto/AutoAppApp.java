package ski.komoro.auto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import io.dropwizard.views.common.ViewBundle;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.guicey.spa.SpaBundle;
import ski.komoro.auto.dao.DatabaseBundleFactory;
import ski.komoro.auto.views.CustomFVR;

@Slf4j
public class AutoAppApp extends Application<AutoAppConfig> {

    public static void main(final String[] args) throws Exception {
        new AutoAppApp().run(args);
    }

    @Override
    public String getName() {
        return "AutoApp";
    }

    @Override
    public void initialize(final Bootstrap<AutoAppConfig> bootstrap) {
        log.debug("Starting {}", getName());
        bootstrap.addBundle(GuiceBundle.builder()
            .printDiagnosticInfo()
            .enableAutoConfig(getClass().getPackage().getName()) // Auto Register stuff in our app package
            .dropwizardBundles(
                    new JdbiExceptionsBundle(),
                    DatabaseBundleFactory.buildFlyway(),
                    new ViewBundle<AutoAppConfig>() {
                        @Override
                        public Map<String, Map<String, String>> getViewConfiguration(AutoAppConfig config) {
                            return Map.of(
                                    "customfreemarker", Map.of(
                                            "strict_syntax", "true"
                                    )
                            );
                        }
                    }
//                    new AssetsBundle("/assets", "/", "index.html")

            )
            .bundles(
                    DatabaseBundleFactory.buildJdbi(),
                    SpaBundle.app("assets", "/assets", "/").build()
            )
            .modules(new AutoAppModule())
            .build());

        bootstrap.getObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public void run(final AutoAppConfig configuration,
                    final Environment environment) {
        // intentionally left blank
    }

}
