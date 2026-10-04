import java.awt.Color;
import java.awt.Checkbox;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener{
    String formno;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton submit,cancel;

    SignUp3(String formno){

        super("sign up 3");

        this.formno=formno;
        setSize(850,700);
        setLayout(null);
        setLocation(400,20);
        getContentPane().setBackground(new Color(215,252,252));

        //account details
        JLabel l1=new JLabel("Account Details :");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        //account type
        JLabel l2=new JLabel("Account type");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(100,90,200,30);
        add(l2);

        r1=new JRadioButton("Saving Account");
        r1.setBackground(new Color(215,252,252));
        r1.setFont(new Font("Raleway",Font.BOLD,18));
        r1.setBounds(100,130,250,30);
        add(r1);

        r2=new JRadioButton("Fixed Deposite Account");
        r2.setBackground(new Color(215,252,252));
        r2.setFont(new Font("Raleway",Font.BOLD,18));
        r2.setBounds(370,130,250,30);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBackground(new Color(215,252,252));
        r3.setFont(new Font("Raleway",Font.BOLD,18));
        r3.setBounds(100,170,250,30);
        add(r3);

        r4=new JRadioButton("Recurring Deposite Account");
        r4.setBackground(new Color(215,252,252));
        r4.setFont(new Font("Raleway",Font.BOLD,18));
        r4.setBounds(370,170,250,30);
        add(r4);

        ButtonGroup b1=new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);
        b1.add(r4);

        //card number
        JLabel l3=new JLabel("Card Number :");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,210,200,30);
        add(l3);

        JLabel l4=new JLabel("Your 16-Digit Card no.");
        l4.setFont(new Font("Raleway",Font.BOLD,12));
        l4.setBounds(100,240,200,20);
        add(l4);

        JLabel l5=new JLabel("XXXX-XXXX-XXXX-1234");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(330,210,250,30);
        add(l5);

        JLabel l6=new JLabel("(card no. will appear on atm card/cheque Book and Statement)");
        l6.setFont(new Font("Raleway",Font.BOLD,12));
        l6.setBounds(330,240,500,20);
        add(l6);

        JLabel l7=new JLabel("PIN:");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(100,280,200,20);
        add(l7);

        JLabel l8=new JLabel("XXXX");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(330,280,500,20);
        add(l8);

        JLabel l9=new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway",Font.BOLD,12));
        l9.setBounds(100,310,200,20);
        add(l9);

        JLabel l10=new JLabel("Service Required :");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,360,200,20);
        add(l10);
        
        c1=new JCheckBox("ATM Card");
        c1.setBackground(new Color(215,252,252));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,410,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215,252,252));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,410,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215,252,252));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,460,200,30);
        add(c3);

        c4=new JCheckBox("Email Alerts");
        c4.setBackground(new Color(215,252,252));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,460,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215,252,252));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,510,200,30);
        add(c5);

        c6=new JCheckBox("E Statement");
        c6.setBackground(new Color(215,252,252));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,510,200,30);
        add(c6);

        Checkbox c7=new Checkbox("I here by decleares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,580,600,20);
        add(c7);

        JLabel l11=new JLabel("Form no.");
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        l11.setBounds(700,10,100,30);
        add(l11);

        JLabel l12=new JLabel();
        l12.setFont(new Font("Raleway",Font.BOLD,12));
        l12.setBounds(760,10,60,30);
        add(l12);

        submit=new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(200,620,200,30);
        add(submit);
        submit.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(450,620,200,30);
        add(cancel);
        cancel.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String accType="";
        if(r1.isSelected()){
            accType="Saving Account";
        }
        else if(r2.isSelected()){
            accType="Fixed Deposite Account";
        }
        else if(r3.isSelected()){
            accType="Current Account";
        }
        else if(r4.isSelected()){
            accType="Recurring Deposite Account";
        }

        //generate random no. for card no.
        Random r=new Random();
        long first7=(r.nextLong() % 90000000L)+1409963000000000L;
        String cardno=""+Math.abs(first7);

        //generatin pin
        long first3=(r.nextLong()%9000L)+1000L;
        String pinNo=""+Math.abs(first3);

        String choise="";
        if(c1.isSelected()){
            choise+="ATM Card";
        }
        if(c2.isSelected()){
            choise+="Internet Banking";
        }
        if(c3.isSelected()){
            choise+="Mobile Banking";
        }
        if(c4.isSelected()){
            choise+="Email Alerts";
        }
        if(c5.isSelected()){
            choise+="Cheque Book";
        }
        if(c6.isSelected()){
            choise+="E Statement";
        }

        try{
            if(e.getSource()==submit){
                if(accType.equals("")){
                    JOptionPane.showMessageDialog(null,"fill correct info");
                }else{
                    ConnectionDB c1=new ConnectionDB();
                    String q="insert into signupthree values('"+formno+"','"+accType+"','"+cardno+"','"+pinNo+"','"+choise+"')";
                    String q2="insert into login values('"+formno+"','"+cardno+"','"+pinNo+"')";
                    c1.statement.executeUpdate(q);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card no : "+cardno+"\n PIN no : "+pinNo);
                    new deposite(pinNo);
                    setVisible(false);
                }
            }
            else if(e.getSource()==cancel){
                System.exit(0);
            }
            
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}

//7147, 1409962937833770
