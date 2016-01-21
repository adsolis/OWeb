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
public class cRamEsp implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int cveEntidad;
    private int cveDeleg;
    private int cveUniad;
    private Double numRamoAnt;
    private String numPagaduria;
    private String status;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;
    private int bandAuxEsDf;
    private int bandAuxEsRamEsp;
    
    public cRamEsp (){
        
    }
    public cRamEsp (Integer ramo,String pagaduria){
        this.numRamoAnt=new Double(ramo);
        this.numPagaduria=pagaduria;
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
     * @return the numRamoAnt
     */
    public Double getNumRamoAnt() {
        return numRamoAnt;
    }

    /**
     * @param numRamoAnt the numRamoAnt to set
     */
    public void setNumRamoAnt(Double numRamoAnt) {
        this.numRamoAnt = numRamoAnt;
    }

    /**
     * @return the numPagaduria
     */
    public String getNumPagaduria() {
        return numPagaduria;
    }

    /**
     * @param numPagaduria the numPagaduria to set
     */
    public void setNumPagaduria(String numPagaduria) {
        this.numPagaduria = numPagaduria;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * @return the bandAuxEsDf
     */
    public int getBandAuxEsDf() {
        return bandAuxEsDf;
    }

    /**
     * @param bandAuxEsDf the bandAuxEsDf to set
     */
    public void setBandAuxEsDf(int bandAuxEsDf) {
        this.bandAuxEsDf = bandAuxEsDf;
    }

    /**
     * @return the bandAuxEsRamEsp
     */
    public int getBandAuxEsRamEsp() {
        return bandAuxEsRamEsp;
    }

    /**
     * @param bandAuxEsRamEsp the bandAuxEsRamEsp to set
     */
    public void setBandAuxEsRamEsp(int bandAuxEsRamEsp) {
        this.bandAuxEsRamEsp = bandAuxEsRamEsp;
    }
    
    
    
}
