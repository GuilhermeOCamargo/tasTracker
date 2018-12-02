<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
    <form:form method="POST" action="${pageContext.servletContext.contextPath}/usuario/save"
        modelAttribute="usuarioForm">
        <form:hidden  path="id"/>
        <spring:bind path="nome">
            <div class="form-group ">
                <form:label path="nome">Nome:</form:label>
                <form:input path="nome" type="text" class="form-control" id="nome"
                value="${usuarioForm.nome}"/>
                <div>
                    <form:errors path="nome" class="${status.error ? 'alert-danger' : ''}" />
                </div>
            </div>
        </spring:bind>
        <spring:bind path="email">
            <div class="form-group">
                <form:label path="email">Email:</form:label>
                <form:input path="email" type="text" class="form-control" id="email"
                value="${usuarioForm.email}"/>
                <div>
                    <form:errors path="email" class="${status.error ? 'alert-danger' : ''}" />
                </div>
            </div>
        </spring:bind>
            <c:if test="${usuarioForm.id != null}">
                <spring:bind path="senha">
                    <div class="form-group">
                         <form:hidden path="senha" class="form-control" id="senha" value="${usuarioForm.senha}"/>
                    </div>
                </spring:bind>
                <spring:bind path="confirmSenha">
                    <div class="form-group">
                         <form:hidden path="confirmSenha" class="form-control" id="confirmSenha" value="${usuarioForm.senha}"/>
                    </div>
                </spring:bind>
            </c:if>
            <c:if test="${usuarioForm.id == null}">
                <spring:bind path="senha">
                    <div class="form-group">
                        <form:label path="senha">Senha:</form:label>
                        <form:input path="senha" type="password" class="form-control" id="senha"/>
                        <div>
                            <form:errors path="senha" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="confirmSenha">
                    <div class="form-group">
                        <form:label path="confirmSenha">Confirmação Senha:</form:label>
                        <form:input path="confirmSenha" type="password" class="form-control" id="confirmSenha"/>
                        <div>
                            <form:errors path="confirmSenha" class="${status.error ? 'alert-danger' : ''}" />
                        </div>
                    </div>
                </spring:bind>
             </c:if>
        <spring:bind path="permissao">
            <div class="form-group">
                <form:label path="permissaoId">Permissão:</form:label>
                <form:select path="permissaoId" class="form-control">
                    <form:options items="${permissoes}" itemValue="id" itemLabel="nome"/>
                </form:select>
                <div>
                    <form:errors path="permissao" class="${status.error ? 'alert-danger' : ''}" />
                </div>
            </div>
        </spring:bind>
        <div class="form-group">
           <button type="submit" class="btn btn-success">
            <span class="glyphicon glyphicon-floppy-disk"></span> Salvar
           </button>
        </div>
    </form:form>
</div>