package com.MyATM;

import javax.swing.*;
import java.sql.ResultSet;

public class CheckBalance {
    String userName = LogIn.myUserName;

    CheckBalance() {
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
                        String query = "select balance from accdetails where username='"+userName+"' and pin="+pinNumber+";";
                        try {
                            ResultSet rs2 = conn.s.executeQuery(query);
                            //if balance is present then update
                            if (rs2.next()) {
                                double balance = rs2.getDouble(1);
                                JOptionPane.showMessageDialog(null, "Your Balance is " + balance, "Current Balance", JOptionPane.ERROR_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog(null, "Wrong pin number", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Wrong Input", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else{
                        JOptionPane.showMessageDialog(null, "sorry pin cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                    }

            }else{
                JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}