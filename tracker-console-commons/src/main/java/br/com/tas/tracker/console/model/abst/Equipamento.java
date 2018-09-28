package br.com.tas.tracker.console.model.abst;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 15/09/2018
 * @version 1.0
 **/
@Entity
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false)
    private Modelo modelo;
    @Column(nullable = false, length = 50, unique = true)
    private String hostname;
    @Column(nullable = false, length = 50, unique = true)
    private String numeroSerie;
    @Column(nullable = false, length = 50, unique = true)
    private String tag;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false)
    private Ambiente ambiente;

    /**
     * @param id - Id
     * @param modelo - Modelo
     * @param hostname - Hostname
     * @param numeroSerie - NumeroSerie
     * @param tag - Tag de reconhecimento da antena LORA
     * @param ambiente - ambiente
     * */
    public Equipamento(Long id, Modelo modelo, String hostname, String numeroSerie, String tag, Ambiente ambiente) {
        this.id = id;
        this.modelo = modelo;
        this.hostname = hostname;
        this.numeroSerie = numeroSerie;
        this.tag = tag;
        this.ambiente = ambiente;
    }
    /*Getters and Setters*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    @Override
    public String toString() {
        return "Id: "+getId()+ " Host: "+getHostname();
    }

    @Override
    public boolean equals(Object obj) {
        return (getId() == ((Equipamento)obj).getId() ? true:false);
    }
}
