/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gisi.model;

/**
 *
 * @author isr10
 */
public class proyectos {

    private int proyectoid;
    private String nombreProyecto;
    private int empresaid;

    public int getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(int proyectoid) {
        this.proyectoid = proyectoid;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public int getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }

    @Override
    public String toString() {
        return "proyectos{" + "proyectoid=" + proyectoid + ", nombreProyecto=" + nombreProyecto + ", empresaid=" + empresaid + '}';
    }
    
    
}
