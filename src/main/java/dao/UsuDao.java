/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author rene.linaresusam
 */
public class UsuDao {
    Conexion conn=new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public UsuDao(Conexion conn) {
        this.conn=conn;
    }
    
    public boolean insert(Usuario u){
        sql="insert into usuario values (?,?,?)";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getPass());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean login(String usuario, String pass){
        sql="select * from usuario where usuario=? and pass=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public int roles(String usuario, String pass){
        int rol=0;
        try {
            sql="select * from usuario where usuario=? and pass=?";
            ps=conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next()){
                rol=rs.getInt("idtipo");
            }
            return rol;
        } catch (Exception e) {
            return 0;
        }
    }
    
}
