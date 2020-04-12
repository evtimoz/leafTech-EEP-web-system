/*
 * Created by JFormDesigner on Thu Apr 09 08:17:10 MSK 2020
 */

package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import middleware.AuthenticationService;
import middleware.InventoryService;
import model.Product;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
import java.util.List;


/**
 * @author evtimoz
 */
public class InventoryMainFrame extends JFrame {
    private String userName;
    public InventoryMainFrame(String login) {
        userName = login;

        initComponents();
    }

    private static String productType = "";

    private void treesRadioButtonActionPerformed(ActionEvent e) {
        productType = "tree";
    }

    private void seedsRadioButtonActionPerformed(ActionEvent e) {
        productType = "shrub";
    }

    private void shrubsRadioButtonActionPerformed(ActionEvent e) {
        productType = "seed";
    }

    private void cultureBoxesRadioButtonActionPerformed(ActionEvent e) {
        productType = "culturebox";
    }

    private void genomicsRadioButtonActionPerformed(ActionEvent e) {
        productType = "genomic";
    }

    private void processingRadioButtonActionPerformed(ActionEvent e) {
        productType = "processing";
    }

    private void referenceMaterialsRadioButtonActionPerformed(ActionEvent e) {
        productType = "referencematerial";
    }

    private void addItemButtonActionPerformed(ActionEvent e) {
        boolean fieldError = false;     // Error flag
        inventoryTextArea.setText("");

        if (!treesRadioButton.isSelected() && !seedsRadioButton.isSelected() &&
                !shrubsRadioButton.isSelected() && !cultureBoxesRadioButton.isSelected() &&
                !genomicsRadioButton.isSelected() && !processingRadioButton.isSelected() && !referenceMaterialsRadioButton.isSelected()){
            fieldError = true;
            inventoryTextArea.setText("\n Please, specify product type");
        } else {
            //Make sure there is a product description
            if ( productDescriptionText.getText().length() == 0 )
            {
                fieldError = true;
                inventoryTextArea.append("\nMust enter a product description.");

            } else {
                //Make sure there is a product ID
                if ( productIdText.getText().length() == 0 )
                {
                    fieldError = true;
                    inventoryTextArea.append("\nMust enter a product ID.");
                } else {
                    //Make sure there is a price
                    if ( priceText.getText().length() == 0 )
                    {
                        fieldError = true;
                        inventoryTextArea.append("\nMust enter a product price.");
                    } else {
                        //Make sure quantity is specified
                        if ( quantityText.getText().length() == 0 )
                        {
                            fieldError = true;
                            inventoryTextArea.append("\nMust enter a product quantity.");
                        } // quantity
                    } // price
                } // product ID
            } //product description
        } //category selected

        if (!fieldError)
        {
            try
            {
                // get the data from the text fields
                String description = productDescriptionText.getText();
                String productID = productIdText.getText();
                int quantity = Integer.parseInt(quantityText.getText());
                double perUnitCost = Float.parseFloat(priceText.getText());

                InventoryService.getInstance().AddProduct(new Product(productID, productType, description, perUnitCost, quantity));

                inventoryTextArea.append("\nINVENTORY UPDATED... The following was added to the inventory...\n");
                inventoryTextArea.append("\nProduct Code:: " + productID);
                inventoryTextArea.append("\nProduct Type:: " + productType);
                inventoryTextArea.append("\nDescription::  " + description);
                inventoryTextArea.append("\nQuantity::     " + quantity);
                inventoryTextArea.append("\nUnit Cost::    " + perUnitCost);
            } catch (Exception ex) {
                inventoryTextArea.append("\nProblem adding inventory:: " + ex.getMessage());
            } // try
        }
    }

    private void listInventoryButtonActionPerformed(ActionEvent e) {
        // This button will list the inventory for the product
        boolean fieldError = true;      // Error flag

        //Clear the fields - they are not needed and may cause confusion
        inventoryTextArea.setText("");

        // Check to make sure a radio button is selected
        if ((treesRadioButton.isSelected() || seedsRadioButton.isSelected() ||
                shrubsRadioButton.isSelected() || cultureBoxesRadioButton.isSelected() ||
                genomicsRadioButton.isSelected() || processingRadioButton.isSelected() || referenceMaterialsRadioButton.isSelected()))
        {
            fieldError = false;
        } else {
            inventoryTextArea.setText("\n Please, specify product type");
        }

        if (!fieldError)
        {
            try
            {
                List<Product> products = InventoryService.getInstance().GetProductsByType(productType);

                // Now we list the inventory for the selected table
                inventoryTextArea.setText("");
                for (Product product : products) {
                    String msgString = productType + " >> " + product.getId() + " :: " + product.getDescription() +
                            " :: "+ product.getQuantity() + " :: " + product.getPrice();
                    inventoryTextArea.append("\n" + msgString);
                }

            } catch(Exception ex) {
                inventoryTextArea.append("\nProblem with " + productType +" query:: " + ex);
            } // try
        }
    }

