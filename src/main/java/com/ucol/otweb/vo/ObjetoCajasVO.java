/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

/**
 *
 * @author 
 */
public class ObjetoCajasVO {
   private int ventanaMostrar;
   private boolean afectacionPresupuestal;
   private int ramoDF;
   private ValFolioAuxVO valFolioAuxVO;

    /**
     * @return the ventanaMostrar
     */
    public int getVentanaMostrar() {
        return ventanaMostrar;
    }

    /**
     * @param ventanaMostrar the ventanaMostrar to set
     */
    public void setVentanaMostrar(int ventanaMostrar) {
        this.ventanaMostrar = ventanaMostrar;
    }

    /**
     * @return the afectacionPresupuestal
     */
    public boolean isAfectacionPresupuestal() {
        return afectacionPresupuestal;
    }

    /**
     * @param afectacionPresupuestal the afectacionPresupuestal to set
     */
    public void setAfectacionPresupuestal(boolean afectacionPresupuestal) {
        this.afectacionPresupuestal = afectacionPresupuestal;
    }

    /**
     * @return the ramoDF
     */
    public int getRamoDF() {
        return ramoDF;
    }

    /**
     * @param ramoDF the ramoDF to set
     */
    public void setRamoDF(int ramoDF) {
        this.ramoDF = ramoDF;
    }

    /**
     * @return the valFolioAuxVO
     */
    public ValFolioAuxVO getValFolioAuxVO() {
        return valFolioAuxVO;
    }

    /**
     * @param valFolioAuxVO the valFolioAuxVO to set
     */
    public void setValFolioAuxVO(ValFolioAuxVO valFolioAuxVO) {
        this.valFolioAuxVO = valFolioAuxVO;
    }
}
