/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luisj
 */
public class OperacionesDAO {

    private java.sql.Connection con;
    private java.sql.Statement st;
    private java.sql.ResultSet rs;
    private final Controlador.Conexion conexion;
    private final Controlador.ClientesDAO operacionesCliente;

    private java.lang.String consulta = "";

    public OperacionesDAO() {
        conexion = new Controlador.Conexion();
        operacionesCliente = new Controlador.ClientesDAO();
    }

    public javax.swing.table.DefaultTableModel obtenerOperaciones(javax.swing.table.TableModel modeloTabla) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;
        String cabeceras[] = {"ID Operación", "Cliente", "Gestión", "Fecha", "Estado", "Observaciones"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conexion.ObtenerConexion();
            consulta = "SELECT * FROM Operaciones, Clientes WHERE Clientes.IDCliente = Operaciones.IDCliente ORDER BY Operaciones.IDOperacion DESC";
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDOperacion"), rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"), rs.getString("operacionRealizada"), rs.getString("fechaDeOperacion"),
                        rs.getString("estadoOperacion"), rs.getString("observacionesOperacion")});

                }
            } else {
                System.out.println("Sin datos");
            }
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
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.getStackTrace();
        }

        return modelo;
    }

    public void guardarOperacion(String dniCliente, String pago, String operacionRealizada, String estadoOperacion, Double importeOperacion, String observaciones) {

        int idCliente = operacionesCliente.obtenerIdCliente(dniCliente);

        java.time.LocalDateTime locaDate = java.time.LocalDateTime.now();
        int dia = locaDate.getDayOfMonth();
        int mes = locaDate.getMonthValue();
        int year = locaDate.getYear();
        String fechaOperacion;
        String diafinal;
        if (dia < 10) {
            diafinal = "0" + dia;
        } else {
            diafinal = "" + dia;
        }
        if (mes < 10) {
            fechaOperacion = year + "-" + "0" + mes + "-" + diafinal;
        } else {
            fechaOperacion = year + "-" + mes + "-" + diafinal;
        }

        String consulta = "INSERT INTO Operaciones VALUES (NULL, " + idCliente + ", '" + dniCliente + "', '" + pago + "', '" + operacionRealizada + "', '" + fechaOperacion + "', '" + estadoOperacion
                + "', " + importeOperacion + ", '" + observaciones + "')";

        try {

            con = conexion.ObtenerConexion();
            st = con.createStatement();
            st.execute(consulta);
            javax.swing.JOptionPane.showMessageDialog(null, "Operación guardada con éxito.", "Operación realizada", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Fallo al guardar la operación.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public java.util.Vector ultimaOperación(int idCliente) {
        java.util.Vector ultimaoperacion = new java.util.Vector<String>();

        String consulta = "SELECT * FROM Operaciones WHERE IDCliente = " + idCliente + " ORDER BY IDOperacion DESC";

        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                ultimaoperacion.add(rs.getString("operacionRealizada"));
                ultimaoperacion.add(rs.getString("metodoPago"));
                ultimaoperacion.add(rs.getString("fechaDeOperacion"));
                ultimaoperacion.add(rs.getString("estadoOperacion"));
                ultimaoperacion.add(rs.getDouble("importeOperacion"));
                ultimaoperacion.add(rs.getString("observacionesOperacion"));

            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ninguna operación registrada para este cliente.", "Sin datos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
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
        return ultimaoperacion;
    }

    public javax.swing.table.DefaultTableModel exportarAllOperaciones(javax.swing.table.TableModel modeloTabla) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;
        String consulta = "SELECT * FROM Operaciones";
        String[] cabeceras = {"ID Operación", "ID Cliente", "DNI Cliente", "Método de pago", "Operación realizada", "Fecha de la operación", "Estado",
            "Importe", "Observaciones"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDOperacion"), rs.getInt("IDCliente"), rs.getString("dniCliente"), rs.getString("metodoPago"),
                        rs.getString("operacionRealizada"), rs.getString("fechaDeOperacion"), rs.getString("estadoOperacion"), rs.getDouble("importeOperacion"),
                        rs.getString("observacionesOperacion")});
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            rs.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return modelo;
    }

    public void eliminarOperacion(int idoperacion) {
        String consulta = "DELETE FROM Operaciones WHERE IDOperacion = " + idoperacion;

        try {
            con = conexion.ObtenerConexion();
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

    public javax.swing.table.DefaultTableModel obtenerOperacionesDeCliente(javax.swing.table.TableModel modeloTabla, int idCliente) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;
        String cabeceras[] = {"ID Operación", "Cliente", "Gestión", "Fecha", "Estado", "Observaciones"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conexion.ObtenerConexion();
            consulta = "SELECT * FROM Operaciones, Clientes WHERE Operaciones.IDCliente = " + idCliente + " AND Clientes.IDCliente = Operaciones.IDCliente ORDER BY Operaciones.IDOperacion DESC";
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDOperacion"), rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"), rs.getString("operacionRealizada"), rs.getString("fechaDeOperacion"),
                        rs.getString("estadoOperacion"), rs.getString("observacionesOperacion")});

                }
            } else {
                System.out.println("Sin datos");
            }
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
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.getStackTrace();
        }

        return modelo;
    }

    public void actualizarEstado(String estado, int idoperacion) {
        String consulta = "UPDATE Operaciones SET estadoOperacion='" + estado + "' WHERE IDOperacion = " + idoperacion;
        try {
            con = conexion.ObtenerConexion();
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

    public javax.swing.table.DefaultTableModel obtenerOperacionesTotalesPorFecha(javax.swing.table.TableModel modeloTabla, String fecha) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;

        String cabeceras[] = {"ID Operación", "Cliente", "Gestión", "Fecha", "Estado", "Observaciones"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conexion.ObtenerConexion();
            consulta = "SELECT * FROM Operaciones, Clientes WHERE Operaciones.fechaDeOperacion LIKE '%" + fecha + "%' AND Clientes.IDCliente = Operaciones.IDCliente ORDER BY Operaciones.IDOperacion DESC";
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDOperacion"), rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"), rs.getString("operacionRealizada"), rs.getString("fechaDeOperacion"),
                        rs.getString("estadoOperacion"), rs.getString("observacionesOperacion")});

                }
            } else {
                System.out.println("Sin datos");
            }
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
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.getStackTrace();
        }

        return modelo;
    }

    public javax.swing.table.DefaultTableModel obtenerOperacionesDeClientePorFecha(javax.swing.table.TableModel modeloTabla, String fecha, int idcliente) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;

        String cabeceras[] = {"ID Operación", "Cliente", "Gestión", "Fecha", "Estado", "Observaciones"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conexion.ObtenerConexion();
            consulta = "SELECT * FROM Operaciones, Clientes WHERE Operaciones.IDCliente = " + idcliente + " AND Operaciones.fechaDeOperacion LIKE '%" + fecha + "%' AND Clientes.IDCliente = Operaciones.IDCliente ORDER BY Operaciones.IDOperacion DESC";
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDOperacion"), rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"), rs.getString("operacionRealizada"), rs.getString("fechaDeOperacion"),
                        rs.getString("estadoOperacion"), rs.getString("observacionesOperacion")});

                }
            } else {
                System.out.println("Sin datos");
            }
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
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.getStackTrace();
        }

        return modelo;
    }

    public void eliminarOperacionesDelCliente(int idcliente) {
        String consulta = "DELETE FROM Operaciones WHERE IDCliente = " + idcliente;

        try {
            con = conexion.ObtenerConexion();
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

    public java.util.Vector obtenerDetallesOperacion(int idoperacion) {
        java.util.Vector vectorDatos = new java.util.Vector<>();

        String consulta = "SELECT * FROM Operaciones, Clientes WHERE IDOperacion = " + idoperacion + " AND Clientes.IDCliente = Operaciones.IDCliente";
        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    vectorDatos.add(rs.getInt("IDOperacion"));
                    vectorDatos.add(rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"));
                    vectorDatos.add(rs.getString("dniCliente"));
                    vectorDatos.add(rs.getString("metodoPago"));
                    vectorDatos.add(rs.getString("operacionRealizada"));
                    vectorDatos.add(rs.getString("fechaDeOperacion"));
                    vectorDatos.add(rs.getString("estadoOperacion"));
                    vectorDatos.add(rs.getDouble("importeOperacion"));
                    vectorDatos.add(rs.getString("observacionesOperacion"));
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

        return vectorDatos;
    }

    public int operacionesdelcliente(int idcliente) {
        int operacionestotales = 0;
        String consulta = "SELECT * FROM Operaciones";
        try {
            con = conexion.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs != null) {
                while (rs.next()) {
                    operacionestotales++;
                }
            }

        } catch (java.sql.SQLException ex) {
            ex.getStackTrace();
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
        return operacionestotales;
    }

}
