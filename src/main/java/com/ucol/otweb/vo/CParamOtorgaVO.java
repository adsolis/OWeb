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
public class CParamOtorgaVO implements Serializable{
    private static final long serialVersionUID = 1L; 

    private int cveParamOtorga;
    private String dscParamOtorga;
    private Double valParamOtorga;
    private String stat;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the cveParamOtorga
     */
    public int getCveParamOtorga() {
        return cveParamOtorga;
    }

    /**
     * @param cveParamOtorga the cveParamOtorga to set
     */
    public void setCveParamOtorga(int cveParamOtorga) {
        this.cveParamOtorga = cveParamOtorga;
    }

    /**
     * @return the dscParamOtorga
     */
    public String getDscParamOtorga() {
        return dscParamOtorga;
    }

    /**
     * @param dscParamOtorga the dscParamOtorga to set
     */
    public void setDscParamOtorga(String dscParamOtorga) {
        this.dscParamOtorga = dscParamOtorga;
    }

    /**
     * @return the valParamOtorga
     */
    public Double getValParamOtorga() {
        return valParamOtorga;
    }

    /**
     * @param valParamOtorga the valParamOtorga to set
     */
    public void setValParamOtorga(Double valParamOtorga) {
        this.valParamOtorga = valParamOtorga;
    }

    /**
     * @return the stat
     */
    public String getStat() {
        return stat;
    }

    /**
     * @param stat the stat to set
     */
    public void setStat(String stat) {
        this.stat = stat;
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
