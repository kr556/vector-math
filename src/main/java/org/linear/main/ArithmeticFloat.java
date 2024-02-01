package org.linear.main;

public interface ArithmeticFloat<V extends Linear<Float, V>> extends Arithmetic<Float, V> {
    V add(float value);
    V add(float value, V pointer);
    V sub(float value);
    V sub(float value, V pointer);
}
