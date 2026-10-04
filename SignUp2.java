import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import javax.swing.ButtonGroup;
// import javax.swing.JButton;
import javax.swing.JComboBox;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JRadioButton;
// import javax.swing.JTextField;
// import java.awt.Color;

public class SignUp2 extends JFrame implements ActionListener{
    JComboBox<String> religionBox,catagoryBox,eduBox,occuBox;
    JTextField panField,adharField,incomeField;
    JRadioButton r1,r2,r3,r4;
    JButton nextBtn;
    String formno;

    SignUp2(String formNo){
        
        super("sign-up 2");
        setLayout(null);
        setSize(750,550);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.formno=formNo;

        //addition details
        JLabel additionalDetailsLabel=new JLabel("Additional Details :");
        additionalDetailsLabel.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetailsLabel.setBounds(300,30,600,40);
        add(additionalDetailsLabel);

        //religion label
        JLabel religionLabel=new JLabel("Religion :");
        religionLabel.setFont(new Font("Raleway",Font.BOLD,18));
        religionLabel.setBounds(100,90,100,30);
        add(religionLabel);

        String religion[]={"Hindu","Sikh","Muslim","Christian","Other"};
        religionBox=new JComboBox<>();
        religionBox.addItem("Select");
        for(int i=0;i<religion.length;i++){
            religionBox.addItem(religion[i]);
        }
        religionBox.setBackground(new Color(252,208,76));
        religionBox.setFont(new Font("Raleway",Font.BOLD,14));
        religionBox.setBounds(250,90,220,30);
        add(religionBox);

        //catagory
        JLabel catagoryLabel=new JLabel("Catagory :");
        catagoryLabel.setFont(new Font("Raleway",Font.BOLD,18));
        catagoryLabel.setBounds(100,130,100,30);
        add(catagoryLabel);

        String catagorylist[]={"OBC","General","SC","ST","Other"};
        catagoryBox=new JComboBox<>();
        catagoryBox.addItem("Select");
        for(int i=0;i<catagorylist.length;i++){
            catagoryBox.addItem(catagorylist[i]);
        }
        catagoryBox.setBackground(new Color(252,208,76));
        catagoryBox.setFont(new Font("Raleway",Font.BOLD,14));
        catagoryBox.setBounds(250,130,220,30);
        add(catagoryBox);

        //income label
        JLabel incomeLabel=new JLabel("Income :");
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,18));
        incomeLabel.setBounds(100,170,100,30);
        add(incomeLabel);

        incomeField=new JTextField();
        incomeField.setFont(new Font("Raleway",Font.BOLD,14));
        incomeField.setBounds(250,170,220,30);
        incomeField.setBackground(new Color(252,208,76));
        add(incomeField);

        //education label
        JLabel educationLabel=new JLabel("Education :");
        educationLabel.setFont(new Font("Raleway",Font.BOLD,18));
        educationLabel.setBounds(100,210,100,30);
        add(educationLabel);

        eduBox=new JComboBox<>();
        eduBox.addItem("unEducated");
        eduBox.addItem("Select");
        eduBox.addItem("Graduated");
        eduBox.addItem("Post Graduated");
        eduBox.addItem("10th passed");
        eduBox.addItem("12th pass");

        eduBox.setBackground(new Color(252,208,76));
        eduBox.setFont(new Font("Raleway",Font.BOLD,14));
        eduBox.setBounds(250,210,220,30);
        add(eduBox);

        //occupation
        JLabel occupationLabel=new JLabel("Occupation :");
        occupationLabel.setFont(new Font("Raleway",Font.BOLD,18));
        occupationLabel.setBounds(100,250,100,30);
        add(occupationLabel);

        occuBox=new JComboBox<>();
        occuBox.addItem("Salaried");
        occuBox.addItem("Self-Employed");
        occuBox.addItem("Bussiness");
        occuBox.addItem("Student");
        occuBox.addItem("Retired");
        occuBox.addItem("Other");

        occuBox.setBackground(new Color(252,208,76));
        occuBox.setFont(new Font("Raleway",Font.BOLD,14));
        occuBox.setBounds(250,250,220,30);
        add(occuBox);

        //pan number
        JLabel panNoLabel=new JLabel("PAN no.");
        panNoLabel.setFont(new Font("Raleway",Font.BOLD,18));
        panNoLabel.setBounds(100,290,150,30);
        add(panNoLabel);

        panField=new JTextField();
        panField.setFont(new Font("Raleway",Font.BOLD,18));
        panField.setBounds(250,290,220,30);
        add(panField);

        //adhar no
        JLabel adharLabel=new JLabel("Adhar no.");
        adharLabel.setFont(new Font("Raleway",Font.BOLD,18));
        adharLabel.setBounds(100,330,150,30);
        add(adharLabel);

        adharField=new JTextField();
        adharField.setFont(new Font("Raleway",Font.BOLD,18));
        adharField.setBounds(250,330,220,30);
        add(adharField);

        //age
        JLabel seniorLabel=new JLabel("Senior Citizen");
        seniorLabel.setFont(new Font("Raleway",Font.BOLD,18));
        seniorLabel.setBounds(100,370,150,30);
        add(seniorLabel);

        r1=new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(250,370,100,30);
        add(r1);

        r2=new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(350,370,100,30);
        add(r2);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        //check for existing account
        JLabel extAccLabel=new JLabel("Existing Account");
        extAccLabel.setFont(new Font("Raleway",Font.BOLD,18));
        extAccLabel.setBounds(100,410,150,30);
        add(extAccLabel);

        r3=new JRadioButton("Yes");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(new Color(252,208,76));
        r3.setBounds(250,410,100,30);
        add(r3);

        r4=new JRadioButton("No");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(new Color(252,208,76));
        r4.setBounds(350,410,100,30);
        add(r4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(r3);
        bg2.add(r4);

        JLabel l11=new JLabel("Form no.");
        l11.setFont(new Font("Raleway",Font.BOLD,16));
        l11.setBounds(700,10,100,30);
        add(l11);

        JLabel l12=new JLabel(formNo);
        l12.setFont(new Font("Raleway",Font.BOLD,16));
        l12.setBounds(760,10,60,30);
        add(l12);

        //next button
        nextBtn=new JButton("Next");
        nextBtn.setFont(new Font("Raleway",Font.BOLD,14));
        nextBtn.setBackground(new Color(252,208,76));
        nextBtn.setBounds(540,450,100,30);
        add(nextBtn);
        nextBtn.addActionListener(this);



    
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String rel=(String) religionBox.getSelectedItem();
        String cate=(String) catagoryBox.getSelectedItem();
        String income=incomeField.getText();
        String edu=(String) eduBox.getSelectedItem();
        String occu=(String) occuBox.getSelectedItem();
        String pan=panField.getText();
        String adhar=adharField.getText();
        String senior="";
        if(r1.isSelected()){
            senior="Yes";
        }
        else if(r2.isSelected()){
            senior="No";
        }
        else{

        }

        String extAcc="";
        if(r3.isSelected()){
            extAcc="Yes";
        }
        else if(r4.isSelected()){
            extAcc="No";
        }else{

        }
        
        try{
            if(incomeField.getText().equals("") || panField.getText().equals("") || adharField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "please fill correctly");
            }
            else{
                ConnectionDB c1=new ConnectionDB();
                String q="insert into signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+income+"','"+edu+"','"+occu+"','"+pan+"','"+adhar+"','"+senior+"','"+extAcc+"')";
                c1.statement.executeUpdate(q);
                new SignUp3(formno);
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new SignUp2("");
    }
}
