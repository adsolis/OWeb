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
public class CDiferimientoVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int qnaEmis;
    private int ramoDif;
    private String pagad;
    private int numQuinDif;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

 
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
     * @return the qnaEmis
     */
    public int getQnaEmis() {
        return qnaEmis;
    }

    /**
     * @param qnaEmis the qnaEmis to set
     */
    public void setQnaEmis(int qnaEmis) {
        this.qnaEmis = qnaEmis;
    }

    /**
     * @return the ramoDif
     */
    public int getRamoDif() {
        return ramoDif;
    }

    /**
     * @param ramoDif the ramoDif to set
     */
    public void setRamoDif(int ramoDif) {
        this.ramoDif = ramoDif;
    }

    /**
     * @return the pagad
     */
    public String getPagad() {
        return pagad;
    }

    /**
     * @param pagad the pagad to set
     */
    public void setPagad(String pagad) {
        this.pagad = pagad;
    }

    /**
     * @return the numQuinDif
     */
    public int getNumQuinDif() {
        return numQuinDif;
    }

    /**
     * @param numQuinDif the numQuinDif to set
     */
    public void setNumQuinDif(int numQuinDif) {
        this.numQuinDif = numQuinDif;
    }
    
    
    
}
