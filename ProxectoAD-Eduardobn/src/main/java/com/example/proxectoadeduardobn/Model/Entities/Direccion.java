package com.example.proxectoadeduardobn.Model.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion implements java.io.Serializable {
    @Column(length = 40)
    private String calle;
    @Column(length = 40)
    private String ciudad;
    @Column(length = 20)
    private String provincia;
    @Column(length = 5, nullable = false)
    private String codigoPostal;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad, String provincia, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}
