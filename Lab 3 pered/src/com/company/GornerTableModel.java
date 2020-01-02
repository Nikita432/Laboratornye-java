package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.Random;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
// В данной модели три столбца
        return 3;
    }
    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;
        double result = x*2;

        if (col==0) {
// Если запрашивается значение 1-го столбца, то это X
            return x;
        }

        if (col==1) {
// Если запрашивается значение 2-го столбца, то это значение
// многочлена
// Вычисление значения в точке по схеме Горнера.
// Вспомнить 1-ый курс и реализовать
// ...

            return result;
        }
        if (col==2){
            int res = (int)result; //целая часть
            double result2 = result - res; //дробная часть

            if(res % 2 == 0) {
                return "Число " + res + " четное";
            } else {
                return "Число " + res + " нечетное";
            }
        }




        else {
            int res = (int)result; //целая часть
            double result2 = result - res; //дробная часть

            if (result2==0) {

                return true;
            }
            else {
                return false;
            }
        }
    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:
// Название 1-го столбца
                return "Значение X";
            // Название 2-го столбца
            case 1:
                return "Значение многочлена";
            case 2:
                return "Целая часть четная?";
            default:
// Название 3-го столбца
                return "Дробная часть равна 0?";

        }
    }
    public Class<?> getColumnClass(int col) {
        if (col == 0) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
            return Double.class;

        }
        if (col == 1) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
            return Double.class;
        }
        if (col == 2){
            return String.class;
        }
        else{

            return Boolean.class;
        }
    }
}