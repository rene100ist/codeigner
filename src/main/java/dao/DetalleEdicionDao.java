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
import modelo.DetalleEdicion;

/**
 *
 * @author rene.linaresusam
 */
public class DetalleEdicionDao {

    Conexion conn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public DetalleEdicionDao(Conexion conn) {
        this.conn = conn;
    }

    public List<DetalleEdicion> consultar() {
        sql = "select de.*,c.nombre as newComp, oldc.nombre as oldComp from detalle_edicion as de \n"
                + "left join compania as c on de.newComp=c.id \n"
                + "left join compania as oldc on de.oldComp=oldc.id";
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            List<DetalleEdicion> listade = new LinkedList<>();

            while (rs.next()) {
                DetalleEdicion de = new DetalleEdicion(rs.getInt(1));
                de.setFecha(rs.getString(2));
                de.setNewComp(rs.getString(7));
                de.setOldComp(rs.getString(8));
                de.setColeccion(rs.getString(5));
                de.setOldColeccion(rs.getString(6));
                listade.add(de);
            }
            return listade;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
