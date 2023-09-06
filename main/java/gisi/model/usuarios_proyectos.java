/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gisi.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author isr10
 */
public class usuarios_proyectos {

    private int id;
    private int id_usuario;
    private int id_proyecto;
    private Timestamp fecha_alta;
    private Timestamp fecha_baja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Timestamp fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Timestamp fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    @Override
    public String toString() {
        return "usuarios_proyectos{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_proyecto=" + id_proyecto + ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + '}';
    }

}
