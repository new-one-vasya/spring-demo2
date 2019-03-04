package ru.academy.springdemo2;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface MyAnnotation {

  String value();
}
