CREATE TABLE palabra (
                         idpalabra INT AUTO_INCREMENT PRIMARY KEY ,
                         palabra   VARCHAR(255)

);

CREATE TABLE partida (
                         idpartida INT NOT NULL,
                         word      VARCHAR(255),
                         n_try     INT,
                         score     INT,
                         PRIMARY KEY (idpartida)
);

CREATE TABLE jugador (
                         idjugador         INT AUTO_INCREMENT PRIMARY KEY,
                         user              VARCHAR(45) NOT NULL,
                         score             INT,
                         avatarimg         VARCHAR(255),
                         partida_idpartida INT,
                         FOREIGN KEY (partida_idpartida) REFERENCES partida (idpartida) ON DELETE CASCADE
);

CREATE TABLE equipo (
                        idequipo          INT NOT NULL,
                        name              VARCHAR(255) NOT NULL,
                        score             INT,
                        badge             VARCHAR(255),
                        jugador_idjugador INT NOT NULL,
                        PRIMARY KEY (idequipo),
                        FOREIGN KEY (jugador_idjugador) REFERENCES jugador (idjugador) ON DELETE CASCADE
);

CREATE TABLE juego (
                       idjuego           INT NOT NULL,
                       description       VARCHAR(255),
                       difficulty_J      VARCHAR(255),
                       max_tries          INT,
                       partida_idpartida INT NOT NULL,
                       PRIMARY KEY (idjuego),
                       FOREIGN KEY (partida_idpartida) REFERENCES partida (idpartida) ON DELETE CASCADE
);

CREATE TABLE s_p (
                     juego_idjuego     INT NOT NULL,
                     palabra_idpalabra INT NOT NULL,
                     difficulty_P      VARCHAR(255),
                     PRIMARY KEY (juego_idjuego, palabra_idpalabra),
                     FOREIGN KEY (juego_idjuego) REFERENCES juego (idjuego) ON DELETE CASCADE,
                     FOREIGN KEY (palabra_idpalabra) REFERENCES palabra (idpalabra) ON DELETE CASCADE
);

-- Inserciones para la tabla Palabra
INSERT INTO palabra (palabra) VALUES
                                  ('a'),
                                  ('aba'),
                                  ('abaá'),
                                  ('ababillarse'),
                                  ('ababol'),
                                  ('abacá'),
                                  ('abacal'),
                                  ('abacalera'),
                                  ('abacalero'),
                                  ('abacera'),
                                  ('abacería'),
                                  ('abacero'),
                                  ('abacial'),
                                  ('abacora'),
                                  ('abacorar'),
                                  ('abad'),
                                  ('abada'),
                                  ('abadejo'),
                                  ('abadenga'),
                                  ('abadengo'),
                                  ('abadernar'),
                                  ('abadesa'),
                                  ('abadí'),
                                  ('abadía'),
                                  ('abadiado'),
                                  ('abadiato'),
                                  ('ab aeterno'),
                                  ('abajadero'),
                                  ('abajamiento'),
                                  ('abajar');

INSERT INTO palabra (palabra) VALUES
                                  ('b'),
                                  ('baalita'),
                                  ('baasismo'),
                                  ('baasista'),
                                  ('baazismo'),
                                  ('baazista'),
                                  ('baba'),
                                  ('babaco'),
                                  ('babada'),
                                  ('babadero'),
                                  ('babador'),
                                  ('babaero'),
                                  ('babahoyense'),
                                  ('babanca'),
                                  ('babatel'),
                                  ('babaza'),
                                  ('babazorra'),
                                  ('babazorro'),
                                  ('babear'),
                                  ('babel'),
                                  ('babélica'),
                                  ('babélico'),
                                  ('babeo'),
                                  ('babera'),
                                  ('babero'),
                                  ('baberol'),
                                  ('babi'),
                                  ('babiana'),
                                  ('babiano'),
                                  ('babieca');
INSERT INTO palabra (palabra) VALUES
                                  ('c'),
                                  ('ca'),
                                  ('caacupeña'),
                                  ('caacupeño'),
                                  ('caaguaceña'),
                                  ('caaguaceño'),
                                  ('caaminí'),
                                  ('caazapeña'),
                                  ('caazapeño'),
                                  ('cabadura'),
                                  ('cabal'),
                                  ('cábala'),
                                  ('cabalar'),
                                  ('cabalera'),
                                  ('cabalero'),
                                  ('cabalgada'),
                                  ('cabalgador'),
                                  ('cabalgadora'),
                                  ('cabalgadura'),
                                  ('cabalgamiento'),
                                  ('cabalgar'),
                                  ('cabalgata'),
                                  ('cabalgazón'),
                                  ('cabalhuste'),
                                  ('cabalidad'),
                                  ('cabalina'),
                                  ('cabalino'),
                                  ('cabalista'),
                                  ('cabalística'),
                                  ('cabalístico');




-- Inserciones para la tabla Partida
INSERT INTO partida (idpartida, word, n_try, score) VALUES
                                                        (1, 'Palabra secreta', 3, 100),
                                                        (2, 'Otra palabra', 5, 80),
                                                        (3, 'Palabra difícil', 2, 120);

-- Inserciones para la tabla Jugador
INSERT INTO jugador (idjugador, user, score, avatarimg, partida_idpartida) VALUES
                                                                               (1, 'Usuario1', 150, 'avatar1.jpg', 1),
                                                                               (2, 'Usuario2', 120, 'avatar2.jpg', 1),
                                                                               (3, 'Usuario3', 90, 'avatar3.jpg', 2);

-- Inserciones para la tabla Equipo
INSERT INTO equipo (idequipo, name, score, badge, jugador_idjugador) VALUES
                                                                         (1, 'Equipo1', 300, 'badge1.png', 1),
                                                                         (2, 'Equipo2', 250, 'badge2.png', 2),
                                                                         (3, 'Equipo3', 200, 'badge3.png', 3);

-- Inserciones para la tabla Juego
INSERT INTO juego (idjuego, description, difficulty_J, max_tries, partida_idpartida) VALUES
                                                                                         (1, 'Juego1', 'Fácil', 10, 1),
                                                                                         (2, 'Juego2', 'Intermedio', 8, 2),
                                                                                         (3, 'Juego3', 'Difícil', 5, 3);

-- Inserciones para la tabla S_P
INSERT INTO s_p (juego_idjuego, palabra_idpalabra, difficulty_P) VALUES
                                                                     (1, 1, 'Fácil'),
                                                                     (1, 2, 'Fácil'),
                                                                     (2, 2, 'Intermedio'),
                                                                     (3, 3, 'Difícil');

