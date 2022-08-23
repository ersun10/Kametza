/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.DriverManager;

/**
 *
 * @author luisj
 */
public class Conexion {

    private java.lang.String url, db, userDb, passwd;
    private java.lang.String driver;
    private java.sql.Connection con;

    public Conexion() {
        url = "jdbc:sqlite:Database/database.db";
        driver = "org.sqlite.JDBC";
    }

    public java.sql.Connection ObtenerConexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            if (con == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

   
}
