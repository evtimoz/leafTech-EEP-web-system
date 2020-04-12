/*
 * Created by JFormDesigner on Thu Apr 09 08:39:25 MSK 2020
 */

package presentation;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

import middleware.OrderService;
import model.Order;
import model.Product;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author unknown
 */
public class ShippingMainFrame extends JFrame {

    String orderToUpdateId;

    public ShippingMainFrame() {
        initComponents();
    }

    private void firstNameTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void lastNameTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void phoneTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void markAsShippedButtonActionPerformed(ActionEvent e) {
        // This method is responsible changing the status of the order
        // to shipped.

        String errString = null;            // String for displaying errors

        try {
            Boolean status = OrderService.getInstance().markOrderAsShipped(orderToUpdateId);

            if (status) {
                messagesTextArea.setText("\nOrder #" + orderToUpdateId + " status has been changed to shipped.");

            } else {
                messagesTextArea.setText("\nOrder #" + orderToUpdateId + " record not found.");
            }

            // Clean up the form
            firstNameText.setText("");
            lastNameText.setText("");
            mailingAddressText.setText("");
            phoneText.setText("");
            orderDateText.setText("");
            orderTextArea.setText("");
            orderItemsTextArea.setText("");

        } catch (Exception ex) {

            errString = "\nProblem updating status:: " + ex.getMessage();
            messagesTextArea.append(errString);
        }

    }

    private void showPendingOrdersButtonActionPerformed(ActionEvent e) {
        // This method is responsible for querying the orders database and
        // getting the list of pending orders. This are orders that have not
        // been shipped as of yet. The list of pending orders is written in textarea

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        Boolean shippedStatus;                  // if 0, order not shipped, if 1 order shipped

        // Clean up the form before we start

        firstNameText.setText("");
        lastNameText.setText("");
        mailingAddressText.setText("");
        phoneText.setText("");
        messagesTextArea.setText("");
        orderDateText.setText("");
        orderTextArea.setText("");
        orderItemsTextArea.setText("");

        try {
            // Create a query to get all the orders and execute the query
            List<Order> orders = OrderService.getInstance().getOrders();

            //Display the data in the textarea
            orderTextArea.setText("");

            // For each row returned, we check the shipped status. If it is
            // equal to 0 it means it has not been shipped as of yet, so we
            // display it in textArea, which we interpret
            // here on the application side as an integer.

            for (Order order : orders) {
                shippedStatus = order.getShipped();

                if (!shippedStatus) {
                    msgString = "ORDER # " + order.getId() + " : " + order.getDate() +
                            " : " + order.getFirstname() + " : " + order.getTotal();
                    orderTextArea.append(msgString + "\n");
                }
            }

            // notify the user all went well and enable the select order button
            selectOrderButton.setEnabled(true);
            msgString = "\nPENDING ORDERS RETRIEVED...";
            messagesTextArea.setText(msgString);

        } catch (Exception ex) {
            errString = "\nProblem getting tree inventory:: " + ex.getMessage();
            messagesTextArea.append(errString);
        }

    }

    private void selectOrderButtonActionPerformed(ActionEvent e) {
        // This button gets the selected line of text from the
        // order list window. The line of text is parsed for the
        // order number. Once the order number is parsed, then the order is
        // retrieved from the orders database.

        String errString = null;            // String for displaying errors
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String msgString = null;            // String for displaying non-error messages
        String orderSelection = null;       // Order selected from TextArea1
        String orderID = null;              // Product ID pnemonic
        Boolean orderBlank = false;         // False: order string is not blank

        try {
            // this is the selected line of text
            orderSelection = orderTextArea.getSelectedText();

            // make sure its not blank
            if (orderSelection.length() > 0) {
                // get the product ID
                beginIndex = 0;
                beginIndex = orderSelection.indexOf(" # ", beginIndex);
                beginIndex = beginIndex + 3; //skip past _#_
                endIndex = orderSelection.indexOf(" :", beginIndex);
                orderID = orderSelection.substring(beginIndex, endIndex);

            } else {

                msgString = ">> Order string is blank...";
                messagesTextArea.setText("\n" + msgString);
                orderBlank = true;

            } // Blank string check

            // If an order was selected, then connect to the orderinfo database. In
            // all normal situations this would be impossible to do since the select
            // button is disabled until an order is selected... just in case the
            // check is here.

            if (!orderBlank) {

                Order order = OrderService.getInstance().getOrderById(orderID);

                // Get the information from the database. Display the
                // first and last name, address, phone number, address, and
                // order date. Same the ordertable name - this is the name of
                // the table that is created when an order is submitted that
                // contains the list of order items.

                //orderTable = ;         // name of table with list of items
                firstNameText.setText(order.getFirstname()); // first name
                lastNameText.setText(order.getLastname()); // last name
                phoneText.setText(order.getPhone()); // phone
                orderDateText.setText(order.getDate()); // order date
                mailingAddressText.setText(order.getAddress());  // address


                // get the order items from the related order table
                // list the items on the form that comprise the order
                orderItemsTextArea.setText("");

                List<Product> orderItems = OrderService.getInstance().getProductsFromOrder(orderID);

                for (Product product : orderItems) {
                    msgString = product.getType() + ":  PRODUCT ID: " + product.getId() +
                            "  DESCRIPTION: " + product.getDescription() + "  PRICE $" + product.getPrice();
                    orderItemsTextArea.append(msgString + "\n");

                } // while

                // This global variable is used to update the record as shipped
                orderToUpdateId = orderID;

                // Update the form
                markAsShippedButton.setEnabled(true);
                msgString = "RECORD RETRIEVED...";
                messagesTextArea.setText(msgString);
            }

        } catch (Exception ex) {

            errString = "\nProblem getting order items:: " + ex.getMessage();
            messagesTextArea.append(errString);

        } // end try-catch

    } // connect and blank order check

