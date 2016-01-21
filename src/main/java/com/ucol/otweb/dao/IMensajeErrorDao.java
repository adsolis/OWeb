/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CRechazoWebVO;

/**
 *
 * @author 
 */
public interface IMensajeErrorDao {

    /**
     * Recuperar la informacion de el error desde la BD
     * @param cveMotivo
     * @return
     */
    CRechazoWebVO obtenerMensaje(int cveMotivo);
    
}
