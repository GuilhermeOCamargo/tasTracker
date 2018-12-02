package br.com.tas.tracker.console.services;

import br.com.tas.tracker.console.dao.QuestionarioDao;
import br.com.tas.tracker.console.exceptions.QuestionarioExistenteException;
import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Questionario;
import br.com.tas.tracker.console.util.JsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guilherme.camargo
 * @since 16/10/2018
 * @version 1.0
 * */
@Service
public class QuestionarioService {
    @Autowired
    private QuestionarioDao questionarioDao;
    @Autowired
    private EmpresaService empresaService;

    Logger log = LoggerFactory.getLogger(QuestionarioService.class);

    public Questionario findById(Long id){
        log.info("Procurando questionário: "+ id);
        return questionarioDao.findById(id);
    }

    public Questionario findByEmpresaPending(Empresa empresa){
        log.info("Procurando questionário pendente da empresa: "+ empresa.getNome());
        return questionarioDao.findByEmpresaPending(empresa);
    }

    public List<Questionario> findByEmpresaAnswered(Empresa empresa){
        log.info("Procurando questionário pendente da empresa: "+ empresa.getNome());
        return questionarioDao.findByEmpresaAnswered(empresa);
    }

    public List<Questionario> findByEmpresa(Empresa empresa){
        log.info("Procurando questionários pendente da empresa: "+ empresa.getNome());
        return questionarioDao.findByEmpresa(empresa);
    }

    public boolean save(Questionario questionario){
        log.info("Salvando questionario.");
        if(questionario.getId() == null){
            return questionarioDao.insert(questionario);
        }else{
            return questionarioDao.update(questionario);
        }
    }
    /**
     * @param id - Id da empresa
     * Cria um questionario para a empresa
     * @exception QuestionarioExistenteException - Ja existe um questionário pendente.
     * */
    public boolean createQuestionario(Long id){
        Empresa empresa = empresaService.findById(id);
        if(empresa == null){
            return false;
        }
        if(findByEmpresaPending(empresa) != null){
            throw new QuestionarioExistenteException();
        }
        log.info("Criando questionario para a empresa: "+ empresa.getNome());
        Questionario questionario = new Questionario(empresa);
        return save(questionario);
    }
}
