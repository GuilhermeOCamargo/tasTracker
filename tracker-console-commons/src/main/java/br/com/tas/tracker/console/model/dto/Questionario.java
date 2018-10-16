package br.com.tas.tracker.console.model.dto;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author guilherme.camargo
 * @since 08/10/2018
 * @version 1.0
 * */
@Entity
public class Questionario {
    private Long id;
    private AtivosDevices ativosDevices;
    private ComunicacaoConectividade comunicacaoConectividade;
    private ServicoBackend servicoBackend;
    private PadraoReqRegulatorio padraoReqRegulatorio;
    private AmbienteProjeto ambienteProjeto;
    private Calendar dtCriacao;
    private Calendar dtResposta;

    public Questionario(){
        this.ativosDevices = new AtivosDevices();
        this.comunicacaoConectividade = new ComunicacaoConectividade();
        this.servicoBackend = new ServicoBackend();
        this.padraoReqRegulatorio = new PadraoReqRegulatorio();
        this.ambienteProjeto = new AmbienteProjeto();
        this.dtCriacao = Calendar.getInstance();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public AtivosDevices getAtivosDevices() {
        return ativosDevices;
    }

    public void setAtivosDevices(AtivosDevices ativosDevices) {
        this.ativosDevices = ativosDevices;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public ComunicacaoConectividade getComunicacaoConectividade() {
        return comunicacaoConectividade;
    }

    public void setComunicacaoConectividade(ComunicacaoConectividade comunicacaoConectividade) {
        this.comunicacaoConectividade = comunicacaoConectividade;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public ServicoBackend getServicoBackend() {
        return servicoBackend;
    }

    public void setServicoBackend(ServicoBackend servicoBackend) {
        this.servicoBackend = servicoBackend;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public PadraoReqRegulatorio getPadraoReqRegulatorio() {
        return padraoReqRegulatorio;
    }

    public void setPadraoReqRegulatorio(PadraoReqRegulatorio padraoReqRegulatorio) {
        this.padraoReqRegulatorio = padraoReqRegulatorio;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public AmbienteProjeto getAmbienteProjeto() {
        return ambienteProjeto;
    }

    public void setAmbienteProjeto(AmbienteProjeto ambienteProjeto) {
        this.ambienteProjeto = ambienteProjeto;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Calendar getDtCriacao() {
        return dtCriacao;
    }
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    public void setDtCriacao(Calendar dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Calendar getDtResposta() {
        return dtResposta;
    }

    public void setDtResposta(Calendar dtResposta) {
        this.dtResposta = dtResposta;
    }
}
