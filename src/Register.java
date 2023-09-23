
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;





public class Register extends JFrame implements ActionListener {
    
    
    
    
    public static void enterRecord(String username,String password, String balance){
    try{
        FileWriter writer = new FileWriter("test.txt", true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.append(username+","+password+","+balance);
        bw.newLine();
        bw.close();
    }
    catch(Exception e){
        
    }
    
}



    
    
    
    
    
    
    JFrame rframe = new JFrame();
    JButton register;
    JButton back;
    
    JLabel title;
    JTextField balField;
    JTextField userID;
    JPasswordField password;
    JLabel uname;
    JLabel pword;
    JLabel BLabel;
    Register(){
        ImageIcon icon = new ImageIcon("icon.png");
        title = new JLabel("Registration");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setBounds(150, 80, 250, 50);
        
        uname = new JLabel("User Name:");
        uname.setBounds(120,160,90,25);
        
        pword = new JLabel("Password:");
        pword.setBounds(120,220,90,25);
        
        BLabel = new JLabel("Balance:");
        BLabel.setBounds(120,280,200,23);
                
        userID = new JTextField();
        userID.setBounds(200,160,200,25);
        
        balField = new JTextField();
        balField.setBounds(200,280,200,23);
        
        password = new JPasswordField();
        password.setBounds(200, 220, 200, 25);
        
        register = new JButton("Register");
        register.setFont(new Font("Georgia",Font.PLAIN,15));
        register.setBounds(290,350,100,30);
        register.setFocusable(false);
        
        back = new JButton("Back");
        back.setFont(new Font("Georgia",Font.PLAIN,15));
        back.setBounds(120,350,100,30);
        back.setFocusable(false);
        
        //---------ActionListener---------------
        back.addActionListener(this);
        register.addActionListener(this);
        //--------------------------------------
        rframe.setTitle("Register");
        rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rframe.setVisible(true);
        rframe.setLayout(null);
        rframe.setIconImage(icon.getImage());
        rframe.setResizable(false);
        rframe.setSize(500, 500);
        rframe.add(userID);
        rframe.add(password);
        rframe.add(balField);
        rframe.add(register);
        rframe.add(back);
        rframe.add(title);
        rframe.add(uname);
        rframe.add(pword);
        rframe.add(BLabel);
        rframe.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            MyFrame open = new MyFrame();
            rframe.dispose();
            
        }
        if(e.getSource()==register){
            enterRecord(userID.getText(),String.valueOf(password.getText()), balField.getText());
            MyFrame open = new MyFrame();
            rframe.dispose();
        }
    }
    
}
