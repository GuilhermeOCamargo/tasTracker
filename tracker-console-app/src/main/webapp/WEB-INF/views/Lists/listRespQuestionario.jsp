<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table">
    <thead>
        <tr>
            <th id="thAtivoDispositivo"><fmt:message key="message.ativoDispositivo.label"/></th>
            <th id="thComuniConectividade"><fmt:message key="message.comuniConectividade.label"/></th>
            <th id="thServicoBackend"><fmt:message key="message.servicoBackend.label"/></th>
            <th id="thPadraoReqRegulatorio"><fmt:message key="message.padraoReqRegulatorio.label"/></th>
            <th id="thAmbienteProjeto"><fmt:message key="message.ambienteProjeto.label"/></th>
        </tr>
    </thead>
    <tbody class="text-center">
        <tr>
            <td id="tdAtivoDispositivo">${questionario.ativosDevices.calcularResultado()}</td>
            <td id="tdComuniConectividade">${questionario.comunicacaoConectividade.calcularResultado()}</td>
            <td id="tdServicoBackend">${questionario.servicoBackend.calcularResultado()}</td>
            <td id="tdPadraoReqRegulatorio">${questionario.padraoReqRegulatorio.calcularResultado()}</td>
            <td id="tdAmbienteProjeto">${questionario.ambienteProjeto.calcularResultado()}</td>
        </tr>
    </tbody>
</table>
<div class="row">
    <canvas id="chartContainer" style="height: 500px; width: 100%;"></canvas>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<script type="text/javascript">
    var data;
    var ctx;
    var label1, label2, label3, label4, label5;
    var val1, val2, val3, val4, val5;
    $(document).ready(function(){
        ctx = document.getElementById("chartContainer");
        label1 = $("#thAtivoDispositivo").text();
        label2 = $("#thComuniConectividade").text();
        label3 = $("#thServicoBackend").text();
        label4 = $("#thPadraoReqRegulatorio").text();
        label5 = $("#thAmbienteProjeto").text();

        val1 = $("#tdAtivoDispositivo").text();
        val2 = $("#tdComuniConectividade").text();
        val3 = $("#tdServicoBackend").text();
        val4 = $("#tdPadraoReqRegulatorio").text();
        val5 = $("#tdAmbienteProjeto").text();

        data = {
                           labels: [label1, label2, label3, label4, label5],
                           datasets: [{
                                label: 'Questionário',
                                backgroundColor: "#F5A9A9",
                                borderColor: "grey",
                                pointBackgroundColor: "red",
                                data: [val1, val2, val3, val4, val5]
                           }]
                       }
                var myRadarChart = new Chart(chartContainer, {
                    type: 'radar',
                    data: data,
                    options: {
                        legend: {
                            position: 'bottom',
                        },
                        title: {
                            display: true,
                            text: 'Track & Trace'
                        },
                        scale: {
                            ticks: {
                                beginAtZero: true,
                                display: true
                            }
                        }
                    }
                });

    });
    window.onload = function () {
        /*debugger;
        data = {
                   labels: [label1, label2, label3, label4, label5],
                   datasets: [{
                        label: 'Questionário',
                        backgroundColor: "#F5A9A9",
                        borderColor: "grey",
                        pointBackgroundColor: "red",
                        data: [val1, val2, val3, val4, val5]
                   }]
               }
        var myRadarChart = new Chart(chartContainer, {
            type: 'radar',
            data: data,
            options: {
                legend: {
                    position: 'bottom',
                },
                title: {
                    display: true,
                    text: 'Track & Trace'
                },
                scale: {
                    ticks: {
                        beginAtZero: true,
                        display: true
                    }
                }
            }
        });*/

    }
</script>
