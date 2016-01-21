/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CAfectVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CAfectExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        CAfectVO afectVO = new CAfectVO();
        afectVO.setCve_afect(rs.getInt(1));
        afectVO.setDesc_afect(rs.getString(2));
        afectVO.setTpo_part(rs.getString(3));
        afectVO.setDist_pob(rs.getString(4));
        return afectVO;
    }
    
}
