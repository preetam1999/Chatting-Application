package chatting.application;

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class server extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea ar1;
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    server(){
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);
        
        ImageIcon pre1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
        Image pre2 = pre1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon pre3 = new ImageIcon(pre2); 
        JLabel a1 = new JLabel(pre3); 
        a1.setBounds(5, 17, 30, 30);
        p1.add(a1);
        
        a1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        
        ImageIcon pre4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
        Image pre5 = pre4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon pre6 = new ImageIcon(pre5); 
        JLabel a2 = new JLabel(pre6); 
        a2.setBounds(40, 5, 60, 60);
        p1.add(a2);
        
        ImageIcon pre7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
        Image pre8 = pre7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon pre9 = new ImageIcon(pre8); 
        JLabel a5 = new JLabel(pre9); 
        a5.setBounds(300, 20, 35, 30);
        p1.add(a5);
        
        ImageIcon pre10 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
        Image pre11 = pre10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon pre12 = new ImageIcon(pre11); 
        JLabel a6 = new JLabel(pre12); 
        a6.setBounds(350, 20, 35, 30);
        p1.add(a6);
        
        ImageIcon pre13 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
        Image pre14 = pre13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon pre15 = new ImageIcon(pre14); 
        JLabel a7 = new JLabel(pre15); 
        a7.setBounds(400, 20, 13, 25);
        p1.add(a7);
        
        JLabel a3 = new JLabel("Gaitonde");
        a3.setFont(new Font("SAN-SERIF",Font.BOLD,18));
        a3.setForeground(Color.white);
        a3.setBounds(110, 15, 100, 18);
        p1.add(a3);
        
        JLabel a4 = new JLabel("Active Now");
        a4.setFont(new Font("SAN-SERIF",Font.PLAIN,14));
        a4.setForeground(Color.white);
        a4.setBounds(110, 35, 100, 20);
        p1.add(a4);
        
        t1= new JTextField();
        t1.setBounds(5, 655, 310, 40);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN, 16));
        add(t1);
        
        b1 = new JButton("Send");
        b1.setBounds(320, 655, 123, 40);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        b1.addActionListener(this);
        add(b1);
        
        ar1 = new JTextArea();
        ar1.setBounds(5,75,440,575);
        ar1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        ar1.setEditable(false);
        ar1.setLineWrap(true);
        ar1.setWrapStyleWord(true);
        add(ar1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(450,700);
        setLocation(400,200);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String out = t1.getText();
            ar1.setText(ar1.getText() + "\n\t\t\t" + out);
            dout.writeUTF(out);
            t1.setText("");
        }catch(Exception e){}
    }
    public static void main(String[] args) {
        new server().setVisible(true);
        String msginput = "";
        try{
            skt = new ServerSocket(6001);
            s=skt.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            msginput = din.readUTF();
            ar1.setText(ar1.getText()+"\n"+msginput);
            skt.close();
            s.close();
            
        }catch(Exception e){
            
        }
    }
}

