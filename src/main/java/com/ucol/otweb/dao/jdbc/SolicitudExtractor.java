/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.SolicitudVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class SolicitudExtractor implements ResultSetExtractor<SolicitudVO> {

    public SolicitudVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        SolicitudVO solicitudVO = new SolicitudVO();
        solicitudVO.setCve_entidad(rs.getInt(1));
        solicitudVO.setCve_deleg(rs.getInt(2));
        solicitudVO.setCve_uniad(rs.getInt(3));
        solicitudVO.setCve_oficina(rs.getInt(4));
        return solicitudVO;
    }
    
}
