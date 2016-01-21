/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IFolioDao;
import com.ucol.otweb.dao.jdbc.BFolioVOExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.vo.FolioClaveVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.RecepcionVO;
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
@Repository(value = "folioDao")
public class FolioDaoImpl extends GenericDao implements IFolioDao {

    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BFOLIO_X_PRESTAMO_SELECT = "select f.anio , f.cve_tcr, tc.nom_tcr, f.cve_entidad, f.cve_deleg, f.cve_uniad,f.num_ramo_ant, f.cve_afecta_presup "
            + " from [TABLA] f, tpo_credito tc "
            + " where tc.cve_tcr = f.cve_tcr  and f.anio = " + DateUtils.anioActual();
    private static final String BFOLIO_SOLIC_EXISTE_SELECT = "SELECT cve_tcr,tpo_presto,cve_afecta_presup,num_ramo_ant, tno_cve, cve_entidad,cve_deleg,cve_uniad FROM folios where anio = " + DateUtils.anioActual();
    private static final String BCOUNT_FOLIOS_BLOQUEADOS_SELECT = "select count(*) from folios_bloqueados where anio = " + DateUtils.anioActual();
    private static final String CFOLIO_RAMO = "SELECT COUNT(*) FROM folio_ramo WHERE ram_fol = ? AND   ram_plz = ?";
    private static final String CFOLIO = "SELECT COUNT(*) FROM FOLIOS WHERE anio=anio ";
    private static final String BPREST_ADS_FOLIOS_ESPECIALES = "SELECT num_prs_ad FROM folios_especiales  WHERE ? BETWEEN num_folio_ini AND num_folio_fin AND cve_tcr = ? AND anio = ?";
    private static final String BSELECT_FOLIOS = "SELECT tpo_presto,cve_afecta_presup FROM FOLIOS WHERE ? BETWEEN num_folio_ini AND num_folio_fin AND cve_tcr = ? AND anio = ?";
    private static final String BESTATUSPROC = "select  estatus from estatus_proceso WHERE funcion_proc=?";
    private static final String BFOLIOCLAVE_SELECT=" SELECT folio, clave, anio, tpo_cred FROM folio_clave WHERE folio=? and anio= "+DateUtils.anioActual()+ " and tpo_cred=? ";
    
    public FolioDaoImpl() {
    }

