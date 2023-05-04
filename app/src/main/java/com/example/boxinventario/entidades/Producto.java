package com.example.boxinventario.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Producto implements  Serializable, Parcelable {

    public String color;
    public String nameproducto;
    //public Date fechaproducto;
    public String fechaproducto;
    public String cantidad;
    public String precio;
    public String categoria;
    public String ubicacion;

    public Producto(String color, String nameproducto, String fechaproducto, String cantidad, String precio, String ubicacion, String categoria){
        this.color = color;
        this.nameproducto = nameproducto;
        this.fechaproducto = fechaproducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }

    protected Producto(Parcel in) {
        categoria = in.readString();
        color = in.readString();
        nameproducto = in.readString();
        fechaproducto = in.readString();
        cantidad = in.readString();
        precio = in.readString();
        ubicacion = in.readString();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        parcel.writeString(color);
        parcel.writeString(this.nameproducto);
        parcel.writeString(this.fechaproducto.toString());
        parcel.writeString(this.cantidad);
        parcel.writeString(this.ubicacion);
        parcel.writeString(this.categoria);
        parcel.writeString(this.precio);
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
