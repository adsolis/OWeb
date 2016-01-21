/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 */
public class SalarioMinimoVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    private Double salMinDiario;
    private Double salarioMin;
    private Date fechaSalario;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the salMinDiario
     */
    public Double getSalMinDiario() {
        return salMinDiario;
    }

    /**
     * @param salMinDiario the salMinDiario to set
     */
    public void setSalMinDiario(Double salMinDiario) {
        this.salMinDiario = salMinDiario;
    }

    /**
     * @return the salarioMin
     */
    public Double getSalarioMin() {
        return salarioMin;
    }

    /**
     * @param salarioMin the salarioMin to set
     */
    public void setSalarioMin(Double salarioMin) {
        this.salarioMin = salarioMin;
    }

    /**
     * @return the fechaSalario
     */
    public Date getFechaSalario() {
        return fechaSalario;
    }

    /**
     * @param fechaSalario the fechaSalario to set
     */
    public void setFechaSalario(Date fechaSalario) {
        this.fechaSalario = fechaSalario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fechaAud
     */
    public Date getFechaAud() {
        return fechaAud;
    }

    /**
     * @param fechaAud the fechaAud to set
     */
    public void setFechaAud(Date fechaAud) {
        this.fechaAud = fechaAud;
    }

    /**
     * @return the componenteCve
     */
    public String getComponenteCve() {
        return componenteCve;
    }

    /**
     * @param componenteCve the componenteCve to set
     */
    public void setComponenteCve(String componenteCve) {
        this.componenteCve = componenteCve;
    }

    /**
     * @return the ipEquipo
     */
    public String getIpEquipo() {
        return ipEquipo;
    }

    /**
     * @param ipEquipo the ipEquipo to set
     */
    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }
    
    
}
