/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class PrestamoProyeccionVO implements Serializable{
    private PrstamoOrigVO prestamo;
    private ProyeccionVO proyeccion;

    /**
     * @return the prestamo
     */
    public PrstamoOrigVO getPrestamo() {
        return prestamo;
    }

    /**
     * @param prestamo the prestamo to set
     */
    public void setPrestamo(PrstamoOrigVO prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * @return the proyeccion
     */
    public ProyeccionVO getProyeccion() {
        return proyeccion;
    }

    /**
     * @param proyeccion the proyeccion to set
     */
    public void setProyeccion(ProyeccionVO proyeccion) {
        this.proyeccion = proyeccion;
    }
}
