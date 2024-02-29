CREATE TABLE players (
    id UUID PRIMARY KEY,
    player_name TEXT NOT NULL
);

CREATE INDEX players_name_idx ON players (player_name);
alter table players add active boolean default true;
