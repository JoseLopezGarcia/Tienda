/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricky
 */
public class frmProductosAgregar extends javax.swing.JFrame {

    /**
     * Creates new form frmProductosAgregar
     */
    frmProductos formu=new frmProductos();
    DefaultComboBoxModel modeloSucursal = new DefaultComboBoxModel();
    private boolean cambioActualizacion=false;
    
    public frmProductosAgregar() {
        initComponents();
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        llenandoComboSucursal();
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
    
    //------------------------------------actualizar(inventario) si el producto a registrar ya existe------------------
   
        public void actualizarInventario(){
            Producto producto = new Producto();
            String[] sucus=new String[4];
            Object[] produ=new Object[5];
            
            producto.setCodBarra(txtCodBarraProductos.getText());
            producto.setNombre(txtNombreProductos.getText());
            producto.setCosto(Double.parseDouble(txtCostoProductos.getText()));
            producto.setInventario(Integer.parseInt(txtInventarioProducto.getText()));
            
            try {  //Para establecer el IdSucursal
                    ArrayList<Producto> opcion=ControladorProducto.Buscar(txtCodBarraProductos.getText());
                    Iterator iterador=opcion.iterator();
                    while(iterador.hasNext()){
                        produ[0]=iterador.next();
                        produ[1]=iterador.next();
                        produ[2]=iterador.next();
                        produ[3]=iterador.next();
                        produ[4]=iterador.next();
                        
                        ArrayList<Sucursal> miSucursal=ControladorSucursal.obtener();
                        
                        Iterator ite=miSucursal.iterator();
                        while (ite.hasNext()) {
                            sucus[0]=ite.next().toString();
                            sucus[1]=ite.next().toString();
                            sucus[2]=ite.next().toString();
                            sucus[3]=ite.next().toString();
                            
                            if (sucus[1].equals(cmbSucursal.getSelectedItem())) {
                                produ[4]=sucus[0];
                                System.out.println(produ[4]);
                                producto.setIdSucursal(Integer.parseInt(produ[4].toString()));
                            }
                            
                        }
                        
//                        if (miSucursal.getNombre().equals(cmbModificarSucursal.getSelectedItem().toString())) {
//                            System.out.println(miSucursal.getNombre());
//                            System.out.println(cmbModificarSucursal.getSelectedItem());
//                            producto.setIdSucursal(Integer.parseInt(produ[4].toString()));
//                            System.out.println(produ[4]);
//                        }else{
//                            System.out.println("La sucuarsal no es la misma");
//                        }
                    }
                    
                } catch (ErrorTienda ex) {
                    Logger.getLogger(frmProductosAgregar.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            try {
                ControladorProducto.Modificar(producto);
                mensajeNotificacion("¡Producto actualizado exitosamente!", "Ok");
            } catch (ErrorTienda ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
            //tblProveedores.removeAll();
            
            }
        
    
     //-----------------limpiando cajas de texto-------------------------
    public void limpiandoTxtProducto(){
        txtCodBarraProductos.setText("");
        txtNombreProductos.setText("");
        txtInventarioProducto.setText("");
        txtCostoProductos.setText("");
        formu.txtProductosBuscar.setText("");
        txtCodBarraProductos.requestFocus();
    }
    
    //------------------llenandoComboSucursal-------------------------
    public void llenandoComboSucursal(){
        cmbSucursal.removeAll();
        modeloSucursal.removeAllElements();
        Object[] opcionSucursales=new Object[4];
        
        try {
            ArrayList<Sucursal> sucursales=ControladorSucursal.obtener();
            Iterator iterador=sucursales.iterator();
            
            while(iterador.hasNext()){
                opcionSucursales[0]=iterador.next();
                modeloSucursal.addElement(iterador.next());
                opcionSucursales[2]=iterador.next();
                opcionSucursales[3]=iterador.next();
            }
            
            cmbSucursal.setModel(modeloSucursal);
            
            
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmProductosAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void tablaBuscarProductos(){
        String codBarra=txtCodBarraProductos.getText();
        
        ArrayList<Producto> productos = new ArrayList();
        Object[] fila = new Object[5];
        Object[] sucursales=new Object[4];
        if (codBarra.equals("")) {
            mensajeNotificacion("No ha introducido un código o nombre.", "Adv");
            
        }else{
            
            try {
                Sucursal opcionSucu;
                
                
                productos = ControladorProducto.Buscar(codBarra);
                
                Iterator<Producto> prod = productos.iterator();
                
                
                
                while (prod.hasNext()) {
                    
                    fila[0] = prod.next();
                    fila[1] = prod.next();
                    fila[2] = prod.next();
                    fila[3] = prod.next();
                    fila[4] = prod.next();
                    
                    opcionSucu= ControladorSucursal.obtenerSucursal(Integer.parseInt(fila[4].toString()));
                    
                    
                    fila[4]=opcionSucu.getNombre();
                    
                    if (fila[0].equals(codBarra)) {
                        cmbSucursal.removeAll();
                        modeloSucursal.removeAllElements();
                        txtNombreProductos.setText(fila[1].toString());
                        txtInventarioProducto.setText(fila[2].toString());
                        txtCostoProductos.setText(fila[3].toString());
                        
                        modeloSucursal.addElement(fila[4].toString());
                        cmbSucursal.setModel(modeloSucursal);
                        txtNombreProductos.setEditable(false);
                        txtCostoProductos.setEditable(false);
                        
                        cambioActualizacion=true;
                        
                        
                    }else{
                        llenandoComboSucursal();
                        txtNombreProductos.setText("");
                        txtCostoProductos.setText("");
                        txtInventarioProducto.setText("");
                        txtCostoProductos.setEditable(true);
                        txtNombreProductos.setEditable(true);
                        cambioActualizacion=false;
                    }
                    
                }
               
               
            } catch (ErrorTienda ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
         txtInventarioProducto.requestFocus();
         txtInventarioProducto.selectAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBarraSuperior = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblAtras = new javax.swing.JLabel();
        jpnCompras = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        btnAgregarNuevoProducto = new javax.swing.JButton();
        txtCodBarraProductos = new javax.swing.JTextField();
        txtNombreProductos = new javax.swing.JTextField();
        txtCostoProductos = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtInventarioProducto = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png")).getImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblLogo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 50, 50));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jpnBarraSuperior.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 60, 60));

        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atras.png"))); // NOI18N
        lblAtras.setToolTipText("Volver Atrás");
        lblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(lblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        getContentPane().add(jpnBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        jpnCompras.setBackground(new java.awt.Color(0, 0, 0));
        jpnCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnCompras.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 20, 50));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Agregar un Producto:");
        jpnCompras.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 12, -1, 30));

        getContentPane().add(jpnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 50));

        btnAgregarNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/agregar2.png"))); // NOI18N
        btnAgregarNuevoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarNuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarNuevoProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarNuevoProductoMouseExited(evt);
            }
        });
        btnAgregarNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevoProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, 110, 30));

        txtCodBarraProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarraProductosActionPerformed(evt);
            }
        });
        txtCodBarraProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodBarraProductosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodBarraProductosKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodBarraProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 220, 30));

        txtNombreProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductosActionPerformed(evt);
            }
        });
        txtNombreProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductosKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombreProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 270, 30));

        txtCostoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoProductosActionPerformed(evt);
            }
        });
        txtCostoProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoProductosKeyTyped(evt);
            }
        });
        getContentPane().add(txtCostoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 80, 30));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 0, 0));
        jLabel27.setText("Código de barra:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, 20));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Sucursal:");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, -1, 20));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Costo:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 60, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Inventario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, 20));

        txtInventarioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInventarioProductoActionPerformed(evt);
            }
        });
        txtInventarioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInventarioProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtInventarioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 60, 30));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Nombre:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, 20));

        cmbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 300, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        frmProductos pd = new frmProductos();
        pd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void btnAgregarNuevoProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarNuevoProductoMouseEntered
        btnAgregarNuevoProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/agregarB.png")));
    }//GEN-LAST:event_btnAgregarNuevoProductoMouseEntered

    private void btnAgregarNuevoProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarNuevoProductoMouseExited
        btnAgregarNuevoProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/agregar.png")));
    }//GEN-LAST:event_btnAgregarNuevoProductoMouseExited

    private void btnAgregarNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevoProductoActionPerformed
        Producto agregado=new Producto();
        String[] sucus=new String[4]; 
        
        if (cambioActualizacion) {
            actualizarInventario();
            limpiandoTxtProducto();
            llenandoComboSucursal();
            txtCodBarraProductos.requestFocus();
            txtCostoProductos.setEditable(true);
            txtNombreProductos.setEditable(true);
        }else{
      
        if (txtCodBarraProductos.equals("") || txtNombreProductos.equals("") || txtInventarioProducto.getText().equals("") || txtCostoProductos.getText().equals("")) {
            mensajeNotificacion("Debe de rellenar todos los campos.", "Error");
        
        }else{
            
            int inven=Integer.parseInt(txtInventarioProducto.getText());
            double cost=Double.parseDouble(txtCostoProductos.getText());
            if(inven<=0 || cost<=0){
                mensajeNotificacion("Inventario y costo deben ser mayor a 0.", "Error");
            }else{
                    agregado.setCodBarra(txtCodBarraProductos.getText());
                    agregado.setNombre(txtNombreProductos.getText());
                    agregado.setCosto(Double.parseDouble(txtCostoProductos.getText()));
                    agregado.setInventario(Integer.parseInt(txtInventarioProducto.getText()));
                    
                try {
                    ArrayList<Sucursal> opcion=ControladorSucursal.obtener();
                    Iterator iterador=opcion.iterator();
                    while(iterador.hasNext()){
                        sucus[0]=iterador.next().toString();
                        sucus[1]=iterador.next().toString();
                        sucus[2]=iterador.next().toString();
                        sucus[3]=iterador.next().toString();
                        
                        if (sucus[1].equals(cmbSucursal.getSelectedItem().toString())) {
                            agregado.setIdSucursal(Integer.parseInt(sucus[0]));
                        }
                        
                    }
                } catch (ErrorTienda ex) {
                    Logger.getLogger(frmProductosAgregar.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    ControladorProducto.Agregar(agregado);

                    mensajeNotificacion("¡Producto agregado exitosamente!", "Ok");
                    limpiandoTxtProducto();
                } catch (ErrorTienda e) {

                }
            }
            
        }
        }
    }//GEN-LAST:event_btnAgregarNuevoProductoActionPerformed

    private void txtCodBarraProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarraProductosActionPerformed
        txtNombreProductos.requestFocus();
    }//GEN-LAST:event_txtCodBarraProductosActionPerformed

    private void txtCodBarraProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraProductosKeyTyped
        int limiteCaracter=13;

        int c=(int) evt.getKeyChar();
        int limiteCaracteres=13;

        if ((c >=48 && c<=57) || (c==8) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if(txtCodBarraProductos.getText().length()==limiteCaracter){
                getToolkit().beep();
                evt.consume();
            }
        }else{
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCodBarraProductosKeyTyped

    private void txtNombreProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductosActionPerformed
        txtCostoProductos.requestFocus();
    }//GEN-LAST:event_txtNombreProductosActionPerformed

    private void txtNombreProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductosKeyTyped
        int c=(int) evt.getKeyChar();
        char mayu=evt.getKeyChar();

        if ((c>=65 && c<=90) || (c>=97 && c<=122)  || (c==32) || (c==8) || (c >=48 && c<=57) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if (Character.isLowerCase(mayu)) {
                String cadena=(""+mayu).toUpperCase();
                mayu=cadena.charAt(0);
                evt.setKeyChar(mayu);
            }
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtNombreProductosKeyTyped

    private void txtCostoProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoProductosKeyTyped
        int c=(int) evt.getKeyChar();

        if ((c >=48 && c<=57)  || (c==46) || (c==8) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if (c==46) {
                String cadena=txtCostoProductos.getText();
                int tamanio=cadena.length();
                for (int i = 0; i <= tamanio; i++) {
                    if (cadena.contains(".")) {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        getToolkit().beep();
                        evt.consume();
                    }
                }
            }
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoProductosKeyTyped

    private void txtInventarioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInventarioProductoActionPerformed
        cmbSucursal.requestFocus();
    }//GEN-LAST:event_txtInventarioProductoActionPerformed

    private void txtInventarioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInventarioProductoKeyTyped
        int c=(int) evt.getKeyChar();

        if ((c >=48 && c<=57) || (c==8) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            //No pasa nada
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtInventarioProductoKeyTyped

    private void cmbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSucursalActionPerformed

    private void txtCostoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoProductosActionPerformed
        txtInventarioProducto.requestFocus();
    }//GEN-LAST:event_txtCostoProductosActionPerformed

    private void txtCodBarraProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraProductosKeyPressed
        char c=evt.getKeyChar();    
        if (c == (char) KeyEvent.VK_ENTER) {
            tablaBuscarProductos();
        }
    }//GEN-LAST:event_txtCodBarraProductosKeyPressed

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
            java.util.logging.Logger.getLogger(frmProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductosAgregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarNuevoProducto;
    private javax.swing.JComboBox<String> cmbSucursal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnCompras;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtCodBarraProductos;
    private javax.swing.JTextField txtCostoProductos;
    private javax.swing.JTextField txtInventarioProducto;
    private javax.swing.JTextField txtNombreProductos;
    // End of variables declaration//GEN-END:variables
}
