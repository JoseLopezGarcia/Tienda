/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.ErrorTienda;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class frmCalcularCambio extends javax.swing.JFrame {

    /**
     * Creates new form frmCalcularCambio
     */
    DecimalFormat decf = new DecimalFormat("0.00");
    
    public frmCalcularCambio() {
        initComponents();
        txtRecibido.requestFocus();
    }
    public void calcular(){
        if(txtRecibido.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo esta vacìo","ERROR DE USUARIO",JOptionPane.ERROR_MESSAGE);
        }else{
            String totalT=txtTotalaPagar.getText().substring(2);
        double total = Double.parseDouble(totalT);
        double recibido = Double.parseDouble(txtRecibido.getText());
        if(recibido<total){
           frmVentas vn;
            try {
                vn = new frmVentas();
                txtRecibido.requestFocus();
                txtRecibido.selectAll();
                vn.mensajeNotificacion("Ingrese una cantidad correcta", "Error");
                
            } catch (ErrorTienda ex) {
                
            }
           
        }else{
        txtCambio.setText(String.valueOf(decf.format(recibido-total)));    
        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTotalaPagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtRecibido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calcular cambio");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        jLabel4.setText("iShop");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Calcular Cambio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 60));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotalaPagar.setEditable(false);
        txtTotalaPagar.setBackground(new java.awt.Color(204, 204, 255));
        txtTotalaPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalaPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalaPagarActionPerformed(evt);
            }
        });
        jPanel3.add(txtTotalaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 140, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Total a Pagar");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 540, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cambio $");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        txtCambio.setEditable(false);
        txtCambio.setBackground(new java.awt.Color(204, 204, 255));
        txtCambio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 240, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Recibido $");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        txtRecibido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecibidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 13, 240, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        btnTerminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 540, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        calcular();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTotalaPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalaPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalaPagarActionPerformed

    private void txtRecibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibidoKeyTyped
        int c=(int) evt.getKeyChar();

        if ((c >=48 && c<=57)  || (c==46) || (c==8) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if (c==46) {
                String cadena=txtRecibido.getText();
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
    }//GEN-LAST:event_txtRecibidoKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCalcularCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCalcularCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCalcularCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCalcularCambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCalcularCambio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtRecibido;
    public javax.swing.JTextField txtTotalaPagar;
    // End of variables declaration//GEN-END:variables
}
