package br.com.tas.tracker.console.model.dto;

import br.com.tas.tracker.console.model.form.EmpresaForm;

import javax.persistence.*;

/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 **/
@NamedQueries({
        /*DELETE BY ID*/
        @NamedQuery(name = "EMPRESA.deleteById", query = "DELETE FROM Empresa e WHERE e.id = :id"),
        /*FIND ALL*/
        @NamedQuery(name = "EMPRESA.findAll", query = "SELECT e FROM Empresa e ORDER BY nome"),
        /*FIND BY ID*/
        @NamedQuery(name = "EMPRESA.findById", query = "SELECT e FROM Empresa e WHERE e.id = :id"),
        /*FIND BY NAME*/
        @NamedQuery(name = "EMPRESA.findByName", query = "SELECT e FROM Empresa e WHERE e.nome = :nome"),
        /*FIND BY CNPJ*/
        @NamedQuery(name = "EMPRESA.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")
})
@Entity
public class Empresa {
    private Long id;
    private String nome;
    private String cnpj;
    private Usuario usuarioResponsavel;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(nullable = false, length = 50)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Column(nullable = false, length = 14)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public EmpresaForm toForm(){
        EmpresaForm form = new EmpresaForm();
        form.setId(this.getId());
        form.setCnpj(this.getCnpj());
        form.setNome(this.getNome());
        form.setUsuarioId(this.getUsuarioResponsavel().getId());
        return form;
    }
}
