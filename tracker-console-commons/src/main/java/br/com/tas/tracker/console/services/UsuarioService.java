package br.com.tas.tracker.console.services;

import br.com.tas.tracker.console.dao.UsuarioDao;
import br.com.tas.tracker.console.model.dto.Permissao;
import br.com.tas.tracker.console.model.dto.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author guilherme.camargo
 * @since 20/09/2018
 * @version 1.0
 * */
@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioDao userDao;
    @Autowired
    private PermissaoService permissaoService;

    private boolean insert(Usuario usuario) {
        log.info("Inserindo usuário: "+ usuario.getNome());
        return userDao.insert(usuario);
    }

    private boolean update(Usuario usuario) {
        log.info("Alterando usuário: "+ usuario.getNome());
        return userDao.update(usuario);
    }

    public boolean delete(Usuario usuario) {
        log.info("Deletando usuário: "+ usuario.getNome());
        return userDao.delete(usuario);
    }

    public boolean deleteById(Long id) {
        log.info("Deletando usuário com id: "+id);
        return userDao.deleteById(id);
    }

    public List<Usuario> findAll() {
        log.info("Buscando todos os usuários.");
        return userDao.findAll();
    }

    public Usuario findById(Long id) {
        log.info("Buscando usuário com id: "+id);
        return userDao.findById(id);
    }

    public Usuario findByEmail(String email){
        log.info("Buscando usuário por E-mail: " +email);
        return userDao.findByEmail(email);
    }

    public List<Usuario> findAllEmpresas(){
        log.info("Buscando usuários com perfil de empresa");
        return userDao.findByPermissao(permissaoService.findByName("Empresa"));
    }

    public Usuario authenticate(String email, String senha){
        log.info("Tentando autenticar o usuário: "+ email);
        return userDao.authenticate(email, senha);
    }

    public List<Usuario> findAllExceptLogged(String logged){
        log.info("Buscando todos os usuário com exceção do usuário logado: "+ logged);
        return userDao.findAllExceptLogged(logged);
    }

    /**
     * @param usuario - Usuário a ser salvo no banco
     * */
    public boolean save(Usuario usuario) {
        if(usuario.getId() == null){
            return insert(usuario);
        }else{
            return update(usuario);
        }
    }

    /**
     * @param usuario - Usuário a ser validado
     * Verifica se todos os campos estão de acordo com as regras estabelecidas
     * */
    /*private void validateFields(usuario usuario) {
        log.info("Validando todos os campos do usuário");
        if(usuario.getNome() == null){
            log.error("Validação nome null - falhou");
            throw new UserNomeNullException();
        }
        log.info("Validação nome null - OK");
        if(usuario.getNome().length() > 100){
            log.error("Validação nome chars - falhou");
            throw new UserNomeLimitCharsException();
        }
        log.info("Validação nome chars - OK");
        if(usuario.getEmail() == null){
            log.error("Validação email null - falhou");
            throw new UserEmailNullException();
        }
        log.info("Validação email null - OK");
        if(usuario.getEmail().length() > 50){
            log.error("Validação email chars - falhou");
            throw new UserEmailCharsException();
        }
        log.info("Validação email chars - OK");
       *//* if(findByEmail(usuario.getEmail()) != null){
            log.error("Validação email unique - falhou");
            throw new UserEmailUniqueException();
        }*//*
        log.info("Validação email unique - OK");
        if(usuario.getSenha() == null){
            log.error("Validação senha null - falhou");
            throw new UserSenhaNullException();
        }
        log.info("Validação senha null - OK");
        if(usuario.getSenha().length() > 15 || usuario.getSenha().length() < 8){
            log.error("Validação senha chars - falhou");
            throw new UserSenhaCharsException();
        }
        log.info("Validação senha chars - OK");
        if(usuario.getPermissao() == null){
            log.error("Validação permissão null - falhou");
            throw new UserPermissaoNullException();
        }
        log.info("Validação permissão null - OK");
    }*/

}
