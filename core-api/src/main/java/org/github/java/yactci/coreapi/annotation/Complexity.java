package org.github.java.yactci.coreapi.annotation;

import static org.github.java.yactci.coreapi.annotation.BigO.BIG_O_C;

/**
 * Complexity annotation can be used for indicating the time and space complexity of a method. It is
 * not effective at the moment, just for better documentation.
 *
 * @author Said Ucar
 */
public @interface Complexity {

  BigO time() default BIG_O_C;

  BigO space() default BIG_O_C;
}
