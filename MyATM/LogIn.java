package com.MyATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LogIn extends JFrame implements ActionListener {
    public static String myUserName;
    public static String myPassword;

    JButton button1, button2, button3;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField textField1;
    JPasswordField passwordField;
    JPanel panel;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");

    LogIn() {
        setTitle("ANUBHAV CENTRAL BANK");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setIconImage(imageIcon.getImage());
        setResizable(false);
        setBackground(Color.orange);

        panel = new JPanel();
        panel.setBounds(22, 105, 640, 315);
        panel.setBackground(Color.YELLOW);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));

        Container c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);
        c.add(panel);

        label1 = new JLabel("ANUBHAV CENTRAL BANK");
        label1.setFont(new Font("Bauhaus 93", Font.BOLD, 42));
        label1.setForeground(Color.black);
        label1.setBounds(105, 20, 600, 50);
        c.add(label1);

        label2 = new JLabel("\"No.1 Centralize Bank of India, Always 24/7 Available in Your Service\"");
        label2.setFont(new Font("arial", Font.ITALIC, 20));
        label2.setForeground(Color.black);
        label2.setBounds(30, 55, 650, 50);
        c.add(label2);

        label3 = new JLabel("Hope you like the Experience. \nYour Feedback is very much important for us.");
        label3.setFont(new Font("arial", Font.PLAIN, 12));
        label3.setForeground(Color.black);
        label3.setBounds(145, 420, 500, 40);
        c.add(label3);

        label4 = new JLabel("Username: ");
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        label4.setForeground(Color.black);
        label4.setBounds(115, 63, 500, 50);
        panel.add(label4);

        textField1 = new JFormattedTextField();
        textField1.setFont(new Font("arial", Font.PLAIN, 16));
        textField1.setBounds(230, 73, 300, 30);
        textField1.setForeground(Color.BLACK);
        panel.add(textField1);

        label5 = new JLabel("Password: ");
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        label5.setForeground(Color.black);
        label5.setBounds(115, 119, 500, 50);
        panel.add(label5);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("arial", Font.PLAIN, 16));
        passwordField.setBounds(230, 129, 300, 30);
        passwordField.setForeground(Color.BLACK);
        panel.add(passwordField);

        button1 = new JButton("LOG IN");
        button1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button1.setBounds(160, 190, 150, 40);
        button1.setFocusable(false);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.setForeground(Color.BLACK);
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("SIGN UP");
        button2.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button2.setBounds(330, 190, 150, 40);
        button2.setFocusable(false);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setForeground(Color.BLACK);
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("EXIT");
        button3.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button3.setBounds(220, 250, 200, 40);
        button3.setFocusable(false);
        button3.setBorder(BorderFactory.createEtchedBorder());
        button3.setForeground(Color.BLACK);
        button3.addActionListener(this);
        panel.add(button3);

        label6 = new JLabel();
        label6.setText("PERFECTION Is BETTER Then CURE");
        label6.setBounds(140, 20, 700, 30);
        label6.setForeground(Color.RED);
        label6.setFont(new Font("Segoe Script", Font.ITALIC, 18));
        panel.add(label6);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent actionEvent){
        if (actionEvent.getSource()==button1){
            logIn();
        } else if(actionEvent.getSource()==button2){
            signUp();
        } else if(actionEvent.getSource()==button3){
            System.exit(0);
        }
    }

    public void logIn(){
        if(textField1.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()){
         JOptionPane.showMessageDialog(this,"Please enter valid user name & password","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String userName = textField1.getText();
                String password = String.valueOf(passwordField.getPassword());

                //create a object of Conn class and write the query
                Conn conn = new Conn();
                String query = "select * from signup where username='" + userName + "' and password='" + password + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    new Home();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Account doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }

                myUserName = userName;
                myPassword = password;
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, "Account doesn't exist. Create a new account first", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public void signUp(){
        new SignUp();
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn();
            }
        });

    }
}
