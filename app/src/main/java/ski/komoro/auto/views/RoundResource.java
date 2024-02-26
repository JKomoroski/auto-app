package ski.komoro.auto.views;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jdbi.v3.core.Jdbi;
import ski.komoro.auto.views.RoundView.Round;

@Path("/rounds")
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_JSON)
public class RoundResource {
    @Inject
    private Jdbi jdbi;

    @GET
    public RoundView getRound() {
        return new RoundView(new Round(1, "a,b,c"));
    }

}
