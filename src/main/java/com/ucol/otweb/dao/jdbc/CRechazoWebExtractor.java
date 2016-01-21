/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CRechazoWebVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CRechazoWebExtractor implements ResultSetExtractor<Serializable> {

    /**
     * Extraer la informacion de el RS para la consulta de Rechazo
     * @param rs
     * @return
     * @throws SQLException
     * @throws DataAccessException
     */
    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        CRechazoWebVO vo = new CRechazoWebVO();
        vo.setCveMotivo(rs.getInt(1));
        vo.setDescRechazo(rs.getString(2));
        vo.setTipoMotivo(rs.getString(3));
        vo.setStatMotivo(rs.getString(4));
        return vo;
    }
    
}
