
package lmcpointofsalessystem;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static lmcpointofsalessystem.LMCPointofSalesSystem.s;
import static lmcpointofsalessystem.ManageCustomers.con;
import static lmcpointofsalessystem.ManageCustomers.s;
import static lmcpointofsalessystem.ManageEmployee.s;
import static lmcpointofsalessystem.ManipulateStocks.s;

/**
 *
 * @author JohnReinel
 */
public class ManipulateStocksEmployee extends javax.swing.JFrame {
public static Statement s;
    public static Connection con;
    ResultSet rs;
    
      DefaultTableModel tblModel = new DefaultTableModel();
      public void Clock (){
        Thread clock = new Thread(){
            public void run(){
                try {
                    while(true){
                    Calendar cal = new GregorianCalendar();
                    int day=cal.get(Calendar.DAY_OF_MONTH);
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
        
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);
                    SimpleDateFormat sdf = new SimpleDateFormat("a");
                    lblPM.setText(sdf.format(cal.getTime()));
                    lblTimes.setText("Time "+month+"/"+day+"/"+year+" "+hour+":"+minute+":"+second+"");
                    sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        clock.start();
    }
    public void criticalStock(){
        
    try {
        String sql = ("select ItemName from Stocks where Quantity<=10");
        rs = s.executeQuery(sql);
		ArrayList<String> stocksList = new ArrayList<String>();
        while(rs.next()){              
            stocksList.add(rs.getString("ItemName"));
        }
	String[] arrOfString = (String[]) stocksList.toArray(new String[stocksList.size()]);
        JOptionPane.showMessageDialog(null, new JList(arrOfString),"Low Stocks", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
        Logger.getLogger(ManipulateStocks.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public ManipulateStocksEmployee() {
        initComponents();
        this.setLocationRelativeTo(null);
        LMCPointofSalesSystem connect = new LMCPointofSalesSystem();
        s=connect.s;
        con=connect.con;
		lblUsern.setText(Login.U);
        fillTable();
        displayID();
        Clock();
        criticalStock();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jSpinner1 = new javax.swing.JSpinner();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtpStock = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        spnQty = new javax.swing.JSpinner();
        cmbType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblItemNo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtaOrig = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtuItemNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtuName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        spnuQty = new javax.swing.JSpinner();
        cmbuType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtuPrice = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtuOrig = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtitemno1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cmbFilter = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        btnViewall = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnrefresh4 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblPM = new javax.swing.JLabel();
        lblTimes = new javax.swing.JLabel();
        jlabelsisiw = new javax.swing.JLabel();
        lblUsern = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        jMenu1.setText("jMenu1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Stocks");
        setType(java.awt.Window.Type.UTILITY);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 255, 153));
        jPanel3.setForeground(new java.awt.Color(0, 255, 153));

        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setToolTipText("Add one Stock");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Item No.:");

        jLabel2.setText("Type:");

        jLabel3.setText("Name:");

        txtName.setName("txtName"); // NOI18N

        jLabel10.setText("Quantity: ");

        spnQty.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000000, 1));

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Part", "Accessory" }));
        cmbType.setName(""); // NOI18N

        jLabel8.setText("Price:");

        txtPrice.setText("0");

        lblItemNo.setText("jLabel9");

        jLabel15.setText("Orig Price:");

        txtaOrig.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItemNo))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblItemNo))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtaOrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jtpStock.addTab("Add Stock", jPanel1);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_edit.png"))); // NOI18N
        btnUpdate.setText("Save");
        btnUpdate.setToolTipText("Updates one Stock");
        btnUpdate.setName("btnedit"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel4.setText("Item No.:");

        txtuItemNo.setEnabled(false);

        jLabel5.setText("Type:");

        jLabel6.setText("Name:");

        txtuName.setEnabled(false);

        jLabel11.setText("Quantity: ");

        spnuQty.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000000, 1));
        spnuQty.setEnabled(false);

        cmbuType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Part", "Accessory" }));
        cmbuType.setEnabled(false);

        jLabel9.setText("Price:");

        txtuPrice.setText("0");
        txtuPrice.setEnabled(false);

        jLabel14.setText("Orig Price:");

        txtuOrig.setText("0");
        txtuOrig.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbuType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuItemNo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(spnuQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtuOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5)
                    .addComponent(btnUpdate))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtuItemNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbuType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(spnuQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuOrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jtpStock.addTab("Update Stock", jPanel4);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setToolTipText("Deletes one Record");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("Item No.:");

        txtitemno1.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtitemno1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtitemno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jtpStock.addTab("Delete Stock", jPanel6);

        tblStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Number", "Type", "Name", "Quantity", "Price", "Orig Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStocksMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblStocks);
        if (tblStocks.getColumnModel().getColumnCount() > 0) {
            tblStocks.getColumnModel().getColumn(0).setResizable(false);
            tblStocks.getColumnModel().getColumn(1).setResizable(false);
            tblStocks.getColumnModel().getColumn(2).setResizable(false);
            tblStocks.getColumnModel().getColumn(3).setResizable(false);
            tblStocks.getColumnModel().getColumn(4).setResizable(false);
            tblStocks.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel12.setText("Filter:");

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Part", "Accessory" }));
        cmbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFilterItemStateChanged(evt);
            }
        });

        jLabel13.setText("Search:");

        btnGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_view.png"))); // NOI18N
        btnGo.setText("Search");
        btnGo.setToolTipText("Search one Stock");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        btnViewall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_view.png"))); // NOI18N
        btnViewall.setText("View All");
        btnViewall.setToolTipText("View all records");
        btnViewall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewallActionPerformed(evt);
            }
        });

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_back.png"))); // NOI18N
        btnback.setText("Back");
        btnback.setToolTipText("Go back to admin panel");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnrefresh4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_refresh.png"))); // NOI18N
        btnrefresh4.setText("Refresh");
        btnrefresh4.setToolTipText("Refreshes the Table");
        btnrefresh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefresh4ActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setToolTipText("Clear the Fields");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jtpStock)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewall))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(33, 33, 33)
                .addComponent(btnrefresh4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtpStock, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewall, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrefresh4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        lblPM.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblPM.setForeground(new java.awt.Color(0, 255, 153));
        lblPM.setText("jLabel12");

        lblTimes.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblTimes.setForeground(new java.awt.Color(0, 255, 153));
        lblTimes.setText("jLabel13");

        jlabelsisiw.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jlabelsisiw.setForeground(new java.awt.Color(255, 255, 255));
        jlabelsisiw.setText("Login in as:");

        lblUsern.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblUsern.setForeground(new java.awt.Color(0, 255, 153));
        lblUsern.setText("jLabel24");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlabelsisiw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsern)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTimes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabelsisiw)
                        .addComponent(lblUsern))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPM)
                        .addComponent(lblTimes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     try{
String itemno = lblItemNo.getText();
        String type= cmbType.getSelectedItem().toString();
        String name= txtName.getText();
        Object qty = spnQty.getValue().toString();
        float origp = Float.parseFloat(txtaOrig.getText());
        float price = Float.parseFloat(txtPrice.getText().toString());
        if (txtName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please Input a Name !");
        } 
        else if (spnQty.getValue().equals(0))
        {
            JOptionPane.showMessageDialog(this, "Invalid Quantity (0) !");
        }
        else if (origp == 0){
            JOptionPane.showMessageDialog(this, "Please Input an Original Price !");
        }
        else if (price == 0)
        {
            JOptionPane.showMessageDialog(this, "Please Input a Price !");
        }
        else{
        try {
            s.executeUpdate("insert into Stocks(Type,itemName,Quantity,Price,OrigPrice) values('"+type+"','"+name+"',"+qty+","+price+","+origp+")");
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(rootPane, "Successfully Added");
        fillTable();
        clear();
        try {
                  String sql = "select ItemNo from Stocks";
                     rs=s.executeQuery(sql);
                 while(rs.next()){
                    
                     int uo = rs.getInt("ItemNo");
                     int uo1 = uo + 1;
                     lblItemNo.setText(String.valueOf(uo1));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(ManipulateStocksEmployee.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid Input !");
            txtaOrig.setText("0");
            txtPrice.setText("0");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String itemno= txtuItemNo.getText();
        String type= cmbuType.getSelectedItem().toString();
        String name= txtuName.getText();
        float price = Float.parseFloat(txtuPrice.getText());
        int qty1 = Integer.parseInt(spnuQty.getValue().toString());
        if(itemno.equals("")){
            JOptionPane.showMessageDialog(this, "Please select one record from the table !");
        }
        else if (txtuName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please Input a Name !");
        } 
        else if (qty1 == 0)
        {
            JOptionPane.showMessageDialog(this, "Invalid Quantity (0) !");
        } 
        else if (price == 0)
        {
            JOptionPane.showMessageDialog(this, "Please Input a Price !");
        } 
        else{
          try {
            if(qty1>0){
            s.executeUpdate("Update Stocks Set Type  = '"+type+"',itemName = '"+name+"',Quantity = "+qty1+", Price = "+price+" where itemNo =('"+itemno+"')");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Invalid Stock!");
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(rootPane, "Stock ID: " + itemno + "\n" + "Successfully Updated!");
        fillTable();
        clear();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String itemno = txtitemno1.getText();
	JFrame msg = new JFrame();
        int f = JOptionPane.showConfirmDialog(msg, "Delete Record? This can not be undone!", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (f==0){

        try {
			String sql = "select * from Stocks where ItemNo='"+itemno+"'";
            rs=s.executeQuery(sql);
            if(rs.next()){
            int ID = rs.getInt("ItemNo");
            String Type = rs.getString("Type");
            String ItemName = rs.getString("ItemName");
            int Quantity = rs.getInt("Quantity");
            float Price = rs.getFloat("Price");
            float OrigPrice = rs.getFloat("OrigPrice");
                //if(itemno == String.valueOf(ID)){
                s.executeUpdate("insert into ArchivedStocks values('"+ID+"','"+Type+"','"+ItemName+"',"+Quantity+","+Price+","+OrigPrice+")");
                s.executeUpdate("delete from Stocks where itemNo= ('"+itemno+"')");
                JOptionPane.showMessageDialog(rootPane, "Stock ID: " + itemno + "\n" + "Successfully Archived!");
                fillTable();
                //}
            }else{
            JOptionPane.showMessageDialog(rootPane, "ID not found!");
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Invalid Input !");
        }
         
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        //EmployeePanel ep = new EmployeePanel();
        //ep.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnrefresh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefresh4ActionPerformed
        fillTable();

    }//GEN-LAST:event_btnrefresh4ActionPerformed

    private void tblStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStocksMouseClicked
        try{
            int row = tblStocks.getSelectedRow();
            String table_click = (tblStocks.getModel().getValueAt(row, 0).toString());
			JFrame msg = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Update");
            options[1] = new String("Delete");
            
            int f = JOptionPane.showOptionDialog(msg.getContentPane(), "Which operation you want?", "Choose", 0,JOptionPane.INFORMATION_MESSAGE,null, options, null);
            
            if (f==0){
                jtpStock.setSelectedIndex(1);
            }if(f==1){
                jtpStock.setSelectedIndex(2);
            }
            String sql = "select * from Stocks where ItemNo='"+table_click+"'";
            rs=s.executeQuery(sql);
             if(rs.next()){
                String up1 = rs.getString("ItemNo");
                txtuItemNo.setText(up1);
                txtitemno1.setText(up1);
                String up2 = rs.getString("Type");
                cmbuType.setSelectedItem(up2);
                String up3 = rs.getString("ItemName");
                txtuName.setText(up3);
                int up4 = rs.getInt("Quantity");
                spnuQty.setValue(up4);
                float up5 = rs.getFloat("Price");
                txtuPrice.setText(String.valueOf(up5));
                float up6 = rs.getFloat("OrigPrice");
                txtuOrig.setText(String.valueOf(up6));
                editables();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblStocksMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
       txtaOrig.setText("0");
    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFilterItemStateChanged
        Object filter = cmbFilter.getSelectedItem();
        if(filter.equals("Part")){
            try {
            tblModel = (DefaultTableModel)tblStocks.getModel();
            rs = s.executeQuery("Select * from  Stocks where Type = 'Part' ");
            ResultSetMetaData md = rs.getMetaData();
            int row = tblModel.getRowCount();
            while(row>0)
            {
                row--;
                tblModel.removeRow(row);
            }
            int colcount = md.getColumnCount();
            Object[] data = new Object[colcount];
            while(rs.next()){
                for(int i=1;i<=colcount;i++){
                    data[i-1] = rs.getString(i);
                }
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }
        }
        if(filter.equals("Accessory")){
            try {
            tblModel = (DefaultTableModel)tblStocks.getModel();
            rs = s.executeQuery("Select * from  Stocks where Type = 'Accessory' ");
            ResultSetMetaData md = rs.getMetaData();
            int row = tblModel.getRowCount();
            while(row>0)
            {
                row--;
                tblModel.removeRow(row);
            }
            int colcount = md.getColumnCount();
            Object[] data = new Object[colcount];
            while(rs.next()){
                for(int i=1;i<=colcount;i++){
                    data[i-1] = rs.getString(i);
                }
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }
        }
        if(filter.equals("All")){
            fillTable();
        }
    }//GEN-LAST:event_cmbFilterItemStateChanged

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        String search = txtSearch.getText();
        String ID="";
        if(search.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Input a valid Stocks ID!");
            txtSearch.setText("");
        }
        if(Pattern.matches("[a-zA-Z]+",search)==true && search.length() >= 1){
            JOptionPane.showMessageDialog(null, "Input a valid Stocks ID!");
            txtSearch.setText("");
        }
        else{
            try {
                String sql = "select * from Stocks where ItemNo='"+search+"'";
                rs=s.executeQuery(sql);
                txtuItemNo.enable(false);
                if(rs.next()){
                    ID = rs.getString("ItemNo");
                    tblModel = (DefaultTableModel)tblStocks.getModel();
                    rs = s.executeQuery("select * from Stocks where ItemNo='"+search+"'" );
                    ResultSetMetaData md = rs.getMetaData();
                    int row = tblModel.getRowCount();
                    while(row>0)
                    {
                        row--;
                        tblModel.removeRow(row);
                    }
                    int colcount = md.getColumnCount();
                    Object[] data = new Object[colcount];
                    while(rs.next()){
                    for(int i=1;i<=colcount;i++){
                    data[i-1] = rs.getString(i);
                    }
                    tblModel.addRow(data);
                    }
                    txtSearch.setText("");
                }
                    else{
                    JOptionPane.showMessageDialog(null, "ID doesn't exist");
                    fillTable();
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(ManipulateStocksAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGoActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
    try {
        PDFStocks pdf = new PDFStocks("Stocks");
    } catch (IOException ex) {
        Logger.getLogger(ManipulateStocksAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnViewallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewallActionPerformed
        fillTable();
    }//GEN-LAST:event_btnViewallActionPerformed

    void fillTable(){
        try {
            tblModel = (DefaultTableModel)tblStocks.getModel();
            rs = s.executeQuery("Select * from  Stocks " );
            ResultSetMetaData md = rs.getMetaData();
            int row = tblModel.getRowCount();
            while(row>0)
            {
                row--;
                tblModel.removeRow(row);
            }
            int colcount = md.getColumnCount();
            Object[] data = new Object[colcount];
            while(rs.next()){
                for(int i=1;i<=colcount;i++){
                    data[i-1] = rs.getString(i);
                }
                tblModel.addRow(data);
            }
        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }
       
    }
    
    void displayID (){
        try {
                  String sql = "select ItemNo from Stocks";
                     rs=s.executeQuery(sql);
                 while(rs.next()){
                     int uo = rs.getInt("ItemNo");
                     int uo1 = uo + 1;
                     lblItemNo.setText(String.valueOf(uo1));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(ManageEmployee.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    void editables (){
        cmbuType.setEnabled(true);
        txtuName.setEnabled(true);
        spnuQty.setEnabled(true);
        txtuPrice.setEnabled(true);
        txtuOrig.setEnabled(true);
    }
    void clear(){
        cmbType.setSelectedIndex(0);
        txtName.setText("");
        spnQty.setValue(0);
        txtPrice.setText("");
        cmbuType.setSelectedIndex(0);
        txtuName.setText("");
        spnuQty.setValue(0);
        txtuItemNo.setText("");
        txtuPrice.setText("0");
        txtPrice.setText("0");
        txtuOrig.setText("0");
        txtitemno1.setText("");
        cmbuType.setEnabled(false);
        txtuName.setEnabled(false);
        spnuQty.setEnabled(false);
        txtuPrice.setEnabled(false);
        txtuOrig.setEnabled(false);
    }
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
            java.util.logging.Logger.getLogger(ManipulateStocksEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManipulateStocksEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManipulateStocksEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManipulateStocksEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 
                new ManipulateStocksEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewall;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnrefresh4;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JComboBox<String> cmbuType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabelsisiw;
    private javax.swing.JTabbedPane jtpStock;
    private javax.swing.JLabel lblItemNo;
    private javax.swing.JLabel lblPM;
    private javax.swing.JLabel lblTimes;
    private javax.swing.JLabel lblUsern;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JSpinner spnuQty;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtaOrig;
    private javax.swing.JTextField txtitemno1;
    private javax.swing.JTextField txtuItemNo;
    private javax.swing.JTextField txtuName;
    private javax.swing.JTextField txtuOrig;
    private javax.swing.JTextField txtuPrice;
    // End of variables declaration//GEN-END:variables
}
