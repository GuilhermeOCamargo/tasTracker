package br.com.tas.tracker.console.model.dto;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 * */
@Entity
public class AmbienteProjeto {
    private Integer tempo;
    private Integer orcamento;
    private Integer habFuncExp;
    private Integer habTecExp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = true, length = 1)
    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    @Column(nullable = true, length = 1)
    public Integer getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Integer orcamento) {
        this.orcamento = orcamento;
    }

    @Column(nullable = true, length = 1)
    public Integer getHabFuncExp() {
        return habFuncExp;
    }

    public void setHabFuncExp(Integer habFuncExp) {
        this.habFuncExp = habFuncExp;
    }

    @Column(nullable = true, length = 1)
    public Integer getHabTecExp() {
        return habTecExp;
    }

    public void setHabTecExp(Integer habTecExp) {
        this.habTecExp = habTecExp;
    }
}
