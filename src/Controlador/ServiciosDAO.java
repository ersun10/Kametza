/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author luisj
 */
public class ServiciosDAO {

    private final Controlador.Conexion conection;

    private java.sql.Connection con;
    private java.sql.Statement st;
    private java.sql.ResultSet rs;

    public ServiciosDAO() {

        conection = new Controlador.Conexion();

    }

    public java.util.Vector<String> obtenerServicios() {

        java.util.Vector<String> servicios = new java.util.Vector<String>();
        String consulta = "SELECT nombreServicio FROM Servicios";

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs != null) {
                while (rs.next()) {
                    servicios.add(rs.getString("nombreServicio"));
                }
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }

        return servicios;
    }

    public boolean insertarDatos(String nombre, double importe) {

        String consulta = "INSERT INTO Servicios VALUES ( NULL, '" + nombre + "', " + importe + ")";

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            st.execute(consulta);
            return true;

        } catch (Exception ex) {
            if (ex.getMessage().startsWith("[SQLITE_CONSTRAINT_UNIQUE]")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Servicio ya registrado.", "Duplicado", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        }

        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (java.sql.SQLException ex) {
        }

        return false;
    }

    public void borrarServicio(String nombre) {

        String consulta = "DELETE FROM Servicios WHERE nombreServicio = '" + nombre + "'";

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            st.execute(consulta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String obtenerImporte(String nombre) {
        String consulta = "SELECT importeServicio FROM Servicios WHERE nombreServicio = '" + nombre + "'";
        String importe = "";

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs != null) {
                while (rs.next()) {
                    importe = (String)rs.getString("importeServicio");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }

        return importe;
    }

}
