/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

/**
 *
 * @author 
 */
public class CoberturaGlobVO {

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
    private EntidadVO entidad;
    private CDelegacionVO delegacion;
    private CUnidadVO unidad;
    private COficinaVO oficina;

    /**
     * @return the entidad
     */
    public EntidadVO getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(EntidadVO entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the delegacion
     */
    public CDelegacionVO getDelegacion() {
        return delegacion;
    }

    /**
     * @param delegacion the delegacion to set
     */
    public void setDelegacion(CDelegacionVO delegacion) {
        this.delegacion = delegacion;
    }

    /**
     * @return the unidad
     */
    public CUnidadVO getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(CUnidadVO unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the oficina
     */
    public COficinaVO getOficina() {
        return oficina;
    }

    /**
     * @param oficina the oficina to set
     */
    public void setOficina(COficinaVO oficina) {
        this.oficina = oficina;
    }
    
}
