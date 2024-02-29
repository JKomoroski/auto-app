package ski.komoro.auto.player;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import java.util.UUID;
import ski.komoro.auto.Model.Player;

@Path("/players")
@Produces(MediaType.TEXT_HTML)
public class PlayerResource {

    @Inject
    private PlayerDao dao;

    @GET
    public PlayerView get() {
        return new PlayerView(dao.list());
    }

    @POST //TODO Figure out post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public PlayerView add(@FormParam("playerName") String playerName) {
        dao.createPlayer(new Player(UUID.randomUUID(), playerName, true));
        return new PlayerView(dao.list());
    }

    @DELETE //TODO Figure out delete
    public PlayerView deleteLastRound(@QueryParam("id") UUID id) {
        dao.deactivate(id);
        return new PlayerView(dao.list());
    }
}
