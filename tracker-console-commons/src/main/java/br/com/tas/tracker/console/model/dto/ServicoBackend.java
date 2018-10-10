package br.com.tas.tracker.console.model.dto;
/**
 * @author guilherme.camargo
 * @since 09/10/2018
 * @version 1.0
 * */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEstrategiaApliacacao() {
        return estrategiaApliacacao;
    }

    public void setEstrategiaApliacacao(Integer estrategiaApliacacao) {
        this.estrategiaApliacacao = estrategiaApliacacao;
    }

    public Integer getComplexNegocio() {
        return complexNegocio;
    }

    public void setComplexNegocio(Integer complexNegocio) {
        this.complexNegocio = complexNegocio;
    }

    public Integer getIntegraBackend() {
        return integraBackend;
    }

    public void setIntegraBackend(Integer integraBackend) {
        this.integraBackend = integraBackend;
    }

    public Integer getVolumDadosDia() {
        return volumDadosDia;
    }

    public void setVolumDadosDia(Integer volumDadosDia) {
        this.volumDadosDia = volumDadosDia;
    }

    public Integer getVariedadeDados() {
        return variedadeDados;
    }

    public void setVariedadeDados(Integer variedadeDados) {
        this.variedadeDados = variedadeDados;
    }

    public Integer getMudancaSchema() {
        return mudancaSchema;
    }

    public void setMudancaSchema(Integer mudancaSchema) {
        this.mudancaSchema = mudancaSchema;
    }

    public Integer getAnalytics() {
        return analytics;
    }

    public void setAnalytics(Integer analytics) {
        this.analytics = analytics;
    }
}
