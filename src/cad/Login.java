/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cad;

import javax.swing.JOptionPane;

/**
 *
 * @author virajee
 */
public class Login extends javax.swing.JFrame {

    private String reverseword = "";  //this variable is for storing reverse user user id and password
    private LoginInfo l = null;
    private LoginDB ldb=null;
    private static int countRound = 1; //this variable is to count rounds
    private Validator v=new Validator();
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        ldb = new LoginDB();
        txt_username.grabFocus();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_log = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        pwd_pass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login-2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 200));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Username: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 240, -1));

        btn_log.setText("Log");
        btn_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logActionPerformed(evt);
            }
        });
        jPanel1.add(btn_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 70, -1));

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        pwd_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_passKeyPressed(evt);
            }
        });
        jPanel1.add(pwd_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logActionPerformed
            String username=txt_username.getText();
            String pass = new String(pwd_pass.getPassword());
         
        if (v.isPresent(username)&& v.isPresent(pass)) {            
            reverseword = "";
            l = ldb.getLogin(username);
            if (countRound < 3) {     //1.In here it checks whether the user exceeds the attempts or not
                if (l != null) {    //2.In here it checks whther entered username is valid or not.
                    String passDB=v.reverseuser_pass(new String(l.getPassword()));
                    if (passDB.equals(pass)) {  //3.in here it checks whether the enterd password is match with the username                        
                        UserLevel.userLevel = l.getUserLevel();
                        Home mv = new Home();
                        mv.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(btn_log, "Incorrect Username or Password");
                        countRound++;
                        pwd_pass.grabFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(btn_log, "Incorrect Username or Password");
                    countRound++;
                    txt_username.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(btn_log, "Incorrect Username or Password and your Attempts exceed the Limits");
                System.exit(0);
            }
        }      
    }//GEN-LAST:event_btn_logActionPerformed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        if (evt.getKeyCode() == 10) {
            pwd_pass.grabFocus();
        }
        if (evt.getKeyCode() == 39) {
            pwd_pass.grabFocus();
        }
    }//GEN-LAST:event_txt_usernameKeyPressed

    private void pwd_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_passKeyPressed
        if (evt.getKeyCode() == 37) {
            txt_username.grabFocus();
        }
    }//GEN-LAST:event_pwd_passKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_log;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pwd_pass;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
