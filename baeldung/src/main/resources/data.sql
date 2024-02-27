CREATE TABLE PRODOTTO (
	idProdotto INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    prezzo DOUBLE,
    path VARCHAR(255),
    descrizione VARCHAR(2000),
    PRIMARY KEY (idProdotto)
);

INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('prova',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('jpa',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('html',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('query',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('optional',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('ricerca',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('javascript',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('node.js',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('h2',1.85,'provapath1','query per ricerca');
INSERT INTO PRODOTTO(NOME,PREZZO,PATH,DESCRIZIONE) VALUES ('mySql',1.85,'provapath1','query per ricerca');
