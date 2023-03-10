/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import dataacces.DataAccess;
import java.util.Arrays;

/**
 *
 * @author Miquel
 */
public class EditUserDialog extends javax.swing.JDialog {

    private Main pantallaPricipal;

    /**
     * Creates new form LoginDialog
     */
    public EditUserDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        pantallaPricipal = (Main) parent;
        initComponents();
        txtEmail.setText(pantallaPricipal.getUserLogged().getEmail());
        txtPassword.setText(pantallaPricipal.getUserLogged().getPassword());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIntro = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(100, 100));
        setPreferredSize(new java.awt.Dimension(375, 250));
        setResizable(false);
        getContentPane().setLayout(null);

        lblIntro.setText("Introduce sus credenciales:");
        getContentPane().add(lblIntro);
        lblIntro.setBounds(30, 20, 160, 20);

        lblPassword.setText("Password:");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(90, 110, 70, 16);

        lblEmail.setText("Email:");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(110, 60, 50, 16);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(170, 60, 140, 22);

        btnLogin.setText("Edit");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(230, 150, 72, 23);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(170, 110, 140, 22);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(135, 150, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Comprobamos si existe el usuario y lo seteamos como usuario logeado.
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //Recoger datos de los campos.
        String emailValue = txtEmail.getText().trim().toLowerCase();
        String valuePassword = String.valueOf(txtPassword.getPassword()).trim();
        

        //Validamos los datos introducidos antes de enviarlos a la base de datos.
        if (!emailValue.isBlank() && !valuePassword.isBlank()) {
            
            pantallaPricipal.getUserLogged().setEmail(emailValue);
            pantallaPricipal.getUserLogged().setPassword(valuePassword);
            //Comprobamos si existe el usuario en la base de datos.
            DataAccess data = new DataAccess();
            
            if (data.updateUser(pantallaPricipal.getUserLogged())>0) {
                this.setVisible(false);
                pantallaPricipal.isLogedIn(true);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIntro;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
