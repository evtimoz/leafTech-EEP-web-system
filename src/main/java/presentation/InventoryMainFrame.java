/*
 * Created by JFormDesigner on Thu Apr 09 08:17:10 MSK 2020
 */

package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author evtimoz
 */
public class InventoryMainFrame extends JFrame {
    public InventoryMainFrame() {
        initComponents();
    }

    private void treesRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void seedsRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void shrubsRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void productIdTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void addItemButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void productDescriptionTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void listInventoryButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteItemButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void decrementButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void cultureBoxesRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void genomicsRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void processingRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void referenceMaterialsRadioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        treesRadioButton = new JRadioButton();
        seedsRadioButton = new JRadioButton();
        shrubsRadioButton = new JRadioButton();
        frameTitleLabel = new JLabel();
        productIdLabel = new JLabel();
        priceLabel = new JLabel();
        quantityLabel = new JLabel();
        productIdText = new JTextField();
        priceText = new JTextField();
        quantityText = new JTextField();
        addItemButton = new JButton();
        jSeparator1 = new JSeparator();
        inventoryScrollPane = new JScrollPane();
        inventoryTextArea = new JTextArea();
        productDescriptionLabel = new JLabel();
        productDescriptionText = new JTextField();
        listInventoryButton = new JButton();
        deleteItemButton = new JButton();
        decrementButton = new JButton();
        deleteText = new JLabel();
        decrementText = new JLabel();
        cultureBoxesRadioButton = new JRadioButton();
        genomicsRadioButton = new JRadioButton();
        processingRadioButton = new JRadioButton();
        referenceMaterialsRadioButton = new JRadioButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- treesRadioButton ----
        treesRadioButton.setText("Trees");
        treesRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                treesRadioButtonActionPerformed(e);
            }
        });

        //---- seedsRadioButton ----
        seedsRadioButton.setText("Shrubs");
        seedsRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seedsRadioButtonActionPerformed(e);
            }
        });

        //---- shrubsRadioButton ----
        shrubsRadioButton.setText("Seeds");
        shrubsRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shrubsRadioButtonActionPerformed(e);
            }
        });

        //---- frameTitleLabel ----
        frameTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        frameTitleLabel.setText("EEPs Inventory Management Application");

        //---- productIdLabel ----
        productIdLabel.setText("Product ID");

        //---- priceLabel ----
        priceLabel.setText("Price");

        //---- quantityLabel ----
        quantityLabel.setText("Quantity");

        //---- productIdText ----
        productIdText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                productIdTextActionPerformed(e);
            }
        });

        //---- addItemButton ----
        addItemButton.setText("Add Item");
        addItemButton.setActionCommand("jButton1");
        addItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemButtonActionPerformed(e);
            }
        });

        //======== inventoryScrollPane ========
        {

            //---- inventoryTextArea ----
            inventoryTextArea.setColumns(20);
            inventoryTextArea.setRows(5);
            inventoryScrollPane.setViewportView(inventoryTextArea);
        }

        //---- productDescriptionLabel ----
        productDescriptionLabel.setText("Product Description");

        //---- productDescriptionText ----
        productDescriptionText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                productDescriptionTextActionPerformed(e);
            }
        });

        //---- listInventoryButton ----
        listInventoryButton.setText("List Inventory");
        listInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listInventoryButtonActionPerformed(e);
            }
        });

        //---- deleteItemButton ----
        deleteItemButton.setText("Delete Item");
        deleteItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteItemButtonActionPerformed(e);
            }
        });

        //---- decrementButton ----
        decrementButton.setText("Decrement");
        decrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrementButtonActionPerformed(e);
            }
        });

        //---- deleteText ----
        deleteText.setText("Deletes item selected from list ");

        //---- decrementText ----
        decrementText.setText("Decrements inventory count of item selected from the list");

        //---- cultureBoxesRadioButton ----
        cultureBoxesRadioButton.setText("Culture Boxes");
        cultureBoxesRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cultureBoxesRadioButtonActionPerformed(e);
            }
        });

        //---- genomicsRadioButton ----
        genomicsRadioButton.setText("Genomics");
        genomicsRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genomicsRadioButtonActionPerformed(e);
            }
        });

        //---- processingRadioButton ----
        processingRadioButton.setText("Processing");
        processingRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processingRadioButtonActionPerformed(e);
            }
        });

        //---- referenceMaterialsRadioButton ----
        referenceMaterialsRadioButton.setText("Reference Materials");
        referenceMaterialsRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                referenceMaterialsRadioButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(13, 13, 13)
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                .add(productIdLabel)
                                .add(productDescriptionLabel)
                                .add(priceLabel)
                                .add(quantityLabel))
                            .add(5, 5, 5)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(productDescriptionText, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE)
                                    .add(0, 68, Short.MAX_VALUE))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(priceText)
                                        .add(quantityText)
                                        .add(productIdText, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                    .add(26, 26, 26)
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(treesRadioButton)
                                            .add(9, 9, 9)
                                            .add(contentPaneLayout.createParallelGroup()
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(51, 51, 51)
                                                    .add(addItemButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                                                    .add(shrubsRadioButton)
                                                    .add(18, 18, 18)
                                                    .add(seedsRadioButton))))
                                        .add(GroupLayout.TRAILING, listInventoryButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                    .add(18, 18, 18)
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(decrementButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.UNRELATED)
                                            .add(decrementText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(contentPaneLayout.createParallelGroup()
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(deleteItemButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(deleteText))
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(cultureBoxesRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(genomicsRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(processingRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(referenceMaterialsRadioButton)))
                                            .add(0, 0, Short.MAX_VALUE))))))
                        .add(GroupLayout.TRAILING, jSeparator1)
                        .add(inventoryScrollPane))
                    .addContainerGap())
                .add(contentPaneLayout.createSequentialGroup()
                    .add(324, 324, 324)
                    .add(frameTitleLabel)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(frameTitleLabel)
                    .addPreferredGap(LayoutStyle.RELATED, 103, Short.MAX_VALUE)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(productDescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(productDescriptionLabel))
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(productIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(treesRadioButton)
                        .add(productIdLabel)
                        .add(shrubsRadioButton)
                        .add(seedsRadioButton)
                        .add(cultureBoxesRadioButton)
                        .add(genomicsRadioButton)
                        .add(processingRadioButton)
                        .add(referenceMaterialsRadioButton))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(priceLabel))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(quantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(quantityLabel)
                        .add(deleteItemButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .add(deleteText)
                        .add(addItemButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .add(18, 18, 18)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(decrementButton)
                        .add(decrementText)
                        .add(listInventoryButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .add(55, 55, 55)
                    .add(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(18, 18, 18)
                    .add(inventoryScrollPane, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JRadioButton treesRadioButton;
    private JRadioButton seedsRadioButton;
    private JRadioButton shrubsRadioButton;
    private JLabel frameTitleLabel;
    private JLabel productIdLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JTextField productIdText;
    private JTextField priceText;
    private JTextField quantityText;
    private JButton addItemButton;
    private JSeparator jSeparator1;
    private JScrollPane inventoryScrollPane;
    private JTextArea inventoryTextArea;
    private JLabel productDescriptionLabel;
    private JTextField productDescriptionText;
    private JButton listInventoryButton;
    private JButton deleteItemButton;
    private JButton decrementButton;
    private JLabel deleteText;
    private JLabel decrementText;
    private JRadioButton cultureBoxesRadioButton;
    private JRadioButton genomicsRadioButton;
    private JRadioButton processingRadioButton;
    private JRadioButton referenceMaterialsRadioButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
