package ru.academy.springdemo2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Cat {

  @Id
  @GeneratedValue
  Long id;

  @NonNull
  String name;

}
