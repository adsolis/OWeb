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
public class CPartidaVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int cveEntidad;
    private int cveDeleg;
    private int cveUniad;
    private int numRamo;
    private String tnoCve;
    private int cvePartida;
    private String desPartida;
    private String stsPartida;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

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
     * @return the numRamo
     */
    public int getNumRamo() {
        return numRamo;
    }

    /**
     * @param numRamo the numRamo to set
     */
    public void setNumRamo(int numRamo) {
        this.numRamo = numRamo;
    }

    /**
     * @return the tnoCve
     */
    public String getTnoCve() {
        return tnoCve;
    }

    /**
     * @param tnoCve the tnoCve to set
     */
    public void setTnoCve(String tnoCve) {
        this.tnoCve = tnoCve;
    }

    /**
     * @return the cvePartida
     */
    public int getCvePartida() {
        return cvePartida;
    }

    /**
     * @param cvePartida the cvePartida to set
     */
    public void setCvePartida(int cvePartida) {
        this.cvePartida = cvePartida;
    }

    /**
     * @return the desPartida
     */
    public String getDesPartida() {
        return desPartida;
    }

    /**
     * @param desPartida the desPartida to set
     */
    public void setDesPartida(String desPartida) {
        this.desPartida = desPartida;
    }

    /**
     * @return the stsPartida
     */
    public String getStsPartida() {
        return stsPartida;
    }

    /**
     * @param stsPartida the stsPartida to set
     */
    public void setStsPartida(String stsPartida) {
        this.stsPartida = stsPartida;
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
