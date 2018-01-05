/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.DadoPessoal;
import br.com.sistematabica.model.OperadorCaixa;
import br.com.sistematabica.model.Produto;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ProdutoDAOOracle {

    public void inserirProduto(Produto produto) {
        Connection con = new ConexaoOracle().getConnection();

        try (
                PreparedStatement stm = con.prepareStatement("INSERT INTO TABELA_PRODUTO (CODIGO,VALOR, DESCRICAO, ESTOQUE, CODIGO_BARRAS, NOME) VALUES (?,?,?,?,?,?)")) {

            stm.setInt(1, idMax_PRODUTO() + 1);
            stm.setDouble(2, produto.getValor());
            stm.setString(3, produto.getDescricao());
            stm.setInt(4, produto.getEstoque());
            stm.setString(5, produto.getCodigoBarras());
            stm.setString(6, produto.getNome());

            stm.addBatch();
            stm.executeBatch();

        } catch (SQLException ex) {
            //printStackTrace();
            System.out.println("Erro ao inserir o produto no banco de dados");

        }
    }

    public boolean dropProduto(int id) {

        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("DELETE FROM TABELA_PRODUTO WHERE CODIGO = ?");) {
            stm.setInt(1, id);

            stm.addBatch();
            stm.executeBatch();

            return true;
        } catch (SQLException ex) {

            System.out.println("Erro ao deletar dados pessoais");
            return false;
        }
    }

    public ArrayList<Produto> readCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produto updateProduto(Produto produto) {

        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("UPDATE TABELA_PRODUTO SET NOME = ?, VALOR = ?, DESCRICAO = ?, ESTOQUE = ?, CODIGO_BARRAS = ? WHERE CODIGO = ?");) {

            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getValor());
            stm.setString(3, produto.getDescricao());
            stm.setInt(4, produto.getEstoque());
            stm.setString(5, produto.getCodigoBarras());
            stm.setInt(6, produto.getCodigo());

            stm.addBatch();
            stm.executeBatch();

            System.out.println("SISTEMA: PRODUTO ATUALIZADO");

        } catch (SQLException ex) {
            //printStackTrace();
            System.out.println("SISTEMA: erro ao atualizar produto");
        }//finally{
        //conexaoOracle.closeConnection();
        //}
        return null;
    }

    public int idMax_PRODUTO() {

        ArrayList<String> list = new ArrayList<>();
        Connection con = new ConexaoOracle().getConnection();
        try (PreparedStatement stm = con.prepareStatement("SELECT max(CODIGO) FROM TABELA_PRODUTO");
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {
                return rs.getInt("max(CODIGO)");
            }

        } catch (SQLException ex) {
            System.out.println("Erro com banco de dados");
        }

        return 0;
    }

    public ArrayList<Produto> selecionarProduto() {

        ArrayList<Produto> list = new ArrayList<>();

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT CODIGO,VALOR, DESCRICAO, ESTOQUE, CODIGO_BARRAS, NOME FROM TABELA_PRODUTO");
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("CODIGO"));
                produto.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstoque(rs.getInt("ESTOQUE"));
                produto.setNome(rs.getString("NOME"));
                produto.setValor(rs.getDouble("VALOR"));

                list.add(produto);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar os operadores de caixa");
            printStackTrace();
        }

        return list;
    }

    public Produto selecionarUmProduto(int id) {

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT CODIGO,VALOR, DESCRICAO, ESTOQUE, CODIGO_BARRAS, NOME FROM TABELA_PRODUTO WHERE CODIGO = ?");) {

            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("CODIGO"));
                produto.setCodigoBarras(rs.getString("CODIGO_BARRAS"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setEstoque(rs.getInt("ESTOQUE"));
                produto.setNome(rs.getString("NOME"));
                produto.setValor(rs.getDouble("VALOR"));

                return produto;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Produto não cadastro!");
            printStackTrace();
        }

        return null;
    }

    public boolean validarProdutoCod(int cod) {

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT CODIGO FROM TABELA_PRODUTO");
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {

                if(cod == rs.getInt("CODIGO")){
                    return true;
                }

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar os operadores de caixa");
            printStackTrace();
        }

        return false;
    }

}
