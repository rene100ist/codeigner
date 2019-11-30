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
public class Cd_individual {
    private int isbn,cod_tienda;
    private String nombre_cd;
     private double pvp;
    //foranea
   private int artista, cd_coleccion;

    public Cd_individual(int isbn) {
        this.isbn = isbn;
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

    public String getNombre_cd() {
        return nombre_cd;
    }

    public void setNombre_cd(String nombre_cd) {
        this.nombre_cd = nombre_cd;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }

    public int getCd_coleccion() {
        return cd_coleccion;
    }

    public void setCd_coleccion(int cd_coleccion) {
        this.cd_coleccion = cd_coleccion;
    }
   
   
}
