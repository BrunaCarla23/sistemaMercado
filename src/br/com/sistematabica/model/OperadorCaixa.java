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
public class OperadorCaixa {
    private DadoPessoal dados;
    private String nomeLogin, senhalogin;

    public OperadorCaixa(DadoPessoal dados, String nomeLogin, String senhalogin) {
        this.dados = dados;
        this.nomeLogin = nomeLogin;
        this.senhalogin = senhalogin;
    }

    public OperadorCaixa() {
       
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

    public String getSenhalogin() {
        return senhalogin;
    }

    public void setSenhalogin(String senhalogin) {
        this.senhalogin = senhalogin;
    }
}
