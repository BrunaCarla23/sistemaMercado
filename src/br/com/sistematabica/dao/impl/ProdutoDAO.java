/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;

import br.com.sistematabica.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface ProdutoDAO {
    public void inserirProduto(Produto produto);
    public void dropProduto(Produto produto);
    public ArrayList<Produto>readCliente();
    public Produto updateProduto(Produto produto);
    
}
