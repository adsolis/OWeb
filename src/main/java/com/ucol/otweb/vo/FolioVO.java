/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class FolioVO implements Serializable{
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
    private int anio;
    private int cveTcr;
    private String nomTcr;
    private int cveEntidad;
    private int cveDeleg;
    private int cveUniad;
    private int cveAfectaPresup;
    private int numFolioIni;
    private int numFolioFin;
    private String folioSolicitud;
    private String conFolioSolici;
    private String tpo_presto;
    private int numRamoAnt;
    private int tnoCve;
    private String clave;
    private String vehiculo;

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
     * @return the nomTcr
     */
    public String getNomTcr() {
        return nomTcr;
    }

    /**
     * @param nomTcr the nomTcr to set
     */
    public void setNomTcr(String nomTcr) {
        this.nomTcr = nomTcr;
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
     * @return the cveAfectaPresup
     */
    public int getCveAfectaPresup() {
        return cveAfectaPresup;
    }

    /**
     * @param cveAfectaPresup the cveAfectaPresup to set
     */
    public void setCveAfectaPresup(int cveAfectaPresup) {
        this.cveAfectaPresup = cveAfectaPresup;
    }

    /**
     * @return the numFolioFin
     */
    public int getNumFolioFin() {
        return numFolioFin;
    }

    /**
     * @param numFolioFin the numFolioFin to set
     */
    public void setNumFolioFin(int numFolioFin) {
        this.numFolioFin = numFolioFin;
    }

    /**
     * @return the numFolioIni
     */
    public int getNumFolioIni() {
        return numFolioIni;
    }

    /**
     * @param numFolioIni the numFolioIni to set
     */
    public void setNumFolioIni(int numFolioIni) {
        this.numFolioIni = numFolioIni;
    }

    /**
     * @return the folioSolicitud
     */
    public String getFolioSolicitud() {
        return folioSolicitud;
    }

    /**
     * @param folioSolicitud the folioSolicitud to set
     */
    public void setFolioSolicitud(String folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

    /**
     * @return the tpo_presto
     */
    public String getTpo_presto() {
        return tpo_presto;
    }

    /**
     * @param tpo_presto the tpo_presto to set
     */
    public void setTpo_presto(String tpo_presto) {
        this.tpo_presto = tpo_presto;
    }

    /**
     * @return the numRamoAnt
     */
    public int getNumRamoAnt() {
        return numRamoAnt;
    }

    /**
     * @param numRamoAnt the numRamoAnt to set
     */
    public void setNumRamoAnt(int numRamoAnt) {
        this.numRamoAnt = numRamoAnt;
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

    public String getConFolioSolici() {
        return conFolioSolici;
    }

    public void setConFolioSolici(String conFolioSolici) {
        this.conFolioSolici = conFolioSolici;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
