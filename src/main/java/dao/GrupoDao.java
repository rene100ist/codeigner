package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Grupo;

public class GrupoDao {

    Conexion conn = new Conexion();
    PreparedStatement ps;
    String sql;
    ResultSet rs;

    public GrupoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Grupo g) {
        sql = "insert into grupo values (?,?,?)";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, g.getId());
            ps.setString(2, g.getNombre());
            ps.setInt(3, g.getArtista());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Grupo g) {
        sql = "update grupo set nombre=?, artista=? where id=?";
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, g.getNombre());
            ps.setInt(2, g.getArtista());
            ps.setInt(3, g.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminar(int id) {
        sql = "delete from grupo where id=?";
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

    public List<Grupo> consultar() {
        sql = "select g.*, ar.nombre\n"
                + "from grupo g\n"
                + "inner join artistas ar on g.artista=ar.id";
        try {
            ps=conn.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            List<Grupo> listag=new LinkedList<>();
            
            while(rs.next()){
                Grupo g=new Grupo(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setNombArtista(rs.getString(4));
                listag.add(g);
            }
            return listag;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Grupo consultarId(int id) {
        sql = "select g.*, ar.nombre\n"
                + "from grupo g\n"
                + "inner join artistas ar on g.artista=ar.id where g.id=?";
        try {
            ps=conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            Grupo g= null;
            
            while(rs.next()){
                g=new Grupo(rs.getInt(1));
                g.setNombre(rs.getString(2));
                g.setNombArtista(rs.getString(4));
            }
            return g;
        }catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
