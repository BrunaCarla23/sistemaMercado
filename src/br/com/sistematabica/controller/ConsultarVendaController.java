
package br.com.sistematabica.controller;

import br.com.sistematabica.dao.CompraProdutoDAOOracle;
import br.com.sistematabica.dao.VendaDAOOracle;
import br.com.sistematabica.view.vendas.ConsultarVendaGUI;
import javax.swing.JOptionPane;

/**Controller que vai ser responsável por tudo relacionado a consultar venda.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ConsultarVendaController {
    
    // tela de consultar vendas
    private static ConsultarVendaGUI consultarVendaGUI;

    /**Método que vai mostrar a tela consultarVenda.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void showTela() {
        consultarVendaGUI = new ConsultarVendaGUI(new VendaDAOOracle().selecionarTodasVendas());
        consultarVendaGUI.setVisible(true);
    }

    /**Método que vai imprimir a relação das vendas.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void relacao() {
        JOptionPane.showMessageDialog(null, "Ops, infelizmente essa funcionalidade não esta diponivel");
    }
    
    /**Método que vai deletar uma venda.
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param id int - o id da venda.
     *
     * @return boolean - true se removido com sucesso, false se teve alguma falha.
     * 
     */
    public boolean deletar(int id) {
        
        boolean compraProduto = new CompraProdutoDAOOracle().deletarCompraProduto(id);
        boolean venda = new VendaDAOOracle().deletarVenda(id);
        
        return compraProduto && venda;
    }

}
