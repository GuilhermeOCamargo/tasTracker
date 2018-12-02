package br.com.tas.tracker.console.dao;

import br.com.tas.tracker.console.model.dto.Permissao;
import br.com.tas.tracker.console.util.HibernateUtil;
import br.com.tas.tracker.console.model.dto.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author guilherme.camargo
 * @since 17/09/2018
 * @version 1.0
 * */
@Repository
public class UsuarioDao implements DaoInterface<Usuario> {

    @Override
    public boolean insert(Usuario usuarioDto) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.save(usuarioDto);
            tx.commit();
            isCompleted = true;
        }catch (RuntimeException e){
            e.printStackTrace();
            try{
                tx.rollback();
            }catch (RuntimeException rte){
            }
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return isCompleted;
    }

    @Override
    public boolean update(Usuario usuarioDto) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.update(usuarioDto);
            tx.commit();
            isCompleted = true;
        }catch (RuntimeException e){
            e.printStackTrace();
            try{
                tx.rollback();
            }catch (RuntimeException rte){
            }
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return isCompleted;
    }

    @Override
    public boolean delete(Usuario usuarioDto) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.delete(usuarioDto);
            tx.commit();
            isCompleted = true;
        }catch (RuntimeException e){
            e.printStackTrace();
            try{
                tx.rollback();
            }catch (RuntimeException rte){
            }
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return isCompleted;
    }

    @Override
    public boolean deleteById(Long id) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try {
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.getNamedQuery("USUARIO.deleteById").setParameter("id", id).executeUpdate();
            tx.commit();
            isCompleted = true;
        }catch (RuntimeException e) {
            e.printStackTrace();
            try {
                tx.rollback();
            } catch (RuntimeException rte) {
            }
        }finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return isCompleted;
    }

    @Override
    public List<Usuario> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return session.getNamedQuery("USUARIO.findAll").list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public Usuario findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Usuario) session.getNamedQuery("USUARIO.findById").setParameter("id", id).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Usuario findByEmail(String email) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Usuario) session.getNamedQuery("USUARIO.findByEmail").
                    setParameter("email", email).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
    public List<Usuario> findByPermissao(Permissao permissao) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return  session.getNamedQuery("USUARIO.findByPermission").
                    setParameter("permissao", permissao).list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Usuario authenticate(String email, String senha) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Usuario) session.getNamedQuery("USUARIO.authenticate").
                    setParameter("email", email).setParameter("senha", senha).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public List<Usuario> findAllExceptLogged(String email) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return  session.getNamedQuery("USUARIO.findAllExceptLogged").
                    setParameter("email", email).list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
