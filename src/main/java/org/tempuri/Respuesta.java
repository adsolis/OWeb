
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Respuesta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Respuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cve_mes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_persona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rfc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="curp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="no_credito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_otrgm_crd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_inicl_pesos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smg_fch_credit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_inic_vsmg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sldo_base_vsmg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sldo_base_infrd_fchcrd_p" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tinteres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plazo_mxmo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prm_amrt_infr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_prmr_pgo_real" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_prmr_pgo_real" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dif_prm_pgo_infrd_real" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amrt_dif_hace_una" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuantas_supst_6qnas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equiv_meses_6qnas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_ult_pgo_real" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_ult_pgo_real" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oblg_act_pgo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amort_sar_inic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_mrcj_inicsar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_vlr_mrcj_inicsar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_ult_mrcj_subsecsar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pgo_drcto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_prm_pgo_drcto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_ult_pgo_drcto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="icp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dependencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sofol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desarrollador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notaria_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numfoliopaq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_testimonio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datos_rpp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="afil_sindic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ent_fed_grnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localidad_grnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cve_ch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conj_hab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tot_qns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qnas_pgds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qnas_no_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="no_solicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avaluo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_crd_despues_aplsar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prmr_qna_vencd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_prmr_amort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_prmr_pgo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_ult_amrt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mnto_ult_pgo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tpocrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tot_pagos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tot_sar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tot_ddi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sts_laboral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_oficina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dscrp_tpocrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_stscrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc_stscrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_convenio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dscrp_cartera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_desarrollo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="no_cubre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="procesado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fchlqd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cedida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estatus_amort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldo_cubre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldo_nocubre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fch_esperada_liq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tiene_od" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_fovissste" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_ult_subsec_sar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_organismo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="av" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emproblemado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="congruencia_30pc_vs_5pc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cej_despacho" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="erogaciones_netas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compra_cofinanciado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compra_fovban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pagos_exceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sar_exceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="demasia_faltante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testimonio_orig_en_custodio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Respuesta", propOrder = {
    "cveMes",
    "idPersona",
    "rfc",
    "curp",
    "nombre",
    "noCredito",
    "fchOtrgmCrd",
    "montoIniclPesos",
    "moneda",
    "smgFchCredit",
    "montoInicVsmg",
    "sldoBaseVsmg",
    "sldoBaseInfrdFchcrdP",
    "tinteres",
    "plazoMxmo",
    "prmAmrtInfr",
    "montoPrmrPgoReal",
    "fchPrmrPgoReal",
    "difPrmPgoInfrdReal",
    "amrtDifHaceUna",
    "cuantasSupst6Qnas",
    "equivMeses6Qnas",
    "fchUltPgoReal",
    "montoUltPgoReal",
    "oblgActPgo",
    "amortSarInic",
    "fchMrcjInicsar",
    "fchVlrMrcjInicsar",
    "fchUltMrcjSubsecsar",
    "pgoDrcto",
    "fchPrmPgoDrcto",
    "fchUltPgoDrcto",
    "icp",
    "dependencia",
    "sofol",
    "desarrollador",
    "notariaNum",
    "notario",
    "numfoliopaq",
    "fchTestimonio",
    "datosRpp",
    "afilSindic",
    "entFedGrnt",
    "localidadGrnt",
    "cveCh",
    "conjHab",
    "totQns",
    "qnasPgds",
    "qnasNoPago",
    "noSolicitud",
    "saldo",
    "avaluo",
    "montoCrdDespuesAplsar",
    "prmrQnaVencd",
    "montoPrmrAmort",
    "fchPrmrPgo",
    "fchUltAmrt",
    "mntoUltPgo",
    "tpocrd",
    "totPagos",
    "totSar",
    "totDdi",
    "stsLaboral",
    "idOficina",
    "dv",
    "dscrpTpocrd",
    "idStscrd",
    "descStscrd",
    "idConvenio",
    "dscrpCartera",
    "idDesarrollo",
    "noCubre",
    "procesado",
    "fchlqd",
    "cedida",
    "estatusAmort",
    "saldoCubre",
    "saldoNocubre",
    "fchEsperadaLiq",
    "tieneOd",
    "codFovissste",
    "montoUltSubsecSar",
    "idOrganismo",
    "av",
    "emproblemado",
    "congruencia30PcVs5Pc",
    "cejDespacho",
    "erogacionesNetas",
    "compraCofinanciado",
    "compraFovban",
    "pagosExceso",
    "sarExceso",
    "demasiaFaltante",
    "testimonioOrigEnCustodio",
    "idEstado"
})
public class Respuesta {

