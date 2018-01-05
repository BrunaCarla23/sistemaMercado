
package br.com.sistematabica.view.configuracoes;

import br.com.sistematabica.view.Style;
import javax.swing.JOptionPane;

/**Tela feedback.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class FeedbackGUI extends javax.swing.JFrame {
    
    Style style = new Style();
    /**
     * Creates new form FeedbackGUI
     */
    public FeedbackGUI() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblAssunto = new javax.swing.JLabel();
        lblButtonTitulo = new javax.swing.JLabel();
        lblButtonBackground = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Feedback");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 390, 150));

        lblAssunto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAssunto.setForeground(new java.awt.Color(255, 255, 255));
        lblAssunto.setText("Feedback:");
        jPanel1.add(lblAssunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        lblButtonTitulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblButtonTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblButtonTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButtonTitulo.setText("Enviar");
        lblButtonTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblButtonTituloMouseClicked(evt);
            }
        });
        jPanel1.add(lblButtonTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 140, 40));

        lblButtonBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistematabica/imagens/sistema/icones/backgroundVerdeClaro.png"))); // NOI18N
        lblButtonBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblButtonBackgroundMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblButtonBackgroundMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblButtonBackgroundMouseExited(evt);
            }
        });
        jPanel1.add(lblButtonBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 140, 40));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistematabica/imagens/sistema/icones/backgroundStarBlack.png"))); // NOI18N
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblButtonBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButtonBackgroundMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblButtonBackgroundMouseClicked

    private void lblButtonBackgroundMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButtonBackgroundMouseEntered
        style.jLabelEditImage(lblButtonBackground, "/br/com/sistematabica/imagens/sistema/icones/backgroundVerdeEscuro.png");
    }//GEN-LAST:event_lblButtonBackgroundMouseEntered

    private void lblButtonBackgroundMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButtonBackgroundMouseExited
        style.jLabelEditImage(lblButtonBackground, "/br/com/sistematabica/imagens/sistema/icones/backgroundVerdeClaro.png");
    }//GEN-LAST:event_lblButtonBackgroundMouseExited

    private void lblButtonTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButtonTituloMouseClicked
        JOptionPane.showMessageDialog(null, "Ops, função não disponivel nessa versão");
    }//GEN-LAST:event_lblButtonTituloMouseClicked

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
            java.util.logging.Logger.getLogger(FeedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeedbackGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeedbackGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAssunto;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblButtonBackground;
    private javax.swing.JLabel lblButtonTitulo;
    // End of variables declaration//GEN-END:variables
}