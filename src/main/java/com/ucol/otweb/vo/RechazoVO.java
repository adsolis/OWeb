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
public class RechazoVO implements Serializable{
    private int error;
    private int bndRechazo;
    private int cveRech;
    private int cveRechazo;

    public RechazoVO(){
        
    }
    public RechazoVO(int error, int bndRechazo,int cveRech,int cveRechazo){
        this.error = error;
        this.bndRechazo = bndRechazo;
        this.cveRech = cveRech;
        this.cveRechazo = cveRechazo;
    }
    
    /**
     * @return the error
     */
    public int getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(int error) {
        this.error = error;
    }

    /**
     * @return the bndRechazo
     */
    public int getBndRechazo() {
        return bndRechazo;
    }

    /**
     * @param bndRechazo the bndRechazo to set
     */
    public void setBndRechazo(int bndRechazo) {
        this.bndRechazo = bndRechazo;
    }

    /**
     * @return the cveRechazo
     */
    public int getCveRechazo() {
        return cveRechazo;
    }

    /**
     * @param cveRechazo the cveRechazo to set
     */
    public void setCveRechazo(int cveRechazo) {
        this.cveRechazo = cveRechazo;
    }

    /**
     * @return the cveRech
     */
    public int getCveRech() {
        return cveRech;
    }

    /**
     * @param cveRech the cveRech to set
     */
    public void setCveRech(int cveRech) {
        this.cveRech = cveRech;
    }
    
}
