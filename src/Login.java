
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Login extends JFrame implements ActionListener{
    
    private static Scanner input;
    
    public static String[] LoginConfirm(String username,String password){
        
        boolean found = false;
        
        String tempUsername = "";
        String tempPassword = "";
        String Balance = "";
        try {
            input = new Scanner(new File("Test.txt"));
            input.useDelimiter("[,\n]");
            
            while(input.hasNext() && !found){
                tempUsername = input.next();
                tempPassword = input.next();
                Balance = input.next();
                
                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    found = true;
                }
            }
            
            input.close();            
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        String truefalse = String.valueOf(found);
        String[] array = new String[2];
        array[0] = truefalse;
        array[1] = Balance;
        return array;
    }
        
    
    
    
    
    
    int ub1;
    
    JFrame lframe = new JFrame();
    JButton login;
    JButton back;
    
    JLabel title;
    public JTextField userIDLogin;
    JPasswordField passwordLogin;
    JLabel uname;
    JLabel pword;
    JLabel confirm;
    Login(){
        
        ImageIcon icon = new ImageIcon("icon.png");
        title = new JLabel("Login");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setBounds(210, 80, 250, 50);
        
        uname = new JLabel("User Name:");
        uname.setBounds(120,180,90,25);
        
        pword = new JLabel("Password:");
        pword.setBounds(120,240,90,25);
        
        confirm = new JLabel();
        confirm.setBounds(155,360,250,30);
        confirm.setFont(new Font("null",Font.BOLD,13));
        
        userIDLogin = new JTextField();
        userIDLogin.setBounds(200,180,200,25);
        
        passwordLogin = new JPasswordField();
        passwordLogin.setBounds(200, 240, 200, 25);
        
        login = new JButton("Login");
        login.setFont(new Font("Georgia",Font.PLAIN,15));
        login.setBounds(290,320,100,30);
        login.setFocusable(false);

        back = new JButton("Back");
        back.setFont(new Font("Georgia",Font.PLAIN,15));
        back.setBounds(120,320,100,30);
        back.setFocusable(false);

        //---------ActionListener---------------
        back.addActionListener(this);
        login.addActionListener(this);
        //--------------------------------------
        lframe.setTitle("Login");
        lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lframe.setVisible(true);
        lframe.setLayout(null);
        lframe.setIconImage(icon.getImage());
        lframe.setResizable(false);
        lframe.setSize(500, 500);
        lframe.setLocationRelativeTo(null);
        lframe.add(userIDLogin);
        lframe.add(passwordLogin);
        lframe.add(login);
        lframe.add(back);
        lframe.add(title);
        lframe.add(uname);
        lframe.add(pword);
        lframe.add(confirm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            MyFrame startpage = new MyFrame();
            lframe.dispose();
        }
        if(e.getSource()==login){
            
            //LoginConfirm(userID ,userPassword)
            
            
            String userID = userIDLogin.getText();
            String userPassword = String.valueOf(passwordLogin.getPassword());
            
                        
            boolean correctLoginPassword = Boolean.parseBoolean(LoginConfirm(userID ,userPassword)[0]);
            String ub = LoginConfirm(userID ,userPassword)[1].trim();
            
            ub1 = Integer.parseInt(ub);
            
            if(correctLoginPassword == true){
                LoggedIn login1 = new LoggedIn();
                login1.bal = ub1;
                System.out.println(login1.bal);
                confirm.setText("Logged in Successfully");
                confirm.setForeground(Color.green);
                System.out.println(ub1);
                login1.balance.setText("Your balance in Pkr is: "+ub1);
                login1.username = userIDLogin.getText();
                lframe.dispose();
                lframe.setVisible(false);
            }
            else{
                confirm.setText("Incorrect Username or Password");
                confirm.setForeground(Color.red);
            }
            
            
        }
    }
}
