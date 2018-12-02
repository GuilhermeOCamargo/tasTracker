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
            <th>Data Criação</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questionarios}" var="quest">
            <tr>
                <td>${quest.empresa.nome}</td>
                <td class="cnpjTd">${quest.empresa.cnpj}</td>
                <fmt:setLocale value="pt_BR" />
                <fmt:formatDate value="${quest.dtCriacao.time}" type="both"
                    pattern="dd/MM/yyyy" var="dtCriacao" />
                <td>${dtCriacao}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/questionario/answer/${quest.id}" role="button"> <i class="glyphicon glyphicon-list-alt"></i>
                            Responder Questionário
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