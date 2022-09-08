package com.usbbog.edu.parkingmusb.sp.model;

public class roles {
    private int id;
    private Object rol;
    private Object descripcion;

    public roles(int id, Object rol, Object descripcion) {
        this.id = id;
        this.rol = rol;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getRol() {
        return rol;
    }

    public void setRol(Object rol) {
        this.rol = rol;
    }

    public Object getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Object descripcion) {
        this.descripcion = descripcion;
    }
}
