-- Table: itvendas

-- DROP TABLE itvendas;

CREATE TABLE itvendas
(
  nvenda integer NOT NULL,
  ncaixa character varying(3) NOT NULL,
  nitem integer NOT NULL,
  codpro integer,
  refere1 character varying(14),
  quanta1 numeric(15,3),
  precobruto numeric(15,3),
  precoespecial numeric(10,3),
  preco1 numeric(15,3),
  custo1 numeric(15,3),
  descricao character varying(50),
  vir_refere character varying(14),
  tipot character varying(1),
  alqitem numeric(5,2),
  cstitem character varying(3),
  quantadevol numeric(15,3),
  valimpbruto numeric(15,2),
  valimp numeric(15,2),
  flagretorno character varying(1),
  obsitem character varying(100),
  csosn character varying(3),
  codcfop character varying(4),
  baseicms numeric(15,2),
  valicms numeric(15,2),
  CONSTRAINT pk_itvendas PRIMARY KEY (nvenda, ncaixa, nitem),
  CONSTRAINT itvendas_codpro_fkey FOREIGN KEY (codpro)
      REFERENCES produtos (codpro) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE itvendas
  OWNER TO postgres;