    @XmlElement(name = "cve_mes")
    protected String cveMes;
    @XmlElement(name = "id_persona")
    protected String idPersona;
    protected String rfc;
    protected String curp;
    protected String nombre;
    @XmlElement(name = "no_credito")
    protected String noCredito;
    @XmlElement(name = "fch_otrgm_crd")
    protected String fchOtrgmCrd;
    @XmlElement(name = "monto_inicl_pesos")
    protected String montoIniclPesos;
    protected String moneda;
    @XmlElement(name = "smg_fch_credit")
    protected String smgFchCredit;
    @XmlElement(name = "monto_inic_vsmg")
    protected String montoInicVsmg;
    @XmlElement(name = "sldo_base_vsmg")
    protected String sldoBaseVsmg;
    @XmlElement(name = "sldo_base_infrd_fchcrd_p")
    protected String sldoBaseInfrdFchcrdP;
    protected String tinteres;
    @XmlElement(name = "plazo_mxmo")
    protected String plazoMxmo;
    @XmlElement(name = "prm_amrt_infr")
    protected String prmAmrtInfr;
    @XmlElement(name = "monto_prmr_pgo_real")
    protected String montoPrmrPgoReal;
    @XmlElement(name = "fch_prmr_pgo_real")
    protected String fchPrmrPgoReal;
    @XmlElement(name = "dif_prm_pgo_infrd_real")
    protected String difPrmPgoInfrdReal;
    @XmlElement(name = "amrt_dif_hace_una")
    protected String amrtDifHaceUna;
    @XmlElement(name = "cuantas_supst_6qnas")
    protected String cuantasSupst6Qnas;
    @XmlElement(name = "equiv_meses_6qnas")
    protected String equivMeses6Qnas;
    @XmlElement(name = "fch_ult_pgo_real")
    protected String fchUltPgoReal;
    @XmlElement(name = "monto_ult_pgo_real")
    protected String montoUltPgoReal;
    @XmlElement(name = "oblg_act_pgo")
    protected String oblgActPgo;
    @XmlElement(name = "amort_sar_inic")
    protected String amortSarInic;
    @XmlElement(name = "fch_mrcj_inicsar")
    protected String fchMrcjInicsar;
    @XmlElement(name = "fch_vlr_mrcj_inicsar")
    protected String fchVlrMrcjInicsar;
    @XmlElement(name = "fch_ult_mrcj_subsecsar")
    protected String fchUltMrcjSubsecsar;
    @XmlElement(name = "pgo_drcto")
    protected String pgoDrcto;
    @XmlElement(name = "fch_prm_pgo_drcto")
    protected String fchPrmPgoDrcto;
    @XmlElement(name = "fch_ult_pgo_drcto")
    protected String fchUltPgoDrcto;
    protected String icp;
    protected String dependencia;
    protected String sofol;
    protected String desarrollador;
    @XmlElement(name = "notaria_num")
    protected String notariaNum;
    protected String notario;
    protected String numfoliopaq;
    @XmlElement(name = "fch_testimonio")
    protected String fchTestimonio;
    @XmlElement(name = "datos_rpp")
    protected String datosRpp;
    @XmlElement(name = "afil_sindic")
    protected String afilSindic;
    @XmlElement(name = "ent_fed_grnt")
    protected String entFedGrnt;
    @XmlElement(name = "localidad_grnt")
    protected String localidadGrnt;
    @XmlElement(name = "cve_ch")
    protected String cveCh;
    @XmlElement(name = "conj_hab")
    protected String conjHab;
    @XmlElement(name = "tot_qns")
    protected String totQns;
    @XmlElement(name = "qnas_pgds")
    protected String qnasPgds;
    @XmlElement(name = "qnas_no_pago")
    protected String qnasNoPago;
    @XmlElement(name = "no_solicitud")
    protected String noSolicitud;
    protected String saldo;
    protected String avaluo;
    @XmlElement(name = "monto_crd_despues_aplsar")
    protected String montoCrdDespuesAplsar;
    @XmlElement(name = "prmr_qna_vencd")
    protected String prmrQnaVencd;
    @XmlElement(name = "monto_prmr_amort")
    protected String montoPrmrAmort;
    @XmlElement(name = "fch_prmr_pgo")
    protected String fchPrmrPgo;
    @XmlElement(name = "fch_ult_amrt")
    protected String fchUltAmrt;
    @XmlElement(name = "mnto_ult_pgo")
    protected String mntoUltPgo;
    protected String tpocrd;
    @XmlElement(name = "tot_pagos")
    protected String totPagos;
    @XmlElement(name = "tot_sar")
    protected String totSar;
    @XmlElement(name = "tot_ddi")
    protected String totDdi;
    @XmlElement(name = "sts_laboral")
    protected String stsLaboral;
    @XmlElement(name = "id_oficina")
    protected String idOficina;
    protected String dv;
    @XmlElement(name = "dscrp_tpocrd")
    protected String dscrpTpocrd;
    @XmlElement(name = "id_stscrd")
    protected String idStscrd;
    @XmlElement(name = "desc_stscrd")
    protected String descStscrd;
    @XmlElement(name = "id_convenio")
    protected String idConvenio;
    @XmlElement(name = "dscrp_cartera")
    protected String dscrpCartera;
    @XmlElement(name = "id_desarrollo")
    protected String idDesarrollo;
    @XmlElement(name = "no_cubre")
    protected String noCubre;
    protected String procesado;
    protected String fchlqd;
    protected String cedida;
    @XmlElement(name = "estatus_amort")
    protected String estatusAmort;
    @XmlElement(name = "saldo_cubre")
    protected String saldoCubre;
    @XmlElement(name = "saldo_nocubre")
    protected String saldoNocubre;
    @XmlElement(name = "fch_esperada_liq")
    protected String fchEsperadaLiq;
    @XmlElement(name = "tiene_od")
    protected String tieneOd;
    @XmlElement(name = "cod_fovissste")
    protected String codFovissste;
    @XmlElement(name = "monto_ult_subsec_sar")
    protected String montoUltSubsecSar;
    @XmlElement(name = "id_organismo")
    protected String idOrganismo;
    protected String av;
    protected String emproblemado;
    @XmlElement(name = "congruencia_30pc_vs_5pc")
    protected String congruencia30PcVs5Pc;
    @XmlElement(name = "cej_despacho")
    protected String cejDespacho;
    @XmlElement(name = "erogaciones_netas")
    protected String erogacionesNetas;
    @XmlElement(name = "compra_cofinanciado")
    protected String compraCofinanciado;
    @XmlElement(name = "compra_fovban")
    protected String compraFovban;
    @XmlElement(name = "pagos_exceso")
    protected String pagosExceso;
    @XmlElement(name = "sar_exceso")
    protected String sarExceso;
    @XmlElement(name = "demasia_faltante")
    protected String demasiaFaltante;
    @XmlElement(name = "testimonio_orig_en_custodio")
    protected String testimonioOrigEnCustodio;
    @XmlElement(name = "id_estado")
    protected String idEstado;

