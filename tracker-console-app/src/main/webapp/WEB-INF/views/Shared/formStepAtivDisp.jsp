<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row subtitulo">
    <h3><fmt:message key="message.ativoDispositivo.label"/></h3>
</div>
<form:errors path="ativosDevicesForm" cssClass="alert-danger row" element="div" />
<section>
    <div class="row">
        <div class="borda-solida text-center">
            <h4>Geral</h4>
        </div>
        <div class="col-xs-6">
            <!--Inicio Numero de ativos-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.numAtivos">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.numAtivos"><fmt:message key="message.ativoDispositivo.geral.numAtivo.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.numAtivos" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.geral.numAtivo.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.numAtivos" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Fim Numero de ativos-->
            <!--Inicio Valor do Ativo Individual-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.valorAtiInd">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.valorAtiInd"><fmt:message key="message.ativoDispositivo.geral.valorAtiInd.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.valorAtiInd" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.geral.valorAtiInd.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.valorAtiInd" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Fim Valor do Ativo Individual-->
            <!--Inicio Valor econômico adicionado por ativo indiv./ano-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.valorEconAtiAno">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.valorEconAtiAno"><fmt:message key="message.ativoDispositivo.geral.valorEconAtiAno.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.valorEconAtiAno" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.geral.valorEconAtiAno.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.valorEconAtiAno" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Fim Valor econômico adicionado por ativo indiv./ano-->
        </div>
        <div class="col-xs-6">
            <!--Inicio Perspectiva de Integração-->
                <div class="row">
                    <spring:bind path="ativosDevicesForm.complexAtivo">
                        <div class="form-group ">
                            <form:label path="ativosDevicesForm.complexAtivo"><fmt:message key="message.ativoDispositivo.geral.complexAtivo.label"/>:</form:label>
                            <c:forEach var = "i" begin = "1" end = "4">
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="ativosDevicesForm.complexAtivo" value="${i}"/>
                                        <fmt:message key="message.ativoDispositivo.geral.complexAtivo.${i}"/>
                                    </label>
                                </div>
                            </c:forEach>
                            <div>
                                <form:errors path="ativosDevicesForm.complexAtivo" class="${status.error ? 'alert-danger' : ''}" />
                            </div>
                        </div>
                    </spring:bind>
                </div>
                <!--Fim Perspectiva de Integração-->
                <!--Inicio Perspectiva de Integração (inc. versões e variantes)-->
                <div class="row">
                    <spring:bind path="ativosDevicesForm.heteroAtivo">
                        <div class="form-group ">
                            <form:label path="ativosDevicesForm.heteroAtivo"><fmt:message key="message.ativoDispositivo.geral.heteroAtivo.label"/>:</form:label>
                            <c:forEach var = "i" begin = "1" end = "4">
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="ativosDevicesForm.heteroAtivo" value="${i}"/>
                                        <fmt:message key="message.ativoDispositivo.geral.heteroAtivo.${i}"/>
                                    </label>
                                </div>
                            </c:forEach>
                            <div>
                                <form:errors path="ativosDevicesForm.heteroAtivo" class="${status.error ? 'alert-danger' : ''}" />
                            </div>
                        </div>
                    </spring:bind>
                </div>
            <!--Perspectiva de Integração (inc. versões e variantes)-->
        </div>
    </div>
</section>
<section>
    <div class="row sessao-color">
        <div class="borda-solida text-center">
            <h4>Poder de Processamento</h4>
        </div>
        <div class="col-xs-6">
            <!--Lógica de negócio local-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.logNegLocal">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.logNegLocal"><fmt:message key="message.ativoDispositivo.poderProcess.logNegLocal.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.logNegLocal" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.poderProcess.logNegLocal.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.logNegLocal" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Lógica de negócio local-->
            <!--Processamento local de evento-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.processLocalEven">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.processLocalEven"><fmt:message key="message.ativoDispositivo.poderProcess.processLocalEven.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.processLocalEven" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.poderProcess.processLocalEven.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.processLocalEven" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Processamento local de evento-->
        </div>
        <div class="col-xs-6">
            <!--Requisitos de tempo real-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.requiTempReal">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.requiTempReal"><fmt:message key="message.ativoDispositivo.poderProcess.requiTempReal.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.requiTempReal" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.poderProcess.requiTempReal.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.requiTempReal" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Requisitos de tempo real-->
            <!--Gerenciamento local de dados-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.gerenciaLocalDados">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.gerenciaLocalDados"><fmt:message key="message.ativoDispositivo.poderProcess.gerenciaLocalDados.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.gerenciaLocalDados" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.poderProcess.gerenciaLocalDados.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.gerenciaLocalDados" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Gerenciamento local de dados-->
        </div>
    </div>
</section>
<section>
    <div class="row">
        <div class="borda-solida text-center">
            <h4>Outros requisitos de HW</h4>
        </div>
        <div class="col-xs-6">
            <!--Suprimento de energia-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.supriEnergia">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.supriEnergia"><fmt:message key="message.ativoDispositivo.outroRequisiHW.supriEnergia.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.supriEnergia" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.outroRequisiHW.supriEnergia.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.supriEnergia" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Suprimento de energia-->
        </div>
        <div class="col-xs-6">
            <!--Ambiente-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.ambiente">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.ambiente"><fmt:message key="message.ativoDispositivo.outroRequisiHW.ambiente.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.ambiente" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.outroRequisiHW.ambiente.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.ambiente" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Ambiente-->
        </div>
    </div>
</section>
<section>
    <div class="row sessao-color">
        <div class="borda-solida text-center">
            <h4>Gestão do Ciclo de Vida</h4>
        </div>
        <div class="col-xs-6">
            <!--Tempo de vida projetado para o ativo-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.tempVidaAtivo">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.tempVidaAtivo"><fmt:message key="message.ativoDispositivo.gestaoCicloVida.tempVidaAtivo.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.tempVidaAtivo" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.gestaoCicloVida.tempVidaAtivo.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.tempVidaAtivo" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Tempo de vida projetado para o ativo-->
            <!--Restrições para atualização de HW-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.restriAtualHW">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.restriAtualHW"><fmt:message key="message.ativoDispositivo.gestaoCicloVida.restriAtualHW.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.restriAtualHW" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.gestaoCicloVida.restriAtualHW.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.restriAtualHW" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Restrições para atualização de HW-->
        </div>
        <div class="col-xs-6">
            <!--Restrições para atualização de SW-->
            <div class="row">
                <spring:bind path="ativosDevicesForm.restriAtualSW">
                    <div class="form-group ">
                        <form:label path="ativosDevicesForm.restriAtualSW"><fmt:message key="message.ativoDispositivo.gestaoCicloVida.restriAtualSW.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ativosDevicesForm.restriAtualSW" value="${i}"/>
                                    <fmt:message key="message.ativoDispositivo.gestaoCicloVida.restriAtualSW.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ativosDevicesForm.restriAtualSW" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Restrições para atualização de HW-->
        </div>
    </div>
</section>