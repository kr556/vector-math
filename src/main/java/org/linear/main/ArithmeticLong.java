package org.linear.main;

public interface ArithmeticLong<V extends Linear<Long, V> & ArithmeticLong<V>> extends Arithmetic<Long, V> {
    V add(long value);
    V add(long value, V pointer);
    V sub(long value);
    V sub(long value, V pointer);
    V mul(double value);
    V mul(double value, V pointer);
    V div(double value);
    V div(double value, V pointer);
}
