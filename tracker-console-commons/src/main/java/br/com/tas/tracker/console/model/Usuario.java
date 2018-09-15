package br.com.tas.tracker.console.model;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/
@Entity(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Column(name = "EMAIL", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "SENHA", nullable = false, length = 15)
    private String senha;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "PERMISSAO", nullable = false)
    private Permissao permissao;

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
