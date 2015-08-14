/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BimBimWS;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author depit
 */
@Entity
@Table(name = "vterti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vterti.findAll", query = "SELECT v FROM Vterti v"),
    @NamedQuery(name = "Vterti.findBySediu", query = "SELECT v FROM Vterti v WHERE v.sediu = :sediu"),
    @NamedQuery(name = "Vterti.findByCui", query = "SELECT v FROM Vterti v WHERE v.cui = :cui"),
    @NamedQuery(name = "Vterti.findByPlt", query = "SELECT v FROM Vterti v WHERE v.plt = :plt"),
    @NamedQuery(name = "Vterti.findByDenumire", query = "SELECT v FROM Vterti v WHERE v.denumire = :denumire"),
    @NamedQuery(name = "Vterti.findByCategorieId", query = "SELECT v FROM Vterti v WHERE v.categorieId = :categorieId"),
    @NamedQuery(name = "Vterti.findByGrupaId", query = "SELECT v FROM Vterti v WHERE v.grupaId = :grupaId"),
    @NamedQuery(name = "Vterti.findByClasaId", query = "SELECT v FROM Vterti v WHERE v.clasaId = :clasaId"),
    @NamedQuery(name = "Vterti.findBySiruta", query = "SELECT v FROM Vterti v WHERE v.siruta = :siruta"),
    @NamedQuery(name = "Vterti.findByTertId", query = "SELECT v FROM Vterti v WHERE v.tertId = :tertId"),
    @NamedQuery(name = "Vterti.findBySw0", query = "SELECT v FROM Vterti v WHERE v.sw0 = :sw0"),
    @NamedQuery(name = "Vterti.findByTvai", query = "SELECT v FROM Vterti v WHERE v.tvai = :tvai"),
    @NamedQuery(name = "Vterti.findByTtipId", query = "SELECT v FROM Vterti v WHERE v.ttipId = :ttipId"),
    @NamedQuery(name = "Vterti.findByTrisc", query = "SELECT v FROM Vterti v WHERE v.trisc = :trisc"),
    @NamedQuery(name = "Vterti.findByTmodplata", query = "SELECT v FROM Vterti v WHERE v.tmodplata = :tmodplata")})
public class Vterti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "sediu")
    private String sediu;
    @Column(name = "cui")
    private String cui;
    @Column(name = "plt")
    private String plt;
    @Column(name = "denumire")
    private String denumire;
    @Column(name = "categorie_id")
    private String categorieId;
    @Column(name = "grupa_id")
    private String grupaId;
    @Column(name = "clasa_id")
    private String clasaId;
    @Column(name = "siruta")
    private Integer siruta;
    @Column(name = "tert_id")
    private String tertId;
    @Column(name = "sw_0")
    private Character sw0;
    @Column(name = "tvai")
    private Boolean tvai;
    @Column(name = "ttip_id")
    private String ttipId;
    @Column(name = "trisc")
    private Integer trisc;
    @Column(name = "tmodplata")
    private Integer tmodplata;

    public Vterti() {
    }

    public String getSediu() {
        return sediu;
    }

    public void setSediu(String sediu) {
        this.sediu = sediu;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getPlt() {
        return plt;
    }

    public void setPlt(String plt) {
        this.plt = plt;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(String categorieId) {
        this.categorieId = categorieId;
    }

    public String getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(String grupaId) {
        this.grupaId = grupaId;
    }

    public String getClasaId() {
        return clasaId;
    }

    public void setClasaId(String clasaId) {
        this.clasaId = clasaId;
    }

    public Integer getSiruta() {
        return siruta;
    }

    public void setSiruta(Integer siruta) {
        this.siruta = siruta;
    }

    public String getTertId() {
        return tertId;
    }

    public void setTertId(String tertId) {
        this.tertId = tertId;
    }

    public Character getSw0() {
        return sw0;
    }

    public void setSw0(Character sw0) {
        this.sw0 = sw0;
    }

    public Boolean getTvai() {
        return tvai;
    }

    public void setTvai(Boolean tvai) {
        this.tvai = tvai;
    }

    public String getTtipId() {
        return ttipId;
    }

    public void setTtipId(String ttipId) {
        this.ttipId = ttipId;
    }

    public Integer getTrisc() {
        return trisc;
    }

    public void setTrisc(Integer trisc) {
        this.trisc = trisc;
    }

    public Integer getTmodplata() {
        return tmodplata;
    }

    public void setTmodplata(Integer tmodplata) {
        this.tmodplata = tmodplata;
    }
    
}
