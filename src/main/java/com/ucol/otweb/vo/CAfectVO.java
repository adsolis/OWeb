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
public class CAfectVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 

    private int cve_afect;
    private String desc_afect;
    private String tpo_part;
    private String dist_pob;

    /**
     * @return the desc_afect
     */
    public String getDesc_afect() {
        return desc_afect;
    }

    /**
     * @param desc_afect the desc_afect to set
     */
    public void setDesc_afect(String desc_afect) {
        this.desc_afect = desc_afect;
    }

    /**
     * @return the tpo_part
     */
    public String getTpo_part() {
        return tpo_part;
    }

    /**
     * @param tpo_part the tpo_part to set
     */
    public void setTpo_part(String tpo_part) {
        this.tpo_part = tpo_part;
    }

    /**
     * @return the dist_pob
     */
    public String getDist_pob() {
        return dist_pob;
    }

    /**
     * @param dist_pob the dist_pob to set
     */
    public void setDist_pob(String dist_pob) {
        this.dist_pob = dist_pob;
    }

    /**
     * @return the cve_afect
     */
    public int getCve_afect() {
        return cve_afect;
    }

    /**
     * @param cve_afect the cve_afect to set
     */
    public void setCve_afect(int cve_afect) {
        this.cve_afect = cve_afect;
    }
    
    
}
