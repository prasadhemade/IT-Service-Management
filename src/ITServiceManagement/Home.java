package ITServiceManagement;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5;

    Home(){

        getContentPane().setBackground(new Color(180,180, 250));
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Home.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1700, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 1700, 900);
        add(label);

        b1 = new JButton("Create Ticket");
        b1.setBounds(1170, 100, 150, 40);
        b1.setFont(new Font("Tahoma", Font.BOLD, 17));
        b1.setBackground(new Color(100,100, 250));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("View Tickets");
        b2.setBounds(1350, 100, 150, 40);
        b2.setFont(new Font("Tahoma", Font.BOLD, 17));
        b2.setBackground(new Color(100,100, 250));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Updates");
        b3.setBounds(1170, 160, 150, 40);
        b3.setFont(new Font("Tahoma", Font.BOLD, 17));
        b3.setBackground(new Color(100,100, 250));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Resolved");
        b4.setBounds(1350, 160, 150, 40);
        b4.setFont(new Font("Tahoma", Font.BOLD, 17));
        b4.setBackground(new Color(100,100, 250));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Log Out");
        b5.setBounds(1270, 230, 150, 40);
        b5.setFont(new Font("Tahoma", Font.BOLD, 17));
        b5.setBackground(new Color(100,100, 250));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);


        setUndecorated(true);
        setSize(1700, 900);
        setLocation(110, 70);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            new Create_Ticket();
            setVisible(false);
        }else if (e.getSource()== b2){
            new ViewTickets();
            setVisible(false);
        }else if (e.getSource()== b3){
            new UpdateTickets();
            setVisible(false);
        }else if(e.getSource()== b4){
            new ResolvedTickets();
            setVisible(false);
        }else {
            new Splash();
            setVisible(false);
        }

        }


    public static void main(String[] args) {
        new Home();
    }


}
