package br.com.tas.tracker.console.services;

import java.util.List;
/**
 * @author guilherme.camargo
 * @since 20/09/2018
 * @version 1.0
 * */
public interface ServiceInterface<T extends Object> {

    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    boolean deleteById(Long id);
    List<T> findAll();
    T findById(Long id);
    boolean save(T t);
    Object validateFields(T t);
}
