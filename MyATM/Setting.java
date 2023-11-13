package com.MyATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting implements ActionListener {
    JFrame frame, okframe;
    JLabel label1, label2, label3, label4, label5, label6, oklabel;
    JPanel panel;
    JTextField textField1, textField2, textField3;
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9 , button10 , button11, button12;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");
    Setting(){
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

        panel = new JPanel();
        panel.setBounds(22, 105, 640, 330);
        panel.setBackground(Color.YELLOW);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(panel);

        label1 = new JLabel("ANUBHAV CENTRAL BANK");
        label1.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
        label1.setForeground(Color.black);
        label1.setBounds(110, 18, 700, 50);
        c.add(label1);

        label2 = new JLabel("\"No.1 Centralize Bank of India, Always 24/7 Available in Your Service\"");
        label2.setFont(new Font("arial", Font.ITALIC, 20));
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(16, 55, 650, 50);
        label2.setForeground(Color.black);
        c.add(label2);

        label3 = new JLabel("Hope you like the Experience. \nYour Feedback is very much important for us.");
        label3.setFont(new Font("arial", Font.PLAIN, 12));
        label3.setForeground(Color.black);
        label3.setBounds(145, 428, 500, 40);
        c.add(label3);

        button1 = new JButton("GENERAL");
        button1.setFocusable(false);
        button1.setBounds(50, 30, 250, 40);
        button1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setVerticalTextPosition(JButton.CENTER);
        button1.setForeground(Color.BLACK);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.addActionListener(this);
        panel.add(button1);

        button4 = new JButton("SECURITY");
        button4.setFocusable(false);
        button4.setBounds(50, 90, 250, 40);
        button4.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button4.setHorizontalTextPosition(JButton.CENTER);
        button4.setVerticalTextPosition(JButton.CENTER);
        button4.setForeground(Color.BLACK);
        button4.setBorder(BorderFactory.createEtchedBorder());
        button4.addActionListener(this);
        panel.add(button4);

        button5 = new JButton("PRIVACY");
        button5.setFocusable(false);
        button5.setBounds(50, 150, 250, 40);
        button5.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button5.setHorizontalTextPosition(JButton.CENTER);
        button5.setVerticalTextPosition(JButton.CENTER);
        button5.setForeground(Color.BLACK);
        button5.setBorder(BorderFactory.createEtchedBorder());
        button5.addActionListener(this);
        panel.add(button5);

        button6 = new JButton("ACCOUNT");
        button6.setFocusable(false);
        button6.setBounds(50, 210, 250, 40);
        button6.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button6.setHorizontalTextPosition(JButton.CENTER);
        button6.setVerticalTextPosition(JButton.CENTER);
        button6.setForeground(Color.BLACK);
        button6.setBorder(BorderFactory.createEtchedBorder());
        button6.addActionListener(this);
        panel.add(button6);

        button7 = new JButton("PAYMENTS");
        button7.setFocusable(false);
        button7.setBounds(330, 30, 250, 40);
        button7.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button7.setHorizontalTextPosition(JButton.CENTER);
        button7.setVerticalTextPosition(JButton.CENTER);
        button7.setForeground(Color.BLACK);
        button7.setBorder(BorderFactory.createEtchedBorder());
        button7.addActionListener(this);
        panel.add(button7);

        button8 = new JButton("SERVICES");
        button8.setFocusable(false);
        button8.setBounds(330, 90, 250, 40);
        button8.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button8.setHorizontalTextPosition(JButton.CENTER);
        button8.setVerticalTextPosition(JButton.CENTER);
        button8.setForeground(Color.BLACK);
        button8.setBorder(BorderFactory.createEtchedBorder());
        button8.addActionListener(this);
        panel.add(button8);

        button9 = new JButton("HELP");
        button9.setFocusable(false);
        button9.setBounds(330, 150, 250, 40);
        button9.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button9.setHorizontalTextPosition(JButton.CENTER);
        button9.setVerticalTextPosition(JButton.CENTER);
        button9.setForeground(Color.BLACK);
        button9.setBorder(BorderFactory.createEtchedBorder());
        button9.addActionListener(this);
        panel.add(button9);

        button10 = new JButton("THEME");
        button10.setFocusable(false);
        button10.setBounds(330, 210, 250, 40);
        button10.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        button10.setHorizontalTextPosition(JButton.CENTER);
        button10.setVerticalTextPosition(JButton.CENTER);
        button10.setForeground(Color.BLACK);
        button10.setBorder(BorderFactory.createEtchedBorder());
        button10.addActionListener(this);
        panel.add(button10);

        button2 = new JButton("LOG OUT");
        button2.setFocusable(false);
        button2.setBounds(50, 270, 250, 40);
        button2.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.CENTER);
        button2.setForeground(Color.BLACK);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("BACK");
        button3.setFocusable(false);
        button3.setBounds(330, 270, 250, 40);
        button3.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setVerticalTextPosition(JButton.CENTER);
        button3.setForeground(Color.BLACK);
        button3.setBorder(BorderFactory.createEtchedBorder());
        button3.addActionListener(this);
        panel.add(button3);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            frame.setVisible(false);
            new LogIn();
        } else if (e.getSource() == button3) {
            frame.setVisible(false);
            new Home();
        } else if(e.getSource() == button1){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        }  else if(e.getSource() == button4){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == button5){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == button6){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == button7){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == button8){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == button9){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE);
        } else if(e.getSource() == button10){
            JOptionPane.showMessageDialog(frame,"This Server is busy now...","Message",JOptionPane.PLAIN_MESSAGE) ;
        }
    }
}
