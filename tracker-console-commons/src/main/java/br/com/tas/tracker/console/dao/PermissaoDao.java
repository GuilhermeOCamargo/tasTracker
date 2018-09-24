package br.com.tas.tracker.console.dao;

import br.com.tas.tracker.console.Util.HibernateUtil;
import br.com.tas.tracker.console.model.dto.Permissao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
/**
 * @author guilherme.camargo
 * @since 23/09/2018
 * @version 1.0
 * */
@Repository
public class PermissaoDao {

    public List<Permissao> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return session.getNamedQuery("PERMISSAO.findAll").list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Permissao findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Permissao) session.getNamedQuery("PERMISSAO.findById").setParameter("id", id).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
