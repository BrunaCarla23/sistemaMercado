
package br.com.sistematabica.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**Classe que contém a Connection, onde para abrir um conexão ou fechar tem que instanciar a mesma.
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
    
    /**Método que vai abrir a conexão
     * 
     * @author Joel Henrique
     * @author Evelyn Mayara
     * @author Lucas Gabriel
     * 
     * @return Connection - Classe connection
     *
     */
    public Connection getConnection() {
        try{
            //con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Database username","senha");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bancosistematabica","lajedo10");
        }catch(SQLException ex){
            System.out.println("dao>ConexaoOracle: Erro ao abrir uma conexão!");
        }finally{
            return con;
        }
    }
    
    /**Método que vai fechar a conexão com o banco de dados
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
            System.out.println("dao>ConexaoOracle: Erro ao fechar a conexão!");
        }
    }
    
}
