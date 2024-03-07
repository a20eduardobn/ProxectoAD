package com.example.proxectoadeduardobn.Model.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private int idAlmacen;
    @Column(length = 50)
    private String nombre;
    @Embedded
    private Direccion direccion;
    @Column(length = 6)
    private int capacidadCajas;
    private boolean refrigerado;
    @ManyToMany(mappedBy = "almacenes")
    private List<Producto> productos = new ArrayList<>();

    public Almacen() {
    }

    public Almacen(String nombre, Direccion direccion, int capacidadCajas, boolean refrigerado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadCajas = capacidadCajas;
        this.refrigerado = refrigerado;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getCapacidadCajas() {
        return capacidadCajas;
    }

    public void setCapacidadCajas(int capacidadCajas) {
        this.capacidadCajas = capacidadCajas;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void addProducto(List<Producto> productos) {
        this.productos.addAll(productos);
    }

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "idAlmacen=" + idAlmacen +
                ", nombre='" + nombre + '\'' +
                ", capacidadCajas=" + capacidadCajas +
                ", refrigerado=" + refrigerado +
                ", productos=" + productos +
                ", direccion=" + direccion.getCodigoPostal() +", "+direccion.getCalle()+", "+direccion.getCiudad()+
                ", "+direccion.getProvincia()+
                '}';
    }
}