package org.linear.main;

import org.jetbrains.annotations.NotNull;
import org.liner.annotation.Final;
import org.liner.annotation.PropertiesMethod;

import java.nio.Buffer;

public non-sealed interface Linear<E extends Number, V extends Linear<E, V>>
        extends Array<E>, Cloneable {
   /**
    * Assignment this instance.
    * @param copy right side.
    */
   void set(V copy);

   default Buffer get(Buffer pointer) {
      return get(0, pointer);
   }

   Buffer get(int offset, Buffer pointer);

   @Final
   void set(int index, E value);

   @PropertiesMethod
   boolean isScalar();

   boolean equals(V value);
   
   @Final
   boolean isNaN();

   @PropertiesMethod
   int elementsSize();
}
