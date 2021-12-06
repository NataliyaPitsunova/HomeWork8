
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MyCalc extends JFrame {


        public MyCalc() {
            setBounds(300,300,500,500);
            setTitle("Калькулятор");
            Font font= new Font("Time New Romans",Font.BOLD,16);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(null);

            JTextField field = new JTextField();
            field.setBounds(20,20,455,32);
            add(field);
            JButton [] button1_3 = new JButton [3];
            Font fontbutton= new Font("Time New Romans",Font.BOLD,12);
            for (int i=0;i< button1_3.length;i++) {
                button1_3[i]=new JButton(Integer.toString(i+1));
                button1_3[i].setBounds(20+i*60, 60, 50, 40);
                add(button1_3[i]);
            }
            JButton [] button4_6 = new JButton [3];
            for (int i=0;i< button4_6.length;i++) {
                button4_6[i]=new JButton(Integer.toString(i+4));
                button4_6[i].setBounds(20+i*60, 120, 50, 40);

                add(button4_6[i]);
            }
            JButton [] button7_9 = new JButton [3];
            for (int i=0;i< button7_9.length;i++) {
                button7_9[i]=new JButton(Integer.toString(i+7));
                button7_9[i].setBounds(20+i*60, 180, 50, 40);

                add(button7_9[i]);
            }

            JButton button0 =new JButton(Integer.toString(0));
            button0.setBounds(20, 240, 80, 40);

            add(button0);

            JButton btnBack =new JButton("Del");
            btnBack.setBounds(110, 240, 80, 40);
            button0.addActionListener((ActionListener) this);
            add(btnBack);

            JButton [] buttonOperation = new JButton [4];
            String [] signs = new String[4];
            signs[0]="+";
            signs[1]="-";
            signs[2]="/";
            signs[3]="*";
            for (int i=0;i< buttonOperation.length;i++) {
                buttonOperation[i]=new JButton(signs[i]);
                buttonOperation[i].addActionListener((ActionListener) this);
                buttonOperation[i].setBounds(200, 60+i*60, 50, 40);
                add(buttonOperation[i]);
            }
            JButton btnRes =new JButton("=");
            btnRes.setBounds(260, 60, 50, 220);
            btnRes.addActionListener((ActionListener) this);
            add(btnRes);



            setVisible(true);
        }

        public static void main(String[] args) {
            new MyCalc();
        }



}
