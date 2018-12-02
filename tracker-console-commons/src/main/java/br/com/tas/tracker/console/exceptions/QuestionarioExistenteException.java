package br.com.tas.tracker.console.exceptions;

public class QuestionarioExistenteException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Já existe um questionário pendente para a empresa selecionada.";
    }
}
