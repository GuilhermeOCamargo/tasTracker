<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row subtitulo">
    <h3><fmt:message key="message.padraoReqRegulatorio.label"/></h3>
</div>
<form:errors path="padraoReqRegulatorioForm" cssClass="alert-danger row" element="div" />
<section>
    <div class="row">
        <div class="borda-solida text-center">
            <h4>Requerimentos Regulatórios</h4>
        </div>
        <div class="col-xs-6">
            <!--Regionais específicos-->
            <div class="row">
                <spring:bind path="padraoReqRegulatorioForm.regionalEsp">
                    <div class="form-group ">
                        <form:label path="padraoReqRegulatorioForm.regionalEsp"><fmt:message key="message.padraoReqRegulatorio.reqRegulatorio.regional.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="padraoReqRegulatorioForm.regionalEsp" value="${i}"/>
                                    <fmt:message key="message.padraoReqRegulatorio.reqRegulatorio.regional.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="padraoReqRegulatorioForm.regionalEsp" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Regionais específicos-->
            <!--Específicos da Indústria-->
            <div class="row">
                <spring:bind path="padraoReqRegulatorioForm.industriaEsp">
                    <div class="form-group ">
                        <form:label path="padraoReqRegulatorioForm.industriaEsp"><fmt:message key="message.padraoReqRegulatorio.reqRegulatorio.industria.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="padraoReqRegulatorioForm.industriaEsp" value="${i}"/>
                                    <fmt:message key="message.padraoReqRegulatorio.reqRegulatorio.industria.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="padraoReqRegulatorioForm.industriaEsp" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Específicos da Indústria-->
        </div>
        <div class="col-xs-6">
            <!--Específicos da Tecnologia-->
            <div class="row">
                <spring:bind path="padraoReqRegulatorioForm.tecnologiaEsp">
                    <div class="form-group ">
                        <form:label path="padraoReqRegulatorioForm.tecnologiaEsp"><fmt:message key="message.padraoReqRegulatorio.reqRegulatorio.tecnologia.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="padraoReqRegulatorioForm.tecnologiaEsp" value="${i}"/>
                                    <fmt:message key="message.padraoReqRegulatorio.reqRegulatorio.tecnologia.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="padraoReqRegulatorioForm.tecnologiaEsp" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Específicos da Tecnologia-->
        </div>
    </div>
</section>
<section>
    <div class="row sessao-color">
        <div class="borda-solida text-center">
            <h4>Padrões</h4>
        </div>
        <div class="col-xs-6">
            <!--Padrões técnicos-->
            <div class="row">
                <spring:bind path="padraoReqRegulatorioForm.tecnicoPad">
                    <div class="form-group ">
                        <form:label path="padraoReqRegulatorioForm.tecnicoPad"><fmt:message key="message.padraoReqRegulatorio.padrao.tecnico.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="padraoReqRegulatorioForm.tecnicoPad" value="${i}"/>
                                    <fmt:message key="message.padraoReqRegulatorio.padrao.tecnico.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="padraoReqRegulatorioForm.tecnicoPad" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Padrões técnicos-->
        </div>
        <div class="col-xs-6">
            <!--Padrões Funcionais/da Indústria-->
            <div class="row">
                <spring:bind path="padraoReqRegulatorioForm.funcionalPad">
                    <div class="form-group ">
                        <form:label path="padraoReqRegulatorioForm.funcionalPad"><fmt:message key="message.padraoReqRegulatorio.padrao.funcional.label"/>:</form:label>
                        <c:forEach var = "i" begin = "1" end = "4">
                            <div class="radio">
                                <label>
                                    <form:radiobutton path="padraoReqRegulatorioForm.funcionalPad" value="${i}"/>
                                    <fmt:message key="message.padraoReqRegulatorio.padrao.funcional.${i}"/>
                                </label>
                            </div>
                        </c:forEach>
                        <div>
                            <form:errors path="padraoReqRegulatorioForm.funcionalPad" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
            </div>
            <!--Padrões Funcionais/da Indústria-->
        </div>
    </div>
</section>