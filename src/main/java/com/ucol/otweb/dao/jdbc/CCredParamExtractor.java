/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CCredParamVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CCredParamExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        CCredParamVO cCredParamVO =  new CCredParamVO();
        cCredParamVO.setMontoCre(rs.getDouble(1));
        cCredParamVO.setPlazoCre(rs.getInt(2));
        cCredParamVO.setPrimaGarant(rs.getDouble(3));
        cCredParamVO.setTasaInt(rs.getDouble(4));
        
        return cCredParamVO;
    }
    
}
