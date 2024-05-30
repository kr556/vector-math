package org.linear.main;

public interface ArithmeticGeneric<E extends Number, V extends ArithmeticGeneric<E, V>> extends Arithmetic<E, V> {
    V add(E value);
    V add(E value, V pointer);
    V sub(E value);
    V sub(E value, V pointer);
    V mul(double value);
    V mul(double value, V pointer);
    V mul(E value);
    V mul(E value, V pointer);
    V div(double value);
    V div(double value, V pointer);
    V div(E value);
    V div(E value, V pointer);
}
