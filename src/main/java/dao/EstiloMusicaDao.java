/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Estilo_musica;

/**
 *
 * @author rene.linaresusam
 */
public class EstiloMusicaDao {
    Conexion conn=new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public EstiloMusicaDao(Conexion conn) {
        this.conn=conn;
    }
    
    public boolean insert(Estilo_musica em){
        sql="insert into estilo_musica values(?,?)";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, em.getId());
            ps.setString(2, em.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Estilo_musica em){
        sql="update estilo_musica set nombre=? where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(2, em.getId());
            ps.setString(1, em.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        sql="delete from estilo_musica where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Estilo_musica> consultar(){
        sql="select * from estilo_musica";
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            List<Estilo_musica> listaem=new LinkedList<>();
            
            while(rs.next()){
                Estilo_musica em=new Estilo_musica(rs.getInt(1));
                em.setNombre(rs.getString(2));
                listaem.add(em);
            }
            return listaem;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Estilo_musica consultarId(int id){
        sql="select * from estilo_musica where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            Estilo_musica em=null;
            rs=ps.executeQuery();
            
            while(rs.next()){
                em=new Estilo_musica(rs.getInt(1));
                em.setNombre(rs.getString(2));;
            }
            return em;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
}
