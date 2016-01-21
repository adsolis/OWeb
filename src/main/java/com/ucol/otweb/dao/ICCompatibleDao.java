/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CCompatibleVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface ICCompatibleDao {
    List<CCompatibleVO> obtenerCompatibilidadCredito(CCompatibleVO cCompatibleVO );
}
