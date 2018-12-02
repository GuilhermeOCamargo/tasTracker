package br.com.tas.tracker.console.dao;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Questionario;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
/**
 * @author guilherme.camargo
 * @since 16/10/2018
 * @version 1.0
 * */
@Repository
public class QuestionarioDao implements DaoInterface<Questionario> {


    @Override
    public boolean insert(Questionario questionario) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.save(questionario);
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
    public boolean update(Questionario questionario) {
        Session session = null;
        Transaction tx = null;
        boolean isCompleted = false;
        try{
            session = HibernateUtil.openSession();
            tx = session.beginTransaction();
            session.update(questionario);
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
    public boolean delete(Questionario questionario) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Questionario> findAll() {
        return null;
    }

    @Override
    public Questionario findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Questionario) session.getNamedQuery("QUESTIONARIO.findById").setParameter("id", id).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public List<Questionario> findByEmpresa(Empresa empresa) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return session.getNamedQuery("QUESTIONARIO.findByEmpresa")
                    .setParameter("empresa", empresa).list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Questionario findByEmpresaPending(Empresa empresa) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return (Questionario) session.getNamedQuery("QUESTIONARIO.findByEmpresaPending")
                    .setParameter("empresa", empresa).uniqueResult();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public List<Questionario> findByEmpresaAnswered(Empresa empresa) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return session.getNamedQuery("QUESTIONARIO.findByEmpresaAnswered")
                    .setParameter("empresa", empresa).list();
        }catch (NoResultException e) {
            return null;
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
