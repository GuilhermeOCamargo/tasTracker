<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row" id="conteudo">
    <sec:authorize access="hasAnyRole('ROLE_ADMINISTRADOR')">
        <div class="col-sm-3">
            <c:import url="Forms/formEmpresa.jsp"></c:import>
        </div>
    <div class="col-sm-9">
        <c:import url="Lists/listEmpresa.jsp"></c:import>
    </div>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_VISUALIZADOR')">
    <div class="col-sm-12">
        <c:import url="Lists/listEmpresa.jsp"></c:import>
    </div>
    </sec:authorize>
</div>