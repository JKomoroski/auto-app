package ski.komoro.auto.round;


import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterConstructorMapper(Round.class)
public interface RoundDao {

    @SqlQuery("""
            select id
            from round
            order by id desc""")
    List<Round> list();

    @SqlUpdate("""
            INSERT INTO round DEFAULT VALUES""")
    void addRound();


    @SqlUpdate("""
            DELETE from round where id = (select max(id) from round)""")
    void deleteLastRound();


}
