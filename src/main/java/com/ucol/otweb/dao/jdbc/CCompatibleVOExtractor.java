/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CCompatibleVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CCompatibleVOExtractor implements ResultSetExtractor<CCompatibleVO> {

    public CCompatibleVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CCompatibleVO cCompatibleVO = new CCompatibleVO();
        cCompatibleVO.setCveTrcSol(rs.getInt(1));
        cCompatibleVO.setCveTrcAnt(rs.getInt(2));
        cCompatibleVO.setPorPlazo(rs.getDouble(3));
        cCompatibleVO.setPorMonto(rs.getDouble(4));
        cCompatibleVO.setNumSalMin(rs.getInt(5));
        cCompatibleVO.setUsuario(rs.getString(6));
        cCompatibleVO.setFechaAud(rs.getDate(7));
        cCompatibleVO.setComponenteCve(rs.getString(8));
        cCompatibleVO.setIpEquipo(rs.getString(9));
        return cCompatibleVO;
    }
    
}
