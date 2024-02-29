package ski.komoro.auto.player;

import java.util.List;
import java.util.UUID;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import ski.komoro.auto.Model.Player;

@RegisterConstructorMapper(Player.class)
public interface PlayerDao {
        @SqlQuery("""
            select id, player_name, active
            from players
            where active = true
            order by player_name""")
        List<Player> list();

        @SqlUpdate("""
            INSERT INTO players (id, player_name, active) 
            VALUES (:id, :playerName, :active)""")
        void createPlayer(@BindMethods Player player);


        @SqlUpdate("""
            UPDATE players
            SET active = false
            WHERE id = :id""")
        void deactivate(UUID id);



    }
