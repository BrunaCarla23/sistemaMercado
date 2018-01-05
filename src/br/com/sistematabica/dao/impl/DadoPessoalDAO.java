/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;

import br.com.sistematabica.model.DadoPessoal;
import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public interface DadoPessoalDAO {
    public void inserirDadoPessoal(DadoPessoal dadoPessoal); 
    public boolean deletarDadoPessoal(int id);
    public ArrayList<DadoPessoal>readDadoPessoal();
    public DadoPessoal atualizarOperadorCaixa(DadoPessoal dadoPessoal);
    public boolean isDadoPessoal(); //retorna se tem algum gerente no sistema
    public int maxIdDadoPessoal();
//
}
