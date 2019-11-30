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
import modelo.Compania;

/**
 *
 * @author rene.linaresusam
 */
public class CompaniaDao {

    Conexion conn = new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public CompaniaDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Compania co) {
        sql = "insert into compania values(?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, co.getId());
            ps.setString(2, co.getNombre());
            ps.setInt(3, co.getPais());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Compania co) {
        sql = "update compania set nombre=?, pais=? where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(3, co.getId());
            ps.setString(1, co.getNombre());
            ps.setInt(2, co.getPais());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        sql = "delete from compania where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Compania> consultar() {
        sql = "select co.*, p.nombre from compania as co\n"
                + "inner join pais p on co.pais=p.id";
        try {
            ps = conn.conectar().prepareStatement(sql);
            Compania co;
            List<Compania> listaco=new LinkedList<>();
            rs=ps.executeQuery();
            
            while(rs.next()){
                co=new Compania(rs.getInt(1));
                co.setNombre(rs.getString(2));
                co.setNombrePais(rs.getString(4));
                listaco.add(co);
            }
            return listaco;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Compania consultarId(int id){
         sql = "select co.*, p.nombre from compania as co\n"
                + "inner join pais p on co.pais=p.id where co.id=?";
         try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            Compania co=null;
            
            while(rs.next()){
                co=new Compania(rs.getInt(1));
                co.setNombre(rs.getString(2));
                co.setNombrePais(rs.getString(4));
            }
            return co;
        } catch (Exception e) {
            return null;
        }
    }

}
