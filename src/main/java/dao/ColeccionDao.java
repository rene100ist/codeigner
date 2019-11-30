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
import modelo.Cd_Coleccion;

/**
 *
 * @author rene.linaresusam
 */
public class ColeccionDao {

    Conexion conn = new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public ColeccionDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Cd_Coleccion cdo) {
        sql = "insert into cd_coleccion values (?,?,?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cdo.getIsbn());
            ps.setString(2, cdo.getNombre_col());
            ps.setInt(3, cdo.getCod_tienda());
            ps.setDouble(4, cdo.getPvpC());
            ps.setInt(5, cdo.getPromotor());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Cd_Coleccion cdo) {
        sql = "update cd_coleccion set nombre_col=?, cod_tienda=?, pvpC=?, promotor=? where isbn=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cdo.getIsbn());
            ps.setString(2, cdo.getNombre_col());
            ps.setInt(3, cdo.getCod_tienda());
            ps.setDouble(4, cdo.getPvpC());
            ps.setInt(5, cdo.getPromotor());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int isbn) {
        sql = "delete from cd_coleccion where isbn=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, isbn);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Cd_Coleccion> consultar() {
        sql = "select cd.*, c.nombre\n"
                + "from compania c\n"
                + "inner join cd_coleccion cd on c.id=cd.promotor";
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            List<Cd_Coleccion> listacdo=new LinkedList<>();
            Cd_Coleccion cdo;
            
            while(rs.next()){
                cdo= new Cd_Coleccion(rs.getInt(1));
                cdo.setNombre_col(rs.getString(2));
                cdo.setCod_tienda(rs.getInt(3));
                cdo.setPvpC(rs.getDouble(4));
                cdo.setNombrePromo(rs.getString(6));
                listacdo.add(cdo);
            }
            return listacdo;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public Cd_Coleccion consultarId(int isbn){
        sql= "select cd.*, c.nombre\n"
               + "from compania c\n"
                + "inner join cd_coleccion cd on c.id=cd.promotor where cd.isbn=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, isbn);
            rs=ps.executeQuery();
            Cd_Coleccion cdo=null;
            
            while(rs.next()){
                cdo= new Cd_Coleccion(rs.getInt(1));
                cdo.setNombre_col(rs.getString(2));
                cdo.setCod_tienda(rs.getInt(3));
                cdo.setPvpC(rs.getDouble(4));
                cdo.setNombrePromo(rs.getString(6));
            }
            return cdo;
        } catch (Exception e) {
            return null;
        }
    }

}
