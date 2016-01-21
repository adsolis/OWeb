/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.PagoRealVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPagoRealDao {
    
    public List<PagoRealVO> obtenerDTSaldoRealPorPrestamo(Double numPrestamo);
    
}
