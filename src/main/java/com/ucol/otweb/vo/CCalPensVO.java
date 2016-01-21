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
public class CCalPensVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Date fechaIniOtorga;
    private Date fechaFinOtorga;
    private Date fechaIniPens;
    private Date fechaTerPens;
    private int qnasADiferir;
    private String ssaaOrdDscto;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the fechaIniOtorga
     */
    public Date getFechaIniOtorga() {
        return fechaIniOtorga;
    }

    /**
     * @param fechaIniOtorga the fechaIniOtorga to set
     */
    public void setFechaIniOtorga(Date fechaIniOtorga) {
        this.fechaIniOtorga = fechaIniOtorga;
    }

    /**
     * @return the fechaFinOtorga
     */
    public Date getFechaFinOtorga() {
        return fechaFinOtorga;
    }

    /**
     * @param fechaFinOtorga the fechaFinOtorga to set
     */
    public void setFechaFinOtorga(Date fechaFinOtorga) {
        this.fechaFinOtorga = fechaFinOtorga;
    }

    /**
     * @return the fechaIniPens
     */
    public Date getFechaIniPens() {
        return fechaIniPens;
    }

    /**
     * @param fechaIniPens the fechaIniPens to set
     */
    public void setFechaIniPens(Date fechaIniPens) {
        this.fechaIniPens = fechaIniPens;
    }

    /**
     * @return the fechaTerPens
     */
    public Date getFechaTerPens() {
        return fechaTerPens;
    }

    /**
     * @param fechaTerPens the fechaTerPens to set
     */
    public void setFechaTerPens(Date fechaTerPens) {
        this.fechaTerPens = fechaTerPens;
    }

    /**
     * @return the qnasADiferir
     */
    public int getQnasADiferir() {
        return qnasADiferir;
    }

    /**
     * @param qnasADiferir the qnasADiferir to set
     */
    public void setQnasADiferir(int qnasADiferir) {
        this.qnasADiferir = qnasADiferir;
    }

    /**
     * @return the ssaaOrdDscto
     */
    public String getSsaaOrdDscto() {
        return ssaaOrdDscto;
    }

    /**
     * @param ssaaOrdDscto the ssaaOrdDscto to set
     */
    public void setSsaaOrdDscto(String ssaaOrdDscto) {
        this.ssaaOrdDscto = ssaaOrdDscto;
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
