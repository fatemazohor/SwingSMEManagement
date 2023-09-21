/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DbCon;

/**
 *
 * @author user
 */
public class SMEDashboard extends javax.swing.JFrame {

    //database variable
    DbCon dbCon = new DbCon();
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Creates new form SMEDashboard
     */
    public SMEDashboard() {
        initComponents();
        init();
    }

    private void init() {
        getAllProducts();
    }

    private void getAllProducts() {

        String[] columnNames = {"ProduntId", "Name", "Quentity", "Unit_price", "Buy_price", "Entry_date"};
        sql = "select * from smemanagement.products";

        DefaultTableModel producttableModel = new DefaultTableModel();
        producttableModel.setColumnIdentifiers(columnNames);
        tableInvUpdateProdunt.setModel(producttableModel);

        try {
            ps = dbCon.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int produntId = rs.getInt("idproducts");
                String name = rs.getString("name");
                int quentity = rs.getInt("quentity");
                float unitprice = rs.getFloat("unit_price");
                float purchasePrice = rs.getFloat("purchase_price");
                Date entryDate = rs.getDate("entry_date");

                producttableModel.addRow(new Object[]{produntId, name, quentity, unitprice, purchasePrice, entryDate});

            }

            ps.close();
            dbCon.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(SMEDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//    date format method
    //conver utill date to sql date

    public static Date convertutilltosql(java.util.Date utilldate) {

        if (utilldate != null) {
            return new Date(utilldate.getTime());

        }
        return null;

    }

    //date format for sql date
    public static String formatSqlDate(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate;

    }

    //convert sql date to utill date
    public static java.util.Date convertsqltoutill(Date sqldate) {

        if (sqldate != null) {
            return new java.util.Date(sqldate.getTime());

        }
        return null;

    }

    //date format for utill date
    public static String formatUtilDate(java.util.Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate;

    }

    private void setInvProductReset() {
        txtProductaddProductId.setText(null);
        txtProductaddProductName.setText(null);
        txtProductaddPurchasePrice.setText(null);
        txtProductaddUnitPrice.setText(null);
        spanProductaddQuentity.setValue(0);
        jdateAddProduct.setDate(null);

    }

    private void setbtnInvUpdateReset() {
        txtinvUpdateProId.setText(null);
        txtinvUpdateProName.setText(null);
        txtinvUpdateUnitPrice.setText(null);
        txtinvUpdateQuentity.setText(null);
        txtinvUpdatebuyPrice.setText(null);

    }

    private void setbtnillInfoReset() {
        txtbillProName.setText(null);
        txtbillunitPrice.setText(null);
        txtbillquentity.setValue(0);
        txtbillTotalPrice.setText(null);
        txtbillDiscount.setText(null);
        txtbillFinalPrice.setText(null);

    }

    private void setbtnCustomerReset() {
        txtCustomerInfoName.setText(null);
        txtCustomerInfoCell.setText(null);
        txtCustomerInfoAddress.setText(null);
        comboCustomerDistrict.setSelectedIndex(0);
        jDateCustomerInfo.setDate(null);

    }

    private float getbillTotalPrice() {
        float unitPrice = Float.parseFloat(txtbillunitPrice.getText().trim().toString());
        float quentity = Float.parseFloat(txtbillquentity.getValue().toString());

        float totalPrice = (unitPrice * quentity);

        return totalPrice;
    }

    private float getbillAutualPrice() {
        float discount = Float.parseFloat(txtbillDiscount.getText().trim());
        float totalPrice = getbillTotalPrice();

        float actualPrice = (totalPrice - (totalPrice * discount / 100));

        return actualPrice;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btndashborad = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnorderSales = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        menu = new javax.swing.JTabbedPane();
        tpdashboard = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        btnhome = new javax.swing.JButton();
        tpInventory = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        btnInventoryAdd = new javax.swing.JButton();
        btnInventoryUpdate = new javax.swing.JButton();
        tpInvAddProduct = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        txtProductaddProductId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProductaddProductName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProductaddUnitPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProductaddPurchasePrice = new javax.swing.JTextField();
        spanProductaddQuentity = new javax.swing.JSpinner();
        btnInvProductAdd = new javax.swing.JButton();
        btnInvProductReset = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jdateAddProduct = new com.toedter.calendar.JDateChooser();
        tpInvUpdateProduct = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtinvUpdateProId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtinvUpdateProName = new javax.swing.JTextField();
        txtinvUpdateUnitPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtinvUpdateQuentity = new javax.swing.JTextField();
        txtinvUpdatebuyPrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvUpdateProdunt = new javax.swing.JTable();
        btnInvUpdateDelete = new javax.swing.JButton();
        btnInvUpdate = new javax.swing.JButton();
        btnInvUpdateReset = new javax.swing.JButton();
        tpOrder = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCustomerInfoName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCustomerInfoCell = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        comboCustomerDistrict = new javax.swing.JComboBox<>();
        btnCustomerNext = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCustomerInfoAddress = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jDateCustomerInfo = new com.toedter.calendar.JDateChooser();
        btnCustomerReset = new javax.swing.JButton();
        tpBillingInfo = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtbillProName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtbillunitPrice = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtbillTotalPrice = new javax.swing.JTextField();
        txtbillDiscount = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtbillFinalPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBillInfoProductDetails = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnillInfoReset = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txtbillquentity = new javax.swing.JSpinner();
        tpPayment = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tpLast = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 90));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        btndashborad.setText("DashBoard");
        btndashborad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndashboradMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndashboradMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndashboradMouseExited(evt);
            }
        });

        btnInventory.setText("Inventory");
        btnInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventoryMouseExited(evt);
            }
        });

        btnorderSales.setText("Order/Sales");
        btnorderSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnorderSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnorderSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnorderSalesMouseExited(evt);
            }
        });

        jButton3.setText("Product List");

        jButton4.setText("Customer List");

        jButton5.setText("Sales Report");

        jButton6.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndashborad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnorderSales, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btndashborad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnorderSales, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 490));

        txtName.setText("name");

        btnhome.setText("jButton1");
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnhome)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(411, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnhome)
                .addContainerGap(336, Short.MAX_VALUE))
        );

        tpdashboard.addTab("tab1", jPanel3);

        menu.addTab("menu", tpdashboard);

        btnInventoryAdd.setText("Add Product");
        btnInventoryAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventoryAddMouseClicked(evt);
            }
        });

        btnInventoryUpdate.setText("Update Product");
        btnInventoryUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventoryUpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnInventoryAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btnInventoryUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInventoryAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(327, Short.MAX_VALUE))
        );

        tpInventory.addTab("tab1", jPanel6);

        menu.addTab("tab5", tpInventory);

        txtProductaddProductId.setEditable(false);
        txtProductaddProductId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Product Name");

        txtProductaddProductName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Unit Price");

        txtProductaddUnitPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Quentity");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buy price/unit");

        txtProductaddPurchasePrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnInvProductAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvProductAdd.setText("Add");
        btnInvProductAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvProductAddMouseClicked(evt);
            }
        });

        btnInvProductReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvProductReset.setText("Reset");
        btnInvProductReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvProductResetMouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Created_Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtProductaddUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductaddPurchasePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addComponent(spanProductaddQuentity)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnInvProductAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInvProductReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txtProductaddProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txtProductaddProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdateAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductaddProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductaddProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jdateAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductaddUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spanProductaddQuentity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductaddPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInvProductAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnInvProductReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        tpInvAddProduct.addTab("tab1", jPanel4);

        menu.addTab("tab2", tpInvAddProduct);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Update Product");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Product Id");

        txtinvUpdateProId.setEditable(false);
        txtinvUpdateProId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Product Name");

        txtinvUpdateProName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtinvUpdateUnitPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Unit Price");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Quentity");

        txtinvUpdateQuentity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtinvUpdatebuyPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Buying Price/Unit");

        tableInvUpdateProdunt.setModel(new javax.swing.table.DefaultTableModel(
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
        tableInvUpdateProdunt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInvUpdateProduntMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableInvUpdateProdunt);

        btnInvUpdateDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvUpdateDelete.setText("Delete");
        btnInvUpdateDelete.setMaximumSize(new java.awt.Dimension(77, 23));
        btnInvUpdateDelete.setMinimumSize(new java.awt.Dimension(77, 23));
        btnInvUpdateDelete.setPreferredSize(new java.awt.Dimension(77, 23));
        btnInvUpdateDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvUpdateDeleteMouseClicked(evt);
            }
        });

        btnInvUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvUpdate.setText("Update");
        btnInvUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvUpdateMouseClicked(evt);
            }
        });

        btnInvUpdateReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvUpdateReset.setText("Reset");
        btnInvUpdateReset.setMaximumSize(new java.awt.Dimension(77, 23));
        btnInvUpdateReset.setMinimumSize(new java.awt.Dimension(77, 23));
        btnInvUpdateReset.setPreferredSize(new java.awt.Dimension(77, 23));
        btnInvUpdateReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvUpdateResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtinvUpdateQuentity, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtinvUpdateUnitPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtinvUpdateProName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtinvUpdateProId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnInvUpdate)
                                            .addComponent(txtinvUpdatebuyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(btnInvUpdateDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnInvUpdateReset, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtinvUpdateProId, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(txtinvUpdateProName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(txtinvUpdateUnitPrice))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(txtinvUpdateQuentity)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtinvUpdatebuyPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInvUpdateDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvUpdateReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        tpInvUpdateProduct.addTab("tab1", jPanel7);

        menu.addTab("tab4", tpInvUpdateProduct);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Customer Information");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Name");

        txtCustomerInfoName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Cell number");

        txtCustomerInfoCell.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("District");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Address");

        comboCustomerDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select division--", "Barisal", "Dhaka", "Chittagong", "Khulna", "Mymensingh", "Rajshahi", "Rangpur", "Sylhet" }));

        btnCustomerNext.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomerNext.setText("Next");
        btnCustomerNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerNextMouseClicked(evt);
            }
        });

        txtCustomerInfoAddress.setColumns(20);
        txtCustomerInfoAddress.setRows(5);
        jScrollPane4.setViewportView(txtCustomerInfoAddress);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Created_date");

        btnCustomerReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomerReset.setText("Reset");
        btnCustomerReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateCustomerInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(txtCustomerInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboCustomerDistrict, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                            .addComponent(txtCustomerInfoCell, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(131, 380, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCustomerReset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnCustomerNext, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerInfoCell, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCustomerDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateCustomerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCustomerReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomerNext, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        tpOrder.addTab("tab1", jPanel8);

        menu.addTab("tab6", tpOrder);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Billing Information");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 33, 294, 40));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Product Name");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 99, 92, 29));

        txtbillProName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txtbillProName, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 99, 161, 29));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Unit Price");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 154, 92, 29));

        txtbillunitPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbillunitPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbillunitPriceFocusLost(evt);
            }
        });
        jPanel9.add(txtbillunitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 154, 161, 29));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Quentity");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 209, 92, 29));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Total Price");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 264, 92, 29));

        txtbillTotalPrice.setEditable(false);
        txtbillTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbillTotalPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbillTotalPriceMouseClicked(evt);
            }
        });
        jPanel9.add(txtbillTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 264, 161, 29));

        txtbillDiscount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtbillDiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbillDiscountFocusLost(evt);
            }
        });
        jPanel9.add(txtbillDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 319, 161, 29));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Discount");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 319, 92, 29));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Final Price");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 374, 92, 29));

        txtbillFinalPrice.setEditable(false);
        txtbillFinalPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel9.add(txtbillFinalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 374, 161, 29));

        tableBillInfoProductDetails.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableBillInfoProductDetails);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 151, 384, 88));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 306, 384, 86));

        jLabel27.setText("Cart");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 257, 205, 31));

        jLabel28.setText("Product List");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 107, 196, -1));

        jButton2.setText("Payment");
        jPanel9.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 424, 150, 34));

        jButton7.setText("Delete");
        jPanel9.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 424, 97, 34));

        btnillInfoReset.setText("Reset");
        btnillInfoReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnillInfoResetMouseClicked(evt);
            }
        });
        jPanel9.add(btnillInfoReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 424, 91, 34));

        jButton9.setText("Save");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 421, 95, 34));

        txtbillquentity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbillquentityMouseClicked(evt);
            }
        });
        jPanel9.add(txtbillquentity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, 30));

        tpBillingInfo.addTab("tab1", jPanel9);

        menu.addTab("tab7", tpBillingInfo);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("Payment Information");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(480, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        tpPayment.addTab("tab1", jPanel10);

        menu.addTab("tab8", tpPayment);

        jLabel7.setText("Last page");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        tpLast.addTab("tab1", jPanel5);

        menu.addTab("tab3", tpLast);

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 810, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        // TODO add your handling code here:
        txtName.getText();

        txtProductaddProductId.setText(txtName.getText());

    }//GEN-LAST:event_btnhomeMouseClicked

    private void btndashboradMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboradMouseClicked
        // TODO add your handling code here:
        menu.setSelectedIndex(0);

    }//GEN-LAST:event_btndashboradMouseClicked

    private void btnInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseClicked
        // TODO add your handling code here:
        menu.setSelectedIndex(1);
    }//GEN-LAST:event_btnInventoryMouseClicked

    private void btnorderSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnorderSalesMouseClicked
        // TODO add your handling code here:
        menu.setSelectedIndex(4);
    }//GEN-LAST:event_btnorderSalesMouseClicked
    //Inventory Add Produnts page Reset 
    private void btnInvProductResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvProductResetMouseClicked
        // TODO add your handling code here:
