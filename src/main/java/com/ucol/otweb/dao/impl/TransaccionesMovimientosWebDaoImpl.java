/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ITransaccionesMovimientosWebDao;
import com.ucol.otweb.dao.jdbc.BTransMovWebRowMapper;
import com.ucol.otweb.dao.jdbc.OtorgWebContRowMapper;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.vo.OtorgamWebContad;
import com.ucol.otweb.vo.TransMovOtoWeb;
import com.ucol.otweb.vo.TransOtoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@Repository(value = "transMovWebDao")
public class TransaccionesMovimientosWebDaoImpl extends GenericDao implements ITransaccionesMovimientosWebDao {

    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BTRANS_MOV_OTO_WEB_SELECT = "select rfc, curp, nss, num_issste, nombre, folio, tipo_prst, cve_entidad, cve_deleg, cve_uniad, "
            + " cve_oficina, ramo, pagad, status, fecha_mov, fecha_aud, hora_aud, componente, operador, ip_equipo "
            + " from trans_mov_oto_web ";
    private static final String BOTORG_MOV_WEB_CONT_SELECT = "select fecha, contador, usuario, fecha_aud, componente_cve from otorgamweb_contad "
            + " where fecha = ";
    private static final String BDIA_FESTIVO_OTO_WEB_SELECT = "select fecha, usuario, fecha_aud, componente_cve, ip_equipo from otorgamweb_nodisp where fecha = ";
    private static final String ITRANS_MOV_OTO_WEB = " INSERT INTO trans_mov_oto_web(rfc, curp, nss, num_issste, nombre, folio, tipo_prst, cve_entidad, cve_deleg, cve_uniad, cve_oficina, ramo, pagad, status, fecha_mov, fecha_aud, hora_aud, componente, operador, ip_equipo) "
            + "    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String UTRANS_MOV_OTO_WEB = "UPDATE trans_mov_oto_web "
            + "    SET rfc=?, curp=?, nss=?, num_issste=?, nombre=?, folio=?, tipo_prst=?, cve_entidad=?, cve_deleg=?, cve_uniad=?, cve_oficina=?, ramo=?, pagad=?, status=?, fecha_mov=?, fecha_aud=?, hora_aud=?, componente=?, operador=?, ip_equipo=?"
            + "    WHERE num_issste =? AND tipo_prst=? AND FOLIO=? AND STATUS=0 ";
    private static final String ICONTADOR_NUEVO = "insert into otorgamweb_contad "
            + "(fecha, contador, usuario, fecha_aud, componente_cve, ip_equipo) "
            + "values (to_date(?,'%d/%m/%Y'),?, ?, (to_date(?,'%d/%m/%Y'), ?, ?)";
    private static final String UCONTADOR = "update otorgamweb_contad set "
            + "contador=contador+1, usuario=?, fecha_aud=?, componente_cve=?, ip_equipo=? "
            + "where fecha=to_date(?,'%d/%m/%Y')";
    private static final String UPDATE_STATUS_POR_ISSSTE = "UPDATE trans_mov_oto_web set status =? where num_issste=?";
    private static final String UTRANS_OTO_WEB_POR_ISSSTE_FOLIO_ETC = "UPDATE trans_mov_oto_web SET status=?, fecha_aud=?, hora_aud=?, componente=?, ip_equipo=? "
            + "WHERE num_issste =? and ramo= ? and pagad=? and folio = ? and fecha_mov=? ";
    private static final String ITRANS_OTO = "INSERT INTO trans_oto(dt_trans, rfc_trans, nombre_trans, salario_trans, tipo_nomb_trans, sexo_trans, edad_trans, antig_trans, ent_oper_trans, nbr_oper_trans, issste_nbr_trans, loan_nbr_trans, nbr_folio_trans, loan_issue_date, loan_type_prs, loan_stat_prs, orig_loan_prin, loan_disb_amt, imp_refinanc, cap_refinanc, int_refinanc, iva_refinanc, orig_loan_int_amt, orig_iva, deferred_int, warranty_prem, renewal_prem, int_rate, iva_rate, orig_nbr_pay, loan_auth_cd, pay_amt, first_pay_per_yr_d, last_pay_per_yr_du, modo_pago, tipo_cta, cve_banco, num_cta_banc, tipo_presup, entid_otor, deleg_otor, uniad_otor, off_otor, ramo_otor, pagad_otor, cve_afect, cve_part, hora_aud, componente_cve, usuario, ip_equipo) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public TransaccionesMovimientosWebDaoImpl() {
    }

    /**
     * Se obtiene por numero de issste la transaccion de movimientos en
     * Otorgamiento web
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public TransMovOtoWeb obtenerTransMovWeb(TransMovOtoWeb transMovOto) {
        List<TransMovOtoWeb> listaTransMovWeb = null;
        TransMovOtoWeb transMovOtoWeb = null;
        String sql = "";
        String order = " ORDER BY fecha_mov  desc ";
        if (transMovOto.getNumIssste() != null && transMovOto.getNumIssste() > 0) {
            if (sql.equals("")) {
                sql += " where num_issste = " + transMovOto.getNumIssste();
            } else {
                sql += " and num_issste = " + transMovOto.getNumIssste();
            }
        }
        if (transMovOto.getFolio() != null) {
            if (sql.equals("")) {
                sql += " where folio = " + transMovOto.getFolio() + " and status >=0 ";
            } else {
                sql += " and folio = " + transMovOto.getFolio() + " and status >=0 ";
            }
        }
        if (transMovOto.getTipo_prst() > 0) {
            if (sql.equals("")) {
                sql += " where tipo_prst = " + transMovOto.getTipo_prst();
            } else {
                sql += " and tipo_prst = " + transMovOto.getTipo_prst();
            }
        }
        listaTransMovWeb = super.getJdbcTemplate().query(BTRANS_MOV_OTO_WEB_SELECT + sql + order, new BTransMovWebRowMapper());
        if (listaTransMovWeb != null && listaTransMovWeb.size() > 0) {
            transMovOtoWeb = listaTransMovWeb.get(0);
        }

        return transMovOtoWeb;
    }

    /**
     * Se obtiene el contador de visitas a Otorgamiento Web al día en que se
     * quiere hacer la transaccion
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public OtorgamWebContad obtenerContadorVisitasWeb() {
        List<OtorgamWebContad> listacontadorVisWeb = null;
        OtorgamWebContad otorgamWebContad = null;

        listacontadorVisWeb = super.getJdbcTemplate().query(BOTORG_MOV_WEB_CONT_SELECT + DateUtils.fechaActualToString(), new OtorgWebContRowMapper() {

            public OtorgamWebContad mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                OtorgamWebContad otorgamWebContad = new OtorgamWebContad();
                otorgamWebContad.setFecha(rs.getDate(1));
                otorgamWebContad.setContador(rs.getInt(2));
                otorgamWebContad.setUsuario(rs.getString(3));
                otorgamWebContad.setFecha_aud(rs.getDate(4));
                otorgamWebContad.setComponente_cve(rs.getString(5));
                return otorgamWebContad;
            }
        });
        if (listacontadorVisWeb != null && listacontadorVisWeb.size() > 0) {
            otorgamWebContad = listacontadorVisWeb.get(0);
        }

        return otorgamWebContad;
    }

    /**
     * Se obtiene si el día en el que hara la operación es festivo
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public OtorgamWebContad obtenerDiaFestivoAlDia() {
        List<OtorgamWebContad> listacontadorVisWeb = null;
        OtorgamWebContad otorgamWebContad = null;

        listacontadorVisWeb = super.getJdbcTemplate().query(BDIA_FESTIVO_OTO_WEB_SELECT + DateUtils.fechaActualToString(), new OtorgWebContRowMapper() {

            public OtorgamWebContad mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                OtorgamWebContad otorgamWebContad = new OtorgamWebContad();
                otorgamWebContad.setFecha(rs.getDate(1));
                otorgamWebContad.setUsuario(rs.getString(2));
                otorgamWebContad.setFecha_aud(rs.getDate(3));
                otorgamWebContad.setComponente_cve(rs.getString(4));
                otorgamWebContad.setIp_equipo(rs.getString(5));
                return otorgamWebContad;
            }
        });
        if (listacontadorVisWeb != null && listacontadorVisWeb.size() > 0) {
            otorgamWebContad = listacontadorVisWeb.get(0);
        }

        return otorgamWebContad;
    }

    public void update(TransMovOtoWeb transMovOtoWeb) {

        Object[] params = new Object[23];
        params[0] = transMovOtoWeb.getRfc();
        params[1] = transMovOtoWeb.getCurp();
        params[2] = transMovOtoWeb.getNss();
        params[3] = transMovOtoWeb.getNumIssste();
        params[4] = transMovOtoWeb.getNombre();
        params[5] = transMovOtoWeb.getFolio();
        params[6] = transMovOtoWeb.getTipo_prst();
        params[7] = transMovOtoWeb.getCveEntidad();
        params[8] = transMovOtoWeb.getCveDeleg();
        params[9] = transMovOtoWeb.getCveUniad();
        params[10] = transMovOtoWeb.getCveOficina();
        params[11] = transMovOtoWeb.getRamo();
        params[12] = transMovOtoWeb.getPagad();
        params[13] = transMovOtoWeb.getStatus();
        params[14] = new Date();
        params[15] = new Date();
        params[16] = DateUtils.horaActual();
        params[17] = transMovOtoWeb.getComponente();
        params[18] = transMovOtoWeb.getOperador();
        params[19] = transMovOtoWeb.getIp_equipo();
        params[20] = transMovOtoWeb.getNumIssste();
        params[21] = transMovOtoWeb.getTipo_prst();
        params[22] = transMovOtoWeb.getFolio();


        super.getJdbcTemplate().update(
                UTRANS_MOV_OTO_WEB, params);
    }

    public void insertData(TransMovOtoWeb transMovOtoWeb) {

        Object[] params = new Object[20];
        params[0] = transMovOtoWeb.getRfc();
        params[1] = transMovOtoWeb.getCurp();
        params[2] = transMovOtoWeb.getNss();
        params[3] = transMovOtoWeb.getNumIssste();
        params[4] = transMovOtoWeb.getNombre();
        params[5] = transMovOtoWeb.getFolio();
        params[6] = transMovOtoWeb.getTipo_prst();
        params[7] = transMovOtoWeb.getCveEntidad();
        params[8] = transMovOtoWeb.getCveDeleg();
        params[9] = transMovOtoWeb.getCveUniad();
        params[10] = transMovOtoWeb.getCveOficina();
        params[11] = transMovOtoWeb.getRamo();
        params[12] = transMovOtoWeb.getPagad();
        params[13] = transMovOtoWeb.getStatus();
        params[14] = new Date();
        params[15] = new Date();
        params[16] = DateUtils.horaActual();
        params[17] = transMovOtoWeb.getComponente();
        params[18] = transMovOtoWeb.getOperador();
        params[19] = transMovOtoWeb.getIp_equipo();

        super.getJdbcTemplate().update(
                ITRANS_MOV_OTO_WEB, params);
    }

    public void insertContador(OtorgamWebContad contador) {
        super.getJdbcTemplate().update(ICONTADOR_NUEVO,
                new Object[]{
                    DateUtils.formatFechaToString(contador.getFecha()),
                    contador.getContador(),
                    contador.getUsuario(),
                    DateUtils.formatFechaToString(contador.getFecha_aud()),
                    contador.getComponente_cve(),
                    contador.getIp_equipo()
                });
    }

    public void incrementaContador(OtorgamWebContad contador) {
        super.getJdbcTemplate().update(UCONTADOR,
                new Object[]{
                    contador.getUsuario(),
                    DateUtils.formatFechaToString(contador.getFecha_aud()),
                    contador.getComponente_cve(),
                    contador.getIp_equipo(),
                    DateUtils.formatFechaToString(contador.getFecha())
                });
    }

    public void updatePorIsssteFolio(TransMovOtoWeb transMovOtoWeb) {
        Object[] params = new Object[10];
        params[0] = transMovOtoWeb.getStatus();
        params[1] = new Date();
        params[2] = DateUtils.horaActual();
        params[3] = transMovOtoWeb.getComponente();
        params[4] = transMovOtoWeb.getIp_equipo();
        params[5] = transMovOtoWeb.getNumIssste();
        params[6] = transMovOtoWeb.getRamo();
        params[7] = transMovOtoWeb.getPagad();
        params[8] = transMovOtoWeb.getFolio();
        params[9] = transMovOtoWeb.getFechaMov();

        super.getJdbcTemplate().update(
                UTRANS_OTO_WEB_POR_ISSSTE_FOLIO_ETC, params);
    }

    public void insert(TransOtoVO transOto) {
        Object[] params = new Object[51];
        params[0] = transOto.getDtTrans();
        params[1] = transOto.getRfcTrans();
        params[2] = transOto.getNombreTrans();
        params[3] = transOto.getSalarioTrans();
        params[4] = transOto.getTipoNombTrans();
        params[5] = transOto.getSexoTrans();
        params[6] = transOto.getEdadTrans();
        params[7] = transOto.getAntigTrans();
        params[8] = transOto.getEntOperTrans();
        params[9] = transOto.getNbrOperTrans();
        params[10] = transOto.getIsssteNbrTrans();
        params[11] = transOto.getLoanNbrTrans();
        params[12] = transOto.getNbrFolioTrans();
        params[13] = transOto.getLoanIssueDate();
        params[14] = transOto.getLoanTypePrs();
        params[15] = transOto.getLoanStatPrs();
        params[16] = transOto.getOrigLoanPrin();
        params[17] = transOto.getLoanDisbAmt();
        params[18] = transOto.getImpRefinanc();
        params[19] = transOto.getCapRefinanc();
        params[20] = transOto.getIntRefinanc();
        params[21] = transOto.getIvaRefinanc();
        params[22] = transOto.getOrigLoanIntAmt();
        params[23] = transOto.getOrigIva();
        params[24] = transOto.getDeferredInt();
        params[25] = transOto.getWarrantyPrem();
        params[26] = transOto.getRenewalPrem();
        params[27] = transOto.getIntRate();
        params[28] = transOto.getIvaRate();
        params[29] = transOto.getOrigNbrPay();
        params[30] = transOto.getLoanAuthCd();
        params[31] = transOto.getPayAmt();
        params[32] = transOto.getFirstPayPerYrD();
        params[33] = transOto.getLastPayPerYrDu();
        params[34] = transOto.getModoPago();
        params[35] = transOto.getTipoCta();
        params[36] = transOto.getCveBanco();
        params[37] = transOto.getNumCtaBanc();
        params[38] = transOto.getTipoPresup();
        params[39] = transOto.getEntidOtor();
        params[40] = transOto.getDelegOtor();
        params[41] = transOto.getUniadOtor();
        params[42] = transOto.getOffOtor();
        params[43] = transOto.getRamoOtor();
        params[44] = transOto.getPagadOtor();
        params[45] = transOto.getCveAfect();
        params[46] = transOto.getCvePart();
        params[47] = transOto.getHoraAud();
        params[48] = transOto.getComponenteCve();
        params[49] = transOto.getUsuario();
        params[50] = transOto.getIpEquipo();
        super.getJdbcTemplate().update(ITRANS_OTO, params);

    }
}
