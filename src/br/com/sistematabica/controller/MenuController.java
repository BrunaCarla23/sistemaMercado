
package br.com.sistematabica.controller;

import br.com.sistematabica.dao.ClienteDAOOracle;
import br.com.sistematabica.dao.VendaDAOOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.model.OperadorCaixa;
import br.com.sistematabica.model.Venda;
import br.com.sistematabica.view.catalogo.ProdutoGUI;
import br.com.sistematabica.view.configuracoes.AtualizacoesGUI;
import br.com.sistematabica.view.configuracoes.FeedbackGUI;
import br.com.sistematabica.view.configuracoes.SobreGUI;
import br.com.sistematabica.view.configuracoes.SuporteTecnicoGUI;
import br.com.sistematabica.view.contas.ClienteGUI;
import br.com.sistematabica.view.contas.GerenteGUI;
import br.com.sistematabica.view.contas.OperadorCaixaGUI;
import br.com.sistematabica.view.outrosRelatorios.MovimentacaoGUI;
import br.com.sistematabica.view.principal.PrincipalGUI;
import br.com.sistematabica.view.vendas.ConsultarVendaGUI;
import br.com.sistematabica.view.vendas.NovaVendaGUI;
import java.util.ArrayList;

/**Controller principal que vai ser responsável pela inicial
 *
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.0
 * 
 */
public class MenuController{
    
    private static PrincipalGUI principalGUI;

    
    /** Método que vai mostrar a tela principal
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     */
    public void showTela() {
        principalGUI = new PrincipalGUI();
        principalGUI.setVisible(true);
    }
    
    /**Método que vai fechar a tela principal
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     */
    public void fecharTelaPrincipal() {
        principalGUI.setVisible(false);
    }
    
    /** Método que vai mostrar a tela principal enviando um gerente para ela
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  gerente Gerente - Um objeto gerente
     * 
     */
    public void showGUI(Gerente gerente) {

       principalGUI = new PrincipalGUI(gerente);
       principalGUI.setVisible(true);
       
        System.out.println("gerente " + gerente.getDados().getNomeCompleto() + " entrou no sistema");
    }
    
    /** Método vai mostrar a tela principal enviando um operador de caixa
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  operadorCaixa OperadorCaixa - Um operador de caixa.
     * 
     */
    public void showTela(OperadorCaixa operadorCaixa) {
        
        principalGUI = new PrincipalGUI(operadorCaixa);
        principalGUI.setVisible(true);
        
        System.out.println("OperadorCaixa " + operadorCaixa.getDados().getNomeCompleto() + " entrou no sistema");
        
    }
    
    /** Método que vai mostrar a tela do cliente
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela ClienteGUI - Um objeto ClienteGUI.
     * 
     */
    public void chamarTela(ClienteGUI tela) {
        ClienteController clienteController = new ClienteController();
        clienteController.showTela();
    }

    /** Método que vai mostrar a tela do gerente
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela GerenteGUI - um objeto GerenteGUI
     * 
     */
    public void chamarTela(GerenteGUI tela, Gerente gerente) {
        GerenteController gerenteController = new GerenteController();
        gerenteController.showTela(gerente);
    }

    /** Método que vai mostrar a tela do operador de caixa
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela OperadorCaixaGUI - um objeto OperadorCaixaGUI.
     * 
     */
    public void chamarTela(OperadorCaixaGUI tela) {
        OperadorCaixaController operadorCaixaController = new OperadorCaixaController();
        operadorCaixaController.showTela();
    }

    /** Método que vai mostrar a tela de consultar venda
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela ConsultarVendaGUI - um objeto ConsultarVendaGUI.
     * 
     */
    public void chamarTela(ConsultarVendaGUI tela) {
        ConsultarVendaGUI view = new ConsultarVendaGUI(new VendaDAOOracle().selecionarTodasVendas());
        view.setVisible(true);
    }

    /** Método que vai mostrar a tela de nova venda
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param nomeVendedor String - nome do vendedor
     * @param  tela NovaVendaGUI - um objeto NovaVendaGUI.
     * 
     */
    public void chamarTela(String nomeVendedor, NovaVendaGUI tela) {
        
        ArrayList<Cliente> clientes = new ClienteDAOOracle().selecionarTodosClientes();
        int codNumeroVenda = new VendaDAOOracle().idMaxVenda() + 1;
        
        NovaVendaController novaVendaController = new NovaVendaController();
        novaVendaController.showTela(nomeVendedor, clientes, codNumeroVenda);
    }

    /** Método que vai mostrar a tela do produto
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela ProdutoGUI - um objeto ProdutoGUI.
     * 
     */
    public void chamarTela(ProdutoGUI tela) {
        ProdutoController produtoController = new ProdutoController();
        produtoController.showTela();
    }

    /** Método que vai mostrar a tela do movimentação
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela MovimentacaoGUI - um objeto MovimentacaoGUI.
     * 
     */
    public void chamarTela(MovimentacaoGUI tela) {
        
        ArrayList<Venda> vendas = new VendaDAOOracle().selecionarTodasVendas();
        
        MovimentacaoGUI view = new MovimentacaoGUI(vendas);
        view.setVisible(true);
    }

    /** Método que vai mostrar a tela de atualização
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela AtualizacoesGUI - um objeto AtualizacoesGUI.
     * 
     */
    public void chamarTela(AtualizacoesGUI tela) {
        AtualizacoesGUI view = new AtualizacoesGUI();
        view.setVisible(true);
    }

    /** Método que vai mostrar a tela de feedback
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela FeedbackGUI - um objeto FeedbackGUI.
     * 
     */
    public void chamarTela(FeedbackGUI tela) {
        FeedbackGUI view = new FeedbackGUI();
        view.setVisible(true);
    }

    /** Método que vai mostrar a tela de sobre
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela SobreGUI - um objeto SobreGUI.
     * 
     */
    public void chamarTela(SobreGUI tela) {
        SobreGUI view = new SobreGUI();
        view.setVisible(true);
    }

    /** Método que vai mostrar a tela de suporte tecnico
     * 
     * @author Joel Henrique
     * @author Lucas Gabriel
     * @author Evelyn Mayara
     * 
     * @param  tela SuporteTecnicoGUI - um objeto SuporteTecnicoGUI.
     * 
     */
    public void chamarTela(SuporteTecnicoGUI tela) {
        SuporteTecnicoGUI view = new SuporteTecnicoGUI();
        view.setVisible(true);
    }

}
