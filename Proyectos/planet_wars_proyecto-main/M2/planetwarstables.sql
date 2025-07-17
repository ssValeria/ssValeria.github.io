-- planet stats
CREATE TABLE planet_stats (
    planet_id NUMBER PRIMARY KEY NOT NULL,
    name VARCHAR2(100),
    resource_metal_amount NUMBER,
    resource_deuterium_amount NUMBER,
    technology_defense_level NUMBER,
    technology_attack_level NUMBER,
    battlescounter NUMBER,
    missile_launcher_remaining NUMBER,
    ion_cannon_remaining NUMBER,
    plasma_cannon_remaining NUMBER,
    light_hunter_remaining NUMBER,
    heavy_hunter_remaining NUMBER,
    battleship_remaining NUMBER,
    armored_ship_remaining NUMBER
);
-- battle_stats

CREATE TABLE battle_stats (
    planet_id INT,
    num_battle INT NOT NULL,
    resource_metals_adquired NUMBER,
    resource_deuterium_adquired NUMBER,
    PRIMARY KEY (planet_id, num_battle), -- Clave primaria compuesta
    FOREIGN KEY (planet_id) REFERENCES planet_stats(planet_id)
);
CREATE TABLE battle_log (

    planet_id NUMBER,
    num_battle NUMBER,
    num_line NUMBER,
    log_entry VARCHAR2(255),
    PRIMARY KEY (planet_id, num_battle, num_line),
    FOREIGN KEY (planet_id, num_battle) REFERENCES battle_stats(planet_id, num_battle)
);
CREATE TABLE planet_battle_defense (
    planet_id NUMBER,
    num_battle NUMBER,
    misile_launcher_built NUMBER,
    missile_launcher_destroyed NUMBER,
    ion_cannon_built NUMBER,
    plasma_cannon_built NUMBER,
    PRIMARY KEY (planet_id, num_battle),
    FOREIGN KEY (planet_id, num_battle) REFERENCES battle_stats(planet_id, num_battle)
);

CREATE TABLE planet_battle_army(
    planet_id NUMBER,
    num_battle NUMBER,
    light_hunter_build NUMBER,
    light_hunter_destroyed NUMBER,
    heavy_hunter_built NUMBER,
    heavy_hunter_destroyed NUMBER,
    battleship_built NUMBER,
    battleship_destroyed NUMBER,
    armored_ship_built NUMBER,
    armored_ship_destroyed NUMBER,
    PRIMARY KEY (planet_id, num_battle),
    FOREIGN KEY (planet_id, num_battle) REFERENCES battle_stats(planet_id, num_battle)
);

-- tabla enemy_army
CREATE TABLE  enemy_army(
planet_id NUMBER,
num_battle NUMBER,
light_hunter_threat NUMBER,
light_hunter_destroyed NUMBER,
heavy_hunter_threat NUMBER,
heavy_hunter_destroyed NUMBER,
armored_ship_threat NUMBER,
armored_ship_destroyed NUMBER,
PRIMARY KEY (planet_id, num_battle)
);