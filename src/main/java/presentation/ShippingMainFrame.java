/*
 * Created by JFormDesigner on Thu Apr 09 08:39:25 MSK 2020
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
public class ShippingMainFrame extends JFrame {
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
        // TODO add your code here
    }

    private void showPendingOrdersButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void selectOrderButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void showShippedOrdersButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
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
        jScrollPane2 = new JScrollPane();
        mailingAddressTextArea = new JTextArea();
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
        jScrollPane5 = new JScrollPane();
        orderTextArea1 = new JTextArea();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- shippingApplicationLabel ----
        shippingApplicationLabel.setText("Shipping Application");

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

        //======== jScrollPane2 ========
        {

            //---- mailingAddressTextArea ----
            mailingAddressTextArea.setEditable(false);
            mailingAddressTextArea.setColumns(20);
            mailingAddressTextArea.setRows(5);
            jScrollPane2.setViewportView(mailingAddressTextArea);
        }

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
        orderLabel.setText("Order Number : Order Date & Time: Customer Name");

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

        //======== jScrollPane5 ========
        {

            //---- orderTextArea1 ----
            orderTextArea1.setEditable(false);
            orderTextArea1.setColumns(20);
            orderTextArea1.setRows(5);
            jScrollPane5.setViewportView(orderTextArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(45, 45, 45)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                .add(GroupLayout.LEADING, jScrollPane4)
                                .add(GroupLayout.LEADING, jScrollPane2)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(0, 0, Short.MAX_VALUE)
                                    .add(shippingApplicationLabel)
                                    .add(228, 228, 228))
                                .add(GroupLayout.LEADING, contentPaneLayout.createSequentialGroup()
                                    .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 715, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(markAsShippedButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
                                .add(GroupLayout.LEADING, contentPaneLayout.createSequentialGroup()
                                    .add(jScrollPane1, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                                    .add(444, 444, 444)
                                    .add(jScrollPane5, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.RELATED)
                                    .add(selectOrderButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(firstNameText, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                        .add(firstNameLabel))
                                    .add(18, 18, 18)
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(lastNameLabel)
                                        .add(lastNameText, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(phoneLabel)
                                        .add(phoneText, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .add(10, 10, 10)
                                    .add(contentPaneLayout.createParallelGroup()
                                        .add(orderDateLabel)
                                        .add(orderDateText)))
                                .add(GroupLayout.LEADING, contentPaneLayout.createSequentialGroup()
                                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                                        .add(GroupLayout.LEADING, mailingAddressLabel)
                                        .add(GroupLayout.LEADING, contentPaneLayout.createParallelGroup(GroupLayout.TRAILING, false)
                                            .add(GroupLayout.LEADING, showShippedOrdersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(GroupLayout.LEADING, showPendingOrdersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .add(0, 0, Short.MAX_VALUE)))
                            .add(45, 45, 45))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(messagesLabel)
                                .add(orderItemsLabel)
                                .add(jLabel4)
                                .add(orderLabel))
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(shippingApplicationLabel)
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(showPendingOrdersButton)
                    .add(8, 8, 8)
                    .add(showShippedOrdersButton)
                    .add(18, 18, 18)
                    .add(orderLabel)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(selectOrderButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .add(18, 18, 18)
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
                        .add(orderDateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(mailingAddressLabel)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jScrollPane2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(orderItemsLabel)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(14, 14, 14)
                            .add(messagesLabel))
                        .add(markAsShippedButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(jScrollPane4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .add(32, 32, 32))
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
    private JScrollPane jScrollPane2;
    private JTextArea mailingAddressTextArea;
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
    private JScrollPane jScrollPane5;
    private JTextArea orderTextArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
