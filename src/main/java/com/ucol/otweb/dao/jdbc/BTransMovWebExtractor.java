/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.TransMovOtoWeb;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BTransMovWebExtractor implements ResultSetExtractor<TransMovOtoWeb> {

    /**
     * 
     * @param rs
     * @return
     * @throws SQLException
     * @throws DataAccessException
     */
    public TransMovOtoWeb extractData(ResultSet rs) throws SQLException, DataAccessException {
        TransMovOtoWeb transMovOtoWeb = new TransMovOtoWeb();
        transMovOtoWeb.setRfc(rs.getString(1));
        transMovOtoWeb.setCurp(rs.getString(2));
        transMovOtoWeb.setNss(rs.getString(3));
        transMovOtoWeb.setNumIssste(rs.getInt(4));
        transMovOtoWeb.setNombre(rs.getString(5));
        transMovOtoWeb.setFolio(rs.getInt(6));
        transMovOtoWeb.setTipo_prst(rs.getInt(7));
        transMovOtoWeb.setCveEntidad(rs.getInt(8));
        transMovOtoWeb.setCveDeleg(rs.getInt(9));
        transMovOtoWeb.setCveUniad(rs.getInt(10));
        transMovOtoWeb.setCveOficina(rs.getInt(11));
        transMovOtoWeb.setRamo(rs.getInt(12));
        transMovOtoWeb.setPagad(rs.getString(13));
        transMovOtoWeb.setStatus(rs.getInt(14));
        transMovOtoWeb.setFechaMov(rs.getDate(15));
        transMovOtoWeb.setFechaAud(rs.getDate(16));
        transMovOtoWeb.setHoraAud(rs.getString(17));
        transMovOtoWeb.setComponente(rs.getString(18));
        transMovOtoWeb.setOperador(rs.getString(19));
        transMovOtoWeb.setIp_equipo(rs.getString(20));
        return transMovOtoWeb;
    }
    
}
