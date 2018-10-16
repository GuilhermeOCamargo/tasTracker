package br.com.tas.tracker.console.model.dto;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 * */
@Entity
public class PadraoReqRegulatorio {

    private Long id;
    /*Regionais específicos*/
    private Integer regionalEsp;
    private Integer industriaEsp;
    private Integer tecnologiaEsp;
    /*Padrões técnicos*/
    private Integer tecnicoPad;
    private Integer funcionalPad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = true, length = 1)
    public Integer getRegionalEsp() {
        return regionalEsp;
    }

    public void setRegionalEsp(Integer regionalEsp) {
        this.regionalEsp = regionalEsp;
    }

    @Column(nullable = true, length = 1)
    public Integer getIndustriaEsp() {
        return industriaEsp;
    }

    public void setIndustriaEsp(Integer industriaEsp) {
        this.industriaEsp = industriaEsp;
    }

    @Column(nullable = true, length = 1)
    public Integer getTecnologiaEsp() {
        return tecnologiaEsp;
    }

    public void setTecnologiaEsp(Integer tecnologiaEsp) {
        this.tecnologiaEsp = tecnologiaEsp;
    }

    @Column(nullable = true, length = 1)
    public Integer getTecnicoPad() {
        return tecnicoPad;
    }

    public void setTecnicoPad(Integer tecnicoPad) {
        this.tecnicoPad = tecnicoPad;
    }

    @Column(nullable = true, length = 1)
    public Integer getFuncionalPad() {
        return funcionalPad;
    }

    public void setFuncionalPad(Integer funcionalPad) {
        this.funcionalPad = funcionalPad;
    }
}
