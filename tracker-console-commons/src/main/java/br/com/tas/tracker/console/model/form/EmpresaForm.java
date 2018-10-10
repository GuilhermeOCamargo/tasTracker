package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.Empresa;

public class EmpresaForm extends Empresa {
    private int usuarioId;
    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getCnpj() {
        return super.getCnpj();
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
