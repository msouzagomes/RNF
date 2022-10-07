CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.ConfigRnf (
  Id char(36) NOT NULL DEFAULT (uuid()),
  ConfigRnfId varchar(36) NOT NULL,
  DataInicio datetime DEFAULT NULL,
  DataFim datetime DEFAULT NULL,
  IdFilial varchar(36) DEFAULT NULL,
  MostrarPlaca tinyint(1) NOT NULL DEFAULT '1',
  MostrarCentroCusto tinyint(1) NOT NULL DEFAULT '1',
  AgruparNotaPor varchar(15) DEFAULT NULL,
  Ativo tinyint(1) NOT NULL DEFAULT '1',
  DataInclusao datetime NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.ConfigEc (
  Id char(36) NOT NULL DEFAULT (uuid()),
  configEcId varchar(36) DEFAULT NULL,
  EnvioAutomatico varchar(40) DEFAULT NULL,
  DataInicio datetime DEFAULT NULL,
  DataFim datetime DEFAULT NULL,
  EcId varchar(36) DEFAULT NULL,
  IdConfigRnf varchar(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKConfigEcId (IdConfigRnf),
  CONSTRAINT FKConfigEcId FOREIGN KEY (IdConfigRnf) REFERENCES RNFRoboEmissorNf.ConfigRnf (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.ConfiguracaoVeiculo (
  Id char(36) NOT NULL DEFAULT (uuid()),
  ConfiguracaoVeiculosId varchar(36) DEFAULT NULL,
  IdVeiculo varchar(36) DEFAULT NULL,
  IdConfigRnf char(36) NOT NULL,
  PRIMARY KEY (Id),
  KEY FKConfiguracaoVeiculoIdConfigRnf (IdConfigRnf),
  CONSTRAINT FKConfiguracaoVeiculoIdConfigRnf FOREIGN KEY (IdConfigRnf) REFERENCES RNFRoboEmissorNf.ConfigRnf (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Nf (
  Id char(36) NOT NULL DEFAULT (uuid()),
  NfsId varchar(36) DEFAULT NULL,
  AmbienteEmissao varchar(20) DEFAULT NULL,
  NaturezaOperacao varchar(40) DEFAULT NULL,
  TipoOperacao varchar(10) DEFAULT NULL,
  Finalidade varchar(10) DEFAULT NULL,
  ConsumidorFinal tinyint(1) NOT NULL DEFAULT '1',
  IndicadorPresencaConsumidor varchar(20) DEFAULT NULL,
  IdConfigRnf char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKNfIdConfigRnf (IdConfigRnf),
  CONSTRAINT FKNfIdConfigRnf FOREIGN KEY (IdConfigRnf) REFERENCES RNFRoboEmissorNf.ConfigRnf (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Cliente (
  Id char(36) NOT NULL DEFAULT (uuid()),
  TipoPessoa varchar(10) DEFAULT NULL,
  IndicadorContribuinteICMS varchar(20) DEFAULT NULL,
  Nome varchar(100) DEFAULT NULL,
  Email varchar(100) DEFAULT NULL,
  Telefone varchar(15) DEFAULT NULL,
  CpfCnpj varchar(15) DEFAULT NULL,
  IdNf char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKClienteIdNf (IdNf),
  CONSTRAINT FKClienteIdNf FOREIGN KEY (IdNf) REFERENCES RNFRoboEmissorNf.Nf (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Endereco (
  Id char(36) NOT NULL DEFAULT (uuid()),
  Uf varchar(2) DEFAULT NULL,
  Cidade varchar(20) DEFAULT NULL,
  Logradouro varchar(100) DEFAULT NULL,
  Numero varchar(10) DEFAULT NULL,
  Complemento varchar(20) DEFAULT NULL,
  Bairro varchar(40) DEFAULT NULL,
  Cep varchar(10) DEFAULT NULL,
  EnviarPorEmail tinyint(1) NOT NULL DEFAULT '1',
  IdCliente char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKEnderecoIdCliente (IdCliente),
  CONSTRAINT FKEnderecoIdCliente FOREIGN KEY (IdCliente) REFERENCES RNFRoboEmissorNf.Cliente (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Item (
  Id char(36) NOT NULL DEFAULT (uuid()),
  Cfop varchar(10) DEFAULT NULL,
  Codigo varchar(10) DEFAULT NULL,
  Descricao varchar(100) DEFAULT NULL,
  Ncm varchar(10) DEFAULT NULL,
  Quantidade int DEFAULT NULL,
  UnidadeMedida varchar(5) DEFAULT NULL,
  ValorUnitario int DEFAULT NULL,
  Frete int DEFAULT NULL,
  OutrasDespesas int DEFAULT NULL,
  IdNf char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKItemIdNf (IdNf),
  CONSTRAINT FKItemIdNf FOREIGN KEY (IdNf) REFERENCES RNFRoboEmissorNf.Nf (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Combustivel (
  Id char(36) NOT NULL DEFAULT (uuid()),
  CodigoProdutoANP varchar(10) DEFAULT NULL,
  PercentualGasNatural varchar(10) DEFAULT NULL,
  Codif varchar(10) DEFAULT NULL,
  QuantidadeFaturadaTempAmbiente int DEFAULT NULL,
  UfConsumo varchar(2) DEFAULT NULL,
  IdItem char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKCombustivelIdItem (IdItem),
  CONSTRAINT FKCombustivelIdItem FOREIGN KEY (IdItem) REFERENCES RNFRoboEmissorNf.Item (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Imposto (
  Id char(36) NOT NULL DEFAULT (uuid()),
  TributoSimplificadoPercentual double DEFAULT NULL,
  Fonte varchar(20) DEFAULT NULL,
  IcmsOrigem int DEFAULT NULL,
  IcmsSituacaoTributaria varchar(4) DEFAULT NULL,
  PisSituacaoTributaria varchar(4) DEFAULT NULL,
  CofinsSituacaoTributaria varchar(4) DEFAULT NULL,
  IdItem char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKImpostoId (IdItem),
  CONSTRAINT FKImpostoId FOREIGN KEY (IdItem) REFERENCES RNFRoboEmissorNf.Item (Id)
);

CREATE TABLE IF NOT EXISTS RNFRoboEmissorNf.Cide (
  Id char(36) NOT NULL DEFAULT (uuid()),
  QuantidadeBaseCalculo int DEFAULT NULL,
  ValorAliquota int DEFAULT NULL,
  Valor int DEFAULT NULL,
  IdCombustivel char(36) DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKCideIdCombustivel (IdCombustivel),
  CONSTRAINT FKCideIdCombustivel FOREIGN KEY (IdCombustivel) REFERENCES RNFRoboEmissorNf.Combustivel (Id)
);

ALTER TABLE RNFRoboEmissorNf.ConfigRnf ADD StatusEnvio varchar(15) NULL;