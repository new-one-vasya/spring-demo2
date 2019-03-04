package ru.academy.springdemo2;

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.academy.springdemo2.dao.CatRepository;
import ru.academy.springdemo2.model.Cat;

import javax.xml.catalog.CatalogResolver;

import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FieldDefaults(level = PRIVATE)
@WithMockUser(authorities = "ADMIN")
public class SpringDemo2ApplicationTests {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  CatRepository catRepository;

  private static final MediaType HAL_JSON =
      MediaType.parseMediaType("application/hal+json;charset=UTF-8");

  @Before
  public void setUp() {
    Stream.of("Мурзик", "Васька", "Барсик")
        .map(Cat::new)
        .forEach(catRepository::save);
  }

  @Test
  @SneakyThrows
  public void contextLoads() {
    mockMvc.perform(MockMvcRequestBuilders.get("/cats"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(HAL_JSON))
        .andExpect(mvcResult -> assertEquals("3",
            mvcResult.getResponse().getContentAsString()
                .split("totalElements")[1]
                .split(":")[1].trim()
                .split(",")[0]));
  }

}
