package com.example.proxectoadeduardobn.Model.DAO;

import java.util.List;

public interface DAO<T>{
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    void deleteAll();
    List<T> executeCustomQuery(String s);
}
