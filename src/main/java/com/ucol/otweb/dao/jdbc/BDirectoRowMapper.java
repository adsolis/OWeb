/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.DirectoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BDirectoRowMapper implements RowMapper<DirectoVO> {

    public DirectoVO mapRow(ResultSet rs, int i) throws SQLException {
        BDirectoExtractor directoExtractor = new BDirectoExtractor();
        return directoExtractor.extractData(rs);
    }
    
}
