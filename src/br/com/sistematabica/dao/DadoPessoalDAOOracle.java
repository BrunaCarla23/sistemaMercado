/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.model.DadoPessoal;
import br.com.sistematabica.model.Gerente;
import br.com.sistematabica.model.OperadorCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public class DadoPessoalDAOOracle{

    public void inserirDadoPessoal(DadoPessoal dadoPessoal) {
        
        Connection con = new ConexaoOracle().getConnection();
        try( 
                PreparedStatement stm = con.prepareStatement("INSERT INTO DADO_PESSOAL (ID, TIPO, NOME_COMPLETO, CPF, DATA_NASCIMENTO, SEXO, TELEFONE, CELULAR, CIDADE, BAIRRO, CEP, COMPLEMENTO, UF, URLFOTO, DATA_CADASTRO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           ){
            stm.setInt(1, maxIdDadoPessoal()+1);
            stm.setString(2, dadoPessoal.getTipo());
            stm.setString(3, dadoPessoal.getNomeCompleto());
            stm.setString(4, dadoPessoal.getCPF());
            stm.setString(5, dadoPessoal.getDataNascimento());
            stm.setString(6, dadoPessoal.getSexo());
            stm.setString(7, dadoPessoal.getPrimeiroTelefone());
            
            stm.setString(8, dadoPessoal.getNumeroCelular());
            stm.setString(9, dadoPessoal.getCidade());
            stm.setString(10, dadoPessoal.getBairro());
            stm.setString(11,dadoPessoal.getCEP());
            stm.setString(12,dadoPessoal.getComplemento());
            stm.setString(13,dadoPessoal.getUF());
            stm.setString(14,dadoPessoal.getURLFoto());
            stm.setString(15,dadoPessoal.getDataCadastro());

            stm.addBatch();
            stm.executeBatch();
            
        }catch(SQLException ex) {

            System.out.println("Erro ao inserir dados pessoais");
            
        }
    }


    public int maxIdDadoPessoal() {
    
        ArrayList<String> list = new ArrayList<>();
        
        try {
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT max(id) FROM DADO_PESSOAL");
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()) {
               return rs.getInt("max(id)");
            }

        } catch (SQLException ex) {
            System.out.println("err ao ver o maior dado pessoal");
        }
        
        
        return 0;
    }

   public Cliente atualizarDadoPessoal(Cliente cliente) {
        
        Connection con = new ConexaoOracle().getConnection();
        try( 
                 PreparedStatement stm = con.prepareStatement("UPDATE DADO_PESSOAL SET NOME_COMPLETO = ?, CPF = ?, DATA_NASCIMENTO = ?, SEXO = ?, TELEFONE = ?, CELULAR = ?, CIDADE = ?, BAIRRO = ?, CEP = ?, COMPLEMENTO = ?, UF = ?, URLFOTO = ? WHERE ID = ?");
            ){

            stm.setString(1, cliente.getDados().getNomeCompleto());
            stm.setString(2, cliente.getDados().getCPF());
            stm.setString(3, cliente.getDados().getDataNascimento());
            stm.setString(4, cliente.getDados().getSexo());
            stm.setString(5, cliente.getDados().getPrimeiroTelefone());
            stm.setString(6, cliente.getDados().getNumeroCelular());
            stm.setString(7, cliente.getDados().getCidade());
            stm.setString(8, cliente.getDados().getBairro());
            stm.setString(9, cliente.getDados().getCEP());
            stm.setString(10, cliente.getDados().getComplemento());
            stm.setString(11, cliente.getDados().getUF());
            stm.setString(12, cliente.getDados().getURLFoto());
            stm.setInt(13, cliente.getDados().getNumeroRegistro());
            
            stm.addBatch();
            stm.executeBatch();
            
            System.out.println("SISTEMA: DADOS_PESSOAL ATUALIZADO");
 
        }catch(SQLException ex) {
            //printStackTrace();
            System.out.println("SISTEMA: erro ao atualizar dados pessoais");
        }//finally{
            //conexaoOracle.closeConnection();
        //}
        return null;
    }
    
    
    public OperadorCaixa atualizarDadoPessoal(OperadorCaixa operador) {
        
        Connection con = new ConexaoOracle().getConnection();
        try( 
                 PreparedStatement stm = con.prepareStatement("UPDATE DADO_PESSOAL SET NOME_COMPLETO = ?, CPF = ?, DATA_NASCIMENTO = ?, SEXO = ?, TELEFONE = ?, CELULAR = ?, CIDADE = ?, BAIRRO = ?, CEP = ?, COMPLEMENTO = ?, UF = ?, URLFOTO = ? WHERE ID = ?");
            ){

            stm.setString(1, operador.getDados().getNomeCompleto());
            stm.setString(2, operador.getDados().getCPF());
            stm.setString(3, operador.getDados().getDataNascimento());
            stm.setString(4, operador.getDados().getSexo());
            stm.setString(5, operador.getDados().getPrimeiroTelefone());
            stm.setString(6, operador.getDados().getNumeroCelular());
            stm.setString(7, operador.getDados().getCidade());
            stm.setString(8, operador.getDados().getBairro());
            stm.setString(9, operador.getDados().getCEP());
            stm.setString(10, operador.getDados().getComplemento());
            stm.setString(11, operador.getDados().getUF());
            stm.setString(12, operador.getDados().getURLFoto());
            stm.setInt(13, operador.getDados().getNumeroRegistro());
            
            stm.addBatch();
            stm.executeBatch();
            
            System.out.println("SISTEMA: DADOS_PESSOAL ATUALIZADO");
 
        }catch(SQLException ex) {
            //printStackTrace();
            System.out.println("SISTEMA: erro ao atualizar dados pessoais");
        }//finally{
            //conexaoOracle.closeConnection();
        //}
        return null;
    }
   
    public OperadorCaixa atualizarDadoPessoal(Gerente gerente) {
        
        Connection con = new ConexaoOracle().getConnection();
        try( 
                 PreparedStatement stm = con.prepareStatement("UPDATE DADO_PESSOAL SET NOME_COMPLETO = ?, CPF = ?, DATA_NASCIMENTO = ?, SEXO = ?, TELEFONE = ?, CELULAR = ?, CIDADE = ?, BAIRRO = ?, CEP = ?, COMPLEMENTO = ?, UF = ?, URLFOTO = ? WHERE ID = ?");
            ){

            stm.setString(1, gerente.getDados().getNomeCompleto());
            stm.setString(2, gerente.getDados().getCPF());
            stm.setString(3, gerente.getDados().getDataNascimento());
            stm.setString(4, gerente.getDados().getSexo());
            stm.setString(5, gerente.getDados().getPrimeiroTelefone());
            stm.setString(6, gerente.getDados().getNumeroCelular());
            stm.setString(7, gerente.getDados().getCidade());
            stm.setString(8, gerente.getDados().getBairro());
            stm.setString(9, gerente.getDados().getCEP());
            stm.setString(10, gerente.getDados().getComplemento());
            stm.setString(11, gerente.getDados().getUF());
            stm.setString(12, gerente.getDados().getURLFoto());
            stm.setInt(13, new GerenteDAOOracle().idDadoPessoal(gerente.getDados().getNumeroRegistro()));
            
            stm.addBatch();
            stm.executeBatch();
            
            System.out.println("SISTEMA: DADOS_PESSOAL ATUALIZADO");
 
        }catch(SQLException ex) {
            //printStackTrace();
            System.out.println("SISTEMA: erro ao atualizar dados pessoais");
        }//finally{
            //conexaoOracle.closeConnection();
        //}
        return null;
    }

    public boolean deletarDadoPessoal(int id) {

        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("DELETE FROM DADO_PESSOAL WHERE ID = ?");) {
            stm.setInt(1, id);

            stm.addBatch();
            stm.executeBatch();
            
            return true;
        } catch (SQLException ex) {

            System.out.println("Erro ao deletar dados pessoais");
            return false;
        }
    }

    
}
