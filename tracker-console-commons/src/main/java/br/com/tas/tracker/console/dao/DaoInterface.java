package br.com.tas.tracker.console.dao;

import java.util.List;

/**
 * @author guilherme.camargo
 * @since 17/09/2018
 * @version 1.0
 * */
public interface DaoInterface<T extends Object> {

    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    boolean deleteById(Long id);

    /*Named Queries - Select*/
    List<T> findAll();
    T findById(Long id);

}
