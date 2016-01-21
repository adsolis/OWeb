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
public class CramPagVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer ramoCat;
    private String pagaCat;
    private String nombCat;
    private String domiCat;
    private String modaCat;
    private int entiCat;
    private int entiDist;
    private int cveDeleg;
    private int cveUniad;
    private int tipoNom;
    private String disponCat;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the ramoCat
     */
    public Integer getRamoCat() {
        return ramoCat;
    }

    /**
     * @param ramoCat the ramoCat to set
     */
    public void setRamoCat(Integer ramoCat) {
        this.ramoCat = ramoCat;
    }

    /**
     * @return the pagaCat
     */
    public String getPagaCat() {
        return pagaCat;
    }

    /**
     * @param pagaCat the pagaCat to set
     */
    public void setPagaCat(String pagaCat) {
        this.pagaCat = pagaCat;
    }

    /**
     * @return the nombCat
     */
    public String getNombCat() {
        return nombCat;
    }

    /**
     * @param nombCat the nombCat to set
     */
    public void setNombCat(String nombCat) {
        this.nombCat = nombCat;
    }

    /**
     * @return the domiCat
     */
    public String getDomiCat() {
        return domiCat;
    }

    /**
     * @param domiCat the domiCat to set
     */
    public void setDomiCat(String domiCat) {
        this.domiCat = domiCat;
    }

    /**
     * @return the modaCat
     */
    public String getModaCat() {
        return modaCat;
    }

    /**
     * @param modaCat the modaCat to set
     */
    public void setModaCat(String modaCat) {
        this.modaCat = modaCat;
    }

    /**
     * @return the entiCat
     */
    public int getEntiCat() {
        return entiCat;
    }

    /**
     * @param entiCat the entiCat to set
     */
    public void setEntiCat(int entiCat) {
        this.entiCat = entiCat;
    }

    /**
     * @return the entiDist
     */
    public int getEntiDist() {
        return entiDist;
    }

    /**
     * @param entiDist the entiDist to set
     */
    public void setEntiDist(int entiDist) {
        this.entiDist = entiDist;
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
     * @return the tipoNom
     */
    public int getTipoNom() {
        return tipoNom;
    }

    /**
     * @param tipoNom the tipoNom to set
     */
    public void setTipoNom(int tipoNom) {
        this.tipoNom = tipoNom;
    }

    /**
     * @return the disponCat
     */
    public String getDisponCat() {
        return disponCat;
    }

    /**
     * @param disponCat the disponCat to set
     */
    public void setDisponCat(String disponCat) {
        this.disponCat = disponCat;
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
