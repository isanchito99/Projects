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


public class empresas {

    private int empresaid;
    private String nombreEmpresa;

    public int getEmpresaid() {
        return empresaid;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return "empresas{" + "empresaid=" + empresaid + ", nombreEmpresa=" + nombreEmpresa + '}';
    }

}
