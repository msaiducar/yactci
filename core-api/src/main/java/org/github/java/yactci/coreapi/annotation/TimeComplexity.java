package org.github.java.yactci.coreapi.annotation;

import static org.github.java.yactci.coreapi.annotation.BigO.BIG_O_C;

/**
 * Time Complexity annotation can be used for indicating the time complexity of a method. It is not
 * effective at the moment, just for better documentation.
 *
 * @author Said Ucar
 */
public @interface TimeComplexity {

  BigO best() default BIG_O_C;

  BigO worst() default BIG_O_C;

  BigO average() default BIG_O_C;
}
