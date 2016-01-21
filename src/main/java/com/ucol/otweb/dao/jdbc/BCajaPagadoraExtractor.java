/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CajaPagadoraVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BCajaPagadoraExtractor implements ResultSetExtractor<CajaPagadoraVO>{

    public CajaPagadoraVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CajaPagadoraVO caja = new CajaPagadoraVO();
        caja.setId(rs.getInt(1));
        caja.setIdEntidad(rs.getInt(2));
        caja.setIdDelegacion(rs.getInt(3));
        caja.setIdUniad(rs.getInt(4));
        caja.setIdOficina(rs.getInt(5));
        caja.setCiudad(rs.getString(6));
        caja.setCalle(rs.getString(7));
        caja.setColonia(rs.getString(8));
        caja.setCodigoPostal(rs.getString(9));
        caja.setEntidad(rs.getString(10));
        caja.setDia_cheque(rs.getInt(11));
        return caja;
    }
    
}
