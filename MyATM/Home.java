package com.MyATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home implements ActionListener {
    public static JFrame frame = new JFrame("Anubhav Central Bank");
    JButton button1, button2, button3, button4,button5,button6,button7,button8,button9;
    JLabel label1,label2,label3,label4 ;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");


    Home(){
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        frame.setLayout(null);
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(false);

        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        label1 = new JLabel("Welcome to ACB");
        label1.setFont(new Font("Bauhaus 93",Font.BOLD,40));
        label1.setForeground(Color.black);
        label1.setBounds(190,20,400,50);
        c.add(label1);

        label2 = new JLabel("\"Always 24/7 Available | Bharat Sarkar Ke Adhin\"");
        label2.setFont(new Font("arial",Font.ITALIC,20));
        label2.setForeground(Color.black);
        label2.setBounds(130,55,500,50);
        c.add(label2);

        label3 = new JLabel("Hope you like the Experience. \nYour Feedback is very much important for us.");
        label3.setFont(new Font("arial",Font.PLAIN,12));
        label3.setForeground(Color.black);
        label3.setBounds(145,420,500,40);
        c.add(label3);

        button1 = new JButton("Create Account");
        button1.setBounds(70,120,200,40);
        button1.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button1.addActionListener(this);
        button1.setFocusable(false);
        c.add(button1);

        button2 = new JButton("Deposit Amount");
        button2.setBounds(70,200,200,40);
        button2.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button2.addActionListener(this);
        button2.setFocusable(false);
        c.add(button2);

        button3 = new JButton("Withdraw Amount");
        button3.setBounds(70,280,200,40);
        button3.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button3.addActionListener(this);
        button3.setFocusable(false);
        c.add(button3);

        button4 = new JButton("Check Balance");
        button4.setBounds(70,360,200,40);
        button4.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button4.addActionListener(this);
        button4.setFocusable(false);
        c.add(button4);

        button5 = new JButton("Account Details");
        button5.setBounds(410,120,200,40);
        button5.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button5.addActionListener(this);
        button5.setFocusable(false);
        c.add(button5);

        button6 = new JButton("Transaction History");
        button6.setBounds(410,200,200,40);
        button6.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button6.addActionListener(this);
        button6.setFocusable(false);
        c.add(button6);

        button7 = new JButton("Settings");
        button7.setBounds(410,280,200,40);
        button7.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button7.addActionListener(this);
        button7.setFocusable(false);
        c.add(button7);

        button8 = new JButton("Delete Account");
        button8.setBounds(410,360,200,40);
        button8.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button8.addActionListener(this);
        button8.setFocusable(false);
        c.add(button8);

        button9 = new JButton("Log Out");
        button9.setBounds(290,360,100,40);
        button9.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
        button9.addActionListener(this);
        button9.setFocusable(false);
        c.add(button9);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            new CreateAccount();
            frame.setVisible(false);
        }else if(e.getSource() == button2){
            new DepositAmount();
        }else if(e.getSource() == button3){
            new WithdrawAmount();
        }else if(e.getSource() == button4){
            new CheckBalance();
        }else if(e.getSource() == button5){
            new AccountDetails();
        }else if(e.getSource() == button6){
            new TransactionHistory();
        }else if(e.getSource() == button7){
            new Setting();
            frame.setVisible(false);
        }else if(e.getSource() == button8){
            new DeleteAccount();
        }else if (e.getSource() == button9){
            new LogIn();
            frame.setVisible(false);
        }
    }
}
