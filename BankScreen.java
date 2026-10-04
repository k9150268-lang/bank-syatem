import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.event.ActionListener;
//import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


public class BankScreen extends JFrame implements ActionListener{
    String pin;
    JButton b1,b2,b4,b5,b6,b7;
    BankScreen(String pin){

        super("main screen");
        //setSize(800,700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,20);
        this.pin=pin;
        
        ImageIcon icon = new ImageIcon("img4.png");

        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(1350, 800, Image.SCALE_SMOOTH);

        ImageIcon newIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(newIcon);
        background.setLayout(null);

        //deposite label
        b1=new JButton("DEPOSITE MONEY");
        b1.setBounds(360,240,200,30);
        b1.setFont(new Font("Raleway",Font.BOLD,14));
        // depositbtn.setBackground(new Color(45,39,67));
        // depositbtn.setForeground(new Color(#00000f));
        b1.addActionListener(this);

        //withdrow
        b2=new JButton("WITHDRAW MONEY");
        b2.setBounds(600,240,200,30);
        b2.setFont(new Font("Raleway",Font.BOLD,14));
        //creditAmtbtn.setBackground(new Color(45,39,67));
        b2.addActionListener(this);

        //mini statement
        b4=new JButton("MINI STATEMENT");
        b4.setBounds(600,280,200,30);
        b4.setFont(new Font("Raleway",Font.BOLD,14));
        b4.addActionListener(this);

        b5=new JButton("BANK ENQUIRY");
        b5.setBounds(360,320,200,30);
        b5.setFont(new Font("Raleway",Font.BOLD,14));
        b5.addActionListener(this);

        //Exit 
        b6=new JButton("EXIT");
        b6.setBounds(600,320,200,30);
        b6.setFont(new Font("Raleway",Font.BOLD,14));
        b6.addActionListener(this);

        //change pin
        b7=new JButton("CHANGE PIN");
        b7.setBounds(360,280,200,30);
        b7.setFont(new Font("Raleway",Font.BOLD,14));
        b7.addActionListener(this);

        //transfer money
        // transferAmtBtn=new JButton("Transfer Money");
        // transferAmtBtn.setBounds(285,320,200,30);
        // transferAmtBtn.setFont(new Font("Raleway",Font.BOLD,14));

        
        background.add(b1);
        background.add(b2);
        background.add(b4);
        background.add(b5);
        background.add(b6);
        background.add(b7);

        //https://github.com/k9150268-lang/BankManagementSystem.git


        setContentPane(background);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b1){
            new deposite(pin);
        }
        else if(e.getSource()==b2){
            new Withdrow(pin);
            setVisible(false);
        }
        else if(e.getSource()==b4){
            new MiniStatement(pin);
            setVisible(false);
        }
        else if(e.getSource()==b5){
            new BalanceEnquiry(pin);
            setVisible(false);
        }
        else if(e.getSource()==b6){
            System.exit(0);
        }
        else if(e.getSource()==b7){
            new PinChange(pin);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BankScreen("");
    }
}
