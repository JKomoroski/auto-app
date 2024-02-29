CREATE TABLE round
(
    id INT NOT NULL PRIMARY KEY
);

CREATE TABLE division
(
    id       INT NOT NULL PRIMARY KEY,
    round_id INT NOT NULL,
    FOREIGN KEY (round_id) REFERENCES round (id)
);

CREATE TABLE player
(
    id   INT  NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE division_result
(
    id        INT NOT NULL,
    round_id  INT NOT NULL,
    player_id INT NOT NULL,
    score     INT NOT NULL,
    FOREIGN KEY (round_id) REFERENCES round (id),
    FOREIGN KEY (player_id) REFERENCES player (id),
    PRIMARY KEY (id, round_id)
);
