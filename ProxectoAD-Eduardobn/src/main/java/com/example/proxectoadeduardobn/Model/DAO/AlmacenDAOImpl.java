package com.example.proxectoadeduardobn.Model.DAO;

import com.example.proxectoadeduardobn.Model.Entities.Almacen;
import jakarta.persistence.EntityManager;


public class AlmacenDAOImpl implements DAO<Almacen>{

    private final EntityManager eManager;

    public AlmacenDAOImpl(EntityManager eManager) {this.eManager=eManager;}

    public Almacen get(int id) {
        return eManager.find(Almacen.class, id);
    }

    @Override
    public java.util.List<Almacen> getAll() {
        return eManager.createQuery("FROM Almacen").getResultList();
    }

    @Override
    public void save(Almacen almacen) {
        eManager.persist(almacen);
    }

    @Override
    public void update(Almacen almacen) {
        eManager.merge(almacen);
    }

    @Override
    public void delete(Almacen almacen) {
        eManager.remove(almacen);
    }

    public void deleteById(int id) {
        eManager.remove(get(id));
    }

    @Override
    public void deleteAll() {
        eManager.createQuery("DELETE FROM Almacen").executeUpdate();
    }
}

