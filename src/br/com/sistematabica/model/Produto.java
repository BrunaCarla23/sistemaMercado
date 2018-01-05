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
public class Produto {
    private String codigoBarras,descricao,nome;
    
    private int estoque,codigo;
    
    private double valor;

    public Produto(String codigoBarras, String descricao, String nome, int estoque, int codigo, double valor) {
        this.codigoBarras = codigoBarras;
        this.descricao = descricao;
        this.nome = nome;
        this.estoque = estoque;
        this.codigo = codigo;
        this.valor = valor;
    }

    public Produto() {
        
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }



}
