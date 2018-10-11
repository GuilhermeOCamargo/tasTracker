package br.com.tas.tracker.console.services;

import br.com.tas.tracker.console.dao.PermissaoDao;
import br.com.tas.tracker.console.model.dto.Permissao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author guilherme.camargo
 * @since 24/09/2018
 * @version 1.0
 * */
@Service
public class PermissaoService {
    private static final Logger log = LoggerFactory.getLogger(PermissaoService.class);
    @Autowired
    private PermissaoDao permissaoDao;

    public List<Permissao> findAll(){
        log.info("Buscando todas as permissões.");
        return permissaoDao.findAll();
    }
    public Permissao findById(Long id){
        log.info("Buscando permissão por id: "+ id);
        return permissaoDao.findById(id);
    }
    public Permissao findByName(String name){
        log.info("Buscando permissão por nome: "+ name);
        return permissaoDao.findByName(name);
    }
}
