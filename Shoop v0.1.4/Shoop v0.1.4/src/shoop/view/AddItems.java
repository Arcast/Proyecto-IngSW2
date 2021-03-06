/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shoop.view;

import java.awt.Color;
import shoop.controller.ProductController;
import shoop.controller.RegisterViewController;

/**
 *
 * @author Juan Francisco
 */
public class AddItems extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public AddItems() {
        initComponents();
        
        this.setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBCategory = new javax.swing.JComboBox();
        FieldDesc = new javax.swing.JTextField();
        LabelDesc = new javax.swing.JLabel();
        FieldURL = new javax.swing.JTextField();
        LabelURL = new javax.swing.JLabel();
        FieldName = new javax.swing.JTextField();
        LabelName = new javax.swing.JLabel();
        LabelCat = new javax.swing.JLabel();
        FieldProvider = new javax.swing.JTextField();
        LabelProvider = new javax.swing.JLabel();
        FieldPrice = new javax.swing.JTextField();
        LabelPrice = new javax.swing.JLabel();
        LabelQuantity = new javax.swing.JLabel();
        FieldQuant = new javax.swing.JTextField();
        ButCancel = new javax.swing.JButton();
        ButAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BG = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CBCategory.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        CBCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Book and Audible", "Movies and Music", "Games", "Electronics", "Home and Garden", "Beauty and health", "Toys", "Clothing and Jewelry", "Sports", "Automotive", "Others" }));
        getContentPane().add(CBCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 220, 30));

        FieldDesc.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        getContentPane().add(FieldDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 220, 30));

        LabelDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/desc.png"))); // NOI18N
        getContentPane().add(LabelDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 180, 60));

        FieldURL.setEditable(false);
        FieldURL.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        FieldURL.setText("(Not implemented)");
        getContentPane().add(FieldURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 220, 30));

        LabelURL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/url.png"))); // NOI18N
        getContentPane().add(LabelURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 170, 50));

        FieldName.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        getContentPane().add(FieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 220, 30));

        LabelName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/name.png"))); // NOI18N
        getContentPane().add(LabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 160, 50));

        LabelCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/Category.png"))); // NOI18N
        getContentPane().add(LabelCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 183, 160, 60));

        FieldProvider.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        getContentPane().add(FieldProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 220, 30));

        LabelProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/provider.png"))); // NOI18N
        getContentPane().add(LabelProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 160, 60));

        FieldPrice.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        FieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldPriceKeyTyped(evt);
            }
        });
        getContentPane().add(FieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 220, 30));

        LabelPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/Price.png"))); // NOI18N
        getContentPane().add(LabelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 160, 60));

        LabelQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/quant.png"))); // NOI18N
        getContentPane().add(LabelQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 160, 60));

        FieldQuant.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        FieldQuant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FieldQuantKeyTyped(evt);
            }
        });
        getContentPane().add(FieldQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 220, 30));

        ButCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/cancel.png"))); // NOI18N
        ButCancel.setBorderPainted(false);
        ButCancel.setContentAreaFilled(false);
        ButCancel.setFocusPainted(false);
        ButCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCancelActionPerformed(evt);
            }
        });
        getContentPane().add(ButCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, -1, -1));

        ButAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/Additem.png"))); // NOI18N
        ButAdd.setBorderPainted(false);
        ButAdd.setContentAreaFilled(false);
        ButAdd.setFocusPainted(false);
        ButAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAddActionPerformed(evt);
            }
        });
        getContentPane().add(ButAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 270, -1));

        jButton1.setText("Delete");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 580, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/BGlogReg.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/items/Additem.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 270, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCancelActionPerformed
            this.dispose();
    }//GEN-LAST:event_ButCancelActionPerformed

    private void ButAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAddActionPerformed
            
        
        
        
        Object aa = CBCategory.getSelectedItem();
            String a = String.valueOf(aa);
                  
            
            String b = FieldName.getText();
            String c = FieldURL.getText();
            String d = FieldDesc.getText();
            String e = FieldProvider.getText();
            String f = FieldPrice.getText();
            String g = FieldQuant.getText();
            String id = b+a+e;
            
            if ((FieldPrice.getText().trim().length()==0)        || 
                (FieldName.getText().trim().length()==0)        ||
                (FieldDesc.getText().trim().length()==0)    ||
                (FieldProvider.getText().trim().length()==0)          ||
                (FieldQuant.getText()).trim().length()==0)
                {
            System.out.println("Missing Fields");
        } else {
            ProductController.AssingAndAddProductClass(a,b,"x",d,e,f,"1",id,g);
            
            this.dispose();
            }
            
            
            
            
            
            
    }//GEN-LAST:event_ButAddActionPerformed

    private void FieldPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldPriceKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&
         (car != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();
                System.out.println("letra");}
    
    }//GEN-LAST:event_FieldPriceKeyTyped

    private void FieldQuantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldQuantKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&
         (car != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();
                System.out.println("letra");}
    
    }//GEN-LAST:event_FieldQuantKeyTyped
    
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
            java.util.logging.Logger.getLogger(AddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItems().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton ButAdd;
    private javax.swing.JButton ButCancel;
    private javax.swing.JComboBox CBCategory;
    private javax.swing.JTextField FieldDesc;
    private javax.swing.JTextField FieldName;
    private javax.swing.JTextField FieldPrice;
    private javax.swing.JTextField FieldProvider;
    private javax.swing.JTextField FieldQuant;
    private javax.swing.JTextField FieldURL;
    private javax.swing.JLabel LabelCat;
    private javax.swing.JLabel LabelDesc;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPrice;
    private javax.swing.JLabel LabelProvider;
    private javax.swing.JLabel LabelQuantity;
    private javax.swing.JLabel LabelURL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
