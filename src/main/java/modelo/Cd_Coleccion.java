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
    private int isbn,cod_tienda,id;
    private String nombre_col;
    private double pvpC;
    //foranea
    private int promotor;
    private String nombrePromo;

    public Cd_Coleccion(int isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePromo() {
        return nombrePromo;
    }

    public void setNombrePromo(String nombrePromo) {
        this.nombrePromo = nombrePromo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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
}
