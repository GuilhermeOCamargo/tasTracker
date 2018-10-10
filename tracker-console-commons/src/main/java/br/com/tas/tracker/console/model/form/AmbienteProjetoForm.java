package br.com.tas.tracker.console.model.form;

import br.com.tas.tracker.console.model.dto.AmbienteProjeto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AmbienteProjetoForm extends AmbienteProjeto {
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getTempo() {
        return super.getTempo();
    }
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getOrcamento() {
        return super.getOrcamento();
    }
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getHabFuncExp() {
        return super.getHabFuncExp();
    }
    @Min(1)
    @Max(4)
    @NotNull
    @Override
    public Integer getHabTecExp() {
        return super.getHabTecExp();
    }
}
