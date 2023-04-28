package ro.tuc.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
 private JTextField clientstextField;
private JLabel  clientsLabel;
private JLabel queuesLabel;
private JTextField  queuestextField;
private JTextField simulationtextField;

private JTextField  arrivaltextField;

private JTextField  servicetextField;
private JTextField  arrivaltextField2;
    private JLabel maximumLabel;
    private  JLabel arrivalLabel;
    private JLabel serviceLabel;
    private  JLabel serviceLabel2;
    private JLabel arrivalLabel2;
    private   JButton btn;
private  JTextField servicetextField2;
private  JLabel frontLabel;
    public View()
    {
        this.setResizable(false);

        setBounds(100, 100, 931, 725);
        this.getContentPane().setBackground(new Color(255, 204, 102));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.getContentPane().setLayout(null);

        clientstextField = new JTextField();
        clientstextField.setFont(new Font("Arial", Font.PLAIN, 16));
        clientstextField.setBounds(52, 140, 247, 30);
        this.getContentPane().add(clientstextField);
        clientstextField.setColumns(10);

        clientsLabel = new JLabel("Nr of clients:");
        clientsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        clientsLabel.setBounds(65, 89, 105, 22);
        this.getContentPane().add(clientsLabel);

         queuesLabel = new JLabel("Nr of queues:");
        queuesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        queuesLabel.setBounds(65, 205, 105, 22);
        this.getContentPane().add(queuesLabel);

        queuestextField = new JTextField();
        queuestextField.setFont(new Font("Arial", Font.PLAIN, 16));
        queuestextField.setColumns(10);
        queuestextField.setBounds(52, 254, 247, 30);
        this.getContentPane().add(queuestextField);

        maximumLabel = new JLabel("Maximum simulation time:");
        maximumLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        maximumLabel.setBounds(63, 321, 247, 22);
        this.getContentPane().add(maximumLabel);

        simulationtextField = new JTextField();
        simulationtextField.setFont(new Font("Arial", Font.PLAIN, 16));
        simulationtextField.setColumns(10);
        simulationtextField.setBounds(52, 367, 247, 30);
        this.getContentPane().add(simulationtextField);

         arrivalLabel = new JLabel("Minimum arrival time:");
        arrivalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        arrivalLabel.setBounds(459, 89, 157, 22);
        this.getContentPane().add(arrivalLabel);

        arrivaltextField = new JTextField();
        arrivaltextField.setFont(new Font("Arial", Font.PLAIN, 16));
        arrivaltextField.setColumns(10);
        arrivaltextField.setBounds(469, 140, 105, 30);
       this.getContentPane().add(arrivaltextField);

       serviceLabel = new JLabel("Minimum service time:");
        serviceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        serviceLabel.setBounds(472, 225, 157, 22);
        this.getContentPane().add(serviceLabel);


         btn = new JButton("Start the simulation");
        btn.setBackground(new Color(255, 255, 153));
        btn.setFont(new Font("Arial", Font.PLAIN, 16));
        btn.setBounds(524, 496, 247, 50);
        this.getContentPane().add(btn);

        arrivalLabel2 = new JLabel("Maximum arrival time:");
        arrivalLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
        arrivalLabel2.setBounds(652, 89, 157, 22);
        this.getContentPane().add(arrivalLabel2);

        arrivaltextField2 = new JTextField();
        arrivaltextField2.setFont(new Font("Arial", Font.PLAIN, 16));
        arrivaltextField2.setColumns(10);
        arrivaltextField2.setBounds(674, 140, 105, 30);
        this.getContentPane().add(arrivaltextField2);

         serviceLabel2 = new JLabel("Maximum service time:");
        serviceLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
        serviceLabel2.setBounds(674, 225, 170, 22);
        this.getContentPane().add(serviceLabel2);

        servicetextField = new JTextField();
        servicetextField.setFont(new Font("Arial", Font.PLAIN, 16));
        servicetextField.setColumns(10);
        servicetextField.setBounds(483, 284, 105, 30);
        this.getContentPane().add(servicetextField);

        servicetextField2 = new JTextField();
        servicetextField2.setFont(new Font("Arial", Font.PLAIN, 16));
        servicetextField2.setColumns(10);
        servicetextField2.setBounds(695, 284, 105, 30);
        this.getContentPane().add(servicetextField2);


        frontLabel = new JLabel("Queues management application");
        frontLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        frontLabel.setBounds(243, 30, 444, 30);
        this.getContentPane().add(frontLabel);
        this.setVisible(true);
    }
    public String getclientstextField() {
        return clientstextField.getText();
    }
    public void setclientstextField(String clientstextField) {
        this.clientstextField.setText(clientstextField);
    }
    public String getqueuestextField() {
        return queuestextField.getText();
    }
    public void setqueuestextField(String queuestextField) {
        this.queuestextField.setText(queuestextField);
    }

    public String getarrivaltextField() {
        return arrivaltextField.getText();
    }

    public void setarrivaltextField(String arrivaltextField) {
        this.arrivaltextField.setText(arrivaltextField);
    }
    public String getsimulationtextField() {
        return simulationtextField.getText();
    }

    public void setsimulationtextField(String simulationtextField) {
        this.simulationtextField.setText(simulationtextField);
    }
    public String getservicetextField() {
        return servicetextField.getText();
    }

    public void setservicetextField(String servicetextField) {
        this.servicetextField.setText(servicetextField);
    }
    public String getservicetextField2() {
        return servicetextField2.getText();
    }

    public void setservicetextField2(String servicetextField2) {
        this.servicetextField2.setText(servicetextField2);
    }
    public String getarrivaltextField2() {
        return arrivaltextField2.getText();
    }

    public void setarrivaltextField2(String arrivaltextField2) {
        this.arrivaltextField2.setText(arrivaltextField2);
    }
    public void addCreateListener(ActionListener action)
    {
        btn.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
