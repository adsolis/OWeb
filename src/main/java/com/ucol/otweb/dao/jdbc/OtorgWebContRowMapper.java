/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.OtorgamWebContad;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class OtorgWebContRowMapper implements RowMapper<OtorgamWebContad> {

    public OtorgamWebContad mapRow(ResultSet rs, int i) throws SQLException {
        OtorgWebContExtractor otorgWebContExtractor = new OtorgWebContExtractor();
        return otorgWebContExtractor.extractData(rs);
    }
    
}
