package br.com.tas.tracker.console.model.dto;
/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 * */
public class AmbienteProjeto {
    private Long id;
    private Integer tempo;
    private Integer orcamento;
    private Integer habFuncExp;
    private Integer habTecExp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Integer getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Integer orcamento) {
        this.orcamento = orcamento;
    }

    public Integer getHabFuncExp() {
        return habFuncExp;
    }

    public void setHabFuncExp(Integer habFuncExp) {
        this.habFuncExp = habFuncExp;
    }

    public Integer getHabTecExp() {
        return habTecExp;
    }

    public void setHabTecExp(Integer habTecExp) {
        this.habTecExp = habTecExp;
    }
}
