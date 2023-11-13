package com.MyATM;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TransactionHistory implements ActionListener {
    String userName = LogIn.myUserName;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");
    JFrame frame;
    JButton okbutton;
    TransactionHistory() {
        //create a object of Conn class
        Conn conn = new Conn();

        //check whether your details are exists or not
        String myNewQuery = "select * from transaction where username='" + userName + "';";
        try{
            ResultSet rs3 = conn.s.executeQuery(myNewQuery);
            if (rs3.next()) {
                String pinNumber;
                final JPasswordField passwordField = new JPasswordField();

                //get pin number from user
                pinNumber = JOptionPane.showConfirmDialog(null, passwordField, "Enter Your PIN number securely", Integer.parseInt(String.valueOf(JOptionPane.OK_CANCEL_OPTION)), JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(passwordField.getPassword()) : "";
                if (pinNumber.length() > 0) {
                    //check whether your details are exists or not
                    String myquery = "select * from transaction where username='" + userName + "'and pin=" + pinNumber + ";";
                    try {
                        ResultSet rs1 = conn.s.executeQuery(myquery);
                        if (rs1.next()) {

                            //check details
                            String query = "select status,amount,time,totalbalance from transaction where username='" + userName + "' and pin=" + pinNumber + ";";
                            try {
                                ResultSet rs2 = conn.s.executeQuery(query);
                                //if details is present then update
                                frame = new JFrame("ANUBHAV CENTRAL BANK / Transaction History");
                                frame.setSize(700, 500);
                                frame.setLocationRelativeTo(null);
                                frame.setResizable(false);
                                frame.setIconImage(imageIcon.getImage());
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setVisible(true);
                                frame.setLayout(new FlowLayout(FlowLayout.CENTER));

                                Container c = frame.getContentPane();
                                c.setLayout(null);
                                c.setBackground(Color.ORANGE);

                                Border border = BorderFactory.createLineBorder(Color.white, 10);

                                JTextArea textArea = new JTextArea();
                                textArea.setFont(new Font("arial", Font.PLAIN, 16));
                                textArea.setBounds(20, 55, 645, 355);
                                textArea.setText("          Status          |          Amount          |          Time          |          TotalBalance          ");
                                textArea.setForeground(Color.BLACK);
                                textArea.setBackground(Color.lightGray);
                                textArea.setBorder(border);
                                textArea.setEditable(false);
                                c.add(textArea);

                                JLabel l = new JLabel("\"Your personal details are very much important & sensitive so please don't");
                                l.setFont(new Font("arial", Font.ITALIC, 17));
                                l.setHorizontalTextPosition(JLabel.CENTER);
                                l.setHorizontalAlignment(JLabel.CENTER);
                                l.setBounds(30, -5, 620, 50);
                                l.setForeground(Color.black);
                                c.add(l);

                                JLabel l1 = new JLabel("share your personal information to anyone\"");
                                l1.setFont(new Font("arial", Font.ITALIC, 17));
                                l1.setHorizontalTextPosition(JLabel.CENTER);
                                l1.setHorizontalAlignment(JLabel.CENTER);
                                l1.setBounds(30, 15, 620, 50);
                                l1.setForeground(Color.black);
                                c.add(l1);

                                okbutton = new JButton();
                                okbutton.setText("BACK");
                                okbutton.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
                                okbutton.setHorizontalTextPosition(JButton.CENTER);
                                okbutton.setHorizontalAlignment(JButton.CENTER);
                                okbutton.setBounds(275, 420, 150, 35);
                                okbutton.setFocusable(false);
                                c.add(okbutton);
                                okbutton.addActionListener(this);

                                while (rs2.next()) {
                                    String transactionDetails = "\n" + rs2.getString(1) + " | " + rs2.getDouble(2) + " | " + rs2.getString(3) + " | " + rs2.getDouble(4);

                                    Home.frame.setVisible(false);
                                    textArea.append(transactionDetails);
                                }
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Account doesn't exists", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "sorry pin cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton){
            frame.setVisible(false);
            new Home();
        }
    }
}