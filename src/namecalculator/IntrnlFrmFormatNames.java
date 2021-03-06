/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namecalculator;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import myframework.pkgGUIContainers.ClsGUIContainers;

/**
 *
 * @author Windows2K
 */
public class IntrnlFrmFormatNames extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmFormatNames
     */
    MyCheckBox chkName[] = null;
    MyCheckBox chkMeaning[] = null;

    JLabel lblTitle[] = null;

    DefaultListModel lstMdlFormatedNames = new DefaultListModel();
    DefaultListModel lstMdlSelectedNames = new DefaultListModel();
    String strNumerologyValue[];
    FrmMain objMainFrom;
    ClsGUIContainers objGUIContainer;

    public IntrnlFrmFormatNames() {
        objMainFrom = FrmMain.self();
        objGUIContainer = ClsGUIContainers.self(objMainFrom.txtLogs);

        initComponents();
        DefaultTableModel obj = new DefaultTableModel(new Object[]{"Column-1", "Column-2", "Column-3"}, 4);
        tblPastedBabyNames.setModel(obj);
        fnLoadCheckBoxes();
        //0 ,1     ,2    ,3     ,4    ,5     ,6    ,7   ,8
        strNumerologyValue = new String[]{"", "AIJQY", "BKR", "CGLS", "DMT", "HENX", "UVW", "OZ", "PF"};

    }

    private void fnLoadCheckBoxes() {

        tblPastedBabyNames.packAll();
        pnlCheckBoxes.setPreferredSize(new Dimension(tblPastedBabyNames.getPreferredSize().width, pnlCheckBoxes.getPreferredSize().height));

        int intColCount = tblPastedBabyNames.getColumnCount();
        pnlCheckBoxes.setLayout(new GridLayout(3, intColCount));

        if (chkName != null) {
            for (int i = 0; i < chkName.length; i++) {
                pnlCheckBoxes.remove(chkName[i]);
                chkName[i] = null;

                pnlCheckBoxes.remove(chkMeaning[i]);
                chkMeaning[i] = null;

                pnlCheckBoxes.remove(lblTitle[i]);
                lblTitle[i] = null;

            }
        }

        chkName = new MyCheckBox[intColCount];
        chkMeaning = new MyCheckBox[intColCount];
        lblTitle = new JLabel[intColCount];

        for (int i = 0; i < intColCount; i++) {
            lblTitle[i] = new JLabel("Column " + (i + 1));
            pnlCheckBoxes.add(lblTitle[i]);
        }

        for (int i = 0; i < intColCount; i++) {
            chkName[i] = new MyCheckBox("Name " + (i + 1), i);
            chkName[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    chkNameCheckBoxClicked(evt);
                }
            });
            pnlCheckBoxes.add(chkName[i]);
        }

        for (int i = 0; i < intColCount; i++) {
            chkMeaning[i] = new MyCheckBox("Mean " + (i + 1), i);
            chkMeaning[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    chkMeaningCheckBoxClicked(evt);
                }
            });
            pnlCheckBoxes.add(chkMeaning[i]);
        }
        pnlCheckBoxes.updateUI();
    }

    static IntrnlFrmFormatNames objFrm;

    private void chkNameCheckBoxClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        MyCheckBox objChkBox = (MyCheckBox) evt.getComponent();
        if (objChkBox.isSelected()) {
            chkMeaning[objChkBox.fnGetIndex()].setSelected(false);
        }
    }

    private void chkMeaningCheckBoxClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        MyCheckBox objChkBox = (MyCheckBox) evt.getComponent();
        if (objChkBox.isSelected()) {
            chkName[objChkBox.fnGetIndex()].setSelected(false);
        }
    }

    public static IntrnlFrmFormatNames self() {
        //if (objFrm == null) {
            objFrm = new IntrnlFrmFormatNames();
        //}
        return objFrm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popPasteMenu = new javax.swing.JPopupMenu();
        mnuPasteNames = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuAddCustomName = new javax.swing.JMenuItem();
        optgroupdelimiter = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmdGetNames = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSelectedNames = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmdMoveSelectedNamesLTR = new javax.swing.JButton();
        cmdMoveAllNamesLTR = new javax.swing.JButton();
        cmdSaveToDatabase = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstFormatedNames1 = new javax.swing.JList();
        scrlCheckBoxes = new javax.swing.JScrollPane();
        pnlCheckBoxes = new javax.swing.JPanel();
        scrltbl = new javax.swing.JScrollPane();
        tblPastedBabyNames = new org.jdesktop.swingx.JXTable();
        jLabel8 = new javax.swing.JLabel();
        optCustomSeperation = new javax.swing.JRadioButton();
        optSpaceSeperation = new javax.swing.JRadioButton();
        optTabSeperation = new javax.swing.JRadioButton();
        optComaSeperation = new javax.swing.JRadioButton();
        txtCustomDelimiter = new javax.swing.JTextField();
        cmdMoveAllNamesRTL = new javax.swing.JButton();
        cmdMoveSelectedNamesRTL = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNameInitial = new javax.swing.JTextField();
        cmdClearAllData = new javax.swing.JButton();
        txtSourceLink = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        mnuPasteNames.setText("Clear Data & Paste Copied Names");
        mnuPasteNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPasteNamesActionPerformed(evt);
            }
        });
        popPasteMenu.add(mnuPasteNames);
        popPasteMenu.add(jSeparator1);

        mnuAddCustomName.setText("Add Custom Name");
        mnuAddCustomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddCustomNameActionPerformed(evt);
            }
        });
        popPasteMenu.add(mnuAddCustomName);

        setBackground(new java.awt.Color(255, 153, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Copy Names From Web site");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1.png"))); // NOI18N
        jLabel1.setText("<html> Copy baby names from the internet web page and paste here. After paste, paste the source link to the below field</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 820, 20));

        cmdGetNames.setBackground(new java.awt.Color(255, 255, 0));
        cmdGetNames.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdGetNames.setText("Get Names");
        cmdGetNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGetNamesActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGetNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 119, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/2.png"))); // NOI18N
        jLabel3.setText("<html> Click this button after paste (This will try to identify individual names)</html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 410, 25));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/3.png"))); // NOI18N
        jLabel6.setText("<html> Preview of the baby names after identification</html>");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 400, 20));

        lstSelectedNames.setBackground(new java.awt.Color(153, 255, 153));
        jScrollPane3.setViewportView(lstSelectedNames);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 330, 400, 260));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/5.png"))); // NOI18N
        jLabel2.setText(" Selected baby names that can be saved to database");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 400, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/4.png"))); // NOI18N
        jLabel4.setText("<html> Move names from right to left</html>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 170, -1));

        cmdMoveSelectedNamesLTR.setBackground(new java.awt.Color(255, 153, 102));
        cmdMoveSelectedNamesLTR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdMoveSelectedNamesLTR.setText("Move Selected Names -->");
        cmdMoveSelectedNamesLTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMoveSelectedNamesLTRActionPerformed(evt);
            }
        });
        getContentPane().add(cmdMoveSelectedNamesLTR, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 190, -1));

        cmdMoveAllNamesLTR.setBackground(new java.awt.Color(255, 153, 102));
        cmdMoveAllNamesLTR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdMoveAllNamesLTR.setText("Move All Names -->");
        cmdMoveAllNamesLTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMoveAllNamesLTRActionPerformed(evt);
            }
        });
        getContentPane().add(cmdMoveAllNamesLTR, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 190, -1));

        cmdSaveToDatabase.setBackground(new java.awt.Color(0, 204, 0));
        cmdSaveToDatabase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdSaveToDatabase.setText("Save & Clear");
        cmdSaveToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveToDatabaseActionPerformed(evt);
            }
        });
        getContentPane().add(cmdSaveToDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 610, 110, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/6.png"))); // NOI18N
        jLabel7.setText("<html>Finally Save the selected names to Database </html>");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 220, 30));
        jLabel7.getAccessibleContext().setAccessibleName("Finally Save the selected names to Database");

        lstFormatedNames1.setBackground(new java.awt.Color(255, 153, 102));
        jScrollPane4.setViewportView(lstFormatedNames1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 370, 260));

        scrlCheckBoxes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlCheckBoxes.setBackground(new java.awt.Color(0, 204, 204));
        pnlCheckBoxes.setLayout(null);
        scrlCheckBoxes.setViewportView(pnlCheckBoxes);

        getContentPane().add(scrlCheckBoxes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 822, 60));

        scrltbl.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrltbl.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblPastedBabyNames.setBackground(new java.awt.Color(255, 255, 102));
        tblPastedBabyNames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPastedBabyNames.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPastedBabyNames.setComponentPopupMenu(popPasteMenu);
        tblPastedBabyNames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPastedBabyNamesMouseReleased(evt);
            }
        });
        scrltbl.setViewportView(tblPastedBabyNames);
        if (tblPastedBabyNames.getColumnModel().getColumnCount() > 0) {
            tblPastedBabyNames.getColumnModel().getColumn(0).setResizable(false);
            tblPastedBabyNames.getColumnModel().getColumn(1).setResizable(false);
            tblPastedBabyNames.getColumnModel().getColumn(2).setResizable(false);
            tblPastedBabyNames.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(scrltbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 822, 135));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("jLabel8");
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 650, -1, -1));

        optgroupdelimiter.add(optCustomSeperation);
        optCustomSeperation.setText("Custom");
        getContentPane().add(optCustomSeperation, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 70, -1));

        optgroupdelimiter.add(optSpaceSeperation);
        optSpaceSeperation.setText("Space Seperation");
        getContentPane().add(optSpaceSeperation, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, -1));

        optgroupdelimiter.add(optTabSeperation);
        optTabSeperation.setSelected(true);
        optTabSeperation.setText("Tab Seperation");
        getContentPane().add(optTabSeperation, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, -1, -1));

        optgroupdelimiter.add(optComaSeperation);
        optComaSeperation.setText("Coma Seperation");
        getContentPane().add(optComaSeperation, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, -1, -1));
        getContentPane().add(txtCustomDelimiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, 60, 20));

        cmdMoveAllNamesRTL.setBackground(new java.awt.Color(153, 255, 153));
        cmdMoveAllNamesRTL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdMoveAllNamesRTL.setText("<-- Move All Names");
        cmdMoveAllNamesRTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMoveAllNamesRTLActionPerformed(evt);
            }
        });
        getContentPane().add(cmdMoveAllNamesRTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 190, -1));

        cmdMoveSelectedNamesRTL.setBackground(new java.awt.Color(153, 255, 153));
        cmdMoveSelectedNamesRTL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdMoveSelectedNamesRTL.setText("<-- Move Selected Names");
        cmdMoveSelectedNamesRTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMoveSelectedNamesRTLActionPerformed(evt);
            }
        });
        getContentPane().add(cmdMoveSelectedNamesRTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 190, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/4.png"))); // NOI18N
        jLabel9.setText("<html> Move names from left to right</html>");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 170, -1));

        jLabel5.setText("<html>Name Initial (Press Enter after any Change)</html>");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 150, 30));

        txtNameInitial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameInitialActionPerformed(evt);
            }
        });
        getContentPane().add(txtNameInitial, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 50, -1));

        cmdClearAllData.setBackground(new java.awt.Color(255, 51, 51));
        cmdClearAllData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdClearAllData.setText("Clear All Data");
        cmdClearAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearAllDataActionPerformed(evt);
            }
        });
        getContentPane().add(cmdClearAllData, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 140, -1));
        getContentPane().add(txtSourceLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 720, -1));

        jLabel10.setText("Reference Link");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdGetNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGetNamesActionPerformed
        // TODO add your handling code here:

        boolean blnNameSelected = false;
        boolean blnMeaningSelected = false;

        for (int i = 0; i < chkName.length; i++) {
            if (chkName[i].isSelected()) {
                blnNameSelected = true;
            }

            if (chkMeaning[i].isSelected()) {
                blnMeaningSelected = true;
            }
        }

        if (!blnNameSelected || !blnMeaningSelected) {
            objGUIContainer.fnShowConfirmDialog(this, "Name or meaning not selected. Please select to proceed.", "Confirm", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
            return;
        }

        String strDelimiter = "";

        if (optComaSeperation.isSelected()) {
            strDelimiter = ",";
        } else if (optCustomSeperation.isSelected()) {
            strDelimiter = txtCustomDelimiter.getText();
        } else if (optSpaceSeperation.isSelected()) {
            strDelimiter = " ";
        } else if (optTabSeperation.isSelected()) {
            strDelimiter = "\t";
        }

        String strName = "";
        String strMeaning = "";

        lstMdlFormatedNames.removeAllElements();

        for (int j = 0; j < tblPastedBabyNames.getRowCount(); j++) {
            for (int i = 0; i < chkName.length; i++) {
                if (chkName[i].isSelected()) {
                    strName = strName + "" + tblPastedBabyNames.getModel().getValueAt(j, i).toString() + " ";
                }

                if (chkMeaning[i].isSelected()) {
                    strMeaning = strMeaning + "" + tblPastedBabyNames.getModel().getValueAt(j, i).toString() + " ";
                }
            }

            lstMdlFormatedNames.addElement("[" + (j + 1) + "] " + strName + " -> " + strMeaning);
            strName = "";
            strMeaning = "";

        }
        lstFormatedNames1.setModel(lstMdlFormatedNames);

    }//GEN-LAST:event_cmdGetNamesActionPerformed

    private void fnPasteData(String strContent) {
        // TODO add your handling code here:
        String strClipboardContent = strContent;
        //objGUIContainer.fnShowConfirmDialog(this, strClipboardContent);

        String strLines[] = strClipboardContent.split("\n");
        String strLineColumns[] = null;
        ArrayList objAlRow = new ArrayList(strLines.length);
        String strDelimiter = "";

        int intOmitedRows = 0;
        int intMaxCols = 0;
        for (int i = 0; i < strLines.length; i++) {

            if (optComaSeperation.isSelected()) {
                strDelimiter = ",";
            } else if (optCustomSeperation.isSelected()) {
                strDelimiter = txtCustomDelimiter.getText();
            } else if (optSpaceSeperation.isSelected()) {
                strDelimiter = " ";
            } else if (optTabSeperation.isSelected()) {
                strDelimiter = "\t";
            }

            strLines[i] = strLines[i].trim();

            if (strLines[i].isEmpty()) {
                intOmitedRows += 1;
                continue;
            }

            strLineColumns = strLines[i].split(strDelimiter);

            if (intMaxCols < strLineColumns.length) {
                intMaxCols = strLineColumns.length;
            }
            ArrayList objAlColumns = new ArrayList(strLineColumns.length + 1);
            objAlColumns.add(i + 1 - intOmitedRows);
            for (int j = 0; j < strLineColumns.length; j++) {
                objAlColumns.add(strLineColumns[j]);
            }
            objAlRow.add(objAlColumns);
        }

        //serial number is the +1
        intMaxCols += 1;

        Object objData[][] = new Object[objAlRow.size()][intMaxCols];
        Object objHeader[] = new Object[intMaxCols];

        for (int i = 0; i < objAlRow.size(); i++) {
            ArrayList objAlColumns = (ArrayList) objAlRow.get(i);
            for (int j = 0; j < objAlColumns.size(); j++) {
                objData[i][j] = objAlColumns.get(j);
            }
        }

        for (int j = 0; j < intMaxCols; j++) {
            objHeader[j] = "Column " + (j + 1);
        }

        DefaultTableModel objModal = new DefaultTableModel(objData, objHeader);

        tblPastedBabyNames.setModel(objModal);

        fnLoadCheckBoxes();
        txtSourceLink.setText("");
        objGUIContainer.fnShowConfirmDialog(this, objAlRow.size() + " line(s) pasted. \nAnd " + intOmitedRows + " line(s) rejected.", "Confirmation", JOptionPane.PLAIN_MESSAGE);
    }

    private void mnuPasteNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPasteNamesActionPerformed
        try {
            fnPasteData(Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString().replace("'", "''"));
        } catch (UnsupportedFlavorException ex) {
            //Logger.getLogger(IntrnlFrmFormatNames.class.getName()).log(Level.SEVERE, null, ex);
            objGUIContainer.fnShowConfirmDialog(this, ex.getMessage(), "Information", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            //Logger.getLogger(IntrnlFrmFormatNames.class.getName()).log(Level.SEVERE, null, ex);
            objGUIContainer.fnShowConfirmDialog(this, ex.getMessage(), "Information", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mnuPasteNamesActionPerformed

    private int fnCalcNumerologyValueBig(String strText) {
        strText = strText.toUpperCase();
        int intTotalValue = 0;
        for (int iCount = 0; iCount < strText.length(); iCount++) {
            for (int jCount = 1; jCount < strNumerologyValue.length; jCount++) {
                if (strNumerologyValue[jCount].contains(strText.substring(iCount, iCount + 1))) {
                    intTotalValue += jCount;
                    break;
                }
            }
        }
        return intTotalValue;
    }

    private int fnCalcNumerologyValueSmall(int intBigValue) {
        int intTotalValue = 0;
        String str = "" + intBigValue;
        for (int iCount = 0; iCount < str.length(); iCount++) {
            intTotalValue += Integer.parseInt(str.substring(iCount, iCount + 1));
        }
        str = "" + intTotalValue;
        if (str.length() != 1) {
            intTotalValue = fnCalcNumerologyValueSmall(intTotalValue);
        } else {
            return intTotalValue;
        }
        return intTotalValue;
    }

    private void cmdSaveToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveToDatabaseActionPerformed
        try {
            // TODO add your handling code here:
            int intLetterCount = 0;
            int intLetterCount_initial = 0;
            int intNumerologySmall = 0;
            int intNumerologyBig = 0;
            int intNumerologySmall_initial = 0;
            int intNumerologyBig_initial = 0;
            String strName = "";
            String strName_initial = "";
            String strMeaning = "";
            String str[];
            String strInitial = txtNameInitial.getText().replace(".", "").trim();

            if (txtSourceLink.getText().trim().isEmpty()) {
                objGUIContainer.fnShowConfirmDialog(this, "Reference link field is empty. Please update. \n(Save operation cancelled.)", "Confirm", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
                return;
            }

            objMainFrom.objDBHSQ.fnInsertQuery("ChooseYourBabyName","insert into tbl_reference_link (value) values ('" + txtSourceLink.getText().trim() + "')");
            ResultSet objRs = objMainFrom.objDBHSQ.fnSelectQuery("ChooseYourBabyName","select IDENTITY() from TBL_NAME_INITIAL");
            objRs.next();
            int intRefLinkId = objRs.getInt(1);

            for (int iCount = 0; iCount < lstMdlSelectedNames.getSize(); iCount++) {

                str = lstMdlSelectedNames.get(iCount).toString().split("] | -> ");
                strName = str[1].trim();
                strName_initial = strInitial + " " + strName;
                strMeaning = str[2].trim();

                intLetterCount = strName.length();
                intNumerologyBig = fnCalcNumerologyValueBig(strName);
                intNumerologySmall = fnCalcNumerologyValueSmall(intNumerologyBig);

                intLetterCount_initial = strInitial.length() + strName.length();
                intNumerologyBig_initial = fnCalcNumerologyValueBig(strName_initial);
                intNumerologySmall_initial = fnCalcNumerologyValueSmall(intNumerologyBig_initial);

                objMainFrom.objDBHSQ.fnInsertQuery("ChooseYourBabyName","insert into TBL_BABY_NAMES(REF_TBLID_REF_LINK, name, name_initial, namemeaning, lettercount,lettercount_initial, numerology_actual_num, numerology_actual_num_initial, numerology_single_num,numerology_single_num_initial) values (" + intRefLinkId + ",'" + strName + "','" + strName_initial + "','" + strMeaning + "'," + intLetterCount + "," + intLetterCount_initial + "," + intNumerologyBig + "," + intNumerologyBig_initial + "," + intNumerologySmall + "," + intNumerologySmall_initial + ")");
            }
            lstMdlFormatedNames.clear();
            lstMdlSelectedNames.clear();
            objGUIContainer.fnShowConfirmDialog(this, "Insert operation completed", "Process complete", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            //Logger.getLogger(IntrnlFrmFormatNames.class.getName()).log(Level.SEVERE, null, ex);
            objGUIContainer.fnShowConfirmDialog(this, ex.getMessage(), "Information", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdSaveToDatabaseActionPerformed

    private void tblPastedBabyNamesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPastedBabyNamesMouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == 3) {
            popPasteMenu.show(tblPastedBabyNames, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblPastedBabyNamesMouseReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            // TODO add your handling code here:
            ResultSet objrs = objMainFrom.objDBHSQ.fnSelectQuery("ChooseYourBabyName","select initial from tbl_name_initial");
            objrs.next();
            txtNameInitial.setText(objrs.getString(1));
            objrs.close();
            objrs = null;
        } catch (SQLException ex) {
            //Logger.getLogger(IntrnlFrmFormatNames.class.getName()).log(Level.SEVERE, null, ex);
            objGUIContainer.fnShowConfirmDialog(this, ex.getMessage(), "Information", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
        }
        //objGUIContainer.fnShowInternalFormMiddle(objMainFrom, this);
    }//GEN-LAST:event_formInternalFrameOpened

    private void cmdMoveAllNamesLTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMoveAllNamesLTRActionPerformed
        // TODO add your handling code here:
        int intSize = lstMdlFormatedNames.getSize();
        for (int i = 0; i < lstMdlFormatedNames.getSize(); i++) {
            lstMdlSelectedNames.addElement(lstMdlFormatedNames.get(i));
        }

        lstMdlFormatedNames.removeAllElements();

        lstSelectedNames.setModel(lstMdlSelectedNames);
        objGUIContainer.fnShowConfirmDialog(this, intSize + " names moved.", "Confirmation", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_cmdMoveAllNamesLTRActionPerformed

    private void cmdMoveSelectedNamesLTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMoveSelectedNamesLTRActionPerformed
        // TODO add your handling code here:
        List objLst = lstFormatedNames1.getSelectedValuesList();
        for (int i = 0; i < objLst.size(); i++) {
            lstMdlSelectedNames.addElement(objLst.get(i));
            lstMdlFormatedNames.removeElement(objLst.get(i));
        }

        lstSelectedNames.setModel(lstMdlSelectedNames);

        objGUIContainer.fnShowConfirmDialog(this, objLst.size() + " names moved.", "Confirmation", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_cmdMoveSelectedNamesLTRActionPerformed

    private void cmdMoveAllNamesRTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMoveAllNamesRTLActionPerformed
        // TODO add your handling code here:
        int intSize = lstMdlSelectedNames.getSize();
        for (int i = 0; i < intSize; i++) {
            lstMdlFormatedNames.addElement(lstMdlSelectedNames.get(i));
        }
        lstMdlSelectedNames.removeAllElements();

        lstFormatedNames1.setModel(lstMdlFormatedNames);

        objGUIContainer.fnShowConfirmDialog(this, intSize + " names moved.", "Confirmation", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_cmdMoveAllNamesRTLActionPerformed

    private void cmdMoveSelectedNamesRTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMoveSelectedNamesRTLActionPerformed
        // TODO add your handling code here:
        List objLst = lstSelectedNames.getSelectedValuesList();
        for (int i = 0; i < objLst.size(); i++) {
            lstMdlFormatedNames.addElement(objLst.get(i));
            lstMdlSelectedNames.removeElement(objLst.get(i));
        }

        lstFormatedNames1.setModel(lstMdlFormatedNames);
        objGUIContainer.fnShowConfirmDialog(this, objLst.size() + " names moved.", "Confirmation", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_cmdMoveSelectedNamesRTLActionPerformed

    private void txtNameInitialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameInitialActionPerformed
        try {
            // TODO add your handling code here:
            if (objMainFrom.objDBHSQ.fnUpdateQuery("ChooseYourBabyName","update tbl_name_initial set initial = '" + txtNameInitial.getText() + "'") != -1) {
                objGUIContainer.fnShowConfirmDialog(this, "Initial Updated..", "Confirmation", JOptionPane.PLAIN_MESSAGE);
            } else {
                objGUIContainer.fnShowConfirmDialog(this, "Initial not Updated..", "Confirmation", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
            objGUIContainer.fnShowConfirmDialog(this, ex.getMessage(), "Information", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNameInitialActionPerformed

    private void cmdClearAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearAllDataActionPerformed
        // TODO add your handling code here:
        DefaultTableModel obj = new DefaultTableModel(new Object[]{"Column-1", "Column-2", "Column-3"}, 4);
        tblPastedBabyNames.setModel(obj);
        fnLoadCheckBoxes();
        lstMdlFormatedNames.clear();
        lstMdlSelectedNames.clear();
    }//GEN-LAST:event_cmdClearAllDataActionPerformed

    private void mnuAddCustomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddCustomNameActionPerformed
        // TODO add your handling code here:
        String strValue = JOptionPane.showInputDialog(this, "Enter Name & Meaning separated with '/' character");
        if (!strValue.isEmpty()) {
            optCustomSeperation.setSelected(true);
            txtCustomDelimiter.setText("/");
            fnPasteData(strValue);
            optTabSeperation.setSelected(true);
        }
    }//GEN-LAST:event_mnuAddCustomNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClearAllData;
    private javax.swing.JButton cmdGetNames;
    private javax.swing.JButton cmdMoveAllNamesLTR;
    private javax.swing.JButton cmdMoveAllNamesRTL;
    private javax.swing.JButton cmdMoveSelectedNamesLTR;
    private javax.swing.JButton cmdMoveSelectedNamesRTL;
    private javax.swing.JButton cmdSaveToDatabase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JList lstFormatedNames1;
    private javax.swing.JList lstSelectedNames;
    private javax.swing.JMenuItem mnuAddCustomName;
    private javax.swing.JMenuItem mnuPasteNames;
    private javax.swing.JRadioButton optComaSeperation;
    private javax.swing.JRadioButton optCustomSeperation;
    private javax.swing.JRadioButton optSpaceSeperation;
    private javax.swing.JRadioButton optTabSeperation;
    private javax.swing.ButtonGroup optgroupdelimiter;
    private javax.swing.JPanel pnlCheckBoxes;
    private javax.swing.JPopupMenu popPasteMenu;
    private javax.swing.JScrollPane scrlCheckBoxes;
    private javax.swing.JScrollPane scrltbl;
    private org.jdesktop.swingx.JXTable tblPastedBabyNames;
    private javax.swing.JTextField txtCustomDelimiter;
    private javax.swing.JTextField txtNameInitial;
    private javax.swing.JTextField txtSourceLink;
    // End of variables declaration//GEN-END:variables
}
