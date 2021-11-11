/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel_xoquin.reloj_di03;

import com.samuel_xoquin.reloj_di03.bean.Alarma;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

/**
 *
 * @author xoquin
 */
public class FrameReloj extends javax.swing.JFrame {

    /**
     * Inicializa el JFrame estableciendo el tamaño del texto del reloj,
     * deshabilitando que se pueda cambiar el tamaño de la ventana y centrándola.
     */
    public FrameReloj() {
        initComponents();
        reloj.setFont(new Font("DejaVu Sans", Font.PLAIN, 40));
        this.setResizable(false);
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        int width = 481;
        int height = 179;
        this.setBounds(screenWidth/2-width/2, screenHeight/2-height/2, width, height);
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
        nomAlarma = new javax.swing.JTextField();
        spnHora = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnMinuto = new javax.swing.JSpinner();
        chkAlActiva = new javax.swing.JCheckBox();
        reloj = new com.samuel_xoquin.reloj_di03.bean.RelojBean();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alarma");

        jLabel1.setText("Nombre alarma");

        spnHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel2.setText("Hora");

        jLabel3.setText("Minuto");

        spnMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        chkAlActiva.setText("¿Alarma activada?");
        chkAlActiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAlActivaActionPerformed(evt);
            }
        });

        reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloj.addAlarmaListener(new com.samuel_xoquin.reloj_di03.bean.RelojBean.AlarmaListener() {
            public void capturarAlarma(com.samuel_xoquin.reloj_di03.bean.AlarmaEvent evt) {
                relojCapturarAlarma(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reloj, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomAlarma))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(chkAlActiva)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(chkAlActiva)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reloj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Al lanzarse el evento de alarma, muestra un diálogo con el texto definido
     * @param evt 
     */
    private void relojCapturarAlarma(com.samuel_xoquin.reloj_di03.bean.AlarmaEvent evt) {//GEN-FIRST:event_relojCapturarAlarma
        JOptionPane.showMessageDialog(null, reloj.getTextoAlarma(), "Alerta alarma", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_relojCapturarAlarma

    /**
     * Establece la alarma con los parámetros definidos en la vista según se
     * active o desactive, en cuyo caso también bloquea los componentes de
     * edición de la alarma.
     * @param evt 
     */
    private void chkAlActivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAlActivaActionPerformed
        if (chkAlActiva.isSelected()) {
            int hora = (int) spnHora.getValue();
            int minuto = (int) spnMinuto.getValue();
            reloj.setAlarma(new Alarma(hora, minuto));
            reloj.setTextoAlarma(nomAlarma.getText());
            
            spnHora.setEnabled(false);
            spnMinuto.setEnabled(false);
            nomAlarma.setEnabled(false);
        }
        else{
            reloj.setAlarma(null);
            
            spnHora.setEnabled(true);
            spnMinuto.setEnabled(true);
            nomAlarma.setEnabled(true);
        }
    }//GEN-LAST:event_chkAlActivaActionPerformed

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
            java.util.logging.Logger.getLogger(FrameReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameReloj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameReloj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkAlActiva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomAlarma;
    private com.samuel_xoquin.reloj_di03.bean.RelojBean reloj;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JSpinner spnMinuto;
    // End of variables declaration//GEN-END:variables
}
