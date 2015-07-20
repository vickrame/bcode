DROP table IF EXISTS Personne;
--DROP table IF EXISTS Company;

CREATE TABLE Personne (
    id integer GENERATED ALWAYS AS IDENTITY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    PRIMARY KEY(id)
);


INSERT INTO Personne (nom, prenom) values('toto', 'kiki tu es ou');