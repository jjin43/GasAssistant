package gasassistant;

import java.text.ParseException;


public class GasAssistant {
    
    public static void main(String[] args) throws ParseException {

        CalculateTab calculateTab = new CalculateTab();
        StatisticsTab statisticsTable = new StatisticsTab();
        GasGUI gasGUI = new GasGUI(calculateTab,statisticsTable);
        gasGUI.setVisible(true);
        gasGUI.setLocationRelativeTo(null);
        statisticsTable.setGasGUI(gasGUI);
    
    }
        
}