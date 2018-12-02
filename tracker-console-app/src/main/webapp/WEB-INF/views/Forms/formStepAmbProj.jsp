<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row subtitulo">
    <h3><fmt:message key="message.ambienteProjeto.label"/></h3>
</div>
<form:errors path="ambienteProjetoForm" cssClass="alert-danger row" element="div" />
<section>
    <div class="row">
        <div class="borda-solida text-center">
            <h4>Geral</h4>
        </div>
        <form:hidden  path="ambienteProjetoForm.id"/>
        <div class="col-xs-6">
            <!--Tempo-->
            <div class="row">
                <spring:bind path="ambienteProjetoForm.tempo">
                    <div class="form-group ">
                        <form:label path="ambienteProjetoForm.tempo"><fmt:message key="message.ambienteProjeto.tempo.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ambienteProjetoForm.tempo" value="${i}"/>
                                    <fmt:message key="message.ambienteProjeto.tempo.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ambienteProjetoForm.tempo" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Tempo-->
            <!--Orçamento-->
            <div class="row">
                <spring:bind path="ambienteProjetoForm.orcamento">
                    <div class="form-group ">
                        <form:label path="ambienteProjetoForm.orcamento"><fmt:message key="message.ambienteProjeto.orcamento.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ambienteProjetoForm.orcamento" value="${i}"/>
                                    <fmt:message key="message.ambienteProjeto.orcamento.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ambienteProjetoForm.orcamento" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Orçamento-->
        </div>
        <div class="col-xs-6">
            <!--Habilidades Funcionais & experiência-->
            <div class="row">
                <spring:bind path="ambienteProjetoForm.habFuncExp">
                    <div class="form-group ">
                        <form:label path="ambienteProjetoForm.habFuncExp"><fmt:message key="message.ambienteProjeto.habFuncExp.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ambienteProjetoForm.habFuncExp" value="${i}"/>
                                    <fmt:message key="message.ambienteProjeto.habFuncExp.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ambienteProjetoForm.habFuncExp" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Habilidades Funcionais & experiência-->
            <!--Habilidades Técnicas & experiência-->
            <div class="row">
                <spring:bind path="ambienteProjetoForm.habTecExp">
                    <div class="form-group ">
                        <form:label path="ambienteProjetoForm.habTecExp"><fmt:message key="message.ambienteProjeto.habTecExp.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="ambienteProjetoForm.habTecExp" value="${i}"/>
                                    <fmt:message key="message.ambienteProjeto.habTecExp.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="ambienteProjetoForm.habTecExp" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Habilidades Técnicas & experiência-->
        </div>
    </div>
</section>