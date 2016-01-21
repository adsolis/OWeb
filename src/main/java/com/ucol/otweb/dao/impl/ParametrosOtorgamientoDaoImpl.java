/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IParametrosOtorgamientoDao;
import com.ucol.otweb.dao.jdbc.CParamOtorgaExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CParamOtorgaVO;
import com.ucol.otweb.vo.CSicParamVO;
import java.io.Serializable;
import java.sql.*;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "parametrosOtorgamientoDao")
public class ParametrosOtorgamientoDaoImpl extends GenericDao implements IParametrosOtorgamientoDao {

    private static final String BPARAM_OTORGA_SELECT = "SELECT cve_param_otorga, dsc_param_otorga, val_param_otorga FROM c_param_otorga WHERE cve_param_otorga = ?";
    private static final String IC_SIC_PARAM = "INSERT INTO c_sic_param(num_sic, usuario, fecha_aud, componente_cve, ip_equipo) "
            + "VALUES(0, ?, ?, ?, ?)";

    public CParamOtorgaVO obtenerParametroByID(int cveParamOtorga) {
        List<Serializable> listaParametros = null;
        CParamOtorgaVO parametroOtorgamiento = null;
        listaParametros = super.getJdbcTemplate().query(BPARAM_OTORGA_SELECT, new Object[]{new Integer(cveParamOtorga)}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CParamOtorgaExtractor extractor = new CParamOtorgaExtractor();
                return extractor.extractData(rs);
            }
        });
        if (listaParametros != null && listaParametros.size() > 0) {
            parametroOtorgamiento = (CParamOtorgaVO) listaParametros.get(0);
        }
        return parametroOtorgamiento;
    }

    public Integer insert(final CSicParamVO cSicParamVO) {
        Integer generatedId = null;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement ps = conn.prepareStatement(IC_SIC_PARAM, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, cSicParamVO.getUsuario().toString());
                ps.setDate(2, cSicParamVO.getFechaAud());
                ps.setString(3, cSicParamVO.getComponenteCve());
                ps.setString(4, cSicParamVO.getIpEquipo());
                return ps;
            }
        }, keyHolder);
        generatedId = (Integer) keyHolder.getKey();

        return generatedId;
    }
}
