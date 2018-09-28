package br.com.tas.tracker.console.model.abst;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/
@Entity
public class Fabricante {
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
