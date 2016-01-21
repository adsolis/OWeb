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
public class CCompatibleVO implements Serializable{
    private static final long serialVersionUID = 1L; 
    private Integer cveTrcSol;
    private Integer cveTrcAnt;
    private Double porPlazo;
    private Double porMonto;
    private Integer numSalMin;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    public String getComponenteCve() {
        return componenteCve;
    }

    public void setComponenteCve(String componenteCve) {
        this.componenteCve = componenteCve;
    }

    public Integer getCveTrcAnt() {
        return cveTrcAnt;
    }

    public void setCveTrcAnt(Integer cveTrcAnt) {
        this.cveTrcAnt = cveTrcAnt;
    }

    public Integer getCveTrcSol() {
        return cveTrcSol;
    }

    public void setCveTrcSol(Integer cveTrcSol) {
        this.cveTrcSol = cveTrcSol;
    }

    public Date getFechaAud() {
        return fechaAud;
    }

    public void setFechaAud(Date fechaAud) {
        this.fechaAud = fechaAud;
    }

    public String getIpEquipo() {
        return ipEquipo;
    }

    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }

    public Integer getNumSalMin() {
        return numSalMin;
    }

    public void setNumSalMin(Integer numSalMin) {
        this.numSalMin = numSalMin;
    }

    public Double getPorMonto() {
        return porMonto;
    }

    public void setPorMonto(Double porMonto) {
        this.porMonto = porMonto;
    }

    public Double getPorPlazo() {
        return porPlazo;
    }

    public void setPorPlazo(Double porPlazo) {
        this.porPlazo = porPlazo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
