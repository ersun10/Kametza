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
public class ClientesDAO {

    private final Conexion conection = new Conexion();
    private String consulta;
    private java.sql.Connection con;
    private java.sql.Statement st;
    private java.sql.PreparedStatement ps;
    private java.sql.ResultSet rs;
   
    public void insertarDatos(String nombre, String primerapellido, String segundoapellido, String genero, String fecha, String tipoDoc, String numeroDoc,
            String dir, String numero, String bloque, String escalera, String piso, String letra, String poblacion, String codpostal, String pais, String empresa,
            long telefono, long segundotelefono, long fax, long movil, String email, String razonSocial, String observaciones) {
        consulta = "INSERT INTO Clientes VALUES (NULL, ?, ?, ?, ?, ?, ?, ?,"
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = conection.ObtenerConexion();
            ps = con.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, primerapellido);
            ps.setString(3, segundoapellido);
            ps.setString(4, genero);
            ps.setString(5, fecha);
            ps.setString(6, tipoDoc);
            ps.setString(7, numeroDoc);
            ps.setString(8, dir);
            ps.setString(9, numero);
            ps.setString(10, bloque);
            ps.setString(11, escalera);
            ps.setString(12, piso);
            ps.setString(13, letra);
            ps.setString(14, poblacion);
            ps.setString(15, codpostal);
            ps.setString(16, pais);
            ps.setString(17, empresa);
            ps.setLong(18, telefono);
            ps.setLong(19, segundotelefono);
            ps.setLong(20, fax);
            ps.setLong(21, movil);
            ps.setString(22, email);
            ps.setString(23, razonSocial);
            ps.setString(24, observaciones);
            ps.execute();
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensaje = "";
            if (ex.getMessage().startsWith("Duplicate entry")) {
                mensaje = "DNI ya registrado";
                javax.swing.JOptionPane.showMessageDialog(null, "El DNI ya ha sido registrado en la base de datos", "DNI duplicado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            }

        }

        try {
            ps.clearParameters();
            ps.close();
            con.close();
        } catch (java.sql.SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public javax.swing.table.DefaultTableModel recuperarClientes(javax.swing.table.TableModel modeloTabla) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;
        String consulta = "SELECT * FROM Clientes";
        String[] cabeceras = {"ID", "NOMBRE", "APELLIDOS", "DOCUMENTO", "TELÉFONO", "EMAIL"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDCliente"), rs.getString("nombreCliente"), rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"),
                        rs.getString("numeroDocumento"), rs.getLong("telefono"), rs.getString("email")});
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

