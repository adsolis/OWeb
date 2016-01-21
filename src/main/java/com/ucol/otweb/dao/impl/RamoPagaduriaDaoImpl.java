/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IRamoPagaduriaDao;
import com.ucol.otweb.dao.jdbc.CRamEspExtractor;
import com.ucol.otweb.dao.jdbc.CRamPagExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.dao.jdbc.VCPagaduriaVOExtractor;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.vo.CramPagVO;
import com.ucol.otweb.vo.cRamEsp;
import com.ucol.otweb.vo.VcPagaduriaVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@Repository(value = "ramoPagaduriaDao")
public class RamoPagaduriaDaoImpl extends GenericDao implements IRamoPagaduriaDao {

    private static final String BRAMO_PAGADURIA_SELECT = " SELECT ramo_cat,paga_cat, nomb_cat, domi_cat, moda_cat, enti_cat, enti_dist, cve_deleg, cve_uniad, tipo_nom, dispon_cat FROM crampag  WHERE ramo_cat = ? ";
    private static final String CRRAMO_ESPECIAL = "select count(*) from c_ram_esp WHERE num_ramo_ant = ? AND status = ?";
    private static final String BRAMO_ESPECIAL = "SELECT cve_entidad,cve_deleg,cve_uniad FROM c_ram_esp where status='1' AND cve_uniad = ? ";
    private static final String BVCPAGADURIA_SELECT = "select num_ramo, num_pagaduria,ram_ant, dis_cve, ent_cve, ent_dis, sec_cve, mod_cve, mba_cve, res_cve, resc_cve, codigo_postal, nco_cve, pag_estado, t_aseguramiento, t_inter_inf, "
            + " distribucion, fecha_inicio_act, fecha_alta, fecha_baja, porcent_apor_sm, porcent_apor_cre, porcent_apor_sar, porcent_apor_pen, porcent_apor_est, porcent_apor_fov, porcent_apor_ga, porcent_apor_rt, porcent_cuo_ga, porcent_cuo_cre,"
            + " porcent_cuo_pen, porcent_cuo_sm, porcent_cuo_est, num_exterior, num_interior, telefono, calle, nombre, t_pago_aportacn, t_pago_cuota, t_pago_retencn  FROM vc_pagaduria WHERE num_ramo = ? ";
    private static final String BRAMO_ESPECIAL_VALFO= "select cve_entidad,cve_deleg, cve_uniad,num_ramo_ant, num_pagaduria from c_ram_esp where num_ramo_ant = ? and  num_pagaduria = ? " 
            + " and status=1 order by cve_deleg, cve_uniad desc";
    private static final String BRAMO_ANT = "select ram_ant from c_pagaduria "
            + "where num_ramo = ? and num_pagaduria = ? and pag_estado = 'A'";

