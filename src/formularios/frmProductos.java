/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.*;
import static formularios.frmProveedores.tblProveedores;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ricky
 */
public class frmProductos extends javax.swing.JFrame {

    boolean estadoMenu=false; 
    JTableHeader tHeadVentas;
    
    public frmProductos() {
        initComponents();
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        tHeadVentas = tblProductos.getTableHeader();
        Font fuente = new Font("Tahoma", Font.BOLD, 12);
        tHeadVentas.setBackground(jpnBarraSuperior.getBackground());
        tHeadVentas.setForeground(Color.WHITE);
        tHeadVentas.setFont(fuente);

    }
    
    //METODO GENERAL PARA ENVIAR MENSAJES POR NOTIFICAICON DE FRMNOTIFICACION
    public void mensajeNotificacion(String mensaje, String tipo){
        if(tipo.equals("Error")){
        frmNotificacion not = new frmNotificacion();
        not.Mensaje(mensaje);
        not.setVisible(true);
        not.lblIcono.setIcon(new ImageIcon(getClass().getResource("/iconos/Error.png")));
        //not.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/eliminar.png")));
        }else if(tipo == "Ok"){
        frmNotificacion not = new frmNotificacion();
        not.Mensaje(mensaje);
        not.setVisible(true);
        not.lblIcono.setIcon(new ImageIcon(getClass().getResource("/iconos/Ok.png")));
        }else if(tipo == "Adv"){
        frmNotificacion not = new frmNotificacion();
        not.Mensaje(mensaje);
        not.setVisible(true);
        not.lblIcono.setIcon(new ImageIcon(getClass().getResource("/iconos/Adv.png")));
        }       
    }
    //--------------------llenando tabla de productos----------------
    
