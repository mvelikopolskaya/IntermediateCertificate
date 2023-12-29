DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE IF NOT EXISTS human_friends;
USE human_friends;

CREATE TABLE IF NOT EXISTS domestic_animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_type CHAR(30)
);

INSERT INTO domestic_animals(animal_type)
VALUES
('cat'),
('dog'),
('hamster');

CREATE TABLE IF NOT EXISTS pack_animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_type CHAR(30)
);

INSERT INTO pack_animals(animal_type)
VALUES
('horse'),
('camel'),
('donkey');

CREATE TABLE IF NOT EXISTS cat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100),
    domestic_animals_id INT,
    FOREIGN KEY (domestic_animals_id)  REFERENCES domestic_animals(id)
);

CREATE TABLE IF NOT EXISTS dog (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100),
    domestic_animals_id INT,
    FOREIGN KEY (domestic_animals_id)  REFERENCES domestic_animals(id)
);

CREATE TABLE IF NOT EXISTS hamster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100),
    domestic_animals_id INT,
    FOREIGN KEY (domestic_animals_id)  REFERENCES domestic_animals(id)
);

CREATE TABLE IF NOT EXISTS horse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100),
    pack_animals_id INT,
    FOREIGN KEY (pack_animals_id)  REFERENCES pack_animals(id)
);

CREATE TABLE IF NOT EXISTS camel (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100),
    pack_animals_id INT,
    FOREIGN KEY (pack_animals_id)  REFERENCES pack_animals(id)
);

CREATE TABLE IF NOT EXISTS donkey (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100),
    pack_animals_id INT,
    FOREIGN KEY (pack_animals_id)  REFERENCES pack_animals(id)
);

INSERT INTO cat(animal_name, date_of_birth, commands)
VALUES
('Whiskers', '2019-05-15',	'Sit, Pounce'),
('Smudge', '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', '2020-06-30', 'Meow, Scratch, Jump');
    
INSERT INTO dog(animal_name, date_of_birth, commands)
VALUES
('Fido', '2020-01-01',	'Sit, Stay, Fetch'),
('Buddy', '2018-12-10','Sit, Paw, Bark'),
('Bella', '2019-11-11', 'Sit, Stay, Roll');

INSERT INTO hamster(animal_name, date_of_birth, commands)
VALUES
('Hammy', '2021-03-10', 'Roll, Hide'),
('Peanut', '2021-08-01',	'Roll, Spin');

INSERT INTO horse(animal_name, date_of_birth, commands)
VALUES
('Thunder', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', '2014-05-05', 'Trot, Canter'),
('Blaze', '2016-02-29',	'Trot, Jump, Gallop');

INSERT INTO camel(animal_name, date_of_birth, commands)
VALUES
('Sandy', '2016-11-03', 'Walk, Carry Load'),
('Dune', '2018-12-12', 'Walk, Sit'),
('Sahara', '2015-08-14', 'Walk, Run');

INSERT INTO donkey(animal_name, date_of_birth, commands)
VALUES
('Eeyore', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', '2019-01-23', 'Walk, Bray, Kick');

TRUNCATE TABLE camel;

INSERT INTO horse (animal_name, date_of_birth, commands)
SELECT animal_name, date_of_birth, commands
FROM donkey;

RENAME TABLE horse TO horse_and_donkey;
-- SELECT * FROM horse_and_donkey;

CREATE TABLE IF NOT EXISTS young_animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    date_of_birth DATE,
    commands CHAR(100)
);

INSERT INTO young_animal (animal_name, date_of_birth, commands)
SELECT animal_name, date_of_birth, commands FROM cat
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) > 1 AND TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) < 3
UNION ALL
SELECT animal_name, date_of_birth, commands FROM dog
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) > 1 AND TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) < 3
UNION ALL
SELECT animal_name, date_of_birth, commands FROM hamster
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) > 1 AND TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) < 3
UNION ALL
SELECT  animal_name, date_of_birth, commands FROM horse_and_donkey
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) > 1 AND TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) < 3;

SELECT * FROM young_animal;