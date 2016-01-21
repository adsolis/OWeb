/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CParamOtorgaVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CParamOtorgaExtractor implements ResultSetExtractor<Serializable> {

    /**
     * 
     * @param rs
     * @return Objeto VO conteniendo la informacion extraida por registro de la consulta mediante RS
     * @throws SQLException
     * @throws DataAccessException
     */
    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        CParamOtorgaVO parametroOtorgamiento = new CParamOtorgaVO();
        parametroOtorgamiento.setCveParamOtorga(rs.getInt(1));
        parametroOtorgamiento.setDscParamOtorga(rs.getString(2));
        parametroOtorgamiento.setValParamOtorga(rs.getDouble(3));
        return parametroOtorgamiento;
    }
}
