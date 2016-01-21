/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CDiferimientoVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CDiferimientoExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        CDiferimientoVO vo = new CDiferimientoVO();
        vo.setQnaEmis(rs.getInt(1));
        vo.setRamoDif(rs.getInt(2));
        vo.setPagad(rs.getString(3));
        vo.setNumQuinDif(rs.getInt(4));
        return vo;
    }
    
}
