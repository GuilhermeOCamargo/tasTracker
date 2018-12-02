<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Cnpj</th>
            <th>Usuário</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${empresas}" var="emp">
            <tr>
                <td>${emp.nome}</td>
                <td class="cnpjTd">${emp.cnpj}</td>
                <td>${emp.usuarioResponsavel.nome}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/dashboard/answered/list/${emp.id}" role="button"> <i class="glyphicon glyphicon-list-alt"></i>
                            Visualizar Questionários
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
}
</script>