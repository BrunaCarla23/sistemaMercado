/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;


import br.com.sistematabica.model.OperadorCaixa;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface OperadorCaixaDAO {
    public void inserirOperadorCaixa(OperadorCaixa operador);
    public boolean deletarOperadorCaixa(int id);
    public ArrayList<OperadorCaixa> selecionarTodosOperadorCaixa();
    public OperadorCaixa atualizarOperadorCaixa(OperadorCaixa operador);
    public OperadorCaixa selecionarOperadorCaixaAtual(int id);
    
}
