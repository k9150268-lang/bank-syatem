import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
//import javax.swing.*;
import java.awt.Font;
//import java.time.LocalDate;
import java.awt.Color;


public class Withdrow extends JFrame implements ActionListener{
    String pin;
    JTextField withdrawField;
    JButton withdrawBtn,backBtn;

    Withdrow(String pin){
        //super("deposite screen");
        
        this.pin=pin;
        ImageIcon icon = new ImageIcon("img4.png");

        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(1350, 800, Image.SCALE_SMOOTH);

        ImageIcon newIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(newIcon);
        background.setLayout(null);

        //setSize(1550,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel messageLabel=new JLabel("MAXIMUM WITHDRAWAL AMOUNT IS Rs.10000 :");
        messageLabel.setBounds(415,230,400,35);
        messageLabel.setFont(new Font("System",Font.BOLD,16));
        messageLabel.setForeground(Color.darkGray);

        JLabel l1=new JLabel("ENTER AMOUNT YOU WANT :");
        l1.setBounds(415,260,400,35);
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setForeground(Color.darkGray);

        withdrawField=new JTextField();
        withdrawField.setBounds(415,300,350,30);
        withdrawField.setFont(new Font("Raleway",Font.BOLD,14));
        withdrawField.setBackground(new Color(32, 28, 66));
        withdrawField.setForeground(Color.white);

        withdrawBtn=new JButton("Withdraw");
        withdrawBtn.setBounds(638,360,130,33);
        withdrawBtn.setFont(new Font("Raleway",Font.BOLD,14));
        withdrawBtn.setBackground(new Color(32, 28, 66));
        withdrawBtn.setForeground(Color.white);
        withdrawBtn.addActionListener(this);

        backBtn=new JButton("Back");
        backBtn.setBounds(415,360,130,33);
        backBtn.setFont(new Font("Raleway",Font.BOLD,14));
        backBtn.setBackground(new Color(32, 28, 66));
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);



        //JOptionPane.showMessageDialog(null, "you have deposited : "+amt+" your current balance is : "+totalAmt);
        
        background.add(messageLabel);
        background.add(l1);
        background.add(withdrawField);
        background.add(withdrawBtn);
        background.add(backBtn);

        setContentPane(background);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==backBtn){
            setVisible(false);
            new BankScreen(pin);
        }
        else if(e.getSource()==withdrawBtn){
            try{
            String amt=withdrawField.getText();
            LocalDate date= LocalDate.now();
            if(withdrawField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "please enter a valid amount!"); 
            }
            else{
                ConnectionDB c=new ConnectionDB();
                ResultSet rs=c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString(amt));
                    }
                }
                if(balance<Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null, "insufficient balance!");
                    return;
                }

                //update in database
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amt+"')");
                JOptionPane.showMessageDialog(null,"Rs."+amt+" withdrawed ");
                setVisible(false);
                new BankScreen(pin);

            }
            }catch(Exception E){
                E.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Withdrow("");
    }
}
