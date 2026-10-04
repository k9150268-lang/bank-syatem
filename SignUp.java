import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {

    Random r=new Random();
    int randomNo=r.nextInt(9999);
    String formNum=" "+Math.abs(randomNo);
    JTextField nameField,fNameField,mNameField,emailField,addressField,cityField,pinCodeField,stateField;
    //JDateChooser dateChoose;
    JRadioButton m1,m2;
    JButton nextBtn;
    JComboBox<String> day,month,year,genderBox;
    
    SignUp(){
        super("Application Form ");

        getContentPane().setBackground(new Color(0,115,203));
        setLayout(null);
        setSize(850,700);
        setLocation(300,20);

        JLabel formNo=new JLabel("Application Form Number : "+formNum);
        formNo.setBounds(160,20,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);

        JLabel personalDetailLabel=new JLabel("Personal Detail :");
        personalDetailLabel.setBounds(290,70,600,30);
        personalDetailLabel.setFont(new Font("Raleway",Font.PLAIN,22));
        add(personalDetailLabel);

        // name label
        JLabel nameLabel=new JLabel("Enter Name :");
        nameLabel.setBounds(100,120,300,30);
        nameLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(nameLabel);

        //name field
        nameField=new JTextField();
        nameField.setBounds(310,120,300,30);
        nameField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(nameField);

        //father, mother name label 
        JLabel fName=new JLabel("Enter Father Name :");
        fName.setBounds(100,160,300,30);
        fName.setFont(new Font("Raleway",Font.PLAIN,19));
        add(fName);

        fNameField=new JTextField();
        fNameField.setBounds(310,160,300,30);
        fNameField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(fNameField);

        //mother
        JLabel mName=new JLabel("Enter Mother Name :");
        mName.setBounds(100,200,300,30);
        mName.setFont(new Font("Raleway",Font.PLAIN,19));
        add(mName);

        mNameField=new JTextField();
        mNameField.setBounds(310,200,300,30);
        mNameField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(mNameField);

        // DOB
        JLabel dobLabel=new JLabel("Enter Your DOB :");
        dobLabel.setBounds(100,250,300,30);
        dobLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(dobLabel);

        day = new JComboBox<>();
        month = new JComboBox<>();
        year = new JComboBox<>();

        for (int i = 1; i <= 31; i++) {
            day.addItem(String.valueOf(i));
        }

        for (int i = 1; i <= 12; i++) {
            month.addItem(String.valueOf(i));
        }

        for (int i = 1950; i <= 2026; i++) {
            year.addItem(String.valueOf(i));
        }

        day.setBounds(310, 250, 60, 30);
        month.setBounds(380, 250, 60, 30);
        year.setBounds(450, 250, 80, 30);

        add(dobLabel);
        add(day);
        add(month);
        add(year);

        // gender
        JLabel genderLabel=new JLabel("Gender :");
        genderLabel.setBounds(100,290,300,30);
        genderLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(genderLabel);

        genderBox=new JComboBox<>();
        genderBox.addItem("Select");
        genderBox.addItem("Female");
        genderBox.addItem("Male");
        genderBox.addItem("Other");
        genderBox.setBounds(310,290,200,30);
        genderBox.setFont(new Font("Raleway",Font.PLAIN,19));
        add(genderBox);

        //enter email
        JLabel emailLabel=new JLabel("Enter email :");
        emailLabel.setBounds(100,330,200,30);
        emailLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(emailLabel);

        emailField=new JTextField();
        emailField.setBounds(310,330,300,30);
        emailField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(emailField);

        //address
        JLabel addressLabel=new JLabel("Enter Address :");
        addressLabel.setBounds(100,370,200,30);
        addressLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(addressLabel);

        addressField=new JTextField();
        addressField.setBounds(310,370,300,30);
        addressField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(addressField);

        //enter city
        JLabel acityLabel=new JLabel("Enter City :");
        acityLabel.setBounds(100,410,200,30);
        acityLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(acityLabel);

        cityField=new JTextField();
        cityField.setBounds(310,410,300,30);
        cityField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(cityField);

        //enter pin-code
        JLabel pinCodeLabel=new JLabel("Enter Pin-Code :");
        pinCodeLabel.setBounds(100,450,200,30);
        pinCodeLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(pinCodeLabel);

        pinCodeField=new JTextField();
        pinCodeField.setBounds(310,450,300,30);
        pinCodeField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(pinCodeField);

        //enter state
        JLabel stateLabel=new JLabel("Enter State :");
        stateLabel.setBounds(100,490,200,30);
        stateLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(stateLabel);

        stateField=new JTextField();
        stateField.setBounds(310,490,300,30);
        stateField.setFont(new Font("Raleway",Font.PLAIN,19));
        add(stateField);

        //marital status
        JLabel mLabel=new JLabel("Enter Marital status :");
        mLabel.setBounds(100,530,200,30);
        mLabel.setFont(new Font("Raleway",Font.PLAIN,19));
        add(mLabel);
        m1=new JRadioButton("Married");
        m1.setBounds(310,530,200,30);
        m1.setFont(new Font("Raleway",Font.PLAIN,19));
        add(m1);
        m2=new JRadioButton("UnMarried");
        m2.setBounds(530,530,200,30);
        m2.setFont(new Font("Raleway",Font.PLAIN,19));
        add(m2);

        ButtonGroup bg=new ButtonGroup();
        bg.add(m1);
        bg.add(m2);

        //next button
        nextBtn=new JButton("Next");
        nextBtn.setBounds(100,570,200,30);
        nextBtn.setFont(new Font("Raleway",Font.PLAIN,19));
        add(nextBtn);
        nextBtn.addActionListener(this);

        //exit button

        setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e){
        try{
            String formNo=formNum;
            String userName=nameField.getText();
            String fname=fNameField.getText();
            String mname=mNameField.getText();
            int daystr = Integer.parseInt((String) day.getSelectedItem());
            int monthstr = Integer.parseInt((String) month.getSelectedItem());
            int yearStr = Integer.parseInt((String) year.getSelectedItem());

            LocalDate d = LocalDate.of(yearStr, monthstr, daystr);
            String dob = d.toString();
            String genderStr=(String) genderBox.getSelectedItem();
            String emailstr=emailField.getText();
            String add=addressField.getText();
            String citystr=cityField.getText();
            String pincode=pinCodeField.getText();
            String state=stateField.getText();
            String marital=null;
            if(m1.isSelected()){
                marital="Married";
            }
            else if(m2.isSelected()){
                marital="UnMarried";
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select marital status");
                return;
            }

            try{
                if(nameField.getText().equals("") || fNameField.getText().equals("") || mNameField.getText().equals("") || dob.equals("") || genderBox.getSelectedItem().equals("Select") || emailField.getText().equals("") || addressField.getText().equals("") || cityField.getText().equals("") || pinCodeField.getText().equals("") || stateField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"please correctly fill info!");
                }
                else{
                    ConnectionDB con=new ConnectionDB();
                    String q="insert into signup values('"+formNo+"','"+userName+"','"+mname+"','"+fname+"','"+dob+"','"+genderStr+"','"+emailstr+"','"+add+"','"+citystr+"','"+state+"','"+pincode+"','"+marital+"')";
                    con.statement.executeUpdate(q);
                    new SignUp2(formNo);
                    setVisible(false);
                }

            }
            catch(Exception e1){
                e1.printStackTrace();
            }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
