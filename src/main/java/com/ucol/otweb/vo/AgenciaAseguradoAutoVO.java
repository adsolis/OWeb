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
public class AgenciaAseguradoAutoVO implements  Serializable {
    
    private String nomAgencia;
    private String nomImagen;
    private String url;
    private int contante;

    public String getNomAgencia() {
        return nomAgencia;
    }

    public void setNomAgencia(String nomAgencia) {
        this.nomAgencia = nomAgencia;
    }

    public String getNomImagen() {
        return nomImagen;
    }

    public void setNomImagen(String nomImagen) {
        this.nomImagen = nomImagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the contante
     */
    public int getContante() {
        return contante;
    }

    /**
     * @param contante the contante to set
     */
    public void setContante(int contante) {
        this.contante = contante;
    }
    
}
