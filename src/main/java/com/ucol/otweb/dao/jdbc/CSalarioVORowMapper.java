/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CSalarioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class CSalarioVORowMapper implements RowMapper<CSalarioVO> {

    public CSalarioVO mapRow(ResultSet rs, int i) throws SQLException {
        CSalarioVOExtractor cSalarioVOExtractor = new CSalarioVOExtractor();
        return cSalarioVOExtractor.extractData(rs);
    }
    
}
