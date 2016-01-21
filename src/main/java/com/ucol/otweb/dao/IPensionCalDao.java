/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.DeudosVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPensionCalDao {
    
    public List<DeudosVO> obtenerSaldoActualProy(Integer numIssste);
    
}
