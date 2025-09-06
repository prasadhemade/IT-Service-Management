package ITServiceManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class ResolvedTickets extends JFrame{

    JTextField  tfPhone, tfProblem, tfEmpId, tfAction;
    JTable table;
    JButton check, resolved, delete, refresh, back;

    JLabel date,  lblAssignment;
    Choice choice, tkChoice;
    JComboBox cstatus;

    ResolvedTickets() {


        getContentPane().setBackground(new Color(180, 180, 250));
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Black.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1700, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 1700, 900);
        add(label);

        JLabel empId = new JLabel("Employee ID  :");
        empId.setBounds(100, 150, 200, 30);
        empId.setForeground(Color.WHITE);
        empId.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(empId);

        tfEmpId = new JTextField();
        tfEmpId.setBounds(270, 150, 270, 30);
        tfEmpId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfEmpId.setForeground(Color.BLACK);
        tfEmpId.setBackground(new Color(190, 180, 250));
        label.add(tfEmpId);

        JLabel lblTId = new JLabel("Ticket No. \t      :");
        lblTId.setBounds(100, 200, 150, 30);
        lblTId.setForeground(Color.WHITE);
        lblTId.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblTId);


        tkChoice = new Choice();
        tkChoice.setBounds(270, 200, 270, 30);
        tkChoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tkChoice.setForeground(Color.BLACK);
        tkChoice.setBackground(new Color(190, 180, 250));
        label.add(tkChoice);

        try {
            Conn conn = new Conn();
            String q = "select * from employee";
            ResultSet resultSet = conn.statement.executeQuery(q);
            while (resultSet.next()){
                tkChoice.add(resultSet.getString("Ticket_no"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel empName = new JLabel("Name  \t            :");
        empName.setBounds(100, 250, 150, 30);
        empName.setForeground(Color.WHITE);
        empName.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(empName);

        JLabel lblEmp = new JLabel();
        lblEmp.setBounds(270, 250, 270, 30);
        lblEmp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmp.setForeground(Color.WHITE);
        lblEmp.setBackground(Color.BLACK);
        label.add(lblEmp);

        JLabel lblEmail = new JLabel("Email ID  \t       :");
        lblEmail.setBounds(100, 300, 200, 30);
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblEmail);

        JLabel lblEmpEmail = new JLabel();
        lblEmpEmail.setBounds(270, 300, 270, 30);
        lblEmpEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmpEmail.setForeground(Color.WHITE);
        lblEmpEmail.setBackground(new Color(190, 180, 250));
        label.add(lblEmpEmail);

        JLabel lblDate = new JLabel("Date \t               :");
        lblDate.setBounds(100, 350, 200, 30);
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblDate);

        Date date1 = new Date();

        date = new JLabel("" +date1);
        date.setBounds(270, 350, 270, 30);
        date.setFont(new Font("Tahoma", Font.PLAIN, 18));
        date.setForeground(Color.WHITE);
        date.setBackground(new Color(190, 180, 250));
        label.add(date);

        JLabel lblPhone = new JLabel("Phone  \t           :");
        lblPhone.setBounds(100, 400, 200, 30);
        lblPhone.setForeground(Color.WHITE);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(270, 400, 270, 30);
        tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfPhone.setForeground(Color.BLACK);
        tfPhone.setBackground(new Color(190, 180, 250));
        label.add(tfPhone);

        JLabel lblProblem = new JLabel("Problems  \t      :");
        lblProblem.setBounds(100, 450, 200, 30);
        lblProblem.setForeground(Color.WHITE);
        lblProblem.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblProblem);

        tfProblem = new JTextField();
        tfProblem.setBounds(270, 450, 270, 30);
        tfProblem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfProblem.setForeground(Color.BLACK);
        tfProblem.setBackground(new Color(190, 180, 250));
        label.add(tfProblem);

        JLabel lblAssign = new JLabel("Assignment\t    :");
        lblAssign.setBounds(100, 500, 150, 30);
        lblAssign.setForeground(Color.WHITE);
        lblAssign.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblAssign);

        lblAssignment = new JLabel();
        lblAssignment.setBounds(270, 500, 270, 30);
        lblAssignment.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAssignment.setForeground(Color.WHITE);
        lblAssignment.setBackground(new Color(190, 180, 250));
        label.add(lblAssignment);


        JLabel lblAction = new JLabel("Action  \t           :");
        lblAction.setBounds(100, 550, 200, 30);
        lblAction.setForeground(Color.WHITE);
        lblAction.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblAction);

        tfAction = new JTextField();
        tfAction.setBounds(270, 550, 270, 30);
        tfAction.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfAction.setForeground(Color.BLACK);
        tfAction.setBackground(new Color(190, 180, 250));
        label.add(tfAction);

        JLabel lblStatus = new JLabel("Status  \t           :");
        lblStatus.setBounds(100, 600, 200, 30);
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblStatus);

        String[] cstatus1 = {"None", "Pending", "Completed"};
        cstatus = new JComboBox(cstatus1);
        cstatus.setBounds(270, 600, 270, 30);
        cstatus.setBackground(new Color(180, 180, 250));
        cstatus.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.add(cstatus);

        try {
        Conn conn = new Conn();
        String query = "select * from employee where Ticket_no = '"+tkChoice.getSelectedItem()+"'";
        ResultSet resultSet = conn.statement.executeQuery(query);
        while (resultSet.next()){
            tfEmpId.setText(resultSet.getString("Employee_id"));
            lblEmp.setText(resultSet.getString("Name"));
            lblEmpEmail.setText(resultSet.getString("Email"));
            tfPhone.setText(resultSet.getString("Phone"));
            tfProblem.setText(resultSet.getString("Problems"));
            tfAction.setText(resultSet.getString("Action"));
            lblAssignment.setText(resultSet.getString("Assignment"));
        }

        }catch (Exception e){
            e.printStackTrace();
        }

        tkChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn conn = new Conn();
                    String query = "select * from employee where Ticket_no = '"+tkChoice.getSelectedItem()+"'";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    while (resultSet.next()){
                        tfEmpId.setText(resultSet.getString("Employee_id"));
                        lblEmp.setText(resultSet.getString("Name"));
                        lblEmpEmail.setText(resultSet.getString("Email"));
                        tfPhone.setText(resultSet.getString("Phone"));
                        tfProblem.setText(resultSet.getString("Problems"));
                        tfAction.setText(resultSet.getString("Action"));
                        lblAssignment.setText(resultSet.getString("Assignment"));
}
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        check = new JButton("CHECK");
        check.setBounds(200, 650, 150, 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.DARK_GRAY);
        check.setFont(new Font("Tahoma", Font.BOLD, 17));
        label.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where Ticket_no = '"+tkChoice.getSelectedItem()+"'");
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        resolved = new JButton("RESOLVED");
        resolved.setBounds(200, 700, 150, 30);
        resolved.setFont(new Font("Tahoma", Font.BOLD, 17));
        resolved.setForeground(Color.WHITE);
        resolved.setBackground(Color.DARK_GRAY);
        label.add(resolved);
        resolved.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String n1 = tkChoice.getSelectedItem();
                    String action = tfAction.getText();
                    String dt = date.getText();
                    String cs = (String) cstatus.getSelectedItem();
                    c.statement.executeUpdate("update employee set Action = '"+action+"', Status = '"+cs+"', Out_Time = '"+dt+"' where Ticket_no = '"+n1+"'");
                   JOptionPane.showMessageDialog(null, "This ticket has been resolved successfully");


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        refresh = new JButton("REFRESH");
        refresh.setBounds(390, 650, 150, 30);
        refresh.setFont(new Font("Tahoma", Font.BOLD, 17));
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(Color.DARK_GRAY);
        label.add(refresh);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    String query = "select * from employee";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(390, 700, 150, 30);
        delete.setFont(new Font("Tahoma", Font.BOLD, 17));
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.DARK_GRAY);
        label.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "Please be safe to delete records");

                try {
                    Conn conn = new Conn();
                    String q = tkChoice.getSelectedItem();
                    String q1 = "delete from employee where Ticket_no = '"+q+"'";
                    conn.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Record deleted successfully");
                    conn.connection.commit();

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        back= new JButton("BACK");
        back.setBounds(300, 750, 150, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 17));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        label.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                setVisible(false);
            }
        });

        table = new JTable();
        table.setBounds(600, 150, 1000, 600);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("serif", Font.BOLD, 15));
        table.setForeground(Color.BLACK);
        label.add(table);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(600, 150, 1000, 600);
        label.add(jsp);


        setUndecorated(true);
        setSize(1700, 900);
        setLocation(110, 70);
        setVisible(true);
    }


    public static void main(String[] args) {
        new ResolvedTickets();

    }


}
