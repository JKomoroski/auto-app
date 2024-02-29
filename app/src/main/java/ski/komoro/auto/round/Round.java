package ski.komoro.auto.round;

import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import ski.komoro.auto.Model.Group;

@RegisterConstructorMapper(Round.class)
record Round(
        int id,
        List<Group> groups
) {
}

