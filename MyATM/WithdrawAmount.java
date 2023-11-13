package com.MyATM;

import javax.swing.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WithdrawAmount {
    String userName = LogIn.myUserName;

    WithdrawAmount() {
        //create a object of Conn class
        Conn conn = new Conn();
        //check whether your details are exists or not
        String myquery = "select * from accdetails where username='" + userName + "';";
        try {
            ResultSet rs1 = conn.s.executeQuery(myquery);
            if (rs1.next()) {
                final String pinNumber;
                final JPasswordField passwordField = new JPasswordField();

                //get input from user
                String enterAmount1 = JOptionPane.showInputDialog("Enter amount");
                double enterAmount = Double.parseDouble(enterAmount1);

                //get pin number from user
                pinNumber = JOptionPane.showConfirmDialog(null, passwordField, "Enter Your PIN number securely", Integer.parseInt(String.valueOf(JOptionPane.OK_CANCEL_OPTION)), JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(passwordField.getPassword()) : "";

                if (enterAmount1.length() > 0 && pinNumber.length() > 0) {
                    try {
                        //check balance
                        String query = "select balance from accdetails where username='" + userName + "' and pin=" + pinNumber + ";";
                        ResultSet rs2 = conn.s.executeQuery(query);
                        //if balance is present then update
                        if (rs2.next()) {
                            double availableAmount = rs2.getDouble(1);
                            try {
                                if (enterAmount > availableAmount) {
                                    throw new Exception();
                                } else {
                                    double totalAmount = availableAmount - enterAmount;

                                    //deposit balance
                                    String newQuery1 = "update accdetails set balance = " + totalAmount + " where pin=" + pinNumber + ";";
                                    int execute1 = conn.s.executeUpdate(newQuery1);
                                    System.out.println(execute1 + " row/s affected");

                                    //get recent time & date
                                    LocalDateTime dateTime = LocalDateTime.now();
                                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - E - H:m:s a");
                                    String myDate = dateTime.format(dateTimeFormatter);

                                    //update the transaction history
                                    String newQuery2 = "insert into transaction values('Amount Withdrawn'," + enterAmount + ",'" + myDate + "'," + totalAmount + ",'" + userName + "',"+pinNumber+");";
                                    int execute2 = conn.s.executeUpdate(newQuery2);
                                    System.out.println(execute2 + " row/s affected");

                                    JOptionPane.showMessageDialog(null, "Amount Withdrawn Successfully", "Message", JOptionPane.PLAIN_MESSAGE);
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Sorry!! Insufficient balance", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong pin number, Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Wrong pin number, Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "sorry username and password cannot be null please try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Account doesn't exists, Please create an account 1st", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter Valid Input", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Account doesn't exists, please create an account first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}