    /**
     * Se obtiene el folio por Tipo de Prestamo, Anio y un rango de inicio a fin
     * del número de folio
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<FolioVO> consultaFolioXPrestamo(Integer cveTrc, Integer numFolio) {
        List<FolioVO> folioXPrestamo = null;
        String sql = "";
        String tabla = "folios";
        if (cveTrc != null && cveTrc > 0) {
            sql += " and f.cve_tcr = " + cveTrc;
        }
        if (numFolio != null && numFolio !=0) {
            sql += " and f.num_folio_ini <= " + numFolio + " and f.num_folio_fin >= " + numFolio;
            if(numFolio<0){
                tabla="folios_sim";
            }
        }

        folioXPrestamo = (List) super.getJdbcTemplate().query(BFOLIO_X_PRESTAMO_SELECT.replace("[TABLA]", tabla) + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                BFolioVOExtractor bFolioVOExtractor = new BFolioVOExtractor();
                return bFolioVOExtractor.extractData(rs);
            }
        });
        return folioXPrestamo;
    }

    /**
     * Se valida que el folio de la solicitud exista en la tabla de Folios
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<FolioVO> obtenerFolioSolicitud(FolioVO folioSolicitud) {
        List<FolioVO> folioXPrestamo = null;
        String where = "";
        if (folioSolicitud.getFolioSolicitud() != null && !folioSolicitud.getFolioSolicitud().isEmpty()) {
            where += " and " + folioSolicitud.getFolioSolicitud() + " BETWEEN num_folio_ini AND num_folio_fin ";
        }
        if (folioSolicitud.getCveTcr() > 0) {
            where += " and cve_tcr = " + folioSolicitud.getCveTcr();
        }
        if (folioSolicitud.getTpo_presto() != null && folioSolicitud.getTpo_presto().isEmpty()) {
            where += " and tpo_presto = " + folioSolicitud.getTpo_presto();
        }
        if (folioSolicitud.getCveAfectaPresup() > 0) {
            where += " and cve_afecta_presup = " + folioSolicitud.getCveAfectaPresup();
        }



        folioXPrestamo = (List) super.getJdbcTemplate().query(BFOLIO_SOLIC_EXISTE_SELECT + where, new SerializableRowMapper() {

            public FolioVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                FolioVO folioVO = new FolioVO();
                folioVO.setCveTcr(rs.getInt(1));
                folioVO.setTpo_presto(rs.getString(2));
                folioVO.setCveAfectaPresup(rs.getInt(3));
                folioVO.setNumRamoAnt(rs.getInt(4));
                folioVO.setTnoCve(rs.getInt(5));
                folioVO.setCveEntidad(rs.getInt(6));
                folioVO.setCveDeleg(rs.getInt(7));
                folioVO.setCveUniad(rs.getInt(8));
                return folioVO;
            }
        });

        return folioXPrestamo;
    }

    /**
     * Se obtiene el numero total de folios bloqueados por folio de solicitud,
     * año y tipo de prestamo
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countFoliosBloqueados(RecepcionVO folioSolicitud) {
        Integer cuentaFoliosBloqueados = null;
        String where = "";
        if (folioSolicitud.getFolioSol() != null && folioSolicitud.getFolioSol()!=0) {
            where += " and " + folioSolicitud.getFolioSol() + " BETWEEN num_folio_ini AND num_folio_fin ";

        }
        if (folioSolicitud.getCveTcr() > 0) {
            where += " and cve_tcr = " + folioSolicitud.getCveTcr();
        }
        cuentaFoliosBloqueados = super.getJdbcTemplate().queryForInt(BCOUNT_FOLIOS_BLOQUEADOS_SELECT + where);
        return cuentaFoliosBloqueados;
    }

    /**
     * contador de folio-ramo
     *
     * @param ramFol
     * @param ramPlz
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countFolioRamo(int ramFol, int ramPlz) {
        Integer count = null;
        count = super.getJdbcTemplate().queryForInt(CFOLIO_RAMO, new Object[]{ramFol, ramPlz});
        return count;
    }

    /**
     * Con ciertos rangos de folios se van a poder otorgar créditos de un tipo
     * préstamo aun cuando ya hayan hecho uso del máximo número de préstamos
     * para ese tipo
     *
     * @param folio numero de folio que se buscara entre los Folios especiales
     * @param cveTcr clave del tipo de prestamos
     * @param anio anio para cuando es valido el prestamo adicional
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer obtenerNumeroPresAdicFoliosEspeciales(int folio, int cveTcr, int anio) {
        Integer nPresAdic = 1000;
        List<Serializable> foliosEspeciales = super.getJdbcTemplate().query(BPREST_ADS_FOLIOS_ESPECIALES, new Object[]{folio, cveTcr, anio}, new SerializableRowMapper(){

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                FolioVO vO = new FolioVO();
                vO.setFolioSolicitud(rs.getString(1));
                return vO;
            }
        
        });
        /*if(foliosEspeciales!=null && foliosEspeciales.size()>0){
            nPresAdic=Integer.parseInt(((FolioVO)foliosEspeciales.get(0)).getFolioSolicitud());
        }*/
        return nPresAdic;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public FolioVO obtenerFolios(int folioSol, int cveTcr, int anio) {
        FolioVO folio = null;
        folio = (FolioVO) super.getJdbcTemplate().queryForObject(BSELECT_FOLIOS, new Object[]{folioSol, cveTcr, anio}, new SerializableRowMapper() {

            public FolioVO mapRow(ResultSet rs, int i) throws SQLException {
                FolioVO vo = new FolioVO();
                vo.setTpo_presto(rs.getString(1));
                vo.setCveAfectaPresup(rs.getInt(2));
                return vo;
            }
        });
        return folio;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countFolios(FolioVO folio, boolean sinCobertura) {
        Integer count = null;
        StringBuilder where = new StringBuilder();
        if (folio.getFolioSolicitud() != null && !folio.getFolioSolicitud().isEmpty()) {
            where.append(" AND ");
            where.append(folio.getFolioSolicitud());
            where.append(" BETWEEN num_folio_ini AND num_folio_fin ");
        }
        if (folio.getCveTcr() > 0) {
            where.append(" AND cve_tcr = ");
            where.append(folio.getCveTcr());
        }
        if (folio.getCveEntidad() > 0) {

            where.append(" AND cve_entidad = ");
            where.append(folio.getCveEntidad());
        } else if (sinCobertura) {
            where.append(" AND (cve_entidad IS NULL OR cve_entidad = 0) ");
        }
        if (folio.getCveDeleg() > 0) {
            where.append(" AND cve_deleg = ");
            where.append(folio.getCveDeleg());
        }
        if (folio.getCveUniad() > 0) {
            where.append(" AND cve_uniad = ");
            where.append(folio.getCveUniad());
        }

        if (folio.getAnio() > 0) {
            where.append(" AND anio = ");
            where.append(folio.getAnio());
        }

        count = super.getJdbcTemplate().queryForInt(CFOLIO+where);

        return count;
    }
    
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer obtenerEstatusProc(String funcion){
        Integer estatus= null;      
        estatus = super.getJdbcTemplate().queryForInt(BESTATUSPROC, new Object[]{funcion});
        return estatus;
    }
     
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<FolioClaveVO> obtenerClaveFolio(FolioVO folioVO){
        System.out.println("BFOLIOCLAVE_SELECT"+BFOLIOCLAVE_SELECT +folioVO.getFolioSolicitud()+folioVO.getCveTcr());
        List<FolioClaveVO> listaClave = (List) super.getJdbcTemplate().query(BFOLIOCLAVE_SELECT, new Object[]{folioVO.getFolioSolicitud(), folioVO.getCveTcr()}, new SerializableRowMapper(){

            public Serializable mapRow(ResultSet rs, int rowNum) throws SQLException {
                FolioClaveVO folioClaveVO = new FolioClaveVO();
                folioClaveVO.setFolio(rs.getInt(1));
                folioClaveVO.setClave(rs.getString(2));
                folioClaveVO.setAnio(rs.getInt(3));
                folioClaveVO.setTpoCred(rs.getInt(4));
                return  folioClaveVO;
            }
        });
        return listaClave;
    }
}
