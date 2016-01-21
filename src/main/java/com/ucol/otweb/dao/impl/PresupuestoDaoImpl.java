/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IPresupuestoDao;
import com.ucol.otweb.dao.jdbc.PrestoAnualVOExtractor;
import com.ucol.otweb.dao.jdbc.PrestoAutoExtractor;
import com.ucol.otweb.dao.jdbc.PrestoMensualVOExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.PrestoAnualVO;
import com.ucol.otweb.vo.PrestoAutoVO;
import com.ucol.otweb.vo.PrestoMensualVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@Repository(value = "presupuestoDao")
public class PresupuestoDaoImpl extends GenericDao implements IPresupuestoDao {
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */

    private static final String BPRESUP_MENSUAL_X_PARTIDA = "SELECT num_version, tpo_presto, tpo_part, cve_afect, cve_gposind, cve_tcr, num_mes, cve_entidad, cve_deleg, cve_uniad, cve_ramo, cve_part, tno_cve, cred_tot, cred_disp, cred_comp, cred_ejer, cred_trf, impo_ejer, status, usuario, fecha_aud, componente_cve, ip_equipo "
            + " FROM presto_mensual WHERE presto_mensual.status = 'V' AND presto_mensual.tpo_presto = 'A'";
    private static final String BPRESUP_ANUAL_X_PRESTAMO_MES = "SELECT num_version  FROM presto_anual WHERE presto_anual.tpo_presto = 'A' AND presto_anual.status = 'V' ";
    private static final String BPRESUPUESTO_AUTO = "SELECT cve_afect, cve_tcr, tno_cve, cve_entidad, cve_deleg, cve_uniad, ramo, cve_uniad_ori, cve_subpart_ori FROM presto_auto WHERE presto_auto.cve_afect =    ? "
            + " AND (presto_auto.cve_tcr =     ?     OR presto_auto.cve_tcr IS NULL) "
            + " AND (presto_auto.tno_cve =     ?     OR presto_auto.tno_cve IS NULL) "
            + " AND (presto_auto.cve_entidad = ? OR presto_auto.cve_entidad IS NULL) "
            + " AND (presto_auto.cve_deleg =   ?   OR presto_auto.cve_deleg IS NULL) "
            + " AND (presto_auto.cve_uniad =   ?   OR presto_auto.cve_uniad IS NULL) "
            + " AND (presto_auto.ramo =        ?    OR presto_auto.ramo IS NULL)";

    public PresupuestoDaoImpl() {
    }

