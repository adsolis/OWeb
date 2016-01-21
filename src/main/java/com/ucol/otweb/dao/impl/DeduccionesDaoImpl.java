/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.informix.util.dateUtil;
import com.ucol.otweb.dao.IDeduccionesDao;
import com.ucol.otweb.dao.jdbc.DeduccionExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.vo.DeduccionesVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "deduccionesDao")
public class DeduccionesDaoImpl extends GenericDao implements IDeduccionesDao {

    private static final String BDEDUCCION = "SELECT issste_nbr_202, ramo,pagaduria, dscto_fovissste, loan_nbr_sityf, dscto_sityf, loan_nbr_issste, dscto_issste FROM deducciones  WHERE issste_nbr_202 = ? AND ramo = ? AND pagaduria = ?";
    private static final String COUN_DEDUCCION = "SELECT COUNT(*) FROM deducciones ";

    /**
     * Obtener la deduccion por el numero de ISSSTE, ramo y pagaduria 
     * todos los parametros son obligatorios
     * @param numIssste
     * @param ramo
     * @param Pagaduria
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public DeduccionesVO obtenerDeduccion(Integer numIssste, Integer ramo, String pagaduria) {
        DeduccionesVO deduccionesVO=null;
        List<Serializable> deduccion = super.getJdbcTemplate().query(BDEDUCCION,
                new Object[]{numIssste, ramo, pagaduria}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                DeduccionExtractor extractor = new DeduccionExtractor();
                return extractor.extractData(rs);
            }
        });
        if(deduccion!=null && deduccion.size()>0){
            deduccionesVO=(DeduccionesVO) deduccion.get(0);
        }
        return deduccionesVO;
    }

    /**
     *Se obtiene el numero de deducciones por numIssste, ramo y pagaduria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer conteoDeducciones(Integer numIssste, Integer ramo, String pagaduria) {
        Integer countDeducc = null;
        String sql = "";

        if (numIssste != null && numIssste > 0) {
            if (sql.equals("")) {
                sql += " WHERE issste_nbr_202 = " + numIssste;
            } else {
                sql += " and  issste_nbr_202 = " + numIssste;
            }
        }
        if (ramo != null && ramo > 0) {
            if (sql.equals("")) {
                sql += " WHERE ramo = " + ramo;
            } else {
                sql += " and  ramo = " + ramo;
            }
        }
        if (pagaduria != null && !pagaduria.equals("")) {
            if (sql.equals("")) {
                sql += " WHERE pagaduria = " + pagaduria;
            } else {
                sql += " and  pagaduria = " + pagaduria;
            }
        } else {
            if (sql.equals("")) {
                sql += " WHERE pagaduria is NULL ";
            } else {
                sql += " and  pagaduria  is NULL ";
            }
        }
        countDeducc = super.getJdbcTemplate().queryForInt(COUN_DEDUCCION + sql);

        return countDeducc;
    }

    /**
     *Se hace la inserción de la deducción 
     */
    public boolean insertDeduccion(DeduccionesVO deduccionesVO) {
        boolean inserto = false;
        try {
            String sql = "INSERT INTO informix.deducciones(issste_nbr_202, ramo, pagaduria, dscto_fovissste, loan_nbr_sityf, dscto_sityf, loan_nbr_issste, dscto_issste, usuario, fecha_aud, componente_cve, ip_equipo)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            super.getJdbcTemplate().update(
                    sql,
                    new Object[]{deduccionesVO.getIsssteNbr202(), deduccionesVO.getRamo(), deduccionesVO.getPagaduria(), deduccionesVO.getDsctoFovissste(), deduccionesVO.getLoanNbrSityf(), deduccionesVO.getDsctoSityf(), deduccionesVO.getLoanNbrIssste(),
                        deduccionesVO.getDsctoIssste(), deduccionesVO.getUsuario(), new Date(), deduccionesVO.getComponenteCve(), deduccionesVO.getIpEquipo()});
            inserto=true;
        }catch(Exception e){
            inserto=false;
        }

        return inserto;

    }
}
