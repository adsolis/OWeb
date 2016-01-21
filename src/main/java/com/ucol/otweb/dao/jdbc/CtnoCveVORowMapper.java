/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CtnoCveVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class CtnoCveVORowMapper implements RowMapper<CtnoCveVO> {

    public CtnoCveVO mapRow(ResultSet rs, int i) throws SQLException {
        CtnoCveVOExtractor ctnoCveVOExtractor = new CtnoCveVOExtractor();
        return ctnoCveVOExtractor.extractData(rs);
    }
    
}
