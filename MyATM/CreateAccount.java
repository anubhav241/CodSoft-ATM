package com.MyATM;


import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CreateAccount implements ActionListener {
    JFrame frame;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, oklabel;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JCheckBox checkBox;
    JComboBox comboBox1, comboBox2, comboBox3, comboBox4, comboBox5, comboBox6, comboBox7;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    JButton button1, button2;
    ImageIcon imageIcon = new ImageIcon("The Coding Career-modified.png");

    String userName = LogIn.myUserName;

    CreateAccount() {
        frame = new JFrame("ANUBHAV CENTRAL BANK");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(false);

        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        label8 = new JLabel("Account Creation");
        label8.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
        label8.setForeground(Color.black);
        label8.setBounds(190, 18, 700, 50);
        c.add(label8);

        label9 = new JLabel("To create account please fill up the following details.");
        label9.setFont(new Font("arial", Font.ITALIC, 20));
        label9.setBounds(120, 52, 500, 50);
        label9.setForeground(Color.black);
        c.add(label9);

        label1 = new JLabel("Name: ");
        label1.setFont(new Font("Baskerville Old Face", Font.BOLD, 21));
        label1.setBounds(20, 110, 150, 25);
        label1.setForeground(Color.BLACK);
        c.add(label1);

        textField1 = new JFormattedTextField();
        textField1.setFont(new Font("arial", Font.PLAIN, 16));
        textField1.setBounds(120, 110, 210, 25);
        textField1.setForeground(Color.BLACK);
        c.add(textField1);

        label2 = new JLabel("Mob No.: ");
        label2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label2.setBounds(20, 150, 150, 25);
        label2.setForeground(Color.BLACK);
        c.add(label2);

        textField2 = new JFormattedTextField();
        textField2.setFont(new Font("arial", Font.PLAIN, 16));
        textField2.setBounds(120, 150, 210, 25);
        textField2.setForeground(Color.BLACK);
        c.add(textField2);

        label3 = new JLabel("State: ");
        label3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label3.setBounds(20, 190, 150, 25);
        label3.setForeground(Color.BLACK);
        c.add(label3);

        String[] states = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal","Andaman and Nicobar Islands","Chandigarh","Dadra Nagar Haveli and Daman Diu","Delhi","Jammu and Kashmir","Ladakh","Lakshadweep","Puducherry"};

        comboBox1 = new JComboBox(states);
        comboBox1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox1.setBounds(80, 190, 250, 25);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBackground(Color.WHITE);
        c.add(comboBox1);

        label4 = new JLabel("District: ");
        label4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label4.setBounds(20, 230, 150, 25);
        label4.setForeground(Color.BLACK);
        c.add(label4);

        textField3 = new JFormattedTextField();
        textField3.setFont(new Font("arial", Font.PLAIN, 16));
        textField3.setBounds(120, 230, 210, 25);
        textField3.setForeground(Color.BLACK);
        c.add(textField3);

        label5 = new JLabel("City: ");
        label5.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label5.setBounds(20, 270, 150, 25);
        label5.setForeground(Color.BLACK);
        c.add(label5);

        textField4 = new JFormattedTextField();
        textField4.setFont(new Font("arial", Font.PLAIN, 16));
        textField4.setBounds(120, 270, 210, 25);
        textField4.setForeground(Color.BLACK);
        c.add(textField4);

        label6 = new JLabel("Pin: ");
        label6.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label6.setBounds(20, 310, 150, 25);
        label6.setForeground(Color.BLACK);
        c.add(label6);

        textField5 = new JFormattedTextField();
        textField5.setFont(new Font("arial", Font.PLAIN, 16));
        textField5.setBounds(120, 310, 210, 25);
        textField5.setForeground(Color.BLACK);
        c.add(textField5);

        checkBox = new JCheckBox("Tick here to confirm.");
        checkBox.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        checkBox.setBounds(20, 360, 320, 25);
        checkBox.setBackground(Color.ORANGE);
        checkBox.setForeground(Color.BLACK);
        checkBox.setIconTextGap(20);
        checkBox.setFocusable(false);
        c.add(checkBox);

        label7 = new JLabel("");
        label7.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label7.setBounds(60, 390, 500, 25);
        c.add(label7);

        label10 = new JLabel("Occupation: ");
        label10.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label10.setBounds(350, 110, 150, 25);
        label10.setForeground(Color.BLACK);
        c.add(label10);

        String[] occupation = {"Student", "Teacher", "Engineer", "Doctor", "Accountant", "Developer", "Pharmacist", "Scientist", "Psychologist", "Consultant", "Architect", "Electrician", "Journal", "Machinist", "Physiotherapist", "Social Worker", "House Wife"};

        comboBox2 = new JComboBox(occupation);
        comboBox2.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox2.setBounds(470, 110, 200, 25);
        comboBox2.setForeground(Color.BLACK);
        comboBox2.setBackground(Color.WHITE);
        c.add(comboBox2);

        label11 = new JLabel("Gender: ");
        label11.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label11.setBounds(350, 150, 150, 25);
        label11.setForeground(Color.BLACK);
        c.add(label11);

        radioButton1 = new JRadioButton("Male");
        radioButton1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        radioButton1.setBounds(450, 150, 90, 25);
        radioButton1.setForeground(Color.BLACK);
        radioButton1.setBackground(Color.ORANGE);
        radioButton1.setFocusable(false);

        radioButton2 = new JRadioButton("Female");
        radioButton2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        radioButton2.setBounds(550, 150, 150, 25);
        radioButton2.setForeground(Color.BLACK);
        radioButton2.setBackground(Color.ORANGE);
        radioButton2.setFocusable(false);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        c.add(radioButton1);
        c.add(radioButton2);

        label12 = new JLabel("Status: ");
        label12.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label12.setBounds(350, 190, 150, 25);
        label12.setForeground(Color.BLACK);
        c.add(label12);

        radioButton3 = new JRadioButton("Married");
        radioButton3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        radioButton3.setBounds(450, 190, 100, 25);
        radioButton3.setForeground(Color.BLACK);
        radioButton3.setBackground(Color.ORANGE);
        radioButton3.setFocusable(false);

        radioButton4 = new JRadioButton("Unmarried");
        radioButton4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        radioButton4.setBounds(550, 190, 150, 25);
        radioButton4.setForeground(Color.BLACK);
        radioButton4.setBackground(Color.ORANGE);
        radioButton4.setFocusable(false);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);
        c.add(radioButton3);
        c.add(radioButton4);

        label13 = new JLabel("Nationality: ");
        label13.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label13.setBounds(350, 230, 150, 25);
        label13.setForeground(Color.BLACK);
        c.add(label13);

        String[] nationality = {"INDIAN","Others"};

        comboBox7 = new JComboBox(nationality);
        comboBox7.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox7.setBounds(470, 230, 200, 25);
        comboBox7.setForeground(Color.BLACK);
        comboBox7.setBackground(Color.WHITE);
        c.add(comboBox7);

        label14 = new JLabel("UID: ");
        label14.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label14.setBounds(350, 270, 150, 25);
        label14.setForeground(Color.BLACK);
        c.add(label14);

        String[] uid = {"Aadhaar Card", "PAN Card", "Driving License", "Passport", "Voter ID Card", "Overseas Citizenship of India", "Person of Indian Origin Card", "Identity Certificate"};

        comboBox3 = new JComboBox(uid);
        comboBox3.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox3.setBounds(420, 270, 250, 25);
        comboBox3.setForeground(Color.BLACK);
        comboBox3.setBackground(Color.WHITE);
        c.add(comboBox3);

        label15 = new JLabel("UID Number: ");
        label15.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label15.setBounds(350, 310, 150, 25);
        label15.setForeground(Color.BLACK);
        c.add(label15);

        textField7 = new JTextField();
        textField7.setFont(new Font("arial", Font.PLAIN, 16));
        textField7.setBounds(480, 310, 190, 25);
        textField7.setForeground(Color.BLACK);
        c.add(textField7);

        label16 = new JLabel("DOB: ");
        label16.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        label16.setBounds(350, 353, 150, 25);
        label16.setForeground(Color.BLACK);
        c.add(label16);

        String[] date = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        comboBox4 = new JComboBox(date);
        comboBox4.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox4.setBounds(420, 350, 50, 25);
        comboBox4.setForeground(Color.BLACK);
        comboBox4.setBackground(Color.WHITE);
        c.add(comboBox4);

        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        comboBox5 = new JComboBox(month);
        comboBox5.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox5.setBounds(480, 350, 110, 25);
        comboBox5.setForeground(Color.BLACK);
        comboBox5.setBackground(Color.WHITE);
        c.add(comboBox5);

        String[] year = {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100"};

        comboBox6 = new JComboBox(year);
        comboBox6.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        comboBox6.setBounds(600, 350, 70, 25);
        comboBox6.setForeground(Color.BLACK);
        comboBox6.setBackground(Color.WHITE);
        c.add(comboBox6);

        button1 = new JButton("BACK");
        button1.setFocusable(false);
        button1.setBounds(210, 410, 120, 40);
        button1.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setVerticalTextPosition(JButton.CENTER);
        button1.setForeground(Color.BLACK);
        button1.addActionListener(this);
        c.add(button1);

        button2 = new JButton("CREATE");
        button2.setFocusable(false);
        button2.setBounds(370, 410, 120, 40);
        button2.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.CENTER);
        button2.setForeground(Color.BLACK);
        button2.addActionListener(this);
        c.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1) {
            frame.setVisible(false);
            new Home();
        } else if (ae.getSource() == button2) {
            saveDetails();
        }
    }

    public void saveDetails() {
        if (checkBox.isSelected()) {
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty() || textField7.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fill up all details first", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if ((radioButton1.isEnabled() && radioButton2.isEnabled()) || (radioButton3.isEnabled() && radioButton4.isEnabled())) {
                    try {
                        String name = textField1.getText();
                        String mobNo = textField2.getText();
                        long mob = Long.parseLong(mobNo);
                        String state = (String) comboBox1.getSelectedItem();
                        String district = textField3.getText();
                        String city = textField4.getText();
                        String myPinCode = textField5.getText();
                        long pinCode = Long.parseLong(myPinCode);
                        String occupation = (String) comboBox2.getSelectedItem();
                        String gender;
                        if (radioButton1.isSelected()) {
                            gender = "Male";
                        } else {
                            gender = "Female";
                        }
                        String status;
                        if (radioButton3.isSelected()) {
                            status = "Married";
                        } else {
                            status = "Unmarried";
                        }
                        String nationality = (String) comboBox7.getSelectedItem();
                        String uid = (String) comboBox3.getSelectedItem();
                        String myUidNumber = textField7.getText();
                        long uidNumber = Long.parseLong(myUidNumber);

                        String dob = (String) comboBox4.getSelectedItem() + "/" + comboBox5.getSelectedItem() + "/" + comboBox6.getSelectedItem();

                        double balance = 0.0;

                        Random rand = new Random();
                        long accNumber1 = rand.nextInt(999999999);
                        long accNumber2 = rand.nextInt(999999999);
                        long accNumber = accNumber1 * accNumber2;

                        Random rand1 = new Random();
                        int pinNum = rand1.nextInt(9999);


                        //create a object of Conn class
                        Conn conn = new Conn();
                        //check whether the tables are exists or not
                        String myquery1 = "select * from information_schema.tables where table_schema='atmsystem' and table_name='accdetails';";
                        ResultSet rs1 = conn.s.executeQuery(myquery1);
                        if (rs1.next()) {
                            String myquery2 = "select * from information_schema.tables where table_schema='atmsystem' and table_name='transaction';";
                            ResultSet rs2 = conn.s.executeQuery(myquery2);
                            if(rs2.next()) {
                                //insert data into database through passing query
                                String query1 = "insert into accdetails values('" + name + "'," + mob + ",'" + state + "','" + district + "','" + city + "'," + pinCode + ",'" + occupation + "','" + gender + "','" + status + "','" + nationality + "','" + uid + "'," + uidNumber + ",'" + dob + "'," + accNumber + "," + pinNum + "," + balance + ",'"+userName+"');";
                                int execute1 = conn.s.executeUpdate(query1);
                                System.out.println(execute1 + " row/s affected");        //msg for ok query

                                //msg for account successfully created
                                JOptionPane.showMessageDialog(frame, "Hurry Up...!! Your account is created successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
                                JOptionPane.showMessageDialog(frame, "Account Number:" + accNumber + "\nPIN Number:" + pinNum, "Note this", JOptionPane.PLAIN_MESSAGE);

                                //declaring date time
                                LocalDateTime dateTime = LocalDateTime.now();
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - E - H:m:s a");
                                String myDate = dateTime.format(dateTimeFormatter);

                                //insert data into transaction table
                                String query2 = "insert into transaction values('Account Created'," + balance + ",'" + myDate + "'," + balance + ",'" + userName + "',"+pinNum+");";
                                int execute2 = conn.s.executeUpdate(query2);
                                System.out.println(execute2 + " row/s affected");       //msg for ok query

                                new DepositAmount();

                            } else {
                                //insert data into accdetails table
                                String query1 = "insert into accdetails values('" + name + "'," + mob + ",'" + state + "','" + district + "','" + city + "'," + pinCode + ",'" + occupation + "','" + gender + "','" + status + "','" + nationality + "','" + uid + "'," + uidNumber + ",'" + dob + "'," + accNumber + "," + pinNum + "," + balance + ",'"+userName+"');";
                                int executeUpdate1 = conn.s.executeUpdate(query1);
                                System.out.println(executeUpdate1 + " row/s affected");           //msg for ok query

                                //msg for account successfully created
                                JOptionPane.showMessageDialog(frame, "Hurry Up...!! Your account is created successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
                                JOptionPane.showMessageDialog(frame, "Account Number:" + accNumber + "\nPIN Number:" + pinNum, "Note this", JOptionPane.PLAIN_MESSAGE);

                                //creating transaction table
                                String second_query = "create table transaction(Status varchar(200), Amount decimal(20,2), Time varchar(100) , TotalBalance decimal(20,2), username varchar(100),pin int, foreign key(username) references accdetails(username));";
                                int execute2 = conn.s.executeUpdate(second_query);
                                System.out.println(execute2 + " row/s affected");       //msg for ok query

                                //declaring date time
                                LocalDateTime dateTime = LocalDateTime.now();
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - E - H:m:s a");
                                String myDate = dateTime.format(dateTimeFormatter);

                                //insert data into transaction table
                                String query2 = "insert into transaction values('Account Created'," + balance + ",'" + myDate + "'," + balance + ",'" + userName + "',"+pinNum+");";
                                int executeUpdate2 = conn.s.executeUpdate(query2);
                                System.out.println(executeUpdate2 + " row/s affected");            //msg for ok query

                                new DepositAmount();
                            }

                        } else {
                            //creating accdetails table
                            String first_query = "create table accdetails(name varchar(200), mobno decimal(10,0), state varchar(100), district varchar(100), city varchar(100), pincode decimal(6,0), occupation varchar(100), gender varchar(100), status varchar(100), nationality varchar(100), uid varchar(200), uidnumber decimal(12,0), dob varchar(100), accnumber decimal(20,0) primary key, pin int, balance decimal(20,2), username varchar(100), foreign key(username) references signup(username));";
                            int execute1 = conn.s.executeUpdate(first_query);
                            System.out.println(execute1 + " row/s affected");       //msg for ok query

                            //insert data into accdetails table
                            String query1 = "insert into accdetails values('" + name + "'," + mob + ",'" + state + "','" + district + "','" + city + "'," + pinCode + ",'" + occupation + "','" + gender + "','" + status + "','" + nationality + "','" + uid + "'," + uidNumber + ",'" + dob + "'," + accNumber + "," + pinNum + "," + balance + ",'"+userName+"');";
                            int executeUpdate1 = conn.s.executeUpdate(query1);
                            System.out.println(executeUpdate1 + " row/s affected");           //msg for ok query

                            //msg for account successfully created
                            JOptionPane.showMessageDialog(frame, "Hurry Up...!! Your account is created successfully.", "Message", JOptionPane.PLAIN_MESSAGE);
                            JOptionPane.showMessageDialog(frame, "Account Number:" + accNumber + "\nPIN Number:" + pinNum, "Note this", JOptionPane.PLAIN_MESSAGE);

                            //creating transaction table
                            String second_query = "create table transaction(Status varchar(200), Amount decimal(20,2), Time varchar(100), TotalBalance decimal(20,2), username varchar(100), pin int, foreign key(username) references accdetails(username));";
                            int execute2 = conn.s.executeUpdate(second_query);
                            System.out.println(execute2 + " row/s affected");       //msg for ok query

                            //declaring date time
                            LocalDateTime dateTime = LocalDateTime.now();
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - E - H:m:s a");
                            String myDate = dateTime.format(dateTimeFormatter);

                            //insert data into transaction table
                            String query2 = "insert into transaction values('Account Created'," + balance + ",'" + myDate + "'," + balance + ",'" + userName + "',"+pinNum+");";
                            int executeUpdate2 = conn.s.executeUpdate(query2);
                            System.out.println(executeUpdate2 + " row/s affected");            //msg for ok query

                            new DepositAmount();
                        }
                        //close the statement & connection class
                        frame.setVisible(false);
                        new Home();

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Please enter valid input ", "Error", JOptionPane.ERROR_MESSAGE);
//                    }catch (MysqlDataTruncation e){
//                        JOptionPane.showMessageDialog(frame, "Your Input is out of range, Correct it first", "Error", JOptionPane.ERROR_MESSAGE);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Fill up all details first", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please confirm first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
