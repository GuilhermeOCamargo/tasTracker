package br.com.tas.tracker.console.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author guilherme.camargo
 * @since 28/09/2018
 * @version 1.0
 * */
@Entity
public class AtivosDevices {
    @Id
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumAtivos() {
        return numAtivos;
    }

    public void setNumAtivos(Integer numAtivos) {
        this.numAtivos = numAtivos;
    }

    public Integer getValorAtiInd() {
        return valorAtiInd;
    }

    public void setValorAtiInd(Integer valorAtiInd) {
        this.valorAtiInd = valorAtiInd;
    }

    public Integer getValorEconAtiAno() {
        return valorEconAtiAno;
    }

    public void setValorEconAtiAno(Integer valorEconAtiAno) {
        this.valorEconAtiAno = valorEconAtiAno;
    }

    public Integer getComplexAtivo() {
        return complexAtivo;
    }

    public void setComplexAtivo(Integer complexAtivo) {
        this.complexAtivo = complexAtivo;
    }

    public Integer getHeteroAtivo() {
        return heteroAtivo;
    }

    public void setHeteroAtivo(Integer heteroAtivo) {
        this.heteroAtivo = heteroAtivo;
    }

    public Integer getLogNegLocal() {
        return logNegLocal;
    }

    public void setLogNegLocal(Integer logNegLocal) {
        this.logNegLocal = logNegLocal;
    }

    public Integer getProcessLocalEven() {
        return processLocalEven;
    }

    public void setProcessLocalEven(Integer processLocalEven) {
        this.processLocalEven = processLocalEven;
    }

    public Integer getRequiTempReal() {
        return requiTempReal;
    }

    public void setRequiTempReal(Integer requiTempReal) {
        this.requiTempReal = requiTempReal;
    }

    public Integer getGerenciaLocalDados() {
        return gerenciaLocalDados;
    }

    public void setGerenciaLocalDados(Integer gerenciaLocalDados) {
        this.gerenciaLocalDados = gerenciaLocalDados;
    }

    public Integer getSupriEnergia() {
        return supriEnergia;
    }

    public void setSupriEnergia(Integer supriEnergia) {
        this.supriEnergia = supriEnergia;
    }

    public Integer getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Integer ambiente) {
        this.ambiente = ambiente;
    }

    public Integer getTempVidaAtivo() {
        return tempVidaAtivo;
    }

    public void setTempVidaAtivo(Integer tempVidaAtivo) {
        this.tempVidaAtivo = tempVidaAtivo;
    }

    public Integer getRestriAtualHW() {
        return restriAtualHW;
    }

    public void setRestriAtualHW(Integer restriAtualHW) {
        this.restriAtualHW = restriAtualHW;
    }

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
