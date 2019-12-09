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
import modelo.Cd_individual;
import modelo.Pistas;

/**
 *
 * @author rene.linaresusam
 */
public class PistasDao {

    Conexion conn = new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public PistasDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Pistas pi) {
        
        sql = "insert into pistas values(?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pi.getId());
            ps.setString(2, pi.getNombre());
            ps.setString(3, pi.getDuracion().toString());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminar(int id){
        sql="delete from pistas where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<Pistas> consultar(){
        sql="select * from pistas";
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            List<Pistas> listap=new LinkedList<>();
            
            while(rs.next()){
                Pistas pi=new Pistas(rs.getInt(1));
                pi.setNombre(rs.getString(2));
                pi.setDuracion(rs.getTime(3).toLocalTime());
                listap.add(pi);
            }
            return listap;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public Pistas consultarId(int id) {
        sql = "select * from pistas where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Pistas pi = null;

            while (rs.next()) {
                pi = new Pistas(rs.getInt(1));
                pi.setNombre(rs.getString(2));
                pi.setDuracion(rs.getTime(3).toLocalTime());
            }
            return pi;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public boolean update(Pistas pi){
        sql="update pistas set nombre=?, duracion=? where id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setString(1, pi.getNombre());
            ps.setString(2, pi.getDuracion().toString());
            ps.setInt(3, pi.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    
}
