/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CAfectVO;

/**
 *
 * @author 
 */
public interface IAfectacionDao {

    /**
     * Obtener los datos de la afectacion por medio la clave
     * @param cveAfect
     * @return
     */
    CAfectVO obtenerCatAfectacionByID(int cveAfect);
    
}
