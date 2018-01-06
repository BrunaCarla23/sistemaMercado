
package br.com.sistematabica.controller;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.dao.DadoPessoalDAOOracle;
import br.com.sistematabica.dao.GeralDAOOracle;
import br.com.sistematabica.dao.GerenteDAOOracle;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.view.meuperfil.MeuPerfilGerenteGUI;
import br.com.sistematabica.view.cadastrar.conta.gerente.CadastrarGerenteGUI;
import br.com.sistematabica.view.contas.GerenteGUI;
import java.sql.Connection;
import java.sql.SQLException;

/**Classe Controller que vai controlar tudo relacionado ao gerente.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class GerenteController {

    // tela gerente principal
    private static GerenteGUI GerenteGUI;

    /**Método que vai mostrar a tela principal do gerente
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showGUI() {
       GerenteGUI = new GerenteGUI();
       GerenteGUI.setVisible(true);
    }

    /**Método que vai mostrar a tela principal do gerente passando por parametro um gerente
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param gerente Gerente - um objeto gerente.
     *
     */
    void showGUI(Gerente gerente) {
       GerenteGUI = new GerenteGUI(gerente);
       GerenteGUI.setVisible(true);
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

    /**Método que vai deletar um gerente no banco de dados
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param id Int - id do gerente qu vai ser deletado
     *
     */
    public void deletarGerente(int id) {
        new GerenteDAOOracle().deletarGerente(new GerenteDAOOracle().idDadoPessoal(id));
       new DadoPessoalDAOOracle().deletarDadoPessoal(id);
        
        new MenuController().dispose();
        
        if(new GerenteDAOOracle().isGerente()) {
            
            System.out.println("sistema: Existe pelo menos 1 gerente");
            PrincipalController principalController = new PrincipalController();
            principalController.showTela();
                
        }else {
            
            System.out.println("sistema: não existe gerent no sistma");
            CadastrarGerenteGUI cadastrarGerenteGUI = new CadastrarGerenteGUI();
            cadastrarGerenteGUI.setVisible(true);
   
        }
    }

    /**Método que vai que vai mostrar a tela para cadastrar um gerente
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void novo() {
        
        CadastrarGerenteGUI cadastrarGerenteGUI = new CadastrarGerenteGUI();
        cadastrarGerenteGUI.setVisible(true);
        
    }

    /**Método que vai mostrar a tela para altera um gerente
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param gerente Gerente - um objeto gerente
     *
     */
    public void alterarGUI(Gerente gerente) {
        MeuPerfilGerenteGUI alterar = new MeuPerfilGerenteGUI(gerente);
        alterar.setVisible(true);
    }

    /**Método que vai alterar um gerente no banco de dados
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param gerente Gerente - um objeto gerente
     *
     */
    public void alterar(Gerente gerente) {
        new DadoPessoalDAOOracle().atualizarDadoPessoal(gerente);
        new GerenteDAOOracle().updateGerente(gerente);
        new PrincipalController().showTela();
        
    }

    /**Método que vai validar o email do gerente
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param text String - o email a ser validado
     *
     */
    public boolean validarEmail(String text) {
        
        try (Connection con = new ConexaoOracle().getConnection()) {
           return new GeralDAOOracle().validarEmail(con, text);
        } catch (SQLException ex) {
            System.out.println("erro OperadorCaixaController!");
        }
            return false;
    }

    /**Método que vai inserir um gerente no banco de dados
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param gerente Gerente - um objeto gerente
     *
     */
    public void inserir(Gerente gerente) {
            new DadoPessoalDAOOracle().inserirDadoPessoal(gerente.getDados());
            new GerenteDAOOracle().inserirGerente(gerente);
    }

    
}
