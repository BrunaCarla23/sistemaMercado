
package br.com.sistematabica.controller;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.dao.GeralDAOOracle;
import br.com.sistematabica.dao.GerenteDAOOracle;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.model.OperadorCaixa;
import br.com.sistematabica.view.principal.EsqueceuSenhaGUI;
import br.com.sistematabica.view.principal.LoginGUI;
import br.com.sistematabica.view.principal.PrincipalGUI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/** Controller Principal que vai controlar a tela de login
 *
 * @author Joel Henrique Silva Santos
 * @author Evelyn Mayara Silva Santos
 * @author Lucas Gabriel Silva Santos
 * 
 * @version 1.0.0
 */
public class PrincipalController {

    private static LoginGUI loginGUI;
    private GerenteDAOOracle gerenteDAO = new GerenteDAOOracle();
    private static Object contaLogada = null;
    private static String email = "",senha = "";
    
    /**Método que vai mostrar a tela de login inicial
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showGUI() {
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
     */
    public boolean validarLogin(String emailDigitado, String senhaDigitada) {
        ArrayList<String[]> listaLogin = null;

        try (Connection con = new ConexaoOracle().getConnection()) {
            listaLogin = new GeralDAOOracle().returnLogin(con);

            for (String[] i : listaLogin) {
                if (i[0].equals(emailDigitado) && i[1].equals(senhaDigitada)) {
                    System.out.println("Sistema: validação efetuada com sucesso");
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Sistema: erro ao validar usuario");
            JOptionPane.showMessageDialog(null, "erro ao validar usuario com o banco de dados");
        }

        return false;
    }
    
    /**Método que vai mostrar a tela principal setado com a conta que foi logada
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     * @param principalGUI PrincipalGUI - a tela principal
     */
    public void objectSelect(PrincipalGUI principalGUI) {
        try (Connection con = new ConexaoOracle().getConnection()) {

            Object conta = new GeralDAOOracle().returnConta(con, this.email, this.senha);
            MenuController menuController = new MenuController();
            
            if(conta instanceof Gerente) {
                menuController.showGUI((Gerente)conta);
            }else if(conta instanceof OperadorCaixa) {
                menuController.showGUI((OperadorCaixa)conta);
            }
            
            this.loginGUI.setVisible(false);

            System.out.println("Sistema: entrando no menuController");
            
        } catch (SQLException ex) {
            System.out.println("Erro com a PrincipalController");
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
    public void objectSelect(EsqueceuSenhaGUI esqueceuSenhaGUI) {
        EsqueceuSenhaController esqueceuSenhaController = new EsqueceuSenhaController();
        esqueceuSenhaController.showGUI();
        this.loginGUI.setVisible(false);
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
        this.email = emailDigitado;
        this.senha = senhaDigitado;
    }

    
    
}
