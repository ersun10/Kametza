/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jdesktop.swingx.JXDatePicker;
import Controlador.Conexion;

public class newUser extends javax.swing.JDialog {

    // Paneles
    private javax.swing.JPanel panelBasico;
    private javax.swing.JPanel panelDireccion;
    private javax.swing.JPanel panelContacto;
    private javax.swing.JPanel panelObservaciones;

    // Recogida datos
    private javax.swing.JLabel lblImagen;
    private javax.swing.ImageIcon iconoUser;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrimerApellido;
    private javax.swing.JLabel lblSegundoApellido;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblTipoDocumento;
    private javax.swing.JLabel lblNumeroIdentificacion;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblSegundoTelefono;
    private javax.swing.JLabel lblMovil;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblBloque;
    private javax.swing.JLabel lblEscalera;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblPuerta;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblSocial;
    private javax.swing.JLabel lblObservaciones;

    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPrimerApellido;
    private javax.swing.JTextField jtxtSegundoApellido;
    private javax.swing.JTextField jtxtNumeroIdentificacion;
    private javax.swing.JTextField jtxtTelefono;
    private javax.swing.JTextField jtxtSegundoTelefono;
    private javax.swing.JTextField jtxtMovil;
    private javax.swing.JTextField jtxtFax;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtCiudad;
    private javax.swing.JTextField jtxtCodigoPostal;
    private javax.swing.JTextField jtxtPais;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtEmpresa;
    private javax.swing.JTextField jtxtNumero;
    private javax.swing.JTextField jtxtBloque;
    private javax.swing.JTextField jtxtEscalera;
    private javax.swing.JTextField jtxtPiso;
    private javax.swing.JTextField jtxtPuerta;
    private javax.swing.JTextArea jtxtAreaObservaciones;

    private javax.swing.JComboBox<java.lang.String> jcomboTipoIdentificacion;
    private javax.swing.JComboBox<java.lang.String> jcomboSexo;
    private javax.swing.JComboBox<java.lang.String> jcomboSocial;

    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtCancelar;

    // Otros
    private java.awt.Font lblFont;
    private java.awt.Color colorPaneles;

    // Calendario
    private final JXDatePicker picker = new JXDatePicker();
    
    // CambioForm
    private boolean modificar;
    private int idcliente;
    
    // Instancias
    private final Controlador.ClientesDAO clientesdao = new Controlador.ClientesDAO();
    private final Vista.Kametza principal = new Vista.Kametza();
    private final Controlador.parseDate parsedate = new Controlador.parseDate();
    
    public newUser(javax.swing.JFrame parent, boolean modal, java.awt.Color tema) {
        super(parent, modal);
        this.setTitle("Nuevo cliente");
        this.setSize(800, 800);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        colorPaneles = tema;
        modificar = false;
        initComponents();
    }
    
    public newUser(javax.swing.JFrame parent, boolean modal, java.awt.Color tema, java.util.Vector datosCliente){
        super(parent, modal);
        this.setTitle("Modificar cliente");
        this.setSize(800, 800);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        colorPaneles = tema;
        modificar = true;
        try{
        idcliente = Integer.parseInt(datosCliente.get(0).toString());
        }catch(Exception ex){}
        initComponents();
        rellenarCampos(datosCliente);
    }

