
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;            // My imports
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jackg
 */
public class GUI extends javax.swing.JFrame { // extends JFrame 

    JFrame frame = new JFrame(); // declaring a new frame for dialog box 
    // I used Dialog boxes to face one of my HCI issues that gives the user more information on what is happening. By having a dialog box that pops up in the middle of screen 
    // makes it easier to read and lets the user identify the error that they have done.
    // For my GUI is chose the default colours as I believe they are much clearer and easier to read and navigate. 
    // I tried to space my Layout as much as possible so it was easier to see and understand by many different users 
    // By having the label saying what user is logged in, it gives the program more understandability by letting the user know. 

    Analyse analyse = new Analyse(); // creating an analyse object 
    ActivityLogger logger = new ActivityLogger(); // creating a ActivityLogger object 

    Vector<String> RDA = new Vector(); // creating a vector for my table row 
    Vector<String> districtID = new Vector(); // creating a vector for my table row 
    Vector<String> District = new Vector(); // creating a vector for my table row 
    Vector<String> Year = new Vector(); // creating a vector for my table row 
    Vector<String> reportType = new Vector(); // creating a vector for my table row 
    Vector<String> AKM = new Vector(); // creating a vector for my table row 
    Vector<String> BKM = new Vector(); // creating a vector for my table row 
    Vector<String> CKM = new Vector(); // creating a vector for my table row 
    Vector<String> DKM = new Vector(); // creating a vector for my table row 
    Vector<String> EKM = new Vector(); // creating a vector for my table row 
    Vector<String> FKM = new Vector(); // creating a vector for my table row 
    Vector<String> totalKM = new Vector(); // creating a vector for my table row 
    Vector<String> APC = new Vector(); // creating a vector for my table row 
    Vector<String> BPC = new Vector(); // creating a vector for my table row 
    Vector<String> CPC = new Vector(); // creating a vector for my table row 
    Vector<String> DPC = new Vector(); // creating a vector for my table row 
    Vector<String> EPC = new Vector(); // creating a vector for my table row 
    Vector<String> FPC = new Vector(); // creating a vector for my table row 
    Vector<String> goodPC = new Vector(); // creating a vector for my table row 
    Vector<String> fairPC = new Vector(); // creating a vector for my table row 
    Vector<String> poorPC = new Vector(); // creating a vector for my table row 
    Vector<String> badPC = new Vector(); // creating a vector for my table row 
    Vector<String> highPC = new Vector(); // creating a vector for my table row 
    ArrayList<String> AKMX = new ArrayList(); // creating arraylist for the X value /AKM/ in my table
    ArrayList<String> goodPCY = new ArrayList(); // creating arraylist for the Y value /goodPC/ in my table
    ArrayList<Double> xy = new ArrayList(); // creating arraylist for the XY value for my math sum
    ArrayList<Double> x2 = new ArrayList(); // creating arraylist for the X squared value for my math sum
    ArrayList<Double> y2 = new ArrayList(); // creating arraylist for the Y squared value for my math sum
    String query; // creating string variable 
    TableRowSorter sorter; // creating tableRowSorte

