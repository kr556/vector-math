package org.liner.main;

public interface ArithmeticFloat<V extends VMLinearNumber<Float, V>> extends Arithmetic<V> {
    V add(float value);
    V add(float value, V pointer);
    V sub(float value);
    V sub(float value, V pointer);
    V mul(float value);
    V mul(float value, V pointer);
    V div(float value);
    V div(float value, V pointer);
}
