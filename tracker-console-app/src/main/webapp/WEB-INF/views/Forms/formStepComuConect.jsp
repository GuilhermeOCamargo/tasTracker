<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row subtitulo">
    <h3><fmt:message key="message.comuniConectividade.label"/></h3>
</div>
<form:errors path="comunicacaoConectividadeForm" cssClass="alert-danger row" element="div" />
<section>
    <div class="row">
        <div class="borda-solida text-center">
            <h4>C&C Local</h4>
        </div>
        <div class="col-xs-6">
            <!--Tecnologia-->
            <div class="row">
                <spring:bind path="comunicacaoConectividadeForm.tecnologiaLocal">
                    <div class="form-group ">
                        <form:label path="comunicacaoConectividadeForm.tecnologiaLocal"><fmt:message key="message.comuniConectividade.ccLocal.tecnologia.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="comunicacaoConectividadeForm.tecnologiaLocal" value="${i}"/>
                                    <fmt:message key="message.comuniConectividade.ccLocal.tecnologia.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="comunicacaoConectividadeForm.tecnologiaLocal" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Tecnologia-->
            <!--Largura de banda necessária-->
            <div class="row">
                <spring:bind path="comunicacaoConectividadeForm.larguraBandaLocal">
                    <div class="form-group ">
                        <form:label path="comunicacaoConectividadeForm.larguraBandaLocal"><fmt:message key="message.comuniConectividade.ccLocal.larguraBanda.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="comunicacaoConectividadeForm.larguraBandaLocal" value="${i}"/>
                                    <fmt:message key="message.comuniConectividade.ccLocal.larguraBanda.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="comunicacaoConectividadeForm.larguraBandaLocal" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Largura de banda necessária-->
        </div>
        <div class="col-xs-6">
            <!--Latência Máxima-->
            <div class="row">
                <spring:bind path="comunicacaoConectividadeForm.latenciaMaxLocal">
                    <div class="form-group ">
                        <form:label path="comunicacaoConectividadeForm.latenciaMaxLocal"><fmt:message key="message.comuniConectividade.ccLocal.latenciaMax.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="comunicacaoConectividadeForm.latenciaMaxLocal" value="${i}"/>
                                    <fmt:message key="message.comuniConectividade.ccLocal.latenciaMax.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="comunicacaoConectividadeForm.latenciaMaxLocal" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Latência Máxima-->
        </div>
    </div>
</section>
<section>
    <div class="row sessao-color">
        <div class="borda-solida text-center">
            <h4>C&C Remota</h4>
        </div>
        <div class="col-xs-6">
            <!--Tecnologia-->
            <div class="row">
                <spring:bind path="comunicacaoConectividadeForm.tecnologiaRemota">
                    <div class="form-group ">
                        <form:label path="comunicacaoConectividadeForm.tecnologiaRemota"><fmt:message key="message.comuniConectividade.ccRemota.tecnologia.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="comunicacaoConectividadeForm.tecnologiaRemota" value="${i}"/>
                                    <fmt:message key="message.comuniConectividade.ccRemota.tecnologia.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="comunicacaoConectividadeForm.tecnologiaRemota" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Tecnologia-->
            <!--Largura de banda necessária-->
            <div class="row">
                <spring:bind path="comunicacaoConectividadeForm.larguraBandaRemota">
                    <div class="form-group ">
                        <form:label path="comunicacaoConectividadeForm.larguraBandaRemota"><fmt:message key="message.comuniConectividade.ccRemota.larguraBanda.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="comunicacaoConectividadeForm.larguraBandaRemota" value="${i}"/>
                                    <fmt:message key="message.comuniConectividade.ccRemota.larguraBanda.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="comunicacaoConectividadeForm.larguraBandaRemota" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Largura de banda necessária-->
        </div>
        <div class="col-xs-6">
            <!--Latência Máxima-->
            <div class="row">
                <spring:bind path="comunicacaoConectividadeForm.latenciaMaxRemota">
                    <div class="form-group ">
                        <form:label path="comunicacaoConectividadeForm.latenciaMaxRemota"><fmt:message key="message.comuniConectividade.ccRemota.latenciaMax.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="comunicacaoConectividadeForm.latenciaMaxRemota" value="${i}"/>
                                    <fmt:message key="message.comuniConectividade.ccRemota.latenciaMax.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="comunicacaoConectividadeForm.latenciaMaxRemota" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Latência Máxima-->
        </div>
    </div>
</section>