package org.linear.main.value;

@FunctionalInterface
public non-sealed interface IntValue extends FunctionValue {
    int val();

    @Override
    default Number toNumber() {
        return val();
    }
}
