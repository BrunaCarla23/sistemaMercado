
package br.com.sistematabica.exception;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Joel
 */
public class ContaNaoEncontradaException extends Exception{
    
    public ContaNaoEncontradaException(JLabel labelErro, JTextField textFieldEmail, JTextField textFieldSenha) {
        labelErro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistematabica/imagens/sistema/erro/ContaNaoEncontradaException.png")));
        textFieldSenha.setText("");
        textFieldEmail.setText("");
    }
    
    @Override
    public String getMessage() {
        return "Operador de caixa não existe!";
    }
}
