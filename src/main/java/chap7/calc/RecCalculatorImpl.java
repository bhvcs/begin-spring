package chap7.calc;

import chap7.calc.Calculator;

public class RecCalculatorImpl implements Calculator {
    @Override
    public long factorial(long num) {
        if (num == 0) {
            return 1;
        } else return num * factorial(num - 1);
    }
}