//        String productName = txtProductaddProductName.getText().trim();
//        String unitPrice = txtProductaddUnitPrice.getText().trim();
//        String quentity = spanProductaddQuentity.getValue().toString();
//        String purchasePrice = txtProductaddPurchasePrice.getText().trim();

        setInvProductReset();

    }//GEN-LAST:event_btnInvProductResetMouseClicked

    private void btnInventoryAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryAddMouseClicked
        // TODO add your handling code here:
        menu.setSelectedIndex(2);
    }//GEN-LAST:event_btnInventoryAddMouseClicked

    private void btnInventoryUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryUpdateMouseClicked
        // TODO add your handling code here:
        menu.setSelectedIndex(3);
        
    }//GEN-LAST:event_btnInventoryUpdateMouseClicked

    private void btnInvProductAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvProductAddMouseClicked
        // TODO add your handling code here:

        String pname = txtProductaddProductName.getText().trim();
        String unitPrice = txtProductaddUnitPrice.getText().trim();
        String quentity = spanProductaddQuentity.getValue().toString();
        String buyPrice = txtProductaddPurchasePrice.getText().trim();
        Date createDate = convertutilltosql(jdateAddProduct.getDate());

        sql = "insert into products(name, quentity, unit_price, purchase_price, entry_date)"
                + " values(?,?,?,?,?)";

        try {
            ps = dbCon.getCon().prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, quentity);
            ps.setString(3, unitPrice);
            ps.setString(4, buyPrice);
            ps.setDate(5, createDate);
            ps.executeUpdate();
            ps.close();
            dbCon.getCon().close();
            JOptionPane.showMessageDialog(rootPane, "Data saved in smemanagement.products table");
            getAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(SMEDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnInvProductAddMouseClicked

    private void btnCustomerNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerNextMouseClicked
        // TODO add your handling code here:
        menu.setSelectedIndex(5);
    }//GEN-LAST:event_btnCustomerNextMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btndashboradMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboradMouseEntered
        // TODO add your handling code here:
        btndashborad.setBackground(new Color(51, 204, 255));
    }//GEN-LAST:event_btndashboradMouseEntered

    private void btndashboradMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboradMouseExited
        // TODO add your handling code here:
        btndashborad.setBackground(getBackground());
        btndashborad.setForeground(getForeground());
    }//GEN-LAST:event_btndashboradMouseExited

    private void btnInventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseEntered
        // TODO add your handling code here:
        btnInventory.setBackground(new Color(51, 204, 255));
    }//GEN-LAST:event_btnInventoryMouseEntered

    private void btnInventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseExited
        // TODO add your handling code here:
        btnInventory.setBackground(getBackground());
        btnInventory.setForeground(getForeground());
    }//GEN-LAST:event_btnInventoryMouseExited

    private void btnorderSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnorderSalesMouseEntered
        // TODO add your handling code here:
        btnorderSales.setBackground(new Color(51, 204, 255));
    }//GEN-LAST:event_btnorderSalesMouseEntered

    private void btnorderSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnorderSalesMouseExited
        // TODO add your handling code here:
        btnorderSales.setBackground(getBackground());
        btnorderSales.setForeground(getForeground());
    }//GEN-LAST:event_btnorderSalesMouseExited

    private void btnInvUpdateResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvUpdateResetMouseClicked
        // TODO add your handling code here:
        setbtnInvUpdateReset();
    }//GEN-LAST:event_btnInvUpdateResetMouseClicked

    private void btnillInfoResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnillInfoResetMouseClicked
        // TODO add your handling code here:
        setbtnillInfoReset();
    }//GEN-LAST:event_btnillInfoResetMouseClicked

    private void txtbillunitPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbillunitPriceFocusLost
        // TODO add your handling code here:

        try {
            if (!(txtbillunitPrice.getText().trim().isEmpty())) {

            } else {
                JOptionPane.showMessageDialog(rootPane, "Unit price can not be empty");
                txtbillunitPrice.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "An Error ocured" + e.getMessage()
            );
        }
    }//GEN-LAST:event_txtbillunitPriceFocusLost

    private void txtbillquentityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbillquentityMouseClicked
        // TODO add your handling code here:
