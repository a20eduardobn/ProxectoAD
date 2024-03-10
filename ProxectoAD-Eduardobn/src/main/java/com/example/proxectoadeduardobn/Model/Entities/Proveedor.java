package com.example.proxectoadeduardobn.Model.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Proveedor {
    @Id
    @Column(length = 9)
    private String cif;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 10, nullable = false)
    private String telefonoContacto;
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos = new ArrayList<>();
    @Embedded
    private Direccion direccion;

    public Proveedor() {
    }

    public Proveedor(String cif, String nombre, String telefonoContacto, Direccion direccion) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefonoContacto = telefonoContacto;
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void addProducto(Collection<Producto> productos) {
        this.productos.addAll(productos);
    }

    public void removeProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefonoContacto='" + telefonoContacto + '\'' +
                ", direccion=" + direccion.getCodigoPostal() +", "+direccion.getCalle()+", "+direccion.getCiudad()+
                ", "+direccion.getProvincia()+
                '}';
    }
}
