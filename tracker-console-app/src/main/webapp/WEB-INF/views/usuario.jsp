<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Tas Tracker</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div id="modalContent"></div>
    <div class="wrapper">
        <c:import url="template_menu.jsp"></c:import>
        <div class="container">
            <div class="row">
                <h1>Usu&aacute;rios</h1>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <c:if test="${not empty mensagem}">
                        <div class="alert alert-${css} alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                            <strong>${mensagem}</strong>
                        </div>
                    </c:if>
                </div>
                <div class="col-sm-4">
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
                               <input type="submit" value="Salvar" class="btn btn-primary"/>
                            </div>
                        </form:form>
                    </div>
                </div>
                <div class="col-sm-8">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>E-mail</th>
                                <th>Permissao</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="tableAudit">
                            <c:forEach items="${usuarios}" var="user">
                                <tr>
                                    <td>${user.nome}</td>
                                    <td>${user.email}</td>
                                    <td>${user.permissao.nome}</td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/usuario/edit/${user.id}"> <i class="glyphicon glyphicon-pencil"></i>
                                                Alterar
                                        </a>
                                    </td>
                                    <td>
                                        <a onclick="showConfirmDelete('${user.id}')"> <i class="glyphicon glyphicon-remove"></i>
                                                Excluir
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script type="text/javascript">
        function showConfirmDelete(idUser){
            $.ajax({
                method : 'get',
                url : 'confirmDel/' + idUser,
                cache : false,
                success : function(data) {
                    $("#modalContent").html(data);
                    $("#modalConfirm").modal({
                        backdrop : 'static',
                        keyboard : false
                    });
                },
                error : function(e) {
                }
            });
        }
    </script>
</html>