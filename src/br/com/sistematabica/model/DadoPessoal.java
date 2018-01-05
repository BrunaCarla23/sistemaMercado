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
public class DadoPessoal {
    private int numeroRegistro;
    private String nomeCompleto,
            tipo,
            dataCadastro,
            bairro, 
            cidade, 
            complemento,
            primeiroTelefone, 
            numeroCelular, 
            UF,
            CPF,
            CEP, 
            URLFoto, 
            sexo, 
            dataNascimento;



    
    
   public  DadoPessoal(){
        
    }

    public DadoPessoal(String nomeCompleto, int numeroRegistro, String dataCadastro, String bairro, 
            String cidade, String complemento, String primeiroTelefone, String numeroCelular, String UF, 
            String CPF, String CEP, String URLFoto, String sexo, String dataNascimento) {
        
        this.nomeCompleto = nomeCompleto;
        this.numeroRegistro = numeroRegistro;
        this.dataCadastro = dataCadastro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.primeiroTelefone = primeiroTelefone;
        this.numeroCelular = numeroCelular;
        this.UF = UF;
        this.CPF = CPF;
        this.CEP = CEP;
        this.URLFoto = URLFoto;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }
    
    
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeComplete) {
        this.nomeCompleto = nomeComplete;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPrimeiroTelefone() {
        return primeiroTelefone;
    }

    public void setPrimeiroTelefone(String primeiroTelefone) {
        this.primeiroTelefone = primeiroTelefone;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getURLFoto() {
        return URLFoto;
    }

    public void setURLFoto(String URLFoto) {
        this.URLFoto = URLFoto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
