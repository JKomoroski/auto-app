package ski.komoro.auto.views;


import com.google.auto.service.AutoService;
import freemarker.template.Version;
import io.dropwizard.views.common.ViewRenderer;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;

@AutoService(ViewRenderer.class)
public class CustomFVR extends FreemarkerViewRenderer implements ViewRenderer {

    public CustomFVR() {
        super(new Version(2, 3, 32));
    }

    @Override
    public String getConfigurationKey() {
        return "customfreemarker";
    }
}
