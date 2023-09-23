
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoggedIn extends JFrame implements ActionListener {            
    
    
    private static Scanner input;
    
    
    
    public static void editRecord(String editTerm,int newBalance ){
        String filepath = "test.txt";
        String tempfile = "temp.txt";
        File oldfile = new File(filepath);
        File newfile = new File(tempfile);
        String Username = "";
        String Password = "";
        String  Balance = "";
        try{
            FileWriter fw = new FileWriter(tempfile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            input = new Scanner(new File(filepath));
            input.useDelimiter("[,\n]");
            
            while(input.hasNext()){
                Username = input.next();
                Password = input.next();
                Balance = input.next();
                if(Username.equals(editTerm)){
                    pw.println(Username+","+Password+","+newBalance);
                }
                else{
                    pw.println(Username+","+Password+","+Balance);
                }
                
            }
            input.close();
            pw.flush();
            pw.close();
            oldfile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);
            
            
        }
        catch(Exception e){
            
        }
    }
    
    
    
    
    
    
    
    
    String username;
    int bal;
    
    double convertedBal;
    GridBagConstraints gbc = new GridBagConstraints();
    DecimalFormat numberFormat;
    JFrame mframe = new JFrame();
    
    
    
    JLabel welcome;
    JLabel balance;
    JLabel convertBal;
    JButton Deposit;
    JButton Withdraw;
    JButton Back;
    JTextField withdraw_amount;
    JTextField deposit_amount;
    JTextArea update;
    JScrollPane scroll;
    
    JRadioButton pkr;
    JRadioButton dollar;
    JRadioButton pound;
    JRadioButton euro;
    JRadioButton ringgit;
    JRadioButton yen;
    
    LoggedIn(){
        
        
        
        
        ImageIcon icon = new ImageIcon("icon.png");
        
        
        
        JPanel panelm = new JPanel();
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        
        
        panelm.setBackground(Color.pink);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.yellow);
        
        panel1.setPreferredSize(new Dimension(100,200));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        
        //=====sub panels of panel m=====
        JPanel panelm0 = new JPanel();
        JPanel panelm1 = new JPanel();
        JPanel panelm2 = new JPanel();
        JPanel panelm3 = new JPanel();
        JPanel panelm4 = new JPanel();
        
        
        panelm0.setBackground(Color.white);
        panelm1.setBackground(Color.white);
        panelm2.setBackground(Color.white);
        panelm3.setBackground(Color.LIGHT_GRAY);
        panelm4.setBackground(Color.DARK_GRAY);
        
        
        panelm0.setPreferredSize(new Dimension(100,100));
        panelm1.setPreferredSize(new Dimension(100,120));
        panelm2.setPreferredSize(new Dimension(100,320));
        panelm3.setPreferredSize(new Dimension(100,100));
        panelm4.setPreferredSize(new Dimension(100,100));
        
        
        //==============radio buttons======================
        pkr = new JRadioButton("Pakistani Rupee");
        dollar = new JRadioButton("Dollar");
        pound = new JRadioButton("Pound");
        euro = new JRadioButton("Euro");
        yen = new JRadioButton("Yen");
        ringgit = new JRadioButton("Ringgit");
        //-------------------------------------------------
        
        
                
        
        
        
        welcome = new JLabel("Welcome to your Bank Account");
        welcome.setFont(new Font("Georgia", Font.BOLD, 40));
        
        balance = new JLabel("Your balance in Pkr is: "+bal);
        balance.setFont(new Font("Georgia", Font.BOLD, 20));
        
        convertBal = new JLabel ();
        convertBal.setFont(new Font("Georgia", Font.BOLD, 18));
        deposit_amount = new JTextField();
        withdraw_amount = new JTextField();
        
        Deposit = new JButton("Deposit Cash");
        Deposit.setFocusable(false);
        
        
        Withdraw = new JButton("Withdraw Cash");
        Withdraw.setFocusable(false);
        
        Back = new JButton("Back");
        Back.setFocusable(false);
        
        update = new JTextArea();
        scroll = new JScrollPane(update);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        mframe.setTitle("Welcome");
        //====================radio buttons=======================
        ButtonGroup grp = new ButtonGroup();
        grp.add(pkr);
        grp.add(yen);
        grp.add(pound);
        grp.add(dollar);
        grp.add(euro);
        grp.add(ringgit);
        grp.clearSelection();
        
        
        pkr.setBackground(Color.white);
        dollar.setBackground(Color.white);
        pound.setBackground(Color.white);
        euro.setBackground(Color.white);
        yen.setBackground(Color.white);
        ringgit.setBackground(Color.white);
        
        pkr.setFocusable(false);
        dollar.setFocusable(false);
        pound.setFocusable(false);
        yen.setFocusable(false);
        ringgit.setFocusable(false);
        euro.setFocusable(false);
        //========================================================
        
        panel1.setBorder(new EmptyBorder(140, 0, 0, 0));
        panel1.add(welcome);
        //---------------panelm add-----------------
        panelm.setLayout(new BorderLayout());
        panelm.add(panelm0, BorderLayout.CENTER);
        panelm.add(panelm1, BorderLayout.NORTH);
        panelm.add(panelm2, BorderLayout.SOUTH);
        //panelm.add(panelm3, BorderLayout.EAST);
        //panelm.add(panelm4, BorderLayout.WEST);

        //---------------panelm add-----------------
        panelm1.setBorder(new EmptyBorder(40, 0, 0, 0));
        panelm1.setLayout(new BoxLayout(panelm1, BoxLayout.Y_AXIS));
        balance.setAlignmentX(CENTER_ALIGNMENT);
        panelm1.add(balance);
        convertBal.setAlignmentX(CENTER_ALIGNMENT);
        panelm1.add(convertBal);
        convertBal.setVisible(false);
        JPanel conpanel = new JPanel();
        panelm1.add(conpanel);
        //-------------conversion radio buttons panel--------------------------
        conpanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        conpanel.setBackground(Color.white);
        conpanel.setLayout(new BoxLayout(conpanel, BoxLayout.X_AXIS));
        
        
        conpanel.add(pkr);
        conpanel.add(dollar);
        conpanel.add(pound);
        conpanel.add(euro);
        conpanel.add(yen);
        conpanel.add(ringgit);
        
        //------------locations---------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        panelm0.setLayout(new GridBagLayout());
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        panelm0.add(new JLabel("Enter Amount to be Deposited"), gbc);
        gbc.weightx = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill =  GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panelm0.add(deposit_amount, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelm0.add(Deposit, gbc);//button
        //-----------------row 2----------------------------
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        panelm0.add(new JLabel("Enter Amount to be Withdrawn"), gbc);
        gbc.weightx = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill =  GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panelm0.add(withdraw_amount, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelm0.add(Withdraw, gbc);//button
                //==================row 3========================
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridheight = 0;
        gbc.gridwidth = 1;

        panelm0.add(Back,gbc);
        //---------------panelm2 add-----------------
        update.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        update.setEditable(false);
        panelm2.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 0;
        gbc.gridwidth = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        panelm2.add(scroll, gbc);
        update.setForeground(Color.black);
        update.setBackground(Color.LIGHT_GRAY);
        //=================ActionListener====================
        Withdraw.addActionListener(this);
        Deposit.addActionListener(this);
        Back.addActionListener(this);
        dollar.addActionListener(this);
        yen.addActionListener(this);
        ringgit.addActionListener(this);
        euro.addActionListener(this);
        pound.addActionListener(this);
        pkr.addActionListener(this);
        //--------------------------------------------
        mframe.setLayout(new BorderLayout());
        mframe.getContentPane().setBackground(Color.white);
        mframe.setSize(1000, 1000);
        mframe.setIconImage(icon.getImage());
        mframe.setLocationRelativeTo(null);
        mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mframe.add(panelm, BorderLayout.CENTER);
        mframe.add(panel1, BorderLayout.NORTH);
        //mframe.add(panel2, BorderLayout.SOUTH);
        //mframe.add(panel3, BorderLayout.EAST);
        //mframe.add(panel4, BorderLayout.WEST);
        mframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            mframe.dispose();
            MyFrame frame = new MyFrame();
        }
        if(e.getSource()==Deposit){
            try{
                int dep = Integer.parseInt(deposit_amount.getText());
                
                deposit_amount.setText("");
                System.out.println("Total Balance: "+bal);
                //balance.setText("Your balance is: Pkr "+bal);
                if(dep<0){
                    System.out.println("Deposit amount is negative");
                    update.append("\nDeposit amount is negative");
                    balance.setText("Your balance is: Pkr "+bal);
                }
                else{
                    bal = bal + dep;
                    balance.setText("Your Balance is: "+bal);
                    update.append("\nDeposited amount: "+dep);
                    update.append("\nTotal Balance is: "+bal);
                    balance.setText("Your balance in Pkr is: "+bal);
                    editRecord(username,bal);
                }
            }
            catch(Exception ex){
                update.append("\nEnter a number");
                deposit_amount.setText("");
            }
            
             
        }
        if(e.getSource()==Withdraw){
            try{
                int with = Integer.parseInt(withdraw_amount.getText());
                withdraw_amount.setText("");
                
                if(with>bal){
                    update.append("\nWithdrawal amount is greater than total balance");
                    System.out.println("Withdrawal amount is greater than total balance");
                }
                else{
                    bal = bal - with;
                    System.out.println("Total Balance: "+bal);
                    update.append("\nWithdrawn amount is: "+with);
                    update.append("\nTotal Balance is: "+bal);
                    balance.setText("Your balance in Pkr is: "+bal);
                    editRecord(username,bal);
                }
            }
            catch(Exception ex){
                update.append("\nEnter a number");
                withdraw_amount.setText("");
            }
        }
        
        //---------------------------------------------------------------------------------------------------------------
        if(e.getSource()==pkr){
            CurrencyConverter convert = new CurrencyConverter();
            convertedBal = convert.Pkr(bal);
            numberFormat = new DecimalFormat("#.00");
            convertBal.setText("Your Balance is: "+numberFormat.format(convertedBal)+" pkr");
            convertBal.setVisible(true);
            System.out.println("Your Balance is: "+numberFormat.format(convertedBal)+" pkr");
            update.append("\nYour Balance is: "+numberFormat.format(convertedBal)+" pkr");
            
        }
        if(e.getSource()==yen){
            CurrencyConverter convert = new CurrencyConverter();
            convertedBal = convert.PkrtoYen(bal);
            numberFormat = new DecimalFormat("#.00");
            
            convertBal.setText("Your Balance is: "+numberFormat.format(convertedBal)+" Yen");
            convertBal.setVisible(true);
            System.out.println("Your Balance is: "+numberFormat.format(convertedBal)+" Yen");
            update.append("\nYour Balance is: "+numberFormat.format(convertedBal)+" Yen");
            }
        if(e.getSource()==dollar){
            CurrencyConverter convert = new CurrencyConverter();
            convertedBal = convert.PkrtoUsd(bal);
            numberFormat = new DecimalFormat("#.00");
            
            convertBal.setText("Your Balance is: "+numberFormat.format(convertedBal)+" Dollars");
            convertBal.setVisible(true);
            System.out.println("Your Balance is: "+numberFormat.format(convertedBal)+" Dollars");
            update.append("\nYour Balance is: "+numberFormat.format(convertedBal)+" Dollars");
        }
        if(e.getSource()==ringgit){
            CurrencyConverter convert = new CurrencyConverter();
            convertedBal = convert.PkrtoRinggitt(bal);
            numberFormat = new DecimalFormat("#.00");
            
            convertBal.setText("Your Balance is: "+numberFormat.format(convertedBal)+" Ringgitt");
            convertBal.setVisible(true);
            System.out.println("Your Balance is: "+numberFormat.format(convertedBal)+" Ringgitt");
            update.append("\nYour Balance is: "+numberFormat.format(convertedBal)+" Ringgitt");
        }
        if(e.getSource()==pound){
            CurrencyConverter convert = new CurrencyConverter();
            convertedBal = convert.PkrtoPound(bal);
            numberFormat = new DecimalFormat("#.00");
            
            convertBal.setText("Your Balance is: "+numberFormat.format(convertedBal)+" Pounds");
            convertBal.setVisible(true);
            System.out.println("Your Balance is: "+numberFormat.format(convertedBal)+" Pounds");
            update.append("\nYour Balance is: "+numberFormat.format(convertedBal)+" Pounds");
        }
        if(e.getSource()==euro){
            CurrencyConverter convert = new CurrencyConverter();
            convertedBal = convert.PkrtoEuro(bal);
            numberFormat = new DecimalFormat("#.00");
            
            convertBal.setText("Your Balance is: "+numberFormat.format(convertedBal)+" Euro");
            convertBal.setVisible(true);
            System.out.println("Your Balance is: "+numberFormat.format(convertedBal)+" Euro");
            update.append("\nYour Balance is: "+numberFormat.format(convertedBal)+" Euro");
        }
    }
}