    private void deleteItemButtonActionPerformed(ActionEvent e) {
        // Deletes an item from the database

        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        boolean IndexNotFound;              // Flag indicating a string index was not found.
        String inventorySelection;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found

        // this is the selected line of text
        inventorySelection =  inventoryTextArea.getSelectedText();

        // make sure the selection is not blank
        if ( inventorySelection != null )
        {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>",beginIndex);

            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex+2; //skip past ">>"
            }

            if ( !IndexNotFound )
            {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":",beginIndex);

                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex,endIndex);
                }
            }

            // Now we delete the inventory item indicated by the productID we
            // parsed out above from the indicated table.
            if ( !IndexNotFound )
            {
                inventoryTextArea.setText("");
                inventoryTextArea.append("Deleting ProductID: " + productID);

                InventoryService.getInstance().DeleteProductById(productID.trim());
            } else {
                inventoryTextArea.setText("");
                inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");

            }
        } else {
            inventoryTextArea.setText("");
            inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        } // Blank string check
    }

    private void decrementButtonActionPerformed(ActionEvent e) {
        // Decrements the inventory count for a selected item
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        boolean IndexNotFound;              // Flag indicating a string index was not found.
        String inventorySelection = null;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found

        // this is the selected line of text
        inventorySelection =  inventoryTextArea.getSelectedText();

        // make sure the selection is not blank
        if ( inventorySelection != null )
        {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>",beginIndex);

            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex+2; //skip past ">>"
            }

            if ( !IndexNotFound )
            {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":",beginIndex);

                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex,endIndex);
                }
            }

            // Now we decrement the inventory count of the item indicated by the productID we
            // parsed out above from the indicated table.

            if ( !IndexNotFound )
            {
                inventoryTextArea.setText("");
                inventoryTextArea.append( "Decrementing ProductID: " + productID );

                //If there is no connection error, then we form the SQL statement
                //to decrement the inventory item count and then execute it.
                try
                {
                    InventoryService.getInstance().DecrementProductQuantity(productID.trim());
                    inventoryTextArea.append("\n\n" + productID + " inventory decremented...");

                    List<Product> products = InventoryService.getInstance().GetProductsByType(productType);

                    // Now we list the inventory for the selected table
                    inventoryTextArea.setText("");
                    for (Product product : products) {
                        String msgString = productType + " >> " + product.getId() + " :: " + product.getDescription() +
                                " :: "+ product.getQuantity() + " :: " + product.getPrice();
                        inventoryTextArea.append("\n" + msgString);
                    }
                } catch (Exception ex) {

                    String errString =  "\nProblem with delete:: " + ex;
                    inventoryTextArea.append(errString);

                } // try

            } else {
                inventoryTextArea.setText("");
                inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            }
        } else {
            inventoryTextArea.setText("");
            inventoryTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        } // Blank string check
    }

    private void productIdTextActionPerformed(ActionEvent e) {
        // TODO: not used - delete later!
    }

    private void productDescriptionTextActionPerformed(ActionEvent e) {
        // TODO: not used - delete later!
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

        ButtonGroup productsGroup = new ButtonGroup();
        productsGroup.add(treesRadioButton);
        productsGroup.add(shrubsRadioButton);
        productsGroup.add(seedsRadioButton);
        productsGroup.add(genomicsRadioButton);
        productsGroup.add(cultureBoxesRadioButton);
        productsGroup.add(referenceMaterialsRadioButton);
        productsGroup.add(processingRadioButton);

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
            inventoryTextArea.setEditable(false);
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
                    .add(324, 324, 324)
                    .add(frameTitleLabel)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(13, 13, 13)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(quantityLabel)
                                .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                    .add(productDescriptionLabel)
                                    .add(GroupLayout.LEADING, priceLabel)
                                    .add(GroupLayout.LEADING, productIdLabel)))
                            .add(5, 5, 5)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(productDescriptionText, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(priceText)
                                        .add(quantityText)
                                        .add(productIdText, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                    .add(26, 26, 26)
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(listInventoryButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                            .add(18, 18, 18)
                                            .add(decrementButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.UNRELATED)
                                            .add(decrementText, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(contentPaneLayout.createParallelGroup()
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(treesRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(shrubsRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(seedsRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(cultureBoxesRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(genomicsRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(processingRadioButton)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(referenceMaterialsRadioButton))
                                                .add(contentPaneLayout.createSequentialGroup()
                                                    .add(addItemButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                    .add(18, 18, 18)
                                                    .add(deleteItemButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(deleteText)))
                                            .add(0, 0, Short.MAX_VALUE))))))
                        .add(GroupLayout.TRAILING, jSeparator1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .add(inventoryScrollPane))
                    .add(4, 4, 4))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(frameTitleLabel)
                    .add(10, 10, 10)
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
                        .add(addItemButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .add(deleteItemButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .add(deleteText)
                        .add(priceLabel))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(quantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(listInventoryButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .add(decrementButton)
                        .add(quantityLabel)
                        .add(decrementText))
                    .add(10, 10, 10)
                    .add(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(18, 18, 18)
                    .add(inventoryScrollPane, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                    .add(20, 20, 20))
        );

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    AuthenticationService.getInstance().LogEvent("logout", userName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                System.exit(0);
            }
        });

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
