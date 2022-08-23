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
public class NotasDAO {

    private final Controlador.Conexion conexion;
    private final Modelo.notas notas;

    private java.sql.Connection con;
    private java.sql.Statement st;
    private java.sql.ResultSet rs;
    private java.util.ArrayList<javax.swing.JTextArea> arrayNotas;

    // Instancias
    Controlador.ClientesDAO clientes = new Controlador.ClientesDAO();

    public NotasDAO() {
        conexion = new Controlador.Conexion();
        notas = new Modelo.notas();
        arrayNotas = new java.util.ArrayList<javax.swing.JTextArea>();
    }

    public java.util.ArrayList<javax.swing.JTextArea> notasClientes() {
        //arrayNotas = null;
        arrayNotas.clear();
        String consulta = "SELECT * FROM Notas";

        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    arrayNotas.add(new Modelo.notas(rs.getInt("idNota"), rs.getString("fechaNota"), rs.getInt("idCliente"), rs.getString("nota")));
                }
            }

        } catch (Exception ex) {
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
        return arrayNotas;
    }
    
     public java.util.ArrayList<javax.swing.JTextArea> notasClientesEspecifico(int idcliente) {
        //arrayNotas = null;
        arrayNotas.clear();
        String consulta = "SELECT * FROM Notas WHERE idCliente = " + idcliente;

        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    arrayNotas.add(new Modelo.notas(rs.getInt("idNota"), rs.getString("fechaNota"), rs.getInt("idCliente"), rs.getString("nota")));
                }
            }

        } catch (Exception ex) {
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
        return arrayNotas;
    }

    public void eliminarNota(int idnota) {
        String consulta = "DELETE FROM Notas WHERE idNota = " + idnota;

        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            st.execute(consulta);
        } catch (Exception ex) {
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

    }

    public void insertarNota(String dnicliente, String textonota) {
        int idClienteParaNota = clientes.obtenerIdCliente(dnicliente);
        java.time.LocalDateTime locaDate = java.time.LocalDateTime.now();
        int dia = locaDate.getDayOfMonth();
        int mes = locaDate.getMonthValue();
        int year = locaDate.getYear();
        String fechaOperacion;
        String diafinal;
        if(dia < 10){
           diafinal = "0" + dia; 
        } else {
           diafinal = "" + dia;
        }
        if (mes < 10) {
            fechaOperacion = year + "-" + "0" + mes + "-" + diafinal;  
         } else {
            fechaOperacion = year + "-" + mes + "-" + diafinal;  
        }

        String consulta = "INSERT INTO Notas VALUES (NULL, " + idClienteParaNota + ", '" + textonota + "', '" + fechaOperacion + "')";

        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            st.execute(consulta);
        } catch (Exception ex) {
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

    }
    
    public void eliminarNotasDelCliente(int idcliente) {
        String consulta = "DELETE FROM Notas WHERE idCliente = " + idcliente;

        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            st.execute(consulta);
        } catch (Exception ex) {
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

    }

}
