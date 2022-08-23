package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXDatePicker;

public class Kametza extends javax.swing.JFrame {

    // Declaración de controles
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JPanel panelOperacion;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelRegistros;
    private javax.swing.JPanel panelCitas;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelGraficos;
    private javax.swing.JPanel panelFacturas;

    // Elementos del menú
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu jmnuArchivo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jmnuClientes;
    private javax.swing.JMenuItem itemNuevoCliente;
    private javax.swing.JMenu jmnuEstado;
    private javax.swing.JCheckBoxMenuItem itemOnline;
    private javax.swing.JCheckBoxMenuItem itemOffline;
    private javax.swing.JMenu jmnuExportar;
    private javax.swing.JMenuItem itemExportarClientes;
    private javax.swing.JMenuItem itemExportarOperaciones;
    private javax.swing.JMenu jmnuOpciones;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JSeparator separadorOpciones;
    private javax.swing.JMenu jmnuTemas;
    private javax.swing.JCheckBoxMenuItem itemDefecto;
    private javax.swing.JCheckBoxMenuItem itemSecundario;
    private javax.swing.JMenu jmnuInformacion;
    private javax.swing.JMenuItem itemAcerca;
    private javax.swing.JMenuItem itemGuiaUso;

    // PopMenu Tabla Operaciones
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JMenu menupop;
    private javax.swing.JMenuItem jbtFinalizada;
    private javax.swing.JMenuItem jbtPendiente;

    // PopMenu Tabla Clientes
    private javax.swing.JPopupMenu popMenuClientes;
    private javax.swing.JMenu menupopClientes;
    private javax.swing.JMenuItem jbtOperacion;
    private javax.swing.JMenuItem jbtNota;

    // Otros
    private java.awt.Color colorPaneles;

    // Calendario
    JXDatePicker picker = new JXDatePicker();

    // -------------------------------------------------------------------------------------------------------
    // --------------------------------PANEL CLIENTES---------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------
    private javax.swing.JPanel jpanelIconos;
    private javax.swing.JPanel jpanelClientes;
    private javax.swing.JPanel jpanelOperacionesClientes;
    private javax.swing.JPanel jpanelNotasClientes;
    private javax.swing.JPanel jpanelNotasDelCliente;

    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaOperaciones;

    private javax.swing.ButtonGroup grupoBusqueda;
    private javax.swing.JCheckBox jcheckDni;
    private javax.swing.JCheckBox jcheckApellido;
    private javax.swing.JCheckBox jcheckTelefono;

    private javax.swing.JButton jbtAgregarCliente;
    private javax.swing.JButton jbtTotalClientes;
    private javax.swing.JButton jbtBusqueda;
    private javax.swing.JButton jbtModificarCliente;
    private javax.swing.JButton jbtEliminarCliente;
    private javax.swing.JButton jbtReportarDatosCliente;
    private javax.swing.JButton jbtExportarClientesCsv;
    private javax.swing.JButton jbtModificarOperacion;
    private javax.swing.JButton jbtEliminarOperacion;
    private javax.swing.JButton jbtBuscarOperacion;
    private javax.swing.JButton jbtFacturaOperacion;
    private javax.swing.JButton jbtExportarOperaciones;
    private javax.swing.JButton jbtAgregarNota;
    private javax.swing.JButton jbtEliminarNota;
    private javax.swing.JButton jbtModificarNota;

    private javax.swing.JTextField jtxtBusqueda;

    private javax.swing.JTextArea jtxtareaNotas;

    private javax.swing.ImageIcon iconoAgregarCliente;
    private javax.swing.ImageIcon iconoModificarCliente;
    private javax.swing.ImageIcon iconoEliminarCliente;
    private javax.swing.ImageIcon iconoBusqueda;

    private javax.swing.JScrollPane scrollPanel;

    private javax.swing.JScrollPane scrollTablaOperaciones;
    private javax.swing.JScrollPane scrollNotasClientes;
    public static int idnota;

    private int idcliente = -1;
    private boolean clienteEspecifico = false;
    private String fechabusqueda = "";
    private boolean busquedafecha = false;

    // Instancias
    final Controlador.ClientesDAO clientes = new Controlador.ClientesDAO();
    final Controlador.CsvExport exportar = new Controlador.CsvExport();
    final Controlador.OperacionesDAO operaciones = new Controlador.OperacionesDAO();
    final Controlador.ServiciosDAO servicios = new Controlador.ServiciosDAO();
    final Controlador.NotasDAO notas = new Controlador.NotasDAO();

    // -------------------------------------------------------------------------------------------------------
    // --------------------------------PANEL NOTAS------------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JLabel lblbuscardni;
    private javax.swing.JTextField jtxtbuscardni;
    private javax.swing.JLabel lblnombreclientenota;
    private javax.swing.JLabel lblapellidosclientenota;
    private javax.swing.JLabel lbldniclientenota;
    private javax.swing.JButton jbtbuscardni;
    private javax.swing.JButton jbtGuardarNota;
    private javax.swing.JTextArea jtxtareaNota;

    // -------------------------------------------------------------------------------------------------------
    // --------------------------------PANEL OPERACIONES------------------------------------------------------
    // -------------------------------------------------------------------------------------------------------
    private java.awt.Font lblFont;
    private javax.swing.JPanel jpanelCliente;
    private javax.swing.JPanel jpanelServicio;
    private javax.swing.JLabel lblbusqueda;
    private javax.swing.JLabel lblobservacionesoperacion;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblapellidos;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JLabel lbldni;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblobservaciones;
    private javax.swing.JLabel lbltiposervicio;
    private javax.swing.JLabel lblsistemapago;
    private javax.swing.JLabel lblimporte;
    private javax.swing.JLabel lblestadooperacion;
    private javax.swing.JTextField jtxtbusquedadni;
    private javax.swing.JTextField jtxtnombre;
    private javax.swing.JTextField jtxtapellidos;
    private javax.swing.JTextField jtxttelefono;
    private javax.swing.JTextField jtxtdni;
    private javax.swing.JTextField jtxtemail;
    private javax.swing.JTextField jtxtobservaciones;
    private javax.swing.JTextField jtxtimporte;
    private javax.swing.JComboBox<String> comboservicio;
    private javax.swing.JComboBox<String> combosistemapago;
    private javax.swing.ButtonGroup grupoestado;
    private javax.swing.JRadioButton radiofinalizada;
    private javax.swing.JRadioButton radiopendiente;
    private javax.swing.JButton jbtaceptar;
    private javax.swing.JButton jbtultimaoperacion;
    private javax.swing.JButton jbtnuevoservicio;
    private javax.swing.JButton jbteliminarservicio;
    private javax.swing.JButton jbtguardar;
    private javax.swing.JTextArea jtxtareaobservaciones;
    private javax.swing.JTextArea jtxtareaobservacionesoperacion;

    public Kametza() {
        this.setTitle("KAMETZA SOLUCIONES");
        // para el icono
        java.net.URL url = getClass().getResource("icono.ico");
        java.awt.Image imagen = getToolkit().getImage(url);
        setIconImage(imagen);
        // ------------------------
        this.setSize(1200, 900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.idnota = -1;
        //if(!login()) System.exit(0);
        initComponents();

    }

    private void initComponents() {

        this.getContentPane().setLayout(new java.awt.GridLayout(1, 1));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        java.awt.event.ItemListener itemlistener = new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemstatechanged(evt);
            }
        };

