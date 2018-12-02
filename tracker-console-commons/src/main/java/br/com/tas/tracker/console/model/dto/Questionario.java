package br.com.tas.tracker.console.model.dto;

import br.com.tas.tracker.console.model.form.QuestionarioForm;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author guilherme.camargo
 * @since 08/10/2018
 * @version 1.0
 * */
@NamedQueries({
        @NamedQuery(name = "QUESTIONARIO.findById", query = "SELECT q FROM Questionario q WHERE q.id = :id"),
        @NamedQuery(name = "QUESTIONARIO.findByEmpresa", query = "SELECT q FROM Questionario q WHERE q.empresa = :empresa ORDER BY dtCriacao"),
        @NamedQuery(name = "QUESTIONARIO.findByEmpresaPending", query = "SELECT q FROM Questionario q WHERE q.empresa = :empresa " +
                "AND q.dtResposta IS NULL"),
        @NamedQuery(name = "QUESTIONARIO.findByEmpresaAnswered", query = "SELECT q FROM Questionario q WHERE q.empresa = :empresa " +
                "AND q.dtResposta IS NOT NULL ORDER BY dtCriacao")

})
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
    private Empresa empresa;

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

    public void setDtCriacao(Calendar dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    public Calendar getDtResposta() {
        return dtResposta;
    }

    public void setDtResposta(Calendar dtResposta) {
        this.dtResposta = dtResposta;
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Converte o Questionário em um form
     * */
    public QuestionarioForm toForm(){
        QuestionarioForm form = new QuestionarioForm();
        form.setAtivosDevicesForm(this.getAtivosDevices().toForm());
        form.setComunicacaoConectividadeForm(this.getComunicacaoConectividade().toForm());
        form.setServicoBackendForm(this.getServicoBackend().toForm());
        form.setPadraoReqRegulatorioForm(this.getPadraoReqRegulatorio().toForm());
        form.setAmbienteProjetoForm(this.getAmbienteProjeto().toForm());
        form.setId(this.getId());
        form.setDtCriacao(this.getDtCriacao().getTimeInMillis());
        form.setEmpresaId(this.getEmpresa().getId());
        return form;
    }
    /**
     * Construtor que recebe uma empresa como parametro
     * */
    public Questionario(Empresa empresa){
        this.ativosDevices = new AtivosDevices();
        this.comunicacaoConectividade = new ComunicacaoConectividade();
        this.servicoBackend = new ServicoBackend();
        this.padraoReqRegulatorio = new PadraoReqRegulatorio();
        this.ambienteProjeto = new AmbienteProjeto();
        this.dtCriacao = Calendar.getInstance();
        this.empresa = empresa;
    }
    /**
     * Construtor que transforma um form em um Questionario
     * */
    public Questionario(QuestionarioForm form, Empresa empresa){
        this.id = form.getId();
        Calendar dtCriacao = Calendar.getInstance();
        dtCriacao.setTimeInMillis(form.getDtCriacao());
        this.dtCriacao = dtCriacao;
        this.empresa = empresa;
        this.ativosDevices = new AtivosDevices(form.getAtivosDevicesForm());
        this.comunicacaoConectividade = new ComunicacaoConectividade(form.getComunicacaoConectividadeForm());
        this.servicoBackend = new ServicoBackend(form.getServicoBackendForm());
        this.padraoReqRegulatorio = new PadraoReqRegulatorio(form.getPadraoReqRegulatorioForm());
        this.ambienteProjeto = new AmbienteProjeto(form.getAmbienteProjetoForm());
        this.dtResposta = Calendar.getInstance();
    }
    /**
     * Construtor padrão
     * */
    public Questionario(){}
}
