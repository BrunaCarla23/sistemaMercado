///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.sistematabica.controller;
//
//import br.com.sistematabica.dao.ClienteDAOOracle;
//import br.com.sistematabica.dao.DadoPessoalDAOOracle;
//import br.com.sistematabica.dao.GerenteDAOOracle;
//import br.com.sistematabica.dao.OperadorCaixaDAOOracle;
//import br.com.sistematabica.model.Cliente;
//import br.com.sistematabica.model.Gerente;
//import br.com.sistematabica.model.OperadorCaixa;
//
///**
// *
// * @author Joel
// */
//public class CRUDContaController{
//
//    public void inserir(Object conta) {
//        
//        if(conta instanceof Gerente) {
//            new DadoPessoalDAOOracle().inserirDadoPessoal(((Gerente) conta).getDados());
//            new GerenteDAOOracle().inserirGerente((Gerente) conta);
//       
//        }else if(conta instanceof Cliente) {
//        
//            new DadoPessoalDAOOracle().inserirDadoPessoal(((Cliente) conta).getDados());
//            new ClienteDAOOracle().inserirCliente((Cliente)conta);
//            
//        }else if(conta instanceof OperadorCaixa) {
//            new DadoPessoalDAOOracle().inserirDadoPessoal(((OperadorCaixa) conta).getDados());
//            new OperadorCaixaDAOOracle().inserirOperadorCaixa((OperadorCaixa) conta);
//        }
//        
//    }
//
//}
