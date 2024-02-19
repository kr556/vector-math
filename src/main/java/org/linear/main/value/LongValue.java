package org.linear.main.value;

@FunctionalInterface
public non-sealed interface LongValue extends FunctionValue {
    long val();

    @Override
    default Number toNumber() {
        return val();
    }
}