    public void tablaBuscarProductos(){
        String codBarra=txtProductosBuscar.getText();
        DefaultTableModel modeloProductos = new DefaultTableModel();
        ArrayList<Producto> productos = new ArrayList();
        Object[] fila = new Object[5];
        Object[] sucursales=new Object[4];
        if (codBarra.equals("")) {
            mensajeNotificacion("No ha introducido un código o nombre.", "Adv");
            
        }else{
            String[] campos = {"CodBarra", "Nombre", "Inventario", "Costo","Sucursal"};
            try {
                Sucursal opcionSucu;
                
                
                productos = ControladorProducto.Buscar(codBarra);
                modeloProductos.setColumnIdentifiers(campos);
                Iterator<Producto> prod = productos.iterator();
                
                
                
                while (prod.hasNext()) {
                    
                    fila[0] = prod.next();
                    fila[1] = prod.next();
                    fila[2] = prod.next();
                    fila[3] = prod.next();
                    fila[4] = prod.next();
                    
                    opcionSucu= ControladorSucursal.obtenerSucursal(Integer.parseInt(fila[4].toString()));
                    
                    
                    fila[4]=opcionSucu.getNombre();
                    
                    
                    modeloProductos.addRow(fila);
                    tblProductos.setModel(modeloProductos);
                }
                
            
                
                if (tblProductos.getRowCount()==0) {
                    mensajeNotificacion("¡Error! Ese producto no existe.", "Error");
                }
            } catch (ErrorTienda ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }
    
    
    //------------------------Extrayendo datos para comboboxSucursal-------------------
    public void llenandoComboboxSucursal(){
        Object[] seleccion=new Object[4];
        frmProductosModificar frmPm=new frmProductosModificar();
        
        try {
            ArrayList<Sucursal> misucu=ControladorSucursal.obtener();
            Iterator iterador=misucu.iterator();
            while(iterador.hasNext()){
                seleccion[0]=iterador.next();
                System.out.println(seleccion[0]);
                frmPm.modeloModificarSucursal.addElement(iterador.next());
                
                seleccion[2]=iterador.next();
                seleccion[3]=iterador.next();
            }
            
            frmPm.cmbModificarSucursal.setModel(frmPm.modeloModificarSucursal);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMenu = new javax.swing.JPanel();
        lblSucursales = new javax.swing.JLabel();
        lblProveedores = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        lblParametro = new javax.swing.JLabel();
        lblCompras = new javax.swing.JLabel();
        lblTipoPrecio = new javax.swing.JLabel();
        jpnBarraSuperior = new javax.swing.JPanel();
        lblBotonCerrar = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        home = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jpnCompras = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnNuevoProducto = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtProductosBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnMenu.setPreferredSize(new java.awt.Dimension(80, 304));
        jpnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnMenuMouseExited(evt);
            }
        });
        jpnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSucursales.setBackground(new java.awt.Color(0, 0, 0));
        lblSucursales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSucursales.setForeground(new java.awt.Color(255, 255, 255));
        lblSucursales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Sucursales.png"))); // NOI18N
        lblSucursales.setText("Sucursales");
        lblSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSucursalesMouseClicked(evt);
            }
        });
        jpnMenu.add(lblSucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 50));

        lblProveedores.setBackground(new java.awt.Color(0, 0, 0));
        lblProveedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProveedores.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Proveedores.png"))); // NOI18N
        lblProveedores.setText("Proveedores");
        lblProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProveedoresMouseClicked(evt);
            }
        });
        jpnMenu.add(lblProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, 50));

        lblProductos.setBackground(new java.awt.Color(0, 0, 0));
        lblProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/EProductos.png"))); // NOI18N
        lblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProductosMouseEntered(evt);
            }
        });
        jpnMenu.add(lblProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        lblVentas.setBackground(new java.awt.Color(0, 0, 0));
        lblVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ventas.png"))); // NOI18N
        lblVentas.setText("Ventas");
        lblVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasMouseClicked(evt);
            }
        });
        jpnMenu.add(lblVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 50));

        lblParametro.setBackground(new java.awt.Color(0, 0, 0));
        lblParametro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblParametro.setForeground(new java.awt.Color(255, 255, 255));
        lblParametro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblParametro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Parametro.png"))); // NOI18N
        lblParametro.setText("Parametro");
        lblParametro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParametro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblParametroMouseClicked(evt);
            }
        });
        jpnMenu.add(lblParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 50));

        lblCompras.setBackground(new java.awt.Color(0, 0, 0));
        lblCompras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCompras.setForeground(new java.awt.Color(255, 255, 255));
        lblCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Compras.png"))); // NOI18N
        lblCompras.setText("Compras");
        lblCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblComprasMouseClicked(evt);
            }
        });
        jpnMenu.add(lblCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 50));

        lblTipoPrecio.setBackground(new java.awt.Color(0, 0, 0));
        lblTipoPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTipoPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tipoPrecio.png"))); // NOI18N
        lblTipoPrecio.setText("Tipo Precio");
        lblTipoPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTipoPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTipoPrecioMouseClicked(evt);
            }
        });
        jpnMenu.add(lblTipoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 140, 50));

        getContentPane().add(jpnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 140, 360));

        jpnBarraSuperior.setBackground(new java.awt.Color(102, 0, 0));
        jpnBarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnBarraSuperiorMouseDragged(evt);
            }
        });
        jpnBarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnBarraSuperiorMousePressed(evt);
            }
        });
        jpnBarraSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/exit32.png"))); // NOI18N
        lblBotonCerrar.setToolTipText("Salir");
        lblBotonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCerrarMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(lblBotonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 30, 55));

        menu.setBackground(new java.awt.Color(85, 0, 0));
        menu.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu.setText("Menú");
        menu.setToolTipText("Menú");
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setIconTextGap(-5);
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuMouseExited(evt);
            }
        });
        jpnBarraSuperior.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 55));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setToolTipText("");
        jpnBarraSuperior.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 60, 60));

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Home.png"))); // NOI18N
        home.setToolTipText("Ir a Home");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 70, 55));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jpnBarraSuperior.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 10, 60));

        getContentPane().add(jpnBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        jpnCompras.setBackground(new java.awt.Color(0, 0, 0));
        jpnCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Productos");
        jpnCompras.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 12, -1, 30));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnCompras.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 20, 50));

        getContentPane().add(jpnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 50));

        tblProductos =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barra", "Nombre", "Inventario", "Costo", "Sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        tblProductos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblProductosInputMethodTextChanged(evt);
            }
        });
        tblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblProductosKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(tblProductos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 890, 260));

        btnNuevoProducto.setBackground(new java.awt.Color(0, 0, 0));
        btnNuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/nuevo3.png"))); // NOI18N
        btnNuevoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoProductoMouseExited(evt);
            }
        });
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 110, 30));

        btnBuscarProducto.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/buscar.png"))); // NOI18N
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarProductoMouseExited(evt);
            }
        });
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 110, 30));

        btnModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/modificar.png"))); // NOI18N
        btnModificarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarProductoMouseExited(evt);
            }
        });
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 610, 110, 30));

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/eliminar.png"))); // NOI18N
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarProductoMouseExited(evt);
            }
        });
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Listado de los Productos:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        txtProductosBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductosBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductosBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtProductosBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 430, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Producto a buscar:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1200, 10));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked


    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblProductosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblProductosInputMethodTextChanged

    }//GEN-LAST:event_tblProductosInputMethodTextChanged

    private void tblProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyTyped


    }//GEN-LAST:event_tblProductosKeyTyped

    private void btnNuevoProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProductoMouseEntered
        btnNuevoProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/nuevo3B.png")));
    }//GEN-LAST:event_btnNuevoProductoMouseEntered

    private void btnNuevoProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProductoMouseExited
        btnNuevoProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/nuevo3.png")));
    }//GEN-LAST:event_btnNuevoProductoMouseExited

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        frmProductosAgregar pa = new frmProductosAgregar();
        pa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnBuscarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProductoMouseEntered
        btnBuscarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/buscarB.png")));
    }//GEN-LAST:event_btnBuscarProductoMouseEntered

    private void btnBuscarProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProductoMouseExited
        btnBuscarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/buscar.png")));
    }//GEN-LAST:event_btnBuscarProductoMouseExited

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        tablaBuscarProductos();
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnModificarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarProductoMouseEntered
        btnModificarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/modificarB.png")));
    }//GEN-LAST:event_btnModificarProductoMouseEntered

    private void btnModificarProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarProductoMouseExited
        btnModificarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/modificar.png")));
    }//GEN-LAST:event_btnModificarProductoMouseExited

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        
        
        
        if(tblProductos.getSelectedRow()!=-1){
            int seleccion; 
            frmProductosModificar pm = new frmProductosModificar();
            pm.setVisible(true);
            this.setVisible(false);
            seleccion = tblProductos.getSelectedRow();
            pm.txtNuevoCodBarraProducto.setText(tblProductos.getValueAt(seleccion, 0).toString());
            pm.txtNuevoNombreProducto.setText((tblProductos.getValueAt(seleccion, 1).toString()));
            pm.txtNuevoCostoProducto.setText((tblProductos.getValueAt(seleccion, 3).toString()));
            pm.txtNuevoInventarioProducto.setText((tblProductos.getValueAt(seleccion, 2).toString()));
            
            
            pm.txtNuevoNombreProducto.requestFocus();
            pm.txtNuevoNombreProducto.selectAll();
        }else{
            mensajeNotificacion("¡Seleccione un dato de la tabla!", "Adv");
        }
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnEliminarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProductoMouseEntered
        btnEliminarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/eliminarB.png")));
    }//GEN-LAST:event_btnEliminarProductoMouseEntered

    private void btnEliminarProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProductoMouseExited
        btnEliminarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/eliminar.png")));
    }//GEN-LAST:event_btnEliminarProductoMouseExited

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int fila=tblProductos.getSelectedRow(); 
        if (tblProductos.isRowSelected(fila)) {
            
            if (fila>=0) {
                
            
            Producto eliminar=new Producto();
            ControladorProducto controlador=new ControladorProducto();
            DefaultTableModel modeloProductos=(DefaultTableModel) tblProductos.getModel();
            

            String codBarra=tblProductos.getValueAt(fila, 0).toString();
            String nombre=tblProductos.getValueAt(fila, 1).toString();
            int inventario=Integer.parseInt(tblProductos.getValueAt(fila, 2).toString());
            double costo=Double.parseDouble(tblProductos.getValueAt(fila, 3).toString());

            eliminar.setCodBarra(codBarra);
            eliminar.setNombre(nombre);
            eliminar.setInventario(inventario);
            eliminar.setCosto(costo);


            try {
                ControladorProducto.Eliminar(eliminar);
                if (ControladorProducto.isCambio()) {
                    mensajeNotificacion("¡Error! Producto con registros vigentes.", "Error");
                }else{
                    modeloProductos.removeRow(fila);
                    txtProductosBuscar.setText("");
                    mensajeNotificacion("¡Producto eliminado exitosamente!", "Ok");
                }
                
            } catch (ErrorTienda ex) {
                
            }
            }
        }else{
            mensajeNotificacion("¡Seleccione un Producto de la tabla!", "Adv");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void txtProductosBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductosBuscarKeyPressed
        char c=evt.getKeyChar();    
        if (c == (char) KeyEvent.VK_ENTER) {
            tablaBuscarProductos();
        }
    }//GEN-LAST:event_txtProductosBuscarKeyPressed

    private void txtProductosBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductosBuscarKeyTyped
        char mayu=evt.getKeyChar();      
         int c=(int) evt.getKeyChar();
        int limiteCaracteres=13;
        
         
         if ((c >=48 && c<=57) || (c>=65 && c<=90) || (c>=97 && c<=122) || (c==32) || (c==8) || (c== (char)KeyEvent.VK_ENTER)) {
             if (txtProductosBuscar.getText().length()==limiteCaracteres) {
                 getToolkit().beep();
                 evt.consume();
             }else if (Character.isLowerCase(mayu)) {
                     String cadena=(""+mayu).toUpperCase();
                     mayu=cadena.charAt(0);
                     evt.setKeyChar(mayu);
             }
        }else{
             evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
         }
    }//GEN-LAST:event_txtProductosBuscarKeyTyped

    private void lblBotonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblBotonCerrarMouseClicked

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        if(estadoMenu==true){
            Animacion.Animacion.subir(55, -360, 1, 2, jpnMenu);
            estadoMenu=false;
            Border empty;
            empty = BorderFactory.createEmptyBorder();
            menu.setBorder(empty);
            menu.setText("Menu");
        }else{
            Animacion.Animacion.bajar(-360, 55, 1, 2, jpnMenu);
            estadoMenu=true;
            Border raisedbevel;
            raisedbevel = BorderFactory.createRaisedBevelBorder();
            menu.setBorder(raisedbevel);
            menu.setText("Cerrar");
        }
    }//GEN-LAST:event_menuMouseClicked

    private void menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseExited

    }//GEN-LAST:event_menuMouseExited

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        frmHome home = new frmHome();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

    private void lblSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSucursalesMouseClicked
        frmSucursales sc = new frmSucursales();
        sc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblSucursalesMouseClicked

    private void lblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProveedoresMouseClicked
        frmProveedores pv = new frmProveedores();
        pv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblProveedoresMouseClicked

    private void lblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductosMouseClicked
        frmProductos pd = new frmProductos();
        pd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblProductosMouseClicked

    private void lblProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductosMouseEntered

    }//GEN-LAST:event_lblProductosMouseEntered

    private void lblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseClicked
        try {
            frmVentas vt = new frmVentas();
            vt.setVisible(true);
            this.setVisible(false);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblVentasMouseClicked

    private void lblParametroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParametroMouseClicked
        frmParametro pt = new frmParametro();
        pt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblParametroMouseClicked

    private void lblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprasMouseClicked
        frmCompras cm = new frmCompras();
        cm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblComprasMouseClicked

    private void jpnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnMenuMouseExited

    }//GEN-LAST:event_jpnMenuMouseExited

    private void lblTipoPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipoPrecioMouseClicked
        frmTipoPrecio tp = new frmTipoPrecio();
        tp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblTipoPrecioMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnCompras;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JLabel lblBotonCerrar;
    private javax.swing.JLabel lblCompras;
    private javax.swing.JLabel lblParametro;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblProveedores;
    private javax.swing.JLabel lblSucursales;
    private javax.swing.JLabel lblTipoPrecio;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel menu;
    public javax.swing.JTable tblProductos;
    public javax.swing.JTextField txtProductosBuscar;
    // End of variables declaration//GEN-END:variables
}
