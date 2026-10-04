import javax.swing.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.Font;


public class deposite extends JFrame implements ActionListener {
    String pin;
    JTextField depositeField;
    JButton depositeBtn,backBtn;

    deposite(String pin){
        super("deposite screen");
        
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
        
        JLabel messageLabel=new JLabel("ENTER AMOUNT YOUR WANT TO DEPOSITE :");
        messageLabel.setBounds(415,230,400,35);
        messageLabel.setFont(new Font("System",Font.BOLD,16));
        messageLabel.setForeground(Color.darkGray);

        depositeField=new JTextField();
        depositeField.setBounds(415,280,350,30);
        depositeField.setFont(new Font("Raleway",Font.BOLD,14));
        depositeField.setBackground(new Color(32, 28, 66));
        depositeField.setForeground(Color.white);

        depositeBtn=new JButton("Deposite");
        depositeBtn.setBounds(700,330,130,33);
        depositeBtn.setFont(new Font("Raleway",Font.BOLD,14));
        depositeBtn.setBackground(new Color(32, 28, 66));
        depositeBtn.setForeground(Color.white);
        depositeBtn.addActionListener(this);

        backBtn=new JButton("Back");
        backBtn.setBounds(700,370,130,33);
        backBtn.setFont(new Font("Raleway",Font.BOLD,14));
        backBtn.setBackground(new Color(32, 28, 66));
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);



        //JOptionPane.showMessageDialog(null, "you have deposited : "+amt+" your current balance is : "+totalAmt);
        
        background.add(messageLabel);
        background.add(depositeField);
        background.add(depositeBtn);
        background.add(backBtn);

        setContentPane(background);
        setVisible(true);

        
    }

    public void actionPerformed(ActionEvent e){
        try{
            String amount=depositeField.getText();
            LocalDate date= LocalDate.now();
            if(e.getSource()==depositeBtn){
                if(depositeField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"correctly fill info!");
                }
                else{
                    ConnectionDB c=new ConnectionDB();
                    String q="insert into bank values('"+pin+"','"+date+"','Deposite','"+amount+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"you have deposited : Rs."+amount);
                    new BankScreen(pin);
                    setVisible(false);
                }
            }
            else if(e.getSource()==backBtn){
                setVisible(false);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        new deposite("");
    }
}