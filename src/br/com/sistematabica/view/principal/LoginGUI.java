
package br.com.sistematabica.view.principal;

//import br.com.sistematabica.controller.CRUDContaController;
import br.com.sistematabica.controller.GerenteController;
import br.com.sistematabica.controller.PrincipalController;
import br.com.sistematabica.exception.*;
import br.com.sistematabica.view.Style;
import javax.swing.JOptionPane;

/** Classe para efetuar o login do Gerente ou do Operador de caixa
 *
 * @author Joel Henrique Silva Santos
 * @author Evelyn Mayara da Silva Santos
 * @author Lucas Gabriel Silva Santos
 * 
 * @version 1.0.0
 * 
 */
public class LoginGUI extends javax.swing.JFrame {

    Style style = new Style();
    PrincipalController principalController = new PrincipalController();
    /**
     * Creates new form NewJFrame
     */
    public LoginGUI() {
        initComponents();
        
        style.jLabelEditImage(lblLogo, "/br/com/sistematabica/imagens/sistema/icones/logo.png");
        style.jPanelEditColor(pnlLogin, 255, 255, 255);
        style.jLabelEditColor(lblVersionId, 255, 255, 255);
        style.default_JPanelBackground(pnlLogo);
        style.default_JLabelForeground(lblUsuario);
        style.default_JLabelForeground(lblSenha);
        style.default_JLabelForeground(lblEntrar);
        style.default_JLabelForeground(lblEsqueceuSenha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogo = new javax.swing.JPanel();
        lblVersionId = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblExitErro = new javax.swing.JLabel();
        lblEntrar = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblEsqueceuSenha = new javax.swing.JLabel();
        lblEnviar = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("prinipal");
        setResizable(false);

        pnlLogo.setBackground(new java.awt.Color(54, 52, 66));
        pnlLogo.setLayout(null);

        lblVersionId.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblVersionId.setForeground(new java.awt.Color(255, 255, 255));
        lblVersionId.setText("versão 1.0.0");
        pnlLogo.add(lblVersionId);
        lblVersionId.setBounds(130, 520, 130, 30);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistematabica/imagens/sistema/icones/logo.png"))); // NOI18N
        pnlLogo.add(lblLogo);
        lblLogo.setBounds(130, 120, 150, 260);

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrar");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pnlLogin.add(jLabel1);
        jLabel1.setBounds(220, 330, 130, 40);

        lblExitErro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitErroMouseClicked(evt);
            }
        });
        pnlLogin.add(lblExitErro);
        lblExitErro.setBounds(356, 480, 50, 80);

        lblEntrar.setFont(new java.awt.Font("Tahoma", 0, 70)); // NOI18N
        lblEntrar.setForeground(new java.awt.Color(115, 115, 115));
        lblEntrar.setText("Entrar");
        pnlLogin.add(lblEntrar);
        lblEntrar.setBounds(100, 50, 200, 70);
        pnlLogin.add(txtUsuario);
        txtUsuario.setBounds(40, 220, 310, 30);

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(115, 115, 115));
        lblUsuario.setText("Usuário:");
        pnlLogin.add(lblUsuario);
        lblUsuario.setBounds(40, 200, 60, 15);

        lblSenha.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(115, 115, 115));
        lblSenha.setText("Senha:");
        pnlLogin.add(lblSenha);
        lblSenha.setBounds(40, 260, 50, 15);

        lblEsqueceuSenha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblEsqueceuSenha.setForeground(new java.awt.Color(115, 115, 115));
        lblEsqueceuSenha.setText("Esqueceu a senha?");
        lblEsqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEsqueceuSenhaMouseClicked(evt);
            }
        });
        pnlLogin.add(lblEsqueceuSenha);
        lblEsqueceuSenha.setBounds(60, 330, 160, 40);

        lblEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistematabica/imagens/sistema/icones/backgroundVerdeClaro.png"))); // NOI18N
        lblEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEnviarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEnviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEnviarMouseExited(evt);
            }
        });
        pnlLogin.add(lblEnviar);
        lblEnviar.setBounds(220, 330, 130, 40);

        lblError.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblErrorMouseClicked(evt);
            }
        });
        pnlLogin.add(lblError);
        lblError.setBounds(0, 480, 400, 80);
        pnlLogin.add(txtSenha);
        txtSenha.setBounds(40, 280, 310, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void lblEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnviarMouseClicked

    }//GEN-LAST:event_lblEnviarMouseClicked

    private void lblErrorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblErrorMouseClicked
       
    }//GEN-LAST:event_lblErrorMouseClicked

    private void lblExitErroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitErroMouseClicked
        style.jLabelEditImage(lblError,"");
    }//GEN-LAST:event_lblExitErroMouseClicked

    private void lblEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnviarMouseEntered
        style.jLabelEditImage(lblEnviar,"/br/com/sistematabica/imagens/sistema/icones/backgroundVerdeEscuro.png");
    }//GEN-LAST:event_lblEnviarMouseEntered

    private void lblEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnviarMouseExited
        style.jLabelEditImage(lblEnviar,"/br/com/sistematabica/imagens/sistema/icones/backgroundVerdeClaro.png");
    }//GEN-LAST:event_lblEnviarMouseExited

    private void lblEsqueceuSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEsqueceuSenhaMouseClicked
        String email = JOptionPane.showInputDialog(null, "Digite o email:");
        JOptionPane.showMessageDialog(null, "A senha é: "+new GerenteController().mostrarSenha(email));
    }//GEN-LAST:event_lblEsqueceuSenhaMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        try {

            if (!principalController.validarLogin(txtUsuario.getText(), txtSenha.getText())) {
                throw new LoginErradoException(lblError, txtSenha);
            } else {
                principalController.enviarLogin(txtUsuario.getText(), txtSenha.getText());
                principalController.objectSelect(new PrincipalGUI());
            }

        } catch (LoginErradoException ex) {
            System.out.println("deu erro");
        }

    }//GEN-LAST:event_jLabel1MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEntrar;
    private javax.swing.JLabel lblEnviar;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblEsqueceuSenha;
    private javax.swing.JLabel lblExitErro;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVersionId;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
