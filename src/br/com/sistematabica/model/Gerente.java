/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.model;

/**
 *
 * @author Joel
 */
public class Gerente {
  private  DadoPessoal dados;
  private String nomeLogin, senhaLogin;

    public Gerente() {
    
    }
  
    public Gerente(DadoPessoal dados, String nomeLogin, String senhaLogin) {
        this.dados = dados;
        this.nomeLogin = nomeLogin;
        this.senhaLogin = senhaLogin;
    }

    public DadoPessoal getDados() {
        return dados;
    }

    public void setDados(DadoPessoal dados) {
        this.dados = dados;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }
}
