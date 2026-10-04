import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;

// import javax.swing.JOptionPane;
// import javax.swing.JTextField;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
// import java.time.LocalDate;
//import javax.swing.*;
import java.awt.Font;
//import java.time.LocalDate;
import java.awt.Color;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel l2;
    JButton b1;
    String pin;

    BalanceEnquiry(String pin){

        ImageIcon icon = new ImageIcon("img4.png");

        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(1350, 800, Image.SCALE_SMOOTH);

        ImageIcon newIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(newIcon);
        background.setLayout(null);

        this.pin=pin;

        JLabel l1=new JLabel("YOUR CURRENT BALANCE IS : Rs.");
        l1.setBounds(415,250,400,35);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.darkGray);

        l2=new JLabel();
        l2.setBounds(415,290,400,35);
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setForeground(Color.darkGray);

        b1=new JButton("Back");
        b1.setBounds(670,380,150,35);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.setForeground(Color.darkGray);
        b1.addActionListener(this);

        int balance=0;

        try{

            ConnectionDB c=new ConnectionDB(); 
            ResultSet rs=c.statement.executeQuery("select * form bank where pin ='"+pin+"' ");
            while(rs.next()){
                if(rs.getString("type").equals("Deposite")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        l2.setText(balance+"");

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);

        background.add(l1);
        background.add(l2);
        background.add(b1);


        setContentPane(background);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new BankScreen(pin);
    }


    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
