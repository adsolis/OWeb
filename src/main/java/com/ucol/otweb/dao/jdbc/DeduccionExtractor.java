/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.DeduccionesVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class DeduccionExtractor implements ResultSetExtractor<DeduccionesVO>{

    /**
     * Extraer los datos del resulset
     * @param rs
     * @return
     * @throws SQLException
     * @throws DataAccessException
     */
    public DeduccionesVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        DeduccionesVO deduccion = new DeduccionesVO();
        deduccion.setIsssteNbr202(rs.getInt(1));
        deduccion.setRamo(rs.getInt(2));
        deduccion.setPagaduria(rs.getString(3));
        deduccion.setDsctoFovissste(rs.getDouble(4));
        deduccion.setLoanNbrSityf(rs.getDouble(5));
        deduccion.setDsctoSityf(rs.getDouble(6));
        deduccion.setLoanNbrIssste(rs.getDouble(7));
        deduccion.setDsctoIssste(rs.getDouble(8));
        return deduccion;
    }
    
}
