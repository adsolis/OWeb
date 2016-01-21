/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ITipoCreditoDAO;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.dao.jdbc.TpoCreditoRowMapper;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.vo.TpoCreditoVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "tipoCreditoDAO")
public class TipoCreditoDAO extends GenericDao implements ITipoCreditoDAO {


    private final static Logger logger = Logger.getLogger(TipoCreditoDAO.class);
//    private static final String ENTIDAD_SELECT = "SELECT cve_tcr, nom_tcr FROM tpo_credito WHERE cve_tcr in (?)";
    private static final String ENTIDAD_SELECT = " SELECT distinct tcr.cve_tcr, nom_tcr FROM tpo_credito tcr "+
            " right join folios_sim fs on tcr.cve_tcr=fs.cve_tcr ? order by tcr.cve_tcr ";
    
    private static final String BTPO_CRED_SELECT = "SELECT  cve_tcr, nom_tcr, otorg_max, monto_min, prima_renov, factor_rango, factor_antig, desc_chq1, desc_chq2, "
            + " desc_chq3, cod_autor, cod_can, stat_tcr FROM tpo_credito "
            + " WHERE cve_tcr = ? "
            + " AND   stat_tcr= 1 ";
    private static final String OMONTO_MIN_X_TIP_CRED = "SELECT monto_min FROM tpo_credito WHERE cve_tcr = ? ";

    public List obtenerTiposCredito(boolean activaClave) {
        List<TpoCreditoVO> lstStr = null;
        String sql="";
        if(!activaClave){
            sql = " where fs.cve_tcr not in (21) ";
        }
        String query = ENTIDAD_SELECT.replace("?", sql);

        lstStr = super.getJdbcTemplate().query(query,
                new TpoCreditoRowMapper() {

                    public TpoCreditoVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                        TpoCreditoVO ui = new TpoCreditoVO();
                        ui.setCveTcr(rs.getInt(1));
                        ui.setNomTcr(rs.getString(2));
                        return ui;
                    }
                });
        System.out.println("lstStr.toString()"+lstStr.toString());
        logger.debug(lstStr.toString());
        return lstStr;

    }
    public TpoCreditoVO obtenerTipoCredito(int cveTcr) {
        TpoCreditoVO tpoCred = null;

        tpoCred = super.getJdbcTemplate().queryForObject(BTPO_CRED_SELECT,new Object[]{cveTcr},
                new TpoCreditoRowMapper() );

        return tpoCred;

    }
    public Double obtenerMontoMinTipoCred(int cveTcr) {
        Double montoMin = null;

        montoMin = (Double)super.getJdbcTemplate().queryForObject(OMONTO_MIN_X_TIP_CRED, new Object[]{cveTcr},new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                Double sueldo=0.0;
                sueldo= rs.getDouble(1);
                return sueldo;
            }
        } );

        return montoMin;

    }

}
