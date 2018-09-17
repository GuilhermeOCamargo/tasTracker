package br.com.tas.tracker.console.model;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/
@Entity(name = "MODELO")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false, unique = true, length = 50)
    private String nome;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FABRICANTE", nullable = false)
    private Fabricante fabricante;

    /**
     * @param id - Id
     * @param nome - Nome
     * @param fabricante - Fabricante
     * */
    public Modelo(Long id, String nome, Fabricante fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    @Override
    public String toString() {
        return "Id: "+getId()+ " Nome: "+getNome()+ " Fabricante: " +getFabricante().getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return (getId() == ((Ambiente)obj).getId() ? true:false);
    }
}
