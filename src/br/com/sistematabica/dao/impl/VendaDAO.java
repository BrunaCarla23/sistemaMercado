/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;

import br.com.sistematabica.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface VendaDAO {
     public void inserirVenda(Venda venda);
    public void dropVenda(Venda venda);
    public ArrayList<Venda>readGerente();
    public Venda updateVenda(Venda venda);
    public Venda readOneVenda(String cpf_cliente);
    
}
