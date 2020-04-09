/*
 * Created by JFormDesigner on Thu Apr 09 08:37:07 MSK 2020
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
public class LoginDialog extends JDialog {

    public LoginDialog() {
        initComponents();
    }

    public static void main(String[] args) {

       // new LoginDialog().setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDialog().setVisible(true);
            }
        });
    }

    private void usernameTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String username = usernameText.getText();
        String role = username; // get role from firebase
        if (role.equals("order")) {
            new OrderMainFrame().setVisible(true);
        }
        if (role.equals("inventory")) {
            new InventoryMainFrame().setVisible(true);
        }
        if (role.equals("shipping")) {
            new ShippingMainFrame().setVisible(true);
        }
    }

    private void serverNameActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        frameTitle = new JLabel();
        usernameText = new JTextField();
        passwordText = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- frameTitle ----
        frameTitle.setText("EEP Log In");

        //---- usernameText ----
        usernameText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameTextActionPerformed(e);
            }
        });

        //---- usernameLabel ----
        usernameLabel.setText("Username:");

        //---- passwordLabel ----
        passwordLabel.setText("Password:");

        //---- loginButton ----
        loginButton.setText("Log In");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(67, 67, 67)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(usernameLabel)
                                .add(passwordLabel))
                            .add(21, 21, 21)
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                                .add(passwordText, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .add(usernameText, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(109, 109, 109)
                            .add(loginButton))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(112, 112, 112)
                            .add(frameTitle)))
                    .addContainerGap(74, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(frameTitle)
                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(usernameLabel)
                        .add(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(passwordLabel))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(loginButton)
                    .add(130, 130, 130))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel frameTitle;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
