/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shoop.view;

import java.awt.Color;

 
/**
 *
 * @author Juan Francisco
 */
public class LogIn extends MyOwnJFrame{

    /**
     * Creates new form NewJFrame
     */
    public LogIn() {
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

        LabelPlease = new javax.swing.JLabel();
        FieldUsername = new javax.swing.JTextField();
        FieldPW = new javax.swing.JPasswordField();
        LabelUsername = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        ButCancel = new javax.swing.JButton();
        ButLogIn = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        LabelLogIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelPlease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/register text.png"))); // NOI18N
        getContentPane().add(LabelPlease, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        FieldUsername.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        FieldUsername.setAutoscrolls(false);
        FieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(FieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 260, 30));
        getContentPane().add(FieldPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 260, 30));

        LabelUsername.setFont(new java.awt.Font("Lakesight Personal Use Only", 0, 30)); // NOI18N
        LabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/username.png"))); // NOI18N
        getContentPane().add(LabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 170, 30));

        LabelPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/password.png"))); // NOI18N
        getContentPane().add(LabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 170, 30));

        ButCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/cancel.png"))); // NOI18N
        ButCancel.setBorderPainted(false);
        ButCancel.setContentAreaFilled(false);
        ButCancel.setFocusPainted(false);
        ButCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCancelActionPerformed(evt);
            }
        });
        getContentPane().add(ButCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 310, 40));

        ButLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/log in.png"))); // NOI18N
        ButLogIn.setBorder(null);
        ButLogIn.setBorderPainted(false);
        ButLogIn.setContentAreaFilled(false);
        ButLogIn.setDefaultCapable(false);
        ButLogIn.setFocusPainted(false);
        ButLogIn.setFocusable(false);
        ButLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButLogInActionPerformed(evt);
            }
        });
        getContentPane().add(ButLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 260, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/BGlog.png"))); // NOI18N
        Background.setAlignmentY(0.0F);
        Background.setFocusable(false);
        Background.setRequestFocusEnabled(false);
        Background.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LabelLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/letters/log in.png"))); // NOI18N
        getContentPane().add(LabelLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 193, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCancelActionPerformed
        this.dispose();
        
        
        
    }//GEN-LAST:event_ButCancelActionPerformed

    private void ButLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButLogInActionPerformed
        int count = 0;
        /*Checkin empty spaces*/
        String a = FieldUsername.getText();
        String b = FieldPW.getText();
        if ((a.trim().length()==0)        ||
            (b.trim().length()==0)          
            )
        {
            System.out.println("Missing Fields");
        } else {
            System.out.println("No missing fields");
            count = count +1;
        }

         if (count == 1){
            this.dispose();
            
            
            
         }
            
    }//GEN-LAST:event_ButLogInActionPerformed

    private void FieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton ButCancel;
    private javax.swing.JButton ButLogIn;
    private javax.swing.JPasswordField FieldPW;
    private javax.swing.JTextField FieldUsername;
    private javax.swing.JLabel LabelLogIn;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelPlease;
    private javax.swing.JLabel LabelUsername;
    // End of variables declaration//GEN-END:variables
}