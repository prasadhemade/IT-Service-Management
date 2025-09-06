package ITServiceManagement;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class Create_Ticket extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField  tfEmpName, tfEmpEmail, tfPhone, tfProblem, tfEmpId;
    JTable table;
    JButton submit, back;
    JPanel panel;
    JLabel date, lblTicketId, empNameOp;


    Create_Ticket(){

        getContentPane().setBackground(new Color(180,180, 250));
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Black.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1700, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 1700, 900);
        add(label);

        JLabel empId = new JLabel("Employee ID  :");
        empId.setBounds(100, 200, 200, 30 );
        empId.setForeground(Color.WHITE);
        empId.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(empId);

        tfEmpId = new JTextField();
        tfEmpId.setBounds(270, 200, 270, 30);
        tfEmpId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfEmpId.setForeground(Color.BLACK);
        tfEmpId.setBackground(new Color(190,180,250));
        label.add(tfEmpId);

        JLabel lblTId = new JLabel("Ticket No. \t      :");
        lblTId.setBounds(100, 250, 200, 30 );
        lblTId.setForeground(Color.WHITE);
        lblTId.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblTId);

        lblTicketId = new JLabel("" +number);
        lblTicketId.setBounds(270, 250, 270, 30);
        lblTicketId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTicketId.setForeground(Color.WHITE);
        lblTicketId.setBackground(new Color(190,180,250));
        label.add(lblTicketId);

        JLabel empName = new JLabel("Name  \t            :");
        empName.setBounds(100, 300, 200, 30 );
        empName.setForeground(Color.WHITE);
        empName.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(empName);


        tfEmpName = new JTextField();
        tfEmpName.setBounds(270, 300, 270, 30);
        tfEmpName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfEmpName.setForeground(Color.BLACK);
        tfEmpName.setBackground(new Color(190,180,250));
        label.add(tfEmpName);

        JLabel lblEmail = new JLabel("Email ID  \t       :");
        lblEmail.setBounds(100, 350, 200, 30 );
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblEmail);

        tfEmpEmail = new JTextField();
        tfEmpEmail.setBounds(270, 350, 270, 30);
        tfEmpEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfEmpEmail.setForeground(Color.BLACK);
        tfEmpEmail.setBackground(new Color(190,180,250));
        label.add(tfEmpEmail);

        JLabel lblDate = new JLabel("Date \t               :");
        lblDate.setBounds(100, 450, 200, 30 );
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblDate);

       Date date1 = new Date();

        date = new JLabel("" +date1);
        date.setBounds(270, 450, 270, 30);
        date.setFont(new Font("Tahoma", Font.PLAIN, 18));
        date.setForeground(Color.WHITE);
        date.setBackground(new Color(190,180,250));
        label.add(date);

        JLabel lblPhone = new JLabel("Phone  \t           :");
        lblPhone.setBounds(100, 500, 200, 30 );
        lblPhone.setForeground(Color.WHITE);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(270, 500, 270, 30);
        tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfPhone.setForeground(Color.BLACK);
        tfPhone.setBackground(new Color(190,180,250));
        label.add(tfPhone);

        JLabel lblProblem = new JLabel("Problems  \t      :");
        lblProblem.setBounds(100, 550, 200, 30 );
        lblProblem.setForeground(Color.WHITE);
        lblProblem.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.add(lblProblem);

        tfProblem = new JTextField();
        tfProblem.setBounds(270, 550, 270, 30);
        tfProblem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfProblem.setForeground(Color.BLACK);
        tfProblem.setBackground(new Color(190,180,250));
        label.add(tfProblem);

        submit = new JButton("Submit");
        submit.setBounds(200, 650, 150, 30 );
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.DARK_GRAY);
        submit.setFont(new Font("Tahoma", Font.BOLD, 17));
        submit.addActionListener(this);
        label.add(submit);

        back = new JButton("Back");
        back.setBounds(390, 650, 150, 30);
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

    private void validateID() {
        String idText = tfEmpId.getText().trim(); // Get text and remove leading/trailing spaces

        // Basic validation: Check if it's empty or not a valid number
        if (idText.isEmpty()) {
           JOptionPane.showMessageDialog(null, "ID cannot be empty");
        } else {
            try {
                int id = Integer.parseInt(idText);
                // Add more specific ID validation rules here (e.g., length, range)
                if (id <= 0) { // Example: ID must be positive
                    JOptionPane.showMessageDialog(null,"ID must be a positive number.");
                } else {
                    //JOptionPane.showMessageDialog(null,"ID is valid!"); // Clear error message on success
                    // Proceed with using the valid ID
                    //System.out.println("Valid ID: " + id);

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Invalid ID: Please enter a number.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            validateID();

            String empId = tfEmpId.getText();
            String ticketId = lblTicketId.getText();
            String name = tfEmpName.getText();
            String email = tfEmpEmail.getText();
            String dateText = date.getText();
            String phone = tfPhone.getText();
            String problem = tfProblem.getText();

            try {
                Conn c = new Conn();
                String q = "insert into employee values('"+empId+"','"+ticketId+"','" + name + "', '" + email + "','" + dateText + "', '" + phone + "','" + problem + "','" + "Pending" + "','" + "Pending" + "','" + "Pending" + "','"+" "+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Data added successfully");

                try {
                    Conn conn = new Conn();
                    String q1 = "select * from employee where Ticket_no = '"+ ticketId +"'";
                    ResultSet resultSet = c.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }

            } catch (Exception E) {
                E.printStackTrace();
            }



        }else {
            setVisible(false);
            new Home();

        }

    }


    public static void main(String[] args) {
        new Create_Ticket();
    }


}
