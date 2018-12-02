<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><spam><img class="imagem_logo" src="<c:url value='/resources/img/taz.png'/>"/> TAS Tracker</spam></a>
        </div>
        <ul class="nav navbar-nav">
            <li class=""><a href="${pageContext.servletContext.contextPath}/dashboard/list">Dashboard</a></li>
            <li>
                <sec:authorize access="hasAnyRole('ROLE_ADMINISTRADOR')">
                    <a href="${pageContext.servletContext.contextPath}/usuario/list">Usu&aacute;rios</a>
                </sec:authorize>
            </li>
            <li>
                <sec:authorize access="hasAnyRole('ROLE_ADMINISTRADOR', 'ROLE_VISUALIZADOR')">
                    <a href="${pageContext.servletContext.contextPath}/empresa/list">Empresa</a>
                </sec:authorize>
            </li>
            <li>
                <sec:authorize access="hasAnyRole('ROLE_EMPRESA')">
                    <a href="${pageContext.servletContext.contextPath}/questionario/pending">Question&aacute;rios</a>
                </sec:authorize>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.servletContext.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
        </ul>
    </div>
</nav>
