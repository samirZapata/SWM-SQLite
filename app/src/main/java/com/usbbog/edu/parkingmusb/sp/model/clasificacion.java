package com.usbbog.edu.parkingmusb.sp.model;

public class clasificacion {
    private int id;
    private String tipo;
    private String periodo;
    private String valor;

    public clasificacion(int id, String tipo, String periodo, String valor) {
        this.id = id;
        this.tipo = tipo;
        this.periodo = periodo;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "clasificacion{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", periodo='" + periodo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
