
package br.com.sistematabica.view.principal;

import br.com.sistematabica.controller.PrincipalController;
import br.com.sistematabica.dao.GerenteDAOOracle;
import br.com.sistematabica.view.cadastrar.conta.gerente.CadastrarGerenteGUI;

/**Classe inicial do projeto.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class Main {
    
    private static GerenteDAOOracle gerenteDAO = new GerenteDAOOracle();
    
    public static void main(String [] args) {
        
        if(gerenteDAO.isGerente()) {
            
            System.out.println("sistema: Existe pelo menos 1 gerente");
            PrincipalController principalController = new PrincipalController();
            principalController.showGUI();
                
        }else {
            
            System.out.println("sistema: não existe gerent no sistma");
            CadastrarGerenteGUI cadastrarGerenteGUI = new CadastrarGerenteGUI();
            cadastrarGerenteGUI.setVisible(true);
   
        }

    }
}
