package com.example.proxectoadeduardobn.Model.DAO;

import com.example.proxectoadeduardobn.Model.Entities.Proveedor;
import jakarta.persistence.EntityManager;

public class ProveedorDAOImpl implements DAO<Proveedor>{

    private final EntityManager eManager;

    public ProveedorDAOImpl(EntityManager eManager) {this.eManager=eManager;}

    public Proveedor get(String cif) {
        return eManager.find(Proveedor.class, cif);
    }

    @Override
    public java.util.List<Proveedor> getAll() {
        return eManager.createQuery("FROM Proveedor").getResultList();
    }

    @Override
    public void save(Proveedor proveedor) {
        eManager.persist(proveedor);
    }

    @Override
    public void update(Proveedor proveedor) {
        eManager.merge(proveedor);
    }

    @Override
    public void delete(Proveedor proveedor) {
        eManager.remove(proveedor);
    }


    public void deleteByCif(String cif) {
        eManager.remove(get(cif));
    }

    @Override
    public void deleteAll() {
        eManager.createQuery("DELETE FROM Proveedor").executeUpdate();
    }
}

