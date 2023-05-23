package com.example.drawertry;

import java.io.Serializable;

public class ModeloClientes implements Serializable {
    public int id;
    public String cuil;
    public String nombre;
    public String fecha_nacimiento;
    public String sex;
    public String mail;

    public ModeloClientes() {
    }

    public ModeloClientes(int id, String cuil, String nombre, String fecha_nacimiento, String sex, String mail) {
        this.id = id;
        this.cuil = cuil;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sex = sex;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "ModeloClientes{" +
                "id=" + id +
                ", cuil='" + cuil + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", sex='" + sex + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
