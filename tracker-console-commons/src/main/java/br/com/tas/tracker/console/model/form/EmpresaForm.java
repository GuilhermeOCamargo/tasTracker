package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.validators.annotations.CnpjUniqueValid;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 **/
@CnpjUniqueValid(id = "id", cnpj = "cnpj")
public class EmpresaForm extends Empresa {
    private Long usuarioId;
    @NotNull
    @Size(min = 1, max = 50)
    @Override
    public String getNome() {
        return super.getNome();
    }

    @NotNull
    @CNPJ
    @Override
    public String getCnpj() {
        return super.getCnpj();
    }

    @NotNull
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Empresa build(Usuario usuario){
        Empresa empresa = new Empresa();
        empresa.setId(this.getId());
        empresa.setNome(this.getNome());
        empresa.setCnpj(this.getCnpj().replace(".", "")
                .replace("/", "").replace("-", ""));
        empresa.setUsuarioResponsavel(usuario);
        return empresa;
    }
}
