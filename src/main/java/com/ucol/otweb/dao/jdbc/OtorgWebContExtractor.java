/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.OtorgamWebContad;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class OtorgWebContExtractor implements ResultSetExtractor<OtorgamWebContad> {

    public OtorgamWebContad extractData(ResultSet rs) throws SQLException, DataAccessException {
        OtorgamWebContad otorgamWebContad = new OtorgamWebContad();
        otorgamWebContad.setFecha(rs.getDate(1));
        otorgamWebContad.setContador(rs.getInt(2));
        otorgamWebContad.setUsuario(rs.getString(3));
        otorgamWebContad.setFecha_aud(rs.getDate(4));
        otorgamWebContad.setComponente_cve(rs.getString(5));
        otorgamWebContad.setIp_equipo(rs.getString(6));
        return otorgamWebContad;
    }
    
}