    /**
     * Recuprar los datos de el ramo-pagaduria por los ID
     *
     * @param cveRamo
     * @param pagaduria
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CramPagVO obtenerRamoPagById(int cveRamo, String pagaduria) {

        String andPagaduria = "";
        if (pagaduria == null ) {
            andPagaduria = " AND   paga_cat is null ";
        } else {
            andPagaduria = " AND   paga_cat ='" + pagaduria + "'";
        }


        CramPagVO cramPagVO = (CramPagVO) super.getJdbcTemplate().queryForObject(BRAMO_PAGADURIA_SELECT + andPagaduria,
                new Object[]{cveRamo}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CRamPagExtractor extractor = new CRamPagExtractor();
                return extractor.extractData(rs);
            }
        });

        return cramPagVO;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public VcPagaduriaVO obtenerVCPagaduria(int cveRamo, String pagaduria) {

        String andPagaduria = "";
        if (pagaduria == null || pagaduria.isEmpty()) {
            andPagaduria = " AND num_pagaduriat is null ";
        } else {
            andPagaduria = " AND num_pagaduria ='" + pagaduria + "'";
        }


        VcPagaduriaVO vcPagaduriaVO = (VcPagaduriaVO) super.getJdbcTemplate().queryForObject(BVCPAGADURIA_SELECT + andPagaduria,
                new Object[]{cveRamo}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                VCPagaduriaVOExtractor extractor = new VCPagaduriaVOExtractor();
                return extractor.extractData(rs);
            }
        });
        return vcPagaduriaVO;
    }

    /**
     * Para la saber si es ramo especial
     *
     * @param cveRamo
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countRamoEspecial(int cveRamo, String pagaduria) {
        String andPagaduria = "";
        
        if (pagaduria != null && !pagaduria.isEmpty()) {
            andPagaduria = " AND num_pagaduria ='" + pagaduria + "'";
        }
        Integer count = super.getJdbcTemplate().queryForInt(CRRAMO_ESPECIAL +andPagaduria, new Object[]{cveRamo, "1"});
        return count;
    }

    /**
     * obtener la informacion de los ramos especiales
     *
     * @param ramoEsp
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<cRamEsp> obtenerRamosEspeciales(cRamEsp ramoEsp) {
        List<cRamEsp> ramosEspeciales = null;
        String where = "";
        if (ramoEsp.getCveEntidad() > 0) {
            where += " AND cve_entidad = " + ramoEsp.getCveEntidad();
        }
        if (ramoEsp.getCveDeleg() > 0) {
            where += " AND cve_deleg = " + ramoEsp.getCveDeleg();
        }
        if (ramoEsp.getCveUniad() > 0) {
            where += " AND cve_uniad = " + ramoEsp.getCveUniad();
        }
        if (ramoEsp.getNumRamoAnt() > 0) {
            where += " AND num_ramo_ant = " + ramoEsp.getNumRamoAnt();
        }
        if (ramoEsp.getNumPagaduria() != null) {
            where += " AND num_pagaduria = '" + ramoEsp.getNumPagaduria() + "' ";
        }
        ramosEspeciales = (List) super.getJdbcTemplate().query(this.BRAMO_PAGADURIA_SELECT + where, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CRamPagExtractor extractor = new CRamPagExtractor();
                return extractor.extractData(rs);
            }
        });
        return ramosEspeciales;
    }
    
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<cRamEsp> obtenerRamoEspecial (Integer ramo, String pagaduria){
        List<cRamEsp> ramosEspeciales=(List)super.getJdbcTemplate().query(BRAMO_ESPECIAL_VALFO , new Object[]{ramo, pagaduria} , new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                cRamEsp ramEsp = new cRamEsp();
                ramEsp.setCveEntidad(rs.getInt(1));
                ramEsp.setCveDeleg(rs.getInt(2));
                ramEsp.setCveUniad(rs.getInt(3));
                ramEsp.setNumRamoAnt(rs.getDouble(4));
                ramEsp.setNumPagaduria(rs.getString(5));
                return ramEsp;
            }
        });
        return  ramosEspeciales;
    }

    /**
     * para obtener el ramo anterior de la plaza
     * @param numRamo
     * @param pagaduria
     * @param base
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer obtenerRamoAnt(int numRamo, String pagaduria, String base) {
        Integer ramoAnt = null;
        String baseProp="";
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                baseProp += properties.getParametro("conection.dsipe") + ":";
            }
        }

        String query = this.BRAMO_ANT.replace(Constants.BASE, baseProp);
        ramoAnt = super.getJdbcTemplate().queryForInt(query, new Object[]{numRamo,pagaduria} );
        return ramoAnt;
    }
    
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<cRamEsp> obtenerInfRamoEspecial(cRamEsp ramoEsp){
        List<cRamEsp> ramosEspeciales = null;
        String where = "";
        if (ramoEsp.getCveEntidad() > 0) {
            where += " AND cve_entidad = " + ramoEsp.getCveEntidad();
        }
        if (ramoEsp.getCveDeleg() > 0) {
            where += " AND cve_deleg = " + ramoEsp.getCveDeleg();
        }
        if (ramoEsp.getNumRamoAnt() > 0) {
            where += " AND num_ramo_ant = " + ramoEsp.getNumRamoAnt();
        }
        if (ramoEsp.getNumPagaduria() != null) {
            where += " AND num_pagaduria = '" + ramoEsp.getNumPagaduria() + "' ";
        }
        ramosEspeciales = (List) super.getJdbcTemplate().query(BRAMO_ESPECIAL + where, new Object[]{ramoEsp.getCveUniad()}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CRamEspExtractor extractor = new CRamEspExtractor();
                return extractor.extractData(rs);
            }
        });
        return ramosEspeciales;
    }
}
