
package br.com.sistematabica.controller;

import br.com.sistematabica.dao.ClienteDAOOracle;
import br.com.sistematabica.dao.DadoPessoalDAOOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.view.contas.ClienteGUI;
import br.com.sistematabica.view.contas.MostrarIconGUI;
import br.com.sistematabica.view.alterar.conta.cliente.AlterarClienteGUI;
import br.com.sistematabica.view.cadastrar.conta.cliente.CadastrarClienteGUI;
import javax.swing.JOptionPane;

/**Classe Controller que vai ser responsável por tudo relacionado a cliente.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ClienteController {

    // tela principal do cliente
    private static ClienteGUI usuarioGUI;

    /**Método que vai mostrar a tela principal do cliente e instanciar o objeto cliente passando por parametro todos os clientes
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showTela() {
        usuarioGUI = new ClienteGUI(new ClienteDAOOracle().selecionarTodosClientes());
        usuarioGUI.setVisible(true);
    }

    /**Método que vai imprimir a relação dos clientes
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void relacao() {
        JOptionPane.showMessageDialog(null, "Ops, infelizmente essa funcionalidade não esta diponivel");
    }

    /**Método que vai inserir um cliente no banco de dados.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param cliente Cliente - Um objeto cliente.
     *
     */
    public void inserir(Cliente cliente) {
        new CRUDContaController().inserir(cliente);
    }

    /**Método que vai deletar um cliente no banco de dados.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param id int - o id do cliente.
     *
     * @return boolean - true se removido com sucesso, false se teve alguma falha.
     * 
     */
    public boolean deletar(int id) {
        boolean cliente = new ClienteDAOOracle().deletarCliente(id);
        boolean dadosPessoal = new DadoPessoalDAOOracle().deletarDadoPessoal(id);

        return cliente && dadosPessoal;
    }

    /**Método que vai instanciar e mostrar a tela de alteração do clinte passando por parementro um cliente.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param cliente Cliente - Um objeto cliente.
     *
     */
    public void telaAlterar(Cliente cliente) {
        AlterarClienteGUI alterar = new AlterarClienteGUI(cliente);
        alterar.setVisible(true);
    }

    /**Método que vai instanciar e mostrar a tela de criar um novo cliente.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void telaNovo() {
        CadastrarClienteGUI gui = new CadastrarClienteGUI();
        gui.setVisible(true);
    }

    /**Método que vai mostrar a imagem de um cliente.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param urlFoto String - a url da foto que vai ser mostrada.
     *
     */
    public void telaImagem(String urlFoto) {
        MostrarIconGUI gui = new MostrarIconGUI(urlFoto);
        gui.setVisible(true);
    }

    /**Método que vai alterar um cliente no banco de dados.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param cliente Cliente - Um objeto cliente.
     *
     */
    public void alterar(Cliente cliente) {
        new DadoPessoalDAOOracle().atualizarDadoPessoal(cliente);
    }


    
}