    /*
     * Se obtiene Datos del PresuspuestoMensual con respecto a la cobertura
     */
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrestoMensualVO> obtenerDatosPresupMensual(PrestoMensualVO prestoMensualVO) {
        List<Serializable> listaPresupuesto = null;
        String sql = "";
        if (prestoMensualVO.getCveEntidad() > 0) {
            sql += " AND presto_mensual.cve_entidad = " + prestoMensualVO.getCveEntidad();
        }
        if (prestoMensualVO.getCveDeleg() > 0) {
            sql += " AND presto_mensual.cve_deleg = " + prestoMensualVO.getCveDeleg();
        }
        if (prestoMensualVO.getCveUniad() >= 0) {
            sql += " AND presto_mensual.cve_uniad = " + prestoMensualVO.getCveUniad();
        }
        if (prestoMensualVO.getCveTcr() > 0) {
            sql += " AND presto_mensual.cve_tcr  = " + prestoMensualVO.getCveTcr();
        }
        if (prestoMensualVO.getNumMes() > 0) {
            sql += " AND presto_mensual.num_mes = " + prestoMensualVO.getNumMes();
        }
        if (prestoMensualVO.getCvePart() != null && prestoMensualVO.getCvePart() >= 0) {
            sql += " AND presto_mensual.cve_part = " + prestoMensualVO.getCvePart();
        }
        if (prestoMensualVO.getTpoPart() != null && !prestoMensualVO.getTpoPart().equals("")) {
            sql += " AND presto_mensual.tpo_part = '" + prestoMensualVO.getTpoPart() + "'";
        }
        if (prestoMensualVO.getCveAfect() == 1 || prestoMensualVO.getCveAfect() == 9) {
            sql += " AND presto_mensual.cve_afect = 1";
        } else {
            sql += " AND presto_mensual.cve_afect = " + prestoMensualVO.getCveAfect();
        }
        if (prestoMensualVO.getCveRamo() > 0) {
            sql += " AND presto_mensual.cve_ramo = " + prestoMensualVO.getCveRamo();
        } else {
            sql += " AND presto_mensual.cve_ramo IS NULL ";
        }
        if (prestoMensualVO.getTnoCve() != null && !prestoMensualVO.getTnoCve().equals("")) {
            sql += " AND presto_mensual.tno_cve =  " + prestoMensualVO.getTnoCve();
        } else {
            sql += "AND presto_mensual.tno_cve IS NULL ";
        }

        listaPresupuesto = super.getJdbcTemplate().query(BPRESUP_MENSUAL_X_PARTIDA + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                PrestoMensualVOExtractor extractor = new PrestoMensualVOExtractor();
                return extractor.extractData(rs);
            }
        });

        return (List<PrestoMensualVO>) (List) listaPresupuesto;
    }

    @Override
    public void update(PrestoMensualVO presto) {
        Object[] params = new Object[16];
        String queryUpdate = " UPDATE presto_mensual SET "
                + " cred_disp= ?, cred_comp=?, "
                + " usuario= ? , "
                + " fecha_aud= ? , "
                + "  componente_cve=?, "
                + " ip_equipo=? "
                + " WHERE presto_mensual.status      = 'V' "
                + " AND presto_mensual.tpo_presto  = 'A' "
                + " AND presto_mensual.tpo_part    = ? "
                + " AND presto_mensual.cve_afect   = ? "
                + " AND presto_mensual.cve_tcr     = ? "
                + " AND presto_mensual.num_mes     = ? "
                + " AND presto_mensual.cve_entidad = ? "
                + " AND presto_mensual.cve_deleg   = ? "
                + " AND presto_mensual.cve_uniad   = ? "
                + " AND presto_mensual.cve_ramo    = ? "
                + " AND presto_mensual.cve_part    = ? "
                + " AND presto_mensual.tno_cve     = ? ";
        params[0] = presto.getCredDisp();
        params[1] = presto.getCredComp();
        params[2] = presto.getUsuario();
        params[3] = presto.getFechaAud();
        params[4] = presto.getComponenteCve();
        params[5] = presto.getIpEquipo();
        params[6] = presto.getTpoPart();
        params[7] = presto.getCveAfect();
        params[8] = presto.getCveTcr();
        params[9] = presto.getNumMes();
        params[10] = presto.getCveEntidad();
        params[11] = presto.getCveDeleg();
        params[12] = presto.getCveUniad();
        params[13] = presto.getCveRamo();
        params[14] = presto.getCvePart();
        params[15] = presto.getTnoCve();
        super.getJdbcTemplate().update(queryUpdate, params);
    }

    @Override
    public void updatePresto(PrestoMensualVO presto) {
        Object[] params = new Object[14];
        String sql="";
        String queryUpdate = " UPDATE presto_mensual SET "
                + " cred_disp= ?, cred_trf=?, "
                + " usuario= ? , "
                + " fecha_aud= ? , "
                + " componente_cve=?, "
                + " ip_equipo=? "
                + " WHERE presto_mensual.status      = 'V' "
                + " AND presto_mensual.tpo_presto  = 'A' "
                + " AND presto_mensual.cve_tcr     = ? "
                + " AND presto_mensual.num_mes     = ? "
                + " AND presto_mensual.cve_entidad = ? "
                + " AND presto_mensual.cve_deleg   = ? "
                + " AND presto_mensual.cve_uniad   = ? "
                + " AND presto_mensual.cve_part    = ? "
                + " AND presto_mensual.tpo_part    = ? "
                + " AND presto_mensual.cve_afect   = ? ";
                if(presto.getCveRamo()>0){
                   sql +=  " AND presto_mensual.cve_ramo = "+ presto.getCveRamo();
                }else{
                   sql +=  " AND presto_mensual.cve_ramo is null";
                }
                
                if(presto.getTnoCve()!=null && !presto.getTnoCve().equals("")){
                   sql +=  " AND presto_mensual.tno_cve     =  " + presto.getTnoCve();
                }else{
                   sql +=  " AND presto_mensual.tno_cve is null";
                }
        params[0] = presto.getCredDisp();
        params[1] = presto.getCredTrf();
        params[2] = presto.getUsuario();
        params[3] = presto.getFechaAud();
        params[4] = presto.getComponenteCve();
        params[5] = presto.getIpEquipo();
        params[6] = presto.getCveTcr();
        params[7] = presto.getNumMes();
        params[8] = presto.getCveEntidad();
        params[9] = presto.getCveDeleg();
        params[10] = presto.getCveUniad();
        params[11] = presto.getCvePart();
        params[12] = presto.getTpoPart();
        params[13] = presto.getCveAfect();
        super.getJdbcTemplate().update(queryUpdate + sql, params);
    }
    @Override
    public void updatePrestoDf(PrestoMensualVO presto) {
        List params = new ArrayList();
        String queryUpdate = " UPDATE presto_mensual SET "
                + " cred_disp= ?, "
                + " usuario= ? , "
                + " fecha_aud= ? , "
                + " componente_cve=?, "
                + " ip_equipo=? "
                + " WHERE  presto_mensual.tpo_presto  = 'A' "
                + " AND presto_mensual.tpo_part    = ? "
                + " AND presto_mensual.cve_afect   = ? "
                + " AND presto_mensual.cve_tcr     = ? "
                + " AND presto_mensual.num_mes     = ? "
                + " AND presto_mensual.cve_entidad = ? "
                + " AND presto_mensual.cve_deleg   = ? "
                + " AND presto_mensual.cve_ramo is null ";
        params.add(presto.getCredDisp());
        params.add(presto.getUsuario());
        params.add(presto.getFechaAud());
        params.add(presto.getComponenteCve());
        params.add(presto.getIpEquipo());
        params.add(presto.getTpoPart());
        params.add(presto.getCveAfect());
        params.add(presto.getCveTcr());
        params.add(presto.getNumMes());
        params.add(presto.getCveEntidad());
        params.add(presto.getCveDeleg());

        super.getJdbcTemplate().update(queryUpdate, params.toArray());
    }
    /*
     * Se obtiene el numero de version del presupuesto anual con respecto al
     * tipo de credito y al mes
     */

    public List<PrestoAnualVO> obtenerVersionPresAnu(PrestoAnualVO anualVO) {
        List<Serializable> listaNumVersPresAn = null;
        String sql = "";
        if (anualVO.getEntTcr() >= 0) {
            sql += " AND presto_anual.ent_tcr = " + anualVO.getEntTcr();
        }
        if (anualVO.getNumMes() >= 0) {
            sql += " AND presto_anual.num_mes = " + anualVO.getNumMes();
        }
        listaNumVersPresAn = super.getJdbcTemplate().query(BPRESUP_ANUAL_X_PRESTAMO_MES + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                PrestoAnualVOExtractor extractor = new PrestoAnualVOExtractor();
                return extractor.extractData(rs);
            }
        });
        return (List<PrestoAnualVO>) (List) listaNumVersPresAn;
    }

    /**
     * obtenerPresupuestosTranAuto Se obtiene el presupuesto para tranferencias
     * automaticas por cobertura, tipo de prestamo, nombramiento, afectacion y
     * ramo
     *
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PrestoAutoVO> obtenerPresupuestosTranAuto(PrestoAutoVO args) {
        List<PrestoAutoVO> listaPresto = null;
        Object[] params = new Object[7];
        params[0] = args.getCveAfect();
        params[1] = args.getCveTcr();
        params[2] = args.getTnoCve();
        params[3] = args.getCveEntidad();
        params[4] = args.getCveDeleg();
        params[5] = args.getCveUniad();
        params[6] = args.getRamo();

        listaPresto = (List<PrestoAutoVO>) (List) super.getJdbcTemplate().query(BPRESUPUESTO_AUTO, params, new SerializableRowMapper() {

            public PrestoAutoVO mapRow(ResultSet rs, int i) throws SQLException {
                PrestoAutoExtractor extractor = new PrestoAutoExtractor();
                return extractor.extractData(rs);
            }
        });

        return listaPresto;
    }

    public void insert(PrestoMensualVO prestoMensualVO) {
        String insertQuery = "INSERT INTO presto_mensual("
                + " num_version, tpo_presto, tpo_part, cve_afect, cve_gposind, cve_tcr, num_mes, cve_entidad, cve_deleg, cve_uniad, cve_ramo, cve_part,"
                + " tno_cve, cred_tot, cred_disp, cred_comp, cred_ejer, cred_trf, impo_ejer, status, usuario, fecha_aud, componente_cve, ip_equipo) "
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[24];
        params[0] = prestoMensualVO.getNumVersion();
        params[1] = prestoMensualVO.getTpoPresto();
        params[2] = prestoMensualVO.getTpoPart();
        params[3] = prestoMensualVO.getCveAfect();
        params[4] = prestoMensualVO.getCveGposind();
        params[5] = prestoMensualVO.getCveTcr();
        params[6] = prestoMensualVO.getNumMes();
        params[7] = prestoMensualVO.getCveEntidad();
        params[8] = prestoMensualVO.getCveDeleg();
        params[9] = prestoMensualVO.getCveUniad();
        params[10] = prestoMensualVO.getCveRamo();
        params[11] = prestoMensualVO.getCvePart();
        params[12] = prestoMensualVO.getTnoCve();
        params[13] = prestoMensualVO.getCredTot();
        params[14] = prestoMensualVO.getCredDisp();
        params[15] = prestoMensualVO.getCredComp();
        params[16] = prestoMensualVO.getCredEjer();
        params[17] = prestoMensualVO.getCredTrf();
        params[18] = prestoMensualVO.getImpoEjer();
        params[19] = prestoMensualVO.getStatus();
        params[20] = prestoMensualVO.getUsuario();
        params[21] = prestoMensualVO.getFechaAud();
        params[22] = prestoMensualVO.getComponenteCve();
        params[23] = prestoMensualVO.getIpEquipo();

        super.getJdbcTemplate().update(insertQuery, params);
    }
}
