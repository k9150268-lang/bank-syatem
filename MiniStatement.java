import java.awt.Color;
//import java.awt.Label;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{

    String pin;
    JButton b;

    MiniStatement(String pin){
        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        this.pin=pin;

        JLabel l1=new JLabel();
        l1.setBounds(20,140,400,20);
        add(l1);

        JLabel l2=new JLabel("Kanak");
        l2.setBounds(150,20,200,20);
        l2.setFont(new Font("System",Font.BOLD,15));
        add(l2);

        JLabel l3=new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);

        JLabel l4=new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);

        try{
            ConnectionDB c=new ConnectionDB();
            ResultSet rs=c.statement.executeQuery("select * from login  where pin = '"+pin+"' ");

            while(rs.next()){
                l3.setText("Card no. : "+rs.getString("cardno").substring(0,4)+"XXXXXXXXXX"+rs.getString("cardno").substring(12));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            int balance=0;
            ConnectionDB c=new ConnectionDB();
            ResultSet rs=c.statement.executeQuery("select * from bank where pin = '"+pin+"' ");
            while(rs.next()){

                l1.setText(l1.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");

                if(rs.getString("type").equals("Deposite")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your Total Balance is : "+balance);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        b=new JButton("Exit");
        b.setBounds(20,500,100,25);
        b.addActionListener(this);
        add(b);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new BankScreen(pin);
    }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
