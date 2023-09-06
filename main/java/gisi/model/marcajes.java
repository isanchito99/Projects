/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gisi.model;

import java.util.Date;

/**
 *
 * @author isr10
 */
public class marcajes {

    private int marcajesid;
    private Date fecha_marcajes;
    private String tipo_marcaje;
    private int idUsuarios;

    public int getMarcajesid() {
        return marcajesid;
    }

    public void setMarcajesid(int marcajesid) {
        this.marcajesid = marcajesid;
    }

    public Date getFecha_marcajes() {
        return fecha_marcajes;
    }

    public void setFecha_marcajes(Date fecha_marcajes) {
        this.fecha_marcajes = fecha_marcajes;
    }

    public String getTipo_marcaje() {
        return tipo_marcaje;
    }

    public void setTipo_marcaje(String tipo_marcaje) {
        this.tipo_marcaje = tipo_marcaje;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public String toString() {
        return "marcajes{" + "marcajesid=" + marcajesid + ", fecha_marcajes=" + fecha_marcajes + ", tipo_marcaje=" + tipo_marcaje + ", idUsuarios=" + idUsuarios + '}';
    }
    
    
    
}
