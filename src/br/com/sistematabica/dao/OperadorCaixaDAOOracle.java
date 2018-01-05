
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
import br.com.sistematabica.model.DadoPessoal;
import br.com.sistematabica.model.OperadorCaixa;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperadorCaixaDAOOracle {

    public void inserirOperadorCaixa(OperadorCaixa operador) {

        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("INSERT INTO OPERADOR_CAIXA (ID,DADO_PESSOAL,NOME_LOGIN, SENHA_LOGIN) VALUES (?,?,?,?)");) {

            stm.setInt(1, maxIdOperadorCaixa() + 1);
            stm.setInt(2, new DadoPessoalDAOOracle().maxIdDadoPessoal());
            stm.setString(3, operador.getNomeLogin());
            stm.setString(4, operador.getSenhalogin());

            stm.addBatch();
            stm.executeBatch();

        } catch (SQLException ex) {
            System.out.println("Erro com preparedstament");
            printStackTrace();
        }
    }

    public int maxIdOperadorCaixa() {

        ArrayList<String> list = new ArrayList<>();

        try {
            Connection con = new ConexaoOracle().getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT max(id) FROM OPERADOR_CAIXA");
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

    public boolean deletarOperadorCaixa(int id) {
        Connection con = new ConexaoOracle().getConnection();
        try (
                PreparedStatement stm = con.prepareStatement("DELETE FROM OPERADOR_CAIXA WHERE DADO_PESSOAL = ?");) {
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

    public ArrayList<OperadorCaixa> selecionarTodosOperadorCaixa() {

        ArrayList<OperadorCaixa> list = new ArrayList<>();

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT d.ID,d.DATA_CADASTRO, d.TIPO, d.NOME_COMPLETO, d.CPF, d.DATA_NASCIMENTO, d.SEXO, d.TELEFONE, d.CELULAR, d.CIDADE, d.BAIRRO, d.CEP, d.COMPLEMENTO, d.UF, d.URLFOTO, o.ID, o.DADO_PESSOAL, o.NOME_LOGIN, o.SENHA_LOGIN FROM OPERADOR_CAIXA o INNER JOIN DADO_PESSOAL d ON o.DADO_PESSOAL = d.ID");
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

                OperadorCaixa operadorCaixa = new OperadorCaixa(dado, rs.getString("NOME_LOGIN"), rs.getString("SENHA_LOGIN"));
                list.add(operadorCaixa);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar os operadores de caixa");
            printStackTrace();
        }

        return list;
    }

    public OperadorCaixa atualizarOperadorCaixa(OperadorCaixa operador) {

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("UPDATE OPERADOR_CAIXA SET NOME_LOGIN = ?, SENHA_LOGIN = ? WHERE ID = (SELECT ID FROM OPERADOR_CAIXA WHERE DADO_PESSOAL = ?)");) {

            stm.setString(1, operador.getNomeLogin());
            stm.setString(2, operador.getSenhalogin());
            stm.setInt(3, operador.getDados().getNumeroRegistro());

            stm.addBatch();
            stm.executeBatch();

            System.out.println("SISTEMA: atualizou operadorcaixa");

        } catch (SQLException ex) {
            System.out.println("SISTEMA: erro ao atualizar operador de caixa");
            printStackTrace();
        }
        return null;
    }

    public OperadorCaixa selecionarOperadorCaixaAtual(int id) {

        try (
                Connection con = new ConexaoOracle().getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT d.ID,d.DATA_CADASTRO, d.TIPO, d.NOME_COMPLETO, d.CPF, d.DATA_NASCIMENTO, d.SEXO, d.TELEFONE, d.CELULAR, d.CIDADE, d.BAIRRO, d.CEP, d.COMPLEMENTO, d.UF, d.URLFOTO, o.ID, o.DADO_PESSOAL, o.NOME_LOGIN, o.SENHA_LOGIN FROM OPERADOR_CAIXA o INNER JOIN DADO_PESSOAL d ON o.DADO_PESSOAL = d.ID where = ?");
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

                return new OperadorCaixa(dado, rs.getString("NOME_LOGIN"), rs.getString("SENHA_LOGIN"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar os operadores de caixa");
            printStackTrace();
        }

        return null;
    }

}
