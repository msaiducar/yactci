package org.github.java.yactci.coreapi.annotation;

import static org.github.java.yactci.coreapi.annotation.BigO.CONSTANT;

/**
 * Time Complexity annotation can be used for indicating the time complexity of a method. It is not
 * effective at the moment, just for better documentation.
 *
 * @author Said Ucar
 */
public @interface TimeComplexity {

  BigO best() default CONSTANT;

  BigO worst() default CONSTANT;

  BigO average() default CONSTANT;
}
