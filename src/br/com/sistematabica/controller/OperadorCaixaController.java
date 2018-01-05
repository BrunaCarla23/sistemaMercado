
package br.com.sistematabica.controller;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.dao.DadoPessoalDAOOracle;
import br.com.sistematabica.dao.GeralDAOOracle;
import br.com.sistematabica.dao.OperadorCaixaDAOOracle;
import br.com.sistematabica.model.OperadorCaixa;
import br.com.sistematabica.view.contas.MostrarIconGUI;
import br.com.sistematabica.view.contas.OperadorCaixaGUI;
import br.com.sistematabica.view.alterar.conta.operadorcaixa.AlterarOperadorCaixaGUI;
import br.com.sistematabica.view.cadastrar.conta.OperadorCaixa.CadastrarOperadorCaixaGUI;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**Classe Controller que vai controlar tudo relacionado a operador de caixa.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class OperadorCaixaController {

    private OperadorCaixaGUI telaGUI;

    /**Método que vai mostrar a tela principal do operador
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showGUI() {
        this.telaGUI = new OperadorCaixaGUI(new OperadorCaixaDAOOracle().selecionarTodosOperadorCaixa());
        this.telaGUI.setVisible(true);
    }

    /**Método que mostrar um senha
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param email
     * @return String
     * 
     */
    public String mostrarSenha(String email) {
    
        try (Connection con = new ConexaoOracle().getConnection()) {
           return new GeralDAOOracle().pegarSenha(con, email);
        } catch (SQLException ex) {
            System.out.println("erro OperadorCaixaController!");
        }
        return null;
        
    }
    
    /**Método que vai mostrar a tela de cadastro do operador de caixa.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void novoGUI() {
        CadastrarOperadorCaixaGUI gui = new CadastrarOperadorCaixaGUI();
        gui.setVisible(true);
    }

    /**Método que vai inserir um novo operador de caixa no banco.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param operadorCaixa OperadorCaixa - um objeto operador
     *
     */
    public void novo(OperadorCaixa operadorCaixa) {
        new CRUDContaController().inserir(operadorCaixa);
    }

    /**Método que vai deletar um operador pelo id
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param id Int - id do operador
     *
     */
    public boolean excluir(int id) {

        boolean operadorCaixa = new OperadorCaixaDAOOracle().deletarOperadorCaixa(id);
        boolean dadosPessoal = new DadoPessoalDAOOracle().deletarDadoPessoal(id);

        if (operadorCaixa && dadosPessoal) {
            return true;
        } else {
            return false;
        }

    }

    /**Método que vai imprimir a relação dos operadores
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void relacao() {
        JOptionPane.showMessageDialog(null, "Função indisponível no momento");
    }

    /**Método que vai alterar um operador no banco de dados
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param operadorCaixa OperadorCaixa - um objeto operador
     *
     */
    public void alterar(OperadorCaixa operadorCaixa) {

        new DadoPessoalDAOOracle().atualizarDadoPessoal(operadorCaixa);
        new OperadorCaixaDAOOracle().atualizarOperadorCaixa(operadorCaixa);
        
    }

    /**Método que vai mostrar a tela de alteração de operador
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param operadorCaixa OperadorCaixa - que vai se setado na view de alteração
     *
     */
    public void alterarGUI(OperadorCaixa operadorCaixa) {
        AlterarOperadorCaixaGUI alterar = new AlterarOperadorCaixaGUI(operadorCaixa);
        alterar.setVisible(true);
    }

    /**Método que vai mostrar a imagem do operador
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param url String - a url da imagem
     *
     */
    public void imagem(String url) {
        MostrarIconGUI gui = new MostrarIconGUI(url);
        gui.setVisible(true);
    }

    /**Método que vai validar o email do operador
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param nomeLogin String - o email do operador
     *
     */
    public boolean validarEmail(String nomeLogin) {
        
        try (Connection con = new ConexaoOracle().getConnection()) {
           return new GeralDAOOracle().validarEmail(con, nomeLogin);
        } catch (SQLException ex) {
            System.out.println("erro OperadorCaixaController!");
        }
            return false;
    }

}
