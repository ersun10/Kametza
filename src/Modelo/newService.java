/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.ActionEvent;

/**
 *
 * @author luisj
 */
public class newService extends javax.swing.JDialog {

    private java.awt.Color colorPanel;
    private javax.swing.JPanel panelprincipal;
    private final Controlador.ServiciosDAO servicios;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTextField jtxtnombre;
    private javax.swing.JLabel lblimporte;
    private javax.swing.JTextField jtxtimporte;
    private javax.swing.JButton jbtGuardar;
    private java.awt.Font lblFont;

    public newService(javax.swing.JFrame parent, boolean modal, java.awt.Color tema) {
        super(parent, modal);
        this.setTitle("Servicios");
        this.setSize(340, 350);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        colorPanel = tema;
        servicios = new Controlador.ServiciosDAO();
        initComponents();
    }

    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panelprincipal = new javax.swing.JPanel();
        lblnombre = new javax.swing.JLabel();
        lblimporte = new javax.swing.JLabel();
        jtxtnombre = new javax.swing.JTextField();
        jtxtimporte = new javax.swing.JTextField();
        jbtGuardar = new javax.swing.JButton();
        lblFont = new java.awt.Font("Verdana", java.awt.Font.PLAIN, 15);

        // Propiedades
        panelprincipal.setBackground(colorPanel);
        panelprincipal.setLayout(null);
        
        lblnombre.setText("Nombre del servicio: ");
        lblnombre.setBounds(80, 20, 250, 30);
        lblnombre.setFont(lblFont);
        jtxtnombre.setBounds(60, 70, 200, 30);
        lblimporte.setText("Importe del servicio: ");
        lblimporte.setBounds(80, 120, 200, 30);
        lblimporte.setFont(lblFont);
        jtxtimporte.setBounds(60, 170, 200, 30);
        jbtGuardar.setText("Guardar");
        jbtGuardar.setFont(lblFont);
        jbtGuardar.setBounds(60, 250, 200, 30);
        jbtGuardar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarActionPerformed(evt);
            }
        });

        // Añadiendo
        this.getContentPane().add(panelprincipal);
        panelprincipal.add(lblnombre);
        panelprincipal.add(lblimporte);
        panelprincipal.add(jtxtnombre);
        panelprincipal.add(jtxtimporte);
        panelprincipal.add(jbtGuardar);
        
        this.getRootPane().setDefaultButton(jbtGuardar);

    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        this.setVisible(false);
        this.dispose();
    }
    
    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt){
        Double importe = 0.00;
        try{
            importe = Double.parseDouble(jtxtimporte.getText());
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "El importe introducido no es válido.", "Importe erróneo", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            if (servicios.insertarDatos(jtxtnombre.getText(), importe)) javax.swing.JOptionPane.showMessageDialog(null, "Servicio guardado con éxito.", "Servicio guardado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
