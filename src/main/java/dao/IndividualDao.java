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

/**
 *
 * @author rene.linaresusam
 */
public class IndividualDao {

    Conexion conn = new Conexion();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    public IndividualDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Cd_individual cdi) {
        sql = "insert into cd_individual values(?,?,?,?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cdi.getId());
            ps.setString(2, cdi.getNombre_cd());
            ps.setInt(3, cdi.getCod_tienda());
            ps.setDouble(4, cdi.getPvp());
            ps.setInt(5, cdi.getArtista());
            ps.setInt(6, cdi.getPista());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Cd_individual cdi) {
        sql = "update cd_individual set nombre_cd=?,cod_tienda=?,pvp=?,artista=?,pista=? where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, cdi.getNombre_cd());
            ps.setInt(2, cdi.getCod_tienda());
            ps.setDouble(3, cdi.getPvp());
            ps.setInt(4, cdi.getArtista());
            ps.setInt(5, cdi.getPista());
            ps.setInt(6, cdi.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminar(int id) {
        sql = "delete from cd_individual where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Cd_individual> consultar() {
        sql = "select cdi.*, ar.nombre, pi.nombre, pi.duracion\n"
                + "from cd_individual cdi\n"
                + "inner join artistas ar on cdi.artista=ar.id\n"
                + "inner join pistas pi on cdi.pista=pi.id";
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            List<Cd_individual> listacindi = new LinkedList<>();
            Cd_individual cdi;
            while (rs.next()) {
                cdi = new Cd_individual(rs.getInt(1));
                cdi.setNombre_cd(rs.getString(2));
                cdi.setCod_tienda(rs.getInt(3));
                cdi.setPvp(rs.getDouble(4));
                cdi.setNombArtista(rs.getString(7));
                cdi.setNombPista(rs.getString(8));
                cdi.settDuracion(rs.getString(9));
                listacindi.add(cdi);
            }
            return listacindi;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Cd_individual consultarId(int id) {
        sql = "select cdi.*, ar.nombre, pi.nombre, pi.duracion\n"
                + "from cd_individual cdi\n"
                + "inner join artistas ar on cdi.artista=ar.id\n"
                + "inner join pistas pi on cdi.pista=pi.id where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Cd_individual cdi = null;

            while (rs.next()) {
                cdi = new Cd_individual(rs.getInt(1));
                cdi.setNombre_cd(rs.getString(2));
                cdi.setCod_tienda(rs.getInt(3));
                cdi.setPvp(rs.getDouble(4));
                cdi.setNombArtista(rs.getString(7));
                cdi.setNombPista(rs.getString(8));
                cdi.settDuracion(rs.getString(9));
            }
            return cdi;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /*
    //este metodo sera solo para que me muestre SOLO las canciones de album seleccionado
    public List<Cd_individual> consultarIdPistas(int id) {
        sql = "select cdi.*, ar.nombre, pi.nombre, pi.duracion\n"
                + "from cd_individual cdi\n"
                + "inner join artistas ar on cdi.artista=ar.id\n"
                + "inner join pistas pi on cdi.pista=pi.id where cdi.id = ?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            List<Cd_individual> listaCP = new LinkedList<>();
            Cd_individual cdi;
            while (rs.next()) {
                cdi = new Cd_individual(rs.getInt(1));
                cdi.setNombre_cd(rs.getString(2));
                cdi.setNombArtista(rs.getString(7));
                cdi.setNombPista(rs.getString(8));
                cdi.settDuracion(rs.getString(9));
                listaCP.add(cdi);
            }
            return listaCP;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    */
    

}
