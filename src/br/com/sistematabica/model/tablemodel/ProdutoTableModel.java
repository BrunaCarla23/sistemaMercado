/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistematabica.model.tablemodel;

import br.com.sistematabica.model.OperadorCaixa;
import br.com.sistematabica.model.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**Table model do produto.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ProdutoTableModel extends AbstractTableModel{
    

    private ArrayList<Produto> dados = new ArrayList<>();
    private String[] colunas = {"codigo","nome","descrição","codigo de barras","estoque","valor"};
    
    public Produto getList(int id) {
        return dados.get(id);
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
       return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return dados.get(rowIndex).getCodigo();
            case 1:
                return dados.get(rowIndex).getNome();
            case 2:
                return dados.get(rowIndex).getDescricao();
            case 3:
                return dados.get(rowIndex).getCodigoBarras();
            case 4:
                return dados.get(rowIndex).getEstoque();
            case 5:
                return dados.get(rowIndex).getValor();
            default:
                return null;
        }
    }
    
    public void setValueAt(Object valor, int row, int column) {
        switch(column) {
            case 0:
                dados.get(row).getCodigo();
                break;
            case 1:
                dados.get(row).getNome();
                break;
            case 2:
                dados.get(row).getDescricao();
                break;
            case 3:
                dados.get(row).getCodigoBarras();
                break;
            case 4:
                dados.get(row).getEstoque();
            case 5:
                dados.get(row).getValor();
            default:
                break;
        }
        this.fireTableRowsUpdated(row, row);
    }
  
    public void addRow(Produto teste) {
        this.dados.add(teste);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
