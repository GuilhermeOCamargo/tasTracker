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
public class UsuarioForm {

    private Long id;
    @NotEmpty
    @Size(min = 1, max = 100)
    private String nome;
    @NotEmpty
    @Size(min = 1, max = 50)
    @Email
    @EmailUniqueValid(message = "{Unique.usuario.email}")
    private String email;
    @NotEmpty
    @Size(min = 1, max = 15)
    private String senha;
    @NotNull
    private String confirmSenha;
    @NotNull
    private Long permissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = confirmSenha;
    }

    public Long getPermissao() {
        return permissao;
    }

    public void setPermissao(Long permissao) {
        this.permissao = permissao;
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
