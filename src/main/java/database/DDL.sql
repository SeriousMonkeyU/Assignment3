CREATE SCHEMA "slaughterhouse";

SET SCHEMA 'slaughterhouse';

CREATE TABLE IF NOT EXISTS Animal
(
    regNumber BIGINT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Package
(
    id BIGINT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS AnimalPackage
(
    packageID BIGINT REFERENCES Package (id),
    animalID BIGINT REFERENCES Animal (regNumber),
    PRIMARY KEY (animalID, packageID)
);