/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.PagoNomVO;

/**
 *
 * @author 
 */
public interface INominaDao {

    /**
     * No subir
     * @param cveTipoNombramiento
     * @return
     */
//    int update(PagoNomVO pagoNomVO);

    public void insert(PagoNomVO pagoNomVO);
    
}
