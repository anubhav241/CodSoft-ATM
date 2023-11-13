package com.MyATM;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AccountDetails implements ActionListener {
    String userName = LogIn.myUserName;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");
    JFrame frame;
    JButton okbutton;
    AccountDetails() {
        //create a object of Conn class
        Conn conn = new Conn();
        //check whether your details are exists or not
        String myquery = "select * from accdetails where username='" + userName + "';";
        try {
            ResultSet rs1 = conn.s.executeQuery(myquery);
            if (rs1.next()) {
                String pinNumber;
                final JPasswordField passwordField = new JPasswordField();

                //get pin number from user
                pinNumber = JOptionPane.showConfirmDialog(null, passwordField, "Enter Your PIN number securely", Integer.parseInt(String.valueOf(JOptionPane.OK_CANCEL_OPTION)), JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(passwordField.getPassword()) : "";

                if (pinNumber.length() > 0) {
                    //check balance
                    String query = "select name,mobno,state,district,city,pincode,occupation,gender,status,nationality,uid,uidnumber,dob,accnumber from accdetails where username='" + userName + "' and pin=" + pinNumber + ";";
                    try {
                        ResultSet rs2 = conn.s.executeQuery(query);
                        //if details is present then update
                        if (rs2.next()) {
                            String myDetails = "Name: "+rs2.getString(1) +"\nMob No.: "+ rs2.getLong(2) + "\nState: "+rs2.getString(3) +"\nDistrict: "+ rs2.getString(4) +"\nCity: "+ rs2.getString(5) +"\nPin Code: "+ rs2.getInt(6) +"\nOccupation: "+ rs2.getString(7) +"\nGender: "+ rs2.getString(8) +"\nStatus: "+ rs2.getString(9) +"\nNationality: "+ rs2.getString(10) +"\nUID: "+ rs2.getString(11) +"\nUID Number: "+ rs2.getLong(12) +"\nDOB: "+ rs2.getString(13) +"\nAccount Number: "+ rs2.getLong(14);
                            Home.frame.setVisible(false);

                            frame = new JFrame("ANUBHAV CENTRAL BANK / Details");
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

                            textArea.append(myDetails);

                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong pin number", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "sorry pin cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
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
