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
public class PrestoMensualVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer numVersion;
    private String tpoPresto;
    private String tpoPart;
    private int cveAfect;
    private int cveGposind;
    private int cveTcr;
    private int numMes;
    private int cveEntidad;
    private int cveDeleg;
    private int cveUniad;
    private int cveRamo;
    private Integer cvePart;
    private String tnoCve;
    private Integer credTot;
    private Integer credDisp;
    private Integer credComp;
    private Integer credEjer;
    private Integer credTrf;
    private Double impoEjer;
    private String status;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the numVersion
     */
    public Integer getNumVersion() {
        return numVersion;
    }

    /**
     * @param numVersion the numVersion to set
     */
    public void setNumVersion(Integer numVersion) {
        this.numVersion = numVersion;
    }

    /**
     * @return the tpoPresto
     */
    public String getTpoPresto() {
        return tpoPresto;
    }

    /**
     * @param tpoPresto the tpoPresto to set
     */
    public void setTpoPresto(String tpoPresto) {
        this.tpoPresto = tpoPresto;
    }

    /**
     * @return the tpoPart
     */
    public String getTpoPart() {
        return tpoPart;
    }

    /**
     * @param tpoPart the tpoPart to set
     */
    public void setTpoPart(String tpoPart) {
        this.tpoPart = tpoPart;
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

    /**
     * @return the cveGposind
     */
    public int getCveGposind() {
        return cveGposind;
    }

    /**
     * @param cveGposind the cveGposind to set
     */
    public void setCveGposind(int cveGposind) {
        this.cveGposind = cveGposind;
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
     * @return the numMes
     */
    public int getNumMes() {
        return numMes;
    }

    /**
     * @param numMes the numMes to set
     */
    public void setNumMes(int numMes) {
        this.numMes = numMes;
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
     * @return the cveRamo
     */
    public int getCveRamo() {
        return cveRamo;
    }

    /**
     * @param cveRamo the cveRamo to set
     */
    public void setCveRamo(int cveRamo) {
        this.cveRamo = cveRamo;
    }

    /**
     * @return the cvePart
     */
    public Integer getCvePart() {
        return cvePart;
    }

    /**
     * @param cvePart the cvePart to set
     */
    public void setCvePart(Integer cvePart) {
        this.cvePart = cvePart;
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
     * @return the credTot
     */
    public Integer getCredTot() {
        return credTot;
    }

    /**
     * @param credTot the credTot to set
     */
    public void setCredTot(Integer credTot) {
        this.credTot = credTot;
    }

    /**
     * @return the credDisp
     */
    public Integer getCredDisp() {
        return credDisp;
    }

    /**
     * @param credDisp the credDisp to set
     */
    public void setCredDisp(Integer credDisp) {
        this.credDisp = credDisp;
    }

    /**
     * @return the credComp
     */
    public Integer getCredComp() {
        return credComp;
    }

    /**
     * @param credComp the credComp to set
     */
    public void setCredComp(Integer credComp) {
        this.credComp = credComp;
    }

    /**
     * @return the credEjer
     */
    public Integer getCredEjer() {
        return credEjer;
    }

    /**
     * @param credEjer the credEjer to set
     */
    public void setCredEjer(Integer credEjer) {
        this.credEjer = credEjer;
    }

    /**
     * @return the credTrf
     */
    public Integer getCredTrf() {
        return credTrf;
    }

    /**
     * @param credTrf the credTrf to set
     */
    public void setCredTrf(Integer credTrf) {
        this.credTrf = credTrf;
    }

    /**
     * @return the impoEjer
     */
    public Double getImpoEjer() {
        return impoEjer;
    }

    /**
     * @param impoEjer the impoEjer to set
     */
    public void setImpoEjer(Double impoEjer) {
        this.impoEjer = impoEjer;
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

    
}
