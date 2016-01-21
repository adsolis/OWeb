/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IPartidaDao;
import com.ucol.otweb.dao.jdbc.CPartidaExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CPartidaVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "partidaDao")
public class PartidaDaoImpl extends GenericDao implements IPartidaDao {

    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BCATPARTIDA = "SELECT DISTINCT cve_partida FROM c_partida ORDER BY cve_partida ASC";
    private static final String BCATPARTIDA_SELECT = "SELECT UNIQUE cve_entidad, cve_deleg, cve_uniad, num_ramo, tno_cve, cve_partida, des_partida, sts_partida  FROM C_PARTIDA";

    public PartidaDaoImpl() {
    }

    /**
     * Se obtiene la clave por cada partida que exista en la BD
     */
    public List<CPartidaVO> obtenerCVECPartida() {
        List<Serializable> listaCveCatPart = null;
        listaCveCatPart = super.getJdbcTemplate().query(BCATPARTIDA, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CPartidaExtractor extractor = new CPartidaExtractor();
                return extractor.extractData(rs);
            }
        });
        return (List<CPartidaVO>) (List) listaCveCatPart;
    }

    public List<CPartidaVO> obtenerCPartidas(CPartidaVO cPartidaVO, boolean eqEstatus) {

        String where = "";
        if (cPartidaVO.getCveEntidad() != 0) {
            if (where.isEmpty()) {
                where += " where cve_entidad = " + cPartidaVO.getCveEntidad();
            } else {
                where += " and cve_entidad = " + cPartidaVO.getCveEntidad();
            }
        }
        if (cPartidaVO.getCveDeleg() != 0) {
            if (where.isEmpty()) {
                where += " where cve_deleg = " + cPartidaVO.getCveDeleg();
            } else {
                where += " AND cve_deleg = " + cPartidaVO.getCveDeleg();
            }
        }
        if (cPartidaVO.getCveUniad() != 0) {
            if (where.isEmpty()) {
                where += " where cve_uniad  = " + cPartidaVO.getCveUniad();
            } else {
                where += " AND cve_uniad = " + cPartidaVO.getCveUniad();
            }
        }
        if (cPartidaVO.getNumRamo() != 0) {
            if (where.isEmpty()) {
                where += " where num_ramo  = " + cPartidaVO.getNumRamo();
            } else {
                where += " AND num_ramo = " + cPartidaVO.getNumRamo();
            }
        }
        if (cPartidaVO.getTnoCve() != null) {
            if (where.isEmpty()) {
                where += " where tno_cve = " + cPartidaVO.getTnoCve();
            } else {
                where += " AND tno_cve = " + cPartidaVO.getTnoCve();
            }
        }
        if (cPartidaVO.getCvePartida() != 0) {
            if (where.isEmpty()) {
                where += " where cve_partida = " + cPartidaVO.getCvePartida();
            } else {
                where += " AND cve_partida = " + cPartidaVO.getCvePartida();
            }
        }
        if (cPartidaVO.getTnoCve() != null) {
            if (where.isEmpty()) {
                where += " where tno_cve = '" + cPartidaVO.getTnoCve() + "'";
            } else {
                where += " AND tno_cve = " + cPartidaVO.getTnoCve() + "'";
            }
        }
        if (eqEstatus) {
            if (cPartidaVO.getStsPartida() != null) {
                if (where.isEmpty()) {
                    where += " where cve_partida = '" + cPartidaVO.getCvePartida() + "'";
                } else {
                    where += " AND sts_partida = '" + cPartidaVO.getCvePartida() + "'";
                }
            }
        } else {
            if (where.isEmpty()) {
                where += " where sts_partida <> 0";
            } else {
                where += " AND sts_partida <> 0";
            }
        }




        List<Serializable> listaCveCatPart = null;
        listaCveCatPart = super.getJdbcTemplate().query(BCATPARTIDA_SELECT, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CPartidaExtractor extractor = new CPartidaExtractor();
                return extractor.extractData(rs);
            }
        });
        return (List<CPartidaVO>) (List) listaCveCatPart;
    }
}
