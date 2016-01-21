/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

/**
 *
 * @author 
 */
import java.io.Serializable;

public class DatosLaboralesVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer numIssste;
    private String rfc;
    private String curp;
    private String email;
    private String cemail;
    private String dtoEstado;
    private Integer ramo;
    private String pagaduria;
    private String nombreCompleto;

    /**
     * @return the numIssste
     */
    public Integer getNumIssste() {
        return numIssste;
    }

    /**
     * @param numIssste the numIssste to set
     */
    public void setNumIssste(Integer numIssste) {
        this.numIssste = numIssste;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cemail
     */
    public String getCemail() {
        return cemail;
    }

    /**
     * @param cemail the cemail to set
     */
    public void setCemail(String cemail) {
        this.cemail = cemail;
    }
    
    /**
     * @return the dtoEstado
     */
    public String getDtoEstado() {
        return dtoEstado;
    }

    /**
     * @param dtoEstado the dtoEstado to set
     */
    public void setDtoEstado(String dtoEstado) {
        this.dtoEstado = dtoEstado;
    }

    /**
     * @return the pagaduria
     */
    public String getPagaduria() {
        return pagaduria;
    }

    /**
     * @param pagaduria the pagaduria to set
     */
    public void setPagaduria(String pagaduria) {
        this.pagaduria = pagaduria;
    }

    /**
     * @return the ramo
     */
    public Integer getRamo() {
        return ramo;
    }

    /**
     * @param ramo the ramo to set
     */
    public void setRamo(Integer ramo) {
        this.ramo = ramo;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    
    
}
