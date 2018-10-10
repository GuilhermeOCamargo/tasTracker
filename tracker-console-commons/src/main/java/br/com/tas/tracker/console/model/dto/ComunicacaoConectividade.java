package br.com.tas.tracker.console.model.dto;
/**
 * @author guilherme.camargo
 * @since 09/10/2018
 * @version 1.0
 * */
public class ComunicacaoConectividade {

    private Long id;
    /*C&C Local*/
    private Integer tecnologiaLocal;
    private Integer larguraBandaLocal;
    private Integer latenciaMaxLocal;
    /*C&C Remota*/
    private Integer tecnologiaRemota;
    private Integer larguraBandaRemota;
    private Integer latenciaMaxRemota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTecnologiaLocal() {
        return tecnologiaLocal;
    }

    public void setTecnologiaLocal(Integer tecnologiaLocal) {
        this.tecnologiaLocal = tecnologiaLocal;
    }

    public Integer getLarguraBandaLocal() {
        return larguraBandaLocal;
    }

    public void setLarguraBandaLocal(Integer larguraBandaLocal) {
        this.larguraBandaLocal = larguraBandaLocal;
    }

    public Integer getLatenciaMaxLocal() {
        return latenciaMaxLocal;
    }

    public void setLatenciaMaxLocal(Integer latenciaMaxLocal) {
        this.latenciaMaxLocal = latenciaMaxLocal;
    }

    public Integer getTecnologiaRemota() {
        return tecnologiaRemota;
    }

    public void setTecnologiaRemota(Integer tecnologiaRemota) {
        this.tecnologiaRemota = tecnologiaRemota;
    }

    public Integer getLarguraBandaRemota() {
        return larguraBandaRemota;
    }

    public void setLarguraBandaRemota(Integer larguraBandaRemota) {
        this.larguraBandaRemota = larguraBandaRemota;
    }

    public Integer getLatenciaMaxRemota() {
        return latenciaMaxRemota;
    }

    public void setLatenciaMaxRemota(Integer latenciaMaxRemota) {
        this.latenciaMaxRemota = latenciaMaxRemota;
    }

    /**
     * @param obj - Um usuário
     * @return Verdadeiro se o id for igual
     */
    @Override
    public boolean equals(Object obj) {
        return (getId() == ((ComunicacaoConectividade) obj).getId() ? true : false);
    }
}
