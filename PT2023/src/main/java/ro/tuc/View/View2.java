package ro.tuc.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View2 extends JFrame {
    private  JButton btn;
    private JScrollPane logScrollPane;
    private  JTextArea peaktextArea;
    private  JLabel timerLabel;
    private JTextArea timertextArea;
    private JTextArea logtextArea;
    private JLabel averageLabel;
    private  JTextArea averagetextArea;
    private JLabel averageLabel2;
    private  JTextArea averagetextArea2;
    private JLabel peakLabel;

    public View2()
    {
        this.setResizable(false);

        setBounds(100, 100, 931, 725);
        this.getContentPane().setBackground(new Color(255, 204, 102));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

         timerLabel = new JLabel("Timer");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        timerLabel.setBounds(693, 532, 105, 46);
      this.getContentPane().add(timerLabel);

         timertextArea = new JTextArea();
        timertextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        timertextArea.setBounds(669, 600, 216, 63);
        this.getContentPane().add(timertextArea);

        logtextArea = new JTextArea();
        logtextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        logtextArea.setBounds(55, 36, 510, 609);
        this.getContentPane().add(logtextArea);


        logScrollPane = new JScrollPane();
        logScrollPane.setBounds(55, 36, 510, 609);
        logScrollPane.setViewportView(logtextArea);
        this.getContentPane().add(logScrollPane);

        averageLabel = new JLabel("Average waiting time");
        averageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        averageLabel.setBounds(628, 47, 222, 33);
        this.getContentPane().add(averageLabel);

         averagetextArea = new JTextArea();
        averagetextArea.setFont(new Font("Arial", Font.PLAIN, 10));
        averagetextArea.setBounds(638, 90, 175, 22);
        this.getContentPane().add(averagetextArea);

        averageLabel2 = new JLabel("Average service time");
        averageLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        averageLabel2.setBounds(628, 145, 222, 33);
        this.getContentPane().add(averageLabel2);

       averagetextArea2 = new JTextArea();
        averagetextArea2.setFont(new Font("Arial", Font.PLAIN, 10));
        averagetextArea2.setBounds(638, 199, 175, 22);
        this.getContentPane().add(averagetextArea2);

        peakLabel = new JLabel("Peak hour");
        peakLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        peakLabel.setBounds(628, 253, 222, 33);
        this.getContentPane().add(peakLabel);

         peaktextArea = new JTextArea();
        peaktextArea.setFont(new Font("Arial", Font.PLAIN, 10));
        peaktextArea.setBounds(638, 311, 175, 22);
        this.getContentPane().add(peaktextArea);

         btn = new JButton("START");
        btn.setBackground(new Color(255, 218, 185));
        btn.setFont(new Font("Arial", Font.PLAIN, 30));
        btn.setBounds(628, 405, 210, 46);
        this.getContentPane().add(btn);
        this.setVisible(true);
    }
    public String getlogtextArea() {
        return logtextArea.getText();
    }

    public void setlogtextArea(String logtextArea2) {
        logtextArea.append(logtextArea2+ "\n");
    }
    public String getpeaktextArea() {
        return peaktextArea.getText();
    }

    public void setpeaktextArea(String peaktextArea) {
        this.peaktextArea.setText(peaktextArea);
    }
    public String getaveragetextArea2() {
        return averagetextArea2.getText();
    }

    public void setaveragetextArea2(String averagetextArea2) {
        this.averagetextArea2.setText(averagetextArea2);
    }

    public String getaveragetextArea() {
        return averagetextArea.getText();
    }

    public void setaveragetextArea(String averagetextArea) {
        this.averagetextArea.setText(averagetextArea);
    }
    public String gettimertextArea() {
        return  timertextArea.getText();
    }

    public void settimertextArea(String  timertextArea) {
        this.timertextArea.setText( timertextArea);
    }
    public void addCreateListener(ActionListener action)
    {
        btn.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
