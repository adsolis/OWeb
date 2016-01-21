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
public class FoliosBloqueadosVO implements Serializable{
    private static final long serialVersionUID = 1L; 
    
    private int anio;
    private int cveTcr;
    private int cveSecuencia;
    private Integer numFolioIni;
    private Integer numFolioFin;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;
    private String numOfiBloq;
    private String nomOfiBloq;
    private Date fecOfiBloq;
    private String motivoBloq;

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
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
     * @return the cveSecuencia
     */
    public int getCveSecuencia() {
        return cveSecuencia;
    }

    /**
     * @param cveSecuencia the cveSecuencia to set
     */
    public void setCveSecuencia(int cveSecuencia) {
        this.cveSecuencia = cveSecuencia;
    }

    /**
     * @return the numFolioIni
     */
    public Integer getNumFolioIni() {
        return numFolioIni;
    }

    /**
     * @param numFolioIni the numFolioIni to set
     */
    public void setNumFolioIni(Integer numFolioIni) {
        this.numFolioIni = numFolioIni;
    }

    /**
     * @return the numFolioFin
     */
    public Integer getNumFolioFin() {
        return numFolioFin;
    }

    /**
     * @param numFolioFin the numFolioFin to set
     */
    public void setNumFolioFin(Integer numFolioFin) {
        this.numFolioFin = numFolioFin;
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
     * @return the numOfiBloq
     */
    public String getNumOfiBloq() {
        return numOfiBloq;
    }

    /**
     * @param numOfiBloq the numOfiBloq to set
     */
    public void setNumOfiBloq(String numOfiBloq) {
        this.numOfiBloq = numOfiBloq;
    }

    /**
     * @return the nomOfiBloq
     */
    public String getNomOfiBloq() {
        return nomOfiBloq;
    }

    /**
     * @param nomOfiBloq the nomOfiBloq to set
     */
    public void setNomOfiBloq(String nomOfiBloq) {
        this.nomOfiBloq = nomOfiBloq;
    }

    /**
     * @return the fecOfiBloq
     */
    public Date getFecOfiBloq() {
        return fecOfiBloq;
    }

    /**
     * @param fecOfiBloq the fecOfiBloq to set
     */
    public void setFecOfiBloq(Date fecOfiBloq) {
        this.fecOfiBloq = fecOfiBloq;
    }

    /**
     * @return the motivoBloq
     */
    public String getMotivoBloq() {
        return motivoBloq;
    }

    /**
     * @param motivoBloq the motivoBloq to set
     */
    public void setMotivoBloq(String motivoBloq) {
        this.motivoBloq = motivoBloq;
    }
    
    
    
    
}
