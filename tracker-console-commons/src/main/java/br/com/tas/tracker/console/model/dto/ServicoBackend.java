package br.com.tas.tracker.console.model.dto;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 09/10/2018
 * @version 1.0
 * */
@Entity
public class ServicoBackend {
    private Long id;
    /*Geral*/
    private Integer estrategiaApliacacao;
    private Integer complexNegocio;
    private Integer integraBackend;
    /*Gerencimento de Dados e Analytics*/
    private Integer volumDadosDia;
    private Integer variedadeDados;
    private Integer mudancaSchema;
    private Integer analytics;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = true, length = 1)
    public Integer getEstrategiaApliacacao() {
        return estrategiaApliacacao;
    }

    public void setEstrategiaApliacacao(Integer estrategiaApliacacao) {
        this.estrategiaApliacacao = estrategiaApliacacao;
    }

    @Column(nullable = true, length = 1)
    public Integer getComplexNegocio() {
        return complexNegocio;
    }

    public void setComplexNegocio(Integer complexNegocio) {
        this.complexNegocio = complexNegocio;
    }

    @Column(nullable = true, length = 1)
    public Integer getIntegraBackend() {
        return integraBackend;
    }

    public void setIntegraBackend(Integer integraBackend) {
        this.integraBackend = integraBackend;
    }

    @Column(nullable = true, length = 1)
    public Integer getVolumDadosDia() {
        return volumDadosDia;
    }

    public void setVolumDadosDia(Integer volumDadosDia) {
        this.volumDadosDia = volumDadosDia;
    }

    @Column(nullable = true, length = 1)
    public Integer getVariedadeDados() {
        return variedadeDados;
    }

    public void setVariedadeDados(Integer variedadeDados) {
        this.variedadeDados = variedadeDados;
    }

    @Column(nullable = true, length = 1)
    public Integer getMudancaSchema() {
        return mudancaSchema;
    }

    public void setMudancaSchema(Integer mudancaSchema) {
        this.mudancaSchema = mudancaSchema;
    }

    @Column(nullable = true, length = 1)
    public Integer getAnalytics() {
        return analytics;
    }

    public void setAnalytics(Integer analytics) {
        this.analytics = analytics;
    }
}
