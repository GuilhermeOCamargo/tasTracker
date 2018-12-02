package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.AtivosDevices;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 **/
public class AtivosDevicesForm extends AtivosDevices {
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getNumAtivos() {
        return super.getNumAtivos();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getValorAtiInd() {
        return super.getValorAtiInd();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getValorEconAtiAno() {
        return super.getValorEconAtiAno();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getComplexAtivo() {
        return super.getComplexAtivo();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getHeteroAtivo() {
        return super.getHeteroAtivo();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getLogNegLocal() {
        return super.getLogNegLocal();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getProcessLocalEven() {
        return super.getProcessLocalEven();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getRequiTempReal() {
        return super.getRequiTempReal();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getGerenciaLocalDados() {
        return super.getGerenciaLocalDados();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getSupriEnergia() {
        return super.getSupriEnergia();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getAmbiente() {
        return super.getAmbiente();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getTempVidaAtivo() {
        return super.getTempVidaAtivo();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getRestriAtualHW() {
        return super.getRestriAtualHW();
    }

    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getRestriAtualSW() {
        return super.getRestriAtualSW();
    }

}