        // Inicializando componentes
        lblFont = new java.awt.Font("Verdana", java.awt.Font.PLAIN, 15);
        tabbedPanel = new javax.swing.JTabbedPane();
        panelOperacion = new javax.swing.JPanel();
        panelClientes = new javax.swing.JPanel();
        panelRegistros = new javax.swing.JPanel();
        panelCitas = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        panelGraficos = new javax.swing.JPanel();
        panelFacturas = new javax.swing.JPanel();
        // Menu
        menuBar = new javax.swing.JMenuBar();
        jmnuArchivo = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();
        jmnuClientes = new javax.swing.JMenu();
        itemNuevoCliente = new javax.swing.JMenuItem();
        jmnuEstado = new javax.swing.JMenu();
        itemOnline = new javax.swing.JCheckBoxMenuItem();
        itemOffline = new javax.swing.JCheckBoxMenuItem();
        jmnuExportar = new javax.swing.JMenu();
        itemExportarClientes = new javax.swing.JMenuItem();
        itemExportarOperaciones = new javax.swing.JMenuItem();
        jmnuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        separadorOpciones = new javax.swing.JSeparator();
        jmnuTemas = new javax.swing.JMenu();
        itemDefecto = new javax.swing.JCheckBoxMenuItem();
        itemSecundario = new javax.swing.JCheckBoxMenuItem();
        jmnuInformacion = new javax.swing.JMenu();
        itemAcerca = new javax.swing.JMenuItem();
        itemGuiaUso = new javax.swing.JMenuItem();
        // Pop menu Tabla Operaciones
        popMenu = new javax.swing.JPopupMenu();
        menupop = new javax.swing.JMenu();
        jbtFinalizada = new javax.swing.JMenuItem();
        jbtPendiente = new javax.swing.JMenuItem();

        // Pop menu Tabla Operaciones
        popMenuClientes = new javax.swing.JPopupMenu();
        menupopClientes = new javax.swing.JMenu();
        jbtOperacion = new javax.swing.JMenuItem();
        jbtNota = new javax.swing.JMenuItem();

        // Otros
        colorPaneles = new java.awt.Color(143, 238, 249);

