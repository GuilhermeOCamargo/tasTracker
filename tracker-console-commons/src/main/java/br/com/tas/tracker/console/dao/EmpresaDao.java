package br.com.tas.tracker.console.dao;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
@Repository
public class EmpresaDao implements DaoInterface<Empresa> {
    @Override
    public boolean insert(Empresa empresa) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.save(empresa);
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
    public boolean update(Empresa empresa) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.update(empresa);
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
    public boolean delete(Empresa empresa) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.delete(empresa);
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
            session.getNamedQuery("EMPRESA.deleteById").setParameter("id", id).executeUpdate();
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
    public List<Empresa> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return session.getNamedQuery("EMPRESA.findAll").list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public Empresa findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Empresa) session.getNamedQuery("EMPRESA.findById").setParameter("id", id).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
    public Empresa findByName(String nome) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Empresa) session.getNamedQuery("EMPRESA.findByName").
                    setParameter("nome", nome).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
    public Empresa findByCnpj(String cnpj) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return  (Empresa)session.getNamedQuery("EMPRESA.findByCnpj").
                    setParameter("cnpj", cnpj).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public List<Empresa> findByUsuario(Usuario usuario) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return session.getNamedQuery("EMPRESA.findByUsuario")
                    .setParameter("usuario", usuario).list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
