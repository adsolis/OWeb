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
public class CTipoIvaVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int cveTiva;
    private String dscTiva;
    private int porcTiva;
    private String statTiva;
    private String usuario;
    private Date fechaAud;
    private String horaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the cveTiva
     */
    public int getCveTiva() {
        return cveTiva;
    }

    /**
     * @param cveTiva the cveTiva to set
     */
    public void setCveTiva(int cveTiva) {
        this.cveTiva = cveTiva;
    }

    /**
     * @return the dscTiva
     */
    public String getDscTiva() {
        return dscTiva;
    }

    /**
     * @param dscTiva the dscTiva to set
     */
    public void setDscTiva(String dscTiva) {
        this.dscTiva = dscTiva;
    }

    /**
     * @return the porcTiva
     */
    public int getPorcTiva() {
        return porcTiva;
    }

    /**
     * @param porcTiva the porcTiva to set
     */
    public void setPorcTiva(int porcTiva) {
        this.porcTiva = porcTiva;
    }

    /**
     * @return the statTiva
     */
    public String getStatTiva() {
        return statTiva;
    }

    /**
     * @param statTiva the statTiva to set
     */
    public void setStatTiva(String statTiva) {
        this.statTiva = statTiva;
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
     * @return the horaAud
     */
    public String getHoraAud() {
        return horaAud;
    }

    /**
     * @param horaAud the horaAud to set
     */
    public void setHoraAud(String horaAud) {
        this.horaAud = horaAud;
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
