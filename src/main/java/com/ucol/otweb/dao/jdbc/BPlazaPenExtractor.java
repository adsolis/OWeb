/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PzaPenVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BPlazaPenExtractor implements ResultSetExtractor<PzaPenVO> {

    public PzaPenVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PzaPenVO plazapen = new PzaPenVO();
        plazapen.setNumRamo(rs.getInt(1));
        plazapen.setNumPagaduria(rs.getString(2));
        plazapen.setNumIssste(rs.getInt(3));
        plazapen.setNumPension(rs.getInt(4));
        plazapen.setuVersion(rs.getString(5));
        plazapen.setSsnCve(rs.getString(6));
        plazapen.setImptPension(rs.getDouble(7));
        plazapen.settPension(rs.getInt(8));
        plazapen.setPpnEstado(rs.getString(9));
        plazapen.setFechaAlta(rs.getDate(10));
        plazapen.setFechaBaja(rs.getDate(11));
        plazapen.setFechaMovto(rs.getDate(12));
        plazapen.setUsuario(rs.getString(13));
        plazapen.setFechaAud(rs.getDate(14));
        plazapen.setHoraAud(rs.getString(15));
        plazapen.setComponenteCve(rs.getString(16));
        plazapen.setIpMaquina(rs.getString(17));
        return plazapen;
    }
    
}
