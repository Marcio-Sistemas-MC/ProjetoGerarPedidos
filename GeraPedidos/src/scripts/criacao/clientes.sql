-- Table: clientes

DROP TABLE clientes;

CREATE TABLE clientes
(
  codpessoa integer NOT NULL,
  nome character varying(100) NOT NULL,
  uppernome character varying(100) NOT NULL,
  dta_admissao date,
  tipo character varying(1) NOT NULL,
  razaosocial character varying(100),
  cnpj character varying(14),
  inscest character varying(20),
  socio1 character varying(50),
  socio2 character varying(50),
  socio3 character varying(50),
  cpf character varying(11),
  rg character varying(20),
  inscprodutor character varying(14),
  estado_civ character varying(1),
  apelido character varying(100),
  naturalidade character varying(20),
  data_nasc date,
  conjuge character varying(50),
  filiacao_pai character varying(50),
  filiacao_mae character varying(50),
  localtrabalho character varying(50),
  telefonetrabalho character varying(20),
  renda numeric(15,2),
  logra_com character varying(40),
  num_com character varying(5),
  compl_com character varying(15),
  bairro character varying(40),
  codcidade integer NOT NULL,
  cep character varying(8),
  logra_dom character varying(40),
  num_dom character varying(5),
  compl_dom character varying(15),
  bairrodom character varying(40),
  codcidadedom integer,
  cepdom character varying(8),
  ativo character varying(1),
  email character varying(300),
  telefone character varying(20),
  celular character varying(20),
  pessoacontato character varying(20),
  tipoaliqicms integer,
  observacao character varying(1000),
  inclusaousuario integer,
  inclusaohorario timestamp without time zone,
  alteracaousuario integer,
  alteracaohorario timestamp without time zone,
  ultvenda date,
  proftrabalho character varying(25),
  dta_admtrabalho date,
  atrasodias numeric(18,3),
  atrasovalor numeric(18,2),
  CONSTRAINT clientes_pkey PRIMARY KEY (codpessoa)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE clientes
  OWNER TO postgres;
