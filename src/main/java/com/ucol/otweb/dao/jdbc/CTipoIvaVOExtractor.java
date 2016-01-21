/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CTipoIvaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CTipoIvaVOExtractor implements ResultSetExtractor<CTipoIvaVO> {

    public CTipoIvaVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CTipoIvaVO cTipoIvaVO = new CTipoIvaVO();
        cTipoIvaVO.setPorcTiva(rs.getInt(1));
        return cTipoIvaVO;
    }
    
}
