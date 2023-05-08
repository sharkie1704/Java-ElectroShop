/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author A
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Password extends JPanel implements ActionListener {
    private static final String OK = "ok";
    private static final String HELP = "help";
    private JFrame controllingFrame;
    private JPasswordField passwordField;

    public Password(JFrame f) {
        controllingFrame = f;
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);

        JLabel label = new JLabel("Please enter the password: ");
        label.setLabelFor(passwordField);

        JComponent buttonPane = createButtonPanel();

        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);

        add(textPane);
        add(buttonPane);
    }

    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0, 1));
        JButton okButton = new JButton("OK");
        JButton helpButton = new JButton("Help");

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (OK.equals(cmd)) {
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
                JOptionPane.showMessageDialog(controllingFrame, "Success! You typed the right password 😊 ");
            } else {
                JOptionPane.showMessageDialog(controllingFrame, "Invalid password. Try again.", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
            Arrays.fill(input, '0');
            passwordField.selectAll();
            resetFocus();
        } else {
            JOptionPane.showMessageDialog(controllingFrame, "You can get the password by looking at the source code for the string 'correctPassword'. Or ask the developers for the correct password.");
        }
    }

    private static boolean isPasswordCorrect(char[] input) {
        char[] correctPassword = {'p', 'a', 'n', 'd', 'a'};
        return Arrays.equals(input, correctPassword);
    }

    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Electro Shop Portal Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Password newContentPane = new Password(frame);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            createAndShowGUI();
        });
    }
}
