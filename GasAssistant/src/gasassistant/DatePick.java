package gasassistant;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;


public class DatePick {
   
    JFrame parentFrame;
    JDialog dialog;
    UtilDateModel model;
    Properties p;
    JDatePanelImpl datePanel;
    
    public DatePick(JFrame parentFrame, JButton trigBtn) {
        
        this.parentFrame = parentFrame;
        
        dialog = new JDialog();
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        
        model = new UtilDateModel();
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        
        if( parentFrame instanceof GasGUI ) {
            
            GasGUI curFrame = (GasGUI) parentFrame;
            datePanel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    curFrame.selectedDate = (Date)datePanel.getModel().getValue();
                    curFrame.updateDateLabel();
                    dialog.setVisible(false);
                    dialog.dispose();
                }
            });
            
        } else if( parentFrame instanceof CalculateTab) {
            
            CalculateTab curFrame = (CalculateTab) parentFrame;
            
            if(trigBtn == curFrame.startDateSelector) {
                datePanel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        curFrame.setStartDate((Date)datePanel.getModel().getValue());
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
            } else {
                datePanel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        curFrame.setEndDate((Date)datePanel.getModel().getValue());
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
            }
                
        }
        
        dialog.add(datePanel);
        dialog.setTitle("Calendar");
        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }
   
}