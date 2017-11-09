-- Table: clientes
DROP TABLE clientes cascade;

CREATE TABLE clientes
(
  codpessoa integer primary key,
  nome character varying(100) NOT NULL,
  empresa character varying(100),
  endereco character varying(100),
  numero character varying(10),
  bairro character varying(50),
  cidade character varying(100),
  UF varchar(2) default 'MG',
  flgativo char default 'S',
  telefone varchar(20),
  celular varchar(20),
  email varchar(100)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE clientes
  OWNER TO postgres;
