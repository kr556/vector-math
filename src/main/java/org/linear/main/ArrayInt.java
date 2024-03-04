package org.linear.main;

public non-sealed interface ArrayInt extends Array<Integer> {
    int[] toNewArray();
    int[] toArray(int[] pointer);
    int[] copy(int destPos, int[] pointer);
}
