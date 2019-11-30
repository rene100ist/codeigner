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
import modelo.Pais;

/**
 *
 * @author rene.linaresusam
 */
public class PaisDao {
    Conexion conn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    public PaisDao(Conexion conn) {
        this.conn=conn;
    }
    
    public boolean insert(Pais pa){
        sql="insert into pais values(?,?,?,?)";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, pa.getId());
            ps.setString(2, pa.getNombre());
            ps.setString(3, pa.getDireccion());
            ps.setString(4, pa.getCodigo_postal());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Pais pa){
        sql="update pais set nombre=?,direccion=?,codigo_postal=? where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
             ps.setInt(4, pa.getId());
            ps.setString(1, pa.getNombre());
            ps.setString(2, pa.getDireccion());
            ps.setString(3, pa.getCodigo_postal());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean eliminar(int id){
        sql="delete from pais where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Pais> consultar(){
        sql="select * from pais";
        try {
           List<Pais> listap= new LinkedList<>();
           ps=conn.conectar().prepareStatement(sql);
           rs=ps.executeQuery();
           Pais pa;
           while(rs.next()){
             pa=new Pais(rs.getInt(1));
             pa.setNombre(rs.getString(2));
             pa.setDireccion(rs.getString(3));
             pa.setCodigo_postal(rs.getString(4));
             listap.add(pa);
           }
           return listap;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public Pais consultarId(int id){
        sql="select * from pais where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            Pais pa=null;
            
            while(rs.next()){
                pa=new Pais(rs.getInt(1));
                pa.setNombre(rs.getString(2));
                pa.setDireccion(rs.getString(3));
                pa.setCodigo_postal(rs.getString(4));
            }
            return pa;
        } catch (Exception e) {
            return null;
        }
    }
    
}
