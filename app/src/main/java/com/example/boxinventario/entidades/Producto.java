package com.example.boxinventario.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Producto implements  Serializable, Parcelable {

    private int id;
    private String nameproducto;
    private String fechaproducto;
    private String cantidad;
    private String precio;
    private String categoria;
    private String ubicacion;

    public Producto(int id, String nameproducto, String fechaproducto, String cantidad, String precio, String categoria, String ubicacion) {
        this.id = id;
        this.nameproducto = nameproducto;
        this.fechaproducto = fechaproducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
    }

    protected Producto(Parcel in) {
        categoria = in.readString();
        nameproducto = in.readString();
        fechaproducto = in.readString();
        cantidad = in.readString();
        precio = in.readString();
        ubicacion = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNameproducto() {
        return nameproducto;
    }

    public void setNameproducto(String nameproducto) {
        this.nameproducto = nameproducto;
    }

    public String getFechaproducto() {
        return fechaproducto;
    }

    public void setFechaproducto(String fechaproducto) {
        this.fechaproducto = fechaproducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeString(this.nameproducto);
        parcel.writeString(this.fechaproducto);
        parcel.writeString(String.valueOf(this.cantidad));
        parcel.writeString(this.ubicacion);
        parcel.writeString(this.categoria);
        parcel.writeString(String.valueOf(this.precio));
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
}
