/*
 * Created by JFormDesigner on Thu Apr 09 08:37:34 MSK 2020
 */

package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author unknown
 */
public class OrderMainFrame extends JFrame {
    public OrderMainFrame() {
        initComponents();
    }

    private void treesButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void seedsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void shrubsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void cultureBoxesButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void genomicsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void processesButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void referenceMaterialsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void lastNameTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void phoneTextAreaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void addToOrderButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void costTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void submitOrderButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jLabel1 = new JLabel();
        treesButton = new JButton();
        seedsButton = new JButton();
        shrubsButton = new JButton();
        cultureBoxesButton = new JButton();
        genomicsButton = new JButton();
        processesButton = new JButton();
        referenceMaterialsButton = new JButton();
        jLabel4 = new JLabel();
        jScrollPane2 = new JScrollPane();
        itemsSelectedTextArea = new JTextArea();
        firstNameText = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        lastNameText = new JTextField();
        phoneTextArea = new JTextField();
        jLabel8 = new JLabel();
        itemsSelectedLabel = new JLabel();
        addToOrderButton = new JButton();
        costLabel = new JLabel();
        costText = new JTextField();
        submitOrderButton = new JButton();
        jLabel10 = new JLabel();
        messagesLabel = new JLabel();
        jScrollPane3 = new JScrollPane();
        messagesTextArea = new JTextArea();
        jLabel3 = new JLabel();
        databaseServerIpLabel = new JLabel();
        databaseServerIpText = new JTextField();
        jLabel12 = new JLabel();
        jScrollPane4 = new JScrollPane();
        addressTextArea = new JTextArea();
        jLabel13 = new JLabel();
        jScrollPane1 = new JScrollPane();
        inventoryTextArea = new JTextArea();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setText("Order Management Application");

