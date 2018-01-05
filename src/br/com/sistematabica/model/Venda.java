/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.model;

import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public class Venda {
    
    int id;
    double valorFinal;
    String dataCompra,operadorCaixa, cliente;

    public Venda() {
    }

    public Venda(int id, double valorFinal, String dataCompra, String operadorCaixa, String cliente) {
        this.id = id;
        this.valorFinal = valorFinal;
        this.dataCompra = dataCompra;
        this.operadorCaixa = operadorCaixa;
        this.cliente = cliente;
    }

    public String getOperadorCaixa() {
        return operadorCaixa;
    }

    public void setOperadorCaixa(String operadorCaixa) {
        this.operadorCaixa = operadorCaixa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

}
