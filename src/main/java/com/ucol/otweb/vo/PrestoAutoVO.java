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
public class PrestoAutoVO implements Serializable{
    
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
      
    private int cveAfect;
    private int cveTcr;
    private int tnoCve;
    private int cveEntidad;
    private int cveDeleg;
    private int cveUniad;
    private int ramo;
    private Integer cveUniadOri;
    private int cveSubpartOri;
    private Date fechaAud;
    private String horaAud;
    private String componenteCve;
    private String usuario;
    private String ipEquipo;

    /**
     * @return the cveTcr
     */
    public int getCveTcr() {
        return cveTcr;
    }

    /**
     * @param cveTcr the cveTcr to set
     */
    public void setCveTcr(int cveTcr) {
        this.cveTcr = cveTcr;
    }

    /**
     * @return the tnoCve
     */
    public int getTnoCve() {
        return tnoCve;
    }

    /**
     * @param tnoCve the tnoCve to set
     */
    public void setTnoCve(int tnoCve) {
        this.tnoCve = tnoCve;
    }

    /**
     * @return the cveEntidad
     */
    public int getCveEntidad() {
        return cveEntidad;
    }

    /**
     * @param cveEntidad the cveEntidad to set
     */
    public void setCveEntidad(int cveEntidad) {
        this.cveEntidad = cveEntidad;
    }

    /**
     * @return the cveDeleg
     */
    public int getCveDeleg() {
        return cveDeleg;
    }

    /**
     * @param cveDeleg the cveDeleg to set
     */
    public void setCveDeleg(int cveDeleg) {
        this.cveDeleg = cveDeleg;
    }

    /**
     * @return the cveUniad
     */
    public int getCveUniad() {
        return cveUniad;
    }

    /**
     * @param cveUniad the cveUniad to set
     */
    public void setCveUniad(int cveUniad) {
        this.cveUniad = cveUniad;
    }

    /**
     * @return the ramo
     */
    public int getRamo() {
        return ramo;
    }

    /**
     * @param ramo the ramo to set
     */
    public void setRamo(int ramo) {
        this.ramo = ramo;
    }

    /**
     * @return the cveUniadOri
     */
    public Integer getCveUniadOri() {
        return cveUniadOri;
    }

    /**
     * @param cveUniadOri the cveUniadOri to set
     */
    public void setCveUniadOri(Integer cveUniadOri) {
        this.cveUniadOri = cveUniadOri;
    }

    /**
     * @return the cveSubpartOri
     */
    public int getCveSubpartOri() {
        return cveSubpartOri;
    }

    /**
     * @param cveSubpartOri the cveSubpartOri to set
     */
    public void setCveSubpartOri(int cveSubpartOri) {
        this.cveSubpartOri = cveSubpartOri;
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

    /**
     * @return the cveAfect
     */
    public int getCveAfect() {
        return cveAfect;
    }

    /**
     * @param cveAfect the cveAfect to set
     */
    public void setCveAfect(int cveAfect) {
        this.cveAfect = cveAfect;
    }
    
    
}
