package com.example.proxectoadeduardobn.Model.Entities;

import jakarta.persistence.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int idProducto;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String marca;
    @Column(length = 40)
    private String modelo;
    @Column(length = 150)
    private String descripcion;
    @Column(precision = 6, scale = 2)
    private BigDecimal precio = new BigDecimal(0);
    @Column(length = 6)
    private int stock;
    private boolean activo;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imagen;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "cifProveedor")
    private Proveedor proveedor;
    @ManyToMany
    @JoinTable(
            name = "ProductoAlmacen",
            joinColumns = @JoinColumn(name = "idProducto"),
            inverseJoinColumns = @JoinColumn(name = "idAlmacen")
    )
    private List<Almacen> almacenes = new ArrayList<>();

    public Producto() {
    }

    public Producto(String nombre, String marca, String modelo, String descripcion, double precio, int stock, boolean activo, byte[] imagen, Categoria categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = new BigDecimal(precio);
        this.stock = stock;
        this.activo = activo;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio.doubleValue();
    }

    public void setPrecio(double precio) {
        this.precio= new BigDecimal(precio);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public void setImagenFromURL(String link){
        URL url = null;
        try {
            url = new URI(link).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (InputStream in = url.openStream()) {
            this.imagen= in.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void addAlmacen(Almacen almacen){
        this.almacenes.add(almacen);
    }

    public void addAlmacen(List<Almacen> almacenes){
        this.almacenes.addAll(almacenes);
    }

    public void removeAlmacen(Almacen almacen){
        this.almacenes.remove(almacen);
    }

    public List<Almacen> getAlmacenes(){
        return almacenes;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", activo=" + activo +
                ", imagen=" + Arrays.toString(imagen) +
                ", categoria=" + categoria +
                ", proveedor=" + proveedor +
                ", almacenes=" + almacenes +
                '}';
    }
}
