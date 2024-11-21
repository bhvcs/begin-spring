package chap7;

import chap7.calc.CalculatorImpl;
import chap7.calc.RecCalculatorImpl;

public class Main {
    public static void main(String[] args) {
        ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new CalculatorImpl());
        System.out.println(ttCal1.factorial(20));

        ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculatorImpl());
        System.out.println(ttCal2.factorial(20));
    }
}
