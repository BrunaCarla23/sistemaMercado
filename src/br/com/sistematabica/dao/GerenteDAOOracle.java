/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.dao.impl.GerenteDAO;
import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.model.OperadorCaixa;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class GerenteDAOOracle implements GerenteDAO{

    @Override
    public void inserirGerente(Gerente gerente) {
        Connection con = new ConexaoOracle().getConnection();
        try(
            PreparedStatement stm = con.prepareStatement("INSERT INTO GERENTE (ID,DADO_PESSOAL,NOME_LOGIN, SENHA_LOGIN) VALUES (?,?,?,?)");
            ){
           
            
            //ADD NA TABELA_CLIENTE

            stm.setInt(1,maxIdGerente()+1);
            stm.setInt(2, new DadoPessoalDAOOracle().maxIdDadoPessoal());
            stm.setString(3, gerente.getNomeLogin());
            stm.setString(4, gerente.getSenhaLogin());
            
           
            stm.executeUpdate();

            
        }catch(SQLException ex) {
            //printStackTrace();
            System.out.println("Erro com ao inserir gerente");
        }//finally{
            //conexaoOracle.closeConnection();
        //}
    }
    
    public int idDadoPessoal(int idGerente) {

        try {
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT DADO_PESSOAL FROM GERENTE WHERE ID = ?");
            
            
            stm.setInt(1, idGerente);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
               return rs.getInt("DADO_PESSOAL");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao pegar o id gerente do dadoPessoal");
        }
        
        
        return 0;
    }
    
    public int maxIdGerente() {
    
        ArrayList<String> list = new ArrayList<>();
        
        try {
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT max(id) FROM GERENTE");
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()) {
               return rs.getInt("max(id)");
            }

        } catch (SQLException ex) {
            System.out.println("Erro com banco de dados");
        }
        
        
        return 0;
    }

    @Override
    public void deletarGerente(int id) {
                
        Connection con = new ConexaoOracle().getConnection();
        try( 
                PreparedStatement stm = con.prepareStatement("DELETE FROM GERENTE WHERE DADO_PESSOAL = ?");
           ){
            stm.setInt(1, id);

            stm.addBatch();
            stm.executeBatch();
            
        }catch(SQLException ex) {

            System.out.println("Erro ao deletar gerente");
            
        }
    }

    @Override
    public ArrayList<Gerente> readGerente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gerente updateGerente(Gerente gerente) {

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("UPDATE GERENTE SET NOME_LOGIN = ?, SENHA_LOGIN = ? WHERE ID = ?");) {

            stm.setString(1, gerente.getNomeLogin());
            stm.setString(2, gerente.getSenhaLogin());
            stm.setInt(3, gerente.getDados().getNumeroRegistro());

            stm.addBatch();
            stm.executeBatch();

            System.out.println("SISTEMA: atualizou operadorcaixa");

        } catch (SQLException ex) {
            System.out.println("SISTEMA: erro ao atualizar operador de caixa");
            printStackTrace();
        }
        return null;
        
        
    }

    @Override
    public Gerente readOneGerente(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isGerente() {
        
        try(
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT COUNT(ID) FROM GERENTE");
            ResultSet rs = stm.executeQuery();
                ) {

            while(rs.next()) {
                int countGerente = rs.getInt("COUNT(ID)");
                
                if(countGerente <= 0) {
                    return false;
                }else {
                    return true;
                }
            }
            
        }   catch (SQLException ex) {
            System.out.println("SISTEMA: erro ao ver se existe gerente no sistema");
            return false;
        }
        
        return false;

    }
}

  
    

