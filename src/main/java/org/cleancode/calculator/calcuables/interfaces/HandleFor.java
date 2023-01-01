package org.cleancode.calculator.calcuables.interfaces;

import org.cleancode.calculator.pattern.CalculablePattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HandleFor {
    CalculablePattern target() default CalculablePattern.NONE;
}
