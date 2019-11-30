/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.Artistas;

/**
 *
 * @author rene.linaresusam
 */
public class ArtistaGrupoDao {
    Conexion conn=new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public ArtistaGrupoDao(Conexion conn) {
        this.conn=conn;
    }
    
    public List<Artistas> consultarGrupo(){
        sql="";
    }
}
