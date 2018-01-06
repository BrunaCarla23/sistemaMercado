
package br.com.sistematabica.controller;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.dao.GeralDAOOracle;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.model.OperadorCaixa;
import br.com.sistematabica.view.principal.EsqueceuSenhaGUI;
import br.com.sistematabica.view.principal.LoginGUI;
import br.com.sistematabica.view.principal.PrincipalGUI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/** Controller que vai ser responsável pela tela de login
 *
 * @author Joel Henrique Silva Santos
 * @author Evelyn Mayara Silva Santos
 * @author Lucas Gabriel Silva Santos
 * 
 * @version 1.0.0
 */
public class PrincipalController {

    private static LoginGUI loginGUI;
    private static String email = "",senha = "";
    
    /**Método que vai mostrar a tela de login inicial
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showTela() {
        this.loginGUI = new LoginGUI();
        this.loginGUI.setVisible(true);
    }

    /**Método que vai validar se existe no banco de dados a conta
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param emailDigitado String - o email da conta
     * @param senhaDigitada String - a senha da conta
     *
     * @return boolean - se usuario existe retorna true, senão false
     */
    public boolean validarLogin(String emailDigitado, String senhaDigitada) {
        ArrayList<String[]> listaLogin = null;

        try (Connection con = new ConexaoOracle().getConnection()) {
            listaLogin = new GeralDAOOracle().returnLogin(con);

            for (String[] i : listaLogin) {
                if (i[0].equals(emailDigitado) && i[1].equals(senhaDigitada)) {
                    System.out.println("controller>PrincipalController: validação efetuada com sucesso");
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("controller>PrincipalController: erro ao validar usuario");
            JOptionPane.showMessageDialog(null, "Ops, alguma coisa deu errado ao validar o usuario no banco de dados!");
            ex.printStackTrace();
        }

        return false;
    }
    
    /**Método que vai mostrar a tela principal e setar a conta que foi logada
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     * @param principalGUI PrincipalGUI - a tela principal
     */
    public void chamarTela(PrincipalGUI principalGUI) {
        try (Connection con = new ConexaoOracle().getConnection()) {

            // objeto que vai guardar as info do usuario logado
            Object conta = new GeralDAOOracle().returnConta(con, PrincipalController.email, PrincipalController.senha);
            MenuController menuController = new MenuController();
            
            // se for um gerente logado vai abrir a tela do mesmo
            if(conta instanceof Gerente) {
                menuController.showGUI((Gerente)conta);
            // caso for um operador vai abrir a tela do operador
            }else if(conta instanceof OperadorCaixa) {
                menuController.showTela((OperadorCaixa)conta);
            }
            
            PrincipalController.loginGUI.setVisible(false);

        } catch (SQLException ex) {
            System.out.println("controller>PrincipalController: Erro com a PrincipalController");
            ex.printStackTrace();
        }
    }
    
    /**Método que vai mostrar a tela que esqueceu a senha
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param esqueceuSenhaGUI EsqueceuSenhaGUI - tela esqueceu senha
     *
     */
    public void chamarTela(EsqueceuSenhaGUI esqueceuSenhaGUI) {
        EsqueceuSenhaController esqueceuSenhaController = new EsqueceuSenhaController();
        esqueceuSenhaController.showGUI();
        PrincipalController.loginGUI.setVisible(false);
    }
    
    /**Método que vai setar no principalController o email e a senha passado por parametro
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param emailDigitado String - email da conta
     * @param senhaDigitado String - senha da conta
     *
     */
    public void enviarLogin(String emailDigitado, String senhaDigitado) {
        PrincipalController.email = emailDigitado;
        PrincipalController.senha = senhaDigitado;
    }

    
    
}
