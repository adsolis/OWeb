/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

/**
 *
 * @author 
 */
public class ValFolioAuxVO {
    
    private boolean afectacionPresuspuestal;
    private boolean banderaEdoMEx;
    private int ramoCat;
    private String pagaduriaCat;

    /**
     * @return the afectacionPresuspuestal
     */
    public boolean isAfectacionPresuspuestal() {
        return afectacionPresuspuestal;
    }

    /**
     * @param afectacionPresuspuestal the afectacionPresuspuestal to set
     */
    public void setAfectacionPresuspuestal(boolean afectacionPresuspuestal) {
        this.afectacionPresuspuestal = afectacionPresuspuestal;
    }

    /**
     * @return the banderaEdoMEx
     */
    public boolean isBanderaEdoMEx() {
        return banderaEdoMEx;
    }

    /**
     * @param banderaEdoMEx the banderaEdoMEx to set
     */
    public void setBanderaEdoMEx(boolean banderaEdoMEx) {
        this.banderaEdoMEx = banderaEdoMEx;
    }

    /**
     * @return the ramoCat
     */
    public int getRamoCat() {
        return ramoCat;
    }

    /**
     * @param ramoCat the ramoCat to set
     */
    public void setRamoCat(int ramoCat) {
        this.ramoCat = ramoCat;
    }

    /**
     * @return the ramoPagaduria
     */
    public String getPagaduriaCat() {
        return pagaduriaCat;
    }

    /**
     * @param ramoPagaduria the ramoPagaduria to set
     */
    public void setPagaduriaCat(String pagaduriaCat) {
        this.pagaduriaCat = pagaduriaCat;
    }
    
}
