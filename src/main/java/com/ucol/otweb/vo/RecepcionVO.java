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
public class RecepcionVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int cveOperadorRec ;
private Date dtFechaRec;
private int anioSol ;
private Integer folioSol;
private int cveTcr ;
private Integer numIssste;
private int statRec ;
private int cveEntidadOrigen ;
private int cveDelegOrigen ;
private int cveUniadOrigen ;
private int cveOficinaOrigen ;
private int cveEntidad ;
private int cveDeleg ;
private int cveUniad ;
private int cveOficina ;
private String usuario;
private Date fechaAud;
private String componenteCve;
private String ipEquipo;

    /**
     * @return the cveOperadorRec
     */
    public int getCveOperadorRec() {
        return cveOperadorRec;
    }

    /**
     * @param cveOperadorRec the cveOperadorRec to set
     */
    public void setCveOperadorRec(int cveOperadorRec) {
        this.cveOperadorRec = cveOperadorRec;
    }

    /**
     * @return the dtFechaRec
     */
    public Date getDtFechaRec() {
        return dtFechaRec;
    }

    /**
     * @param dtFechaRec the dtFechaRec to set
     */
    public void setDtFechaRec(Date dtFechaRec) {
        this.dtFechaRec = dtFechaRec;
    }

    /**
     * @return the anioSol
     */
    public int getAnioSol() {
        return anioSol;
    }

    /**
     * @param anioSol the anioSol to set
     */
    public void setAnioSol(int anioSol) {
        this.anioSol = anioSol;
    }

    /**
     * @return the folioSol
     */
    public Integer getFolioSol() {
        return folioSol;
    }

    /**
     * @param folioSol the folioSol to set
     */
    public void setFolioSol(Integer folioSol) {
        this.folioSol = folioSol;
    }

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
     * @return the numIssste
     */
    public Integer getNumIssste() {
        return numIssste;
    }

    /**
     * @param numIssste the numIssste to set
     */
    public void setNumIssste(Integer numIssste) {
        this.numIssste = numIssste;
    }

    /**
     * @return the statRec
     */
    public int getStatRec() {
        return statRec;
    }

    /**
     * @param statRec the statRec to set
     */
    public void setStatRec(int statRec) {
        this.statRec = statRec;
    }

    /**
     * @return the cveEntidadOrigen
     */
    public int getCveEntidadOrigen() {
        return cveEntidadOrigen;
    }

    /**
     * @param cveEntidadOrigen the cveEntidadOrigen to set
     */
    public void setCveEntidadOrigen(int cveEntidadOrigen) {
        this.cveEntidadOrigen = cveEntidadOrigen;
    }

    /**
     * @return the cveDelegOrigen
     */
    public int getCveDelegOrigen() {
        return cveDelegOrigen;
    }

    /**
     * @param cveDelegOrigen the cveDelegOrigen to set
     */
    public void setCveDelegOrigen(int cveDelegOrigen) {
        this.cveDelegOrigen = cveDelegOrigen;
    }

    /**
     * @return the cveUniadOrigen
     */
    public int getCveUniadOrigen() {
        return cveUniadOrigen;
    }

    /**
     * @param cveUniadOrigen the cveUniadOrigen to set
     */
    public void setCveUniadOrigen(int cveUniadOrigen) {
        this.cveUniadOrigen = cveUniadOrigen;
    }

    /**
     * @return the cveOficinaOrigen
     */
    public int getCveOficinaOrigen() {
        return cveOficinaOrigen;
    }

    /**
     * @param cveOficinaOrigen the cveOficinaOrigen to set
     */
    public void setCveOficinaOrigen(int cveOficinaOrigen) {
        this.cveOficinaOrigen = cveOficinaOrigen;
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
     * @return the cveOficina
     */
    public int getCveOficina() {
        return cveOficina;
    }

    /**
     * @param cveOficina the cveOficina to set
     */
    public void setCveOficina(int cveOficina) {
        this.cveOficina = cveOficina;
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
