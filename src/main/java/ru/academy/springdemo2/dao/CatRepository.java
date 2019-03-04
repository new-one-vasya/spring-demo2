package ru.academy.springdemo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.academy.springdemo2.model.Cat;

import static lombok.AccessLevel.PRIVATE;

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, Long> {
}
