// Импортируются классы, используемые в приложении
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
/*import static java.lang.Math.sin;
import static java.lang.Math.log;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.pow;*/
import static java.lang.Math.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.text.DecimalFormat;
/*import static java.lang.Math.sin;
import static java.lang.Math.log;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.pow;*/
import static java.lang.Math.*;
//public class Window extends JFrame


// Главный класс приложения, он же класс фрейма
public class Window extends JFrame{
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;

    // Текстовое поле для отображения результата,
// как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    private JTextField textFieldSum;

    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();

    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    // Формула №1 для рассчѐта
    private int formulaId = 1;
    private Double sumZanovo = 0.0;
    private Double sum = 0.0;
    public Double calculate1(Double x, Double y, Double z)
    {
        return x;
        //return (sin(y*y*acos(-1)) + log(y*y))/(sin(z*z*acos(-1)) + sin(x) + log(z*z) + x*x + exp(cos(z*x)));
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z)
    {
        return y;
        //return exp(1^0.5*x/ sqrt(z+y)*log10(x^z));
       //return (y*((x*x)/((log10(pow(z, y)))+(pow((cos(pow(x, (1/3)))),2)))));


       // return exp(pow(0.5, y))
    }

    public Double calculate3(Double x, Double y, Double z)
    {
        return z;
        //return exp(1^0.5*x/ sqrt(z+y)*log10(x^z));
        //return (y*((x*x)/((log10(pow(z, y)))+(pow((cos(pow(x, (1/3)))),2)))));


        // return exp(pow(0.5, y))
    }

    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId)
    {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener()
                                 {
                                     public void actionPerformed(ActionEvent ev)
                                     {
                                         Window.this.formulaId = formulaId;
                                     }
                                 }
        );
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }


    // Конструктор класса
    public Window()
    {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2, (kit.getScreenSize().height - HEIGHT)/2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        addRadioButton("Формула 3", 3);
        radioButtons.setSelected( radioButtons.getElements().nextElement().getModel(), true);


        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder( BorderFactory.createLineBorder(Color.YELLOW));
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);


        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");


        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);

        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder( BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());
        JLabel labelForResult = new JLabel("Результат:");
        JLabel labelForMemory = new JLabel("Накопление:");
        textFieldResult = new JTextField("0", 15);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        textFieldSum = new JTextField("0", 15);
        textFieldSum.setMaximumSize(textFieldSum.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(labelForMemory);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldSum);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener()

                                     {
                                         public void actionPerformed(ActionEvent ev)
                                     { try
                                     {
                                         Double x = Double.parseDouble(textFieldX.getText());
                                         Double y = Double.parseDouble(textFieldY.getText());
                                         Double z = Double.parseDouble(textFieldZ.getText());
                                         Double result;
                                         if (formulaId==1)
                                             result = calculate1(x, y, z);
                                         else
                                             result = calculate3(x, y, z);

                                         if (formulaId==2)
                                             result = calculate2(x, y, z);
                                         else
                                             result = calculate1(x, y, z);

                                         if (formulaId==3)
                                             result = calculate3(x, y, z);
                                         else
                                             result = calculate2(x, y, z);







                                         sum = result;
                                         DecimalFormat dec = new DecimalFormat("#0.0000");
                                         dec.format(sum);
                                         textFieldResult.setText(sum.toString());
                                     }
                                     catch (NumberFormatException ex)
                                     { JOptionPane.showMessageDialog(Window.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE); }
                                     }
                                     }
        );
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
                sum = 0.0;
            }
        });

        JButton MC = new JButton("MC");
        MC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev)
            {
                sumZanovo = 0.0;
                textFieldSum.setText("0");
            }
        });
        JButton Mplus = new JButton("M+");
        Mplus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev)
            {
                sumZanovo += sum;
                textFieldSum.setText(sumZanovo.toString());
            }
        });
        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(MC);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(Mplus);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder( BorderFactory.createLineBorder(Color.GREEN));
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
    public static void main(String[] args)
    {
        Window frame = new Window();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}