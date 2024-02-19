package org.linear.main.value;

@FunctionalInterface
public non-sealed interface FloatValue extends FunctionValue {
    float val();

    @Override
    default Number toNumber() {
        return val();
    }
}
