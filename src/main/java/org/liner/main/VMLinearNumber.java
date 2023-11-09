package org.liner.main;

import org.jetbrains.annotations.NotNull;

import java.nio.Buffer;

public interface VMLinearNumber<E extends Number, V extends VMLinearNumber<E, V>> {
   E get(int index);

   Buffer get(Buffer pointer);

   E[] get(E[] pointer);

   E[] toArray();

   void set(int index, @NotNull E value);

   boolean isScalar();

   boolean equals(@NotNull V value);
}
