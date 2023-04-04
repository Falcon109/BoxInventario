package com.example.boxinventario;

public class ListaRecordatorio {

    public String color;
    public String nameRecordatorio;
    public String fechaRecordatoio;
    public String status;

    public ListaRecordatorio(String color, String nameRecordatorio, String fechaRecordatoio, String status) {
        this.color = color;
        this.nameRecordatorio = nameRecordatorio;
        this.fechaRecordatoio = fechaRecordatoio;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNameRecordatorio() {
        return nameRecordatorio;
    }

    public void setNameRecordatorio(String nameRecordatorio) {
        this.nameRecordatorio = nameRecordatorio;
    }

    public String getFechaRecordatoio() {
        return fechaRecordatoio;
    }

    public void setFechaRecordatoio(String fechaRecordatoio) {
        this.fechaRecordatoio = fechaRecordatoio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
