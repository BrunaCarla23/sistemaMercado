/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.model.DadoPessoal;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public class ClienteDAOOracle {

    public void inserirCliente(Cliente cliente) {

        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("INSERT INTO TABELA_CLIENTE (ID,DADO_PESSOAL) VALUES (?,?)");) {

            stm.setInt(1, maxIdCliente() + 1);
            stm.setInt(2, new DadoPessoalDAOOracle().maxIdDadoPessoal());

            stm.addBatch();
            stm.executeBatch();

        } catch (SQLException ex) {
            System.out.println("Erro com preparedstament");
            printStackTrace();
        }
    }

    public int maxIdCliente() {

        ArrayList<String> list = new ArrayList<>();

        try {
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT max(id) FROM TABELA_CLIENTE");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                return rs.getInt("max(id)");
            }

        } catch (SQLException ex) {
            System.out.println("Erro com banco de dados");
            printStackTrace();
        }

        return 0;
    }

    public boolean deletarCliente(int id) {
        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("DELETE FROM TABELA_CLIENTE WHERE DADO_PESSOAL = ?");) {
            stm.setInt(1, id);

            stm.addBatch();
            stm.executeBatch();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar dados pessoais");
            printStackTrace(); 
        }
        
        return false;

    }


    public ArrayList<Cliente> selecionarTodosClientes() {

        ArrayList<Cliente> list = new ArrayList<>();

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT d.ID,d.DATA_CADASTRO, d.TIPO, d.NOME_COMPLETO, d.CPF, d.DATA_NASCIMENTO, d.SEXO, d.TELEFONE, d.CELULAR, d.CIDADE, d.BAIRRO, d.CEP, d.COMPLEMENTO, d.UF, d.URLFOTO, o.ID, o.DADO_PESSOAL FROM TABELA_CLIENTE o INNER JOIN DADO_PESSOAL d ON o.DADO_PESSOAL = d.ID");
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {

                DadoPessoal dado = new DadoPessoal();

                dado.setBairro(rs.getString("BAIRRO"));
                dado.setCEP(rs.getString("CEP"));
                dado.setCPF(rs.getString("CPF"));
                dado.setCidade(rs.getString("CIDADE"));
                dado.setComplemento(rs.getString("COMPLEMENTO"));
                dado.setDataCadastro(rs.getString("DATA_CADASTRO"));
                dado.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
                dado.setNomeCompleto(rs.getString("NOME_COMPLETO"));
                dado.setNumeroCelular(rs.getString("CELULAR"));
                dado.setNumeroRegistro(rs.getInt("ID"));
                dado.setPrimeiroTelefone(rs.getString("TELEFONE"));
                dado.setSexo(rs.getString("SEXO"));
                dado.setTipo(rs.getString("TIPO"));
                dado.setUF(rs.getString("UF"));
                dado.setURLFoto(rs.getString("URLFOTO"));

                Cliente cliente = new Cliente(dado);
                list.add(cliente);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar os clientes");
            printStackTrace();
        }

        return list;
    }

    public Cliente selecionarClienteAtual(int id) {

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT d.ID,d.DATA_CADASTRO, d.TIPO, d.NOME_COMPLETO, d.CPF, d.DATA_NASCIMENTO, d.SEXO, d.TELEFONE, d.CELULAR, d.CIDADE, d.BAIRRO, d.CEP, d.COMPLEMENTO, d.UF, d.URLFOTO, o.ID, o.DADO_PESSOAL FROM TABELA_CLIENTE o INNER JOIN DADO_PESSOAL d ON o.DADO_PESSOAL = d.ID where = ?");
                ResultSet rs = stm.executeQuery();) {

            stm.setInt(1, id);

            while (rs.next()) {

                DadoPessoal dado = new DadoPessoal();

                dado.setBairro(rs.getString("BAIRRO"));
                dado.setCEP(rs.getString("CEP"));
                dado.setCPF(rs.getString("CPF"));
                dado.setCidade(rs.getString("CIDADE"));
                dado.setComplemento(rs.getString("COMPLEMENTO"));
                dado.setDataCadastro(rs.getString("DATA_CADASTRO"));
                dado.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
                dado.setNomeCompleto(rs.getString("NOME_COMPLETO"));
                dado.setNumeroCelular(rs.getString("CELULAR"));
                dado.setNumeroRegistro(rs.getInt("ID"));
                dado.setPrimeiroTelefone(rs.getString("TELEFONE"));
                dado.setSexo(rs.getString("SEXO"));
                dado.setTipo(rs.getString("TIPO"));
                dado.setUF(rs.getString("UF"));
                dado.setURLFoto(rs.getString("URLFOTO"));

                return new Cliente(dado);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar os operadores de caixa");
            printStackTrace();
        }

        return null;
    }
}
