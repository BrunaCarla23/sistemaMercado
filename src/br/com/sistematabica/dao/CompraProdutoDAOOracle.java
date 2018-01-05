/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.Produto;
import br.com.sistematabica.model.tablemodel.NovaVendaTableModel;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Joel
 */
public class CompraProdutoDAOOracle {

    public void inserirCompra(int idVenda, NovaVendaTableModel novaVendaTableModel) {
        
        for(Produto produto : novaVendaTableModel.getList()) {
        
            Connection con = new ConexaoOracle().getConnection();
            try (
                    PreparedStatement stm = con.prepareStatement("INSERT INTO TABELA_COMPRA (NUMERO_ATENDE, ID_PRODUTO) VALUES (?,?)");) {

                stm.setInt(1, idVenda);
                stm.setInt(2, produto.getCodigo());

                stm.addBatch();
                stm.executeBatch();

            } catch (SQLException ex) {
                System.out.println("Erro ao salvar os produtos comprado");
                printStackTrace();
            }
        
        }


        
    }

    public boolean deletarCompraProduto(int numeroRegistro) {
        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("DELETE FROM TABELA_COMPRA WHERE NUMERO_ATENDE = ?");) {
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
