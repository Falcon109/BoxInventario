package com.example.boxinventario;

public class ListaProducto {

    public String color;
    public String nameProducto;
    public String fechaProducto;
    public String cantidad;

    public ListaProducto(String color, String nameProducto, String fechaProducto, String cantidad) {
        this.color = color;
        this.nameProducto = nameProducto;
        this.fechaProducto = fechaProducto;
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNameProducto() {
        return nameProducto;
    }

    public void setNameProducto(String nameProducto) {
        this.nameProducto = nameProducto;
    }

    public String getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(String fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