        // Propiedades del menu
        jmnuArchivo.setText("Archivo");
        jmnuArchivo.setMnemonic('A');
        itemSalir.setText("Salir");
        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.KeyEvent.CTRL_MASK));
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        jmnuClientes.setText("Clientes");
        jmnuClientes.setMnemonic('C');
        itemNuevoCliente.setText("Nuevo cliente");
        itemNuevoCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.KeyEvent.CTRL_MASK));
        itemNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoClienteActionPerformed(evt);
            }
        });
        jmnuEstado.setText("Estado");
        //jmnuEstado.setMnemonic('E');
        itemOnline.setText("Conectar");
        itemOnline.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOnlineActionPerformed(evt);
            }
        });
        itemOffline.setText("Offline");
        itemOffline.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOfflineActionPerformed(evt);
            }
        });
        jmnuExportar.setText("Exportar");
        jmnuExportar.setMnemonic('E');
        itemExportarClientes.setText("Todos los clientes");
        itemExportarClientes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportarClientesActionPerformed(evt);
            }
        });
        itemExportarOperaciones.setText("Todas las operaciones");
        itemExportarOperaciones.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportarAllOperacionesActionPerformed(evt);
            }
        });
        jmnuOpciones.setText("Opciones");
        jmnuOpciones.setMnemonic('O');
        itemNuevo.setText("Nuevo..");
        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.KeyEvent.CTRL_MASK));
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        jmnuTemas.setText("Temas");
        itemDefecto.setText("Principal");
        itemDefecto.setSelected(true);
        itemDefecto.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDefectoActionPerformed(evt);
            }
        });
        itemSecundario.setText("Secundario");
        itemSecundario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSecundarioActionPerformed(evt);
            }
        });
        jmnuInformacion.setText("Información");
        jmnuInformacion.setMnemonic('I');
        itemAcerca.setText("Acerca de...");
        itemAcerca.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaActionPerformed(evt);
            }
        });
        itemGuiaUso.setText("Guía de uso");
        itemGuiaUso.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuiaUsoActionPerformed(evt);
            }
        });

        // Enlazando componentes del menu
        jmnuArchivo.add(itemSalir);
        jmnuClientes.add(itemNuevoCliente);
        jmnuEstado.add(itemOnline);
        jmnuEstado.add(itemOffline);
        jmnuExportar.add(itemExportarClientes);
        jmnuExportar.add(itemExportarOperaciones);
        //jmnuOpciones.add(itemNuevo);
        //jmnuOpciones.add(separadorOpciones);
        jmnuOpciones.add(jmnuTemas);
        jmnuTemas.add(itemDefecto);
        jmnuTemas.add(itemSecundario);
        jmnuInformacion.add(itemAcerca);
        jmnuInformacion.add(itemGuiaUso);

        menuBar.add(jmnuArchivo);
        menuBar.add(jmnuClientes);
        //menuBar.add(jmnuEstado);
        menuBar.add(jmnuExportar);
        menuBar.add(jmnuOpciones);
        menuBar.add(jmnuInformacion);

        this.getRootPane().setJMenuBar(menuBar);

        // Pop Menú tabla operaciones
        menupop.setText("Cambiar estado...");
        jbtFinalizada.setText("Finalizada");
        jbtFinalizada.setEnabled(false);
        jbtFinalizada.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcambiarEstadoOperacionActionPerformed(evt, "Finalizada");
            }
        });
        jbtPendiente.setText("Pendiente");
        jbtPendiente.setEnabled(false);
        jbtPendiente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcambiarEstadoOperacionActionPerformed(evt, "Pendiente");
            }
        });
        menupop.add(jbtFinalizada);
        menupop.add(jbtPendiente);
        popMenu.add(menupop);

        // Pop Menú tabla clientes
        menupopClientes.setText("Nueva...");
        jbtOperacion.setText("Operación");
        jbtOperacion.setEnabled(false);
        jbtOperacion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOperacionActionPerformed(evt);
            }
        });
        jbtNota.setText("Nota");
        jbtNota.setEnabled(false);
        jbtNota.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNotaActionPerformed(evt);
            }
        });
        menupopClientes.add(jbtOperacion);
        menupopClientes.add(jbtNota);
        popMenuClientes.add(menupopClientes);

        // Controles
        panelOperacion.setLayout(null);
        panelOperacion.setBackground(colorPaneles);
        panelClientes.setLayout(null);
        panelClientes.setBackground(colorPaneles);
        panelRegistros.setLayout(null);
        panelRegistros.setBackground(colorPaneles);
        panelCitas.setLayout(new java.awt.GridLayout(1, 1));
        panelCitas.setBackground(colorPaneles);
        panelBusqueda.setLayout(null);
        panelBusqueda.setBackground(colorPaneles);
        panelGraficos.setLayout(null);
        panelGraficos.setBackground(colorPaneles);
        panelFacturas.setLayout(null);
        panelFacturas.setBackground(colorPaneles);
        tabbedPanel.setBounds(10, 10, 900, 900);
        tabbedPanel.setBackground(java.awt.Color.BLUE);
        tabbedPanel.add("Clientes", panelClientes);
        tabbedPanel.add("Operaciones", panelOperacion);
        tabbedPanel.add("Notas", panelCitas);
        //tabbedPanel.add("Registros", panelRegistros);
        //tabbedPanel.add("Búsqueda", panelBusqueda);
        //tabbedPanel.add("Gráficos", panelGraficos);
        //tabbedPanel.add("Facturas", panelFacturas);

        // Añadiendo componentes al formulario
        this.getContentPane().add(tabbedPanel);

        // -------------------------------------------------------------------------------------------------------
        // --------------------------------PANEL CLIENTES---------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------
        iconoAgregarCliente = new javax.swing.ImageIcon("Imagenes/panelClientes/addCliente.png");
        iconoBusqueda = new javax.swing.ImageIcon("Imagenes/panelClientes/buscar.png");
        iconoModificarCliente = new javax.swing.ImageIcon("Imagenes/panelClientes/modificarCliente.png");
        iconoEliminarCliente = new javax.swing.ImageIcon("Imagenes/panelClientes/borrarCliente.png");
        jpanelOperacionesClientes = new javax.swing.JPanel();
        jpanelIconos = new javax.swing.JPanel();
        jpanelClientes = new javax.swing.JPanel();
        jpanelNotasClientes = new javax.swing.JPanel();
        jpanelNotasDelCliente = new javax.swing.JPanel();
        tablaClientes = new javax.swing.JTable();
        tablaOperaciones = new javax.swing.JTable();
        grupoBusqueda = new javax.swing.ButtonGroup();
        jcheckDni = new javax.swing.JCheckBox();
        jcheckApellido = new javax.swing.JCheckBox();
        jcheckTelefono = new javax.swing.JCheckBox();
        jbtAgregarCliente = new javax.swing.JButton(iconoAgregarCliente);
        jbtTotalClientes = new javax.swing.JButton(new javax.swing.ImageIcon("Imagenes/panelClientes/allClientes.png"));
        jbtBusqueda = new javax.swing.JButton(iconoBusqueda);
        jbtModificarCliente = new javax.swing.JButton(iconoModificarCliente);
        jbtEliminarCliente = new javax.swing.JButton(iconoEliminarCliente);
        jbtReportarDatosCliente = new javax.swing.JButton();
        jbtExportarClientesCsv = new javax.swing.JButton();
        jbtModificarOperacion = new javax.swing.JButton();
        jbtBuscarOperacion = new javax.swing.JButton();
        jbtFacturaOperacion = new javax.swing.JButton();
        jbtExportarOperaciones = new javax.swing.JButton();
        jbtAgregarNota = new javax.swing.JButton();
        jbtEliminarNota = new javax.swing.JButton();
        jbtModificarNota = new javax.swing.JButton();
        jbtEliminarOperacion = new javax.swing.JButton();
        jtxtBusqueda = new javax.swing.JTextField();
        scrollPanel = new javax.swing.JScrollPane();
        scrollTablaOperaciones = new javax.swing.JScrollPane();
        scrollNotasClientes = new javax.swing.JScrollPane();

        // Propiedades
        jpanelIconos.setLayout(new java.awt.GridLayout(1, 3, 2, 0));
        jpanelIconos.setBackground(colorPaneles);
        jpanelIconos.setBounds(20, 20, 450, 150);
        jpanelClientes.setLayout(null);
        jpanelClientes.setBackground(colorPaneles);
        jpanelClientes.setBounds(20, 200, 550, 580);
        jpanelClientes.setBorder(new javax.swing.border.TitledBorder("Clientes registrados"));
        jpanelOperacionesClientes.setLayout(null);
        jpanelOperacionesClientes.setBackground(colorPaneles);
        jpanelOperacionesClientes.setBounds(600, 20, 550, 500);
        jpanelOperacionesClientes.setBorder(new javax.swing.border.TitledBorder("Operaciones de clientes"));
        jpanelNotasClientes.setLayout(null);
        jpanelNotasClientes.setBackground(colorPaneles);
        jpanelNotasClientes.setBounds(600, 530, 550, 250);
        jpanelNotasClientes.setBorder(new javax.swing.border.TitledBorder("Notas de clientes"));
        jpanelNotasDelCliente.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 5));
        jpanelNotasDelCliente.setBackground(colorPaneles);
        scrollNotasClientes.setBounds(20, 30, 510, 158);
        scrollNotasClientes.setViewportView(jpanelNotasDelCliente);
        scrollNotasClientes.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jbtAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoClienteActionPerformed(evt);
            }
        });
        jbtAgregarCliente.setToolTipText("Nuevo cliente");
        jbtEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarClienteActionPerformed(evt);
            }
        });
        jbtEliminarCliente.setToolTipText("Eliminar cliente");
        jbtModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModificarClientesActionPerformed(evt);
            }
        });
        jbtModificarCliente.setToolTipText("Modificar cliente");
        jbtTotalClientes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteEspecifico = false;
                busquedafecha = false;
                jbtOperacion.setEnabled(false);
                jbtNota.setEnabled(false);
                jbtBuscarOperacion.setText("Buscar..");
                initTable();
                initNotas();
                repaint();
            }
        });
        jbtTotalClientes.setToolTipText("Reiniciar tablas");

        java.awt.Font fuentecheck = new java.awt.Font("Georgia", java.awt.Font.BOLD, 12);
        jcheckDni.setText("DNI");
        jcheckDni.setBounds(30, 30, 100, 30);
        jcheckDni.setFont(fuentecheck);
        jcheckDni.setSelected(true);
        jcheckDni.addItemListener(itemlistener);
        jcheckApellido.setText("PRIMER APELLIDO");
        jcheckApellido.setBounds(180, 30, 150, 30);
        jcheckApellido.setFont(fuentecheck);
        jcheckApellido.addItemListener(itemlistener);
        jcheckTelefono.setText("TELÉFONO");
        jcheckTelefono.setBounds(420, 30, 100, 30);
        jcheckTelefono.setFont(fuentecheck);
        jcheckTelefono.addItemListener(itemlistener);
        grupoBusqueda.add(jcheckDni);
        grupoBusqueda.add(jcheckApellido);
        grupoBusqueda.add(jcheckTelefono);
        jtxtBusqueda.setBounds(30, 80, 300, 30);
        jtxtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBusquedaKeyPerformed(evt);
            }
        });

        scrollPanel.setBounds(20, 120, 510, 400);

        jbtReportarDatosCliente.setText("Datos del cliente");
        jbtReportarDatosCliente.setBounds(40, 530, 200, 30);
        jbtReportarDatosCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtReportarDatosClienteActionPerformed(evt);
            }
        });
        jbtExportarClientesCsv.setText("Exportar tabla");
        jbtExportarClientesCsv.setBounds(300, 530, 200, 30);
        jbtExportarClientesCsv.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportarActionPerformed(evt);
            }
        });

        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesClickedEvent(evt);
            }
        });

        panelClientes.add(jpanelIconos);
        panelClientes.add(jpanelClientes);
        panelClientes.add(jpanelOperacionesClientes);
        panelClientes.add(jpanelNotasClientes);
        jpanelNotasClientes.add(scrollNotasClientes);

        jpanelIconos.add(jbtAgregarCliente);
        jpanelIconos.add(jbtModificarCliente);
        jpanelIconos.add(jbtEliminarCliente);
        jpanelIconos.add(jbtTotalClientes);

        scrollPanel.setViewportView(tablaClientes);
        jpanelClientes.add(scrollPanel);
        jpanelClientes.add(jcheckDni);
        jpanelClientes.add(jcheckApellido);
        jpanelClientes.add(jcheckTelefono);
        jpanelClientes.add(jtxtBusqueda);
        jpanelClientes.add(jbtExportarClientesCsv);
        jpanelClientes.add(jbtReportarDatosCliente);

        // --------------------------------------- OPERACIONES ---------------------------------------------
        scrollTablaOperaciones.setBounds(20, 40, 510, 400);
        scrollTablaOperaciones.setViewportView(tablaOperaciones);
        //jbtModificarOperacion.setBounds(20, 450, 100, 30);
        jbtModificarOperacion.setText("Modificar");
        jbtModificarOperacion.setEnabled(false);
        jbtBuscarOperacion.setBounds(20, 450, 150, 30);
        jbtBuscarOperacion.setText("Buscar..");
        jbtBuscarOperacion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarOperacionActionPerformed(evt);
            }
        });
        jbtEliminarOperacion.setBounds(200, 450, 150, 30);
        jbtEliminarOperacion.setText("Eliminar");
        //jbtEliminarOperacion.setEnabled(false);
        jbtEliminarOperacion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarOperacionActionPerformed(evt);
            }
        });
        jbtExportarOperaciones.setBounds(380, 450, 150, 30);
        jbtExportarOperaciones.setText("Exportar tabla");
        jbtExportarOperaciones.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportarOperacionesActionPerformed(evt);
            }
        });
        tablaOperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOperacionesMouseClicked(evt);
            }
        });

        jpanelOperacionesClientes.add(scrollTablaOperaciones);
        jpanelOperacionesClientes.add(jbtModificarOperacion);
        jpanelOperacionesClientes.add(jbtBuscarOperacion);
        jpanelOperacionesClientes.add(jbtEliminarOperacion);
        jpanelOperacionesClientes.add(jbtExportarOperaciones);

        initTable();

        // --------------------------------------- NOTAS ---------------------------------------------
        jbtAgregarNota.setText("Nueva..");
        //jbtAgregarNota.setBounds(20, 200, 150, 30);
        jbtEliminarNota.setText("Eliminar");
        jbtEliminarNota.setBounds(200, 200, 150, 30);
        jbtEliminarNota.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarNotaActionPerformed(evt);
            }
        });
        jbtModificarNota.setText("Modificar");
        //jbtModificarNota.setBounds(200, 200, 150, 30);

        jpanelNotasClientes.add(jbtAgregarNota);
        jpanelNotasClientes.add(jbtEliminarNota);
        jpanelNotasClientes.add(jbtModificarNota);
        initNotas();

        // -------------------------------------------------------------------------------------------------------
        // --------------------------------PANEL NOTAS------------------------------------------------------
        // ------------------------------------------------------------------------------------------------------- 
        panelDatosCliente = new javax.swing.JPanel();
        lblbuscardni = new javax.swing.JLabel();
        jtxtbuscardni = new javax.swing.JTextField();
        lblnombreclientenota = new javax.swing.JLabel();
        lblapellidosclientenota = new javax.swing.JLabel();
        lbldniclientenota = new javax.swing.JLabel();
        jbtbuscardni = new javax.swing.JButton();
        jbtGuardarNota = new javax.swing.JButton();
        jtxtareaNota = new javax.swing.JTextArea();

        panelDatosCliente.setLayout(null);
        panelDatosCliente.setBackground(colorPaneles);
        panelDatosCliente.setBorder(new javax.swing.border.TitledBorder("Formulario para la nueva nota"));
        lblbuscardni.setText("DNI Cliente: ");
        lblbuscardni.setFont(lblFont);
        lblbuscardni.setBounds(20, 80, 150, 30);
        jtxtbuscardni.setBounds(130, 80, 150, 30);
        jbtbuscardni.setText("Validar DNI");
        jbtbuscardni.setBounds(300, 80, 150, 30);
        jbtbuscardni.setFont(lblFont);
        jbtbuscardni.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtbuscardniActionPerformed(evt);
            }
        });
        lblnombreclientenota.setText("");
        lblnombreclientenota.setBounds(550, 80, 200, 30);
        lblnombreclientenota.setFont(lblFont);
        lblapellidosclientenota.setText("");
        lblapellidosclientenota.setBounds(750, 80, 200, 30);
        lblapellidosclientenota.setFont(lblFont);
        lbldniclientenota.setText("");
        lbldniclientenota.setBounds(1050, 80, 200, 30);
        lbldniclientenota.setFont(lblFont);
        jtxtareaNota.setWrapStyleWord(true);
        jtxtareaNota.setLineWrap(true);
        jtxtareaNota.setBounds(20, 170, 1140, 550);
        jbtGuardarNota.setText("Guardar nota");
        jbtGuardarNota.setEnabled(false);
        jbtGuardarNota.setBounds(960, 740, 200, 30);
        jbtGuardarNota.setFont(lblFont);
        jbtGuardarNota.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarNotaActionPerformed(evt);
            }
        });

        panelCitas.add(panelDatosCliente);
        panelDatosCliente.add(lblbuscardni);
        panelDatosCliente.add(jtxtbuscardni);
        panelDatosCliente.add(lblnombreclientenota);
        panelDatosCliente.add(lblapellidosclientenota);
        panelDatosCliente.add(lbldniclientenota);
        panelDatosCliente.add(jbtbuscardni);
        panelDatosCliente.add(jbtGuardarNota);
        panelDatosCliente.add(jtxtareaNota);

        // -------------------------------------------------------------------------------------------------------
        // --------------------------------PANEL OPERACIONES------------------------------------------------------
        // ------------------------------------------------------------------------------------------------------- 
        jpanelCliente = new javax.swing.JPanel();
        jpanelServicio = new javax.swing.JPanel();
        lblbusqueda = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapellidos = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        lbldni = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblobservaciones = new javax.swing.JLabel();
        lbltiposervicio = new javax.swing.JLabel();
        lblsistemapago = new javax.swing.JLabel();
        lblimporte = new javax.swing.JLabel();
        lblestadooperacion = new javax.swing.JLabel();
        lblobservacionesoperacion = new javax.swing.JLabel();
        jtxtbusquedadni = new javax.swing.JTextField();
        jtxtnombre = new javax.swing.JTextField();
        jtxtapellidos = new javax.swing.JTextField();
        jtxttelefono = new javax.swing.JTextField();
        jtxtdni = new javax.swing.JTextField();
        jtxtemail = new javax.swing.JTextField();
        jtxtobservaciones = new javax.swing.JTextField();
        jtxtimporte = new javax.swing.JTextField();
        comboservicio = new javax.swing.JComboBox<String>();
        combosistemapago = new javax.swing.JComboBox<String>();
        grupoestado = new javax.swing.ButtonGroup();
        radiofinalizada = new javax.swing.JRadioButton();
        radiopendiente = new javax.swing.JRadioButton();
        jtxtareaobservaciones = new javax.swing.JTextArea();
        jtxtareaobservacionesoperacion = new javax.swing.JTextArea();
        jbtaceptar = new javax.swing.JButton();
        jbtultimaoperacion = new javax.swing.JButton();
        jbtnuevoservicio = new javax.swing.JButton(new javax.swing.ImageIcon("Imagenes/panelOperaciones/nuevoServicio.png"));
        jbteliminarservicio = new javax.swing.JButton(new javax.swing.ImageIcon("Imagenes/panelOperaciones/eliminarServicio.png"));
        jbtguardar = new javax.swing.JButton();

        jpanelCliente.setBounds(20, 20, 1140, 400);
        jpanelCliente.setBorder(new javax.swing.border.TitledBorder("Datos del cliente"));
        jpanelCliente.setBackground(colorPaneles);
        jpanelCliente.setLayout(null);
        jpanelServicio.setBounds(20, 440, 1140, 300);
        jpanelServicio.setBorder(new javax.swing.border.TitledBorder("Datos del servicio"));
        jpanelServicio.setBackground(colorPaneles);
        jpanelServicio.setLayout(null);
        jbtguardar.setText("GUARDAR OPERACIÓN");
        jbtguardar.setBounds(910, 750, 250, 30);
        jbtguardar.setFont(lblFont);
        jbtguardar.setEnabled(false);
        jbtguardar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtguardarActionPerformed(evt);
            }
        });

        lblbusqueda.setText("DNI del cliente: ");
        lblbusqueda.setBounds(30, 50, 200, 30);
        lblbusqueda.setFont(lblFont);
        jtxtbusquedadni.setBounds(160, 50, 250, 30);
        jbtaceptar.setText("Validar DNI");
        jbtaceptar.setBounds(430, 50, 150, 30);
        jbtaceptar.setFont(lblFont);
        jbtaceptar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtaceptarActionPerformed(evt);
            }
        });
        lblnombre.setText("Nombre del cliente: ");
        lblnombre.setFont(lblFont);
        lblnombre.setBounds(30, 150, 150, 30);
        jtxtnombre.setBounds(200, 150, 150, 30);
        jtxtnombre.setEditable(false);
        lblapellidos.setText("Apellidos del cliente: ");
        lblapellidos.setFont(lblFont);
        lblapellidos.setBounds(390, 150, 250, 30);
        jtxtapellidos.setBounds(560, 150, 200, 30);
        jtxtapellidos.setEditable(false);
        lbltelefono.setText("Teléfono: ");
        lbltelefono.setFont(lblFont);
        lbltelefono.setBounds(800, 150, 150, 30);
        jtxttelefono.setBounds(900, 150, 200, 30);
        jtxttelefono.setEditable(false);
        lbldni.setText("DNI del cliente: ");
        lbldni.setFont(lblFont);
        lbldni.setBounds(30, 230, 150, 30);
        jtxtdni.setBounds(200, 230, 150, 30);
        jtxtdni.setEditable(false);
        lblemail.setText("Correo electrónico: ");
        lblemail.setFont(lblFont);
        lblemail.setBounds(390, 230, 150, 30);
        jtxtemail.setBounds(560, 230, 300, 30);
        jtxtemail.setEditable(false);
        jbtultimaoperacion.setText("Última operación");
        jbtultimaoperacion.setEnabled(false);
        jbtultimaoperacion.setBounds(900, 230, 200, 30);
        jbtultimaoperacion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtultimaoperacionActionPerformed(evt);
            }
        });
        lblobservaciones.setText("Observaciones: ");
        lblobservaciones.setFont(lblFont);
        lblobservaciones.setBounds(30, 320, 200, 30);
        jtxtareaobservaciones.setBounds(200, 280, 900, 100);
        jtxtareaobservaciones.setEditable(false);
        jtxtareaobservaciones.setLineWrap(true);
        jtxtareaobservaciones.setWrapStyleWord(true);

        lbltiposervicio.setText("Tipo de servicio: ");
        lbltiposervicio.setFont(lblFont);
        lbltiposervicio.setBounds(30, 100, 150, 30);
        comboservicio.setBounds(180, 100, 250, 30);
        comboservicio.setEditable(false);
        comboservicio.setFont(lblFont);
        comboservicio.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboservicioItemStateChanged(evt);
            }
        });
        jbtnuevoservicio.setBounds(440, 100, 30, 30);
        jbtnuevoservicio.setToolTipText("Nuevo servicio");
        jbtnuevoservicio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnuevoservicioActionPerformed(evt);
            }
        });
        jbteliminarservicio.setBounds(480, 100, 30, 30);
        jbteliminarservicio.setToolTipText("Eliminar servicio");
        jbteliminarservicio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbteliminarservicioActionPerformed(evt);
            }
        });
        lblsistemapago.setText("Método de pago: ");
        lblsistemapago.setFont(lblFont);
        lblsistemapago.setBounds(600, 50, 150, 30);
        combosistemapago.setEditable(false);
        combosistemapago.setFont(lblFont);
        combosistemapago.setBounds(750, 50, 150, 30);
        combosistemapago.addItem("Efectivo");
        combosistemapago.addItem("Tarjeta");
        combosistemapago.addItem("Bizum");
        combosistemapago.addItem("Transferencia");
        combosistemapago.addItem("PayPal");
        lblimporte.setText("Importe del servicio: ");
        lblimporte.setFont(lblFont);
        lblimporte.setBounds(600, 100, 250, 30);
        jtxtimporte.setBounds(780, 100, 120, 30);
        jtxtimporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtimporte.setText("0.00");
        lblestadooperacion.setText("Estado de la operación");
        lblestadooperacion.setFont(lblFont);
        lblestadooperacion.setBounds(100, 160, 200, 30);
        radiofinalizada.setText("Finalizada");
        radiofinalizada.setBounds(140, 190, 150, 50);
        radiopendiente.setText("Pendiente");
        radiopendiente.setBounds(140, 230, 150, 50);
        radiopendiente.setSelected(true);
        grupoestado.add(radiofinalizada);
        grupoestado.add(radiopendiente);
        lblobservacionesoperacion.setText("Observaciones: ");
        lblobservacionesoperacion.setFont(lblFont);
        lblobservacionesoperacion.setBounds(350, 160, 200, 30);
        jtxtareaobservacionesoperacion.setBounds(500, 170, 600, 100);
        jtxtareaobservacionesoperacion.setLineWrap(true);
        jtxtareaobservacionesoperacion.setWrapStyleWord(true);

        // Añadiendo al panel
        panelOperacion.add(jpanelCliente);
        panelOperacion.add(jpanelServicio);
        panelOperacion.add(jbtguardar);

        jpanelCliente.add(lblbusqueda);
        jpanelCliente.add(jtxtbusquedadni);
        jpanelCliente.add(jbtaceptar);
        jpanelCliente.add(lblnombre);
        jpanelCliente.add(jtxtnombre);
        jpanelCliente.add(lblapellidos);
        jpanelCliente.add(jtxtapellidos);
        jpanelCliente.add(lbltelefono);
        jpanelCliente.add(jtxttelefono);
        jpanelCliente.add(lbldni);
        jpanelCliente.add(jtxtdni);
        jpanelCliente.add(lblemail);
        jpanelCliente.add(jtxtemail);
        jpanelCliente.add(jbtultimaoperacion);
        jpanelCliente.add(lblobservaciones);
        jpanelCliente.add(jtxtareaobservaciones);

        jpanelServicio.add(lbltiposervicio);
        jpanelServicio.add(comboservicio);
        jpanelServicio.add(lblsistemapago);
        jpanelServicio.add(combosistemapago);
        jpanelServicio.add(jbtnuevoservicio);
        jpanelServicio.add(jbteliminarservicio);
        jpanelServicio.add(lblimporte);
        jpanelServicio.add(jtxtimporte);
        jpanelServicio.add(lblestadooperacion);
        jpanelServicio.add(radiofinalizada);
        jpanelServicio.add(radiopendiente);
        jpanelServicio.add(lblobservacionesoperacion);
        jpanelServicio.add(jtxtareaobservacionesoperacion);

        initServicios();

    }

    private void initServicios() {

        java.util.Vector<String> vectorDatos = new java.util.Vector<String>();
        vectorDatos = servicios.obtenerServicios();

        for (int i = 0; i < vectorDatos.size(); i++) {
            comboservicio.addItem(vectorDatos.get(i));
        }
    }

    public void initTable() {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        tablaClientes.setModel(modelo);
        tablaClientes.setModel(clientes.recuperarClientes(tablaClientes.getModel()));
        javax.swing.table.DefaultTableModel modeloOperaciones = new javax.swing.table.DefaultTableModel();
        tablaOperaciones.setModel(modeloOperaciones);
        tablaOperaciones.setModel(operaciones.obtenerOperaciones(tablaOperaciones.getModel()));
        this.tablaOperaciones.setDefaultRenderer(Object.class, new Controlador.micellrenderer());

        for (int i = 0; i < tablaClientes.getColumnCount(); i++) {
            Class<?> clase_columna = tablaClientes.getColumnClass(i);
            tablaClientes.setDefaultEditor(clase_columna, null);
        }

        for (int i = 0; i < tablaOperaciones.getColumnCount(); i++) {
            Class<?> clase_columna = tablaOperaciones.getColumnClass(i);
            tablaOperaciones.setDefaultEditor(clase_columna, null);
        }
    }

    private void tablaClientesClickedEvent(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            try {
                idcliente = Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
                initTableEspecifico(idcliente);
                initNotasEspecifico(idcliente);
                clienteEspecifico = true;
                busquedafecha = false;
                jbtBuscarOperacion.setText("Buscar en cliente");
                repaint();
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {

            }

        }
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            popMenuClientes.show(tablaClientes, evt.getX(), evt.getY());
            try {
                int opcion = Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
                if (opcion >= 0) {
                    jbtOperacion.setEnabled(true);
                    jbtNota.setEnabled(true);
                } else {
                    jbtOperacion.setEnabled(false);
                    jbtNota.setEnabled(false);
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException AIEX) {
            }

        }
    }

    public void initTableEspecifico(int idcliente) {
        javax.swing.table.DefaultTableModel modeloOperaciones = new javax.swing.table.DefaultTableModel();
        tablaOperaciones.setModel(modeloOperaciones);
        tablaOperaciones.setModel(operaciones.obtenerOperacionesDeCliente(tablaOperaciones.getModel(), idcliente));
        this.tablaOperaciones.setDefaultRenderer(Object.class, new Controlador.micellrenderer());

        for (int i = 0; i < tablaOperaciones.getColumnCount(); i++) {
            Class<?> clase_columna = tablaOperaciones.getColumnClass(i);
            tablaOperaciones.setDefaultEditor(clase_columna, null);
        }
    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    private void itemNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {
        new Modelo.newUser(this, true, colorPaneles).setVisible(true);
        initTable();
    }

    private void jbtEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {

        int opcion = 0;
        try {
            opcion = (Integer) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0);
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "No ha seleccionado ningún cliente a eliminar.", "Cliente desconocido", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int eleccion = javax.swing.JOptionPane.showConfirmDialog(null, "Si elimina el cliente todos sus datos incluyendo operaciones y notas desaparecerán, ¿Desea continuar?", "Eliminar cliente", javax.swing.JOptionPane.YES_NO_OPTION);
        if (eleccion == javax.swing.JOptionPane.NO_OPTION) {
            return;
        }

        try {
            if (clientes.eliminarCliente(opcion)) {
                operaciones.eliminarOperacionesDelCliente(opcion);
                notas.eliminarNotasDelCliente(opcion);
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito.", "Cliente eliminado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente.", "Error en la operación", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception ex) {

            return;
        }
        if (clienteEspecifico) {
            initTableEspecifico(idcliente);
            initNotasEspecifico(idcliente);
        } else {
            initTable();
            initNotas();
        }

        repaint();
    }

    private void jbtModificarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        int opcion = 0;
        java.util.Vector datos = new java.util.Vector<>();
        try {
            opcion = (Integer) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0);
            datos = clientes.obtenerDatosCliente(opcion);
            new Modelo.newUser(this, true, colorPaneles, datos).setVisible(true);
            initTable();
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "No ha seleccionado ningún cliente a modificar.", "Cliente desconocido", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }

    private void itemOnlineActionPerformed(java.awt.event.ActionEvent evt) {
        itemOnline.setText("Conectado");
        itemOnline.setEnabled(false);
        itemOnline.setSelected(true);
        itemOffline.setSelected(false);
        itemOffline.setEnabled(true);
    }

    private void itemOfflineActionPerformed(java.awt.event.ActionEvent evt) {
        itemOnline.setText("Conectar");
        itemOnline.setEnabled(true);
        itemOnline.setSelected(false);
        itemOffline.setEnabled(false);
        itemOffline.setSelected(true);
    }

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void itemAcercaActionPerformed(java.awt.event.ActionEvent evt) {
        String mensaje = "SOFTWARE DISEÑADO PARA KAMETZA SOLUCIONES \n\n";
        mensaje += "Este programa ha sido desarrollado como un proyecto de práctica, \n";
        mensaje += "por lo que puede contener errores de diseño y/o código. \n";
        mensaje += "Al ser un producto libre está prohibida su venta. \n";
        mensaje += "Para cualquier duda o consulta puede ponerse en contacto con el desarrollador: \n\n";
        mensaje += "Email: luisjose_ev@hotmail.com";
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, "Acerca de...", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean login() {
        boolean acceso = false;
        java.lang.String usuario = "", password = "";
        usuario = javax.swing.JOptionPane.showInputDialog(this, "Usuario: ");
        password = javax.swing.JOptionPane.showInputDialog(this, "Contraseña: ");
        if (usuario.compareTo("Mafer") == 0 && password.compareTo("Declejejo5") == 0) {
            return true;
        }
        return false;
    }

    private void itemDefectoActionPerformed(java.awt.event.ActionEvent evt) {
        colorPaneles = new java.awt.Color(143, 238, 249);
        itemSecundario.setSelected(false);
        actualizarColores(colorPaneles);
    }

    private void itemSecundarioActionPerformed(java.awt.event.ActionEvent evt) {
        colorPaneles = new java.awt.Color(250, 41, 243);
        itemDefecto.setSelected(false);
        actualizarColores(colorPaneles);
    }

    private void actualizarColores(java.awt.Color colorTema) {

        java.util.ArrayList<javax.swing.JPanel> listaPaneles = new java.util.ArrayList<javax.swing.JPanel>();
        listaPaneles.add(panelCitas);
        listaPaneles.add(panelBusqueda);
        listaPaneles.add(panelClientes);
        listaPaneles.add(panelGraficos);
        listaPaneles.add(panelOperacion);
        listaPaneles.add(panelRegistros);
        listaPaneles.add(panelFacturas);
        listaPaneles.add(jpanelIconos);
        listaPaneles.add(jpanelClientes);
        listaPaneles.add(jpanelOperacionesClientes);
        listaPaneles.add(jpanelNotasClientes);
        listaPaneles.add(jpanelNotasDelCliente);
        listaPaneles.add(jpanelCliente);
        listaPaneles.add(jpanelServicio);
        listaPaneles.add(panelDatosCliente);

        for (int i = 0; i < listaPaneles.size(); i++) {
            listaPaneles.get(i).setBackground(colorTema);
        }
    }

    private void jtxtBusquedaKeyPerformed(java.awt.event.KeyEvent evt) {
        String opcionBusqueda = "";
        String textoBusqueda = jtxtBusqueda.getText();
        javax.swing.table.TableModel modeloTabla = tablaClientes.getModel();
        if (jcheckDni.isSelected()) {
            opcionBusqueda = "numeroDocumento";
        } else if (jcheckApellido.isSelected()) {
            opcionBusqueda = "primerApellidoCliente";
        } else if (jcheckTelefono.isSelected()) {
            opcionBusqueda = "telefono";
        }
        tablaClientes.setModel(clientes.busquedaClientes(opcionBusqueda, textoBusqueda));
    }

    private void itemstatechanged(java.awt.event.ItemEvent evt) {
        jtxtBusqueda.setText("");
    }

    private void jbtExportarClientesActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser dlgGuardar = new javax.swing.JFileChooser();
        // Guardamos en una variable tipo int si el usuario acepta o no
        int opcion = dlgGuardar.showSaveDialog(this);
        // Variable donde almacenaremos la ruta
        String ruta = "";
        if (opcion == javax.swing.JFileChooser.APPROVE_OPTION) {
            ruta = dlgGuardar.getSelectedFile().getAbsolutePath();
            exportar.exportarTabla(ruta);
        } else {
            return;
        }
    }

    private void jbtExportarActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser dlgGuardar = new javax.swing.JFileChooser();
        // Guardamos en una variable tipo int si el usuario acepta o no
        int opcion = dlgGuardar.showSaveDialog(this);
        // Variable donde almacenaremos la ruta
        String ruta = "";
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaClientes.getModel();
        if (opcion == javax.swing.JFileChooser.APPROVE_OPTION) {
            ruta = dlgGuardar.getSelectedFile().getAbsolutePath();
            exportar.exportarTablaActual(ruta, modeloTabla);
        } else {
            return;
        }
    }

    private void jbtExportarAllOperacionesActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser dlgGuardar = new javax.swing.JFileChooser();
        // Guardamos en una variable tipo int si el usuario acepta o no
        int opcion = dlgGuardar.showSaveDialog(this);
        // Variable donde almacenaremos la ruta
        String ruta = "";
        if (opcion == javax.swing.JFileChooser.APPROVE_OPTION) {
            ruta = dlgGuardar.getSelectedFile().getAbsolutePath();
            exportar.exportarOperaciones(ruta);
        } else {
            return;
        }
    }

    private void jbtExportarOperacionesActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser dlgGuardar = new javax.swing.JFileChooser();
        // Guardamos en una variable tipo int si el usuario acepta o no
        int opcion = dlgGuardar.showSaveDialog(this);
        // Variable donde almacenaremos la ruta
        String ruta = "";
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaOperaciones.getModel();
        if (opcion == javax.swing.JFileChooser.APPROVE_OPTION) {
            ruta = dlgGuardar.getSelectedFile().getAbsolutePath();
            exportar.exportarTablaActual(ruta, modeloTabla);
        } else {
            return;
        }
    }

    private void jbtaceptarActionPerformed(java.awt.event.ActionEvent evt) {
        java.util.Vector datosCliente = new java.util.Vector<>();

        datosCliente = clientes.obtenerDatosCliente(clientes.obtenerIdCliente(jtxtbusquedadni.getText()));

        if (datosCliente.size() != 0) {
            jbtultimaoperacion.setEnabled(true);
            jtxtnombre.setText(datosCliente.get(1).toString());
            jtxtapellidos.setText(datosCliente.get(2).toString() + " " + datosCliente.get(3).toString());
            jtxttelefono.setText(datosCliente.get(18).toString());
            jtxtdni.setText(datosCliente.get(7).toString());
            jtxtemail.setText(datosCliente.get(22).toString());
            jtxtareaobservaciones.setText(datosCliente.get(24).toString());
            jbtguardar.setEnabled(true);
        } else {
            jbtguardar.setEnabled(false);
        }
    }

    private void jbtnuevoservicioActionPerformed(java.awt.event.ActionEvent evt) {
        new Modelo.newService(this, true, colorPaneles).setVisible(true);
        initTable();
        comboservicio.removeAllItems();
        initServicios();
    }

    private void jbteliminarservicioActionPerformed(java.awt.event.ActionEvent evt) {
        if (comboservicio.getSelectedItem() == null) {
            return;
        }
        servicios.borrarServicio(comboservicio.getSelectedItem().toString());
        comboservicio.removeAllItems();
        initServicios();
    }

    private void jbtguardarActionPerformed(java.awt.event.ActionEvent evt) {
        String estado = "";
        if (comboservicio.getSelectedItem() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ningún servicio seleccionado.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (radiofinalizada.isSelected()) {
            estado = "Finalizada";
        }
        if (radiopendiente.isSelected()) {
            estado = "Pendiente";
        }

        operaciones.guardarOperacion(jtxtdni.getText(), combosistemapago.getSelectedItem().toString(), comboservicio.getSelectedItem().toString(), estado, Double.parseDouble(jtxtimporte.getText()), jtxtareaobservacionesoperacion.getText());
        jtxtareaobservacionesoperacion.setText("");
        initTable();
    }

    private void comboservicioItemStateChanged(java.awt.event.ItemEvent evt) {
        try {
            jtxtimporte.setText(servicios.obtenerImporte(comboservicio.getSelectedItem().toString()));
        } catch (Exception ex) {
        }

    }

    private void jbtultimaoperacionActionPerformed(java.awt.event.ActionEvent evt) {
        if (jtxtdni.getText().compareTo("") == 0) {
            return;
        }
        String mensaje = "";
        java.util.Vector datosOperacion = new java.util.Vector<>();
        datosOperacion = null;
        datosOperacion = operaciones.ultimaOperación(clientes.obtenerIdCliente(jtxtdni.getText()));

        mensaje = "DATOS DE LA ÚLTIMA OPERACIÓN: \n\n";
        mensaje += "Operación realizada: " + datosOperacion.get(0) + ".\n";
        mensaje += "Método de pago: " + datosOperacion.get(1) + ".\n";
        mensaje += "Fecha: " + datosOperacion.get(2) + ".\n";
        mensaje += "Estado: " + datosOperacion.get(3) + ".\n";
        mensaje += "Importe: " + datosOperacion.get(4) + ".\n";
        mensaje += "Observaciones: " + datosOperacion.get(5) + ".\n";

        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Datos de última operación", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void jbtEliminarOperacionActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int idoperacion = Integer.parseInt(tablaOperaciones.getValueAt(tablaOperaciones.getSelectedRow(), 0).toString());
            operaciones.eliminarOperacion(idoperacion);
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna operación a eliminar.", "Operación no seleccionada", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        javax.swing.table.DefaultTableModel modeloOperaciones = new javax.swing.table.DefaultTableModel();
        tablaOperaciones.setModel(modeloOperaciones);
        if (clienteEspecifico && busquedafecha) {
            tablaOperaciones.setModel(operaciones.obtenerOperacionesDeClientePorFecha(tablaOperaciones.getModel(), fechabusqueda, idcliente));
        } else if (clienteEspecifico) {
            initTableEspecifico(idcliente);
        } else if (busquedafecha) {
            tablaOperaciones.setModel(operaciones.obtenerOperacionesTotalesPorFecha(tablaOperaciones.getModel(), fechabusqueda));
        } else {
            tablaOperaciones.setModel(operaciones.obtenerOperaciones(tablaOperaciones.getModel()));
        }

    }

    private void jbtBuscarOperacionActionPerformed(java.awt.event.ActionEvent evt) {
        fechabusqueda = javax.swing.JOptionPane.showInputDialog(this, "Inserte la fecha a buscar: 'año-mes-dia'");
        javax.swing.table.DefaultTableModel modeloOperaciones = new javax.swing.table.DefaultTableModel();
        tablaOperaciones.setModel(modeloOperaciones);
        busquedafecha = true;
        if (clienteEspecifico) {
            tablaOperaciones.setModel(operaciones.obtenerOperacionesDeClientePorFecha(tablaOperaciones.getModel(), fechabusqueda, idcliente));
        } else {
            tablaOperaciones.setModel(operaciones.obtenerOperacionesTotalesPorFecha(tablaOperaciones.getModel(), fechabusqueda));
        }

    }

    private void tablaOperacionesMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            try {
                int idoperacion = Integer.parseInt(tablaOperaciones.getValueAt(tablaOperaciones.getSelectedRow(), 0).toString());
                if (idoperacion != -1) {
                    jbtPendiente.setEnabled(true);
                    jbtFinalizada.setEnabled(true);
                    popMenu.show(tablaOperaciones, evt.getX(), evt.getY());
                } else {
                    jbtPendiente.setEnabled(false);
                    jbtFinalizada.setEnabled(false);
                    popMenu.show(tablaOperaciones, evt.getX(), evt.getY());
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                return;
            }
        }
        if (evt.getClickCount() == 2) {
            javax.swing.JTextArea textarea = new javax.swing.JTextArea();
            textarea.setWrapStyleWord(true);
            textarea.setEditable(false);
            //textarea.setLineWrap(true);
            String titulo = "";
            String texto = "DETALLES DE LA OPERACIÓN \n \n";
            String[] cabeceras = new String[]{"ID: ", "Nombre del cliente: ", "Número documento: ", "Método de pago: ", "Operación realizada: ", "Fecha: ", "Estado: ", "Importe: ", "Observaciones: "};
            try {
                int idoperacion = Integer.parseInt(tablaOperaciones.getValueAt(tablaOperaciones.getSelectedRow(), 0).toString());
                java.util.Vector vectordedatos = new java.util.Vector<>();
                vectordedatos = operaciones.obtenerDetallesOperacion(idoperacion);
                titulo = "ID: " + vectordedatos.get(0).toString();
                for (int i = 0; i < vectordedatos.size(); i++) {
                    texto += cabeceras[i] + vectordedatos.get(i) + "\n";
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                return;
            }
            textarea.setText(texto);
            javax.swing.JOptionPane.showMessageDialog(null, textarea, titulo, javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void jbtcambiarEstadoOperacionActionPerformed(java.awt.event.ActionEvent evt, String estado) {
        String texto = estado;
        try {
            int idoperacion = Integer.parseInt(tablaOperaciones.getValueAt(tablaOperaciones.getSelectedRow(), 0).toString());
            operaciones.actualizarEstado(estado, idoperacion);
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna operación.", "Operación no seleccionada", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        javax.swing.table.DefaultTableModel modeloOperaciones = new javax.swing.table.DefaultTableModel();
        tablaOperaciones.setModel(modeloOperaciones);
        if (clienteEspecifico && busquedafecha) {
            tablaOperaciones.setModel(operaciones.obtenerOperacionesDeClientePorFecha(tablaOperaciones.getModel(), fechabusqueda, idcliente));
        } else if (clienteEspecifico) {
            initTableEspecifico(idcliente);
        } else if (busquedafecha) {
            tablaOperaciones.setModel(operaciones.obtenerOperacionesTotalesPorFecha(tablaOperaciones.getModel(), fechabusqueda));
        } else {
            tablaOperaciones.setModel(operaciones.obtenerOperaciones(tablaOperaciones.getModel()));
        }

    }

    public void initNotas() {
        jpanelNotasDelCliente.removeAll();
        java.util.ArrayList<javax.swing.JTextArea> notasDeClientes = new java.util.ArrayList<javax.swing.JTextArea>();
        notasDeClientes = null;
        notasDeClientes = notas.notasClientes();
        for (int i = 0; i < notasDeClientes.size(); i++) {
            jpanelNotasDelCliente.add(notasDeClientes.get(i));
        }

    }

    public void initNotasEspecifico(int idcliente) {
        jpanelNotasDelCliente.removeAll();
        java.util.ArrayList<javax.swing.JTextArea> notasDeClientes = new java.util.ArrayList<javax.swing.JTextArea>();
        notasDeClientes = null;
        notasDeClientes = notas.notasClientesEspecifico(idcliente);
        for (int i = 0; i < notasDeClientes.size(); i++) {
            jpanelNotasDelCliente.add(notasDeClientes.get(i));
        }

    }

    private void jbtEliminarNotaActionPerformed(java.awt.event.ActionEvent evt) {
        if (idnota == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna nota a eliminar.", "Nota sin seleccionar", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            notas.eliminarNota(idnota);
            idnota = -1;
        }

        this.initNotas();
        repaint();
    }

    private void jbtNuevaNotaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jbtModificarNotaActionPerformed(java.awt.event.ActionEvent evt) {
        if (idnota == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna nota a modificar.", "Nota sin seleccionar", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {

            idnota = -1;
        }

    }

    private void jbtbuscardniActionPerformed(java.awt.event.ActionEvent evt) {
        java.util.Vector datosCliente = new java.util.Vector<>();

        datosCliente = clientes.obtenerDatosCliente(clientes.obtenerIdCliente(jtxtbuscardni.getText()));

        if (datosCliente.size() != 0) {
            lblnombreclientenota.setText(datosCliente.get(1).toString());
            lblapellidosclientenota.setText(datosCliente.get(2).toString() + " " + datosCliente.get(3).toString());
            lbldniclientenota.setText(datosCliente.get(7).toString());
            jbtGuardarNota.setEnabled(true);
        } else {
            lblnombreclientenota.setText("");
            lblapellidosclientenota.setText("");
            lbldniclientenota.setText("");
            jtxtareaNota.setText("");
            jbtGuardarNota.setEnabled(false);
        }
    }

    private void jbtGuardarNotaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            notas.insertarNota(lbldniclientenota.getText(), jtxtareaNota.getText());
            javax.swing.JOptionPane.showMessageDialog(null, "Nota guardada con éxito.", "Nota añadida", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jtxtareaNota.setText("");
        } catch (Exception ex) {

        }

        initNotas();
        repaint();
    }

    private void jbtOperacionActionPerformed(java.awt.event.ActionEvent evt) {
        tabbedPanel.setSelectedIndex(1);
        try {
            String dnicliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 3).toString();
            jtxtbusquedadni.setText(dnicliente);
            jbtaceptarActionPerformed(evt);
        } catch (java.lang.ArrayIndexOutOfBoundsException AIEX) {
        }
    }

    private void jbtNotaActionPerformed(java.awt.event.ActionEvent evt) {
        tabbedPanel.setSelectedIndex(2);
        try {
            String dnicliente = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 3).toString();
            jtxtbuscardni.setText(dnicliente);
            jbtbuscardniActionPerformed(evt);
        } catch (java.lang.ArrayIndexOutOfBoundsException AIEX) {
        }
    }

    private void jbtReportarDatosClienteActionPerformed(java.awt.event.ActionEvent evt) {
        int idcliente = 0;
        try {
            idcliente = Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "No ha seleccionado ningún cliente.", "Cliente no seleccionado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(Kametza.class.getResource("/Reportes/ClienteReport.jasper"));
            java.util.Map parametros = new java.util.HashMap<String, String>();
            parametros = clientes.fichaCliente(idcliente);
            int operacionesdelcliente = operaciones.operacionesdelcliente(idcliente);
            String operaciontotal = "" + operacionesdelcliente;
            parametros.put("operaciones", operaciontotal);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
            // Invocamos al jasperviewer que muestra el objeto jasperprint, (jp, false) el primer parametro es el jasperprint a mostrar y 
            // el segundo parametro dice que cuando se cierre el reporte no se cierre la aplicacion entera "false"
            JasperViewer jv = new JasperViewer(jp, false);
            jv.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void abrirarchivo(String archivo) {

        try {

            java.io.File objetofile = new java.io.File(archivo);
            java.awt.Desktop.getDesktop().open(objetofile);

        } catch (Exception ex) {

            System.out.println(ex);

        }

    }

    private void itemGuiaUsoActionPerformed(java.awt.event.ActionEvent evt) {
        abrirarchivo("Guia/GuiaDeUso.pdf");
    }

    public static void main(String[] args) {

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Kametza.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Kametza.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Kametza.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Kametza.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        new Kametza().setVisible(true);
    }

}
