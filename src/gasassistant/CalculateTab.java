package gasassistant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class CalculateTab extends javax.swing.JFrame {
    
    private Date startDate = null, endDate = null;
    DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        updateStartDate();
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        updateEndDate();
    }
    
    public CalculateTab() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endDateSelector = new javax.swing.JButton();
        startDateSelector = new javax.swing.JButton();
        textStartDate = new javax.swing.JLabel();
        textEndDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonCal = new javax.swing.JButton();
        textTotalGallon = new javax.swing.JLabel();
        textTotalCost = new javax.swing.JLabel();
        textReturnError = new javax.swing.JLabel();
        titleCalculations = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textReturnGallons = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textReturnGasUsage = new javax.swing.JLabel();
        textReturnAvgCost = new javax.swing.JLabel();
        textReturnCost = new javax.swing.JLabel();

        setResizable(false);

        endDateSelector.setText("Select End Date");
        endDateSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateSelectorActionPerformed(evt);
            }
        });

        startDateSelector.setText("Select Start Date");
        startDateSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateSelectorActionPerformed(evt);
            }
        });

        textStartDate.setText("Not Selected");

        textEndDate.setText("Not Selected");

        jLabel3.setText("Start Date:");

        jLabel4.setText("End Date:");

        buttonCal.setText("Calculate");
        buttonCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalActionPerformed(evt);
            }
        });

        textTotalGallon.setText("Total Gas Usage (gal.) :");

        textTotalCost.setText("Total Cost ($) :");

        titleCalculations.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleCalculations.setText("Calculations");

        jLabel2.setText("Avg. Refuel Cost ($) :");

        textReturnGallons.setText("0.00");

        jLabel6.setText("Avg. Gas Refueled (gal.) :");

        textReturnGasUsage.setText("0.00");

        textReturnAvgCost.setText("0.00");

        textReturnCost.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(titleCalculations)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startDateSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(endDateSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textEndDate)
                    .addComponent(textStartDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textReturnError)
                    .addComponent(buttonCal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textTotalGallon)
                    .addComponent(jLabel2)
                    .addComponent(textTotalCost)
                    .addComponent(jLabel6))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textReturnGallons, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textReturnGasUsage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textReturnCost, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textReturnAvgCost, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(titleCalculations)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateSelector)
                            .addComponent(jLabel3)
                            .addComponent(textStartDate))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endDateSelector)
                            .addComponent(jLabel4)
                            .addComponent(textEndDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(textReturnError)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textReturnGallons)
                    .addComponent(textTotalGallon))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textReturnGasUsage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textReturnAvgCost))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTotalCost)
                    .addComponent(textReturnCost))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void updateStartDate() {
        textStartDate.setText(outputFormatter.format(startDate));
    }
    
    private void updateEndDate() {
        textEndDate.setText(outputFormatter.format(endDate));
    }
    
    private void startDateSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateSelectorActionPerformed
        new DatePick(this, startDateSelector);
    }//GEN-LAST:event_startDateSelectorActionPerformed

    private void endDateSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateSelectorActionPerformed
        new DatePick(this, endDateSelector);
    }//GEN-LAST:event_endDateSelectorActionPerformed

    private void buttonCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalActionPerformed
        if( startDate != null && endDate != null ) {
            HashMap<String, Double> calculatedCost = GasGUI.calculateCost(startDate, endDate);
            textReturnCost.setText(
                    Double.toString(calculatedCost.get("costTotal"))
            );
            textReturnGallons.setText(
                    Double.toString(calculatedCost.get("gallonTotal"))
            );
            textReturnAvgCost.setText(
                    Double.toString(calculatedCost.get("costAverage"))
            );
            textReturnGasUsage.setText(
                    Double.toString(calculatedCost.get("gallonAverage"))
            );
        } else{
            textReturnError.setText("Please Select Both Dates");
        }   
    }//GEN-LAST:event_buttonCalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCal;
    public javax.swing.JButton endDateSelector;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JButton startDateSelector;
    private javax.swing.JLabel textEndDate;
    private javax.swing.JLabel textReturnAvgCost;
    private javax.swing.JLabel textReturnCost;
    private javax.swing.JLabel textReturnError;
    private javax.swing.JLabel textReturnGallons;
    private javax.swing.JLabel textReturnGasUsage;
    private javax.swing.JLabel textStartDate;
    private javax.swing.JLabel textTotalCost;
    private javax.swing.JLabel textTotalGallon;
    private javax.swing.JLabel titleCalculations;
    // End of variables declaration//GEN-END:variables
}
