/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PrestoMensualVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class PrestoMensualVOExtractor implements ResultSetExtractor<PrestoMensualVO> {

    public PrestoMensualVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrestoMensualVO mensualVO = new PrestoMensualVO();
        mensualVO.setNumVersion(rs.getInt(1));
        mensualVO.setTpoPresto(rs.getString(2));
        mensualVO.setTpoPart(rs.getString(3));
        mensualVO.setCveAfect(rs.getInt(4));
        mensualVO.setCveGposind(rs.getInt(5));
        mensualVO.setCveTcr(rs.getInt(6));
        mensualVO.setNumMes(rs.getInt(7));
        mensualVO.setCveEntidad(rs.getInt(8));
        mensualVO.setCveDeleg(rs.getInt(9));
        mensualVO.setCveUniad(rs.getInt(10));
        mensualVO.setCveRamo(rs.getInt(11));
        mensualVO.setCvePart(rs.getInt(12));
        mensualVO.setTnoCve(rs.getString(13));
        mensualVO.setCredTot(rs.getInt(14));
        mensualVO.setCredDisp(rs.getInt(15));
        mensualVO.setCredComp(rs.getInt(16));
        mensualVO.setCredEjer(rs.getInt(17));
        mensualVO.setCredTrf(rs.getInt(18));
        mensualVO.setImpoEjer(rs.getDouble(19));
        mensualVO.setStatus(rs.getString(20));
        mensualVO.setUsuario(rs.getString(21));
        mensualVO.setFechaAud(rs.getDate(22));
        mensualVO.setComponenteCve(rs.getString(23));
        mensualVO.setIpEquipo(rs.getString(24));
        return mensualVO;
    }
    
}
