/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IRecepcionSolicitudDao;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.dao.jdbc.SolicitudExtractor;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.vo.MotivosSolVO;
import com.ucol.otweb.vo.RecepcionVO;
import com.ucol.otweb.vo.SolicitudVO;
import com.ucol.otweb.vo.TransMovOtoWeb;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "recepcionSolDao")
public class RecepcionSolicitudDaoImpl extends GenericDao implements IRecepcionSolicitudDao {

    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BCOUNT_RECEPCION_SOLICITUD_SELECT = "select count(*) from recepcion where stat_rec = 1 and anio_sol = " + DateUtils.anioActual();
    private static final String BCOUNT_RECEPCION_SOLICITUD_SELECT_SIMUL = "SELECT COUNT(*) FROM recepcion ";
    private static final String BCOBERTURA_SOLICITUD_SELECT = "SELECT cve_entidad,cve_deleg,cve_uniad,cve_oficina FROM solicitud WHERE anio_sol = " + DateUtils.anioActual() + " AND cve_stat_sol <> 10 ";
    private static final String BCOUNT_RECHAZOS_SOLICITUD_SELECT = "SELECT COUNT(*) FROM solicitud S, motivos_sol R  WHERE S.anio_sol = " + DateUtils.anioActual() + " AND R.stat_motivo = 1 "
            + " AND S.anio_sol = R.anio_sol AND S.folio_sol = R.folio_sol AND S.cve_tcr = R.cve_tcr ";
    private static final String BCOUNT_REC_SOL_X_ISSSTE_SELECT = "SELECT COUNT(*) FROM recepcion LEFT JOIN solicitud ON (recepcion.anio_sol = solicitud.anio_sol AND "
            + " recepcion.folio_sol = solicitud.folio_sol AND recepcion.cve_tcr = solicitud.cve_tcr AND solicitud.cve_stat_sol IN (1,2,4,5,6,7,8,9,10)) "
            + " WHERE recepcion.anio_sol = " + DateUtils.anioActual() + " AND recepcion.num_issste = ? AND recepcion.stat_rec = 1 AND solicitud.anio_sol IS NULL ";
    private static final String BCOUNT_REC_SOL_X_OPERADOR_SELECT = "select count(*) from recepcion WHERE dt_fecha_rec = " + DateUtils.fechaActualToString() + " AND anio_sol = " + DateUtils.anioActual() + " AND stat_rec = 1";
    private static final String BESTAT_SOLIC_OTORGADA = "SELECT cve_stat_sol FROM solicitud WHERE anio_sol = ? AND num_issste = ? AND rfc = ? AND cve_stat_sol IN (2,3,4)";
    private static final String BNUM_ISSSTE_SOLIC_OCUPADA = "SELECT num_issste FROM solicitud WHERE anio_sol = ? AND  folio_sol = ?  AND cve_tcr = ? AND cve_stat_sol IN (2,3)";
    private static final String BSOLICITUD = "SELECT cve_entidad, cve_deleg, cve_uniad, cve_oficina, anio_sol, folio_sol, cve_tcr, cve_stat_sol,num_ramo,num_pagaduria FROM solicitud WHERE cve_stat_sol IN (2,3)";
    private static final String DRECECPION = " DELETE recepcion WHERE anio_sol =? AND folio_sol = ? AND cve_tcr = ? AND num_issste = ?";
    private static final String ISOLICITUD = " INSERT INTO solicitud(anio_sol, folio_sol, cve_tcr, fecha_sol, num_issste, rfc, cve_entidad, cve_deleg, cve_uniad, cve_oficina, num_ramo, num_pagaduria, fec_recepci, fec_rechvis, fec_rechoto, fec_otorga, fec_prscanc, fec_cheqemi, fec_cheqcan, fec_cheqent, fec_solcanc, cve_stat_sol, usuario, fecha_aud, componente_cve, ip_equipo) "
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String USOLICITUD_ESTATUS = "UPDATE solicitud SET cve_stat_sol = ? ,"
            + "usuario = ?,"
            + "fecha_aud = ?,"
            + "componente_cve = ?,"
            + "ip_equipo = ? "
            + " WHERE anio_sol = ? "
            + " AND folio_sol = ?"
            + " AND cve_tcr = ?";
    private static final String BRECHAZO_VISUAL = " SELECT MAX(M.fecha_aud) "
            + " FROM motivos_sol M,recepcion R,c_mot_rechazo C "
            + " WHERE R.folio_sol = ?"
            + " AND R.cve_tcr = ? "
            + " AND R.anio_sol = " + DateUtils.anioActual()
            + " AND M.anio_sol = R.anio_sol "
            + " AND M.folio_sol = R.folio_sol "
            + " AND M.cve_tcr = R.cve_tcr "
            + " AND C.cve_motivo = M.cve_motivo "
            + " AND C.tipo_motivo = 'V' "
            + " AND R.stat_rec = 1"
            + " AND C.stat_motivo = 1";
    private static final String BFECHA_RECH = "SELECT dt_fecha_rec FROM recepcion"
            + " WHERE anio_sol = YEAR(dt_fecha_rec)"
            + " AND folio_sol = ? "
            + " AND cve_tcr = ? "
            + " AND stat_rec = 1";
    private static final String COUNT_MOTIVOS_SOL = "SELECT COUNT(*) FROM motivos_sol M,c_mot_rechazo R "
            + " WHERE M.anio_sol = " + DateUtils.anioActual()
            + " AND M.folio_sol = ? "
            + " AND M.cve_tcr = ? "
            + " AND M.stat_motivo = 1"
            + " AND M.cve_motivo = R.cve_motivo";
    private static final String ELIMINAR_MOTIVO_SOL = "DELETE motivos_sol WHERE anio_sol = '" + DateUtils.anioActual() + "'"
            + " AND folio_sol = ? "
            + " AND cve_tcr = ? ";
    private static final String ELIMINAR_SOLICITUD = "DELETE solicitud WHERE anio_sol = '" + DateUtils.anioActual() + "'"
            + " AND folio_sol = ? "
            + " AND cve_tcr = ? ";
    private static final String BCVE_MOTIVO_SOL = "SELECT cve_motivo FROM motivos_sol"
            + " WHERE anio_sol = ? "
            + " AND folio_sol = ? "
            + " AND cve_tcr = ? "
            + " AND stat_motivo = 1";
    private static final String UMOT_SOL = "UPDATE motivos_sol SET stat_motivo = 0"
            + ", usuario = ?"
            + ", fecha_aud = ? "
            + ", componente_cve = ? "
            + ", ip_equipo = ? "
            + " WHERE anio_sol = ? "
            + " AND folio_sol = ? "
            + " AND cve_tcr = ?"
            + " AND cve_motivo = ?"
            + " AND stat_motivo = 1";
    private static final String IMOT_SOL = "INSERT INTO motivos_sol(anio_sol, folio_sol, cve_tcr, cve_motivo, stat_motivo, usuario, fecha_aud, componente_cve, ip_equipo)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    public RecepcionSolicitudDaoImpl() {
    }

    /**
     * Se obtiene la cuenta de solicitudes en recepcion con respecto al folio,
     * al año y tipo de credito
     *
     * @param recepcionVO
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countRecepcionSolicitudSim(TransMovOtoWeb movOtoWeb, int anio) {
        Integer cuentaRecepciones = null;
        String sql = "";
        if (movOtoWeb.getNumIssste() != null && movOtoWeb.getNumIssste() > 0) {
            if (sql.equals("")) {
                sql += " where num_issste = " + movOtoWeb.getNumIssste();
            } else {
                sql += " and num_issste = " + movOtoWeb.getNumIssste();
            }
        }
        if (movOtoWeb.getTipo_prst() > 0) {
            if (sql.equals("")) {
                sql += " where cve_tcr = " + movOtoWeb.getTipo_prst();
            } else {
                sql += " and cve_tcr = " + movOtoWeb.getTipo_prst();
            }
        }
        if (movOtoWeb.getFolio() != null && movOtoWeb.getFolio() > 0) {
            if (sql.equals("")) {
                sql += " where folio_sol = " + movOtoWeb.getFolio();
            } else {
                sql += " and folio_sol = " + movOtoWeb.getFolio();
            }
        }
        if (movOtoWeb.getCveEntidad() > 0) {
            if (sql.equals("")) {
                sql += " where cve_entidad_origen = " + movOtoWeb.getCveEntidad();
            } else {
                sql += " and cve_entidad_origen = " + movOtoWeb.getCveEntidad();
            }
        }
        if (movOtoWeb.getCveDeleg() > 0) {
            if (sql.equals("")) {
                sql += " where cve_deleg_origen = " + movOtoWeb.getCveDeleg();
            } else {
                sql += " and cve_deleg_origen = " + movOtoWeb.getCveDeleg();
            }
        }
        if (anio > 0) {
            if (sql.equals("")) {
                sql += " where anio_sol = " + anio;
            } else {
                sql += " and anio_sol = " + anio;
            }
        }
        if (sql.equals("")) {
            sql += " where cve_uniad_origen = " + movOtoWeb.getCveUniad() + " and cve_oficina_origen " + movOtoWeb.getCveOficina();
        } else {
            sql += " and cve_uniad_origen = " + movOtoWeb.getCveUniad() + " and cve_oficina_origen " + movOtoWeb.getCveOficina();
        }
        cuentaRecepciones = super.getJdbcTemplate().queryForInt(BCOUNT_RECEPCION_SOLICITUD_SELECT_SIMUL + sql);
        return cuentaRecepciones;
    }

    /**
     * Se obtiene la cuenta de solicitudes en recepcion con respecto al folio,
     * al año y tipo de credito
     *
     * @param recepcionVO
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countRecepcionSolicitud(RecepcionVO recepcionVO) {
        Integer cuentaRecepciones = 0;
        String sql = "";
        if (recepcionVO.getFolioSol() != null && recepcionVO.getFolioSol() > 0) {
            sql += " and folio_sol  = " + recepcionVO.getFolioSol();

        }
        if (recepcionVO.getCveTcr() > 0) {
            sql += " and cve_tcr = " + recepcionVO.getCveTcr();

        }

        List<Serializable> lista = super.getJdbcTemplate().query(BCOUNT_RECEPCION_SOLICITUD_SELECT + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                int cuentaRecep = rs.getInt(1);
                return cuentaRecep;
            }
        });
        if (lista != null && lista.size() > 0) {
            cuentaRecepciones = (Integer) lista.get(0);
        }
        return cuentaRecepciones;
    }

    /**
     * Se obtiene la cobertura de la solicitud con respecto al folio, al año, al
     * tipo de credito y a su estatus diferente de 10
     *
     * @param recepcionVO
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<RecepcionVO> obtenerCoberturaSolicitudCredito(RecepcionVO recepcionVO) {
        List<Serializable> coberturaSolicitud = null;
        String sql = "";
        if (recepcionVO.getFolioSol() != null && recepcionVO.getFolioSol() > 0) {
            sql += " and folio_sol  = " + recepcionVO.getFolioSol();

        }
        if (recepcionVO.getCveTcr() > 0) {
            sql += " and cve_tcr = " + recepcionVO.getCveTcr();

        }

        coberturaSolicitud = super.getJdbcTemplate().query(BCOBERTURA_SOLICITUD_SELECT + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                SolicitudExtractor solicitudExtractor = new SolicitudExtractor();
                return solicitudExtractor.extractData(rs);
            }
        });


        return (List<RecepcionVO>) (List) coberturaSolicitud;
    }

    /**
     * Se obtiene el numero de rechazos de la solicitud con respecto al folio,
     * al año, al tipo de credito y a su estatus diferente de 10
     *
     * @param recepcionVO
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countRechazosSolicitud(RecepcionVO recepcionVO) {
        Integer cuentaRechazosS = 0;
        String sql = "";
        if (recepcionVO.getFolioSol() != null && recepcionVO.getFolioSol() > 0) {
            sql += " and S.folio_sol  = " + recepcionVO.getFolioSol();

        }
        if (recepcionVO.getCveTcr() > 0) {
            sql += " and S.cve_tcr = " + recepcionVO.getCveTcr();

        }

        List<Serializable> lista = super.getJdbcTemplate().query(BCOUNT_RECHAZOS_SOLICITUD_SELECT + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                int countRecMotRech = 0;
                countRecMotRech = rs.getInt(1);
                return countRecMotRech;
            }
        });
        if (lista != null && lista.size() > 0) {
            cuentaRechazosS = (Integer) lista.get(0);
        }
        return cuentaRechazosS;
    }

    /**
     * Se valida que no exista mas de un registro para la recepcion de una
     * solicitud para un numero de ISSSTE
     *
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countRecepcionSolicitudesPorIssste(Integer numIssste) {
        Integer cuentaRecSolNum = null;
        cuentaRecSolNum = super.getJdbcTemplate().queryForInt(BCOUNT_REC_SOL_X_ISSSTE_SELECT, new Object[]{numIssste});
        return cuentaRecSolNum;
    }

    /**
     * Si no existe algun registro en la consulta anterior, se hcae el conteo de
     * recepciones de solicitud por el operador
     *
     * @param recepcionVO
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countRecepcionPorOperador(RecepcionVO recepcionVO) {
        Integer cuentaRecSolOpe = null;
        String sql = "";
        if (recepcionVO.getFolioSol() != null && recepcionVO.getFolioSol() > 0) {
            sql += " and folio_sol  = " + recepcionVO.getFolioSol();

        }
        if (recepcionVO.getCveTcr() > 0) {
            sql += " and cve_tcr = " + recepcionVO.getCveTcr();

        }
        if (recepcionVO.getCveOperadorRec() > 0) {
            sql += " AND cve_operador_rec = " + recepcionVO.getCveOperadorRec();
        }
        cuentaRecSolOpe = super.getJdbcTemplate().queryForInt(BCOUNT_REC_SOL_X_OPERADOR_SELECT + sql);
        return cuentaRecSolOpe;
    }

    /**
     * Obtiene el estatus de la solicitud otorgada
     *
     * @param numIssste
     * @param rfc
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer obtenerEstatusSolicitudOtorgada(int numIssste, String rfc) {
        Integer estatus = null;
        List<Serializable> lista = super.getJdbcTemplate().query(BESTAT_SOLIC_OTORGADA,
                new Object[]{DateUtils.anioActual(), numIssste, rfc}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                SolicitudVO vo = new SolicitudVO();
                vo.setCve_stat_sol(rs.getInt(1));
                return vo;
            }
        });
        if (lista != null && lista.size() > 0) {
            estatus = ((SolicitudVO) lista.get(0)).getCve_stat_sol();
        }
        return estatus;
    }

    /**
     * Obtiene el numero de issste de la solicitud existente
     *
     * @param folioSol
     * @param tpoCr
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer obtenerSolicitudOcupada(int folioSol, int tpoCr) {
        Integer issste = null;

        List<Serializable> lista = super.getJdbcTemplate().query(BNUM_ISSSTE_SOLIC_OCUPADA,
                new Object[]{DateUtils.anioActual(), folioSol, tpoCr}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                SolicitudVO vo = new SolicitudVO();
                vo.setNum_issste(rs.getInt(1));
                return vo;
            }
        });
        if (lista != null && lista.size() > 0) {
            issste = ((SolicitudVO) lista.get(0)).getNum_issste();
        }
        return issste;
    }

    /**
     *
     * @param solicitudVO
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<SolicitudVO> obtenerSolicitudCredito(SolicitudVO solicitudVO) {
        List<Serializable> listaSolicitud = null;
        String sql = "";
        if (solicitudVO.getNum_issste() != null && solicitudVO.getNum_issste() > 0) {
            sql += " and num_issste  = " + solicitudVO.getNum_issste();

        }
        if (solicitudVO.getRfc() != null) {
            sql += " and rfc  = " + solicitudVO.getRfc();

        }
        if (solicitudVO.getAnio_sol() > 0) {
            sql += " and anio_sol  = " + solicitudVO.getAnio_sol();

        }

        listaSolicitud = super.getJdbcTemplate().query(BSOLICITUD + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                SolicitudVO vo = new SolicitudVO();
                vo.setCve_entidad(rs.getInt(1));
                vo.setCve_deleg(rs.getInt(2));
                vo.setCve_uniad(rs.getInt(3));
                vo.setCve_oficina(rs.getInt(4));
                vo.setAnio_sol(rs.getInt(5));
                vo.setFolio_sol(rs.getInt(6));
                vo.setCve_tcr(rs.getInt(7));
                vo.setCve_stat_sol(rs.getInt(8));
                vo.setNum_ramo(rs.getInt(9));
                vo.setNum_pagaduria(rs.getString(10));
                return vo;
            }
        });


        return (List<SolicitudVO>) (List) listaSolicitud;
    }

    public void eliminarRecepcion(RecepcionVO recepcion) {

        super.getJdbcTemplate().update(DRECECPION, new Object[]{
                    recepcion.getAnioSol(),
                    recepcion.getFolioSol(),
                    recepcion.getCveTcr(),
                    recepcion.getNumIssste()
                });
    }

    public boolean insert(RecepcionVO recepcion) {
        boolean seInserto = true;
        String insert = "INSERT INTO recepcion(cve_operador_rec, dt_fecha_rec, anio_sol, folio_sol, cve_tcr, num_issste, stat_rec, cve_entidad_origen, cve_deleg_origen, cve_uniad_origen, cve_oficina_origen, cve_entidad, cve_deleg, cve_uniad, cve_oficina, usuario, fecha_aud, componente_cve, ip_equipo) "
                + "VALUES(?, ? ,? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Object[] params = new Object[19];
            params[0] = recepcion.getCveOperadorRec();
            params[1] = recepcion.getDtFechaRec();
            params[2] = recepcion.getAnioSol();
            params[3] = recepcion.getFolioSol();
            params[4] = recepcion.getCveTcr();
            params[5] = recepcion.getNumIssste();
            params[6] = recepcion.getStatRec();
            params[7] = recepcion.getCveEntidadOrigen();
            params[8] = recepcion.getCveDelegOrigen();
            params[9] = recepcion.getCveUniadOrigen();
            params[10] = recepcion.getCveOficinaOrigen();
            params[11] = recepcion.getCveEntidad();
            params[12] = recepcion.getCveDeleg();
            params[13] = recepcion.getCveUniad();
            params[14] = recepcion.getCveOficina();
            params[15] = recepcion.getUsuario();
            params[16] = recepcion.getFechaAud();
            params[17] = recepcion.getComponenteCve();
            params[18] = recepcion.getIpEquipo();
            super.getJdbcTemplate().update(insert, params);
        } catch (Exception e) {
            seInserto = false;
        }
        return seInserto;
    }

    public void insert(SolicitudVO sol) {
        Object[] params = new Object[26];
        params[0] = sol.getAnio_sol();
        params[1] = sol.getFolio_sol();
        params[2] = sol.getCve_tcr();
        params[3] = sol.getFecha_sol();
        params[4] = sol.getNum_issste();
        params[5] = sol.getRfc();
        params[6] = sol.getCve_entidad();
        params[7] = sol.getCve_deleg();
        params[8] = sol.getCve_uniad();
        params[9] = sol.getCve_oficina();
        params[10] = sol.getNum_ramo();
        params[11] = sol.getNum_pagaduria();
        params[12] = sol.getFec_recepci();
        params[13] = sol.getFec_rechvis();
        params[14] = sol.getFec_rechoto();
        params[15] = sol.getFec_otorga();
        params[16] = sol.getFec_prscanc();
        params[17] = sol.getFec_cheqemi();
        params[18] = sol.getFec_cheqcan();
        params[19] = sol.getFec_cheqent();
        params[20] = sol.getFec_solcanc();
        params[21] = sol.getCve_stat_sol();
        params[22] = sol.getUsuario();
        params[23] = sol.getFecha_aud();
        params[24] = sol.getComponente_cve();
        params[25] = sol.getIp_equipo();

        super.getJdbcTemplate().update(ISOLICITUD, params);

    }

    public void update(SolicitudVO sol) {
        Object[] params = new Object[8];
        params[0] = sol.getCve_stat_sol();
        params[1] = sol.getUsuario();
        params[2] = new Date();
        params[3] = sol.getComponente_cve();
        params[4] = sol.getIp_equipo();
        params[5] = sol.getAnio_sol();
        params[6] = sol.getFolio_sol();
        params[7] = sol.getCve_tcr();
        super.getJdbcTemplate().update(USOLICITUD_ESTATUS, params);

    }

    public Date rechazoVisual(int folio, int cveTcr) {
        Object[] params = new Object[]{folio, cveTcr};
        Date fechaRechVisual = null;
        List listaRechazovisual =
                super.getJdbcTemplate().query(BRECHAZO_VISUAL, params, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                Date fecha = rs.getDate(1);
                return fecha;
            }
        });
        for (Object rechazo : listaRechazovisual) {
            fechaRechVisual = (Date) rechazo;
            break;
        }
        return fechaRechVisual;
    }

    public Date obtenerFechaRec(int folio, int cveTcr) {
        Object[] params = new Object[]{folio, cveTcr};
        Date fechaRech = null;
        List listaFechaRech =
                super.getJdbcTemplate().query(BFECHA_RECH, params, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                Date fecha = rs.getDate(1);
                return fecha;
            }
        });
        for (Object rechazo : listaFechaRech) {
            fechaRech = (Date) rechazo;
            break;
        }
        return fechaRech;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countMotivosSolFolio(Integer folio, int tipoPrest) {
        Integer cuentaRecSolNum = null;
        cuentaRecSolNum = super.getJdbcTemplate().queryForInt(COUNT_MOTIVOS_SOL, new Object[]{folio, tipoPrest});
        return cuentaRecSolNum;
    }

    public boolean eliminarMotivoSol(MotivosSolVO motivosSolVO) {
        boolean eliminado = true;
        try {
            Object[] params = new Object[2];
            params[0] = motivosSolVO.getFolioSol();
            params[1] = motivosSolVO.getCveTcr();
            super.getJdbcTemplate().update(ELIMINAR_MOTIVO_SOL, params);
        } catch (Exception e) {
            eliminado = false;
        }
        return eliminado;
    }

    public boolean eliminarSolicitud(SolicitudVO solicitudVO) {
        boolean eliminado = true;
        try {
            Object[] params = new Object[2];
            params[0] = solicitudVO.getFolio_sol();
            params[1] = solicitudVO.getCve_tcr();
            super.getJdbcTemplate().update(ELIMINAR_SOLICITUD, params);
        } catch (Exception e) {
            eliminado = false;
        }
        return eliminado;
    }

    public List<MotivosSolVO> obtenerClaveMotivoSol(MotivosSolVO motivosSolVO) {
        Object[] params = {
            motivosSolVO.getAnioSol(),
            motivosSolVO.getFolioSol(),
            motivosSolVO.getCveTcr()};
        List<MotivosSolVO> listaMot = (List<MotivosSolVO>) (List) super.getJdbcTemplate().query(BCVE_MOTIVO_SOL, params,
                new SerializableRowMapper() {

                    public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                        MotivosSolVO vo = new MotivosSolVO();
                        vo.setCveMotivo(rs.getInt(1));
                        return vo;
                    }
                });
        return listaMot;
    }

    public void update(MotivosSolVO motVO) {
        /*"UPDATE motivos_sol SET stat_motivo = 0",                # Inactivo
        ", usuario = ",gr_solicitud.usuario,
        ", fecha_aud = '",gr_solicitud.fecha_aud,"'",
        ", componente_cve = '",gr_solicitud.componente_cve,"'",
        ", ip_equipo = '",gr_solicitud.ip_equipo,"'",
        " WHERE anio_sol = ",gr_solicitud.anio_sol,
        " AND folio_sol = ",gr_solicitud.folio_sol,
        " AND cve_tcr =",gr_solicitud.cve_tcr,
        " AND cve_motivo = ",ls_cve_motivo,
        " AND stat_motivo = 1"*/
        Object[] params = {
            motVO.getUsuario(),
            motVO.getFechaAud(),
            motVO.getComponenteCve(),
            motVO.getIpEquipo(),
            motVO.getAnioSol(),
            motVO.getFolioSol(),
            motVO.getCveTcr(),
            motVO.getCveMotivo()
        };
        super.getJdbcTemplate().update(UMOT_SOL, params);
    }

    public void insertMotSol(MotivosSolVO motivosSolVO) {
        Object[] params = {motivosSolVO.getAnioSol(),
            motivosSolVO.getFolioSol(),
            motivosSolVO.getCveTcr(),
            motivosSolVO.getCveMotivo(),
            motivosSolVO.getStatMotivo(),
            motivosSolVO.getUsuario(),
            motivosSolVO.getFechaAud(),
            motivosSolVO.getComponenteCve(),
            motivosSolVO.getIpEquipo()
        };
        super.getJdbcTemplate().update(IMOT_SOL, params);
    }
}
