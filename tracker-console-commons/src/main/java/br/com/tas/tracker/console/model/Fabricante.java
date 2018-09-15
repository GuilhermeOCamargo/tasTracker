package br.com.tas.tracker.console.model;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/
@Entity(name = "FABRICANTE")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false, unique = true, length = 50)
    private String nome;

    /**
     * @param id
     * @param nome
     * */
    public Fabricante(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
    @Override
    public String toString() {
        return "Id: "+getId()+ " Nome: "+getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return (getId() == ((Fabricante)obj).getId() ? true:false);
    }

}
