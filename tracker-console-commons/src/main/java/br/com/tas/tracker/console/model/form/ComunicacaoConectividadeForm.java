package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.ComunicacaoConectividade;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * @author guilherme.camargo
 * @since 09/10/2018
 * @version 1.0
 * */
public class ComunicacaoConectividadeForm extends ComunicacaoConectividade {
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getTecnologiaLocal() {
        return super.getTecnologiaLocal();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getLarguraBandaLocal() {
        return super.getLarguraBandaLocal();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getLatenciaMaxLocal() {
        return super.getLatenciaMaxLocal();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getTecnologiaRemota() {
        return super.getTecnologiaRemota();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getLarguraBandaRemota() {
        return super.getLarguraBandaRemota();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getLatenciaMaxRemota() {
        return super.getLatenciaMaxRemota();
    }
}
