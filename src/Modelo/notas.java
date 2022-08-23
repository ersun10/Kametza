/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luisj
 */
public class notas extends javax.swing.JTextArea {

    private String fecha = "";
    private String mensaje = "";
    private String cliente = "";
    private String nota = "";
    int idNota;
    int idCliente;
    
    private final Controlador.ClientesDAO clientes = new Controlador.ClientesDAO();
    

    public notas (){
        
    }
    public notas(int idnota, String fechaNota, int idcliente, String textoNota) {
        this.setPreferredSize(new java.awt.Dimension(162, 124));
        this.setWrapStyleWord(true);
        this.setLineWrap(true);
        this.setEditable(false);
        this.idNota = idnota;
        this.idCliente = idcliente;
        this.fecha = fechaNota;
        this.nota = textoNota;
        this.cliente = nombreCliente(idCliente);
        mensaje = "Fecha: " + fecha + "\n";
        mensaje += "Cliente: " + cliente + "\n\n";
        mensaje += nota;
        this.setText(mensaje);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarNota(evt);
            }
        });
    }

    private void mostrarNota(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            javax.swing.JOptionPane.showMessageDialog(null, this.getText(), "ID NOTA: " + getIdNota(), javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (evt.getClickCount() == 1 || evt.getClickCount() == 2){
            Vista.Kametza.idnota = this.idNota;
        }

    }
    
    private String nombreCliente(int id){
        String nombreCompleto = "";
        nombreCompleto = clientes.nombreCompletoCliente(idCliente);
        return nombreCompleto;
    }
    
    public int getIdNota(){
        return idNota;
    }
    
    

}
