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
public class CompraProduto {
    
    int numeroVenda, numeroProduto;

    public CompraProduto() {
    }

    public CompraProduto(int numeroVenda, int numeroProduto) {
        this.numeroVenda = numeroVenda;
        this.numeroProduto = numeroProduto;
    }

    public int getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public int getNumeroProduto() {
        return numeroProduto;
    }

    public void setNumeroProduto(int numeroProduto) {
        this.numeroProduto = numeroProduto;
    }
    
    
    
}