//        int jsQuentity = Integer.parseInt(txtbillquentity.getValue().toString());
//        try {
//            if (txtbillunitPrice.getText().trim().isEmpty()) {
//                txtbillunitPrice.requestFocus();
//            } else if (jsQuentity == 0) {
//                JOptionPane.showMessageDialog(rootPane, "Quentity can not be Zero");
//                txtbillquentity.requestFocus();
//            } else {
////                JOptionPane.showMessageDialog(rootPane, "Quentity can not be Zero");
////                txtbillquentity.requestFocus();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, "An Error ocured" + e.getMessage()
//            );
//        }

    }//GEN-LAST:event_txtbillquentityMouseClicked

    private void txtbillDiscountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbillDiscountFocusLost
        // TODO add your handling code here:
        float finalPrice = getbillAutualPrice();
        txtbillFinalPrice.setText(finalPrice + "");
    }//GEN-LAST:event_txtbillDiscountFocusLost

    private void txtbillTotalPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbillTotalPriceMouseClicked
        // TODO add your handling code here:
        float toatPrice = getbillTotalPrice();
        System.out.println(toatPrice);
        txtbillTotalPrice.setText(toatPrice + "");

    }//GEN-LAST:event_txtbillTotalPriceMouseClicked

    private void btnCustomerResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerResetMouseClicked
        // TODO add your handling code here:
        setbtnCustomerReset();
    }//GEN-LAST:event_btnCustomerResetMouseClicked

    private void tableInvUpdateProduntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInvUpdateProduntMouseClicked
        // TODO add your handling code here:
        int rowIndex = tableInvUpdateProdunt.getSelectedRow();
        
        String produntId = tableInvUpdateProdunt.getModel().getValueAt(rowIndex,0).toString();
        String produntname = tableInvUpdateProdunt.getModel().getValueAt(rowIndex,1).toString();
        String produntQuentity = tableInvUpdateProdunt.getModel().getValueAt(rowIndex,2).toString();
        String produntUnitPrice = tableInvUpdateProdunt.getModel().getValueAt(rowIndex,3).toString();
        String produntbuyPrice = tableInvUpdateProdunt.getModel().getValueAt(rowIndex,4).toString();
        
        txtinvUpdateProId.setText(produntId);
        txtinvUpdateProName.setText(produntname);
        txtinvUpdateQuentity.setText(produntQuentity);
        txtinvUpdateUnitPrice.setText(produntUnitPrice);
        txtinvUpdatebuyPrice.setText(produntbuyPrice);
    }//GEN-LAST:event_tableInvUpdateProduntMouseClicked

    private void btnInvUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvUpdateMouseClicked
        // TODO add your handling code here:
