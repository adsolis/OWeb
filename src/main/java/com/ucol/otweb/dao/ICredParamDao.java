/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CCredParamVO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 
 */
public interface ICredParamDao {

    /**
     * Metodo para obtener los parametros de credito
     * y el rango de Sal y de antiguedad
     * @param cCredParamVO
     * @param rangoSal
     * @param ant
     * @return
     */
    List<CCredParamVO> obtenerCredParam(CCredParamVO cCredParamVO, double rangoSal, int ant);

    /**
     *
     * @param cveTcr
     * @return
     */
    Integer obtenerMaxAntFin(int cveTcr);
    
     /**
     * Se obtiene el plazo para los creditos 12 y 19 exclusivos para damnificados
     * @return plazo
     */

    public Integer obtenerPlazoDaminificados();
    public List<Serializable> obtenerPlazoCredParaDamnificados();
}
