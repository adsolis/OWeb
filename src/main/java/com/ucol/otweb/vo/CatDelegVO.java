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
public class CatDelegVO implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Integer cveEntidad;
    private String descEntidad;
    
    public CatDelegVO(Integer ent, String desc){
        this.cveEntidad=ent;
        this.descEntidad=desc;
    }

    public CatDelegVO() {
   
    }
    

    /**
     * @return the cveEntidad
     */
    public Integer getCveEntidad() {
        return cveEntidad;
    }

    /**
     * @param cveEntidad the cveEntidad to set
     */
    public void setCveEntidad(Integer cveEntidad) {
        this.cveEntidad = cveEntidad;
    }

    /**
     * @return the descEntidad
     */
    public String getDescEntidad() {
        return descEntidad;
    }

    /**
     * @param descEntidad the descEntidad to set
     */
    public void setDescEntidad(String descEntidad) {
        this.descEntidad = descEntidad;
    }
    
    
    
}
