/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.BplazaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BPlazaExtractor implements ResultSetExtractor<BplazaVO>{
    
     public BplazaVO extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        BplazaVO bplaza = new BplazaVO();
        bplaza.setNumIssste(resultSet.getInt(1));
        bplaza.setNumRamo(resultSet.getInt(2));
        bplaza.setNumPagaduria(resultSet.getString(3));
        bplaza.setFechaAud(resultSet.getDate(4));

        return bplaza;
    }

    
}
