﻿-- Table: cvendas

-- DROP TABLE cvendas;

CREATE TABLE cvendas
(
  nvenda integer NOT NULL,
  ncaixa character varying(3) NOT NULL,
  data date,
  horario character varying(5),
  turno character varying(4),
  flag_tipomov integer,
  cod_cliente integer,
  qtd_prod numeric(15,3),
  total_cust numeric(15,2),
  total_bruto numeric(15,2),
  desconto_itens numeric(15,2),
  total_prod numeric(15,2),
  valorbrutovenda numeric(15,2),
  totjurosforma numeric(15,2),
  desconto_v numeric(15,2),
  por_desc numeric(9,4),
  acresc_v numeric(15,2),
  por_acres numeric(15,2),
  valor numeric(15,2),
  valor_pg numeric(15,2),
  troco numeric(15,2),
  nomecli character varying(50),
  cnpj character varying(14),
  cpf character varying(11),
  inscricao character varying(20),
  operador character varying(15),
  codusuario integer,
  codvendedor integer,
  fone character varying(20),
  codcondpgto integer,
  vencimento date,
  codentregador integer,
  bairro character varying(40),
  cep character varying(8),
  ref_ent character varying(50),
  flag_cancelado character varying(1),
  canceladata timestamp without time zone,
  cancelausuario integer,
  nomedependente character varying(50),
  seqnf integer,
  obsvenda character varying(1000),
  pesocalc integer,
  pesoreal integer,
  endere_logra character varying(40),
  endere_num character varying(5),
  endere_compl character varying(15),
  codcidade integer,
  endere character varying(50),
  uf character varying(2),
  cidade character varying(50),
  cancelamotivo character varying(100),
  logdatahoraalt timestamp without time zone,
  devolvincnvenda integer,
  devolvincncaixa character varying(3),
  codautdesconto integer,
  trocochtroco numeric(15,2),
  flagimpresso character varying(1) DEFAULT 'N'::character varying,
  flag_tipomovorig integer,
  qtdeitens numeric(15,3),
  totalbaseicms numeric(15,2),
  totalicms numeric(15,2),
  entregadom character varying(1) DEFAULT 'N'::character varying,
  nfcenumero integer,
  nfcetipoemis integer,
  nfceambiente integer,
  nfcedhcont character varying(19),
  nfcejustcont character varying(256),
  nfcechaveacesso character varying(44),
  nfcenumrecibo character varying(30),
  nfcesituacao integer,
  nfcenumprotocolo character varying(30),
  nfcecstat character varying(3),
  nfceretorno character varying(300),
  nfcenumprotcanc character varying(30),
  CONSTRAINT pk_cvendas PRIMARY KEY (nvenda, ncaixa),
  CONSTRAINT cvendas_cod_cliente_fkey FOREIGN KEY (cod_cliente)
      REFERENCES clientes (codpessoa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT unq_cvendas UNIQUE (nvenda)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cvendas
  OWNER TO postgres;