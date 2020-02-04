package org.github.java.yactci.coreapi.annotation;

import static org.github.java.yactci.coreapi.annotation.BigO.CONSTANT;

/**
 * Space Complexity annotation can be used for indicating the space complexity of a method. It is
 * not effective at the moment, just for better documentation.
 *
 * @author Said Ucar
 */
public @interface SpaceComplexity {

  BigO best() default CONSTANT;

  BigO worst() default CONSTANT;

  BigO average() default CONSTANT;
}
