
package br.com.sistematabica.exception;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Joel Henrique, Evelyn Mayara, Lucas Gabriel
 */
    public class LoginErradoException extends Exception{
    
    public LoginErradoException(JLabel labelErro, JTextField textFieldSenha) {
        labelErro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistematabica/imagens/sistema/erro/LoginErradoException.png")));
        textFieldSenha.setText("");
    }
    
    @Override
    public String getMessage() {
        return "Senha ou e-email está errado!";
    }
   
    
}
