-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 02/12/2018 às 21:51
-- Versão do servidor: 10.1.37-MariaDB
-- Versão do PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `tracker_console`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `AmbienteProjeto`
--

CREATE TABLE `AmbienteProjeto` (
  `id` bigint(20) NOT NULL,
  `habFuncExp` int(11) DEFAULT NULL,
  `habTecExp` int(11) DEFAULT NULL,
  `orcamento` int(11) DEFAULT NULL,
  `tempo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `AtivosDevices`
--

CREATE TABLE `AtivosDevices` (
  `id` bigint(20) NOT NULL,
  `ambiente` int(11) DEFAULT NULL,
  `complexAtivo` int(11) DEFAULT NULL,
  `gerenciaLocalDados` int(11) DEFAULT NULL,
  `heteroAtivo` int(11) DEFAULT NULL,
  `logNegLocal` int(11) DEFAULT NULL,
  `numAtivos` int(11) DEFAULT NULL,
  `processLocalEven` int(11) DEFAULT NULL,
  `requiTempReal` int(11) DEFAULT NULL,
  `restriAtualHW` int(11) DEFAULT NULL,
  `restriAtualSW` int(11) DEFAULT NULL,
  `supriEnergia` int(11) DEFAULT NULL,
  `tempVidaAtivo` int(11) DEFAULT NULL,
  `valorAtiInd` int(11) DEFAULT NULL,
  `valorEconAtiAno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ComunicacaoConectividade`
--

CREATE TABLE `ComunicacaoConectividade` (
  `id` bigint(20) NOT NULL,
  `larguraBandaLocal` int(11) DEFAULT NULL,
  `larguraBandaRemota` int(11) DEFAULT NULL,
  `latenciaMaxLocal` int(11) DEFAULT NULL,
  `latenciaMaxRemota` int(11) DEFAULT NULL,
  `tecnologiaLocal` int(11) DEFAULT NULL,
  `tecnologiaRemota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Empresa`
--

CREATE TABLE `Empresa` (
  `id` bigint(20) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuarioResponsavel_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `PadraoReqRegulatorio`
--

CREATE TABLE `PadraoReqRegulatorio` (
  `id` bigint(20) NOT NULL,
  `funcionalPad` int(11) DEFAULT NULL,
  `industriaEsp` int(11) DEFAULT NULL,
  `regionalEsp` int(11) DEFAULT NULL,
  `tecnicoPad` int(11) DEFAULT NULL,
  `tecnologiaEsp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Permissao`
--

CREATE TABLE `Permissao` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Permissao`
--

INSERT INTO `Permissao` (`id`, `nome`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'EMPRESA'),
(3, 'VISUALIZADOR');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Questionario`
--

CREATE TABLE `Questionario` (
  `id` bigint(20) NOT NULL,
  `dtCriacao` date NOT NULL,
  `dtResposta` date DEFAULT NULL,
  `ambienteProjeto_id` bigint(20) NOT NULL,
  `ativosDevices_id` bigint(20) NOT NULL,
  `comunicacaoConectividade_id` bigint(20) NOT NULL,
  `empresa_id` bigint(20) NOT NULL,
  `padraoReqRegulatorio_id` bigint(20) NOT NULL,
  `servicoBackend_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ServicoBackend`
--

CREATE TABLE `ServicoBackend` (
  `id` bigint(20) NOT NULL,
  `analytics` int(11) DEFAULT NULL,
  `complexNegocio` int(11) DEFAULT NULL,
  `estrategiaApliacacao` int(11) DEFAULT NULL,
  `integraBackend` int(11) DEFAULT NULL,
  `mudancaSchema` int(11) DEFAULT NULL,
  `variedadeDados` int(11) DEFAULT NULL,
  `volumDadosDia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Usuario`
--

CREATE TABLE `Usuario` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `permissao_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Usuario`
--

INSERT INTO `Usuario` (`id`, `email`, `nome`, `senha`, `permissao_id`) VALUES
(2, 'admin', 'Administrador', 'admin', 1);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `AmbienteProjeto`
--
ALTER TABLE `AmbienteProjeto`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `AtivosDevices`
--
ALTER TABLE `AtivosDevices`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `ComunicacaoConectividade`
--
ALTER TABLE `ComunicacaoConectividade`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Empresa`
--
ALTER TABLE `Empresa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK26DD869608B29C2` (`usuarioResponsavel_id`);

--
-- Índices de tabela `PadraoReqRegulatorio`
--
ALTER TABLE `PadraoReqRegulatorio`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Permissao`
--
ALTER TABLE `Permissao`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices de tabela `Questionario`
--
ALTER TABLE `Questionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKFF8EFE1DFF9DEF6E` (`comunicacaoConectividade_id`),
  ADD KEY `FKFF8EFE1D203F4986` (`empresa_id`),
  ADD KEY `FKFF8EFE1DF044878E` (`servicoBackend_id`),
  ADD KEY `FKFF8EFE1DA5D14A46` (`ambienteProjeto_id`),
  ADD KEY `FKFF8EFE1DAB94A90E` (`padraoReqRegulatorio_id`),
  ADD KEY `FKFF8EFE1DE37B9E66` (`ativosDevices_id`);

--
-- Índices de tabela `ServicoBackend`
--
ALTER TABLE `ServicoBackend`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `FK5B4D8B0EFE0B55C6` (`permissao_id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `AmbienteProjeto`
--
ALTER TABLE `AmbienteProjeto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `AtivosDevices`
--
ALTER TABLE `AtivosDevices`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `ComunicacaoConectividade`
--
ALTER TABLE `ComunicacaoConectividade`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Empresa`
--
ALTER TABLE `Empresa`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `PadraoReqRegulatorio`
--
ALTER TABLE `PadraoReqRegulatorio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Permissao`
--
ALTER TABLE `Permissao`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `Questionario`
--
ALTER TABLE `Questionario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `ServicoBackend`
--
ALTER TABLE `ServicoBackend`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Empresa`
--
ALTER TABLE `Empresa`
  ADD CONSTRAINT `FK26DD869608B29C2` FOREIGN KEY (`usuarioResponsavel_id`) REFERENCES `Usuario` (`id`);

--
-- Restrições para tabelas `Questionario`
--
ALTER TABLE `Questionario`
  ADD CONSTRAINT `FKFF8EFE1D203F4986` FOREIGN KEY (`empresa_id`) REFERENCES `Empresa` (`id`),
  ADD CONSTRAINT `FKFF8EFE1DA5D14A46` FOREIGN KEY (`ambienteProjeto_id`) REFERENCES `AmbienteProjeto` (`id`),
  ADD CONSTRAINT `FKFF8EFE1DAB94A90E` FOREIGN KEY (`padraoReqRegulatorio_id`) REFERENCES `PadraoReqRegulatorio` (`id`),
  ADD CONSTRAINT `FKFF8EFE1DE37B9E66` FOREIGN KEY (`ativosDevices_id`) REFERENCES `AtivosDevices` (`id`),
  ADD CONSTRAINT `FKFF8EFE1DF044878E` FOREIGN KEY (`servicoBackend_id`) REFERENCES `ServicoBackend` (`id`),
  ADD CONSTRAINT `FKFF8EFE1DFF9DEF6E` FOREIGN KEY (`comunicacaoConectividade_id`) REFERENCES `ComunicacaoConectividade` (`id`);

--
-- Restrições para tabelas `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FK5B4D8B0EFE0B55C6` FOREIGN KEY (`permissao_id`) REFERENCES `Permissao` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
