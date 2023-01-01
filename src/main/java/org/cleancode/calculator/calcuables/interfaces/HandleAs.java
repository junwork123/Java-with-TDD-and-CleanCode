package org.cleancode.calculator.calcuables.interfaces;

import org.cleancode.calculator.pattern.OperablePattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface HandleAs {
    OperablePattern symbol();
    int howMany() default 2;
}
