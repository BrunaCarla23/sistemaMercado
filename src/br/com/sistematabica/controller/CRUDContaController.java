
package br.com.sistematabica.controller;

import br.com.sistematabica.dao.ClienteDAOOracle;
import br.com.sistematabica.dao.DadoPessoalDAOOracle;
import br.com.sistematabica.dao.GerenteDAOOracle;
import br.com.sistematabica.dao.OperadorCaixaDAOOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.model.OperadorCaixa;

/**Controller geral.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class CRUDContaController{

   /**Método que vai inserir uma conta no banco.
    * 
    * @author Joel Henrique
    * @author Evelyn Mayara
    * @author Lucas Gabriel
    * 
    * @param conta Object - uma conta qualquer(gerente,cliente ou operador)
    * 
    */
    public void inserir(Object conta) {
        
        if(conta instanceof Gerente) {
            new DadoPessoalDAOOracle().inserirDadoPessoal(((Gerente) conta).getDados());
            new GerenteDAOOracle().inserirGerente((Gerente) conta);
       
        }else if(conta instanceof Cliente) {
        
            new DadoPessoalDAOOracle().inserirDadoPessoal(((Cliente) conta).getDados());
            new ClienteDAOOracle().inserirCliente((Cliente)conta);
            
        }else if(conta instanceof OperadorCaixa) {
            new DadoPessoalDAOOracle().inserirDadoPessoal(((OperadorCaixa) conta).getDados());
            new OperadorCaixaDAOOracle().inserirOperadorCaixa((OperadorCaixa) conta);
        }
        
    }

}
