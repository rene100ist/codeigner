/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rene.linaresusam
 */
public class Cd_Coleccion {
    private int id,cod_tienda;
    private String nombre_col;
    private double pvpC;
    //foranea
    private int promotor, grupo;
    private String nombrePromo,nombGrupo;

    public Cd_Coleccion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_tienda() {
        return cod_tienda;
    }

    public void setCod_tienda(int cod_tienda) {
        this.cod_tienda = cod_tienda;
    }

    public String getNombre_col() {
        return nombre_col;
    }

    public void setNombre_col(String nombre_col) {
        this.nombre_col = nombre_col;
    }

    public double getPvpC() {
        return pvpC;
    }

    public void setPvpC(double pvpC) {
        this.pvpC = pvpC;
    }

    public int getPromotor() {
        return promotor;
    }

    public void setPromotor(int promotor) {
        this.promotor = promotor;
    }

    public String getNombrePromo() {
        return nombrePromo;
    }

    public void setNombrePromo(String nombrePromo) {
        this.nombrePromo = nombrePromo;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getNombGrupo() {
        return nombGrupo;
    }

    public void setNombGrupo(String nombGrupo) {
        this.nombGrupo = nombGrupo;
    }

   
    
    
    
}
