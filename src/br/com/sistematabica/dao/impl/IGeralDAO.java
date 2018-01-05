/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.dao.impl;

/**
 *
 * @author Joel
 */
public interface IGeralDAO {
    public void novo();
    public void remove(int id);
    public void update(Object obj, int id);
}
