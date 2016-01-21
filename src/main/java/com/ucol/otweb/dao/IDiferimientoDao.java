/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CDiferimientoVO;
import java.util.List;

/**
 *
 * @author DANI
 */
public interface IDiferimientoDao {

    List<CDiferimientoVO> obtenerCatDiferimiento(CDiferimientoVO cDiferimientoVO);
    
}
