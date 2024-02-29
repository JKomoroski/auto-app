package ski.komoro.auto.round;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/rounds")
@Produces(MediaType.TEXT_HTML)
public class RoundResource {
    @Inject
    private RoundDao dao;

    @GET
    public RoundView getRound() {
        return new RoundView(dao.list());
    }

    @GET //TODO Figure out post
    @Path("/create")
    public RoundView addRound() {
        dao.addRound();
        return new RoundView(dao.list());
    }


    @GET //TODO Figure out delete
    @Path("/delete")
    public RoundView deleteLastRound() {
        dao.deleteLastRound();
        return new RoundView(dao.list());
    }
}
