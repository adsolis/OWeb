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
public class FolioRamoVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int ramFol;
    private int ram_plz;

    /**
     * @return the ramFol
     */
    public int getRamFol() {
        return ramFol;
    }

    /**
     * @param ramFol the ramFol to set
     */
    public void setRamFol(int ramFol) {
        this.ramFol = ramFol;
    }

    /**
     * @return the ram_plz
     */
    public int getRam_plz() {
        return ram_plz;
    }

    /**
     * @param ram_plz the ram_plz to set
     */
    public void setRam_plz(int ram_plz) {
        this.ram_plz = ram_plz;
    }
    
    
}
