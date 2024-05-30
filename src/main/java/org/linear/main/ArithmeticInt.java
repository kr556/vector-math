package org.linear.main;

public interface ArithmeticInt<V extends Linear<Integer, V> & ArithmeticInt<V>> extends Arithmetic<Integer, V> {
    V add(int value);
    V add(int value, V pointer);
    V sub(int value);
    V sub(int value, V pointer);
}
