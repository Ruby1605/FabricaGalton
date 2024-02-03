/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fabricagalton.vista;

import com.mycompany.fabricagalton.modelo.Bola;
import com.mycompany.fabricagalton.modelo.Logger;
import com.mycompany.fabricagalton.modelo.TableroGalton;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author Rubén
 */
public class VentanaPrincipal extends javax.swing.JFrame {
        
    private Logger logger;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        try {
            logger = new Logger();
        } catch (IOException ex) {
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

        btnTableroGaltonConsola = new javax.swing.JButton();
        btnTableroGaltonGrafico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnTableroGaltonConsola.setText("Tablero Galton Consola");
        btnTableroGaltonConsola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableroGaltonConsolaActionPerformed(evt);
            }
        });

        btnTableroGaltonGrafico.setText("Tablero Galton Grafico");
        btnTableroGaltonGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableroGaltonGraficoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTableroGaltonGrafico)
                    .addComponent(btnTableroGaltonConsola))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnTableroGaltonConsola)
                .addGap(62, 62, 62)
                .addComponent(btnTableroGaltonGrafico)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTableroGaltonConsolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableroGaltonConsolaActionPerformed

          try {
            logger.info("Se pulso boton tablero galton consola");
        } catch (IOException ex) {
        }
        TableroGalton tableroGalton = new TableroGalton (10);
        Bola bolas [] = new Bola [100];
        Thread hilos[]=new Thread [100];
        for (int i = 0;i<100;i++){
            bolas[i]=new Bola(i,tableroGalton);
        }
          for (int i = 0;i<100;i++){
            hilos [i] = new Thread(bolas[i]);
            hilos[i].start();
        }
          for (int i = 0;i<100;i++){
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
            }
          }
          System.out.println("todas las bolas cayeron");
          try {
            logger.info("Finalizo la simulacion por consola de tablero galton");
        } catch (IOException ex) {
        }
          tableroGalton.mostrarDepositos();
          try {
            logger.info("Se mostro el resultado por consola");
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_btnTableroGaltonConsolaActionPerformed

    private void btnTableroGaltonGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableroGaltonGraficoActionPerformed
        try {
            logger.info("Se avtivo el tablero grafico con interfaz grafica");
        } catch (IOException ex) {
        }
        TableroGalton tableroGalton = new TableroGalton(10);
        VistaTableroGalton vistaTableroGalton = new VistaTableroGalton(tableroGalton, 50);
        vistaTableroGalton.setVisible(true);
        
    }//GEN-LAST:event_btnTableroGaltonGraficoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
try {
            logger.cerrar();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTableroGaltonConsola;
    private javax.swing.JButton btnTableroGaltonGrafico;
    // End of variables declaration//GEN-END:variables
}
