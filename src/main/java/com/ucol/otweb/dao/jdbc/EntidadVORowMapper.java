/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.EntidadVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class EntidadVORowMapper implements RowMapper<EntidadVO> {

    @Override
    public EntidadVO mapRow(ResultSet resultSet, int line) throws SQLException {
        EntidadVOExtractor queryExtractor = new EntidadVOExtractor();
        return queryExtractor.extractData(resultSet);
    }

}