    /**
     * Gets the value of the cveMes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveMes() {
        return cveMes;
    }

    /**
     * Sets the value of the cveMes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveMes(String value) {
        this.cveMes = value;
    }

    /**
     * Gets the value of the idPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersona() {
        return idPersona;
    }

    /**
     * Sets the value of the idPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersona(String value) {
        this.idPersona = value;
    }

    /**
     * Gets the value of the rfc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the curp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Sets the value of the curp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the noCredito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCredito() {
        return noCredito;
    }

    /**
     * Sets the value of the noCredito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCredito(String value) {
        this.noCredito = value;
    }

    /**
     * Gets the value of the fchOtrgmCrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchOtrgmCrd() {
        return fchOtrgmCrd;
    }

    /**
     * Sets the value of the fchOtrgmCrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchOtrgmCrd(String value) {
        this.fchOtrgmCrd = value;
    }

    /**
     * Gets the value of the montoIniclPesos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoIniclPesos() {
        return montoIniclPesos;
    }

    /**
     * Sets the value of the montoIniclPesos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoIniclPesos(String value) {
        this.montoIniclPesos = value;
    }

    /**
     * Gets the value of the moneda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Sets the value of the moneda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneda(String value) {
        this.moneda = value;
    }

    /**
     * Gets the value of the smgFchCredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmgFchCredit() {
        return smgFchCredit;
    }

    /**
     * Sets the value of the smgFchCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmgFchCredit(String value) {
        this.smgFchCredit = value;
    }

    /**
     * Gets the value of the montoInicVsmg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoInicVsmg() {
        return montoInicVsmg;
    }

    /**
     * Sets the value of the montoInicVsmg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoInicVsmg(String value) {
        this.montoInicVsmg = value;
    }

    /**
     * Gets the value of the sldoBaseVsmg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSldoBaseVsmg() {
        return sldoBaseVsmg;
    }

    /**
     * Sets the value of the sldoBaseVsmg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSldoBaseVsmg(String value) {
        this.sldoBaseVsmg = value;
    }

    /**
     * Gets the value of the sldoBaseInfrdFchcrdP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSldoBaseInfrdFchcrdP() {
        return sldoBaseInfrdFchcrdP;
    }

    /**
     * Sets the value of the sldoBaseInfrdFchcrdP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSldoBaseInfrdFchcrdP(String value) {
        this.sldoBaseInfrdFchcrdP = value;
    }

    /**
     * Gets the value of the tinteres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTinteres() {
        return tinteres;
    }

    /**
     * Sets the value of the tinteres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTinteres(String value) {
        this.tinteres = value;
    }

    /**
     * Gets the value of the plazoMxmo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazoMxmo() {
        return plazoMxmo;
    }

    /**
     * Sets the value of the plazoMxmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazoMxmo(String value) {
        this.plazoMxmo = value;
    }

    /**
     * Gets the value of the prmAmrtInfr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmAmrtInfr() {
        return prmAmrtInfr;
    }

    /**
     * Sets the value of the prmAmrtInfr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmAmrtInfr(String value) {
        this.prmAmrtInfr = value;
    }

    /**
     * Gets the value of the montoPrmrPgoReal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoPrmrPgoReal() {
        return montoPrmrPgoReal;
    }

    /**
     * Sets the value of the montoPrmrPgoReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoPrmrPgoReal(String value) {
        this.montoPrmrPgoReal = value;
    }

    /**
     * Gets the value of the fchPrmrPgoReal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchPrmrPgoReal() {
        return fchPrmrPgoReal;
    }

    /**
     * Sets the value of the fchPrmrPgoReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchPrmrPgoReal(String value) {
        this.fchPrmrPgoReal = value;
    }

    /**
     * Gets the value of the difPrmPgoInfrdReal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDifPrmPgoInfrdReal() {
        return difPrmPgoInfrdReal;
    }

    /**
     * Sets the value of the difPrmPgoInfrdReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDifPrmPgoInfrdReal(String value) {
        this.difPrmPgoInfrdReal = value;
    }

    /**
     * Gets the value of the amrtDifHaceUna property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmrtDifHaceUna() {
        return amrtDifHaceUna;
    }

    /**
     * Sets the value of the amrtDifHaceUna property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmrtDifHaceUna(String value) {
        this.amrtDifHaceUna = value;
    }

    /**
     * Gets the value of the cuantasSupst6Qnas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuantasSupst6Qnas() {
        return cuantasSupst6Qnas;
    }

    /**
     * Sets the value of the cuantasSupst6Qnas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuantasSupst6Qnas(String value) {
        this.cuantasSupst6Qnas = value;
    }

    /**
     * Gets the value of the equivMeses6Qnas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquivMeses6Qnas() {
        return equivMeses6Qnas;
    }

    /**
     * Sets the value of the equivMeses6Qnas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquivMeses6Qnas(String value) {
        this.equivMeses6Qnas = value;
    }

    /**
     * Gets the value of the fchUltPgoReal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchUltPgoReal() {
        return fchUltPgoReal;
    }

    /**
     * Sets the value of the fchUltPgoReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchUltPgoReal(String value) {
        this.fchUltPgoReal = value;
    }

    /**
     * Gets the value of the montoUltPgoReal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoUltPgoReal() {
        return montoUltPgoReal;
    }

    /**
     * Sets the value of the montoUltPgoReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoUltPgoReal(String value) {
        this.montoUltPgoReal = value;
    }

    /**
     * Gets the value of the oblgActPgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOblgActPgo() {
        return oblgActPgo;
    }

    /**
     * Sets the value of the oblgActPgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOblgActPgo(String value) {
        this.oblgActPgo = value;
    }

    /**
     * Gets the value of the amortSarInic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmortSarInic() {
        return amortSarInic;
    }

    /**
     * Sets the value of the amortSarInic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmortSarInic(String value) {
        this.amortSarInic = value;
    }

    /**
     * Gets the value of the fchMrcjInicsar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchMrcjInicsar() {
        return fchMrcjInicsar;
    }

    /**
     * Sets the value of the fchMrcjInicsar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchMrcjInicsar(String value) {
        this.fchMrcjInicsar = value;
    }

    /**
     * Gets the value of the fchVlrMrcjInicsar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchVlrMrcjInicsar() {
        return fchVlrMrcjInicsar;
    }

    /**
     * Sets the value of the fchVlrMrcjInicsar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchVlrMrcjInicsar(String value) {
        this.fchVlrMrcjInicsar = value;
    }

    /**
     * Gets the value of the fchUltMrcjSubsecsar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchUltMrcjSubsecsar() {
        return fchUltMrcjSubsecsar;
    }

    /**
     * Sets the value of the fchUltMrcjSubsecsar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchUltMrcjSubsecsar(String value) {
        this.fchUltMrcjSubsecsar = value;
    }

    /**
     * Gets the value of the pgoDrcto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPgoDrcto() {
        return pgoDrcto;
    }

    /**
     * Sets the value of the pgoDrcto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPgoDrcto(String value) {
        this.pgoDrcto = value;
    }

    /**
     * Gets the value of the fchPrmPgoDrcto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchPrmPgoDrcto() {
        return fchPrmPgoDrcto;
    }

    /**
     * Sets the value of the fchPrmPgoDrcto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchPrmPgoDrcto(String value) {
        this.fchPrmPgoDrcto = value;
    }

    /**
     * Gets the value of the fchUltPgoDrcto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchUltPgoDrcto() {
        return fchUltPgoDrcto;
    }

    /**
     * Sets the value of the fchUltPgoDrcto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchUltPgoDrcto(String value) {
        this.fchUltPgoDrcto = value;
    }

    /**
     * Gets the value of the icp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcp() {
        return icp;
    }

    /**
     * Sets the value of the icp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcp(String value) {
        this.icp = value;
    }

    /**
     * Gets the value of the dependencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependencia() {
        return dependencia;
    }

    /**
     * Sets the value of the dependencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependencia(String value) {
        this.dependencia = value;
    }

    /**
     * Gets the value of the sofol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSofol() {
        return sofol;
    }

    /**
     * Sets the value of the sofol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSofol(String value) {
        this.sofol = value;
    }

    /**
     * Gets the value of the desarrollador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesarrollador() {
        return desarrollador;
    }

    /**
     * Sets the value of the desarrollador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesarrollador(String value) {
        this.desarrollador = value;
    }

    /**
     * Gets the value of the notariaNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotariaNum() {
        return notariaNum;
    }

    /**
     * Sets the value of the notariaNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotariaNum(String value) {
        this.notariaNum = value;
    }

    /**
     * Gets the value of the notario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotario() {
        return notario;
    }

    /**
     * Sets the value of the notario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotario(String value) {
        this.notario = value;
    }

    /**
     * Gets the value of the numfoliopaq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumfoliopaq() {
        return numfoliopaq;
    }

    /**
     * Sets the value of the numfoliopaq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumfoliopaq(String value) {
        this.numfoliopaq = value;
    }

    /**
     * Gets the value of the fchTestimonio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchTestimonio() {
        return fchTestimonio;
    }

    /**
     * Sets the value of the fchTestimonio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchTestimonio(String value) {
        this.fchTestimonio = value;
    }

    /**
     * Gets the value of the datosRpp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatosRpp() {
        return datosRpp;
    }

    /**
     * Sets the value of the datosRpp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatosRpp(String value) {
        this.datosRpp = value;
    }

    /**
     * Gets the value of the afilSindic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfilSindic() {
        return afilSindic;
    }

    /**
     * Sets the value of the afilSindic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfilSindic(String value) {
        this.afilSindic = value;
    }

    /**
     * Gets the value of the entFedGrnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntFedGrnt() {
        return entFedGrnt;
    }

    /**
     * Sets the value of the entFedGrnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntFedGrnt(String value) {
        this.entFedGrnt = value;
    }

    /**
     * Gets the value of the localidadGrnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalidadGrnt() {
        return localidadGrnt;
    }

    /**
     * Sets the value of the localidadGrnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalidadGrnt(String value) {
        this.localidadGrnt = value;
    }

    /**
     * Gets the value of the cveCh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCveCh() {
        return cveCh;
    }

    /**
     * Sets the value of the cveCh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCveCh(String value) {
        this.cveCh = value;
    }

    /**
     * Gets the value of the conjHab property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConjHab() {
        return conjHab;
    }

    /**
     * Sets the value of the conjHab property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConjHab(String value) {
        this.conjHab = value;
    }

    /**
     * Gets the value of the totQns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotQns() {
        return totQns;
    }

    /**
     * Sets the value of the totQns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotQns(String value) {
        this.totQns = value;
    }

    /**
     * Gets the value of the qnasPgds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQnasPgds() {
        return qnasPgds;
    }

    /**
     * Sets the value of the qnasPgds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQnasPgds(String value) {
        this.qnasPgds = value;
    }

    /**
     * Gets the value of the qnasNoPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQnasNoPago() {
        return qnasNoPago;
    }

    /**
     * Sets the value of the qnasNoPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQnasNoPago(String value) {
        this.qnasNoPago = value;
    }

    /**
     * Gets the value of the noSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoSolicitud() {
        return noSolicitud;
    }

    /**
     * Sets the value of the noSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoSolicitud(String value) {
        this.noSolicitud = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldo(String value) {
        this.saldo = value;
    }

    /**
     * Gets the value of the avaluo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvaluo() {
        return avaluo;
    }

    /**
     * Sets the value of the avaluo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvaluo(String value) {
        this.avaluo = value;
    }

    /**
     * Gets the value of the montoCrdDespuesAplsar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoCrdDespuesAplsar() {
        return montoCrdDespuesAplsar;
    }

    /**
     * Sets the value of the montoCrdDespuesAplsar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoCrdDespuesAplsar(String value) {
        this.montoCrdDespuesAplsar = value;
    }

    /**
     * Gets the value of the prmrQnaVencd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmrQnaVencd() {
        return prmrQnaVencd;
    }

    /**
     * Sets the value of the prmrQnaVencd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmrQnaVencd(String value) {
        this.prmrQnaVencd = value;
    }

    /**
     * Gets the value of the montoPrmrAmort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoPrmrAmort() {
        return montoPrmrAmort;
    }

    /**
     * Sets the value of the montoPrmrAmort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoPrmrAmort(String value) {
        this.montoPrmrAmort = value;
    }

    /**
     * Gets the value of the fchPrmrPgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchPrmrPgo() {
        return fchPrmrPgo;
    }

    /**
     * Sets the value of the fchPrmrPgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchPrmrPgo(String value) {
        this.fchPrmrPgo = value;
    }

    /**
     * Gets the value of the fchUltAmrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchUltAmrt() {
        return fchUltAmrt;
    }

    /**
     * Sets the value of the fchUltAmrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchUltAmrt(String value) {
        this.fchUltAmrt = value;
    }

    /**
     * Gets the value of the mntoUltPgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMntoUltPgo() {
        return mntoUltPgo;
    }

    /**
     * Sets the value of the mntoUltPgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMntoUltPgo(String value) {
        this.mntoUltPgo = value;
    }

    /**
     * Gets the value of the tpocrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpocrd() {
        return tpocrd;
    }

    /**
     * Sets the value of the tpocrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpocrd(String value) {
        this.tpocrd = value;
    }

    /**
     * Gets the value of the totPagos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotPagos() {
        return totPagos;
    }

    /**
     * Sets the value of the totPagos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotPagos(String value) {
        this.totPagos = value;
    }

    /**
     * Gets the value of the totSar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotSar() {
        return totSar;
    }

    /**
     * Sets the value of the totSar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotSar(String value) {
        this.totSar = value;
    }

    /**
     * Gets the value of the totDdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotDdi() {
        return totDdi;
    }

    /**
     * Sets the value of the totDdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotDdi(String value) {
        this.totDdi = value;
    }

    /**
     * Gets the value of the stsLaboral property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStsLaboral() {
        return stsLaboral;
    }

    /**
     * Sets the value of the stsLaboral property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStsLaboral(String value) {
        this.stsLaboral = value;
    }

    /**
     * Gets the value of the idOficina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOficina() {
        return idOficina;
    }

    /**
     * Sets the value of the idOficina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOficina(String value) {
        this.idOficina = value;
    }

    /**
     * Gets the value of the dv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDv() {
        return dv;
    }

    /**
     * Sets the value of the dv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDv(String value) {
        this.dv = value;
    }

    /**
     * Gets the value of the dscrpTpocrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscrpTpocrd() {
        return dscrpTpocrd;
    }

    /**
     * Sets the value of the dscrpTpocrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscrpTpocrd(String value) {
        this.dscrpTpocrd = value;
    }

    /**
     * Gets the value of the idStscrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdStscrd() {
        return idStscrd;
    }

    /**
     * Sets the value of the idStscrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdStscrd(String value) {
        this.idStscrd = value;
    }

    /**
     * Gets the value of the descStscrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStscrd() {
        return descStscrd;
    }

    /**
     * Sets the value of the descStscrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStscrd(String value) {
        this.descStscrd = value;
    }

    /**
     * Gets the value of the idConvenio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConvenio() {
        return idConvenio;
    }

    /**
     * Sets the value of the idConvenio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConvenio(String value) {
        this.idConvenio = value;
    }

    /**
     * Gets the value of the dscrpCartera property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscrpCartera() {
        return dscrpCartera;
    }

    /**
     * Sets the value of the dscrpCartera property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscrpCartera(String value) {
        this.dscrpCartera = value;
    }

    /**
     * Gets the value of the idDesarrollo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDesarrollo() {
        return idDesarrollo;
    }

    /**
     * Sets the value of the idDesarrollo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDesarrollo(String value) {
        this.idDesarrollo = value;
    }

    /**
     * Gets the value of the noCubre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCubre() {
        return noCubre;
    }

    /**
     * Sets the value of the noCubre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCubre(String value) {
        this.noCubre = value;
    }

    /**
     * Gets the value of the procesado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcesado() {
        return procesado;
    }

    /**
     * Sets the value of the procesado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcesado(String value) {
        this.procesado = value;
    }

    /**
     * Gets the value of the fchlqd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchlqd() {
        return fchlqd;
    }

    /**
     * Sets the value of the fchlqd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchlqd(String value) {
        this.fchlqd = value;
    }

    /**
     * Gets the value of the cedida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCedida() {
        return cedida;
    }

    /**
     * Sets the value of the cedida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCedida(String value) {
        this.cedida = value;
    }

    /**
     * Gets the value of the estatusAmort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusAmort() {
        return estatusAmort;
    }

    /**
     * Sets the value of the estatusAmort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusAmort(String value) {
        this.estatusAmort = value;
    }

    /**
     * Gets the value of the saldoCubre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoCubre() {
        return saldoCubre;
    }

    /**
     * Sets the value of the saldoCubre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoCubre(String value) {
        this.saldoCubre = value;
    }

    /**
     * Gets the value of the saldoNocubre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoNocubre() {
        return saldoNocubre;
    }

    /**
     * Sets the value of the saldoNocubre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoNocubre(String value) {
        this.saldoNocubre = value;
    }

    /**
     * Gets the value of the fchEsperadaLiq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchEsperadaLiq() {
        return fchEsperadaLiq;
    }

    /**
     * Sets the value of the fchEsperadaLiq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchEsperadaLiq(String value) {
        this.fchEsperadaLiq = value;
    }

    /**
     * Gets the value of the tieneOd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTieneOd() {
        return tieneOd;
    }

    /**
     * Sets the value of the tieneOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTieneOd(String value) {
        this.tieneOd = value;
    }

    /**
     * Gets the value of the codFovissste property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFovissste() {
        return codFovissste;
    }

    /**
     * Sets the value of the codFovissste property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFovissste(String value) {
        this.codFovissste = value;
    }

    /**
     * Gets the value of the montoUltSubsecSar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoUltSubsecSar() {
        return montoUltSubsecSar;
    }

    /**
     * Sets the value of the montoUltSubsecSar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoUltSubsecSar(String value) {
        this.montoUltSubsecSar = value;
    }

    /**
     * Gets the value of the idOrganismo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOrganismo() {
        return idOrganismo;
    }

    /**
     * Sets the value of the idOrganismo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOrganismo(String value) {
        this.idOrganismo = value;
    }

    /**
     * Gets the value of the av property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAv() {
        return av;
    }

    /**
     * Sets the value of the av property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAv(String value) {
        this.av = value;
    }

    /**
     * Gets the value of the emproblemado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmproblemado() {
        return emproblemado;
    }

    /**
     * Sets the value of the emproblemado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmproblemado(String value) {
        this.emproblemado = value;
    }

    /**
     * Gets the value of the congruencia30PcVs5Pc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCongruencia30PcVs5Pc() {
        return congruencia30PcVs5Pc;
    }

    /**
     * Sets the value of the congruencia30PcVs5Pc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCongruencia30PcVs5Pc(String value) {
        this.congruencia30PcVs5Pc = value;
    }

    /**
     * Gets the value of the cejDespacho property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCejDespacho() {
        return cejDespacho;
    }

    /**
     * Sets the value of the cejDespacho property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCejDespacho(String value) {
        this.cejDespacho = value;
    }

    /**
     * Gets the value of the erogacionesNetas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErogacionesNetas() {
        return erogacionesNetas;
    }

    /**
     * Sets the value of the erogacionesNetas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErogacionesNetas(String value) {
        this.erogacionesNetas = value;
    }

    /**
     * Gets the value of the compraCofinanciado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompraCofinanciado() {
        return compraCofinanciado;
    }

    /**
     * Sets the value of the compraCofinanciado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompraCofinanciado(String value) {
        this.compraCofinanciado = value;
    }

    /**
     * Gets the value of the compraFovban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompraFovban() {
        return compraFovban;
    }

    /**
     * Sets the value of the compraFovban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompraFovban(String value) {
        this.compraFovban = value;
    }

    /**
     * Gets the value of the pagosExceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagosExceso() {
        return pagosExceso;
    }

    /**
     * Sets the value of the pagosExceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagosExceso(String value) {
        this.pagosExceso = value;
    }

    /**
     * Gets the value of the sarExceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSarExceso() {
        return sarExceso;
    }

    /**
     * Sets the value of the sarExceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSarExceso(String value) {
        this.sarExceso = value;
    }

    /**
     * Gets the value of the demasiaFaltante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDemasiaFaltante() {
        return demasiaFaltante;
    }

    /**
     * Sets the value of the demasiaFaltante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDemasiaFaltante(String value) {
        this.demasiaFaltante = value;
    }

    /**
     * Gets the value of the testimonioOrigEnCustodio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestimonioOrigEnCustodio() {
        return testimonioOrigEnCustodio;
    }

    /**
     * Sets the value of the testimonioOrigEnCustodio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestimonioOrigEnCustodio(String value) {
        this.testimonioOrigEnCustodio = value;
    }

    /**
     * Gets the value of the idEstado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEstado() {
        return idEstado;
    }

    /**
     * Sets the value of the idEstado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEstado(String value) {
        this.idEstado = value;
    }

}
