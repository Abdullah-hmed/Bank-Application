import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class MyFrame extends JFrame implements ActionListener{
    JButton register;
    JButton login;
    MyFrame(){
        ImageIcon icon = new ImageIcon("icon.png");
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("image.png");
        label.setIcon(image);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        
        JPanel panel1 = new JPanel();
        
        
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.white);
        panel1.setPreferredSize(new Dimension(100, 700));
        
        JPanel panel2 = new JPanel();
        
        
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,150,50));
        panel2.setBackground(Color.white);
        panel2.setPreferredSize(new Dimension(100, 200));
        //----------------buttons--------------------
        register = new JButton("Register");
        register.setFont(new Font("Georgia",Font.PLAIN ,35));
        register.setFocusable(false);
        login = new JButton("Login");
        login.setFont(new Font("Georgia",Font.PLAIN ,35));
        login.setFocusable(false);
        //--------actiionlistener--------------
        register.addActionListener(this);
        login.addActionListener(this);
        
        //add shit here
        this.setTitle("Bank Application");
        this.getContentPane().setBackground(Color.white);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(panel1,BorderLayout.CENTER);
        this.add(panel2,BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon.getImage());
        panel1.add(label);
        panel2.add(register);
        panel2.add(login);
        this.setVisible(true);
        
    }//main end

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==register){
            Register reg = new Register();
            this.dispose();
        }
        if(e.getSource()==login){
            Login login = new Login();
            this.dispose();
        }
    }
}//class end