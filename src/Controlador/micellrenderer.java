/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author luisj
 */
public class micellrenderer extends javax.swing.table.DefaultTableCellRenderer{
    
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, 
                                                   boolean isSelected, 
                                                   boolean hasFocus, 
                                                   int row, 
                                                   int column) {
 
        String estado = (String)table.getValueAt(row, 4);
        if(estado.compareTo("Finalizada") == 0){
            setBackground(java.awt.Color.GREEN);
        } else if (estado.compareTo("Pendiente") == 0){
            setBackground(java.awt.Color.YELLOW);
        } else if (estado.compareTo("Cancelada") == 0){
            setBackground(java.awt.Color.RED);
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
 

    
}
