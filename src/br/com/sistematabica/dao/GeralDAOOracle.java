/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao;

import br.com.sistematabica.conexao.ConexaoOracle;
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
public class GeralDAOOracle {
    
    
    public String pegarSenha(Connection con, String email) {

        try (
                PreparedStatement stm = con.prepareStatement("SELECT SENHA_LOGIN FROM GERENTE UNION SELECT SENHA_LOGIN FROM OPERADOR_CAIXA WHERE NOME_LOGIN = ?");) {
            con = new ConexaoOracle().getConnection();

            stm.setString(1, email);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                return rs.getString("SENHA_LOGIN");

            }

        } catch (SQLException ex) {
            System.out.println("erro ao selecionar a conta logada");
        }

        // return null;
        //}
        return null;
    
    }
    
    public boolean validarEmail(Connection con, String email) {

         try (PreparedStatement stm = con.prepareStatement("SELECT NOME_LOGIN FROM GERENTE UNION SELECT NOME_LOGIN FROM OPERADOR_CAIXA");
                
                ResultSet rs = stm.executeQuery();){
            
            while(rs.next()) {
                if(rs.getString("NOME_LOGIN").equalsIgnoreCase(email))
                    return false;
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro com banco de dados");
        }
         
        return true;
        
    }
    
    public ArrayList<String[]> returnLogin(Connection con) {
    
        ArrayList<String[]> login = new ArrayList<String[]>();
        
         try (PreparedStatement stm = con.prepareStatement("SELECT NOME_LOGIN, SENHA_LOGIN FROM GERENTE UNION SELECT NOME_LOGIN, SENHA_LOGIN FROM OPERADOR_CAIXA");
                
                ResultSet rs = stm.executeQuery();){
            
            while(rs.next()) {
                login.add(new String[]{rs.getString("NOME_LOGIN"),rs.getString("SENHA_LOGIN")});
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro com banco de dados");
            return null;
        }
         
        return login;
        
    }
    
    public Object returnConta(Connection con, String email, String senha) {

        try (
                PreparedStatement stm = con.prepareStatement("SELECT * FROM ((SELECT * FROM GERENTE) UNION (SELECT * FROM OPERADOR_CAIXA)) U INNER JOIN DADO_PESSOAL D ON U.DADO_PESSOAL = D.ID WHERE U.NOME_LOGIN like ? AND U.SENHA_LOGIN like ?");) {
            con = new ConexaoOracle().getConnection();

            stm.setString(1, email);
            stm.setString(2, senha);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String tipoConta = rs.getString("TIPO");
                if (tipoConta.equalsIgnoreCase("Gerente")) {

                    DadoPessoal dadoPessoal = new DadoPessoal();

                    dadoPessoal.setBairro(rs.getString("BAIRRO"));
                    dadoPessoal.setCEP(rs.getString("CEP"));
                    dadoPessoal.setCPF(rs.getString("CPF"));
                    dadoPessoal.setCidade(rs.getString("CIDADE"));
                    dadoPessoal.setComplemento(rs.getString("COMPLEMENTO"));
                    dadoPessoal.setDataCadastro(rs.getString("DATA_CADASTRO"));
                    dadoPessoal.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
                    dadoPessoal.setNomeCompleto(rs.getString("NOME_COMPLETO"));
                    dadoPessoal.setNumeroCelular(rs.getString("CELULAR"));
                    dadoPessoal.setNumeroRegistro(rs.getInt("ID"));
                    dadoPessoal.setPrimeiroTelefone(rs.getString("TELEFONE"));
                    dadoPessoal.setSexo(rs.getString("SEXO"));
                    dadoPessoal.setTipo(rs.getString("TIPO"));
                    dadoPessoal.setUF(rs.getString("UF"));
                    dadoPessoal.setURLFoto(rs.getString("URLFOTO"));

                    Gerente gerente = new Gerente(dadoPessoal, email, senha);

                    return gerente;

                } else if (tipoConta.equalsIgnoreCase("OperadorCaixa")) {

                    DadoPessoal dadoPessoal = new DadoPessoal();

                    dadoPessoal.setBairro(rs.getString("BAIRRO"));
                    dadoPessoal.setCEP(rs.getString("CEP"));
                    dadoPessoal.setCPF(rs.getString("CPF"));
                    dadoPessoal.setCidade(rs.getString("CIDADE"));
                    dadoPessoal.setComplemento(rs.getString("COMPLEMENTO"));
                    dadoPessoal.setDataCadastro(rs.getString("DATA_CADASTRO"));
                    dadoPessoal.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
                    dadoPessoal.setNomeCompleto(rs.getString("NOME_COMPLETO"));
                    dadoPessoal.setNumeroCelular(rs.getString("CELULAR"));
                    dadoPessoal.setNumeroRegistro(rs.getInt("ID"));
                    dadoPessoal.setPrimeiroTelefone(rs.getString("TELEFONE"));
                    dadoPessoal.setSexo(rs.getString("SEXO"));
                    dadoPessoal.setTipo(rs.getString("TIPO"));
                    dadoPessoal.setUF(rs.getString("UF"));
                    dadoPessoal.setURLFoto(rs.getString("URLFOTO"));

                    OperadorCaixa operadorCaixa = new OperadorCaixa();

                    operadorCaixa.setNomeLogin(email);
                    operadorCaixa.setSenhalogin(senha);
                    operadorCaixa.setDados(dadoPessoal);

                    return operadorCaixa;
                }

            }

        } catch (SQLException ex) {
            System.out.println("erro ao selecionar a conta logada");
        }

        // return null;
        //}
        return null;
    }
}
