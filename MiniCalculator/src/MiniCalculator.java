import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniCalculator extends JFrame implements ActionListener {

    private JTextField num1;
    private JTextField num2;
    private JTextField result;
    private JComboBox<String> operatorComboBox;
    private JLabel errorLabel;


    public MiniCalculator() {

        setLayout(new GridLayout(5, 2));


        add(new JLabel("First Number:"));
        num1 = new JTextField(10);
        add(num1);

        add(new JLabel("Second Number:"));
        num2 = new JTextField(10);
        add(num2);

        add(new JLabel("Operator:"));
        String[] operators = {"+", "-", "*", "/"};
        operatorComboBox = new JComboBox<String>(operators);
        add(operatorComboBox);

        add(new JLabel("Result:"));
        result = new JTextField(10);
        result.setEditable(false);
        add(result);

        errorLabel = new JLabel("");
        add(errorLabel);


        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);


        setTitle("Mini Calculator");
        setSize(400, 200);


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        try {

            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());


            String operator = (String) operatorComboBox.getSelectedItem();


            if (operator.equals("+")) {
                result.setText(Double.toString(n1 + n2));
            } else if (operator.equals("-")) {
                result.setText(Double.toString(n1 - n2));
            } else if (operator.equals("*")) {
                result.setText(Double.toString(n1 * n2));
            } else if (operator.equals("/")) {
                if (n2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result.setText(Double.toString(n1 / n2));
            }
            errorLabel.setText("");
        } catch (NumberFormatException ex) {

            result.setText("");
            errorLabel.setText("Invalid number format");
        } catch (ArithmeticException ex) {

            result.setText("");
            errorLabel.setText("Cannot divide by zero");
        }
    }

    public static void main(String[] args) {

        MiniCalculator calculator = new MiniCalculator();
    }
}
