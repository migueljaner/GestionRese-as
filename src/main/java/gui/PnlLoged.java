/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dataacces.DataAccess;
import dto.Establecimiento;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Miquel
 */
public class PnlLoged extends javax.swing.JPanel {

    private Main padre;
    private DataAccess data = new DataAccess();

    /**
     * Creates new form PnlLoged
     */
    public PnlLoged(Main padre) {
        this.padre = padre;
        initComponents();
        loadUserComponents();

    }

    //para recoger el JFrame desde los hijos de esta clase.
    public Main getPadre() {
        return padre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setText("Lista Establecimientos...");
        add(jLabel1);
        jLabel1.setBounds(120, 60, 190, 16);
    }// </editor-fold>//GEN-END:initComponents

    //Una vez instanciados los componentes estaticos, instanciamos los componentes de usuario.
    private void loadUserComponents() {
        lstEstablecimientos = new javax.swing.JList<>();
        scrAlojamientos = new javax.swing.JScrollPane();
        btnMostrarDetalles = new javax.swing.JButton();

        //Cargamos los alojamientos
        this.add(scrAlojamientos);
        scrAlojamientos.setBounds(80, 120, 560, 200);
        cargarEstablecimientos();
        lstEstablecimientos.addListSelectionListener((javax.swing.event.ListSelectionEvent evt) -> {
            lstAlojamientosValueChanged(evt);
        });

        btnMostrarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDetallesActionPerformed(evt);
            }
        });
    }

    //Funcion que carga los Alojamientos dentro de la lista.
    public void cargarEstablecimientos() {
        ArrayList<Establecimiento> establecimientos = data.getEstablecimientos();
        DefaultListModel<Establecimiento> dflmo = new DefaultListModel<>();
        for (Establecimiento establecimiento : establecimientos) {
            dflmo.addElement(establecimiento);
        }

        lstEstablecimientos.setModel(dflmo);
        scrAlojamientos.setViewportView(lstEstablecimientos);
    }

    //Evento que se activa cada vez que se cambia el alojamiento seleccionado.
    private void lstAlojamientosValueChanged(javax.swing.event.ListSelectionEvent evt) {

        //Metodo para anular la doble entrada al cambiar el valor de la lista de alojamientos.
        if (!evt.getValueIsAdjusting()) {
            if (lstEstablecimientos.getSelectedValue() != null) {
                this.add(btnMostrarDetalles);
                btnMostrarDetalles.setBounds(80, 340, 560, 50);
                btnMostrarDetalles.setText("Ver");
                this.repaint();

            } else {
                this.remove(btnMostrarDetalles);
                this.repaint();
            }
        }
    }

    private void btnMostrarDetallesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        pnlVerModificar = new pnlVer(this);
        padre.add(pnlVerModificar);
        pnlVerModificar.setBounds(0, 0, 800, 540);
        pnlVerModificar.setVisible(true);
        this.setVisible(false);
    }

    public JList<Establecimiento> getLstEstablecimientos() {
        return lstEstablecimientos;
    }

    private javax.swing.JScrollPane scrAlojamientos;
    private javax.swing.JList<Establecimiento> lstEstablecimientos;
    private javax.swing.JPanel pnlVerModificar;
    private javax.swing.JButton btnMostrarDetalles;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}