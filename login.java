import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

public class login {

    public static void main(String args[]){

        JFrame frame = new JFrame();

        frame.setTitle("Bank Management System");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300, 80);
        frame.setUndecorated(true);
        ImageIcon icon = new ImageIcon("img2.png");

        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(800, 500, Image.SCALE_SMOOTH);

        ImageIcon newIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(newIcon);

        //frame.setContentPane(background);
        background.setLayout(null);

        //welcome meassage
        JLabel welcome=new JLabel("Welcome to Bank!");
        welcome.setBounds(250,50,300,30);
        welcome.setFont(new Font("Arial",Font.BOLD,30));
        welcome.setForeground(Color.white);

        JLabel cardLabel=new JLabel("Enter CARD NO. : ");
        cardLabel.setBounds(200, 120, 300, 20);
        //pinlabel.setFont(new Font("Arial",Font.BOLD, 20));
        cardLabel.setFont(new Font("Arial",Font.BOLD, 20));
        cardLabel.setForeground(Color.WHITE);


        JTextField cardnoField=new JTextField();
        cardnoField.setBounds(200,159,343,35);
        cardnoField.setFont(new Font("Arial",Font.PLAIN , 16));
        cardnoField.setForeground(Color.white);
        cardnoField.setBackground(Color.DARK_GRAY);

        // //password label
        JLabel passwordLabel=new JLabel("Enter PIN :");
        passwordLabel.setBounds(200, 220, 300, 20);
        //pinlabel.setFont(new Font("Arial",Font.BOLD, 20));
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 20));
        passwordLabel.setForeground(Color.WHITE);

        // //password field
        JPasswordField passwordField=new JPasswordField();
        passwordField.setBounds(200,255,343,35);
        passwordField.setFont(new Font("Arial",Font.BOLD, 30));
        passwordField.setForeground(Color.white);
        passwordField.setBackground(Color.DARK_GRAY);

        // buttons

        JButton submitButton=new JButton("Submit");
        submitButton.setBounds(200,320,100,35);
        submitButton.setBackground(Color.darkGray);
        submitButton.setForeground(Color.white);
        
        JButton signUpBtn=new JButton("Sign-Up");
        signUpBtn.setBounds(320,320,100,35);
        signUpBtn.setBackground(Color.darkGray);
        signUpBtn.setForeground(Color.white);
        
        //exit button
        JButton exitBtn=new JButton("Exit");
        exitBtn.setBounds(440,320,100,35);
        exitBtn.setBackground(Color.darkGray);
        exitBtn.setForeground(Color.white);
        
        //add components above backgraound
        background.add(welcome);

        background.add(cardLabel);
        background.add(cardnoField);

        background.add(passwordLabel);
        background.add(passwordField);

        background.add(submitButton);
        background.add(signUpBtn);
        background.add(exitBtn);

        frame.setContentPane(background);
        frame.setVisible(true);
        
        
        // submitButton.addActionListener(e ->{
        //     String pin=pinField.getText();
        // });

        exitBtn.addActionListener(e -> {
            System.exit(0);
        });

        signUpBtn.addActionListener(e -> {
            new SignUp();
        });

        submitButton.addActionListener(e->{
            try{
                String cardno=cardnoField.getText();
                String pin=passwordField.getText();
                ConnectionDB c=new ConnectionDB();
                String q="select * from login where card_no = '"+cardno+"' and pin = '"+pin+"' ";
                ResultSet rs=c.statement.executeQuery(q);
                if(rs.next()){
                    frame.setVisible(false);
                    new BankScreen(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null, "incorrect card no. or pin");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        });

    }

}
/*
submitButton.addActionListener(e -> {

    String pin = pinField.getText();
    String password = new String(passwordField.getPassword());

    System.out.println("PIN: " + pin);
    System.out.println("Password: " + password);
});

signupButton.addActionListener(e -> {

    JOptionPane.showMessageDialog(
        frame,
        "Sign Up button clicked!"
    );
});

exitButton.addActionListener(e -> {
    System.exit(0);
});
*/