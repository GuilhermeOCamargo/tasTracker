<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form method="POST" action="${pageContext.servletContext.contextPath}/empresa/save"
    modelAttribute="empresaForm">
    <form:hidden  path="id"/>
    <spring:bind path="nome">
        <div class="form-group ">
            <form:label path="nome">Nome:</form:label>
            <form:input path="nome" type="text" class="form-control" id="nome"
            value="${empresaForm.nome}" placeholder="Nome da Empresa"/>
            <div>
                <form:errors path="nome" class="${status.error ? 'alert-danger' : ''}" />
            </div>
        </div>
    </spring:bind>
    <spring:bind path="cnpj">
        <div class="form-group ">
            <form:label path="cnpj">CNPJ:</form:label>
            <form:input path="cnpj" type="text" class="form-control" id="cnpj"
            value="${empresaForm.cnpj}" placeholder="00.000.000/0000-00"/>
            <div>
                <form:errors path="cnpj" class="${status.error ? 'alert-danger' : ''}" />
            </div>
        </div>
    </spring:bind>
    <spring:bind path="usuarioId">
        <div class="form-group">
            <form:label path="usuarioId">Usuário Responsável:</form:label>
            <form:select path="usuarioId" class="form-control">
                <form:options items="${usuarios}" itemValue="id" itemLabel="nome"/>
            </form:select>
            <div>
                <form:errors path="usuarioId" class="${status.error ? 'alert-danger' : ''}" />
            </div>
        </div>
    </spring:bind>
    <div class="form-group">
        <button type="submit" class="btn btn-success">
            <span class="glyphicon glyphicon-floppy-disk"></span> Salvar
        </button>
    </div>
</form:form>
<script type="text/javascript">
    $(document).ready(function(){
        $("#cnpj").mask("99.999.999/9999-99");
    })
</script>