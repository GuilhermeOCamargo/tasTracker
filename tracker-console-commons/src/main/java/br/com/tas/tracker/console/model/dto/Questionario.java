package br.com.tas.tracker.console.model.dto;
/**
 * @author guilherme.camargo
 * @since 08/10/2018
 * @version 1.0
 * */
public class Questionario {
    private Long id;
    private AtivosDevices ativosDevices;
    private ComunicacaoConectividade comunicacaoConectividade;
    private ServicoBackend servicoBackend;
    private PadraoReqRegulatorio padraoReqRegulatorio;
    private AmbienteProjeto ambienteProjeto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtivosDevices getAtivosDevices() {
        return ativosDevices;
    }

    public void setAtivosDevices(AtivosDevices ativosDevices) {
        this.ativosDevices = ativosDevices;
    }

    public ComunicacaoConectividade getComunicacaoConectividade() {
        return comunicacaoConectividade;
    }

    public void setComunicacaoConectividade(ComunicacaoConectividade comunicacaoConectividade) {
        this.comunicacaoConectividade = comunicacaoConectividade;
    }

    public ServicoBackend getServicoBackend() {
        return servicoBackend;
    }

    public void setServicoBackend(ServicoBackend servicoBackend) {
        this.servicoBackend = servicoBackend;
    }

    public PadraoReqRegulatorio getPadraoReqRegulatorio() {
        return padraoReqRegulatorio;
    }

    public void setPadraoReqRegulatorio(PadraoReqRegulatorio padraoReqRegulatorio) {
        this.padraoReqRegulatorio = padraoReqRegulatorio;
    }

    public AmbienteProjeto getAmbienteProjeto() {
        return ambienteProjeto;
    }

    public void setAmbienteProjeto(AmbienteProjeto ambienteProjeto) {
        this.ambienteProjeto = ambienteProjeto;
    }
}
