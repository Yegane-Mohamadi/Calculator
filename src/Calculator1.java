import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator1 implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10] ;
    JButton[] functions = new JButton[8];
    JButton jam , tafrigh , zarb , taghsim ;
    JButton dot , tasavi , delete , clr;
    JPanel panel;
    Font font = new Font("San Serif" , Font.TRUETYPE_FONT , 30);
    double num1 = 0 , num2 =0 , result = 0;
    char operator;
    Calculator1(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410 , 530);
        frame.setLayout(null);


        textField = new JTextField();
        textField.setBounds(50 , 30 , 300 , 50);
        textField.setFont(font);
        textField.setEditable(false);


        jam = new JButton("+");
        tafrigh = new JButton("-");
        zarb = new JButton("*");
        taghsim = new JButton("/");
        dot = new JButton(".");
        tasavi = new JButton("=");
        delete = new JButton("delete");
        clr = new JButton("clear");
        functions[0] = jam;
        functions[1] = tafrigh;
        functions[2] = zarb ;
        functions[3] = taghsim;
        functions[4] = dot;
        functions[5] = tasavi;
        functions[6] = delete;
        functions[7] = clr;
        for (int i=0 ; i<8 ; i++){
            functions[i].addActionListener(this);
            functions[i].setFont(font);
            functions[i].setFocusable(false);
        }
        for (int i=0 ; i<10 ; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }
        delete.setBounds(50 , 400 , 150 , 50);
        clr.setBounds(200 , 400 , 150 , 50);

        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(50 , 100 , 300 , 300);
        panel.setLayout(new GridLayout(4 , 4 ,5, 5));
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(jam);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(tafrigh);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(zarb);
        panel.add(dot);
        panel.add(numbers[0]);
        panel.add(tasavi);
        panel.add(taghsim);
        frame.add(panel);
        frame.add(delete);
        frame.add(clr);
        frame.add(textField);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
     Calculator1 cal = new Calculator1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0 ; i<10 ; i++){
            if (e.getSource() == numbers[i])
                textField.setText(textField.getText().concat(String.valueOf(i)));

        }
        if (e.getSource() == dot)
            textField.setText(textField.getText().concat("."));

        if (e.getSource() == jam){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == tafrigh){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == zarb){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == taghsim){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == tasavi){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2 ;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
            if (e.getSource() == clr){
                textField.setText("");
            }
            if (e.getSource() == delete){
                String string = textField.getText();
                textField.setText("");
                for (int i=0 ; i<string.length()-1 ; i++){
                    textField.setText(textField.getText() + string.charAt(i));
                }
            }
        }
    }
}
