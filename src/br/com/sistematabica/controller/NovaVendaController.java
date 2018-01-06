
package br.com.sistematabica.controller;

import br.com.sistematabica.dao.CompraProdutoDAOOracle;
import br.com.sistematabica.dao.ProdutoDAOOracle;
import br.com.sistematabica.dao.VendaDAOOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.model.Produto;
import br.com.sistematabica.model.Venda;
import br.com.sistematabica.model.tablemodel.NovaVendaTableModel;
import br.com.sistematabica.view.vendas.NovaVendaGUI;
import java.util.ArrayList;

/**Classe Controller que vai ser responsável por tudo relacionado a vendas.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class NovaVendaController {

    // tela de novas vendas
    private static NovaVendaGUI novaVendaGUI;

    /**Método que vai mostrar a tela de novas venda pasando por paramentro um vendedor, todos os cliente e o cod de numero de venda
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param nomeVendedor String - nome do vendedor
     * @param clientes ArrayList - todos os clientes
     * @param codNumeroVenda int cod do numero da venda
     *
     */
    public void showTela(String nomeVendedor, ArrayList<Cliente> clientes, int codNumeroVenda) {
        novaVendaGUI = new NovaVendaGUI(nomeVendedor, clientes, codNumeroVenda);
        novaVendaGUI.setVisible(true);
    }
    
    /**Método que vai retornar um produto pelo id
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param id Int - id do produto
     * 
     * @return Produto - o produto escolhido
     *
     */
    public Produto idProduto(int id) {
            return new ProdutoDAOOracle().selecionarUmProduto(id);
    }

    /**Método que vai salvar vendas no banco de dados
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     * @param venda Venda - a venda
     * @param novaVendaTableModel NovaVendaTableModel - todos os produtos que foi vendido
     *
     */
    public void salvarVenda(Venda venda, NovaVendaTableModel novaVendaTableModel) {
        new VendaDAOOracle().inserirVenda(venda);
        new CompraProdutoDAOOracle().inserirCompra(venda.getId(), novaVendaTableModel);
    }

    /**Método que vai validar se o produto existe
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param cod Int - cod do produto
     * 
     * @return boolean - se for valido retorna true, senão false
     *
     */
    public boolean validarProdutoCod(int cod) {
        return new ProdutoDAOOracle().validarProdutoCod(cod);
    }
    
}
