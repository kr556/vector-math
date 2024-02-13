package org.linear.main;

/**
 * This interface is implements basic arithmetic methods.
 * @param <E> Basic element type.
 * @param <V> Type of implemented class.
 */
public interface Arithmetic<E extends Number, V extends Arithmetic<E, V>> extends Cloneable {
    /**
     * Assignment this instance.
     * @param copy right side.
     */
    void set(V copy);

    /**
     * Add elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#add(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V add(V value);

    /**
     * Add elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V add(V value, V pointer);

    /**
     * Add elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#add(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V sub(V value);

    /**
     * Sub elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V sub(V value, V pointer);

    /**
     * Mul elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#mul(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V mul(V value);

    V mul(double value);

    V mul(double value, V pointer);

    V div(double value);

    V div(double value, V pointer);
    
    /**
     * Mul elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V mul(V value, V pointer);

    /**
     * Div elements of an argument to corresponding elements of myself. This method can calculation same size of elements.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#div(V,V)}.
     * @param value Term of right
     * @return anser
     */
    V div(V value);

    /**
     * Div elements of an argument to corresponding elements of myself.
     * Becouse, this method can calculation same size of elements.
     * @param value Term of right
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V div(V value, V pointer);

    /**
     * The all elements to absolute value.
     * If you want to do not rewrite myself, you can do calculation without rewrite myself going by use {@link Arithmetic#abs(V)}.
     * @return anser
     */
    V abs();

    /**
     * The all elements to absolute value.
     * Becouse, this method can calculation same size of elements.
     * @param pointer If you want to not rewrite myself, you can put answer to the pointer.
     * @return anser
     */
    V abs(V pointer);
}
