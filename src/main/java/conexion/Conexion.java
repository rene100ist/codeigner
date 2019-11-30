/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rene.linaresusam
 */
public class Conexion {
    private String bd="tiendaMusica";
    private String user="root";
    private String pass="root";
    private String url="jdbc:mysql://localhost/"+bd+"?useSSL=false";
    
    Connection conn;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,pass);
            System.out.println("EXITO CONECTADO");
        } catch (Exception e) {
            System.out.println("ERROR DE CONEXION: "+e);
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws SQLException{
        conn.close();
    }
    
    
}
