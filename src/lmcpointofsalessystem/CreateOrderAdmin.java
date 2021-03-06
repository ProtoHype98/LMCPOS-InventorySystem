
package lmcpointofsalessystem;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
/**
 *
 * @author JohnReinel
 */
public class CreateOrderAdmin extends javax.swing.JFrame {
    public static Statement s;
    public static Connection con;
    ResultSet rs;
    
    DefaultTableModel tblModel = new DefaultTableModel() ;
    public void Clock (){
        Thread clock = new Thread(){
            public void run(){
                try {
                    while(true){
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);
                    SimpleDateFormat sdf = new SimpleDateFormat("a");
                    lblPM.setText(sdf.format(cal.getTime()));
                    lblDate.setText(ft.format(cal.getTime()));
                    lblTime.setText(""+hour+":"+minute+":"+second+"");
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
    int qua;
    String itemName;
    try {
        String sql = ("select * from Stocks");
        rs = s.executeQuery(sql);
        while(rs.next()){              
            itemName = rs.getString("ItemName");
            qua = rs.getInt("Quantity");
       
                 if(qua<=10){
           
                    JOptionPane.showMessageDialog(null,"Stocks are low (Below 10pcs): "+itemName);
                }
                 if(qua <= 0){
                     JOptionPane.showMessageDialog(null,"Insufficient stock (0 pc): "+itemName);
                 }
        }
        } catch (SQLException ex) {
        Logger.getLogger(ManipulateStocks.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public CreateOrderAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        LMCPointofSalesSystem connect = new LMCPointofSalesSystem();
        s=connect.s;
        con=connect.con;
        lblUsern.setText(Login.U);
        fillTable();
        Clock();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPasswordField2 = new javax.swing.JPasswordField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaTotal = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnProceed = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        txtTotalItems = new javax.swing.JTextField();
        txtTotalPrice = new javax.swing.JTextField();
        cmbFilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQtyhand = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        btnClearRow = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        btnCal = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtItemNo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        spnQtybuy = new javax.swing.JSpinner();
        btnPrint = new javax.swing.JButton();
        spnPay = new javax.swing.JSpinner();
        txtDisc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        spnReturn = new javax.swing.JSpinner();
        txtRetItemName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtOrigPrice = new javax.swing.JTextField();
        lblPM = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlabelsisiw = new javax.swing.JLabel();
        lblUsern = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jRadioButton1.setText("jRadioButton1");

        jPasswordField2.setText("jPasswordField2");

        txtAreaTotal.setEditable(false);
        txtAreaTotal.setColumns(20);
        txtAreaTotal.setRows(5);
        jScrollPane3.setViewportView(txtAreaTotal);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Order");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 255, 153));

        jLabel6.setText("Discount:");

        jLabel5.setText("Total Price:");

        btnProceed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_profits.png"))); // NOI18N
        btnProceed.setText("Checkout");
        btnProceed.setToolTipText("Proceed to Checkout");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Orders:");

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_clear.png"))); // NOI18N
        btnClear.setText("Clear Fields");
        btnClear.setToolTipText("Clear all fields");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item No", "Type", "Item Name", "Quantity", "Price", "Orig Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStocksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStocks);
        if (tblStocks.getColumnModel().getColumnCount() > 0) {
            tblStocks.getColumnModel().getColumn(0).setResizable(false);
            tblStocks.getColumnModel().getColumn(1).setResizable(false);
            tblStocks.getColumnModel().getColumn(2).setResizable(false);
            tblStocks.getColumnModel().getColumn(3).setResizable(false);
            tblStocks.getColumnModel().getColumn(4).setResizable(false);
            tblStocks.getColumnModel().getColumn(5).setResizable(false);
        }

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Type", "Item Name", "Quantity", "Unit Price", "Sell Price (Tax)", "Discount", "Date", "Time", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        tblOrder.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                tblOrderComponentResized(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setResizable(false);
            tblOrder.getColumnModel().getColumn(3).setResizable(false);
            tblOrder.getColumnModel().getColumn(4).setResizable(false);
            tblOrder.getColumnModel().getColumn(5).setResizable(false);
            tblOrder.getColumnModel().getColumn(6).setResizable(false);
            tblOrder.getColumnModel().getColumn(7).setResizable(false);
            tblOrder.getColumnModel().getColumn(8).setResizable(false);
            tblOrder.getColumnModel().getColumn(9).setResizable(false);
        }

        txtTotalItems.setText("0");
        txtTotalItems.setEnabled(false);

        txtTotalPrice.setText("0.0");
        txtTotalPrice.setEnabled(false);

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Part", "Accessory" }));
        cmbFilter.setToolTipText("Filter by Type");
        cmbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFilterItemStateChanged(evt);
            }
        });

        jLabel1.setText("Filter:");

        jLabel2.setText("Search:");

        jLabel7.setText("Qty-in-hand:");

        txtQtyhand.setText("0");
        txtQtyhand.setEnabled(false);

        jLabel8.setText("Qty-to-buy: ");

        jLabel9.setText("Price:");

        txtPrice.setText("0");
        txtPrice.setEnabled(false);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_addtocart.png"))); // NOI18N
        btnAdd.setText("Add to Cart");
        btnAdd.setToolTipText("Add selected item to cart");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel10.setText("Stocks");

        jLabel11.setText("Products in Cart");

        jLabel12.setText("Payment:");

        jLabel13.setText("Change:");

        txtChange.setText("0.0");
        txtChange.setEnabled(false);

        btnClearRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_return.png"))); // NOI18N
        btnClearRow.setText("Return");
        btnClearRow.setToolTipText("Return selected Item");
        btnClearRow.setEnabled(false);
        btnClearRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearRowActionPerformed(evt);
            }
        });

        jLabel14.setText("Item Name:");

        txtItemName.setEnabled(false);

        btnCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_calculator.png"))); // NOI18N
        btnCal.setText("Calculator");
        btnCal.setToolTipText("Launch calculator");
        btnCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalActionPerformed(evt);
            }
        });

        jLabel15.setText("Item No:");

        txtItemNo.setEnabled(false);

        jLabel16.setText("Type:");

        txtType.setEnabled(false);

        btnGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_view.png"))); // NOI18N
        btnGo.setText("Search");
        btnGo.setToolTipText("Search one item");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_view.png"))); // NOI18N
        btnView.setText("View All");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        spnQtybuy.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnQtybuy.setToolTipText("Input Quantity");

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_print.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setToolTipText("Print Receipt");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        spnPay.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 50.0f));
        spnPay.setToolTipText("Input Payment");

        txtDisc.setText("0");
        txtDisc.setToolTipText("Input discount");

        jLabel3.setText("%");

        jLabel20.setText("Return Quantity:");

        jLabel21.setText("Item Name:");

        spnReturn.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnReturn.setToolTipText("Input Return Quantity");
        spnReturn.setEnabled(false);

        txtRetItemName.setEnabled(false);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmcpointofsalessystem/Assets/Small Icons/ic_cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("Cancel Return request");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel17.setText("Orig Price:");

        txtOrigPrice.setText("0");
        txtOrigPrice.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(569, 569, 569)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addGap(12, 12, 12)
                        .addComponent(btnCal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClearRow)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel2))
                                    .addComponent(txtItemNo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQtyhand, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnGo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnView))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(40, 40, 40)
                                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtOrigPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(17, 17, 17)
                                        .addComponent(txtDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(6, 6, 6)
                                        .addComponent(spnQtybuy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalItems, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRetItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(spnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(btnCancel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnProceed)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(btnBack)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)))
                        .addGap(12, 12, 12)
                        .addComponent(txtItemNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtQtyhand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel16))
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel17))
                            .addComponent(txtOrigPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel8))
                            .addComponent(spnQtybuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTotalItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRetItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(btnClearRow, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(spnPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lblPM.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblPM.setForeground(new java.awt.Color(0, 255, 153));
        lblPM.setText("jLabel17");

        lblDate.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblDate.setForeground(new java.awt.Color(0, 255, 153));
        lblDate.setText("jLabel18");

        lblTime.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 255, 153));
        lblTime.setText("jLabel19");

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Date:");

        jLabel19.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Time:");

        jlabelsisiw.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jlabelsisiw.setForeground(new java.awt.Color(255, 255, 255));
        jlabelsisiw.setText("Login in as:");

        lblUsern.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblUsern.setForeground(new java.awt.Color(0, 255, 153));
        lblUsern.setText("jLabel24");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jlabelsisiw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsern)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPM, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPM)
                        .addComponent(lblDate)
                        .addComponent(lblTime)
                        .addComponent(jLabel18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelsisiw)
                            .addComponent(lblUsern)))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStocksMouseClicked
        try{
            int row = tblStocks.getSelectedRow();
            String table_click = (tblStocks.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Stocks where ItemNo='"+table_click+"'";
            rs=s.executeQuery(sql);
             if(rs.next()){
                String up1 = rs.getString("ItemNo");
                txtItemNo.setText(up1);
                String up2 = rs.getString("Type");
                txtType.setText(up2);
                String up3 = rs.getString("ItemName");
                txtItemName.setText(up3);
                int up4 = rs.getInt("Quantity");
                txtQtyhand.setText(String.valueOf(up4));
                float up5 = rs.getFloat("Price");
                txtPrice.setText(String.valueOf(up5));
                float up6 = rs.getFloat("OrigPrice");
                txtOrigPrice.setText(String.valueOf(up6));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblStocksMouseClicked

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
ArrayList<Float> ll = new ArrayList<Float>();
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try{
        String itemno = txtItemNo.getText();
        String type = txtType.getText();
        String itemname = txtItemName.getText();
        String qtyhand = txtQtyhand.getText().toString();
        float price = Float.parseFloat(txtPrice.getText());
        String date = lblDate.getText();
        String time = lblTime.getText()+" "+lblPM.getText();
        int disc = Integer.parseInt(txtDisc.getText());
        int qty2buy = Integer.parseInt(spnQtybuy.getValue().toString());
        float total = price*qty2buy;
        float origprice = Float.parseFloat(txtOrigPrice.getText());
        
        if (qty2buy == 0){
            JOptionPane.showMessageDialog(this, "Please Input a Quantity !");
        }
        else if(Pattern.matches("[a-zA-Z]+",String.valueOf(disc))==true || String.valueOf(disc).trim().equalsIgnoreCase("")|| disc >= 91){
            JOptionPane.showMessageDialog(this, "Invalid discount !");
        }
        else if(itemno.trim().equals("") || itemno.equals("0")){
            JOptionPane.showMessageDialog(this, "Please select a product from the stocks table !");
        }
        else if(itemname.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Please select a product from the stocks table !");
        }
        else if(type.equals("")){
            JOptionPane.showMessageDialog(this, "Please select a product from the stocks table !");
        }
        else if(qtyhand.trim().equals("") || qtyhand.equals("0")){
            JOptionPane.showMessageDialog(this, "Please select a product from the stocks table !");
        }
        else if(price <= 100 && disc >=1){
            JOptionPane.showMessageDialog(this, "Discount is not available for 100php or below items !");
            txtDisc.setText("0");
        }
        else{
            try{
            String sql = "select Quantity from Stocks where ItemNo = "+itemno+"";
            rs=s.executeQuery(sql);
            
            if(rs.next()){
                int qty1 = rs.getInt("Quantity");
                
                if(qty2buy >= qty1){
                    JOptionPane.showMessageDialog(this, "Order quantity is higher than stocks !");
                }else if(qty2buy < qty1){
                
                    String as = "";
                    boolean exists = false;
                    for (int x=0; x<tblOrder.getRowCount(); x++) {    
                    as = tblOrder.getValueAt(x, 0).toString().trim();
                    if(itemno.equals(as))
                    {
                    exists = true;
                        JOptionPane.showMessageDialog(null, "Can not add duplicate item !");
                    break;
                    }
                    }
            
            if(!exists){
            int totalqty = qty1 - qty2buy;
            s.executeUpdate("Update Stocks set Quantity="+totalqty+" where ItemNo= "+itemno+"");
            origprice *= qty2buy;
            float b = (total * disc)/100;
            total = total - b;
            String totaldisc = disc + "%";
            Object[] row = { itemno, type, itemname, qty2buy, origprice, price, totaldisc, date,time, total  };
            DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
            model.addRow(row);
            int count = model.getRowCount();
            txtTotalItems.setText(String.valueOf(count));
            ll.add(total);
            float sum = 0;
            for(int i =0; i< ll.size(); i++){
                sum += ll.get(i);
                txtTotalPrice.setText(String.valueOf(sum));
            }
            
            }
            fillTable();
            clear();
            }
                
            }
            
            }catch (SQLException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid discount !");
        }
        
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void btnCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalActionPerformed
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }//GEN-LAST:event_btnCalActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnClearRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRowActionPerformed
        DefaultTableModel dtmodel = (DefaultTableModel) tblOrder.getModel();
        int select = tblOrder.getSelectedRow();
        int numRows = tblOrder.getSelectedRows().length;
        String itemname = txtRetItemName.getText();
        float totalprice = Float.parseFloat(txtTotalPrice.getText());
        float unitprice = Float.parseFloat(tblOrder.getValueAt(select, 5).toString());
        int qty = Integer.parseInt(tblOrder.getValueAt(select, 3).toString());
        int return1 = Integer.parseInt(spnReturn.getValue().toString());
        
        try{
        
        if(txtTotalItems.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Please select atleast one order !");
        }
        else if(numRows == 0){
            JOptionPane.showMessageDialog(null, "Please select atleast one order in the order table !");
        }
        else if(return1 == 0){
            JOptionPane.showMessageDialog(null, "Please input atleast one return !");
        }
        else if(return1 > qty){
            JOptionPane.showMessageDialog(null, "Requested return is higher than your order quantity !");
        }
        else if(itemname.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Please select atleast one order in the order table !");
        }
        else{

        try {
            
            String sql = "Select Quantity,Price from Stocks where ItemName = '"+itemname+"'";
            rs=s.executeQuery(sql);
            if(rs.next()){
            int qty1 = rs.getInt("Quantity");
            float price = rs.getFloat("Price");
            float selectedrow = Float.parseFloat(tblOrder.getValueAt(select, 9).toString());
            float totalAmount=0;
                totalAmount = qty1 + return1;
                float returnprice =totalprice - unitprice*return1;
                txtTotalPrice.setText(String.valueOf(returnprice));
                float totalpriceret = selectedrow - price*return1;
                tblOrder.setValueAt(totalpriceret, select, 9);
                s.executeUpdate("Update Stocks set Quantity="+totalAmount+" where ItemName= '"+itemname+"'");
            }
            spnReturn.setEnabled(false);
            btnClearRow.setEnabled(false);
            fillTable();
            txtRetItemName.setText("");
            spnReturn.setValue(0);
            int tableret = qty - return1;
            tblOrder.setValueAt(tableret, select, 3);
            if(tableret == 0){
                for (int i = 0; i < dtmodel.getRowCount(); i++) {
                    if (((String)tblOrder.getValueAt(i, 2)).equals(itemname)) {
                    dtmodel.removeRow(i);
                    break;
                    }
                }
            }
            if(tblOrder.getRowCount() == 0){
               ll.clear();   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Please select atleast one order !");
        }
        int count = tblOrder.getRowCount(); 
        txtTotalItems.setText(String.valueOf(count));
        if(ll.size() == 0){
            System.out.println("Array Empty");
            txtTotalPrice.setText("0.0");
            txtChange.setText("0.0");
        }
        }
        }catch(ArrayIndexOutOfBoundsException ext){
        JOptionPane.showMessageDialog(null, "Cart Empty !");
        }
        catch(IllegalArgumentException e){
        JOptionPane.showMessageDialog(null, "Cart Empty !");        
        }

    }//GEN-LAST:event_btnClearRowActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        float total = Float.parseFloat(txtTotalPrice.getText());
        float pay = Float.parseFloat(spnPay.getValue().toString());
        String totalorders = txtTotalItems.getText();
        JFrame msg = new JFrame();
        int f = JOptionPane.showConfirmDialog(msg, "Proceed to checkout? (This transaction will exit)", "Checkout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (f==0){
        
        if(pay<total || pay == 0){
            JOptionPane.showMessageDialog(null, "Insufficient payment !");
        }
        else if(pay == 0 && String.valueOf(total).equals("0.0")){
            spnPay.setValue(0);
            txtChange.setText("0.0");
            JOptionPane.showMessageDialog(null, "Please input atleast one order!");
        }
        else if(totalorders.equals("0")){
            spnPay.setValue(0);
            txtChange.setText("0.0");
            JOptionPane.showMessageDialog(null, "Please input atleast one order!");
        }else{
            total = pay - total;
            txtChange.setText(String.valueOf(total));
             genpdf();
            try {
                
                for(int i=0;i<=tblOrder.getRowCount();i++){
                String id = tblOrder.getValueAt(i, 0).toString();
                String type = tblOrder.getValueAt(i, 1).toString();
                String itemname = tblOrder.getValueAt(i, 2).toString();
                int qty = Integer.parseInt(tblOrder.getValueAt(i, 3).toString());
                float origp = Float.parseFloat(tblOrder.getValueAt(i, 4).toString());
                float unitprice = Float.parseFloat(tblOrder.getValueAt(i, 5).toString());
                String disc = tblOrder.getValueAt(i, 6).toString();
                String date = tblOrder.getValueAt(i, 7).toString();
                String time = tblOrder.getValueAt(i, 8).toString();
                float total1 = Float.parseFloat(tblOrder.getValueAt(i, 9).toString());
                
                s.executeUpdate("insert into Sales(ProductID,Type,ItemName,Quantity,UnitPrice,Discount,Date,Time,Total,OrigPrice) values('"+id+"','"+type+"','"+itemname+"',"+qty+","+unitprice+",'"+disc+"','"+date+"','"+time+"',"+total1+","+origp+")");
                this.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Identity operated");
            }
    }
    }
    }//GEN-LAST:event_btnProceedActionPerformed

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

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        fillTable();
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //AdminPanel amp = new AdminPanel();
        //amp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblOrderComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblOrderComponentResized

    }//GEN-LAST:event_tblOrderComponentResized
    ArrayList<Integer> listColWidths = new ArrayList<Integer>();
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        if(txtTotalItems.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Please select atleast one order !");
        }else{
        try{
            tblOrder.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
    spnReturn.setEnabled(true);
    btnClearRow.setEnabled(true);
    btnCancel.setEnabled(true);
    int select = tblOrder.getSelectedRow();
    String itemname = tblOrder.getValueAt(select, 2).toString();

    txtRetItemName.setText(itemname);

    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        spnReturn.setEnabled(false);
        btnClearRow.setEnabled(false);
        btnCancel.setEnabled(false);
        spnReturn.setValue(0);
        txtRetItemName.setText("");
        tblOrder.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnCancelActionPerformed
    void print(){
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        if(txtTotalItems.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Please select atleast one order !");
        }else{
        try{
            tblOrder.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
        }
    }
   
    void genpdf(){
        float totalp = Float.parseFloat(txtTotalPrice.getText());
        float pay = Float.parseFloat(spnPay.getValue().toString());
        float change = Float.parseFloat(txtChange.getText());
        Document document = new Document();
        TableModel dtm = (TableModel) tblOrder.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        String totalorders = txtTotalItems.getText();
        if(totalorders.equals("0")){
            JOptionPane.showMessageDialog(null, "Please input atleast one order!");
        }else{
            String[] columnname = {"Product ID",
            "Type",
            "Item Name",
            "Quantity",
            "Price w/o Tax",
            "Price w/ Tax",
            "Discount",
            "Date",
            "Time",
            "Total"};
        Object[][] tableData = new Object[nRow][nCol];
        for (int x = 0 ; x < nRow ; x++)
        for (int y = 0 ; y < nCol ; y++)
            
            tableData[x][y] = dtm.getValueAt(x,y);
        
        tblOrder.setModel(dtm);
        tblOrder = new JTable(tableData, columnname);
        tblOrder.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tblOrder.setFillsViewportHeight(true);
        for(int i=0;i<tblOrder.getColumnCount();i++)
        {
            TableColumn column = tblOrder.getColumnModel().getColumn(i);
            listColWidths.add(column.getWidth());
        }

        try {
            
            PdfWriter.getInstance(document,new FileOutputStream("Orders.pdf"));
            document.open();
            PdfPTable pdfTable = new PdfPTable(10);
            int tableWidths[] = new int[columnname.length];
            for(int i= 0; i<listColWidths.size();i++)
            {
                tableWidths[i] = listColWidths.get(i);
            }
            //set column widths
            int[] columnWidths = new int[] {1320, 1380, 1390, 1400, 1410, 1420, 1440, 1450, 1490, 1500};
            Font colfont = new Font(Font.HELVETICA, 9);
            pdfTable.setWidths(columnWidths);
            PdfPCell cell = new PdfPCell();
            Phrase phrase = null;
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setBorderWidthLeft(1);
            
            for(int i=0;i<tblOrder.getColumnCount();i++)
            {   
                phrase = new Phrase(columnname[i]);
                cell = new PdfPCell(phrase);
                pdfTable.addCell(cell);
            }
            for(int i=0;i<nRow;++i)
            {
                for(int j=0;j<nCol;++j)
                {
                    phrase = new Phrase(String.valueOf(tableData[i][j]));
                    cell = new PdfPCell(phrase);
                    pdfTable.addCell(cell);
                    cell.setColspan(1);
                }
            }
            document.add(new Paragraph("                                 INVOICE",FontFactory.getFont(FontFactory.TIMES_ROMAN, 25, Font.NORMAL,Color.BLACK)));
            document.add(new Paragraph("                                                                   "));
            document.add(new Paragraph("                                                "+new Date().toString(),FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL,Color.BLACK)));
            document.add(new Paragraph("                                                                   "));
            document.add(pdfTable);
            document.add(new Paragraph("                                                                   "));
            document.add(new Paragraph("                                                                                                 Total="+totalp+"php",FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD,Color.BLACK)));
            document.add(new Paragraph("                                                                                                 Payment="+pay+"php",FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD,Color.BLACK)));
            document.add(new Paragraph("                                                                                                 Change="+change+"php",FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD,Color.BLACK)));
            document.add(new Paragraph("                                                                                                 Cashier="+lblUsern.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD,Color.BLACK)));
            document.add(new Paragraph("                                                                   "));
            document.add(new Paragraph("                                               Goods once sold, has only 1 week replacement",FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL,Color.BLACK)));
            document.add(new Paragraph("               ---------------------------------------------------------------------",FontFactory.getFont(FontFactory.TIMES_ROMAN, 17, Font.NORMAL,Color.BLACK)));
            document.add(new Paragraph("                                                              LMC Point Of Sales System",FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL,Color.BLACK)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
        //to run pdf file
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Orders.pdf");
        } catch (IOException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
//            EmployeePanel ep = new EmployeePanel();
//            ep.setVisible(true);
//            this.hide();
//            ep.dispose();
//            CreateOrder co = new CreateOrder();
//            co.setVisible(true);
        }
    }
    void fillTable(){
        try {
            tblModel = (DefaultTableModel)tblStocks.getModel();
            
            rs = s.executeQuery("Select * from  Stocks where Quantity >1");
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
    
    void fillOrderTable(){
        try {
            tblModel = (DefaultTableModel)tblOrder.getModel();
            rs = s.executeQuery("Select * from  Orders " );
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
    void clear(){
        txtSearch.setText("");
        txtItemNo.setText("");
        txtType.setText("");
        cmbFilter.setSelectedItem("All");
        txtItemName.setText("");
        txtPrice.setText("0");
        txtChange.setText("0");
        txtDisc.setText("0");
        txtQtyhand.setText("0");
        spnQtybuy.setValue(0);
        txtOrigPrice.setText("0");
        
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
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateOrderAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCal;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearRow;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlabelsisiw;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPM;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUsern;
    private javax.swing.JSpinner spnPay;
    private javax.swing.JSpinner spnQtybuy;
    private javax.swing.JSpinner spnReturn;
    public javax.swing.JTable tblOrder;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTextArea txtAreaTotal;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtDisc;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemNo;
    private javax.swing.JTextField txtOrigPrice;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQtyhand;
    private javax.swing.JTextField txtRetItemName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalItems;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
