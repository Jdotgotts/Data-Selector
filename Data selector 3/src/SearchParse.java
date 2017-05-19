
import java.io.IOException; // My import 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jackg
 */
public class SearchParse { 
    
    // CLASS IS NOT USED, COULD NOT FIND USE FOR IT. 

   // ArrayList<String> AKM = new ArrayList(); // testing arraylist
    private String queries[]; // creating array of strings
    private String query; // creaing string variable
    GUI mainGUI; // creating GUI object from class GUI


    public SearchParse() throws IOException {
        this.mainGUI = new GUI(); // assinging object to class GUI 
    }
    
    
  public void parse (String query){ // parse method with string parameter
      this.query = query;  // assinging query variable to passed parameter
     //    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) mainGUI.dataTable.getModel()));
    //    sorter.setRowFilter(RowFilter.regexFilter(query));
       // mainGUI.dataTable.setRowSorter(sorter);
 
 
  }
  
  public String retrieveData(){ // retrieveData method
     // query = mainGUI.searchTxt.getText();
        return query; // returns the variable query 
      
  }
}
