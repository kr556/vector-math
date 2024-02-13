package org.linear.main;

// TODO: 2023/11/23 mul, divの引数をdoubleに
public interface ArithmeticDouble<V extends Linear<Double, V> & ArithmeticDouble<V>> extends Arithmetic<Double, V> {
    V add(double value);
    V add(double value, V pointer);
    V sub(double value);
    V sub(double value, V pointer);
}
