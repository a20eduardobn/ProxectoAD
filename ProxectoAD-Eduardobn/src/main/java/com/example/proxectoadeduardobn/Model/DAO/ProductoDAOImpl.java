package com.example.proxectoadeduardobn.Model.DAO;

import com.example.proxectoadeduardobn.Model.DTO.ProductoDTO;
import com.example.proxectoadeduardobn.Model.Entities.Producto;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;

public class ProductoDAOImpl implements DAO<Producto>{

    private final EntityManager eManager;

    public ProductoDAOImpl(EntityManager eManager) {this.eManager=eManager;}

    public Producto get(int id) {
        return eManager.find(Producto.class, id);
    }

    public ProductoDTO getAsDTO(int id){
        Producto prod = eManager.find(Producto.class, id);
        return convertToDTO(prod);
    }

    private ProductoDTO convertToDTO(Producto prod){
        ProductoDTO prodDTO = new ProductoDTO();
        prodDTO.setMarca(prod.getMarca());
        prodDTO.setProveedor(prod.getProveedor());
        prodDTO.setModelo(prod.getModelo());
        prodDTO.setPrecio(prod.getPrecio());
        prodDTO.setNombre(prod.getNombre());
        prodDTO.setImagen(prod.getImagen());
        prodDTO.setStock(prod.getStock());
        return prodDTO;
    }

    @Override
    public java.util.List<Producto> getAll() {
        return eManager.createQuery("FROM Producto").getResultList();
    }

    public java.util.List<ProductoDTO> getAllAsDTO() {
        java.util.List<Producto> productos = eManager.createQuery("FROM Producto").getResultList();
        java.util.List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
        for (Producto prod: productos) {
            productosDTO.add(convertToDTO(prod));
        }
        return productosDTO;
    }

    @Override
    public void save(Producto producto) {
        eManager.persist(producto);
    }

    @Override
    public void update(Producto producto) {
        eManager.merge(producto);
    }

    @Override
    public void delete(Producto producto) {
        eManager.remove(producto);
    }

    public void deleteById(int id) {
        eManager.remove(get(id));
    }

    @Override
    public void deleteAll() {
        eManager.createQuery("DELETE FROM Producto").executeUpdate();
    }
}