/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;

import br.com.sistematabica.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public interface ClienteDAO {
    public void inserirCliente(Cliente cliente);
    public void deletarCliente(int id);
    public ArrayList<Cliente>readCliente();
    public Cliente updateCliente(Cliente cliente);
    public Cliente readOneCliente(String cpf);
}
