<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Cnpj</th>
            <th>Usuário</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${empresas}" var="emp">
            <tr>
                <td>${emp.nome}</td>
                <td class="cnpjTd">${emp.cnpj}</td>
                <td>${emp.usuarioResponsavel.nome}</td>
                <sec:authorize access="hasAnyRole('ROLE_ADMINISTRADOR')">
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/empresa/edit/${emp.id}" role="button"> <i class="glyphicon glyphicon-pencil"></i>
                                Alterar
                        </a>
                    </td>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMINISTRADOR')">
                    <td>
                        <a onclick="showConfirmDelete('${emp.id}')" class="excluirLink" role="button"> <i class="glyphicon glyphicon-remove"></i>
                                Excluir
                        </a>
                    </td>
                </sec:authorize>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/empresa/createQuestionario/${emp.id}" role="button"> <i class="glyphicon glyphicon-list-alt"></i>
                            Criar Questionário
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script type="text/javascript">
    $(document).ready(function(){
        $(".cnpjTd").mask("99.999.999/9999-99");
    })
    function showConfirmDelete(idEmpresa){
        $.ajax({
            method : 'get',
            url : 'confirmDel/' + idEmpresa,
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