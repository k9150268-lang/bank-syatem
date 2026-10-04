import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener{

    JButton b1,b2;
    JPasswordField f1,f2;
    String pin;
    
    PinChange(String pin){

        ImageIcon icon = new ImageIcon("img4.png");

        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(1350, 800, Image.SCALE_SMOOTH);

        ImageIcon newIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(newIcon);
        //background.setBounds(0,0,1550,1080);
        background.setLayout(null);

        this.pin=pin;

        JLabel l1=new JLabel("CHANGE YOUR PIN :");
        l1.setBounds(415,250,200,30);
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.white);

        JLabel l2=new JLabel("NEW PIN :");
        l2.setBounds(335,290,400,30);
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setForeground(Color.white);

        f1=new JPasswordField();
        f1.setBounds(465,290,200,35);
        f1.setFont(new Font("System",Font.BOLD,14));

        JLabel l3=new JLabel("Re-Enter NEW PIN :");
        l3.setBounds(335,345,400,30);
        l3.setFont(new Font("System",Font.BOLD,14));
        l3.setForeground(Color.white);

        f2=new JPasswordField();
        f2.setBounds(465,345,200,35);
        f2.setFont(new Font("System",Font.BOLD,14));

        b1=new JButton("Change");
        b1.setBounds(700,360,130,33);
        b1.setFont(new Font("Raleway",Font.BOLD,14));
        b1.setBackground(new Color(32, 28, 66));
        b1.setForeground(Color.white);
        b1.addActionListener(this);

        b2=new JButton("Back");
        b2.setBounds(700,400,130,33);
        b2.setFont(new Font("Raleway",Font.BOLD,14));
        b2.setBackground(new Color(32, 28, 66));
        b2.setForeground(Color.white);
        b2.addActionListener(this);


        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(f1);
        background.add(f2);
        background.add(b1);
        background.add(b2);

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);

        setContentPane(background);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b2){
            setVisible(false);
            new BankScreen(pin);
        }
        else if(e.getSource()==b1){

            try{
                String pin1=f1.getText();
                String pin2=f2.getText();
                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null, "Re-Entered PIN does not match!");
                    return ;
                }
                else if(f1.getText().equals("") || f2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "correctly fill info!");
                    return ;
                }
                ConnectionDB c=new ConnectionDB();
                String q1="update bank set pin = '"+pin1+"' where pin = '"+pin+"' ";
                String q2="update login set pin = '"+pin1+"' where pin = '"+pin+"' ";
                String q3="update sighupthree set pin = '"+pin1+"' where pin = '"+pin+"' ";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully1"); 
                setVisible(false);
                new BankScreen(pin1);
            }
            catch(Exception E){

            }
        }
    }


    public static void main(String[] args) {
        new PinChange("");
    }
}
