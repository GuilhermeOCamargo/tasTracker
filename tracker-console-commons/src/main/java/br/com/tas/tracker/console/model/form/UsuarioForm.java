package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.Permissao;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.validators.annotations.ConfirmSenhaEqualsValid;
import br.com.tas.tracker.console.validators.annotations.EmailUniqueValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author guilherme.camargo
 * @since 24/09/2018
 * @version 1.0
     * */
@ConfirmSenhaEqualsValid.List({
        @ConfirmSenhaEqualsValid(senha = "senha", confirmSenha = "confirmSenha")
})
@EmailUniqueValid(email = "email", id = "id")
public class UsuarioForm extends Usuario {

    private String confirmSenha;

    private Long permissaoId;

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }
    @NotEmpty
    @Size(min = 1, max = 100)
    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }
    @NotEmpty
    @Size(min = 1, max = 50)
    @Email
    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }
    @NotEmpty
    @Size(min = 1, max = 15)
    public String getSenha() {
        return super.getSenha();
    }

    public void setSenha(String senha) {
        super.setSenha(senha);
    }
    @NotNull
    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = confirmSenha;
    }
    @NotNull
    public Long getPermissaoId() {
        return this.permissaoId;
    }

    public void setPermissaoId(Long permissaoId) {
        this.permissaoId = permissaoId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Usuario build(Permissao permissao){
        Usuario usuario = new Usuario();
        if(this.getId() != null){
            usuario.setId(this.getId());
        }
        usuario.setNome(this.getNome());
        usuario.setEmail(this.getEmail());
        usuario.setSenha(this.getSenha());
        usuario.setPermissao(permissao);
        return usuario;
    }
}
