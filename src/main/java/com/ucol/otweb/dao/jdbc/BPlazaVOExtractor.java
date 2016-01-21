/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PlazaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BPlazaVOExtractor implements ResultSetExtractor<PlazaVO> {

    public PlazaVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PlazaVO plaza = new PlazaVO();
        plaza.setNumRamo(rs.getDouble(1));
        plaza.setNumPagaduria(rs.getString(2));
        plaza.setNumIssste(rs.getInt(3));
        plaza.setuVersion(rs.getString(4));
        plaza.setSsnCve(rs.getString(5));
        plaza.setFechaAlta(rs.getDate(6));
        plaza.setUsuario(rs.getString(7));
        plaza.setFechaAud(rs.getDate(8));
        plaza.setHoraAud(rs.getString(9));
        plaza.setComponenteCve(rs.getString(10));
        plaza.setIpMaquina(rs.getString(11));
        plaza.setSueldoIssste(rs.getDouble(12));
        plaza.setTnoCve(rs.getInt(13));
        plaza.setCpaCve(rs.getString(14));
        plaza.setSinCve(rs.getString(15));
        plaza.setDisCve(rs.getInt(16));
        plaza.setPtoCve(rs.getInt(17));
        plaza.setNsaCve(rs.getInt(18));
        plaza.setFechaMs(rs.getDate(19));
        plaza.setSueldoSar(rs.getDouble(20));
        plaza.setRemuneracnTotal(rs.getDouble(21));
        plaza.setCobroCve(rs.getString(22));
        plaza.setPlzEstado(rs.getString(23));
        plaza.setModCve(rs.getDouble(24));
        return plaza;
    }
    
}
