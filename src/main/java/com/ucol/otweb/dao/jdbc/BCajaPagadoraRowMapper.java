/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CajaPagadoraVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BCajaPagadoraRowMapper implements RowMapper<CajaPagadoraVO>{

    public CajaPagadoraVO mapRow(ResultSet rs, int i) throws SQLException {
        BCajaPagadoraExtractor cajaExtractor = new BCajaPagadoraExtractor();
        return cajaExtractor.extractData(rs);
    }
    
}
