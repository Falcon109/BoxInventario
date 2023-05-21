package com.example.boxinventario.entidades;

public class ListasDeCompras {

    private int id_listas;
    private String nombre_lista;
    private int id_producto;
    private int cantidad_producto;

    public ListasDeCompras(int id_listas, String nombre_lista, int id_producto, int cantidad_producto) {
        this.id_listas = id_listas;
        this.nombre_lista = nombre_lista;
        this.id_producto = id_producto;
        this.cantidad_producto = cantidad_producto;
    }

    public int getId_listas() {
        return id_listas;
    }

    public void setId_listas(int id_listas) {
        this.id_listas = id_listas;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public void setNombre_lista(String nombre_lista) {
        this.nombre_lista = nombre_lista;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }
}
