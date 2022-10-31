package gasassistant;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;


public class DelButtons extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener{
	
    private JTable buttonTable;	
    private Action buttonAction;
    private Border delBorder;
    private Border hoverBorder;
    private DateEvent curEvent;
    private StatisticsTab caller;

    private JButton renBtn;
    private JButton actBtn;
    private Object actValue;
    private boolean isColumnAct;

    
    public DelButtons(JTable table, Action action, int column){
        
        this.buttonTable = table;
        this.buttonAction = action;

        renBtn = new JButton();
        actBtn = new JButton();
        actBtn.setFocusPainted( false );
        actBtn.addActionListener( this );
        delBorder = actBtn.getBorder();
        setFocusBorder( new LineBorder(Color.BLUE) );

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
        table.addMouseListener( this );
    }

    public Border getFocusBorder(){
        
        return hoverBorder;
    }

    public void setFocusBorder(Border focusBorder){
        
        this.hoverBorder = focusBorder;
        actBtn.setBorder( focusBorder );
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column){

        if (value == null){
                actBtn.setText( "" );
                actBtn.setIcon( null );
        } else if (value instanceof Icon){
                actBtn.setText( "" );
                actBtn.setIcon( (Icon)value );
            } else{
                actBtn.setText( value.toString() );
                actBtn.setIcon( null );
                }

        this.actValue = value;
        return actBtn;
    }

    @Override
    public Object getCellEditorValue(){
            return actValue;
    }

    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){

        if (isSelected){
            renBtn.setForeground(table.getSelectionForeground());
            renBtn.setBackground(table.getSelectionBackground());
        } else{
            renBtn.setForeground(table.getForeground());
            renBtn.setBackground(UIManager.getColor("Button.background"));
        }

        if (hasFocus){
            
            renBtn.setBorder(hoverBorder );
        } else{
            
            renBtn.setBorder(delBorder );
        }

        if (value == null){
            renBtn.setText( "" );
            renBtn.setIcon( null );
                
        } else if (value instanceof Icon){
            renBtn.setText( "" );
            renBtn.setIcon( (Icon)value );
            
        } else{
            renBtn.setText( value.toString() );
            renBtn.setIcon( null );
        }

        return renBtn;
    }

    public void actionPerformed(ActionEvent e){
        int row = buttonTable.convertRowIndexToModel(buttonTable.getEditingRow() );
        fireEditingStopped();

        ActionEvent event = new ActionEvent(
            buttonTable,
            ActionEvent.ACTION_PERFORMED,
            "" + row);
        buttonAction.actionPerformed(event);
    }

    public void mousePressed(MouseEvent e){
        
    	if (buttonTable.isEditing() && buttonTable.getCellEditor() == this){
            isColumnAct = true;
        }
    }

    public void mouseReleased(MouseEvent e){
    	if (isColumnAct &&  buttonTable.isEditing()){
            buttonTable.getCellEditor().stopCellEditing();
        }

	isColumnAct = false;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
