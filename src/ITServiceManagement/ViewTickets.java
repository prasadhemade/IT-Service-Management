package ITServiceManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewTickets extends JFrame implements ActionListener {

    Choice choice, choice2, choice3;
    JButton search, search2, search3, search4, update, print, back;
    JTable table;
    JComboBox cbStatus, cbStatus2;

    ViewTickets(){

        getContentPane().setBackground(new Color(180,180, 250));
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Black.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 1500, 800);
        add(label);

        table = new JTable();
        table.setBounds(400, 100, 1000, 600);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("serif", Font.PLAIN, 15));
        table.setForeground(Color.BLACK);
        label.add(table);

        try {
            Conn c = new Conn();
            String q = "select * from employee";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel searchlbl = new JLabel("Search by Employee ID : ");
        searchlbl.setBounds(50, 100, 220, 30);
        searchlbl.setForeground(Color.WHITE);
        searchlbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(searchlbl);

        choice = new Choice();
        choice.setBounds(50, 130, 150, 40 );
        choice.setBackground(new Color(180,180,250));
        choice.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){

                choice.add(resultSet.getString("Employee_id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(400, 100, 1000, 600);
        label.add(jsp);

        JLabel searchlbl2 = new JLabel("Search by Employee Name : ");
        searchlbl2.setBounds(50, 180, 250, 30);
        searchlbl2.setForeground(Color.WHITE);
        searchlbl2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(searchlbl2);


        choice2 = new Choice();
        choice2.setBounds(50, 210, 170, 40 );
        choice2.setBackground(new Color(180,180,250));
        choice2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(choice2);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choice2.add(resultSet.getString("Name"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel searchlbl3 = new JLabel("Search by Status : ");
        searchlbl3.setBounds(50, 250, 180, 30);
        searchlbl3.setForeground(Color.WHITE);
        searchlbl3.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(searchlbl3);

        String[] status = {"None","Pending", "Completed"};
        cbStatus = new JComboBox(status);
        cbStatus.setBounds(50, 280, 170, 25 );
        cbStatus.setBackground(new Color(180,180,250));
        cbStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(cbStatus);

        JLabel searchlbl4 = new JLabel("Search All : ");
        searchlbl4.setBounds(50, 320, 180, 30);
        searchlbl4.setForeground(Color.WHITE);
        searchlbl4.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(searchlbl4);

        String[] status1 = {"All"};
        cbStatus2 = new JComboBox(status1);
        cbStatus2.setBounds(50, 350, 170, 25 );
        cbStatus2.setBackground(new Color(180,180,250));
        cbStatus2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(cbStatus2);

        search = new JButton("Search");
        search.setBounds(240, 130, 120, 25);
        search.setBackground(Color.DARK_GRAY);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma", Font.BOLD, 14));
        search.addActionListener(this);
        label.add(search);

        search2 = new JButton("Search");
        search2.setBounds(240, 210, 120, 25);
        search2.setBackground(Color.DARK_GRAY);
        search2.setForeground(Color.WHITE);
        search2.setFont(new Font("Tahoma", Font.BOLD, 14));
        search2.addActionListener(this);
        label.add(search2);

        search3 = new JButton("Search");
        search3.setBounds(240, 283, 120, 25);
        search3.setBackground(Color.DARK_GRAY);
        search3.setForeground(Color.WHITE);
        search3.setFont(new Font("Tahoma", Font.BOLD, 14));
        search3.addActionListener(this);
        label.add(search3);

        search4 = new JButton("Search");
        search4.setBounds(240, 350, 120, 25);
        search4.setBackground(Color.DARK_GRAY);
        search4.setForeground(Color.WHITE);
        search4.setFont(new Font("Tahoma", Font.BOLD, 14));
        search4.addActionListener(this);
        label.add(search4);

        print = new JButton("Print");
        print.setBounds(100, 460, 150, 30);
        print.setBackground(Color.DARK_GRAY);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Tahoma", Font.BOLD, 16));
        print.addActionListener(this);
        label.add(print);

        update = new JButton("Update");
        update.setBounds(100, 520, 150, 30);
        update.setBackground(Color.DARK_GRAY);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 16));
        update.addActionListener(this);
        label.add(update);

        back = new JButton("Back");
        back.setBounds(100, 580, 150, 30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.addActionListener(this);
        label.add(back);


        setUndecorated(true);
        setSize(1500, 800);
        setLocation(200, 120);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource()== search) {
                String query = "select * from employee where Employee_id = '" + choice.getSelectedItem() + "'";

                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(query);

                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (Exception E) {
                    E.printStackTrace();
                }

            } else if (e.getSource()== search2) {
                String query = "select * from employee where Name = '" + choice2.getSelectedItem() + "'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }else if (e.getSource()== search3) {
                // String cmStatus = (String) cbStatus.getSelectedItem();
                String query = "select * from employee where Status = '" + cbStatus.getSelectedItem() + "'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));


                } catch (Exception E) {
                    E.printStackTrace();
                }
            }else if (e.getSource()== search4){
                try {
                    Conn conn = new Conn();
                    ResultSet resultSet= conn.statement.executeQuery("select * from employee");
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }



            }else if (e.getSource()== print){

                try{
                    table.print();
                }catch (Exception E){
                    E.printStackTrace();
                }
            } else if (e.getSource()== update) {
                new UpdateTickets();
                setVisible(false);
            }else {
                setVisible(false);
                new Home();
            }
    }
    public static void main(String[] args) {
        new ViewTickets();
    }


}
