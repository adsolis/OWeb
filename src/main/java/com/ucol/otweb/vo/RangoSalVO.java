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
public class RangoSalVO implements Serializable{
    private double sueldoISsste;
    private double rangoSal;

    /**
     * @return the sueldoISsste
     */
    public double getSueldoISsste() {
        return sueldoISsste;
    }

    public RangoSalVO(){
    }
    
    public RangoSalVO(double sueldoISsste,double rangoSal){
        this.sueldoISsste=sueldoISsste;
        this.rangoSal=rangoSal;
        
    }
    
    /**
     * @param sueldoISsste the sueldoISsste to set
     */
    public void setSueldoISsste(double sueldoISsste) {
        this.sueldoISsste = sueldoISsste;
    }

    /**
     * @return the rangoSal
     */
    public double getRangoSal() {
        return rangoSal;
    }

    /**
     * @param rangoSal the rangoSal to set
     */
    public void setRangoSal(double rangoSal) {
        this.rangoSal = rangoSal;
    }
}
