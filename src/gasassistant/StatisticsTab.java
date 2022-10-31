package gasassistant;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class StatisticsTab extends javax.swing.JFrame {
    
    private Object[][] data = new Object[][]{};
    private GasGUI parentFrame;
    
    class JTableButtonModel extends AbstractTableModel {
        
       private Object[][] rows = new Object[][]{};
       private String[] columns = new String[]{"Date", "Gas Price", "Gallons", "Daily Total", ""};
       
       public JTableButtonModel(Object[][] rows) {
            this.rows = rows;
       }

       public int getRowCount() {
          return rows.length;
       }
       
       public int getColumnCount() {
          return columns.length;
       }
       
       public Object getValueAt(int row, int column) {
          System.out.println("Row: " + row + " Column: " +column);
          return rows[row][column];
       }
       
       public boolean isCellEditable(int row, int column) {
          return false;
       }
       
       public Class getColumnClass(int column) {
          return getValueAt(0, column).getClass();
       }
    }
    
    public void setGasGUI(GasGUI gasGUI) {
    
        this.parentFrame = gasGUI;
    
    }
    

    public StatisticsTab() {
        
        initComponents();
        
        populateTable();
 
    }
    
    ArrayList<DateEvent> delCreateList = new ArrayList<>();
    
    private void createDelBtns() {
    
        for( DateEvent curEvent : delCreateList ) {
            Action delete = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    GasGUI.dateEvents.remove(curEvent);
                    Collections.sort(GasGUI.dateEvents);
                    parentFrame.setNeedsSaving(true);
                    populateTable();
                }
            };

            DelButtons buttonColumn = new DelButtons(statisticTable, delete, 4);
        }
        delCreateList.clear();
    
    }
    
    public void populateTable() {
        
        
        if( !GasGUI.dateEvents.isEmpty() ) {
            System.out.println("Valid Array detected");
            Object[][] newData = new Object[GasGUI.dateEvents.size()][];
            for(int i = 0; i < GasGUI.dateEvents.size(); i++) {
                DateEvent curEvent = GasGUI.dateEvents.get(i);
                DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
                String simplifliedDate = outputFormatter.format(curEvent.getDate());
                String curDate = simplifliedDate;
                String curUnitRate = Double.toString(curEvent.getUnitRate());
                String curGallons = Double.toString(curEvent.getGallons());
                String dayTotal = Double.toString(curEvent.getUnitRate() * curEvent.getGallons());
                delCreateList.add(curEvent);
                
                Object[] newObject = new Object[]{curDate, curUnitRate, curGallons, dayTotal, "Remove " + curDate};
                newData[i] = newObject;
            }
            
            data = newData;

        } else {
            System.out.println("Array empty, using empty array fallback.");
            data = new Object[][]{};
        }
        statisticTable.setModel(
                new DefaultTableModel(
                        data, 
                        new String[]{"Date", "Unit Cost", "Gallons", "Total", ""})
        );
        createDelBtns();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        statisticTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                if(column == 4) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        statisticTable.setAutoCreateRowSorter(true);
        statisticTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Unit Price", "Gallons", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        statisticTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(statisticTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable statisticTable;
    // End of variables declaration//GEN-END:variables
}
