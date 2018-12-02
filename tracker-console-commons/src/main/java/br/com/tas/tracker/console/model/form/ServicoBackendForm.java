package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.ServicoBackend;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 **/
public class ServicoBackendForm extends ServicoBackend {
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getEstrategiaApliacacao() {
        return super.getEstrategiaApliacacao();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getComplexNegocio() {
        return super.getComplexNegocio();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getIntegraBackend() {
        return super.getIntegraBackend();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getVolumDadosDia() {
        return super.getVolumDadosDia();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getVariedadeDados() {
        return super.getVariedadeDados();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getMudancaSchema() {
        return super.getMudancaSchema();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getAnalytics() {
        return super.getAnalytics();
    }
}
