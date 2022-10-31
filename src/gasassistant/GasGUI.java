package gasassistant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GasGUI extends JFrame {
    
    public static ArrayList<DateEvent> dateEvents = new ArrayList<>();
    public static Date selectedDate;
    public static boolean needsSaving = false;
    public static File currentFile;
    public static final String defaultFileName = "New File";
    public static String currentFileName;
    private static final JFileChooser fc = new JFileChooser();
    private static final DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
    private static CalculateTab calculateTab;
    private static StatisticsTab statisticsTab;
    private static final String defaultTitle = "Gas Assistant";
    
    public void setNeedsSaving(boolean needsSaving) {
        this.needsSaving = needsSaving;
        if(needsSaving) {
            setTitle(defaultTitle + " - " + currentFileName + "*" );
        } else {
            setTitle(defaultTitle + " - " + currentFileName );
        }
    }
    
    private void resetTitle() {
        setTitle(defaultTitle + "- New File");
    }
    
    private void setCurrentFile(File file) {
        currentFile = file;
        currentFileName = file.getName();
    }
    
    public void setCalculateTab(CalculateTab calculateTab) {
        this.calculateTab = calculateTab;
    }
    
    public void setStatisticsTab(StatisticsTab statisticsTab) {
        this.statisticsTab = statisticsTab;
    }
    
    private void displayDateEvents() {
        System.out.println("Printing current date events: ");
        for( DateEvent curEvent : dateEvents ) {
            System.out.println(curEvent.toString());
        }
    }
        
    public GasGUI(CalculateTab calculateTab, StatisticsTab statisticsTab) {
        initComponents();
        this.calculateTab = calculateTab;
        this.statisticsTab = statisticsTab;
        newFile();
    }
    
    public static HashMap<String, Double> calculateCost(Date startDate, Date endDate) {

        HashMap<String, Double> total = new HashMap<>();
        int totalCount = 0;
        double totalCost = 0, totalGallons = 0, averageCost, averageGallons;

        for( DateEvent curEvent : dateEvents ) {
            if(curEvent.getDate().after(startDate) && curEvent.getDate().before(endDate)) {
                totalCount++;
                totalCost += curEvent.getCost();
                totalGallons += curEvent.getGallons();
            }
        }

        averageCost = totalCost / totalCount;
        averageGallons = totalGallons / totalCount;
        total.put("costTotal", totalCost);
        total.put("gallonTotal", totalGallons);
        total.put("costAverage", averageCost);
        total.put("gallonAverage", averageGallons);
        
        return total;

    }
    
    public void updateDateLabel(){
        
        String simplifliedDate = outputFormatter.format(selectedDate);
        showSelected.setText(simplifliedDate);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        titleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        statisticButton = new javax.swing.JButton();
        calculateButton = new javax.swing.JButton();
        textDateLabel = new javax.swing.JLabel();
        textUnitPriceLabel = new javax.swing.JLabel();
        textGallonsLabel = new javax.swing.JLabel();
        TextPrice = new javax.swing.JTextField();
        TextGallons = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        textNewRefuel = new javax.swing.JLabel();
        dateButton = new javax.swing.JButton();
        showSelected = new javax.swing.JLabel();
        errorReport = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveAsMenu = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gas Assistant ");
        setPreferredSize(new java.awt.Dimension(1050, 750));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Gas Assistant");
        titleLabel.setToolTipText("");

        statisticButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        statisticButton.setText("Entries");
        statisticButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticButtonActionPerformed(evt);
            }
        });

        calculateButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        textDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDateLabel.setText("Date :");

        textUnitPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textUnitPriceLabel.setText("Unit Price ($) :");

        textGallonsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textGallonsLabel.setText("Gallons (gal.) :");

        TextPrice.setText("0.00");

        TextGallons.setText("0.00");

        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        textNewRefuel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        textNewRefuel.setText("New Refuel");

        dateButton.setText("Select Date");
        dateButton.setToolTipText("");
        dateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateButtonActionPerformed(evt);
            }
        });

        showSelected.setText("Not Selected");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        newMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenu.setText("New File");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        fileMenu.add(newMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenu);

        saveAsMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenu.setText("Save As");
        saveAsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenu);

        jMenuBar.add(fileMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(statisticButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUnitPriceLabel)
                            .addComponent(textGallonsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(TextPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(TextGallons)
                            .addComponent(AddButton)
                            .addComponent(textNewRefuel)
                            .addComponent(dateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showSelected)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(errorReport)))))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {calculateButton, statisticButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textDateLabel, textGallonsLabel, textUnitPriceLabel});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TextGallons, TextPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statisticButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(textDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(textNewRefuel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateButton)
                        .addGap(34, 34, 34)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textUnitPriceLabel))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textGallonsLabel)
                    .addComponent(TextGallons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorReport)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {calculateButton, statisticButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {textDateLabel, textGallonsLabel, textUnitPriceLabel});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TextGallons, TextPrice});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statisticButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticButtonActionPerformed
        statisticsTab.setVisible(true);
        statisticsTab.setLocationRelativeTo(this);
    }//GEN-LAST:event_statisticButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        calculateTab.setVisible(true);
        calculateTab.setLocationRelativeTo(this);
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        if(selectedDate != null){
            
            try {
                DateEvent newDateEvent = new DateEvent(selectedDate, 
                Double.valueOf(TextPrice.getText()), 
                Double.valueOf(TextGallons.getText()));
                dateEvents.add(newDateEvent);
                displayDateEvents();
                errorReport.setText("");
                setNeedsSaving(true);
                statisticsTab.populateTable();
            } catch(NumberFormatException e) {
                errorReport.setText("Error: Please Enter a Number.");
                }
            
        } else{
            errorReport.setText("Error: Date not Selected.");
            }
        
       
    }//GEN-LAST:event_AddButtonActionPerformed

    private void dateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateButtonActionPerformed
        DatePick datePicker = new DatePick(this, dateButton);
    }//GEN-LAST:event_dateButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean shouldContinue = true;
        if(needsSaving) {
            shouldContinue = shouldSave();
        }
        if( shouldContinue ) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        
        boolean shouldContinue = true;
        if(needsSaving) {
            shouldContinue = shouldSave();
        }
        
        if(shouldContinue) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("Opening: " + file.getName());
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    dateEvents = (ArrayList) ois.readObject();

                    ois.close();
                    fis.close();
                    setCurrentFile(file);
                    setNeedsSaving(false);
                    displayDateEvents();
                    statisticsTab.populateTable();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                    return;
                } 
                catch (ClassNotFoundException c) {
                    System.out.println("Class not found");
                    c.printStackTrace();
                    return;
                }

            } else {
                    System.out.println("Open command cancelled by user");
            }
        }
    }//GEN-LAST:event_openMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        saveFile();
    }//GEN-LAST:event_saveMenuActionPerformed

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        boolean shouldContinue = true;
        if( needsSaving ) {
            shouldContinue = shouldSave();
        }
        if(shouldContinue) {
            newFile();
        }
    }//GEN-LAST:event_newMenuActionPerformed

    private void saveAsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuActionPerformed
        saveFileAs();
    }//GEN-LAST:event_saveAsMenuActionPerformed
    
    private void saveFile() {        
        if( currentFile != null && needsSaving ) {
            try {
                FileOutputStream fos = new FileOutputStream(currentFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(dateEvents);
                oos.close();
                fos.close();
                setNeedsSaving(false);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            saveFileAs();
        }
    }
    
    private void saveFileAs() {
        
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("Saving: " + file.getName() + ".");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(dateEvents);
                oos.close();
                fos.close();
                setCurrentFile(file);
                setNeedsSaving(false);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
                System.out.println("Save command cancelled by user.");
        }
        
    }
        
    private void newFile() {
        currentFile = null;
        dateEvents = new ArrayList<DateEvent>();
        currentFileName = defaultFileName;
        statisticsTab.populateTable();
        setNeedsSaving(false);
        resetTitle();
    }
    
    private boolean shouldSave() {
        
        
        boolean shouldContinue = true;
        int save = JOptionPane.showConfirmDialog(this, "Would you like to save?", "Save",
        JOptionPane.YES_NO_CANCEL_OPTION);

        switch(save) {
            case 0:
                saveFile();
                break;
            case 1:
                break;
            case 2:
                shouldContinue = false;
                break;
            default:
                shouldContinue = false;
        }
        
        return shouldContinue;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField TextGallons;
    private javax.swing.JTextField TextPrice;
    private javax.swing.JButton calculateButton;
    public javax.swing.JButton dateButton;
    private javax.swing.JLabel errorReport;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem saveAsMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JLabel showSelected;
    private javax.swing.JButton statisticButton;
    private javax.swing.JLabel textDateLabel;
    private javax.swing.JLabel textGallonsLabel;
    private javax.swing.JLabel textNewRefuel;
    private javax.swing.JLabel textUnitPriceLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

