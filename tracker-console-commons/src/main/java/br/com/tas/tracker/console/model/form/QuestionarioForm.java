package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.Questionario;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.Long;

/**
 * @author guilherme.camargo
 * @since 08/10/2018
 * @version 1.0
 * */
public class QuestionarioForm {

    private Long id;
    private Long dtCriacao;
    private Long empresaId;
    @NotNull
    @Valid
    private AtivosDevicesForm ativosDevicesForm;
    @NotNull
    @Valid
    private ComunicacaoConectividadeForm comunicacaoConectividadeForm;
    @NotNull
    @Valid
    private ServicoBackendForm servicoBackendForm;
    @NotNull
    @Valid
    private PadraoReqRegulatorioForm padraoReqRegulatorioForm;
    @NotNull
    @Valid
    private AmbienteProjetoForm ambienteProjetoForm;

    public AtivosDevicesForm getAtivosDevicesForm() {
        return ativosDevicesForm;
    }

    public void setAtivosDevicesForm(AtivosDevicesForm ativosDevicesForm) {
        this.ativosDevicesForm = ativosDevicesForm;
    }

    public ComunicacaoConectividadeForm getComunicacaoConectividadeForm() {
        return comunicacaoConectividadeForm;
    }

    public void setComunicacaoConectividadeForm(ComunicacaoConectividadeForm comunicacaoConectividadeForm) {
        this.comunicacaoConectividadeForm = comunicacaoConectividadeForm;
    }

    public ServicoBackendForm getServicoBackendForm() {
        return servicoBackendForm;
    }

    public void setServicoBackendForm(ServicoBackendForm servicoBackendForm) {
        this.servicoBackendForm = servicoBackendForm;
    }

    public PadraoReqRegulatorioForm getPadraoReqRegulatorioForm() {
        return padraoReqRegulatorioForm;
    }

    public void setPadraoReqRegulatorioForm(PadraoReqRegulatorioForm padraoReqRegulatorioForm) {
        this.padraoReqRegulatorioForm = padraoReqRegulatorioForm;
    }

    public AmbienteProjetoForm getAmbienteProjetoForm() {
        return ambienteProjetoForm;
    }

    public void setAmbienteProjetoForm(AmbienteProjetoForm ambienteProjetoForm) {
        this.ambienteProjetoForm = ambienteProjetoForm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Long dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

}
