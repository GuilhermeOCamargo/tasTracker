<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TAS Tracker</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Dashboard</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Equipamento <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Fabricante</a></li>
          <li><a href="#">Modelo</a></li>
          <li><a href="#">Computadores</a></li>
        </ul>
      </li>
      <li><a href="${pageContext.servletContext.contextPath}/usuario/list">Usu&aacute;rios</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
    </ul>
  </div>
</nav>
