/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;


import br.com.sistematabica.model.Gerente;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface GerenteDAO {
    public void inserirGerente(Gerente gerente); 
    public void deletarGerente(int id);
    public ArrayList<Gerente>readGerente();
    public Gerente updateGerente(Gerente gerente);
    public Gerente readOneGerente(String cpf);
    public boolean isGerente(); //retorna se tem algum gerente no sistema
}
