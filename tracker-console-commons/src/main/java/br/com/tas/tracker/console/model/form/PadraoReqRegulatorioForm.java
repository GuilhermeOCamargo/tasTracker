package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.PadraoReqRegulatorio;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 * */
public class PadraoReqRegulatorioForm extends PadraoReqRegulatorio {
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getRegionalEsp() {
        return super.getRegionalEsp();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getIndustriaEsp() {
        return super.getIndustriaEsp();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getTecnologiaEsp() {
        return super.getTecnologiaEsp();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getTecnicoPad() {
        return super.getTecnicoPad();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getFuncionalPad() {
        return super.getFuncionalPad();
    }
}
