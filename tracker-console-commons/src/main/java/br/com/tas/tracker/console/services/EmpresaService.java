package br.com.tas.tracker.console.services;

import br.com.tas.tracker.console.dao.EmpresaDao;
import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Questionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);
    @Autowired
    private EmpresaDao empresaDao;

    private boolean insert(Empresa empresa) {
        log.info("Inserindo Empresa: "+ empresa.getNome());
        return empresaDao.insert(empresa);
    }

    private boolean update(Empresa empresa) {
        log.info("Alterando Empresa: "+ empresa.getNome());
        return empresaDao.update(empresa);
    }

    public boolean delete(Empresa empresa) {
        log.info("Deletando Empresa: "+ empresa.getNome());
        return empresaDao.delete(empresa);
    }

    public boolean deleteById(Long id) {
        log.info("Deletando Empresa com id: "+id);
        return empresaDao.deleteById(id);
    }

    public List<Empresa> findAll() {
        log.info("Buscando todas as empresas.");
        return empresaDao.findAll();
    }

    public Empresa findById(Long id) {
        log.info("Buscando Empresa com id: "+id);
        return empresaDao.findById(id);
    }

    public Empresa findByName(String name){
        log.info("Buscando Empresa por Nome: " +name);
        return empresaDao.findByName(name);
    }

    public Empresa findByCnpj(String cnpj){
        log.info("Buscando Empresa por cnpj: " +cnpj);
        return empresaDao.findByCnpj(cnpj);
    }

    /**
     * @param empresa - Empresa a ser salva no banco
     * */
    public boolean save(Empresa empresa) {
        if(empresa.getId() == null){
            return insert(empresa);
        }else{
            return update(empresa);
        }
    }
    /**
     * @param id - Id da empresa
     * Cria um questionario para a empresa
     * */
    public boolean createQuestionario(Long id){
        Empresa empresa = findById(id);
        if(empresa == null){
            return false;
        }
        Questionario questionario = new Questionario();
        if(empresa.getQuestionarios() == null){
            List<Questionario> questionarios = new ArrayList<>();
            questionarios.add(questionario);
            empresa.setQuestionarios(questionarios);
        }else{
            empresa.getQuestionarios().add(questionario);
        }
        return save(empresa);
    }

}