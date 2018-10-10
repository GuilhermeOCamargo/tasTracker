<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row text-center borda-inf">
    <h1>Question&aacute;rio</h1>
</div>
<div class="row">
    <ul class="breadcrumb">
        <li class="legend"><fmt:message key="message.ativoDispositivo.label"/></li>
        <li class="legend"><fmt:message key="message.comuniConectividade.label"/></li>
        <li class="legend"><fmt:message key="message.servicoBackend.label"/></li>
        <li class="legend"><fmt:message key="message.padraoReqRegulatorio.label"/></li>
        <li class="legend"><fmt:message key="message.ambienteProjeto.label"/></li>
    </ul>
</div>
<div class="row">
    <!-- Circles which indicates the steps of the form: -->
    <div style="text-align:center;margin-top:40px;">
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
    </div>
</div>
<div class="row">
    <!--Inicio Formulário-->
    <form:form method="POST" modelAttribute="questionarioForm" id="formulario" class="form"
    action="${pageContext.servletContext.contextPath}/questionario/save">
        <div class="tab">
            <c:import url="Shared/formStepAtivDisp.jsp"></c:import>
        </div>
        <div class="tab">
            <c:import url="Shared/formStepComuConect.jsp"></c:import>
        </div>
        <div class="tab">
            <c:import url="Shared/formStepServBack.jsp"></c:import>
        </div>
        <div class="tab">
            <c:import url="Shared/formStepPadReqReg.jsp"></c:import>
        </div>
        <div class="tab">
            <c:import url="Shared/formStepAmbProj.jsp"></c:import>
        </div>
    </form:form>
    <!--Fim Formulário-->
    <section>
        <div class="row borda-sup">
            <ul class="pager">
                <button class="previous btn btn-default" type="button" id="prevBtn" onclick="nextPrev(-1)">Voltar</button>
                <button class="next btn btn-info" type="button" id="nextBtn" onclick="nextPrev(1)">Próximo</button>
            </ul>
        </div>
    </section>
</div>
<script type="text/javascript">
var currentTab = 0; // Current tab is set to be the first tab (0)
$(document).ready(function(){
showTab(currentTab); // Display the crurrent tab
})
function showTab(n) {
// This function will display the specified tab of the form...
var x = document.getElementsByClassName("tab");
x[n].style.display = "block";
//... and fix the Previous/Next buttons:
if (n == 0) {
document.getElementById("prevBtn").style.display = "none";
} else {
document.getElementById("prevBtn").style.display = "inline";
}
if (n == (x.length - 1)) {
document.getElementById("nextBtn").innerHTML = "Enviar";
} else {
document.getElementById("nextBtn").innerHTML = "Próximo";
}
$('html, body').animate({scrollTop:0}, 'slow'); //slow, medium, fast
fixStepIndicator(n)
}
function nextPrev(n) {
// This function will figure out which tab to display
var x = document.getElementsByClassName("tab");
// Exit the function if any field in the current tab is invalid:
if (n == 0) return false;
// Hide the current tab:
x[currentTab].style.display = "none";
// Increase or decrease the current tab by 1:
currentTab = currentTab + n;
// if you have reached the end of the form...
if (currentTab >= x.length) {
// ... the form gets submitted:
document.getElementById("formulario").submit();
return false;
}
// Otherwise, display the correct tab:
showTab(currentTab);
}
function fixStepIndicator(n) {
// This function removes the active class of all steps...
var i, x = document.getElementsByClassName("legend");
var y = document.getElementsByClassName("step");
//TODO deixar tudo em um único For
for (i = 0; i < x.length; i++) {
x[i].className = x[i].className.replace(" active", "");
}
for (i = 0; i < y.length; i++) {
    y[i].className = y[i].className.replace(" active", "");
}
//... and adds the active class on the current step:
x[n].className += " active";
y[n].className += " active";
}
</script>