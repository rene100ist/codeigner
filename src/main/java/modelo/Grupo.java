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
public class Grupo {
    private int id;
    private String nombre;
    //foranea
    private int artista;
    //inner join
    private String nombArtista;

    public Grupo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    
    
    
}
