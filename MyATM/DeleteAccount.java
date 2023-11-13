package com.MyATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteAccount implements ActionListener {
    String userName = LogIn.myUserName;

    JFrame frame, okframe;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JTextField textField1, textField2, textField3;
    JButton button1, button2, button3, okbutton;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");
    //create a object of Conn class
    Conn conn = new Conn();
    DeleteAccount(){
        //check whether your details are exists or not
        String myquery = "select * from accdetails where username='" + userName + "';";
        try {
            ResultSet rs1 = conn.s.executeQuery(myquery);
            if (rs1.next()) {
                Home.frame.setVisible(false);
                frame = new JFrame("ANUBHAV CENTRAL BANK");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null);
                frame.setIconImage(imageIcon.getImage());
                frame.setLayout(new FlowLayout());
                frame.setResizable(false);

                Container c = frame.getContentPane();
                c.setLayout(null);
                c.setBackground(Color.ORANGE);

                label1 = new JLabel("DELETE ACCOUNT");
                label1.setFont(new Font("Bauhaus 93", Font.BOLD, 45));
                label1.setForeground(Color.black);
                label1.setBounds(170, 18, 700, 50);
                c.add(label1);

                label2 = new JLabel("To delete account enter your all details & please tell us why you want to");
                label2.setFont(new Font("arial", Font.ITALIC, 18));
                label2.setHorizontalTextPosition(JLabel.CENTER);
                label2.setHorizontalAlignment(JLabel.CENTER);
                label2.setBounds(10, 70, 660, 20);
                label2.setForeground(Color.black);
                c.add(label2);

                label7 = new JLabel("delete account, if you have any problem then you contact us");
                label7.setFont(new Font("arial", Font.ITALIC, 18));
                label7.setHorizontalTextPosition(JLabel.CENTER);
                label7.setHorizontalAlignment(JLabel.CENTER);
                label7.setBounds(10, 95, 660, 20);
                label7.setForeground(Color.black);
                c.add(label7);

                label3 = new JLabel("Holder's Name: ");
                label3.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
                label3.setBounds(110, 135, 200, 50);
                label3.setForeground(Color.BLACK);
                c.add(label3);

                textField1 = new JTextField();
                textField1.setFont(new Font("arial", Font.PLAIN, 16));
                textField1.setBounds(280, 142, 290, 28);
                textField1.setForeground(Color.BLACK);
                c.add(textField1);

                label4 = new JLabel("Account No.: ");
                label4.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
                label4.setBounds(110, 180, 200, 50);
                label4.setForeground(Color.BLACK);
                c.add(label4);

                textField2 = new JTextField();
                textField2.setFont(new Font("arial", Font.PLAIN, 16));
                textField2.setBounds(280, 187, 290, 28);
                textField2.setForeground(Color.BLACK);
                c.add(textField2);

                label8 = new JLabel("Mob No.: ");
                label8.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
                label8.setBounds(110, 225, 200, 50);
                label8.setForeground(Color.BLACK);
                c.add(label8);

                textField3 = new JTextField();
                textField3.setFont(new Font("arial", Font.PLAIN, 16));
                textField3.setBounds(280, 232, 290, 28);
                textField3.setForeground(Color.BLACK);
                c.add(textField3);

                button1 = new JButton("CONFIRM");
                button1.setFocusable(false);
                button1.setBounds(260, 280, 180, 40);
                button1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
                button1.setHorizontalTextPosition(JButton.CENTER);
                button1.setVerticalTextPosition(JButton.CENTER);
                button1.setForeground(Color.BLACK);
                button1.setBorder(BorderFactory.createEtchedBorder());
                button1.addActionListener(this);
                c.add(button1);

                button2 = new JButton("BACK");
                button2.setFocusable(false);
                button2.setBounds(10, 415, 120, 40);
                button2.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
                button2.setHorizontalTextPosition(JButton.CENTER);
                button2.setVerticalTextPosition(JButton.CENTER);
                button2.setForeground(Color.BLACK);
                button2.addActionListener(this);
                c.add(button2);

                button3 = new JButton("MENU");
                button3.setFocusable(false);
                button3.setBounds(555, 415, 120, 40);
                button3.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
                button3.setHorizontalTextPosition(JButton.CENTER);
                button3.setVerticalTextPosition(JButton.CENTER);
                button3.setForeground(Color.BLACK);
                button3.addActionListener(this);
                c.add(button3);

                label4 = new JLabel("- Take care of your money - it is hard to earn but easy to lose*");
                label4.setFont(new Font("arial", Font.ITALIC, 13));
                label4.setHorizontalTextPosition(JLabel.CENTER);
                label4.setHorizontalAlignment(JLabel.CENTER);
                label4.setBounds(50, 320, 600, 50);
                label4.setForeground(Color.black);
                c.add(label4);

                label5 = new JLabel("- Be careful while investing in seemingly attractive schemes offering high returns*");
                label5.setFont(new Font("arial", Font.ITALIC, 13));
                label5.setHorizontalTextPosition(JLabel.CENTER);
                label5.setHorizontalAlignment(JLabel.CENTER);
                label5.setBounds(50, 340, 600, 50);
                label5.setForeground(Color.black);
                c.add(label5);

                label6 = new JLabel("- Never respond to unsolicited offers of money received through emails/phone/other media*");
                label6.setFont(new Font("arial", Font.ITALIC, 13));
                label6.setHorizontalTextPosition(JLabel.CENTER);
                label6.setHorizontalAlignment(JLabel.CENTER);
                label6.setBounds(50, 360, 600, 50);
                label6.setForeground(Color.black);
                c.add(label6);
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
        if(e.getSource()==button1){
            deleteAccount();
        }else if(e.getSource()==button2) {
            frame.setVisible(false);
            new Home();
        }else if(e.getSource()==button3){
            frame.setVisible(false);
            new Home();
        }
    }

    public void deleteAccount(){
        if (textField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (textField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter your account number", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(textField3.getText().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Please enter your user number", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            delete();
        }
    }

    public void delete(){
        try {
            String name = textField1.getText();
            String myAccNumber = textField2.getText();
            long accNumber = Long.parseLong(myAccNumber);
            String myMobNo = textField3.getText();
            long mobNum = Long.parseLong(myMobNo);

            String pinNumber;
            final JPasswordField passwordField = new JPasswordField();
            pinNumber = JOptionPane.showConfirmDialog(null, passwordField, "Enter Your PIN number securely", Integer.parseInt(String.valueOf(JOptionPane.OK_CANCEL_OPTION)), JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(passwordField.getPassword()) : "";
            if(pinNumber.length()>0){

                String query1 = "delete from transaction where pin="+pinNumber+";";
                int updateQuery1 = conn.s.executeUpdate(query1);
                System.out.println(updateQuery1+" row/s update");

                String query2 = "delete from accdetails where  pin="+pinNumber+" && accnumber="+accNumber+" & mobno="+mobNum+" ;";
                int updateQuery2 = conn.s.executeUpdate(query2);
                System.out.println(updateQuery2+" row/s update");

                System.out.println("Your account is deleted successfully");
            }else{
                JOptionPane.showMessageDialog(frame,"Sorry username & password can,t be null","error",JOptionPane.ERROR_MESSAGE);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
