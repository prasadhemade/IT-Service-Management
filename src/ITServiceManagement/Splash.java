package ITServiceManagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Splash extends JFrame implements ActionListener {

    JTextField unTextField, pwTextField;
    JPasswordField jPasswordField;
    JButton login, back;

    Splash(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1700, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 1700, 900);
        add(label);

        JLabel heading = new JLabel("IT SERVICE MANAGEMENT");
        heading.setBounds(500, 20, 1550, 100);
        heading.setFont(new Font("Tahoma", Font.BOLD, 45));
        heading.setForeground(Color.WHITE);
        label.add(heading);

        JLabel username = new JLabel("Username :");
        username.setBounds(1000, 150, 200, 30 );
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.add(username);

        unTextField = new JTextField();
        unTextField.setBounds(1170, 150, 270, 30);
        unTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        unTextField.setForeground(Color.BLACK);
        unTextField.setBackground(new Color(190,180,250));
        label.add(unTextField);

        JLabel password = new JLabel("Password :");
        password.setBounds(1000, 200, 200, 30 );
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.add(password);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(1170, 200, 270, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jPasswordField.setForeground(Color.BLACK);
        jPasswordField.setBackground(new Color(190,180,250));
        label.add(jPasswordField);

        login = new JButton("Login");
        login.setBounds(1170, 280, 120, 30 );
        login.setForeground(Color.WHITE);
        login.setBackground(Color.DARK_GRAY);
        login.setFont(new Font("Tahoma", Font.BOLD, 17));
        login.addActionListener(this);
        label.add(login);

        back = new JButton("Back");
        back.setBounds(1320, 280, 120, 30 );
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        back.setFont(new Font("Tahoma", Font.BOLD, 17));
        back.addActionListener(this);
        label.add(back);

        setUndecorated(true);
        setSize(1700, 900);
        setLocation(110, 70);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== login){

            try {
                String username = unTextField.getText();
                String password = jPasswordField.getText();

                Conn c = new Conn();

                String query = "select * from credentials where Username = '"+username+"' and Password ='"+password+"'";
                ResultSet resultSet = c.statement.executeQuery(query);
                if (resultSet.next()){
                    new Home();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    new Splash();
                }


            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Splash();
    }


}
