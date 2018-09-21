package br.com.tas.tracker.console.model;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/
@NamedQueries({
        /*DELETE BY ID*/
        @NamedQuery(name = "USUARIO.deleteById", query = "DELETE FROM Usuario u WHERE u.id = :id"),
        /*FIND ALL*/
        @NamedQuery(name = "USUARIO.findAll", query = "SELECT u FROM Usuario u"),
        /*FIND BY ID*/
        @NamedQuery(name = "USUARIO.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
        /*FIND BY E-MAIL*/
        @NamedQuery(name = "USUARIO.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
})
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 15)
    private String senha;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false)
    private Permissao permissao;
    private String confirmSenha;

    /**
     * @param id - Id
     * @param nome - Nome
     * @param email - Email
     * @param senha - Senha
     * @param permissao - Permissão
     * */
    public Usuario(Long id, String nome, String email, String senha, Permissao permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
    }
    public Usuario(){}
    /*Getters and Setters*/
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

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = confirmSenha;
    }

    /**
     * @return Retorna um o id e o nome do usuário
     * */
    @Override
    public String toString() {
        return "Id: "+getId() + " | Nome: "+ getNome();
    }

    /**
     * @param obj - Um usuário
     * @return Verdadeiro se o id for igual
     * */
    @Override
    public boolean equals(Object obj) {
        return (getId() == ((Usuario)obj).getId() ? true:false);
    }
}
