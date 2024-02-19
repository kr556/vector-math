package org.linear.main.value;

@FunctionalInterface
public non-sealed interface DoubleValue extends FunctionValue {
    double val();

    @Override
    default Number toNumber() {
        return val();
    }
}
