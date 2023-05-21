package com.example.boxinventario.entidades;

public class LugaresDeInteres {

    private int id_lugares;
    private String nombre_lugar;
    private String link;
    private String puntaje;

    public LugaresDeInteres(int id_lugares, String nombre_lugar, String link, String puntaje) {
        this.id_lugares = id_lugares;
        this.nombre_lugar = nombre_lugar;
        this.link = link;
        this.puntaje = puntaje;
    }

    public LugaresDeInteres() {

    }

    public int getId_lugares() {
        return id_lugares;
    }

    public void setId_lugares(int id_lugares) {
        this.id_lugares = id_lugares;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
