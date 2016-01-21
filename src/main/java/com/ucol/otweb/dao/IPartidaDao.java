/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CPartidaVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPartidaDao {

    public List<CPartidaVO> obtenerCVECPartida();
    public List<CPartidaVO> obtenerCPartidas(CPartidaVO cPartidaVO, boolean eqEstatus);
}