    public boolean eliminarCliente(int indice) {
        String consulta = "DELETE FROM Clientes WHERE IDCliente = '" + indice + "'";

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            st.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public java.util.Vector obtenerDatosCliente(int idCliente) {
        String consulta = "SELECT * FROM Clientes WHERE IDCliente = '" + idCliente + "'";
        java.util.Vector datos = new java.util.Vector<>();
        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    datos.add(rs.getInt("IDCliente"));
                    datos.add(rs.getString("nombreCliente"));
                    datos.add(rs.getString("primerApellidoCliente"));
                    datos.add(rs.getString("segundoApellidoCliente"));
                    datos.add(rs.getString("generoCliente"));
                    datos.add(rs.getString("fechaNacimiento"));
                    datos.add(rs.getString("tipoDocumento"));
                    datos.add(rs.getString("numeroDocumento"));
                    datos.add(rs.getString("direccionCliente"));
                    datos.add(rs.getInt("numero"));
                    datos.add(rs.getString("bloque"));
                    datos.add(rs.getString("escalera"));
                    datos.add(rs.getInt("piso"));
                    datos.add(rs.getString("letra"));
                    datos.add(rs.getString("poblacion"));
                    datos.add(rs.getString("codigoPostal"));
                    datos.add(rs.getString("pais"));
                    datos.add(rs.getString("empresa"));
                    datos.add(rs.getLong("telefono"));
                    datos.add(rs.getLong("segundoTelefono"));
                    datos.add(rs.getLong("fax"));
                    datos.add(rs.getLong("movil"));
                    datos.add(rs.getString("email"));
                    datos.add(rs.getString("razonSocial"));
                    datos.add(rs.getString("Observaciones"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            st.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return datos;
    }

    public void modificarDatos(int idcliente, String nombre, String primerapellido, String segundoapellido, String genero, String fecha, String tipoDoc, String numeroDoc,
            String dir, String numero, String bloque, String escalera, String piso, String letra, String poblacion, String codpostal, String pais, String empresa,
            long telefono, long segundotelefono, long fax, long movil, String email, String razonSocial, String observaciones) {
        consulta = "UPDATE Clientes "
                + "SET nombreCliente = ?, primerApellidoCliente = ?, segundoApellidoCliente = ?, generoCliente = ?, fechaNacimiento = ?, tipoDocumento = ?,"
                + "numeroDocumento = ?, direccionCliente = ?, numero = ?, bloque = ?, escalera = ?, piso = ?, letra = ?, poblacion = ?, codigoPostal = ?,"
                + "pais = ?, empresa = ?, telefono = ?, segundoTelefono =  ?, fax = ?, movil = ?, email = ?, razonSocial = ?, observaciones = ?"
                + " WHERE IDCliente = '" + idcliente + "'";

        try {
            con = conection.ObtenerConexion();
            ps = con.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, primerapellido);
            ps.setString(3, segundoapellido);
            ps.setString(4, genero);
            ps.setString(5, fecha);
            ps.setString(6, tipoDoc);
            ps.setString(7, numeroDoc);
            ps.setString(8, dir);
            ps.setString(9, numero);
            ps.setString(10, bloque);
            ps.setString(11, escalera);
            ps.setString(12, piso);
            ps.setString(13, letra);
            ps.setString(14, poblacion);
            ps.setString(15, codpostal);
            ps.setString(16, pais);
            ps.setString(17, empresa);
            ps.setLong(18, telefono);
            ps.setLong(19, segundotelefono);
            ps.setLong(20, fax);
            ps.setLong(21, movil);
            ps.setString(22, email);
            ps.setString(23, razonSocial);
            ps.setString(24, observaciones);
            ps.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente modificado con éxito");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensaje = "";
            if (ex.getMessage().startsWith("Duplicate entry")) {
                mensaje = "DNI ya registrado";
                javax.swing.JOptionPane.showMessageDialog(null, "El DNI ya ha sido registrado en la base de datos", "DNI duplicado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            }

        }

        try {
            ps.clearParameters();
            ps.close();
            con.close();
        } catch (java.sql.SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public javax.swing.table.DefaultTableModel busquedaClientes(String opcionBusqueda, String textoBusqueda) {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        String consulta = "SELECT * FROM Clientes WHERE " + opcionBusqueda + " LIKE '%" + textoBusqueda + "%'";
        String[] cabeceras = {"ID", "NOMBRE", "APELLIDOS", "DOCUMENTO", "TELÉFONO", "EMAIL"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDCliente"), rs.getString("nombreCliente"), rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"),
                        rs.getString("numeroDocumento"), rs.getLong("telefono"), rs.getString("email")});
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

    public javax.swing.table.DefaultTableModel exportarAllClientes(javax.swing.table.TableModel modeloTabla) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) modeloTabla;
        String consulta = "SELECT * FROM Clientes";
        String[] cabeceras = {"ID", "NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "GÉNERO", "FECHA DE NACIMIENTO", "TIPO DE DOCUMENTO",
            "NÚMERO DE DOCUMENTO", "DIRECCIÓN", "NÚMERO", "BLOQUE", "ESCALERA", "PISO", "LETRA", "POBLACIÓN",
            "CÓDIGO POSTAL", "PAÍS", "EMPRESA", "TELÉFONO", "SEGUNDO TELÉFONO", "FAX", "MÓVIL", "EMAIL", "RAZÓN SOCIAL", "OBSERVACIONES"};
        for (int i = 0; i < cabeceras.length; i++) {
            modelo.addColumn(cabeceras[i]);
        }
        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("IDCliente"),
                        rs.getString("nombreCliente"), rs.getString("primerApellidoCliente"), rs.getString("segundoApellidoCliente"),
                        rs.getString("generoCliente"), rs.getString("fechaNacimiento"), rs.getString("tipoDocumento"), rs.getString("numeroDocumento"),
                        rs.getString("direccionCliente"), rs.getInt("numero"), rs.getString("bloque"), rs.getString("escalera"), rs.getInt("piso"),
                        rs.getString("letra"), rs.getString("poblacion"), rs.getString("codigoPostal"), rs.getString("pais"), rs.getString("empresa"),
                        rs.getLong("telefono"), rs.getLong("segundoTelefono"), rs.getLong("fax"), rs.getLong("movil"), rs.getString("email"),
                        rs.getString("razonSocial"), rs.getString("Observaciones")});
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

    public int obtenerIdCliente(String dni) {
        int id = 0;
        String consulta = "SELECT IDCliente FROM Clientes WHERE numeroDocumento = '" + dni + "'";

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs != null) {
                id = rs.getInt("IDCliente");
            }
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "El DNI introducido no pertenece a ningún cliente.", "Error", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }

        try {
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }

    public String nombreCompletoCliente(int idcliente) {
        String clientecompleto = "";
        String consulta = "SELECT Clientes.nombreCliente, Clientes.primerApellidoCliente, Clientes.segundoApellidoCliente FROM Clientes WHERE idCliente = " + idcliente;

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    clientecompleto = rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente");
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
        return clientecompleto;
    }

    public java.util.Map<String, String> fichaCliente(int idcliente) {

        java.util.Map datosCliente = new java.util.HashMap<String, String>();
        String consulta = "SELECT * FROM Clientes WHERE IDCliente = " + idcliente;

        try {
            con = conection.ObtenerConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs != null) {
                while (rs.next()) {
                    String telefono = "", segundotelefono = "", fax = "", movil = "";
                    
                    telefono = "" + rs.getInt("telefono");
                    segundotelefono = "" + rs.getInt("segundotelefono");
                    fax = "" + rs.getInt("fax");
                    movil = "" + rs.getInt("movil");
                    if(telefono.compareTo("0")==0) telefono = "--";
                    if(segundotelefono.compareTo("0")==0) segundotelefono = "--";
                    if(fax.compareTo("0")==0) fax = "--";
                    if(movil.compareTo("0")==0) movil = "--";
                    
                    datosCliente.put("nombrecompleto", rs.getString("nombreCliente") + " " + rs.getString("primerApellidoCliente") + " " + rs.getString("segundoApellidoCliente"));
                    datosCliente.put("fechanacimiento", rs.getString("fechaNacimiento"));
                    datosCliente.put("numerodocumento", rs.getString("numeroDocumento"));
                    datosCliente.put("telefono", telefono);
                    datosCliente.put("direccioncompleta", rs.getString("direccionCliente") + " " + rs.getInt("numero") + " " + rs.getString("bloque") + " " + rs.getString("escalera")
                            + " " + rs.getInt("piso") + " " + rs.getString("letra") + " " + rs.getString("poblacion") + " " + rs.getString("codigoPostal") + " " + rs.getString("pais"));
                    datosCliente.put("empresa", rs.getString("empresa"));
                    datosCliente.put("otrosdatos", "Segundo teléfono: " + segundotelefono + "   Fax: " + fax + "   Móvil: " + movil);
                    datosCliente.put("email", rs.getString("email"));
                    datosCliente.put("estadolaboral", rs.getString("razonSocial"));
                    datosCliente.put("observaciones", rs.getString("Observaciones"));
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
        return datosCliente;
    }

}
