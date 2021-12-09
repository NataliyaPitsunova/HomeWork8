import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Calculate {
    public static void main(String[] args) {
        new MyCalc();
    }

    static class MyCalc {
        JFrame window = new JFrame("Калькулятор");
        private JTextField screen = new JTextField();
        private BigDecimal result;
        private String lastAction;
        private boolean start;

        public MyCalc(){
            //задаем окно
            window.setBounds(300,300,345,345);
            Font font= new Font("Time New Romans",Font.BOLD,16);
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            window.setLayout(null);

            //дисплей
            screen.setBounds(20,5,295,45);
            screen.setFont(font);
            window.add(screen);

//кнопки
            String [] signs = {"1","2","3","+","4","5","6","-","7","8", "9","/","0","C",".","*"};
            ActionListener numeric = new InsAction();
            ActionListener action = new CommandAction();
            ActionListener dell;
            dell = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tmp = screen.getText();
                    if (tmp.length()>0) {
                        screen.setText(tmp.substring(0,tmp.length()-1));}
                }
            };
            ActionListener listener;
            result = BigDecimal.ZERO;
            lastAction = "=";
            start = true;
            int index=0;
            do {
                for (int y = 60; y <= 240; y += 60) {
                    for (int x = 0; x < 4; x++) {
                        if (signs[index].equals("+")||signs[index].equals("-")||signs[index].equals("*")||signs[index].equals("/")){
                            listener=action;
                        } else {
                            if (!(signs[index].equals("C"))){
                                listener=numeric;}
                            else {listener=dell;}}
                        addButton(signs[index], listener,x ,y);
                        index++;
                    }
                }
            } while (index < 16) ;
            JButton eqv = new JButton("=");
            eqv.addActionListener(action);
            eqv.setFont(font);
            eqv.setBounds(260, 60, 55, 235);
            window.add(eqv);


            window.setVisible(true);


        }
        //метод добавления кнопок
        private void addButton(String signs, ActionListener listener,int x, int y) {
            Font font= new Font("Time New Romans",Font.BOLD,16);
            JButton button = new JButton(signs);
            button.setVisible(true);
            button.setFont(font);
            button.addActionListener(listener);
            button.setBounds(20 + x * 60, y, 55, 55);
            window.add(button);
        }

        //слушалка для цифр
        private class InsAction implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                String input = event.getActionCommand();
                if (start) {
                    screen.setText("");
                    start = false;
                }
                String tmp = screen.getText();
                screen.setText(tmp + input);
            }
        }
        //слушалка дл действий
        private class CommandAction implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                String action = event.getActionCommand();
                String tmp = screen.getText();
                if (start) {
                    if (action.equals("-")) {
                        screen.setText(action);
                        start = false;
                    } else lastAction = action;
                } else {
                    calculations(new BigDecimal(screen.getText()));
                    lastAction = action;
                    start = true;
                }

            }
        }
        public void calculations(BigDecimal x) {
            if (lastAction.equals("+")) result = result.add(x);
            else if (lastAction.equals("-")) result = result.subtract(x);
            else if (lastAction.equals("*")) result = result.multiply(x);
            else if (lastAction.equals("/")) result = result.divide(x);
            else if (lastAction.equals("=")) result = x;
            if (result.compareTo(BigDecimal.ZERO) == 0) {
                result = BigDecimal.ZERO;
            }
            screen.setText(result.toString());
        }
    }
}
