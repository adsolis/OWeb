/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CCalPensVO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 
 */
public interface ICalPensDao {

    /**
     *
     * @param fecha
     * @return
     */
    List<CCalPensVO> obtenerQuincenasOtorgamiento(Date fecha);
    
}
