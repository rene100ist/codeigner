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
    private int id,cod_tienda;
    private String nombre_cd;
     private double pvp;
    //foranea
   private int artista, pista;
   //inner join
   private String nombArtista, nombPista, tDuracion;

    public Cd_individual(int id) {
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

    public String getNombArtista() {
        return nombArtista;
    }

    public void setNombArtista(String nombArtista) {
        this.nombArtista = nombArtista;
    }

    public int getPista() {
        return pista;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }

    public String getNombPista() {
        return nombPista;
    }

    public void setNombPista(String nombPista) {
        this.nombPista = nombPista;
    }

    public String gettDuracion() {
        return tDuracion;
    }

    public void settDuracion(String tDuracion) {
        this.tDuracion = tDuracion;
    }

   
}
