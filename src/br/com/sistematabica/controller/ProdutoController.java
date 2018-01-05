package br.com.sistematabica.controller;

import br.com.sistematabica.dao.ProdutoDAOOracle;
import br.com.sistematabica.model.Produto;
import br.com.sistematabica.view.alterar.catalogo.produto.AlterarProdutoGUI;
import br.com.sistematabica.view.cadastrar.catalogo.produto.CadastrarProdutoGUI;
import br.com.sistematabica.view.catalogo.ProdutoGUI;
import javax.swing.JOptionPane;

/**Classe Controller que vai controlar tudo relacionado a produto.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ProdutoController {

    private ProdutoGUI telaGUI;

    /**Método que vai mostrar a tela principal de produto
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showGUI() {
        this.telaGUI = new ProdutoGUI(new ProdutoDAOOracle().selecionarProduto());
        this.telaGUI.setVisible(true);
    }

    /**Método que vai mostrar a tela para cadastrar um novo produto
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void novoGUI() {
        CadastrarProdutoGUI gui = new CadastrarProdutoGUI();
        gui.setVisible(true);
    }

    /**Método que vai inserir no banco dados um novo produto
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param produto Produto - o produto que vai se adicionado no banco
     *
     */
    public void novo(Produto produto) {
        new ProdutoDAOOracle().inserirProduto(produto);
    }

    /**Método que vai deletar um produto pelo id
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param id Int - id do produto
     * 
     * @return boolean - se deletado com sucesso true 
     *
     */
    public boolean excluir(int id) {

        boolean produto = new ProdutoDAOOracle().dropProduto(id);

        if (produto) {
            return true;
        } else {
            return false;
        }

    }

    /**Método que vai imprimir a relação dos produtos
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void relacao() {
        JOptionPane.showMessageDialog(null, "Função indisponível no momento");
    }

    /**Método que vai alterar o produto no banco
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param produto Produto - objeto produto
     *
     */
    public void alterar(Produto produto) {
        new ProdutoDAOOracle().updateProduto(produto);
    }

    /**Método que vai mostrar a tela de alteração do produto
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param produto Produto - objeto produto
     *
     */
    public void alterarGUI(Produto produto) {
        AlterarProdutoGUI alterar = new AlterarProdutoGUI(produto);
        alterar.setVisible(true);
    }
}
