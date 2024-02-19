package org.linear.main.value;

/**
 * This is corresponding to values of elements of vector. The interface implemented this are when called a 'val' method will return primitive value.
 * @see FloatValue
 * @see DoubleValue
 * @see IntValue
 * @see LongValue
 */
public sealed interface FunctionValue permits FloatValue, DoubleValue, IntValue, LongValue {
    Number toNumber();
}
