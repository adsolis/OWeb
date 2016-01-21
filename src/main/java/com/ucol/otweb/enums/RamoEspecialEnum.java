/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.enums;

/**
 *
 * @author 
 */
public enum RamoEspecialEnum {
    RAMO_23(9,33,00,18),RAMO_26(9,33,01,01),RAMO_226(9,33,01,01);
    private int cveEntidad;
    private int cveDelegacion;
    private int cveUniad;
    private int cveOficina;
    private RamoEspecialEnum(int e, int d, int u, int o){
    cveEntidad=e;
    cveDelegacion=d;
    cveUniad=u;
    cveOficina=o;
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
     * @return the cveDelegacion
     */
    public int getCveDelegacion() {
        return cveDelegacion;
    }

    /**
     * @param cveDelegacion the cveDelegacion to set
     */
    public void setCveDelegacion(int cveDelegacion) {
        this.cveDelegacion = cveDelegacion;
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
     * @return the cveOficina
     */
    public int getCveOficina() {
        return cveOficina;
    }

    /**
     * @param cveOficina the cveOficina to set
     */
    public void setCveOficina(int cveOficina) {
        this.cveOficina = cveOficina;
    }
    
    public static RamoEspecialEnum ramoEsp(int ramo){
        if(ramo==23){
            return RAMO_23 ;
        }else if(ramo==26){
            return RAMO_26;
        }if(ramo==226){
            return RAMO_226;
        }
        return null;
    }
}
