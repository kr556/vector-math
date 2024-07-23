package org.linear.main;

import org.liner.annotation.Final;

public non-sealed interface ArrayDouble extends Array<Double> {
    double[] toNewArray();
    double[] toArray(double[] pointer);
    double[] copy(int destPos, double[] pointer);
}
