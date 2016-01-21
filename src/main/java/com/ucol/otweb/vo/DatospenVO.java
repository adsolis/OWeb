/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 */
public class DatospenVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer num_pen;
private String u_version;
private String rfc_pen;
private String curp;
private Integer num_issste;
private String nombre;
private String paterno;
private String materno;
private String nombre_h;
private String ind_nomb;
private int sexo;
private int tip_pen_act;
private int tip_pen_org;
private int tip_pago;
private String ent_pago;
private String zon_pago;
private int ent_pen;
private Integer primer_ramo;
private Date primera_fecha;
private Integer ult_ramo;
private Date ult_fecha;
private Double sueldo_reg;
private Double porcentaje;
private Double imp_ori_pendi;
private Double imp_ori_pende;
private Date fecha_inidi;
private Date fecha_inide;
private String tiempo_serv_trab;
private int num_deudo;
private int grupo_familiar;
private int vigencia;
private Date fecha_vigencia;
private Date alta_nomina;
private Double importe_pen;
private int radicacion_exp;
private Integer num_cheque;
private Double total_percep;
private Double total_deduc;
private Double liquido;
private String nombre_cheque;
private int meses_cotizados;
private int meses_nocotizados;
private int meses_pagados;
private String plazas;
private String ind_at_dir;
private String cta_at_dir;
private int revalorizacion;
private Date fecha_reval;
private String spe_id;
private Double ptg_aumen;
private Double cuota_ant;
private Integer ramo1;
private String clave1;
private String nivel1;
private Double ptje1;
private String estatus1;
private Integer ramo2;
private String clave2;
private String nivel2;
private Double ptje2;
private String estatus2;
private Integer ramo3;
private String clave3;
private String nivel3;
private Double ptje3;
private String estatus3;
private Integer ramo4;
private String clave4;
private String nivel4;
private Double ptje4;
private String estatus4;
private Integer ramo5;
private String clave5;
private String nivel5;
private Double ptje5;
private String estatus5;

    /**
     * @return the num_pen
     */
    public Integer getNum_pen() {
        return num_pen;
    }

    /**
     * @param num_pen the num_pen to set
     */
    public void setNum_pen(Integer num_pen) {
        this.num_pen = num_pen;
    }

    /**
     * @return the u_version
     */
    public String getU_version() {
        return u_version;
    }

    /**
     * @param u_version the u_version to set
     */
    public void setU_version(String u_version) {
        this.u_version = u_version;
    }

    /**
     * @return the rfc_pen
     */
    public String getRfc_pen() {
        return rfc_pen;
    }

    /**
     * @param rfc_pen the rfc_pen to set
     */
    public void setRfc_pen(String rfc_pen) {
        this.rfc_pen = rfc_pen;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the num_issste
     */
    public Integer getNum_issste() {
        return num_issste;
    }

    /**
     * @param num_issste the num_issste to set
     */
    public void setNum_issste(Integer num_issste) {
        this.num_issste = num_issste;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the paterno
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * @param paterno the paterno to set
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     * @return the materno
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * @param materno the materno to set
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * @return the nombre_h
     */
    public String getNombre_h() {
        return nombre_h;
    }

    /**
     * @param nombre_h the nombre_h to set
     */
    public void setNombre_h(String nombre_h) {
        this.nombre_h = nombre_h;
    }

    /**
     * @return the ind_nomb
     */
    public String getInd_nomb() {
        return ind_nomb;
    }

    /**
     * @param ind_nomb the ind_nomb to set
     */
    public void setInd_nomb(String ind_nomb) {
        this.ind_nomb = ind_nomb;
    }

    /**
     * @return the sexo
     */
    public int getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the tip_pen_act
     */
    public int getTip_pen_act() {
        return tip_pen_act;
    }

    /**
     * @param tip_pen_act the tip_pen_act to set
     */
    public void setTip_pen_act(int tip_pen_act) {
        this.tip_pen_act = tip_pen_act;
    }

    /**
     * @return the tip_pen_org
     */
    public int getTip_pen_org() {
        return tip_pen_org;
    }

    /**
     * @param tip_pen_org the tip_pen_org to set
     */
    public void setTip_pen_org(int tip_pen_org) {
        this.tip_pen_org = tip_pen_org;
    }

    /**
     * @return the tip_pago
     */
    public int getTip_pago() {
        return tip_pago;
    }

    /**
     * @param tip_pago the tip_pago to set
     */
    public void setTip_pago(int tip_pago) {
        this.tip_pago = tip_pago;
    }

    /**
     * @return the ent_pago
     */
    public String getEnt_pago() {
        return ent_pago;
    }

    /**
     * @param ent_pago the ent_pago to set
     */
    public void setEnt_pago(String ent_pago) {
        this.ent_pago = ent_pago;
    }

    /**
     * @return the zon_pago
     */
    public String getZon_pago() {
        return zon_pago;
    }

    /**
     * @param zon_pago the zon_pago to set
     */
    public void setZon_pago(String zon_pago) {
        this.zon_pago = zon_pago;
    }

    /**
     * @return the ent_pen
     */
    public int getEnt_pen() {
        return ent_pen;
    }

    /**
     * @param ent_pen the ent_pen to set
     */
    public void setEnt_pen(int ent_pen) {
        this.ent_pen = ent_pen;
    }

    /**
     * @return the primer_ramo
     */
    public Integer getPrimer_ramo() {
        return primer_ramo;
    }

    /**
     * @param primer_ramo the primer_ramo to set
     */
    public void setPrimer_ramo(Integer primer_ramo) {
        this.primer_ramo = primer_ramo;
    }

    /**
     * @return the primera_fecha
     */
    public Date getPrimera_fecha() {
        return primera_fecha;
    }

    /**
     * @param primera_fecha the primera_fecha to set
     */
    public void setPrimera_fecha(Date primera_fecha) {
        this.primera_fecha = primera_fecha;
    }

    /**
     * @return the ult_ramo
     */
    public Integer getUlt_ramo() {
        return ult_ramo;
    }

    /**
     * @param ult_ramo the ult_ramo to set
     */
    public void setUlt_ramo(Integer ult_ramo) {
        this.ult_ramo = ult_ramo;
    }

    /**
     * @return the ult_fecha
     */
    public Date getUlt_fecha() {
        return ult_fecha;
    }

    /**
     * @param ult_fecha the ult_fecha to set
     */
    public void setUlt_fecha(Date ult_fecha) {
        this.ult_fecha = ult_fecha;
    }

    /**
     * @return the sueldo_reg
     */
    public Double getSueldo_reg() {
        return sueldo_reg;
    }

    /**
     * @param sueldo_reg the sueldo_reg to set
     */
    public void setSueldo_reg(Double sueldo_reg) {
        this.sueldo_reg = sueldo_reg;
    }

    /**
     * @return the porcentaje
     */
    public Double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the imp_ori_pendi
     */
    public Double getImp_ori_pendi() {
        return imp_ori_pendi;
    }

    /**
     * @param imp_ori_pendi the imp_ori_pendi to set
     */
    public void setImp_ori_pendi(Double imp_ori_pendi) {
        this.imp_ori_pendi = imp_ori_pendi;
    }

    /**
     * @return the imp_ori_pende
     */
    public Double getImp_ori_pende() {
        return imp_ori_pende;
    }

    /**
     * @param imp_ori_pende the imp_ori_pende to set
     */
    public void setImp_ori_pende(Double imp_ori_pende) {
        this.imp_ori_pende = imp_ori_pende;
    }

    /**
     * @return the fecha_inidi
     */
    public Date getFecha_inidi() {
        return fecha_inidi;
    }

    /**
     * @param fecha_inidi the fecha_inidi to set
     */
    public void setFecha_inidi(Date fecha_inidi) {
        this.fecha_inidi = fecha_inidi;
    }

    /**
     * @return the fecha_inide
     */
    public Date getFecha_inide() {
        return fecha_inide;
    }

    /**
     * @param fecha_inide the fecha_inide to set
     */
    public void setFecha_inide(Date fecha_inide) {
        this.fecha_inide = fecha_inide;
    }

    /**
     * @return the tiempo_serv_trab
     */
    public String getTiempo_serv_trab() {
        return tiempo_serv_trab;
    }

    /**
     * @param tiempo_serv_trab the tiempo_serv_trab to set
     */
    public void setTiempo_serv_trab(String tiempo_serv_trab) {
        this.tiempo_serv_trab = tiempo_serv_trab;
    }

    /**
     * @return the num_deudo
     */
    public int getNum_deudo() {
        return num_deudo;
    }

    /**
     * @param num_deudo the num_deudo to set
     */
    public void setNum_deudo(int num_deudo) {
        this.num_deudo = num_deudo;
    }

    /**
     * @return the grupo_familiar
     */
    public int getGrupo_familiar() {
        return grupo_familiar;
    }

    /**
     * @param grupo_familiar the grupo_familiar to set
     */
    public void setGrupo_familiar(int grupo_familiar) {
        this.grupo_familiar = grupo_familiar;
    }

    /**
     * @return the vigencia
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * @return the fecha_vigencia
     */
    public Date getFecha_vigencia() {
        return fecha_vigencia;
    }

    /**
     * @param fecha_vigencia the fecha_vigencia to set
     */
    public void setFecha_vigencia(Date fecha_vigencia) {
        this.fecha_vigencia = fecha_vigencia;
    }

    /**
     * @return the alta_nomina
     */
    public Date getAlta_nomina() {
        return alta_nomina;
    }

    /**
     * @param alta_nomina the alta_nomina to set
     */
    public void setAlta_nomina(Date alta_nomina) {
        this.alta_nomina = alta_nomina;
    }

    /**
     * @return the importe_pen
     */
    public Double getImporte_pen() {
        return importe_pen;
    }

    /**
     * @param importe_pen the importe_pen to set
     */
    public void setImporte_pen(Double importe_pen) {
        this.importe_pen = importe_pen;
    }

    /**
     * @return the radicacion_exp
     */
    public int getRadicacion_exp() {
        return radicacion_exp;
    }

    /**
     * @param radicacion_exp the radicacion_exp to set
     */
    public void setRadicacion_exp(int radicacion_exp) {
        this.radicacion_exp = radicacion_exp;
    }

    /**
     * @return the num_cheque
     */
    public Integer getNum_cheque() {
        return num_cheque;
    }

    /**
     * @param num_cheque the num_cheque to set
     */
    public void setNum_cheque(Integer num_cheque) {
        this.num_cheque = num_cheque;
    }

    /**
     * @return the total_percep
     */
    public Double getTotal_percep() {
        return total_percep;
    }

    /**
     * @param total_percep the total_percep to set
     */
    public void setTotal_percep(Double total_percep) {
        this.total_percep = total_percep;
    }

    /**
     * @return the total_deduc
     */
    public Double getTotal_deduc() {
        return total_deduc;
    }

    /**
     * @param total_deduc the total_deduc to set
     */
    public void setTotal_deduc(Double total_deduc) {
        this.total_deduc = total_deduc;
    }

    /**
     * @return the liquido
     */
    public Double getLiquido() {
        return liquido;
    }

    /**
     * @param liquido the liquido to set
     */
    public void setLiquido(Double liquido) {
        this.liquido = liquido;
    }

    /**
     * @return the nombre_cheque
     */
    public String getNombre_cheque() {
        return nombre_cheque;
    }

    /**
     * @param nombre_cheque the nombre_cheque to set
     */
    public void setNombre_cheque(String nombre_cheque) {
        this.nombre_cheque = nombre_cheque;
    }

    /**
     * @return the meses_cotizados
     */
    public int getMeses_cotizados() {
        return meses_cotizados;
    }

    /**
     * @param meses_cotizados the meses_cotizados to set
     */
    public void setMeses_cotizados(int meses_cotizados) {
        this.meses_cotizados = meses_cotizados;
    }

    /**
     * @return the meses_nocotizados
     */
    public int getMeses_nocotizados() {
        return meses_nocotizados;
    }

    /**
     * @param meses_nocotizados the meses_nocotizados to set
     */
    public void setMeses_nocotizados(int meses_nocotizados) {
        this.meses_nocotizados = meses_nocotizados;
    }

    /**
     * @return the meses_pagados
     */
    public int getMeses_pagados() {
        return meses_pagados;
    }

    /**
     * @param meses_pagados the meses_pagados to set
     */
    public void setMeses_pagados(int meses_pagados) {
        this.meses_pagados = meses_pagados;
    }

    /**
     * @return the plazas
     */
    public String getPlazas() {
        return plazas;
    }

    /**
     * @param plazas the plazas to set
     */
    public void setPlazas(String plazas) {
        this.plazas = plazas;
    }

    /**
     * @return the ind_at_dir
     */
    public String getInd_at_dir() {
        return ind_at_dir;
    }

    /**
     * @param ind_at_dir the ind_at_dir to set
     */
    public void setInd_at_dir(String ind_at_dir) {
        this.ind_at_dir = ind_at_dir;
    }

    /**
     * @return the cta_at_dir
     */
    public String getCta_at_dir() {
        return cta_at_dir;
    }

    /**
     * @param cta_at_dir the cta_at_dir to set
     */
    public void setCta_at_dir(String cta_at_dir) {
        this.cta_at_dir = cta_at_dir;
    }

    /**
     * @return the revalorizacion
     */
    public int getRevalorizacion() {
        return revalorizacion;
    }

    /**
     * @param revalorizacion the revalorizacion to set
     */
    public void setRevalorizacion(int revalorizacion) {
        this.revalorizacion = revalorizacion;
    }

    /**
     * @return the fecha_reval
     */
    public Date getFecha_reval() {
        return fecha_reval;
    }

    /**
     * @param fecha_reval the fecha_reval to set
     */
    public void setFecha_reval(Date fecha_reval) {
        this.fecha_reval = fecha_reval;
    }

    /**
     * @return the spe_id
     */
    public String getSpe_id() {
        return spe_id;
    }

    /**
     * @param spe_id the spe_id to set
     */
    public void setSpe_id(String spe_id) {
        this.spe_id = spe_id;
    }

    /**
     * @return the ptg_aumen
     */
    public Double getPtg_aumen() {
        return ptg_aumen;
    }

    /**
     * @param ptg_aumen the ptg_aumen to set
     */
    public void setPtg_aumen(Double ptg_aumen) {
        this.ptg_aumen = ptg_aumen;
    }

    /**
     * @return the cuota_ant
     */
    public Double getCuota_ant() {
        return cuota_ant;
    }

    /**
     * @param cuota_ant the cuota_ant to set
     */
    public void setCuota_ant(Double cuota_ant) {
        this.cuota_ant = cuota_ant;
    }

    /**
     * @return the ramo1
     */
    public Integer getRamo1() {
        return ramo1;
    }

    /**
     * @param ramo1 the ramo1 to set
     */
    public void setRamo1(Integer ramo1) {
        this.ramo1 = ramo1;
    }

    /**
     * @return the clave1
     */
    public String getClave1() {
        return clave1;
    }

    /**
     * @param clave1 the clave1 to set
     */
    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    /**
     * @return the nivel1
     */
    public String getNivel1() {
        return nivel1;
    }

    /**
     * @param nivel1 the nivel1 to set
     */
    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    /**
     * @return the ptje1
     */
    public Double getPtje1() {
        return ptje1;
    }

    /**
     * @param ptje1 the ptje1 to set
     */
    public void setPtje1(Double ptje1) {
        this.ptje1 = ptje1;
    }

    /**
     * @return the estatus1
     */
    public String getEstatus1() {
        return estatus1;
    }

    /**
     * @param estatus1 the estatus1 to set
     */
    public void setEstatus1(String estatus1) {
        this.estatus1 = estatus1;
    }

    /**
     * @return the ramo2
     */
    public Integer getRamo2() {
        return ramo2;
    }

    /**
     * @param ramo2 the ramo2 to set
     */
    public void setRamo2(Integer ramo2) {
        this.ramo2 = ramo2;
    }

    /**
     * @return the clave2
     */
    public String getClave2() {
        return clave2;
    }

    /**
     * @param clave2 the clave2 to set
     */
    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    /**
     * @return the nivel2
     */
    public String getNivel2() {
        return nivel2;
    }

    /**
     * @param nivel2 the nivel2 to set
     */
    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    /**
     * @return the ptje2
     */
    public Double getPtje2() {
        return ptje2;
    }

    /**
     * @param ptje2 the ptje2 to set
     */
    public void setPtje2(Double ptje2) {
        this.ptje2 = ptje2;
    }

    /**
     * @return the estatus2
     */
    public String getEstatus2() {
        return estatus2;
    }

    /**
     * @param estatus2 the estatus2 to set
     */
    public void setEstatus2(String estatus2) {
        this.estatus2 = estatus2;
    }

    /**
     * @return the ramo3
     */
    public Integer getRamo3() {
        return ramo3;
    }

    /**
     * @param ramo3 the ramo3 to set
     */
    public void setRamo3(Integer ramo3) {
        this.ramo3 = ramo3;
    }

    /**
     * @return the clave3
     */
    public String getClave3() {
        return clave3;
    }

    /**
     * @param clave3 the clave3 to set
     */
    public void setClave3(String clave3) {
        this.clave3 = clave3;
    }

    /**
     * @return the nivel3
     */
    public String getNivel3() {
        return nivel3;
    }

    /**
     * @param nivel3 the nivel3 to set
     */
    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    /**
     * @return the ptje3
     */
    public Double getPtje3() {
        return ptje3;
    }

    /**
     * @param ptje3 the ptje3 to set
     */
    public void setPtje3(Double ptje3) {
        this.ptje3 = ptje3;
    }

    /**
     * @return the estatus3
     */
    public String getEstatus3() {
        return estatus3;
    }

    /**
     * @param estatus3 the estatus3 to set
     */
    public void setEstatus3(String estatus3) {
        this.estatus3 = estatus3;
    }

    /**
     * @return the ramo4
     */
    public Integer getRamo4() {
        return ramo4;
    }

    /**
     * @param ramo4 the ramo4 to set
     */
    public void setRamo4(Integer ramo4) {
        this.ramo4 = ramo4;
    }

    /**
     * @return the clave4
     */
    public String getClave4() {
        return clave4;
    }

    /**
     * @param clave4 the clave4 to set
     */
    public void setClave4(String clave4) {
        this.clave4 = clave4;
    }

    /**
     * @return the nivel4
     */
    public String getNivel4() {
        return nivel4;
    }

    /**
     * @param nivel4 the nivel4 to set
     */
    public void setNivel4(String nivel4) {
        this.nivel4 = nivel4;
    }

    /**
     * @return the ptje4
     */
    public Double getPtje4() {
        return ptje4;
    }

    /**
     * @param ptje4 the ptje4 to set
     */
    public void setPtje4(Double ptje4) {
        this.ptje4 = ptje4;
    }

    /**
     * @return the estatus4
     */
    public String getEstatus4() {
        return estatus4;
    }

    /**
     * @param estatus4 the estatus4 to set
     */
    public void setEstatus4(String estatus4) {
        this.estatus4 = estatus4;
    }

    /**
     * @return the ramo5
     */
    public Integer getRamo5() {
        return ramo5;
    }

    /**
     * @param ramo5 the ramo5 to set
     */
    public void setRamo5(Integer ramo5) {
        this.ramo5 = ramo5;
    }

    /**
     * @return the clave5
     */
    public String getClave5() {
        return clave5;
    }

    /**
     * @param clave5 the clave5 to set
     */
    public void setClave5(String clave5) {
        this.clave5 = clave5;
    }

    /**
     * @return the nivel5
     */
    public String getNivel5() {
        return nivel5;
    }

    /**
     * @param nivel5 the nivel5 to set
     */
    public void setNivel5(String nivel5) {
        this.nivel5 = nivel5;
    }

    /**
     * @return the ptje5
     */
    public Double getPtje5() {
        return ptje5;
    }

    /**
     * @param ptje5 the ptje5 to set
     */
    public void setPtje5(Double ptje5) {
        this.ptje5 = ptje5;
    }

    /**
     * @return the estatus5
     */
    public String getEstatus5() {
        return estatus5;
    }

    /**
     * @param estatus5 the estatus5 to set
     */
    public void setEstatus5(String estatus5) {
        this.estatus5 = estatus5;
    }
    

}
