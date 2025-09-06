package ITServiceManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;

public class UpdateTickets extends JFrame implements ActionListener {
    JTextField  tfEmpEmail, tfPhone, tfProblem, tfEmpId, tfAction, tfStatus;
    JTable table;
    JButton check, update, back, refresh;

    JLabel date, cstatus, lblName;
        Choice tkChoice, choice1;


    UpdateTickets(){

            getContentPane().setBackground(new Color(180,180, 250));
            setLayout(null);

            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Black.jpg"));
            Image image = imageIcon.getImage().getScaledInstance(1700, 900, Image.SCALE_DEFAULT);
            ImageIcon imageIcon1 = new ImageIcon(image);
            JLabel label = new JLabel(imageIcon1);
            label.setBounds(0, 0, 1700, 900);
            add(label);

            JLabel empId = new JLabel("Employee ID  :");
            empId.setBounds(100, 150, 200, 30 );
            empId.setForeground(Color.WHITE);
            empId.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(empId);

            tfEmpId = new JTextField();
            tfEmpId.setBounds(270, 150, 270, 30);
            tfEmpId.setFont(new Font("Tahoma", Font.PLAIN, 18));
            tfEmpId.setForeground(Color.BLACK);
            tfEmpId.setBackground(new Color(190,180,250));
            label.add(tfEmpId);

            JLabel lblTId = new JLabel("Ticket No. \t      :");
            lblTId.setBounds(100, 200, 150, 30 );
            lblTId.setForeground(Color.WHITE);
            lblTId.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblTId);

            tkChoice = new Choice();
            tkChoice.setBounds(270, 200, 270, 30);
            tkChoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
            tkChoice.setForeground(Color.BLACK);
            tkChoice.setBackground(new Color(190,180,250));
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
            empName.setBounds(100, 250, 150, 30 );
            empName.setForeground(Color.WHITE);
            empName.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(empName);

            lblName = new JLabel();

            lblName.setBounds(270, 250, 270, 30);
            lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
            lblName.setForeground(Color.WHITE);
            lblName.setBackground(new Color(190,180,250));
            label.add(lblName);


            JLabel lblEmail = new JLabel("Email ID  \t       :");
            lblEmail.setBounds(100, 300, 200, 30 );
            lblEmail.setForeground(Color.WHITE);
            lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblEmail);

            tfEmpEmail = new JTextField();
            tfEmpEmail.setBounds(270, 300, 270, 30);
            tfEmpEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
            tfEmpEmail.setForeground(Color.BLACK);
            tfEmpEmail.setBackground(new Color(190,180,250));
            label.add(tfEmpEmail);

            JLabel lblDate = new JLabel("Date \t               :");
            lblDate.setBounds(100, 350, 200, 30 );
            lblDate.setForeground(Color.WHITE);
            lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblDate);

