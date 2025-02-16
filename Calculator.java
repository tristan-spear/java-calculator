// First change comment in repo

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JPanel panel;
    JButton[] numberButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];

    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton decButton;
    JButton equButton;
    JButton delButton;
    JButton clrButton;
    JButton negButton;

    Font myFont = new Font("Ink Free", Font.BOLD,30);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    /**
     * 
     */
    Calculator()
    {
        //Declaring the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        //Calulator screen
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.add(textfield);
        
        //Declaring buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("Del");
        equButton = new JButton("=");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        //Adding buttons to array
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = delButton;
        funcButtons[6] = equButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;

        for(int i = 0; i < 9; ++i)
        {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; ++i)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        //clr, del, neg buttons
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
  
        //Declaring panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        // OPTIONAL: Color
        // panel.setBackground(Color.BLUE);
        // frame.getContentPane().setBackground(Color.BLUE);

        frame.add(panel);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(divButton);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        for(int i = 0; i < 10; ++i)
        {
            // Number buttons
            if(e.getSource() == numberButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // Decimal button
        if(e.getSource() == decButton)
        {
            textfield.setText(textfield.getText().concat("."));
        }

        // Add button
        if(e.getSource() == addButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        // Subtract button
        if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        // Multiply button
        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = 'X';
            textfield.setText("");
        }

        // Divide button
        if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        // Equals button
        if(e.getSource() == equButton)
        {
            num2 = Double.parseDouble(textfield.getText());

            switch(operator)
            {
                case '+':
                    result = num1 + num2;
                    break;
                
                case '-':
                    result = num1 - num2;
                    break;
                
                case 'X':
                    result = num1 * num2;
                    break;
                
                case '/':
                    result = num1 / num2;
                    break;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        // Clear button
        if(e.getSource() == clrButton)
        {
            textfield.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }

        // Delete button
        if(e.getSource() == delButton)
        {
            String currDisplay = textfield.getText();
            textfield.setText("");

            for(int i = 0; i < currDisplay.length() - 1; ++i)
            {
                textfield.setText(textfield.getText() + currDisplay.charAt(i));
            }
        }

         // Negative button
         if(e.getSource() == negButton)
         {
             double temp = Double.parseDouble(textfield.getText());
             temp *= -1;
             textfield.setText(String.valueOf(temp));
         }
    }
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();

    }
}
