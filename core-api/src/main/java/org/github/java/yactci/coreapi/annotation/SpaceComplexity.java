package org.github.java.yactci.coreapi.annotation;

import static org.github.java.yactci.coreapi.annotation.BigO.BIG_O_C;

/**
 * Space Complexity annotation can be used for indicating the space complexity of a method. It is
 * not effective at the moment, just for better documentation.
 *
 * @author Said Ucar
 */
public @interface SpaceComplexity {

  BigO best() default BIG_O_C;

  BigO worst() default BIG_O_C;

  BigO average() default BIG_O_C;
}
