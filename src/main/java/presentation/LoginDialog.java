/*
 * Created by JFormDesigner on Thu Apr 09 08:37:07 MSK 2020
 */

package presentation;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

import com.sun.scenario.effect.InvertMask;
import middleware.AuthenticationService;
import middleware.InventoryService;
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
        String password = new String(passwordText.getPassword());
        String role = "";

        try {
            role = AuthenticationService.getInstance().GainUserRole(username, password); // get role from firebase
        } catch (Exception ex){
            ex.printStackTrace();
        }

        if (role.equals("order")) {
            new OrderMainFrame().setVisible(true);
        } else if (role.equals("inventory")) {
            new InventoryMainFrame().setVisible(true);
        } else if (role.equals("shipping")) {
            new ShippingMainFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Incorrect login or password. Try again",
                    "Authorization error",
                    JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }

    private void serverNameActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        usernameText = new JTextField();
        passwordText = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();

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
                            .add(26, 26, 26)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(usernameLabel)
                                .add(passwordLabel))
                            .addPreferredGap(LayoutStyle.UNRELATED)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(usernameText, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .add(passwordText, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(67, 67, 67)
                            .add(loginButton)))
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(usernameLabel)
                        .add(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(passwordLabel)
                        .add(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(loginButton)
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
