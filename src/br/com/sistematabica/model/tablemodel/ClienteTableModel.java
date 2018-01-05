
package br.com.sistematabica.model.tablemodel;

import br.com.sistematabica.model.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**Table model do cliente.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class ClienteTableModel extends AbstractTableModel{
  private ArrayList<Cliente> dados = new ArrayList<>();
    private String[] colunas = {"nomeCompleto","primeiroTelefone","numeroCelular","sexo","dataNascimento","cidade","UF","bairro","dataCadastro","CEP","CPF"};
    

    public Cliente getList(int id) {
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
                return dados.get(rowIndex).getDados().getNomeCompleto();
            case 1:
                return dados.get(rowIndex).getDados().getPrimeiroTelefone();
            case 2:
                return dados.get(rowIndex).getDados().getNumeroCelular();
            case 3:
                return dados.get(rowIndex).getDados().getSexo();
            case 4:
                return dados.get(rowIndex).getDados().getDataNascimento();
            case 5:
                return dados.get(rowIndex).getDados().getCidade();
            case 6:
                return dados.get(rowIndex).getDados().getUF();
            case 7:
                return dados.get(rowIndex).getDados().getBairro();
            case 8:
                return dados.get(rowIndex).getDados().getDataCadastro();
            case 9:
                return dados.get(rowIndex).getDados().getCEP();
            case 10:
                return dados.get(rowIndex).getDados().getCPF();
            default:
                return null;
        }
    }
    
    public void setValueAt(Object valor, int row, int column) {
        switch(column) {
            case 0:
                dados.get(row).getDados().setNomeCompleto((String)valor);
                break;
            case 1:
                dados.get(row).getDados().setPrimeiroTelefone((String)valor);
                break;
            case 2:
                dados.get(row).getDados().setNumeroCelular((String)valor);
                break;
            case 3:
                dados.get(row).getDados().setSexo((String)valor);
                break;
            case 4:
                dados.get(row).getDados().getDataNascimento();
            case 5:
                dados.get(row).getDados().getCidade();
            case 6:
                dados.get(row).getDados().getUF();
            case 7:
                dados.get(row).getDados().getBairro();
            case 8:
                dados.get(row).getDados().getDataCadastro();
            case 9:
                dados.get(row).getDados().getCEP();
            case 10:
                dados.get(row).getDados().getCPF();
            default:
                break;
        }
        this.fireTableRowsUpdated(row, row);
    }
  
    public void addRow(Cliente teste) {
        this.dados.add(teste);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