    private void initComponents() {
        this.getContentPane().setLayout(new java.awt.GridLayout(4, 1));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        // Inicializando
        panelBasico = new javax.swing.JPanel();
        panelDireccion = new javax.swing.JPanel();
        panelContacto = new javax.swing.JPanel();
        panelObservaciones = new javax.swing.JPanel();
        // Componentes
        iconoUser = new javax.swing.ImageIcon("Imagenes/FichaUser.png");
        lblImagen = new javax.swing.JLabel(iconoUser);
        lblNombre = new javax.swing.JLabel();
        lblPrimerApellido = new javax.swing.JLabel();
        lblSegundoApellido = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTipoDocumento = new javax.swing.JLabel();
        lblNumeroIdentificacion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblSegundoTelefono = new javax.swing.JLabel();
        lblMovil = new javax.swing.JLabel();
        lblFax = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblBloque = new javax.swing.JLabel();
        lblEscalera = new javax.swing.JLabel();
        lblPiso = new javax.swing.JLabel();
        lblPuerta = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        lblCodigoPostal = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        lblSocial = new javax.swing.JLabel();
        jtxtAreaObservaciones = new javax.swing.JTextArea();
        jtxtNombre = new javax.swing.JTextField();
        jtxtPrimerApellido = new javax.swing.JTextField();
        jtxtSegundoApellido = new javax.swing.JTextField();
        jtxtNumeroIdentificacion = new javax.swing.JTextField();
        jtxtTelefono = new javax.swing.JTextField();
        jtxtSegundoTelefono = new javax.swing.JTextField();
        jtxtMovil = new javax.swing.JTextField();
        jtxtFax = new javax.swing.JTextField();
        jtxtDireccion = new javax.swing.JTextField();
        jtxtCiudad = new javax.swing.JTextField();
        jtxtCodigoPostal = new javax.swing.JTextField();
        jtxtPais = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jtxtEmpresa = new javax.swing.JTextField();
        jtxtNumero = new javax.swing.JTextField();
        jtxtBloque = new javax.swing.JTextField();
        jtxtEscalera = new javax.swing.JTextField();
        jtxtPiso = new javax.swing.JTextField();
        jtxtPuerta = new javax.swing.JTextField();

        jcomboTipoIdentificacion = new javax.swing.JComboBox<java.lang.String>();
        jcomboSexo = new javax.swing.JComboBox<java.lang.String>();
        jcomboSocial = new javax.swing.JComboBox<java.lang.String>();

        jbtGuardar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();

        lblFont = new java.awt.Font("Verdana", java.awt.Font.PLAIN, 15);

        // Calendario
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        picker.setBounds(350, 85, 200, 30);

        // Propiedades
        panelBasico.setLayout(null);
        panelBasico.setBackground(colorPaneles);
        panelDireccion.setLayout(null);
        panelDireccion.setBackground(colorPaneles);
        panelContacto.setLayout(null);
        panelContacto.setBackground(colorPaneles);
        panelObservaciones.setLayout(null);
        panelObservaciones.setBackground(colorPaneles);

        // Propiedades componentes información básica
        lblImagen.setBounds(600, 25, 150, 150);
        lblNombre.setText("*Nombre: ");
        lblNombre.setFont(lblFont);
        lblNombre.setBounds(20, 20, 150, 26);
        jtxtNombre.setBounds(100, 20, 150, 30);
        lblSexo.setText("*Género: ");
        lblSexo.setFont(lblFont);
        lblSexo.setBounds(320, 20, 150, 26);
        jcomboSexo.addItem("Masculino");
        jcomboSexo.addItem("Femenino");
        jcomboSexo.setBounds(400, 20, 150, 30);
        lblPrimerApellido.setText("*Primer apellido: ");
        lblPrimerApellido.setFont(lblFont);
        lblPrimerApellido.setBounds(20, 60, 150, 26);
        jtxtPrimerApellido.setBounds(170, 60, 150, 30);
        lblFechaNacimiento.setText("Fecha de nacimiento");
        lblFechaNacimiento.setFont(lblFont);
        lblFechaNacimiento.setBounds(350, 60, 200, 26);
        lblSegundoApellido.setText("Segundo apellido: ");
        lblSegundoApellido.setFont(lblFont);
        lblSegundoApellido.setBounds(20, 100, 150, 26);
        jtxtSegundoApellido.setBounds(170, 100, 150, 30);
        lblTipoDocumento.setText("*Tipo de documento: ");
        lblTipoDocumento.setFont(lblFont);
        lblTipoDocumento.setBounds(20, 140, 200, 26);
        jcomboTipoIdentificacion.addItem("NIE");
        jcomboTipoIdentificacion.addItem("DNI");
        jcomboTipoIdentificacion.setBounds(190, 140, 100, 30);
        lblNumeroIdentificacion.setText("*Número: ");
        lblNumeroIdentificacion.setFont(lblFont);
        lblNumeroIdentificacion.setBounds(320, 140, 100, 26);
        jtxtNumeroIdentificacion.setBounds(400, 140, 150, 30);

        // Propiedades componentes dirección
        lblDireccion.setText("Dirección: ");
        lblDireccion.setBounds(20, 40, 150, 26);
        lblDireccion.setFont(lblFont);
        jtxtDireccion.setBounds(110, 40, 400, 30);
        lblNumero.setText("Número: ");
        lblNumero.setFont(lblFont);
        lblNumero.setBounds(530, 40, 150, 26);
        jtxtNumero.setBounds(620, 40, 100, 30);
        lblBloque.setText("Bloque: ");
        lblBloque.setFont(lblFont);
        lblBloque.setBounds(20, 90, 150, 26);
        jtxtBloque.setBounds(90, 90, 50, 30);
        lblEscalera.setText("Escalera: ");
        lblEscalera.setFont(lblFont);
        lblEscalera.setBounds(170, 90, 150, 26);
        jtxtEscalera.setBounds(250, 90, 50, 30);
        lblPiso.setText("Piso: ");
        lblPiso.setFont(lblFont);
        lblPiso.setBounds(320, 90, 150, 26);
        jtxtPiso.setBounds(370, 90, 50, 30);
        lblPuerta.setText("Letra: ");
        lblPuerta.setFont(lblFont);
        lblPuerta.setBounds(450, 90, 150, 26);
        jtxtPuerta.setBounds(510, 90, 50, 30);
        lblCiudad.setText("Población: ");
        lblCiudad.setFont(lblFont);
        lblCiudad.setBounds(20, 140, 150, 26);
        jtxtCiudad.setBounds(100, 140, 200, 30);
        lblCodigoPostal.setText("C. postal: ");
        lblCodigoPostal.setFont(lblFont);
        lblCodigoPostal.setBounds(320, 140, 150, 26);
        jtxtCodigoPostal.setBounds(400, 140, 100, 30);
        lblPais.setText("País: ");
        lblPais.setFont(lblFont);
        lblPais.setBounds(520, 140, 150, 26);
        jtxtPais.setBounds(570, 140, 150, 30);

        // Propiedades componentes información contacto
        lblEmpresa.setText("Nombre empresa: ");
        lblEmpresa.setFont(lblFont);
        lblEmpresa.setBounds(20, 40, 150, 25);
        jtxtEmpresa.setBounds(190, 40, 530, 30);
        lblTelefono.setText("Teléfono: ");
        lblTelefono.setFont(lblFont);
        lblTelefono.setBounds(20, 90, 150, 26);
        jtxtTelefono.setBounds(110, 90, 150, 30);
        jtxtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt){
              validarTelefono(evt);  
            }
        });
        lblSegundoTelefono.setText("2º teléfono: ");
        lblSegundoTelefono.setFont(lblFont);
        lblSegundoTelefono.setBounds(280, 90, 150, 26);
        jtxtSegundoTelefono.setBounds(390, 90, 150, 30);
        jtxtSegundoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt){
              validarTelefono2(evt);  
            }
        });
        lblFax.setText("Fax: ");
        lblFax.setFont(lblFont);
        lblFax.setBounds(560, 90, 150, 26);
        jtxtFax.setBounds(600, 90, 120, 30);
        jtxtFax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt){
              validarTelefonoFax(evt);  
            }
        });
        lblMovil.setText("Móvil: ");
        lblMovil.setFont(lblFont);
        lblMovil.setBounds(20, 140, 150, 26);
        jtxtMovil.setBounds(80, 140, 100, 30);
        jtxtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt){
              validarTelefonoMovil(evt);  
            }
        });
        lblEmail.setText("Email: ");
        lblEmail.setFont(lblFont);
        lblEmail.setBounds(200, 140, 150, 26);
        jtxtEmail.setBounds(260, 140, 200, 30);
        lblSocial.setText("Razón: ");
        lblSocial.setFont(lblFont);
        lblSocial.setBounds(480, 140, 100, 26);
        jcomboSocial.addItem("");
        jcomboSocial.addItem("Desempleado");
        jcomboSocial.addItem("Autónomo");
        jcomboSocial.addItem("Sociedad Limitada");
        jcomboSocial.addItem("Sociedad Anónima");
        jcomboSocial.addItem("Asociación");
        jcomboSocial.addItem("Sociedad Colectiva");
        jcomboSocial.addItem("Sociedad Comanditaria");
        jcomboSocial.addItem("Comunidad de Bienes");
        jcomboSocial.addItem("Sociedad Cooperativa");
        jcomboSocial.setEditable(true);
        jcomboSocial.setBounds(550, 140, 170, 30);

        // Propiedades componentes observaciones
        jtxtAreaObservaciones.setWrapStyleWord(true);
        jtxtAreaObservaciones.setLineWrap(true);
        jtxtAreaObservaciones.setBounds(10, 25, 550, 150);
        jbtGuardar.setText("Guardar");
        jbtGuardar.setFont(lblFont);
        jbtGuardar.setBounds(600, 50, 150, 30);
        jbtGuardar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarActionPerformed(evt);
            }
        });
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setFont(lblFont);
        jbtCancelar.setBounds(600, 100, 150, 30);
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });
        // Añadiendo a los paneles
        panelBasico.add(lblImagen);
        panelBasico.add(lblNombre);
        panelBasico.add(jtxtNombre);
        panelBasico.add(lblSexo);
        panelBasico.add(jcomboSexo);
        panelBasico.add(lblPrimerApellido);
        panelBasico.add(jtxtPrimerApellido);
        panelBasico.add(lblFechaNacimiento);
        panelBasico.add(lblSegundoApellido);
        panelBasico.add(jtxtSegundoApellido);
        panelBasico.add(picker);
        panelBasico.add(lblTipoDocumento);
        panelBasico.add(jcomboTipoIdentificacion);
        panelBasico.add(lblNumeroIdentificacion);
        panelBasico.add(jtxtNumeroIdentificacion);

        panelDireccion.add(lblDireccion);
        panelDireccion.add(jtxtDireccion);
        panelDireccion.add(lblNumero);
        panelDireccion.add(jtxtNumero);
        panelDireccion.add(lblBloque);
        panelDireccion.add(jtxtBloque);
        panelDireccion.add(lblEscalera);
        panelDireccion.add(jtxtEscalera);
        panelDireccion.add(lblPiso);
        panelDireccion.add(jtxtPiso);
        panelDireccion.add(lblPuerta);
        panelDireccion.add(jtxtPuerta);
        panelDireccion.add(lblCiudad);
        panelDireccion.add(jtxtCiudad);
        panelDireccion.add(lblCodigoPostal);
        panelDireccion.add(jtxtCodigoPostal);
        panelDireccion.add(lblPais);
        panelDireccion.add(jtxtPais);

        panelContacto.add(lblEmpresa);
        panelContacto.add(jtxtEmpresa);
        panelContacto.add(lblTelefono);
        panelContacto.add(jtxtTelefono);
        panelContacto.add(lblSegundoTelefono);
        panelContacto.add(jtxtSegundoTelefono);
        panelContacto.add(lblFax);
        panelContacto.add(jtxtFax);
        panelContacto.add(lblMovil);
        panelContacto.add(jtxtMovil);
        panelContacto.add(lblEmail);
        panelContacto.add(jtxtEmail);
        panelContacto.add(lblSocial);
        panelContacto.add(jcomboSocial);

        panelObservaciones.add(jtxtAreaObservaciones);
        panelObservaciones.add(jbtGuardar);
        panelObservaciones.add(jbtCancelar);

        panelBasico.setBorder(new javax.swing.border.TitledBorder("Información básica"));
        panelDireccion.setBorder(new javax.swing.border.TitledBorder("Dirección"));
        panelContacto.setBorder(new javax.swing.border.TitledBorder("Información de contacto"));
        panelObservaciones.setBorder(new javax.swing.border.TitledBorder("Observaciones"));

        // Añadiendo
        this.getContentPane().add(panelBasico);
        this.getContentPane().add(panelDireccion);
        this.getContentPane().add(panelContacto);
        this.getContentPane().add(panelObservaciones);
    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        this.setVisible(false);
        this.dispose();
    }

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        
        String date = "";

        if (jtxtNombre.getText().compareTo("") == 0 || jtxtPrimerApellido.getText().compareTo("") == 0 || jtxtNumeroIdentificacion.getText().compareTo("") == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe rellenar los campos obligatorios", "Faltan datos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!emailValidate(jtxtEmail.getText())) {
            int opcion = javax.swing.JOptionPane.showConfirmDialog(null, "El email parece incorrecto, ¿Desea continuar?", "Email incorrecto", javax.swing.JOptionPane.YES_NO_OPTION);
            if (opcion == javax.swing.JOptionPane.NO_OPTION) return;
        }
        java.text.DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        date = formatoFecha.format(picker.getDate());
        date = date.toString();
        if (!dateValidate(date)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecta", "Fecha incorrecta", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!codigoPostalValidate(jtxtCodigoPostal.getText())) {
            int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "El código postal parece incorrecto, ¿Desea continuar?", "Información", javax.swing.JOptionPane.YES_NO_OPTION);
            if(opcion == javax.swing.JOptionPane.NO_OPTION) return;
        }
        
        
        long telefono = 0, segundoTelefono = 0, fax = 0, movil = 0;
        
        try{
           if(jtxtTelefono.getText().compareTo("") != 0 && telefonoValidate(jtxtTelefono.getText())){
            telefono = Long.parseLong(jtxtTelefono.getText());
        } else {
            int opcion = 0;
            opcion = javax.swing.JOptionPane.showConfirmDialog(null, "El teléfono parece incorrecto, ¿desea continuar?", "Teléfono incorrecto", javax.swing.JOptionPane.YES_NO_OPTION);
            if(opcion == javax.swing.JOptionPane.NO_OPTION) return;
        }
        if(jtxtSegundoTelefono.getText().compareTo("") != 0 && telefonoValidate(jtxtSegundoTelefono.getText())){
            segundoTelefono = Long.parseLong(jtxtSegundoTelefono.getText());
        }
        if(jtxtFax.getText().compareTo("") != 0 && telefonoValidate(jtxtFax.getText())){
            fax = Long.parseLong(jtxtFax.getText());
        }
        if(jtxtMovil.getText().compareTo("") != 0 && telefonoValidate(jtxtMovil.getText())){
            movil = Long.parseLong(jtxtMovil.getText());
        } 
        } catch (NumberFormatException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Uno de los teléfonos introducidos no es correcto", "Error en teléfonos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!modificar){
         
            try{
            clientesdao.insertarDatos(jtxtNombre.getText(), jtxtPrimerApellido.getText(), jtxtSegundoApellido.getText(), jcomboSexo.getSelectedItem().toString(), date,
                jcomboTipoIdentificacion.getSelectedItem().toString(), jtxtNumeroIdentificacion.getText(), jtxtDireccion.getText(), jtxtNumero.getText(),
                jtxtBloque.getText(), jtxtEscalera.getText(), jtxtPiso.getText(), jtxtPuerta.getText(), jtxtCiudad.getText(),
                jtxtCodigoPostal.getText(), jtxtPais.getText(), jtxtEmpresa.getText(), telefono, segundoTelefono,
                fax, movil, jtxtEmail.getText(), jcomboSocial.getSelectedItem().toString(), jtxtAreaObservaciones.getText());
    
        }catch(NumberFormatException ex){
            System.out.println("Error en la consulta: ");
            ex.printStackTrace();
        }
            
        }else{
          try{
           
           clientesdao.modificarDatos(idcliente, jtxtNombre.getText(), jtxtPrimerApellido.getText(), jtxtSegundoApellido.getText(), jcomboSexo.getSelectedItem().toString(), date,
                jcomboTipoIdentificacion.getSelectedItem().toString(), jtxtNumeroIdentificacion.getText(), jtxtDireccion.getText(), jtxtNumero.getText(),
                jtxtBloque.getText(), jtxtEscalera.getText(), jtxtPiso.getText(), jtxtPuerta.getText(), jtxtCiudad.getText(),
                jtxtCodigoPostal.getText(), jtxtPais.getText(), jtxtEmpresa.getText(), telefono, segundoTelefono,
                fax, movil, jtxtEmail.getText(), jcomboSocial.getSelectedItem().toString(), jtxtAreaObservaciones.getText()); 
    
        }catch(NumberFormatException ex){
            System.out.println("Error en la consulta: ");
            ex.printStackTrace();
        }  
        }
        
        
        }

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        this.dispose();
    }

    private boolean emailValidate(String email) {
        String patron = "([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})";
        return email.matches(patron);
    }

    private boolean dateValidate(String date) {
        String patron = "(([1-5][0-9])([0-9][0-9]))[\\\\-](0[1-9]|1[012])[\\\\-](0[1-9]|[12][0-9]|3[01])";
        return date.matches(patron);
    }

    private boolean codigoPostalValidate(String cPostal) {
        String patron = "([0-9]{5})";
        return cPostal.matches(patron);
    }
    
    private boolean telefonoValidate(String telefono){
        String patron ="([0-9]{9})";
        return telefono.matches(patron);
    }
    
    private void validarTelefono(java.awt.event.KeyEvent evt){
         String texto = jtxtTelefono.getText();
        // Almacenamos el texto
        char[] fuente = texto.toCharArray();
        //Reiniciamos la variable
        texto = "";
        int j = 0;
        // Para almacenar el resultado
        char[] resultado = new char[fuente.length];

        for (int i = 0; i < fuente.length; i++) {
            if (fuente[i] >= '0' && fuente[i] <= '9') {
                if (j < 9) {
                    resultado[j++] = fuente[i];
                    texto += resultado[i];
                }
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }

        jtxtTelefono.setText(texto);
    }
    
    private void validarTelefono2(java.awt.event.KeyEvent evt){
         String texto = jtxtSegundoTelefono.getText();
        // Almacenamos el texto
        char[] fuente = texto.toCharArray();
        //Reiniciamos la variable
        texto = "";
        int j = 0;
        // Para almacenar el resultado
        char[] resultado = new char[fuente.length];

        for (int i = 0; i < fuente.length; i++) {
            if (fuente[i] >= '0' && fuente[i] <= '9') {
                if (j < 9) {
                    resultado[j++] = fuente[i];
                    texto += resultado[i];
                }
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }

        jtxtSegundoTelefono.setText(texto);
    }
    
    private void validarTelefonoFax(java.awt.event.KeyEvent evt){
         String texto = jtxtFax.getText();
        // Almacenamos el texto
        char[] fuente = texto.toCharArray();
        //Reiniciamos la variable
        texto = "";
        int j = 0;
        // Para almacenar el resultado
        char[] resultado = new char[fuente.length];

        for (int i = 0; i < fuente.length; i++) {
            if (fuente[i] >= '0' && fuente[i] <= '9') {
                if (j < 9) {
                    resultado[j++] = fuente[i];
                    texto += resultado[i];
                }
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }

        jtxtFax.setText(texto);
    }
    
    private void validarTelefonoMovil(java.awt.event.KeyEvent evt){
         String texto = jtxtMovil.getText();
        // Almacenamos el texto
        char[] fuente = texto.toCharArray();
        //Reiniciamos la variable
        texto = "";
        int j = 0;
        // Para almacenar el resultado
        char[] resultado = new char[fuente.length];

        for (int i = 0; i < fuente.length; i++) {
            if (fuente[i] >= '0' && fuente[i] <= '9') {
                if (j < 9) {
                    resultado[j++] = fuente[i];
                    texto += resultado[i];
                }
            } else {
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }

        jtxtMovil.setText(texto);
    }
    
    private void rellenarCampos(java.util.Vector datosCliente){
        java.util.Date fecha = parsedate.StringToDate(datosCliente.get(5).toString());
        jtxtNombre.setText(datosCliente.get(1).toString());
        jtxtPrimerApellido.setText(datosCliente.get(2).toString());
        jtxtSegundoApellido.setText(datosCliente.get(3).toString());
        jcomboSexo.setSelectedItem(datosCliente.get(4));
        picker.setDate(fecha);
        jcomboTipoIdentificacion.setSelectedItem(datosCliente.get(6));
        jtxtNumeroIdentificacion.setText(datosCliente.get(7).toString());
        jtxtDireccion.setText(datosCliente.get(8).toString());
        jtxtNumero.setText(datosCliente.get(9).toString());
        jtxtBloque.setText(datosCliente.get(10).toString());
        jtxtEscalera.setText(datosCliente.get(11).toString());
        jtxtPiso.setText(datosCliente.get(12).toString());
        jtxtPuerta.setText(datosCliente.get(13).toString());
        jtxtCiudad.setText(datosCliente.get(14).toString());
        jtxtCodigoPostal.setText(datosCliente.get(15).toString());
        jtxtPais.setText(datosCliente.get(16).toString());
        jtxtEmpresa.setText(datosCliente.get(17).toString());
        jtxtTelefono.setText(datosCliente.get(18).toString());
        jtxtSegundoTelefono.setText(datosCliente.get(19).toString());
        jtxtFax.setText(datosCliente.get(20).toString());
        jtxtMovil.setText(datosCliente.get(21).toString());
        jtxtEmail.setText(datosCliente.get(22).toString());
        jcomboSocial.setSelectedItem(datosCliente.get(23));
        jtxtAreaObservaciones.setText(datosCliente.get(24).toString());
        jbtGuardar.setText("Modificar cliente");
    }
}
