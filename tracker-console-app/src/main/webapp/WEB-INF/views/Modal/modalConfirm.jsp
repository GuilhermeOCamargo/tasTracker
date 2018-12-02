<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--MODAL ADD MENU-->
<!--INICIO MODAL-->
<div id="modalConfirm" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<!--CONTE�DO DO MODAL-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<!--T�TULO DO MODAL-->
				<h4 class="modal-title" id="modalTitle">${modalTitle}</h4>
			</div>
			<div class="modal-body">
			    <form method="POST" action="${pageContext.servletContext.contextPath}${linkConfirm}" id="formConfirm">
                    <input type="hidden" id="urlConfirm" value="${pageContext.servletContext.contextPath}${linkConfirm}">
                    <table class="table">
                        <thead>
                            <th>Nome</th>
                            <th>E-mail</th>
                            <th>Permissão</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${userToDelete.nome}</td>
                                <td>${userToDelete.email}</td>
                                <td>${userToDelete.permissao.nome}</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-${cssButton}" value="Sim">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                    </div>
                </form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.FIM MODAL -->
<script type="text/javascript">
   /* $("#btnConfirm").on("click",
        function showConfirmDelete(idUser){
            var urlConfirm = $("#urlConfirm").val();
            $.ajax({
                method : 'delete',
                url : urlConfirm,
                cache : false,
                success : function(data) {

                },
                error : function(e) {
                }
            });
        }
    );*/

</script>