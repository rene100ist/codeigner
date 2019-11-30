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
public class Artistas {
    private int id, pais, estilo_musical;
    private String nombre, nombrePais, nombreEMusica,grupo;

    public Artistas(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public int getEstilo_musical() {
        return estilo_musical;
    }

    public void setEstilo_musical(int estilo_musical) {
        this.estilo_musical = estilo_musical;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreEMusica() {
        return nombreEMusica;
    }

    public void setNombreEMusica(String nombreEMusica) {
        this.nombreEMusica = nombreEMusica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    
    
}
