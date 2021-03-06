/*
 * Created by JFormDesigner on Thu Apr 09 08:37:34 MSK 2020
 */

package presentation;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;

import middleware.AuthenticationService;
import middleware.InventoryService;
import middleware.OrderService;
import model.Order;
import model.Product;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author unknown
 */
public class OrderMainFrame extends JFrame {
    private String userName;
    public OrderMainFrame(String login) {
        userName = login;
        initComponents();
    }

    private void treesButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("tree");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void seedsButtonActionPerformed(ActionEvent e) {
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("seed");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void shrubsButtonActionPerformed(ActionEvent e) {
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("shrub");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void cultureBoxesButtonActionPerformed(ActionEvent e) {
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("culturebox");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void genomicsButtonActionPerformed(ActionEvent e) {
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("genomic");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void processesButtonActionPerformed(ActionEvent e) {
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("processing");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void referenceMaterialsButtonActionPerformed(ActionEvent e) {
        inventoryTextArea.setText("");

        try {
            List<Product> products = InventoryService.getInstance().GetProductsByType("referencematerial");

            // Now we list the inventory for the selected table
            inventoryTextArea.setText("");
            for (Product product : products) {
                String msgString = product.getId() + " : " + product.getDescription() +
                        " : $"+ product.getPrice() + " : " + product.getQuantity()
                        + " units in stock";
                inventoryTextArea.append("\n" + msgString);
            }
        } catch (Exception ex) {
            String errString =  "\nProblem getting inventory:: " + e;
            inventoryTextArea.append(errString);
        }
    }

    private void addToOrderButtonActionPerformed(ActionEvent e) {
        // This button gets the selected line of text from the
        // inventory list window jTextArea1. The line of text is parsed and
        // the relevant information is placed in the order area (jTextArea2).

        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        Float fCost;                        // Item cost
        String productDescription = null;   // Product description
        String productID = null;            // Product ID pnemonic
        String sCost,sTotalCost;            // String order and total cost values
        Boolean IndexNotFound;              // Flag indicating a string index was not found.

        // Initialization

        String inventorySelection = null;
        IndexNotFound = false;
        sCost = null;
        sTotalCost = null;

        // this is the selected line of text
        inventorySelection =  inventoryTextArea.getSelectedText();

        // make sure its not blank
        if ( inventorySelection != null )
        {
            // get the product ID
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(" : ",beginIndex);
            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                productID = inventorySelection.substring(beginIndex,endIndex);
            }

            if ( !IndexNotFound )
            {
                // get the product description
                beginIndex = endIndex + 3; //skip over " : "
                endIndex = inventorySelection.indexOf(" : ",beginIndex);
                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productDescription = inventorySelection.substring(beginIndex,endIndex);
                }
            }

            // get the string cost value
            if ( !IndexNotFound )
            {
                beginIndex = endIndex + 4; //skip over " : $"
                endIndex = inventorySelection.indexOf(" : ",beginIndex);
                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    sCost = inventorySelection.substring(beginIndex,endIndex);
                }
            }

            // write the string to the order area

            if ( !IndexNotFound )
            {
                itemsSelectedTextArea.append( productID + " : " + productDescription + " : $"
                        + sCost + "\n");

                // convert the string cost to a float, add it to what is in the
                // cost field (jTextField6), and update the cost field with the
                // new value

                sTotalCost = costText.getText();
                beginIndex = 0;
                beginIndex = sTotalCost.indexOf("$",beginIndex)+1;
                sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
                fCost = Float.parseFloat(sTotalCost) + Float.parseFloat(sCost);
                costText.setText( "$" + fCost.toString());

            } else {
                messagesTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            }
        } else {
            messagesTextArea.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        } // Blank string check
    }

    private void submitOrderButtonActionPerformed(ActionEvent e) {
        // This is the submit order button. This handler will check to make sure
        // that the customer information is provided, then create an entry in
        // the orderinfo::orders table. It will also create another table where
        // the list of items is stored. This table is also in the orderinfo
        // database as well.

        int beginIndex;                 // String parsing index
        String customerAddress;         // Buyers mailing address
        int endIndex;                   // String paring index
        String firstName = null;        // Customer's first name
        float fCost;                    // Total order cost
        String description;             // Tree, seed, or shrub description
        boolean executeError = false;   // Error flag
        String errString = null;        // String for displaying errors
        String lastName = null;         // Customer's last name
        String sTotalCost = null;       // String representing total order cost
        String sPerUnitCost = null;     // String representation of per unit cost
        String orderItem = null;        // Order line item from jTextArea2
        String phoneNumber = null;      // Customer phone number
        float perUnitCost;              // Cost per tree, seed, or shrub unit
        String productID = null;        // Product id of tree, seed, or shrub

        // Check to make sure there is a first name, last name, address and phone
        if ((firstNameText.getText().length()==0) || (lastNameText.getText().length()==0)
                || (addressTextArea.getText().length()==0)
                || (phoneTextArea.getText().length()==0))
        {
            errString =  "\nMissing customer information!!!\n";
            messagesTextArea.append(errString);
            executeError = true;
        }

        //If there is not a connection error, then we form the SQL statement
        //to submit the order to the orders table and then execute it.

        if (!executeError )
        {
            Calendar rightNow = Calendar.getInstance();

            int TheHour = rightNow.get(Calendar.HOUR_OF_DAY);
            int TheMinute = rightNow.get(Calendar.MINUTE);
            int TheSecond = rightNow.get(Calendar.SECOND);
            int TheDay = rightNow.get(Calendar.DAY_OF_WEEK);
            int TheMonth = rightNow.get(Calendar.MONTH);
            int TheYear = rightNow.get(Calendar.YEAR);

            String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                    + TheHour + ":" + TheMinute  + ":" + TheSecond;

            // Get the order data
            firstName = firstNameText.getText();
            lastName = lastNameText.getText();
            phoneNumber = phoneTextArea.getText();
            customerAddress = addressTextArea.getText();
            sTotalCost = costText.getText();
            beginIndex = 0;
            beginIndex = sTotalCost.indexOf("$",beginIndex)+1;
            sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
            fCost = Float.parseFloat(sTotalCost);

            Order newOrder = new Order(dateTimeStamp, firstName, lastName, customerAddress, phoneNumber, fCost, false);

            String[] items = itemsSelectedTextArea.getText().split("\\n");
            List<Product> products = new ArrayList<Product>();

            for (int i = 0; i < items.length; i++ )
            {
                orderItem = items[i];
                messagesTextArea.append("\nitem #:" + i + ": " + items[i]);

                // Check just to make sure that a blank line was not stuck in
                // there... just in case.

                if (orderItem.length() > 0 )
                {
                    // Parse out the product id
                    beginIndex = 0;
                    endIndex = orderItem.indexOf(" : ",beginIndex);
                    productID = orderItem.substring(beginIndex,endIndex);

                    // Parse out the description text
                    beginIndex = endIndex + 3; //skip over " : "
                    endIndex = orderItem.indexOf(" : ",beginIndex);
                    description = orderItem.substring(beginIndex,endIndex);

                    // Parse out the item cost
                    beginIndex = endIndex + 4; //skip over " : $"
                    //endIndex = orderItem.indexOf(" : ",orderItem.length());
                    //sPerUnitCost = orderItem.substring(beginIndex,endIndex);
                    sPerUnitCost = orderItem.substring(beginIndex,orderItem.length());
                    perUnitCost = Float.parseFloat(sPerUnitCost);

                    products.add(new Product(productID, description, perUnitCost));

                } // line length check
            } //for each line of text in order table

            try {
                OrderService.getInstance().createOrder(newOrder, products);
            } catch (Exception ex) {
                messagesTextArea.append("Error creating order: " + ex.getMessage());
            }

            messagesTextArea.append("\n\nOrder " + dateTimeStamp + " created!");

            itemsSelectedTextArea.setText("");
            firstNameText.setText("");
            lastNameText.setText("");
            addressTextArea.setText("");
            phoneTextArea.setText("");
            inventoryTextArea.setText("");
        }

    }

    private void lastNameTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void phoneTextAreaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void costTextActionPerformed(ActionEvent e) {
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
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 24));

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
            itemsSelectedTextArea.setEditable(false);
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
        costText.setEditable(false);
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
            messagesTextArea.setEditable(false);
            jScrollPane3.setViewportView(messagesTextArea);
        }

