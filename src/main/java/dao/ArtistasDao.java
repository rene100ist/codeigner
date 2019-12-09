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
import modelo.Artistas;

/**
 *
 * @author rene.linaresusam
 */
public class ArtistasDao {

    Conexion conn = new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public ArtistasDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Artistas ar) {
        sql = "insert into artistas values(?,?,?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ar.getId());
            ps.setString(2, ar.getNombre());
            ps.setString(3, ar.getGrupo());
            ps.setInt(4, ar.getPais());
            ps.setInt(5, ar.getEstilo_musical());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Artistas ar) {
        sql = "update artistas set nombre=?, grupo=?, pais=?, estilo_musical=? where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(5, ar.getId());
              ps.setString(1, ar.getNombre());
            ps.setString(2, ar.getGrupo());
            ps.setInt(3, ar.getPais());
            ps.setInt(4, ar.getEstilo_musical());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        sql = "delete from artistas where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Artistas> consultar() {
        sql = "select ar.*, p.nombre, em.nombre\n"
                + "from artistas as ar\n"
                + "inner join pais p on ar.pais=p.id\n"
                + "inner join estilo_musica em on ar.estilo_musical=em.id";
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            List<Artistas> listar = new LinkedList<>();

            while (rs.next()) {
                Artistas ar = new Artistas(rs.getInt(1));
                ar.setNombre(rs.getString(2));
                ar.setGrupo(rs.getString(3));
                ar.setNombrePais(rs.getString(6));
                ar.setNombreEMusica(rs.getString(7));
                listar.add(ar);
            }
            return listar;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Artistas consultarId(int id){
         sql = "select ar.*, p.nombre, em.nombre\n"
                + "from artistas as ar\n"
                + "inner join pais p on ar.pais=p.id\n"
                + "inner join estilo_musica em on ar.estilo_musical=em.id where ar.id=?";
         try {
             ps = conn.conectar().prepareStatement(sql);
             ps.setInt(1, id);
            rs = ps.executeQuery();
            Artistas ar=null;
            
            while (rs.next()) {
                ar = new Artistas(rs.getInt(1));
                ar.setNombre(rs.getString(2));
                ar.setGrupo(rs.getString(3));
                ar.setNombrePais(rs.getString(6));
                ar.setNombreEMusica(rs.getString(7));
            }
            return ar;
        } catch (Exception e) {
            return null;
        }
    }
    
   

}
