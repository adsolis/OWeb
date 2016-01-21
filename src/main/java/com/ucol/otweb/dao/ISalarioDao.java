/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CSalarioVO;

/**
 *
 * @author 
 */
public interface ISalarioDao {
    public CSalarioVO obtenerSalarioMin();
     public CSalarioVO obtenerSalarioMinDiario() ;
}