//            Date date1 = new Date();
            date = new JLabel();
            date.setBounds(270, 350, 270, 30);
            date.setFont(new Font("Tahoma", Font.PLAIN, 18));
            date.setForeground(Color.WHITE);
            date.setBackground(new Color(190,180,250));
            label.add(date);

            JLabel lblPhone = new JLabel("Phone  \t           :");
            lblPhone.setBounds(100, 400, 200, 30 );
            lblPhone.setForeground(Color.WHITE);
            lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblPhone);

            tfPhone = new JTextField();
            tfPhone.setBounds(270, 400, 270, 30);
            tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
            tfPhone.setForeground(Color.BLACK);
            tfPhone.setBackground(new Color(190,180,250));
            label.add(tfPhone);

            JLabel lblProblem = new JLabel("Problems  \t      :");
            lblProblem.setBounds(100, 450, 200, 30 );
            lblProblem.setForeground(Color.WHITE);
            lblProblem.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblProblem);

            tfProblem = new JTextField();
            tfProblem.setBounds(270, 450, 270, 30);
            tfProblem.setFont(new Font("Tahoma", Font.PLAIN, 18));
            tfProblem.setForeground(Color.BLACK);
            tfProblem.setBackground(new Color(190,180,250));
            label.add(tfProblem);

            JLabel lblAssign = new JLabel("Assignment\t    :");
            lblAssign.setBounds(100, 500, 150, 30 );
            lblAssign.setForeground(Color.WHITE);
            lblAssign.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblAssign);

            choice1 = new Choice();
            choice1.setBounds(270, 500, 270, 30);
            choice1.setFont(new Font("Tahoma", Font.PLAIN, 18));
            choice1.setForeground(Color.BLACK);
            choice1.setBackground(new Color(190,180,250));
            label.add(choice1);

            try {
                    Conn c = new Conn();
                    String q = "select * from engineer";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                            choice1.add(resultSet.getString("Eng_Name"));
                    }
            }catch (Exception e){
                    e.printStackTrace();
            }

            JLabel lblAction = new JLabel("Action  \t           :");
            lblAction.setBounds(100, 550, 200, 30 );
            lblAction.setForeground(Color.WHITE);
            lblAction.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblAction);

            tfAction = new JTextField();
            tfAction.setBounds(270, 550, 270, 30);
            tfAction.setFont(new Font("Tahoma", Font.PLAIN, 18));
            tfAction.setForeground(Color.BLACK);
            tfAction.setBackground(new Color(190,180,250));
            label.add(tfAction);

            JLabel lblStatus = new JLabel("Status  \t           :");
            lblStatus.setBounds(100, 600, 200, 30 );
            lblStatus.setForeground(Color.WHITE);
            lblStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.add(lblStatus);

            cstatus = new JLabel("");
            cstatus.setBounds(270, 600, 270, 30 );
            cstatus.setBackground(Color.BLACK);
            cstatus.setFont(new Font("Tahoma", Font.BOLD, 16));
            cstatus.setForeground(Color.WHITE);
            label.add(cstatus);

        try {
            Conn conn = new Conn();
            String query = "select * from employee where Ticket_no = '"+tkChoice.getSelectedItem()+"'";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while (resultSet.next()){
                tfEmpId.setText(resultSet.getString("Employee_id"));
                lblName.setText(resultSet.getString("Name"));
                tfEmpEmail.setText(resultSet.getString("Email"));
                date.setText(resultSet.getString("Date"));
                tfPhone.setText(resultSet.getString("Phone"));
                tfProblem.setText(resultSet.getString("Problems"));
                tfAction.setText(resultSet.getString("Action"));
                cstatus.setText(resultSet.getString("Status"));

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
                        lblName.setText(resultSet.getString("Name"));
                        tfEmpEmail.setText(resultSet.getString("Email"));
                        date.setText(resultSet.getString("Date"));
                        tfPhone.setText(resultSet.getString("Phone"));
                        tfProblem.setText(resultSet.getString("Problems"));
                        tfAction.setText(resultSet.getString("Action"));
                        cstatus.setText(resultSet.getString("Status"));

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        check = new JButton("CHECK");
            check.setBounds(200, 650, 150, 30 );
            check.setForeground(Color.WHITE);
            check.setBackground(Color.DARK_GRAY);
            check.setFont(new Font("Tahoma", Font.BOLD, 17));
            check.addActionListener(this);
            label.add(check);

            update = new JButton("UPDATE  ");
            update.setBounds(390, 650, 150, 30);
            update.setFont(new Font("Tahoma", Font.BOLD, 17));
            update.setForeground(Color.WHITE);
            update.setBackground(Color.DARK_GRAY);
            update.addActionListener(this);
            label.add(update);

        refresh = new JButton("REFRESH");
        refresh.setBounds(200, 700, 150, 30);
        refresh.setFont(new Font("Tahoma", Font.BOLD, 17));
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(Color.DARK_GRAY);
        refresh.addActionListener(this);
        label.add(refresh);

            back = new JButton("Back");
            back.setBounds(390, 700, 150, 30);
            back.setFont(new Font("Tahoma", Font.BOLD, 17));
            back.setForeground(Color.WHITE);
            back.setBackground(Color.DARK_GRAY);
           back.addActionListener(this);
            label.add(back);

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

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource()== check){
                        String ticket = tkChoice.getSelectedItem();
                       String q = "select * from employee where Ticket_no = '"+ticket+"'";
                       // String engName = choice1.getSelectedItem();

                        try {
                                Conn c = new Conn();
                                ResultSet resultSet = c.statement.executeQuery(q);
                                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                        }catch (Exception E){
                                E.printStackTrace();
                        }
                }else if (e.getSource()== update){

                        try {
                              Conn c = new Conn();
                              String q = tkChoice.getSelectedItem();
                                String EngName = choice1.getSelectedItem();
                                String action = tfAction.getText();
                                String ph = tfPhone.getText();

                                c.statement.executeUpdate("update employee set Phone = '"+ph+"', Action = '"+action+"', Assignment = '"+EngName+"' where Ticket_no = '"+q+"'");
                                JOptionPane.showMessageDialog(null, "Data updated successfully");

                                try{
                                        String query = tkChoice.getSelectedItem();
                                        String q1 = "select * from employee where Ticket_no = '"+query+"'";
                                        ResultSet resultSet = c.statement.executeQuery(q1);
                                        table.setModel(DbUtils.resultSetToTableModel(resultSet));
                                }catch (Exception E){
                                        E.printStackTrace();
                                }

                        }catch (Exception E){
                                E.printStackTrace();
                        }
                }else if (e.getSource()== refresh){
                          try{
                              Conn conn = new Conn();
                              String q = "select * from employee";
                              ResultSet resultSet = conn.statement.executeQuery(q);
                              table.setModel(DbUtils.resultSetToTableModel(resultSet));

                          }catch (Exception E){
                              E.printStackTrace();
                          }
                      }else {
                          setVisible(false);
                          new Home();
                      }
                }

    public static void main(String[] args) {
        new UpdateTickets();
    }


}