//        txtinvUpdateProId.getText().trim();
//        txtinvUpdateProName.getText().trim();
//        txtinvUpdateQuentity.getText().trim();
//        txtinvUpdateUnitPrice.getText().trim();
//        txtinvUpdatebuyPrice.getText().trim();
        
        sql = "update products set name=?,quentity = ?,unit_price=?,purchase_price = ? where idproducts = ?";
        try {
            ps = dbCon.getCon().prepareStatement(sql);
            ps.setString(1, txtinvUpdateProName.getText().trim());
            ps.setInt(2, Integer.parseInt(txtinvUpdateQuentity.getText().trim()));
            ps.setFloat(3, Float.parseFloat(txtinvUpdateUnitPrice.getText().trim()));
            ps.setFloat(4, Float.parseFloat(txtinvUpdatebuyPrice.getText().trim()));
            ps.setInt(5, Integer.parseInt(txtinvUpdateProId.getText().trim()));
            
            ps.executeUpdate();
            ps.close();
            dbCon.getCon().close();
            JOptionPane.showMessageDialog(rootPane, "produt update in products table");
            setbtnInvUpdateReset();
            getAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(SMEDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnInvUpdateMouseClicked

    private void btnInvUpdateDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvUpdateDeleteMouseClicked
        // TODO add your handling code here:
        
        sql = "delete from products where idproducts = ?";
        try {
            ps = dbCon.getCon().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtinvUpdateProId.getText().trim()));
            
            ps.executeUpdate();
            ps.close();
            dbCon.getCon().close();
            JOptionPane.showMessageDialog(rootPane, "product deleted from products table");
            setbtnInvUpdateReset();
            getAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(SMEDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnInvUpdateDeleteMouseClicked

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
            java.util.logging.Logger.getLogger(SMEDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SMEDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SMEDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SMEDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SMEDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerNext;
    private javax.swing.JButton btnCustomerReset;
    private javax.swing.JButton btnInvProductAdd;
    private javax.swing.JButton btnInvProductReset;
    private javax.swing.JButton btnInvUpdate;
    private javax.swing.JButton btnInvUpdateDelete;
    private javax.swing.JButton btnInvUpdateReset;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnInventoryAdd;
    private javax.swing.JButton btnInventoryUpdate;
    private javax.swing.JButton btndashborad;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnillInfoReset;
    private javax.swing.JButton btnorderSales;
    private javax.swing.JComboBox<String> comboCustomerDistrict;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateCustomerInfo;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser jdateAddProduct;
    private javax.swing.JTabbedPane menu;
    private javax.swing.JSpinner spanProductaddQuentity;
    private javax.swing.JTable tableBillInfoProductDetails;
    private javax.swing.JTable tableInvUpdateProdunt;
    private javax.swing.JTabbedPane tpBillingInfo;
    private javax.swing.JTabbedPane tpInvAddProduct;
    private javax.swing.JTabbedPane tpInvUpdateProduct;
    private javax.swing.JTabbedPane tpInventory;
    private javax.swing.JTabbedPane tpLast;
    private javax.swing.JTabbedPane tpOrder;
    private javax.swing.JTabbedPane tpPayment;
    private javax.swing.JTabbedPane tpdashboard;
    private javax.swing.JTextArea txtCustomerInfoAddress;
    private javax.swing.JTextField txtCustomerInfoCell;
    private javax.swing.JTextField txtCustomerInfoName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtProductaddProductId;
    private javax.swing.JTextField txtProductaddProductName;
    private javax.swing.JTextField txtProductaddPurchasePrice;
    private javax.swing.JTextField txtProductaddUnitPrice;
    private javax.swing.JTextField txtbillDiscount;
    private javax.swing.JTextField txtbillFinalPrice;
    private javax.swing.JTextField txtbillProName;
    private javax.swing.JTextField txtbillTotalPrice;
    private javax.swing.JSpinner txtbillquentity;
    private javax.swing.JTextField txtbillunitPrice;
    private javax.swing.JTextField txtinvUpdateProId;
    private javax.swing.JTextField txtinvUpdateProName;
    private javax.swing.JTextField txtinvUpdateQuentity;
    private javax.swing.JTextField txtinvUpdateUnitPrice;
    private javax.swing.JTextField txtinvUpdatebuyPrice;
    // End of variables declaration//GEN-END:variables
}
