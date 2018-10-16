package br.com.tas.tracker.console.model.dto;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 28/09/2018
 * @version 1.0
 * */
@Entity
public class AtivosDevices {
    private Long id;
    /*Geral*/
    private Integer numAtivos;
    private Integer valorAtiInd;
    private Integer valorEconAtiAno;
    private Integer complexAtivo;
    private Integer heteroAtivo;
    /*Poder de Processamento*/
    private Integer logNegLocal;
    private Integer processLocalEven;
    private Integer requiTempReal;
    private Integer gerenciaLocalDados;
    /*Outros requisitos de HW*/
    private Integer supriEnergia;
    private Integer ambiente;
    /*Gestão do ciclo de vida*/
    private Integer tempVidaAtivo;
    private Integer restriAtualHW;
    private Integer restriAtualSW;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = true, length = 1)
    public Integer getNumAtivos() {
        return numAtivos;
    }

    public void setNumAtivos(Integer numAtivos) {
        this.numAtivos = numAtivos;
    }

    @Column(nullable = true, length = 1)
    public Integer getValorAtiInd() {
        return valorAtiInd;
    }

    public void setValorAtiInd(Integer valorAtiInd) {
        this.valorAtiInd = valorAtiInd;
    }

    @Column(nullable = true, length = 1)
    public Integer getValorEconAtiAno() {
        return valorEconAtiAno;
    }

    public void setValorEconAtiAno(Integer valorEconAtiAno) {
        this.valorEconAtiAno = valorEconAtiAno;
    }

    @Column(nullable = true, length = 1)
    public Integer getComplexAtivo() {
        return complexAtivo;
    }

    public void setComplexAtivo(Integer complexAtivo) {
        this.complexAtivo = complexAtivo;
    }

    @Column(nullable = true, length = 1)
    public Integer getHeteroAtivo() {
        return heteroAtivo;
    }

    public void setHeteroAtivo(Integer heteroAtivo) {
        this.heteroAtivo = heteroAtivo;
    }

    @Column(nullable = true, length = 1)
    public Integer getLogNegLocal() {
        return logNegLocal;
    }

    public void setLogNegLocal(Integer logNegLocal) {
        this.logNegLocal = logNegLocal;
    }

    @Column(nullable = true, length = 1)
    public Integer getProcessLocalEven() {
        return processLocalEven;
    }

    public void setProcessLocalEven(Integer processLocalEven) {
        this.processLocalEven = processLocalEven;
    }

    @Column(nullable = true, length = 1)
    public Integer getRequiTempReal() {
        return requiTempReal;
    }

    public void setRequiTempReal(Integer requiTempReal) {
        this.requiTempReal = requiTempReal;
    }

    @Column(nullable = true, length = 1)
    public Integer getGerenciaLocalDados() {
        return gerenciaLocalDados;
    }

    public void setGerenciaLocalDados(Integer gerenciaLocalDados) {
        this.gerenciaLocalDados = gerenciaLocalDados;
    }

    @Column(nullable = true, length = 1)
    public Integer getSupriEnergia() {
        return supriEnergia;
    }

    public void setSupriEnergia(Integer supriEnergia) {
        this.supriEnergia = supriEnergia;
    }

    @Column(nullable = true, length = 1)
    public Integer getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Integer ambiente) {
        this.ambiente = ambiente;
    }

    @Column(nullable = true, length = 1)
    public Integer getTempVidaAtivo() {
        return tempVidaAtivo;
    }

    public void setTempVidaAtivo(Integer tempVidaAtivo) {
        this.tempVidaAtivo = tempVidaAtivo;
    }

    @Column(nullable = true, length = 1)
    public Integer getRestriAtualHW() {
        return restriAtualHW;
    }

    public void setRestriAtualHW(Integer restriAtualHW) {
        this.restriAtualHW = restriAtualHW;
    }

    @Column(nullable = true, length = 1)
    public Integer getRestriAtualSW() {
        return restriAtualSW;
    }

    public void setRestriAtualSW(Integer restriAtualSW) {
        this.restriAtualSW = restriAtualSW;
    }

    /**
     * @return Retorna um o id e o nome do usuário
     * */
    @Override
    public String toString() {
        return "Id: "+getId();
    }

    /**
     * @param obj - Um usuário
     * @return Verdadeiro se o id for igual
     * */
    @Override
    public boolean equals(Object obj) {
        return (getId() == ((AtivosDevices)obj).getId() ? true:false);
    }
}