    private void showShippedOrdersButtonActionPerformed(ActionEvent e) {
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        Boolean shippedStatus;                  // if 0, order not shipped, if 1 order shipped

        // Clean up the form before we start

        firstNameText.setText("");
        lastNameText.setText("");
        mailingAddressText.setText("");
        phoneText.setText("");
        messagesTextArea.setText("");
        orderDateText.setText("");
        orderTextArea.setText("");
        orderItemsTextArea.setText("");

        // Connect to the order database

        // If we are connected, then we get the list of trees from the
        // inventory database

        try {
            // Create a query to get all the orders and execute the query
            List<Order> orders = OrderService.getInstance().getOrders();

            //Display the data in the textarea
            orderTextArea.setText("");

             for (Order order : orders) {
                shippedStatus = order.getShipped();

                if (shippedStatus) {
                    msgString = "ORDER # " + order.getId() + " : " + order.getDate() +
                            " : " + order.getFirstname() + " : " + order.getTotal();
                    orderTextArea.append(msgString + "\n");

                } // shipped status check

            } // while

            // notify the user all went well and enable the select order
            // button
            selectOrderButton.setEnabled(true);
            msgString = "\nSHIPPED ORDERS RETRIEVED...";
            messagesTextArea.setText(msgString);

        } catch (Exception ex) {
            errString = "\nProblem getting tree inventory:: " + ex.getMessage();
            messagesTextArea.append(errString);

        } // end try-catch
    }

    private void orderDateTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        shippingApplicationLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        orderTextArea = new JTextArea();
        firstNameText = new JTextField();
        jLabel4 = new JLabel();
        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        lastNameText = new JTextField();
        phoneLabel = new JLabel();
        phoneText = new JTextField();
        mailingAddressLabel = new JLabel();
        markAsShippedButton = new JButton();
        showPendingOrdersButton = new JButton();
        selectOrderButton = new JButton();
        orderLabel = new JLabel();
        jScrollPane3 = new JScrollPane();
        orderItemsTextArea = new JTextArea();
        orderItemsLabel = new JLabel();
        messagesLabel = new JLabel();
        showShippedOrdersButton = new JButton();
        jScrollPane4 = new JScrollPane();
        messagesTextArea = new JTextArea();
        orderDateLabel = new JLabel();
        orderDateText = new JTextField();
        mailingAddressText = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- shippingApplicationLabel ----
        shippingApplicationLabel.setText("Shipping Application");
        shippingApplicationLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

        //======== jScrollPane1 ========
        {

            //---- orderTextArea ----
            orderTextArea.setEditable(false);
            orderTextArea.setColumns(20);
            orderTextArea.setRows(5);
            jScrollPane1.setViewportView(orderTextArea);
        }

