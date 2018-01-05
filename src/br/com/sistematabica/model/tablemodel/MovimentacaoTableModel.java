
package br.com.sistematabica.model.tablemodel;

import br.com.sistematabica.model.Venda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**Table model do movimentacao.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class MovimentacaoTableModel extends AbstractTableModel{
    private ArrayList<Venda> dados = new ArrayList<>(); 
    private String[] colunas = {"Data compra","Valor final","Cliente"};
    
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
                return dados.get(rowIndex).getCliente();
            default:
                return null;
        }
    }
    
    public void addRow(Venda teste) {
        this.dados.add(teste);
        this.fireTableDataChanged();
    }

}
