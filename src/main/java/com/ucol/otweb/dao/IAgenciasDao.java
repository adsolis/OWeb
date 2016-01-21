/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.AgenciaAseguradoAutoVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IAgenciasDao {
    
    public List<AgenciaAseguradoAutoVO> buscarAgencias();
     public List<AgenciaAseguradoAutoVO> buscarAseguradoras();
}
