    /**Método para calculo da diária com base no salário do
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @param diasViagem int - Valor total das vendas do mês.
     *
     * @return Double - Valor da diaria
     *
     */

package br.com.sistematabica.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**Classe que contém a Connection.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ConexaoOracle {
    
    private Connection con;
    
    /**Método que vai retornar um objeto connection
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @return Connection - conexão
     *
     */
    public Connection getConnection() {
        try{
            //con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ifpe");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","workspaceTeste1","123");
        }catch(SQLException ex){
            System.out.println("Banco de dados: Erro ao abrir uma conexão");
        }finally{
            return con;
        }
    }
    
    /**Método que vai fechar a conexão de um objeto connection
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     *
     */
    public void closeConnection() {
        try{
            con.close();
        }catch(SQLException ex){
            System.out.println("BANCO DE DADOS: Erro ao fechar a conexão");
        }
    }
    
}