        //---- firstNameText ----
        firstNameText.setEditable(false);
        firstNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNameTextActionPerformed(e);
            }
        });

        //---- jLabel4 ----
        jLabel4.setText("Order Information:");

        //---- firstNameLabel ----
        firstNameLabel.setText("Customer First Name:");

        //---- lastNameLabel ----
        lastNameLabel.setText("Last Name:");

        //---- lastNameText ----
        lastNameText.setEditable(false);
        lastNameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lastNameTextActionPerformed(e);
            }
        });

        //---- phoneLabel ----
        phoneLabel.setText("Phone Number:");

        //---- phoneText ----
        phoneText.setEditable(false);
        phoneText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                phoneTextActionPerformed(e);
            }
        });

        //---- mailingAddressLabel ----
        mailingAddressLabel.setText("Mailing Address");

        //---- markAsShippedButton ----
        markAsShippedButton.setText("Mark As Shipped");
        markAsShippedButton.setEnabled(false);
        markAsShippedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markAsShippedButtonActionPerformed(e);
            }
        });

        //---- showPendingOrdersButton ----
        showPendingOrdersButton.setText("Show  Pending Orders");
        showPendingOrdersButton.setDefaultCapable(false);
        showPendingOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPendingOrdersButtonActionPerformed(e);
            }
        });

        //---- selectOrderButton ----
        selectOrderButton.setText("Select Order");
        selectOrderButton.setEnabled(false);
        selectOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectOrderButtonActionPerformed(e);
            }
        });

        //---- orderLabel ----
        orderLabel.setText("Order Number : Order Date & Time: Customer Name                (highlight the line with oder or triple click it and choose SELECT ORDER) ");

        //======== jScrollPane3 ========
        {

            //---- orderItemsTextArea ----
            orderItemsTextArea.setEditable(false);
            orderItemsTextArea.setColumns(20);
            orderItemsTextArea.setRows(5);
            jScrollPane3.setViewportView(orderItemsTextArea);
        }

        //---- orderItemsLabel ----
        orderItemsLabel.setText("Order Items ");

        //---- messagesLabel ----
        messagesLabel.setText("Messages");

        //---- showShippedOrdersButton ----
        showShippedOrdersButton.setText("Show Shipped Orders");
        showShippedOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showShippedOrdersButtonActionPerformed(e);
            }
        });

        //======== jScrollPane4 ========
        {

            //---- messagesTextArea ----
            messagesTextArea.setEditable(false);
            messagesTextArea.setColumns(20);
            messagesTextArea.setRows(5);
            jScrollPane4.setViewportView(messagesTextArea);
        }

        //---- orderDateLabel ----
        orderDateLabel.setText("Order Date:");

        //---- orderDateText ----
        orderDateText.setEditable(false);
        orderDateText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderDateTextActionPerformed(e);
            }
        });

        //---- mailingAddressText ----
        mailingAddressText.setEditable(false);
        mailingAddressText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderDateTextActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(36, 36, 36)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(messagesLabel)
                                .add(jScrollPane4, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
                                    .add(18, 18, 18)
                                    .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(markAsShippedButton, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                        .add(mailingAddressText, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                                .add(jLabel4)
                                .add(orderLabel)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                                        .add(jScrollPane1)
                                        .add(contentPaneLayout.createParallelGroup()
                                            .add(contentPaneLayout.createSequentialGroup()
                                                .add(contentPaneLayout.createParallelGroup()
                                                    .add(firstNameText, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                                    .add(firstNameLabel))
                                                .addPreferredGap(LayoutStyle.RELATED)
                                                .add(contentPaneLayout.createParallelGroup()
                                                    .add(lastNameLabel)
                                                    .add(lastNameText, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                                                .add(contentPaneLayout.createParallelGroup()
                                                    .add(contentPaneLayout.createSequentialGroup()
                                                        .add(12, 12, 12)
                                                        .add(phoneLabel)
                                                        .add(76, 76, 76))
                                                    .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.RELATED)
                                                        .add(phoneText, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))
                                            .add(contentPaneLayout.createSequentialGroup()
                                                .add(9, 9, 9)
                                                .add(orderItemsLabel))))
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(15, 15, 15)
                                            .add(contentPaneLayout.createParallelGroup()
                                                .add(mailingAddressLabel)
                                                .add(orderDateLabel)
                                                .add(orderDateText, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
                                        .add(contentPaneLayout.createSequentialGroup()
                                            .add(18, 18, 18)
                                            .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                                                .add(GroupLayout.LEADING, showShippedOrdersButton, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                .add(GroupLayout.LEADING, selectOrderButton, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                .add(showPendingOrdersButton, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))))))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(282, 282, 282)
                            .add(shippingApplicationLabel)))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(19, 19, 19)
                    .add(shippingApplicationLabel)
                    .add(35, 35, 35)
                    .add(orderLabel)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(showPendingOrdersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(showShippedOrdersButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(selectOrderButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                        .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel4)
                    .add(10, 10, 10)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(firstNameLabel)
                        .add(lastNameLabel)
                        .add(phoneLabel)
                        .add(orderDateLabel))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(firstNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(orderDateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(orderItemsLabel)
                            .add(20, 20, 20)
                            .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(mailingAddressLabel)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(mailingAddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(markAsShippedButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(messagesLabel)
                    .add(19, 19, 19)
                    .add(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel shippingApplicationLabel;
    private JScrollPane jScrollPane1;
    private JTextArea orderTextArea;
    private JTextField firstNameText;
    private JLabel jLabel4;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField lastNameText;
    private JLabel phoneLabel;
    private JTextField phoneText;
    private JLabel mailingAddressLabel;
    private JButton markAsShippedButton;
    private JButton showPendingOrdersButton;
    private JButton selectOrderButton;
    private JLabel orderLabel;
    private JScrollPane jScrollPane3;
    private JTextArea orderItemsTextArea;
    private JLabel orderItemsLabel;
    private JLabel messagesLabel;
    private JButton showShippedOrdersButton;
    private JScrollPane jScrollPane4;
    private JTextArea messagesTextArea;
    private JLabel orderDateLabel;
    private JTextField orderDateText;
    private JTextField mailingAddressText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