    /**
     * Creates new form GUI
     *
     * @throws java.io.IOException
     */
    public GUI() throws IOException {

        initComponents(); // Inititates components e.g. frame, button, lables, etc.. on create 

        String csvFile = "C:\\Users\\jackg\\Desktop\\ourDataset.csv";  //creating my file string to find my CSV file. 
        //CSV file has been edited to fill empty blanks with '0' as was throwing exception

        BufferedReader br = null; // Creating bufferedReader object is null
        String line = ""; // creating String line for buffered reader
        String cvsSplitBy = ","; // what my CSV file is split by. CSV files are always split up by commas.
        try {
            br = new BufferedReader(new FileReader(csvFile)); // bufferedReader reads CSV file uses CSV string 
            while ((line = br.readLine()) != null) { // while the line is not null 

                // use comma as separator
                String[] row = line.split(cvsSplitBy); // seperates each row by the comma
                RDA.add(row[0]); //adds the first row the the vector RDA
                districtID.add(row[1]); //adds the second row the the vector districtID
                District.add(row[2]); //adds the third row the the vector District
                Year.add(row[3]); //adds the fourth row the the vector Year
                reportType.add(row[4]); //adds the fifth row the the vector reportType
                AKM.add(row[5]); //adds the sixth row the the vector AKM
                BKM.add(row[6]); //adds the seven row the the vector BKM
                CKM.add(row[7]); //adds the eigth row the the vector CKM
                DKM.add(row[8]); //adds the ninth row the the vector DKM
                EKM.add(row[9]); //adds the tenth row the the vector EKM
                FKM.add(row[10]); //adds the eleven row the the vector FKM
                totalKM.add(row[11]); //adds the twelth row the the vector totalKM
                APC.add(row[12]); //adds the thirteen the the vector APC
                BPC.add(row[13]); //adds the fourteen the the vector BPC
                CPC.add(row[14]); //adds the fifteen the the vector CPC
                DPC.add(row[15]); //adds the sixteen the the vector DPC
                EPC.add(row[16]); //adds the seventeen the the vector EPC
                FPC.add(row[17]); //adds the eighteen the the vector FPC
                goodPC.add(row[18]); //adds the nineteen row the the vector goodPC
                fairPC.add(row[19]); //adds the twenty row the the vector fairPC
                poorPC.add(row[20]); //adds the twenty one row the the vector poorPC
                badPC.add(row[21]); //adds the twenty two row the the vector badPC
                highPC.add(row[22]); //adds the twenty three row the the vector highPC
            }
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException exception) { // catch if file not found
           
            JOptionPane.showMessageDialog(frame, "File not found or data invalid"); // diaglog box to let user know that the file was not found, helps them identifty the problem and also the developer.

        }
        if (br != null) { // if buffered reader is not null
            br.close(); //close buffered reader
        }

        DefaultTableModel model; // creating new DefaultTableModel object
        model = (DefaultTableModel) this.dataTable.getModel(); // assigning object to my table model
        RDA.remove(0); // removing the first row off the vector as it is the title and I already declared them
        districtID.remove(0); // removing the first row off the vector as it is the title and I already declared them
        District.remove(0); // removing the first row off the vector as it is the title and I already declared them
        Year.remove(0); // removing the first row off the vector as it is the title and I already declared them
        reportType.remove(0); // removing the first row off the vector as it is the title and I already declared them
        AKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        BKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        CKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        DKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        EKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        FKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        totalKM.remove(0); // removing the first row off the vector as it is the title and I already declared them
        APC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        BPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        CPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        DPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        EPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        FPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        goodPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        fairPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        poorPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        badPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        highPC.remove(0); // removing the first row off the vector as it is the title and I already declared them
        model.addColumn("RDA", RDA); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("DistrictID", districtID); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("District", District); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("Year", Year); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("ReportType", reportType); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("AKM", AKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("BKM", BKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("CKM", CKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("DKM", DKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("EKM", EKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("FKM", FKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("TotalKM", totalKM); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("APC", APC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("BPC", BPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("CPC", CPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("DPC", DPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("EPC", EPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("FPC", FPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("GOODpc", goodPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("FAIRpc", fairPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("POORpc", poorPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("BADpc", badPC); // Adding a column to my table with the assigned vector and the assigned title of the column 
        model.addColumn("HIGHpc", highPC); // Adding a column to my table with the assigned vector and the assigned title of the column 

    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        calCorrelationBtn = new javax.swing.JButton();
        correlationTxt = new javax.swing.JTextField();
        correlationOutputLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loggedUser = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        activityLogBtn = new javax.swing.JButton();
        MyGraph = new javax.swing.JPanel();

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(556, 406));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1002, 570));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        dataTable.setName(""); // NOI18N
        jScrollPane1.setViewportView(dataTable);

        calCorrelationBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        calCorrelationBtn.setText("Calculate Correlation");
        calCorrelationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calCorrelationBtnActionPerformed(evt);
            }
        });

        correlationOutputLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("River Quality");

        loggedUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loggedUser.setText("?");

        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchBtn.setText("Search data");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        activityLogBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        activityLogBtn.setText("Activity log");
        activityLogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityLogBtnActionPerformed(evt);
            }
        });

        MyGraph.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout MyGraphLayout = new javax.swing.GroupLayout(MyGraph);
        MyGraph.setLayout(MyGraphLayout);
        MyGraphLayout.setHorizontalGroup(
            MyGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        MyGraphLayout.setVerticalGroup(
            MyGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(loggedUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(activityLogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(326, 326, 326))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTxt)
                        .addGap(481, 481, 481))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(calCorrelationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(correlationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(correlationOutputLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MyGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loggedUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activityLogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calCorrelationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(correlationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correlationOutputLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MyGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1377, 1377, 1377)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void getUsername(User user) throws IOException {
        String username = user.getUser(); // getting username from object user in user class
        loggedUser.setText("User logged in as: " + username); // setting the label text to the username

    }
    private void calCorrelationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calCorrelationBtnActionPerformed
        double sumOfXY = 0; // declaring my variables
        double sumOfX2 = 0; // declaring my variables
        double sumOfY2 = 0; // declaring my variables
        double sumOfX = 0; // declaring my variables
        double sumOfY = 0; // declaring my variables
        int numOfSamples = 0; // declaring my variables
        Graphics2D gfx = (Graphics2D) MyGraph.getGraphics(); // creating graphics object

        gfx.clearRect(0, 0, getWidth(), getHeight());

        try {
            for (int row = 0; row < dataTable.getRowCount(); row++) { //loops through all rows of the table

                AKMX.add((String) dataTable.getModel().getValueAt(dataTable.convertRowIndexToModel(row), 5)); // Adding each string of selected row /5/ to the arraylist after every loop
                goodPCY.add((String) dataTable.getModel().getValueAt(dataTable.convertRowIndexToModel(row), 18)); // Adding each string of selected row /18/ to the arraylist after every loop
                double x = Double.parseDouble(AKMX.get(row)); // parsing a string to a double to get the row number and adding it to variable x

                double y = Double.parseDouble(goodPCY.get(row)); // parsing a string to a double to get the row number and adding it to variable y
                sumOfX = sumOfX + x; // adding each row of x value to the variable and adding them together to make sum
                sumOfY = sumOfY + y; // adding each row of y value to the variable and adding them together to make sum

                xy.add(x * y); // adding x and y times to arraylist after every loop.
                x2.add(x * x); // adding x and x times to arraylist after every loop.
                y2.add(y * y); // adding y and y times to arraylist after every loop.

            }

        } catch (NumberFormatException e) { // catch if not a number is found in table

        }

        for (int i = 0; i < xy.size(); i++) { // looping through the XY arraylist

            sumOfXY = sumOfXY + xy.get(i); //adding up each index in the arraylist and adding to the variable after every loop

        }

        for (int j = 0; j < x2.size(); j++) { // looping through the X squared arraylist

            sumOfX2 = sumOfX2 + x2.get(j); //adding up each index in the arraylist and adding to the variable after every loop

        }

        for (int y = 0; y < y2.size(); y++) { // looping through the Y squared arraylist

            sumOfY2 = sumOfY2 + y2.get(y); //adding up each index in the arraylist and adding to the variable after every loop

        }
        numOfSamples = dataTable.getRowCount(); // getting row count of table and adding to the variable

        double correlation = analyse.Correlation(sumOfY, sumOfXY, sumOfX2, sumOfY2, sumOfX, sumOfY, numOfSamples); //passing parameters to maths method and putting result in variable correlation
        String correlationOutput = String.format("%.5f", correlation); //setting the string format to only show 5 decimal places
        correlationTxt.setText(correlationOutput); //outputting the correlation result to the label

        //Creating bar chart
        int x = (int) (sumOfX / 100); //setting double variable X to int variable X and dividing them by 100 to make graph size accurate.
        int y = (int) (sumOfY / 100); //setting double variable Y to int variable Y and dividing them by 100 to make graph size accurate.
        int s = (int) (correlation); //setting double variable correlation to int variable correlation and dividing them by 100 to make graph size accurate.
        String xValue = Integer.toString(x);
        String yValue = Integer.toString(y);

        gfx.drawRect(0, 0, getWidth(), getHeight());
        
        int baseline = 200;

        //X rectangle shape
        //  gfx.setColor(Color.red);  //Changed to color to black as I thought red may hinder some users to see it
        gfx.setColor(Color.black); //setting rectangle colour to black
        gfx.fillRect(20, baseline - x, 100, x); // setting rectangle dimensions including x dimension
        gfx.setColor(Color.magenta); //setting string colour white to stand out against the black background
        gfx.drawString("X AXIS", baseline - x, baseline - x / 5); // setting string dimension and text
        gfx.drawString(xValue, baseline - x, baseline - x / 10); // setting string dimension and text
System.out.println(x - baseline);
        //Y rectangle shape
        // gfx.setColor(Color.blue); //Changed to color to black as I thought blue may hinder some users to see it
        gfx.setColor(Color.black); //setting rectangle colour to black
        gfx.fillRect(130, baseline - y, 100, y);  // setting rectangle dimensions including y dimension
        gfx.setColor(Color.magenta); //setting string colour white to stand out against the black background
        gfx.drawString("Y AXIS", 160, baseline - y / 15); // setting string dimension and text
        gfx.drawString(yValue, 165, baseline - y / 25); // setting string dimension and text
        if (s <= 0) {
            s = 100;
            gfx.setColor(Color.black); //setting rectangle colour to black
            gfx.fillRect(240, baseline, 100, s);   // setting rectangle dimensions including correlation dimension
            gfx.setColor(Color.magenta); //setting string colour white to stand out against the black background
            gfx.drawString("CORRELATION", 245, baseline); //setting string dimension and text

            correlationOutputLbl.setText("This is a negative correlation"); //setting the label text to the outcome of the correlation

        } else {
            s = 100;
            gfx.setColor(Color.black); // setting the colour of the rectangle to green
            gfx.fillRect(240, baseline - 100, 100, baseline);  // setting dimensions for rectangle
            gfx.setColor(Color.magenta); //setting the string color
            gfx.drawString("CORRELATION", 245, 430); // drawing the string on the correlation axis

            correlationOutputLbl.setText("This is a positive correlation");  //setting the label text to the outcome of the correlation
        }

        // Changed the colours of my graph to black and white as I thought having different colours hindered some users to see them, such as colour blind users.
    }//GEN-LAST:event_calCorrelationBtnActionPerformed

    private void activityLogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityLogBtnActionPerformed

        ActivityLogger logFrame = new ActivityLogger(); //instantiting the activity class

        logFrame.setVisible(true); //opening the activity class on button click

    }//GEN-LAST:event_activityLogBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String username = loggedUser.getText(); // get the string from the label and add it to variable username
        try {
        username = username.substring(18); // substring the string to get only the name that is added
        }catch(StringIndexOutOfBoundsException e){
            
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) dataTable.getModel())); // create a tableRowSorter and assign it to my data model.
        sorter.setRowFilter(RowFilter.regexFilter(searchTxt.getText())); // set the filter from the string in the search txt field.
        dataTable.setRowSorter(sorter); // assign the row sorter to my data table with the filter that has been added
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // creating a new date format with current date and time
        Date date = new Date(); // instanting a date object
        String query = searchTxt.getText(); // assigning the string from search text to a string variable

        try {
            logger.writeEntry(username, date, query); // calling method write entry from ActivityLogger class and passing it parameters
        } catch (IOException ex) { // catch statement if input output is wrong.
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new GUI().setVisible(true); // sets frame visible 
                } catch (IOException ex) { // catch if input output is wrong 
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MyGraph;
    private javax.swing.JButton activityLogBtn;
    private javax.swing.JButton calCorrelationBtn;
    private javax.swing.JLabel correlationOutputLbl;
    private javax.swing.JTextField correlationTxt;
    private javax.swing.JTable dataTable;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loggedUser;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
