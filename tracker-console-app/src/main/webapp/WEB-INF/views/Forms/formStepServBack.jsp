<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row subtitulo">
    <h3><fmt:message key="message.servicoBackend.label"/></h3>
</div>
<form:errors path="servicoBackendForm" cssClass="alert-danger row" element="div" />
<section>
    <div class="row">
        <div class="borda-solida text-center">
            <h4>Geral</h4>
        </div>
        <form:hidden  path="servicoBackendForm.id"/>
        <div class="col-xs-6">
            <!--Estratégia de Aplicação-->
            <div class="row">
                <spring:bind path="servicoBackendForm.estrategiaApliacacao">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.estrategiaApliacacao"><fmt:message key="message.servicoBackend.geral.estrategiaApliacacao.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.estrategiaApliacacao" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.geral.estrategiaApliacacao.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.estrategiaApliacacao" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Estratégia de Aplicação-->
            <!--Complexidade do Negócio-->
            <div class="row">
                <spring:bind path="servicoBackendForm.complexNegocio">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.complexNegocio"><fmt:message key="message.servicoBackend.geral.complexNegocio.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.complexNegocio" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.geral.complexNegocio.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.complexNegocio" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Complexidade do Negócio-->
        </div>
        <div class="col-xs-6">
            <!--Integração Back-end-->
            <div class="row">
                <spring:bind path="servicoBackendForm.integraBackend">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.integraBackend"><fmt:message key="message.servicoBackend.geral.integraBackend.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.integraBackend" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.geral.integraBackend.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.integraBackend" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Integração Back-end-->
        </div>
    </div>
</section>
<section>
    <div class="row sessao-color">
        <div class="borda-solida text-center">
            <h4>Gerencimento de Dados e Analytics</h4>
        </div>
        <div class="col-xs-6">
            <!--Volume de dados / ingestão por dia-->
            <div class="row">
                <spring:bind path="servicoBackendForm.volumDadosDia">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.volumDadosDia"><fmt:message key="message.servicoBackend.gerenciaDados.volumDadosDia.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.volumDadosDia" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.gerenciaDados.volumDadosDia.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.volumDadosDia" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Volume de dados / ingestão por dia-->
            <!--Variedade de dados-->
            <div class="row">
                <spring:bind path="servicoBackendForm.variedadeDados">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.variedadeDados"><fmt:message key="message.servicoBackend.gerenciaDados.variedadeDados.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.variedadeDados" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.gerenciaDados.variedadeDados.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.variedadeDados" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Variedade de dados-->
        </div>
        <div class="col-xs-6">
            <!--Variabilidade de dados (mudança de esquema)-->
            <div class="row">
                <spring:bind path="servicoBackendForm.mudancaSchema">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.mudancaSchema"><fmt:message key="message.servicoBackend.gerenciaDados.mudancaSchema.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.mudancaSchema" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.gerenciaDados.mudancaSchema.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.mudancaSchema" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Variabilidade de dados (mudança de esquema)-->
            <!--Analytics-->
            <div class="row">
                <spring:bind path="servicoBackendForm.analytics">
                    <div class="form-group ">
                        <form:label path="servicoBackendForm.analytics"><fmt:message key="message.servicoBackend.gerenciaDados.analytics.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="servicoBackendForm.analytics" value="${i}"/>
                                    <fmt:message key="message.servicoBackend.gerenciaDados.analytics.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="servicoBackendForm.analytics" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Analytics-->
        </div>
    </div>
</section>