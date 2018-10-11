<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                    <a href="${pageContext.servletContext.contextPath}/usuario/edit/${user.id}" role="button"> <i class="glyphicon glyphicon-pencil"></i>
                            Alterar
                    </a>
                </td>
                <td>
                    <a onclick="showConfirmDelete('${user.id}')" class="excluirLink" role="button"> <i class="glyphicon glyphicon-remove"></i>
                            Excluir
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
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