package com.MyATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;

public class SignUp implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JTextField textField1, textField2, textField3;
    JButton button1, button2, button3;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");
    SignUp() {
        frame = new JFrame("Anubhav Central Bank");
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(false);
        frame.setIconImage(imageIcon.getImage());

        panel = new JPanel();
        panel.setBounds(22, 105, 640, 315);
        panel.setBackground(Color.YELLOW);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));

        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);
        c.add(panel);

        label1 = new JLabel("Welcome to ACB");
        label1.setFont(new Font("Bauhaus 93", Font.BOLD, 42));
        label1.setForeground(Color.black);
        label1.setBounds(182, 15, 400, 50);
        c.add(label1);

        label2 = new JLabel("\"No.1 Centralize Bank of India, Always 24/7 Available in Your Service\"");
        label2.setFont(new Font("arial", Font.ITALIC, 20));
        label2.setForeground(Color.black);
        label2.setBounds(30, 50, 650, 50);
        c.add(label2);

        label3 = new JLabel("Hope you like the Experience. \nYour Feedback is very much important for us.");
        label3.setFont(new Font("arial", Font.PLAIN, 12));
        label3.setForeground(Color.black);
        label3.setBounds(145, 425, 500, 40);
        c.add(label3);

        label4 = new JLabel("For signing up fill up the following details.");
        label4.setFont(new Font("arial", Font.ITALIC, 20));
        label4.setForeground(Color.black);
        label4.setBounds(160, 10, 650, 30);
        panel.add(label4);

        label5 = new JLabel("Name: ");
        label5.setFont(new Font("Baskerville Old Face", Font.BOLD, 24));
        label5.setForeground(Color.black);
        label5.setBounds(120, 55, 150, 30);
        panel.add(label5);

        label6 = new JLabel("Mob No: ");
        label6.setFont(new Font("Baskerville Old Face", Font.BOLD, 24));
        label6.setForeground(Color.black);
        label6.setBounds(120, 105, 150, 30);
        panel.add(label6);

        label7 = new JLabel("Email: ");
        label7.setFont(new Font("Baskerville Old Face", Font.BOLD, 24));
        label7.setForeground(Color.black);
        label7.setBounds(120, 155, 150, 30);
        panel.add(label7);

        textField1 = new JFormattedTextField();
        textField1.setFont(new Font("arial", Font.PLAIN, 16));
        textField1.setBounds(220, 55, 300, 30);
        textField1.setForeground(Color.BLACK);
        panel.add(textField1);

        textField2 = new JFormattedTextField();
        textField2.setFont(new Font("arial", Font.PLAIN, 16));
        textField2.setBounds(220, 105, 300, 30);
        textField2.setForeground(Color.BLACK);
        panel.add(textField2);

        textField3 = new JFormattedTextField();
        textField3.setFont(new Font("arial", Font.PLAIN, 16));
        textField3.setBounds(220, 155, 300, 30);
        textField3.setForeground(Color.BLACK);
        panel.add(textField3);

        button1 = new JButton("BACK");
        button1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button1.setBounds(165, 205, 150, 40);
        button1.setFocusable(false);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.setForeground(Color.BLACK);
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("SIGN UP");
        button2.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button2.setBounds(335, 205, 150, 40);
        button2.setFocusable(false);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setForeground(Color.BLACK);
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("CLEAR");
        button3.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button3.setBounds(230, 260, 200, 40);
        button3.setFocusable(false);
        button3.setBorder(BorderFactory.createEtchedBorder());
        button3.setForeground(Color.BLACK);
        button3.addActionListener(this);
        panel.add(button3);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button1) {
            frame.setVisible(false);
            new LogIn();
        } else if (actionEvent.getSource() == button2) {
            signUp();
        } else if (actionEvent.getSource() == button3) {
            textField3.setText("");
            textField2.setText("");
            textField1.setText("");
        }
    }

    public void signUp() {
        if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill up all details", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
            String name = textField1.getText();
            String mobNo = textField2.getText();
            String eMail = textField3.getText();

                //create a object of Conn class
                Conn conn = new Conn();
                //check whether the tables are exists or not
                String myquery1 = "select * from information_schema.tables where table_schema='atmsystem' and table_name='signup';";
                ResultSet rs1 = conn.s.executeQuery(myquery1);
                if (rs1.next()) {
                    //insert data into database through passing query
                    String userName = JOptionPane.showInputDialog(frame, "Choose a unique username which contains both character and number :");
                    String password = JOptionPane.showInputDialog(frame, "Set Password:");
                    if (userName.length() > 0 && password.length() > 0) {
                        if (userName.equals(mobNo) || userName.equals(name)) {
                            JOptionPane.showMessageDialog(frame, "User name can,t be same as mobile number or name, please set any other unique username", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (password.equals(mobNo) || password.equals(name)) {
                            JOptionPane.showMessageDialog(frame, "Password can,t be same as mobile number or name, please set a strong password ", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (userName.equals(password)) {
                            JOptionPane.showMessageDialog(frame, "Username & Password cannot be same, Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String query = "insert into signup values('" + userName + "','" + password + "','" + name + "'," + mobNo + ",'" + eMail + "');";
                            try {
                                //insert in to database....
                                int rs = conn.s.executeUpdate(query);
                                JOptionPane.showMessageDialog(frame, "Account created successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                System.out.println(rs + " row/s affected");

                                new Home();
                                frame.setVisible(false);

                            } catch (SQLSyntaxErrorException e) {
                                JOptionPane.showMessageDialog(frame, "Please Enter Valid input", "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(frame, "This user name is previously used, Please choose a unique user name", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "sorry username and password cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    LogIn.myUserName = userName;
                    LogIn.myPassword = password;
                }else {
                    //creating signup table
                    String first_query = "create table signup(username varchar(200) primary key, password varchar(100), name varchar(200), mono decimal(10,0), email varchar(200));";
                    int execute1 = conn.s.executeUpdate(first_query);
                    System.out.println(execute1 + " row/s affected");       //msg for ok query

                    //insert data into database through passing query
                    String userName = JOptionPane.showInputDialog(frame, "Choose a unique username which contains both character and number :");
                    String password = JOptionPane.showInputDialog(frame, "Set Password:");
                    
                    if (userName.length() > 0 && password.length() > 0) {
                        if (userName.equals(mobNo) || userName.equals(name)) {
                            JOptionPane.showMessageDialog(frame, "User name can,t be same as mobile number or name, please set any other unique username", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (password.equals(mobNo) || password.equals(name)) {
                            JOptionPane.showMessageDialog(frame, "Password can,t be same as mobile number or name, please set a strong password ", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (userName.equals(password)) {
                            JOptionPane.showMessageDialog(frame, "Username & Password cannot be same, Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String query = "insert into signup values('" + userName + "','" + password + "','" + name + "'," + mobNo + ",'" + eMail + "');";
                            try {
                                //insert in to database....
                                int rs = conn.s.executeUpdate(query);
                                JOptionPane.showMessageDialog(frame, "Account created successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                                System.out.println(rs + " row/s affected");

                                new Home();
                                frame.setVisible(false);

                            } catch (SQLSyntaxErrorException e) {
                                JOptionPane.showMessageDialog(frame, "Please Enter Valid input", "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(frame, "This user name is previously used, Please choose a unique user name", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "sorry username and password cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    LogIn.myUserName = userName;
                    LogIn.myPassword = password;

                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