        //---- jLabel3 ----
        jLabel3.setText("Customer Information");

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
                    .add(262, 262, 262)
                    .add(jLabel1)
                    .add(0, 0, Short.MAX_VALUE))
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(phoneTextArea, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                        .add(jLabel4)
                        .add(jLabel3)
                        .add(jLabel6)
                        .add(firstNameText, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                        .add(jLabel7)
                        .add(lastNameText, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                        .add(jLabel12)
                        .add(jLabel8)
                        .add(GroupLayout.TRAILING, jScrollPane4, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(addToOrderButton))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(jScrollPane2, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(costText, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .add(costLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .add(submitOrderButton)))
                        .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                            .add(GroupLayout.LEADING, contentPaneLayout.createSequentialGroup()
                                .add(treesButton)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(seedsButton)
                                .addPreferredGap(LayoutStyle.UNRELATED)
                                .add(shrubsButton)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(cultureBoxesButton)
                                .addPreferredGap(LayoutStyle.UNRELATED)
                                .add(genomicsButton)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(processesButton)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(referenceMaterialsButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                            .add(contentPaneLayout.createSequentialGroup()
                                .add(jLabel10)
                                .add(18, 18, 18)
                                .add(jLabel13)))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(6, 6, 6)
                            .add(itemsSelectedLabel))
                        .add(messagesLabel)
                        .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(14, 14, 14)
                    .add(jLabel1)
                    .add(34, 34, 34)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(treesButton)
                        .add(seedsButton)
                        .add(shrubsButton)
                        .add(cultureBoxesButton)
                        .add(genomicsButton)
                        .add(processesButton)
                        .add(jLabel4)
                        .add(referenceMaterialsButton))
                    .add(25, 25, 25)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel10)
                        .add(jLabel13)
                        .add(jLabel3))
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(jScrollPane1)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(0, 0, Short.MAX_VALUE)
                                    .add(addToOrderButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.UNRELATED))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(22, 22, 22)
                            .add(jLabel6)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(firstNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(jLabel7, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(itemsSelectedLabel)
                            .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(costLabel)
                                    .add(9, 9, 9)
                                    .add(costText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .add(18, 18, 18)
                                    .add(submitOrderButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                                .add(jScrollPane2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(12, 12, 12)
                            .add(jLabel12)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(jScrollPane4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(jLabel8)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(phoneTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(messagesLabel)
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE))
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
    private JLabel jLabel12;
    private JScrollPane jScrollPane4;
    private JTextArea addressTextArea;
    private JLabel jLabel13;
    private JScrollPane jScrollPane1;
    private JTextArea inventoryTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