        //---- treesButton ----
        treesButton.setText("Trees");
        treesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                treesButtonActionPerformed(e);
            }
        });

        //---- seedsButton ----
        seedsButton.setText("Seeds");
        seedsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seedsButtonActionPerformed(e);
            }
        });

        //---- shrubsButton ----
        shrubsButton.setText("Shrubs");
        shrubsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shrubsButtonActionPerformed(e);
            }
        });

        //---- cultureBoxesButton ----
        cultureBoxesButton.setText("Culture Boxes");
        cultureBoxesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cultureBoxesButtonActionPerformed(e);
            }
        });

        //---- genomicsButton ----
        genomicsButton.setText("Genomics");
        genomicsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genomicsButtonActionPerformed(e);
            }
        });

        //---- processesButton ----
        processesButton.setText("Processes");
        processesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processesButtonActionPerformed(e);
            }
        });

        //---- referenceMaterialsButton ----
        referenceMaterialsButton.setText("Reference Materials");
        referenceMaterialsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                referenceMaterialsButtonActionPerformed(e);
            }
        });

        //---- jLabel4 ----
        jLabel4.setText("Press Button For Inventory Display");

        //======== jScrollPane2 ========
        {

            //---- itemsSelectedTextArea ----
            itemsSelectedTextArea.setColumns(20);
            itemsSelectedTextArea.setRows(5);
            jScrollPane2.setViewportView(itemsSelectedTextArea);
        }

        //---- jLabel6 ----
        jLabel6.setText("First Name");

        //---- jLabel7 ----
        jLabel7.setText("Last Name");

        //---- lastNameText ----
        lastNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lastNameTextActionPerformed(e);
            }
        });

        //---- phoneTextArea ----
        phoneTextArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                phoneTextAreaActionPerformed(e);
            }
        });

        //---- jLabel8 ----
        jLabel8.setText("Phone #");

        //---- itemsSelectedLabel ----
        itemsSelectedLabel.setText("Items Selected:");

        //---- addToOrderButton ----
        addToOrderButton.setText("Add to Order");
        addToOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToOrderButtonActionPerformed(e);
            }
        });

        //---- costLabel ----
        costLabel.setText("Order Total Cost:");

        //---- costText ----
        costText.setText("$0");
        costText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                costTextActionPerformed(e);
            }
        });

        //---- submitOrderButton ----
        submitOrderButton.setText("Submit Order");
        submitOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitOrderButtonActionPerformed(e);
            }
        });

        //---- jLabel10 ----
        jLabel10.setText("Product ID : Product Description : Price : Items in Stock");

        //---- messagesLabel ----
        messagesLabel.setText("Messages:");

        //======== jScrollPane3 ========
        {

            //---- messagesTextArea ----
            messagesTextArea.setColumns(20);
            messagesTextArea.setRows(5);
            jScrollPane3.setViewportView(messagesTextArea);
        }

        //---- jLabel3 ----
        jLabel3.setText("Customer Information");

        //---- databaseServerIpLabel ----
        databaseServerIpLabel.setText("Server IP Address:");

        //---- databaseServerIpText ----
        databaseServerIpText.setEditable(false);
        databaseServerIpText.setText("localhost");

        //---- jLabel12 ----
        jLabel12.setText("Address");

        //======== jScrollPane4 ========
        {

            //---- addressTextArea ----
            addressTextArea.setColumns(20);
            addressTextArea.setRows(5);
            jScrollPane4.setViewportView(addressTextArea);
        }

        //---- jLabel13 ----
        jLabel13.setText("SELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER (TRIPLE CLICK)");

        //======== jScrollPane1 ========
        {

            //---- inventoryTextArea ----
            inventoryTextArea.setEditable(false);
            inventoryTextArea.setColumns(20);
            inventoryTextArea.setRows(5);
            jScrollPane1.setViewportView(inventoryTextArea);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(316, 316, 316)
                            .add(jLabel1))
                        .add(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                .add(GroupLayout.LEADING, lastNameText)
                                .add(GroupLayout.LEADING, jLabel12)
                                .add(GroupLayout.LEADING, jScrollPane4, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .add(GroupLayout.LEADING, jLabel7)
                                .add(GroupLayout.LEADING, firstNameText)
                                .add(GroupLayout.LEADING, jLabel6)
                                .add(GroupLayout.LEADING, jLabel3)
                                .add(GroupLayout.LEADING, jLabel8)
                                .add(phoneTextArea))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(9, 9, 9)
                                    .add(itemsSelectedLabel)
                                    .addPreferredGap(LayoutStyle.RELATED)
                                    .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(jLabel4)
                                            .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(databaseServerIpLabel))
                                        .add(jScrollPane2)
                                        .add(jScrollPane3)
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(contentPaneLayout.createParallelGroup()
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(10, 10, 10)
                                                    .add(messagesLabel))
                                                .add(jLabel13)
                                                .add(jLabel10)
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(treesButton)
                                                    .add(18, 18, 18)
                                                    .add(seedsButton)
                                                    .add(27, 27, 27)
                                                    .add(shrubsButton)
                                                    .add(18, 18, 18)
                                                    .add(cultureBoxesButton)
                                                    .add(18, 18, 18)
                                                    .add(genomicsButton)
                                                    .add(18, 18, 18)
                                                    .add(processesButton)))
                                            .add(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(LayoutStyle.RELATED)))
                            .add(contentPaneLayout.createParallelGroup()
                                .add(referenceMaterialsButton)
                                .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                    .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(addToOrderButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(costLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(costText))
                                    .add(databaseServerIpText, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))))
                    .add(74, 74, 74))
                .add(contentPaneLayout.createSequentialGroup()
                    .add(300, 300, 300)
                    .add(submitOrderButton)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(jLabel1)
                    .add(25, 25, 25)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel4)
                        .add(databaseServerIpText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(databaseServerIpLabel))
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(7, 7, 7)
                            .add(jLabel3))
                        .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                            .add(treesButton)
                            .add(seedsButton)
                            .add(shrubsButton)
                            .add(cultureBoxesButton)
                            .add(genomicsButton)
                            .add(processesButton)
                            .add(referenceMaterialsButton)))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jLabel13)
                    .add(3, 3, 3)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel6)
                        .add(jLabel10))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(firstNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(5, 5, 5)
                            .add(jLabel7, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                            .add(2, 2, 2)
                            .add(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(jLabel12)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(jLabel8)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(phoneTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(addToOrderButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .add(13, 13, 13)
                            .add(costLabel)
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(costText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(132, 132, 132)
                                    .add(itemsSelectedLabel)
                                    .addPreferredGap(LayoutStyle.RELATED))
                                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                    .add(18, 18, 18)))
                            .add(jScrollPane2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(submitOrderButton)
                            .add(1, 1, 1)
                            .add(messagesLabel)))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel jLabel1;
    private JButton treesButton;
    private JButton seedsButton;
    private JButton shrubsButton;
    private JButton cultureBoxesButton;
    private JButton genomicsButton;
    private JButton processesButton;
    private JButton referenceMaterialsButton;
    private JLabel jLabel4;
    private JScrollPane jScrollPane2;
    private JTextArea itemsSelectedTextArea;
    private JTextField firstNameText;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JTextField lastNameText;
    private JTextField phoneTextArea;
    private JLabel jLabel8;
    private JLabel itemsSelectedLabel;
    private JButton addToOrderButton;
    private JLabel costLabel;
    private JTextField costText;
    private JButton submitOrderButton;
    private JLabel jLabel10;
    private JLabel messagesLabel;
    private JScrollPane jScrollPane3;
    private JTextArea messagesTextArea;
    private JLabel jLabel3;
    private JLabel databaseServerIpLabel;
    private JTextField databaseServerIpText;
    private JLabel jLabel12;
    private JScrollPane jScrollPane4;
    private JTextArea addressTextArea;
    private JLabel jLabel13;
    private JScrollPane jScrollPane1;
    private JTextArea inventoryTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
