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
public class Cliente {
    private DadoPessoal dados;

    public Cliente(DadoPessoal dados) {
        this.dados = dados;

    }

    public Cliente() {
    }

    public DadoPessoal getDados() {
        return dados;
    }

    public void setDados(DadoPessoal dados) {
        this.dados = dados;
    }


}
