/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.TransMovOtoWeb;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BTransMovWebRowMapper implements RowMapper<TransMovOtoWeb> {

    public TransMovOtoWeb mapRow(ResultSet rs, int i) throws SQLException {
        BTransMovWebExtractor transMovWebExtrac = new BTransMovWebExtractor();
        return transMovWebExtrac.extractData(rs);
    }
    
}
