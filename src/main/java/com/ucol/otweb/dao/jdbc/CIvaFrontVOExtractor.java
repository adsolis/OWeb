/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CIvaFrontVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CIvaFrontVOExtractor implements ResultSetExtractor<CIvaFrontVO> {

    public CIvaFrontVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CIvaFrontVO cIvaFrontVO = new CIvaFrontVO();
        cIvaFrontVO.setEntIva(rs.getInt(1));
        cIvaFrontVO.setCodPosIva(rs.getInt(2));
        cIvaFrontVO.setFechaActIva(rs.getDate(3));
        cIvaFrontVO.setCveProgIva(rs.getString(4));
        cIvaFrontVO.setIpIva(rs.getString(5));
        cIvaFrontVO.setUsuario(rs.getString(6));
        cIvaFrontVO.setFechaAud(rs.getDate(7));
        cIvaFrontVO.setComponenteCve(rs.getString(8));
        cIvaFrontVO.setIpEquipo(rs.getString(9));
        return cIvaFrontVO;
    }
    
}
