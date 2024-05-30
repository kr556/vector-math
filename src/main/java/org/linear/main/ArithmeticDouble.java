package org.linear.main;

public interface ArithmeticDouble<V extends Linear<Double, V> & ArithmeticDouble<V>> extends Arithmetic<Double, V> {
    V add(double value);
    V add(double value, V pointer);
    V sub(double value);
    V sub(double value, V pointer);
}
