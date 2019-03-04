package ru.academy.springdemo2;

@MyAnnotation("Lorem ipsum dolor sit amet")
public class MyClass {

  public static void main(String... __) {
    MyAnnotation annotation = MyClass.class.getAnnotation(MyAnnotation.class);

    System.out.println(annotation.value()); // "Lorem ipsum dolor sit amet"
  }
}
