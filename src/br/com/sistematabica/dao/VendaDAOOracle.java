/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.Cliente;
import br.com.sistematabica.model.DadoPessoal;
import br.com.sistematabica.model.Venda;
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
public class VendaDAOOracle {
     public void inserirVenda(Venda venda) {
         
         
        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("INSERT INTO TABELA_ATENDE (ID,NOME_OPERADOR,NOME_CLIENTE,VALOR_FINAL,DATA_COMPRA) VALUES (?,?,?,?,?)");) {

            stm.setInt(1, venda.getId());
            stm.setString(2, venda.getOperadorCaixa());
            stm.setString(3, venda.getCliente());
            stm.setDouble(4, venda.getValorFinal());
            stm.setString(5, venda.getDataCompra());

            stm.addBatch();
            stm.executeBatch();

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar a venda");
            printStackTrace();
        }
         
         
     }

    public int idMaxVenda() {
        ArrayList<String> list = new ArrayList<>();

        try {
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT max(ID) FROM TABELA_ATENDE");
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

    public ArrayList<Venda> selecionarTodasVendas() {

        ArrayList<Venda> list = new ArrayList<>();

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT ID,NOME_OPERADOR,NOME_CLIENTE,VALOR_FINAL,DATA_COMPRA FROM TABELA_ATENDE");
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {

                Venda venda = new Venda();

                venda.setCliente(rs.getString("NOME_CLIENTE"));
                venda.setDataCompra(rs.getString("DATA_COMPRA"));
                venda.setId(rs.getInt("ID"));
                venda.setOperadorCaixa(rs.getString("NOME_OPERADOR"));
                venda.setValorFinal(rs.getDouble("VALOR_FINAL"));
                
                list.add(venda);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar as vendas");
            printStackTrace();
        }

        return list;
    
    }

    public boolean deletarVenda(int numeroRegistro) {
        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("DELETE FROM TABELA_ATENDE WHERE ID = ?");) {
            stm.setInt(1, numeroRegistro);

            stm.addBatch();
            stm.executeBatch();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar dados pessoais");
            printStackTrace(); 
        }
        
        return false;
    }

}
