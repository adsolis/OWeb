/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.DeduccionesVO;

/**
 *
 * @author 
 */
public interface IDeduccionesDao {

    /**
     * Obtener la deduccion por el numero de ISSSTE, ramo y pagaduria
     * todos los parametros son obligatorios
     * @param numIssste
     * @param ramo
     * @param Pagaduria
     * @return
     */
    DeduccionesVO obtenerDeduccion(Integer numIssste, Integer ramo, String pagaduria);
    Integer conteoDeducciones(Integer numIssste, Integer ramo, String pagaduria);
    boolean insertDeduccion(DeduccionesVO deduccionesVO);
}
