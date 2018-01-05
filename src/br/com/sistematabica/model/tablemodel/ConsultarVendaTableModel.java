
package br.com.sistematabica.model.tablemodel;

import br.com.sistematabica.model.Produto;
import br.com.sistematabica.model.Venda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**Table model do consutalta a venda.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ConsultarVendaTableModel extends AbstractTableModel{

    private ArrayList<Venda> dados = new ArrayList<>();
    private String[] colunas = {"Data compra","Valor final","Operador","Cliente"};
    
    public Venda getList(int id) {
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
                return dados.get(rowIndex).getDataCompra();
            case 1:
                return dados.get(rowIndex).getValorFinal();
            case 2:
                return dados.get(rowIndex).getOperadorCaixa();
            case 3:
                return dados.get(rowIndex).getCliente();
            default:
                return null;
        }
    }
    
    public void setValueAt(Object valor, int row, int column) {
        switch(column) {
            case 0:
                dados.get(row).getDataCompra();
                break;
            case 1:
                dados.get(row).getValorFinal();
                break;
            case 2:
                dados.get(row).getOperadorCaixa();
                break;
            case 3:
                dados.get(row).getCliente();
                break;
        }
        this.fireTableRowsUpdated(row, row);
    }
  
    public void addRow(Venda teste) {
        this.dados.add(teste);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
