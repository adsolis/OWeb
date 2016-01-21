/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.cRamEsp;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CRamEspExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        cRamEsp ramEsp = new cRamEsp();
        ramEsp.setCveEntidad(rs.getInt(1));
        ramEsp.setCveDeleg(rs.getInt(2));
        ramEsp.setCveUniad(rs.getInt(3));
        
        return ramEsp;
    }
    
}
