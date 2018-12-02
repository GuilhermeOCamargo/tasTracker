package br.com.tas.tracker.console.model.dto;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/

@NamedQueries({
        @NamedQuery(name = "PERMISSAO.findAll", query = "SELECT p FROM Permissao p"),
        @NamedQuery(name = "PERMISSAO.findById", query = "SELECT p FROM Permissao p WHERE p.id = :id"),
        @NamedQuery(name = "PERMISSAO.findByName", query = "SELECT p FROM Permissao p WHERE p.nome = :nome")
})

@Entity
public class Permissao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    /**
     * @param id - Id
     * @param nome - Nome
     * */
    public Permissao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Permissao(){}
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
    /**
     * @return Id e nome da permissão
     * */
    @Override
    public String toString() {
        return "Id: "+ getId()+ " | Nome: "+ getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return (getId() == ((Permissao)obj).getId() ? true:false);
    }

}
